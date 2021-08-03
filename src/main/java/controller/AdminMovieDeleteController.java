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
import dao.ReviewDao;
import model.Movies;
import model.Review;
import model.UsersLogin;
import utils.MyUtils;

@WebServlet(urlPatterns = { "/deleteMovie" })
public class AdminMovieDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminMovieDeleteController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("movieId"));
		try {
			MovieDao.deleteMovie(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("listMovies");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}