package model;

import java.time.LocalDate;

public class Review {

	private int reviewId;
	private int movieId;
	private String authorName;
	private String title;
	private String description;

	public Review() {
		
	}
	public Review(int movieId, String authorName, String title, String description) {
		super();
		this.movieId = movieId;
		this.authorName = authorName;
		this.title = title;
		this.description = description;
	}

	public Review(int reviewId, int movieId, String authorName, String title, String description) {
		super();
		this.reviewId = reviewId;
		this.movieId = movieId;
		this.authorName = authorName;
		this.title = title;
		this.description = description;
	}

	public Review(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
