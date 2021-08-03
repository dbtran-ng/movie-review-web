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
import utils.DBUtils;
import utils.MyUtils;

@WebServlet(urlPatterns = { "/addMovie" })
public class AdminMovieAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminMovieAddController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher //
				= this.getServletContext().getRequestDispatcher("/WEB-INF/view/adminMovieAdd.jsp");
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);
		String title = request.getParameter("title");
		String country = request.getParameter("country");
		int year = Integer.parseInt(request.getParameter("year"));
		String description = request.getParameter("description");
		String imagePath = request.getParameter("imagePath");
		String youtubeTrailer = request.getParameter("youtubeTrailer");

		Movies newMovie = new Movies(title, country, year, description, imagePath, youtubeTrailer);

		newMovie.setTitle(title);
		newMovie.setCountry(country);
		newMovie.setYear(year);
		newMovie.setDescription(description);
		newMovie.setImagePath(imagePath);
		newMovie.setYoutubeTrailer(youtubeTrailer);
		try {
			MovieDao.createMovie(newMovie);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/listMovies");
	}

}