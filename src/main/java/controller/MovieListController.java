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

@WebServlet("/movies")
public class MovieListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieDao movieDao;

	public MovieListController() {
		movieDao = new MovieDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = MyUtils.getStoredConnection(request);

		List<Movies> movies = null;
		try {
			movies = MovieDao.listMovies();
			System.out.println("reach Try");
		} catch (ClassNotFoundException e) {
			System.out.println("reach Catch");
			e.printStackTrace();
		}
		request.setAttribute("movies", movies);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/loginsuccess.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
