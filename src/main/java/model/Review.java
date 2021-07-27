package model;

import java.time.LocalDate;

public class Review {

	private int reviewId;
	private String username;
	private int movieId;
	private String title;
	private String description;
	private LocalDate publishDate;

	public Review(int reviewId, String username, int movieId, String title, String description, LocalDate publishDate) {
		super();
		this.reviewId = reviewId;
		this.username = username;
		this.movieId = movieId;
		this.title = title;
		this.description = description;
		this.publishDate = publishDate;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
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
	public LocalDate getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

}
