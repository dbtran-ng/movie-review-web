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
import dao.RegisterDao;
import dao.ReviewDao;
import model.Movies;
import model.Review;
import model.UsersRegister;
import utils.MyUtils;

@WebServlet("/review")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewDao reviewDao;

	public ReviewController() {
		super();

	}

	public void init() {
		reviewDao = new ReviewDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);
		Movies movie = null;
		try {
			int movieId = Integer.parseInt(request.getParameter("movieId"));
			movie = MovieDao.findMovie(movieId);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if (movie == null) {
			response.sendRedirect(request.getServletPath() + "/movies");
			return;
		}

		// Store errorString in request attribute, before forward to views.
		request.setAttribute("movie", movie);
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/view/review.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		addReview(request,response);
	}

	private void addReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);
		String errorString = null;
		Movies movie = null;
		try {
			int movieId = Integer.parseInt(request.getParameter("movieId"));
			movie = MovieDao.findMovie(movieId);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		if (movie == null) {
			System.out.println("Movie is null.");
			response.sendRedirect(request.getServletPath() + "/movies");
			return;
		}

		int movieId = Integer.parseInt(request.getParameter("movieId"));
		String authorName = request.getParameter("username");
		String title = request.getParameter("title");
		String description = request.getParameter("description");

		Review review = new Review(movieId, authorName, title, description);
		review.setMovieId(movieId);
		review.setAuthorName(authorName);
		review.setTitle(title);
		review.setDescription(description);

		try {
			boolean result = reviewDao.addReview(review);

			if (result == true) {
				request.setAttribute("NOTIFICATION", "Add Review Successfully!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("review", review);
		request.setAttribute("movie", movie);

		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/view/review.jsp");
			dispatcher.forward(request, response);
		}

		else {
			response.sendRedirect(request.getContextPath() + "/movie?movieId=" + movieId);
		}
		
	}

}
