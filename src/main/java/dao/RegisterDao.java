package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.UsersLogin;
import model.UsersRegister;

public class RegisterDao {

	public static void registerUsers(UsersRegister users) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO MOVIEUSERS"
				+ " (user_id, user_name, user_password, email, fname, lname, address, state) VALUES "
				+ " (users_id_seq.nextval,?, ?, ?, ?, ?, ?, ?)";
		String INSERT_LOGIN_SQL = "insert into LOGINUSERS select user_name, user_password from MOVIEUSERS";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		try (

				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, users.getUsername());
			preparedStatement.setString(2, users.getPassword());
			preparedStatement.setString(3, users.getEmail());
			preparedStatement.setString(4, users.getFirstName());
			preparedStatement.setString(5, users.getLastName());
			preparedStatement.setString(6, users.getAddress());
			preparedStatement.setString(7, users.getState());
			preparedStatement.execute();
			connection.commit();
//			try {
//				int count = 0;
//
//				count = preparedStatement.executeUpdate();
//				if (count > 0) {
//					preparedStatement1.execute();
//					connection.commit();
//				}
//
//			} catch (Exception ex) {
//				connection.rollback();
//			}

		} catch (SQLException e) {
			System.out.println("Can't insert new user info into the database");
			printSQLException(e);
		}
	}

	public static void registerLogin() throws ClassNotFoundException {
		String INSERT_LOGIN_SQL = "insert into LOGINUSERS select distinct(user_name), user_password from MOVIEUSERS"
				+ " where NOT EXISTS(Select user_name from loginusers where loginusers.user_name = movieusers.user_name)";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		try {
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			PreparedStatement preparedStatement1 = connection.prepareStatement(INSERT_LOGIN_SQL);

			preparedStatement1.execute();
			connection.commit();

		} catch (

		SQLException e) {
			System.out.println("Can't insert new user info into the database");
			printSQLException(e);
		}
	}

	public boolean findByUsername(String username) {

		String statementQuery = ("select count(*) from loginusers where user_name = ?");
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
				PreparedStatement preparedStatement = connection.prepareStatement(statementQuery)) {
			preparedStatement.setString(1, username);
			ResultSet result = preparedStatement.executeQuery();

			if (result != null) {
				while (result.next()) {
					if (result.getInt(1) == 1) {
						return true;
					}
				}
			}

		} catch (SQLException e) {
			printSQLException(e);
		}
		return false;
	}

	public boolean findByLogin(String username, String password) {
		String statementQuery = ("select password from loginusers where user_name = ?");
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
				PreparedStatement preparedStatement = connection.prepareStatement(statementQuery)) {
			preparedStatement.setString(1, username);
			ResultSet result = preparedStatement.executeQuery();

			if (result != null) {
				while (result.next()) {
					if (result.getString(1).equals(password)) {
						return true;
					}
				}
			}

		} catch (SQLException e) {
			printSQLException(e);
		}
		return false;
	}

	private static void printSQLException(SQLException ex) {
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