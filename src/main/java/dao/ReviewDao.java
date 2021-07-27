package dao;

import java.sql.SQLException;

import model.Review;

public interface ReviewDao {

	void addReview(Review review) throws SQLException;

	boolean deleteReview(int reviewId) throws SQLException;

	boolean updateReview(Review review) throws SQLException;

}
