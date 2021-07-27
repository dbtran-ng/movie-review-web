package model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Movie implements Serializable {
	private int movie_id;
    private String title;
    private String country;
    private int year;
    private String description;
    private String youtubeTrailer;
    private String imagePath;
    private List<Review> reviews = new ArrayList<>();
    private String rating;

    public Movie(String title, String country, int year,
                 String description, String youtubeTrailer, String imagePath) {
        this.title = title;
        this.country = country;
        this.year = year;
        this.description = description;
        this.youtubeTrailer = youtubeTrailer;
        this.imagePath = imagePath;

    }

    public Movie(int id, String title, String country, int year,
                 String description, String youtubeTrailer, String imagePath) {
    	this.movie_id = id;
        this.title = title;
        this.country = country;
        this.year = year;
        this.description = description;
        this.youtubeTrailer = youtubeTrailer;
        this.imagePath = imagePath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYoutubeTrailer() {
        return youtubeTrailer;
    }

    public void setYoutubeTrailer(String youtubeTrailer) {
        this.youtubeTrailer = youtubeTrailer;
    }
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return getYear() == movie.getYear()
                && Objects.equals(getTitle(), movie.getTitle())
                && Objects.equals(getCountry(), movie.getCountry())
                && Objects.equals(getDescription(), movie.getDescription())
                && Objects.equals(getYoutubeTrailer(), movie.getYoutubeTrailer());
    }


    @Override
    public String toString() {
        return new StringBuilder().append("Movie{")
                .append("title='").append(title).append('\'')
                .append(", country='").append(country).append('\'')
                .append(", year=").append(year)
                .append(", youtubeTrailer='").append(youtubeTrailer).append('\'')
                .append(", imagePath='").append(imagePath).append('\'')
                .append('}').toString();
    }

}
