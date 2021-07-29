package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Movies;
import connection.ConnectionOracle;

public class MovieDao {
//	public static List<Movies> listMovies() throws ClassNotFoundException {
//		List<Movies> list = new ArrayList<Movies>();
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		try {
//			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
//			preparedStatement = connection
//					.prepareStatement("select * from movies where "
//							+ "movie_id = ? and title = ? and country = ? and year = ?"
//							+ "and description = ? and imagePath = ? and youtubeTrailer = ?");
//			resultSet = preparedStatement.executeQuery();
//
//			while (resultSet.next()) {
//				int movieId = resultSet.getInt(1);
//				String title = resultSet.getString(2);
//				String country = resultSet.getString(3);
//				int year = resultSet.getInt(4);
//				String description = resultSet.getString(5);
//				String imagePath = resultSet.getString(6);
//				String youtubeTrailer = resultSet.getString(7);
//                Movies movie = new Movies(movieId, title, country, year,
//                        description, imagePath, youtubeTrailer);
//				list.add(movie);
//			}
//		} catch (SQLException e) {
//			System.out.println("No access to database");
//			ConnectionOracle.printSQLException(e);
//		}
//		return list;
//
//	}

	public static List<Movies> listMovies() throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		List<Movies> list = new ArrayList<>();
		try {
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			connection.setAutoCommit(true);
			PreparedStatement preparedStatement = connection.prepareStatement(
					"select m.movie_id, m.title, m.country, m.year, m.description, m.imagePath, m.youtubeTrailer from movies m");
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
}
