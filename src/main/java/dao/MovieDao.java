package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Movies;
import model.UsersLogin;
import connection.ConnectionOracle;

public class MovieDao {
	private static final String LIST_MOVIES_SQL = "select m.movie_id, m.title, m.country, m.year, m.description, m.imagePath, m.youtubeTrailer from movies m";
	private static final String CREATE_MOVIE_SQL = "INSERT INTO movies"
			+ " (movie_id, title, country, year, description, imagepath, youtubetrailer) VALUES "
			+ " (movie_id_seq.nextval,?, ?, ?, ?, ?, ?)";
	private static final String SELECT_MOVIE_BY_ID_SQL = "SELECT m.movie_id, m.title, m.country, m.year,  m.description, m.imagePath, m.youtubeTrailer FROM MOVIES m WHERE m.movie_id=?";
	private static final String UPDATE_MOVIE_SQL = "UPDATE movies set title =?, country=?, year=?, description =?, imagePath=?, youtubeTrailer=? WHERE movie_id=?";
	private static final String DELETE_MOVIE_SQL = "DELETE FROM movies WHERE movie_id=?";

	public static List<Movies> listMovies() throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		List<Movies> list = new ArrayList<>();
		try {
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

			PreparedStatement preparedStatement = connection.prepareStatement(LIST_MOVIES_SQL);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int movieId = resultSet.getInt("movie_id");
				String title = resultSet.getString("title");
				String country = resultSet.getString("country");
				int year = resultSet.getInt("year");
				String description = resultSet.getString("description");
				String imagePath = resultSet.getString("imagePath");
				String youtubeTrailer = resultSet.getString("youtubeTrailer");
				Movies movie = new Movies();
				movie.setMovieId(movieId);
				movie.setTitle(title);
				movie.setCountry(country);
				movie.setYear(year);
				movie.setDescription(description);
				movie.setImagePath(imagePath);
				movie.setYoutubeTrailer(youtubeTrailer);

				list.add(movie);
			}
		} catch (SQLException e) {
			System.out.println("No access to database");
			ConnectionOracle.printSQLException(e);
		}
		return list;

	}

	public static Movies findMovie(int movieId) throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try {
			String sql = "select m.movie_id, m.title, m.country, m.year, m.description, m.imagePath, m.youtubeTrailer from movies m where m.movie_id = ?";
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, movieId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String title = resultSet.getString("title");
				String country = resultSet.getString("country");
				int year = resultSet.getInt("year");
				String description = resultSet.getString("description");
				String imagePath = resultSet.getString("imagePath");
				String youtubeTrailer = resultSet.getString("youtubeTrailer");
				Movies movie = new Movies(movieId, title, country, year, description, imagePath, youtubeTrailer);
				return movie;
			}
		} catch (SQLException e) {
			ConnectionOracle.printSQLException(e);
		}
		return null;
	}
	
	public static List<Movies> findAllMoviesByName(String titleLooking) throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		List<Movies> list = new ArrayList<>();
		try {
			String sql = "select m.movie_id, m.title, m.country, m.year, m.description, m.imagePath, m.youtubeTrailer "
					+ "from movies m where instr(lower(m.title),?) >= 1 order by movie_id";
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, titleLooking);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int movieId = resultSet.getInt("movie_id");
				String title = resultSet.getString("title");
				String country = resultSet.getString("country");
				int year = resultSet.getInt("year");
				String description = resultSet.getString("description");
				String imagePath = resultSet.getString("imagePath");
				String youtubeTrailer = resultSet.getString("youtubeTrailer");
				Movies movie = new Movies(movieId, title, country, year, description, imagePath, youtubeTrailer);

				list.add(movie);
			}
		} catch (SQLException e) {
			ConnectionOracle.printSQLException(e);
		}
		return list;
	}

	public static void createMovie(Movies movie) throws SQLException {

		try {
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			PreparedStatement preparedStatement = connection.prepareStatement(CREATE_MOVIE_SQL);
			preparedStatement.setString(1, movie.getTitle());
			preparedStatement.setString(2, movie.getCountry());
			preparedStatement.setInt(3, movie.getYear());
			preparedStatement.setString(4, movie.getDescription());
			preparedStatement.setString(5, movie.getImagePath());
			preparedStatement.setString(6, movie.getYoutubeTrailer());

			preparedStatement.execute();
			connection.commit();
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			System.out.println("Can't insert movie info into the database");
			ConnectionOracle.printSQLException(e);
		}

	}

	// update movie method
	public static void updateMovie(Movies movie) throws SQLException {

		try {
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MOVIE_SQL);
			preparedStatement.setString(1, movie.getTitle());
			preparedStatement.setString(2, movie.getCountry());
			preparedStatement.setInt(3, movie.getYear());
			preparedStatement.setString(4, movie.getDescription());
			preparedStatement.setString(5, movie.getImagePath());
			preparedStatement.setString(6, movie.getYoutubeTrailer());
			preparedStatement.setInt(7, movie.getMovieId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("can't update movie");
			ConnectionOracle.printSQLException(e);
		}
	}

	// delete movie method
	public static void deleteMovie(int id) throws SQLException {

		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		connection.setAutoCommit(true);
		PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MOVIE_SQL);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}

}
