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
import javax.servlet.http.HttpSession;

import dao.LoginDao;
import dao.MovieDao;
import dao.ReviewDao;
import model.Movies;
import model.Review;
import model.UsersLogin;
import utils.MyUtils;

@WebServlet("/movie")
public class MovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MovieController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = MyUtils.getStoredConnection(request);
		Movies movie = null;
		List<Review> reviews = null;

		String action = request.getServletPath();
		try {
			int movieId = Integer.parseInt(request.getParameter("movieId"));
			movie = MovieDao.findMovie(movieId);
			reviews = ReviewDao.listReviewByMovieId(movieId);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		request.setAttribute("movie", movie);
		request.setAttribute("reviews", reviews);
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/view/movie.jsp");
		dispatcher.forward(request, response);
	}

//	private void editReview(HttpServletRequest request, HttpServletResponse response) {
//        HttpSession session = request.getSession();
//		UsersLogin users = MyUtils.getLoginedUser(session);
//		boolean result = false;
//		int movieId = Integer.parseInt(request.getParameter("movieId"));
//		Movies movie = MovieDao.findMovie(movieId);
//		List<Review> reviews = null;
//		reviews = ReviewDao.listReviewByMovieId(movieId);
//		for ( int i = 0 ; i < reviews.size(); i++) {
//		
//			try {
//				if ( reviews.get(i).getAuthorName().equals(users.getUsername())) {
//					result = ReviewDao.deleteReview(movieId,users.getUsername());	
//				}
//			} catch (ClassNotFoundException | SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/movie.jsp");
//		request.setAttribute("todo", existingTodo);
//		dispatcher.forward(request, response);
//		
//	}
//
//	private void deleteReview(HttpServletRequest request, HttpServletResponse response) {
//		int id = Integer.parseInt(request.getParameter("id"));
//		todoDAO.deleteTodo(id);
//		response.sendRedirect("list");
//
//	}

	private void deleteReview(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
