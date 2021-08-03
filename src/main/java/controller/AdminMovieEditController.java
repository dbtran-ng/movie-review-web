package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MovieDao;
import model.Movies;
import utils.MyUtils;

@WebServlet(urlPatterns = { "/editMovie" })
public class AdminMovieEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminMovieEditController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);

		int movieId = Integer.parseInt(request.getParameter("movieId"));
		Movies movie = null;
		String errorString = null;
		try {
			movie = MovieDao.findMovie(movieId);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		if (errorString != null && movie == null) {
			response.sendRedirect(request.getServletPath() + "/productList");
			return;
		}

		// Store errorString in request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("movie", movie);

		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/view/adminMovieEdit.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String errorString = null;
		int movieId = Integer.parseInt(request.getParameter("movieId"));
		String title = request.getParameter("title");
		String country = request.getParameter("country");
		int year = Integer.parseInt(request.getParameter("year"));
		String description = request.getParameter("description");
		String imagePath = request.getParameter("imagePath");
		String youtubeTrailer = request.getParameter("youtubeTrailer");

		Movies movie = new Movies(movieId,title, country, year, description, imagePath, youtubeTrailer);
		try {
			MovieDao.updateMovie(movie);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		request.setAttribute("movie", movie);
		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/view/adminMovieEdit.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("listMovies");
		}
	}

}