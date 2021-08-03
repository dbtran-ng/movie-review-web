package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionOracle;
import connection.ConnectionUtils;
import model.Movies;
import model.Review;

public class ReviewDao {

	private static final String SELECT_REVIEWS_ByID = "select r.review_id,r.movie_id, r.author_name, r.title, r.description from review r where r.movie_id = ? order by r.review_id desc";
	private static final String SELECT_REVIEW_ByReviewID = "select r.review_id,r.movie_id, r.author_name, r.title, r.description from review r where r.review_id = ?";
	private static final String INSERT_REVIEW_SQL = "INSERT INTO REVIEW"
			+ " (review_id, movie_id, author_name, title, description) VALUES " + " (review_id_seq.nextval,?,?,?,?)";
	private static final String DELETE_REVIEW_BY_USER = "delete from review where review_id = ? and author_name = ?";
	private static final String UPDATE_REVIEW = "Update Review set title =?, description=? where review_id = ? and movie_id=? and author_name=? ";

	public static List<Review> listReviewByMovieId(int movieId) throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		List<Review> list = new ArrayList<>();
		try {
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_REVIEWS_ByID);
			preparedStatement.setInt(1, movieId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int reviewId = resultSet.getInt("review_id");
				String author = resultSet.getString("author_name");
				String title = resultSet.getString("title");
				String description = resultSet.getString("description");
				Review review = new Review();
				review.setReviewId(reviewId);
				review.setMovieId(movieId);
				review.setAuthorName(author);
				review.setTitle(title);
				review.setDescription(description);
				list.add(review);
			}
		} catch (SQLException e) {
			System.out.println("No access to database");
			ConnectionOracle.printSQLException(e);
		}
		return list;

	}

	public static int findMovieByReviewId(int reviewId) throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try {

			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_REVIEW_ByReviewID);
			preparedStatement.setInt(1, reviewId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int movieId = resultSet.getInt("movie_id");
				String author = resultSet.getString("author_name");
				String title = resultSet.getString("title");
				String description = resultSet.getString("description");
				Review review = new Review(reviewId, movieId, author, title, description);
				return review.getMovieId();
			}
		} catch (SQLException e) {
			ConnectionOracle.printSQLException(e);
		}
		return -1;
	}

	public static String findAuthorByReviewId(int reviewId) throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try {

			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_REVIEW_ByReviewID);
			preparedStatement.setInt(1, reviewId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int movieId = resultSet.getInt("movie_id");
				String author = resultSet.getString("author_name");
				String title = resultSet.getString("title");
				String description = resultSet.getString("description");
				Review review = new Review(reviewId, movieId, author, title, description);
				return review.getAuthorName();
			}
		} catch (SQLException e) {
			ConnectionOracle.printSQLException(e);
		}
		return null;
	}

	public static Review findReviewByReviewId(int reviewId) throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try {
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_REVIEW_ByReviewID);
			preparedStatement.setInt(1, reviewId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int movieId = resultSet.getInt("movie_id");
				String author = resultSet.getString("author_name");
				String title = resultSet.getString("title");
				String description = resultSet.getString("description");
				Review review = new Review(reviewId, movieId, author, title, description);
				return review;
			}
		} catch (SQLException e) {
			ConnectionOracle.printSQLException(e);
		}
		return null;
	}

	public boolean addReview(Review review) throws SQLException, ClassNotFoundException {

		boolean result = false;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try (

				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_REVIEW_SQL)) {
			preparedStatement.setInt(1, review.getMovieId());
			preparedStatement.setString(2, review.getAuthorName());
			preparedStatement.setString(3, review.getTitle());
			preparedStatement.setString(4, review.getDescription());

			System.out.println(preparedStatement);

			result = preparedStatement.execute();

			connection.commit();
			connection.setAutoCommit(true);

		} catch (SQLException e) {
			printSQLException(e);
		}
		return result;
	}

	public static boolean deleteReview(int reviewId, String author) throws SQLException, ClassNotFoundException {
		boolean rowDeleted;
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_REVIEW_BY_USER);) {
			statement.setInt(1, reviewId);
			statement.setString(2, author);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public static void editReview(Review review) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_REVIEW);
		preparedStatement.setString(1, review.getTitle());
		preparedStatement.setString(2, review.getDescription());
		preparedStatement.setInt(3, review.getReviewId());
		preparedStatement.setInt(4, review.getMovieId());
		preparedStatement.setString(5, review.getAuthorName());
		preparedStatement.executeUpdate();

	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
