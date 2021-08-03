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

@WebServlet(urlPatterns = { "/deleteReview" })
public class ReviewDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReviewDeleteController() {
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
		String authorName = null;
		boolean result = false;
		int reviewId = Integer.parseInt(request.getParameter("reviewId"));
		try {
			movieId = ReviewDao.findMovieByReviewId(reviewId);
			authorName = ReviewDao.findAuthorByReviewId(reviewId);

			if (authorName.equals(loginUsers.getUsername())) {
				result = ReviewDao.deleteReview(reviewId, authorName);
			}
			if (result == true) {
				request.setAttribute("notification", "Delete Review Successfully!");
			} else {

				errorString = "You're not the owner of this post";
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		if (errorString != null) {
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/view/deleteReview.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/movie?movieId=" + movieId);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}