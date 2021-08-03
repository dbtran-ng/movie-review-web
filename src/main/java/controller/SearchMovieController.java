package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MovieDao;
import model.Movies;
import utils.MyUtils;

@WebServlet("/searchMovie")
public class SearchMovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieDao movieDao;

	public SearchMovieController() {
		movieDao = new MovieDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = MyUtils.getStoredConnection(request);
		String errorString = null;
		List<Movies> movies = null;
		String title = request.getParameter("title");
		try {
			movies = MovieDao.findAllMoviesByName(title);
			if ( movies.size() == 0) {
				errorString= "No movies found in our database";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		request.setAttribute("movies", movies);
		request.setAttribute("errorString", errorString);
		if (movies == null) {
			response.sendRedirect(request.getServletPath() + "/movies");
			return;
		}
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/search.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
