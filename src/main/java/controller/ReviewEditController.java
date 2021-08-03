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

@WebServlet(urlPatterns = { "/editReview" })
public class ReviewEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReviewEditController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);
		HttpSession session = request.getSession();
		UsersLogin loginUsers = MyUtils.getLoginedUser(session);
		String errorString = null;
		int movieId = -1;
		Review review = null;
		boolean result = false;
		int reviewId = Integer.parseInt(request.getParameter("reviewId"));
		try {
			review = ReviewDao.findReviewByReviewId(reviewId);
			movieId = review.getMovieId();
			String authorName = review.getAuthorName();
			if (!authorName.equals(loginUsers.getUsername())) {
				errorString = "you cannot edit this comment";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		if (errorString != null) {
			request.setAttribute("errorString", errorString);
			response.sendRedirect(request.getContextPath() + "/movie?movieId=" + movieId);
			return;
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("review",review);
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/view/editReview.jsp");
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);
		HttpSession session = request.getSession();
		UsersLogin loginUsers = MyUtils.getLoginedUser(session);
		String errorString = null;
		Movies movie = null;

		String username = null;
		int reviewId = Integer.parseInt(request.getParameter("reviewId"));
		int movieId = Integer.parseInt(request.getParameter("movieId"));
		String authorName = request.getParameter("authorName");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		
		Review review = new Review(reviewId, movieId, authorName, title, description);
		
		try {			
			movie = MovieDao.findMovie(movieId);
			username = ReviewDao.findAuthorByReviewId(reviewId);
			if (authorName.equals(loginUsers.getUsername())) {
				ReviewDao.editReview(review);
				System.out.println("reach editReview");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		request.setAttribute("review", review);
		request.setAttribute("movie", movie);

		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/view/editReview.jsp");
			dispatcher.forward(request, response);
		}

		else {
			response.sendRedirect(request.getContextPath() + "/movie?movieId=" + movieId);
		}

	}

}