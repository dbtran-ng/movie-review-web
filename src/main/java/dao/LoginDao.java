package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Movies;
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
					.prepareStatement("select * from loginusers where user_name = ? and user_password = ?");
			preparedStatement.setString(1, loginUsers.getUsername());
			preparedStatement.setString(2, loginUsers.getPassword());

			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();

		} catch (SQLException e) {
			System.out.println("Wrong username or Wrong password");
			ConnectionOracle.printSQLException(e);
		}
		return status;

	}
    public static UsersLogin findUser(Connection conn,
            String userName, String password) throws SQLException {
 
        String sql = "Select user_name, user_password from loginusers "
                + " where user_name = ? and user_password= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {     
        	UsersLogin user = new UsersLogin();
            user.setUsername(userName);
            user.setPassword(password);

            return user;
        }
        return null;
    }
 
    public static UsersLogin findUser(Connection conn, String userName) throws SQLException {
 
        String sql = "Select user_name, user_password from loginusers " 
                + " where user_name = ?";
 
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
 
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            String password = rs.getString("Password");
            UsersLogin user = new UsersLogin();
            user.setUsername(userName);
            user.setPassword(password);

            return user;
        }
        return null;
    }
	

}
