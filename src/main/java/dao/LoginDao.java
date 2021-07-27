package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.UsersLogin;
import model.UsersRegister;
import connection.ConnectionOracle;

public class LoginDao {
	public boolean checkUsers(UsersLogin loginUsers) throws ClassNotFoundException {
		boolean status = false;
		Class.forName("oracle.jdbc.driver.OracleDriver");

		try {
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from login where user_name = ? and user_password = ?");
			preparedStatement.setString(1, loginUsers.getUsername());
			preparedStatement.setString(2, loginUsers.getPassword());

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();

		} catch (SQLException e) {
			System.out.println("Wrong username or Wrong password");
			ConnectionOracle.printSQLException(e);
		}
		return status;

	}

}
