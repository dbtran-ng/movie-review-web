package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.AdminLogin;

public class AdminDao {

    public AdminLogin findAdmin(Connection conn,
            String userName, String password) throws SQLException {
 
//        String sql = "Select admin_username, admin_password from MOVIESADMIN where admin_username = ? admin_password = ?";
// 
//        PreparedStatement pstm = conn.prepareStatement(sql);
		PreparedStatement pstm = conn
				.prepareStatement("select * from MOVIESADMIN where admin_username = ? and admin_password = ?");
    	pstm.setString(1, userName);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {     
        	AdminLogin user = new AdminLogin();
            user.setUsername(userName);
            user.setPassword(password);

            return user;
        }
        return null;
    }
 
    public static AdminLogin findAdmin(Connection conn, String userName) throws SQLException {
 
        String sql = "Select admin_username, admin_password from MOVIESADMIN " 
                + " admin_username = ?";
 
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
 
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            String password = rs.getString("Password");
            AdminLogin user = new AdminLogin();
            user.setUsername(userName);
            user.setPassword(password);

            return user;
        }
        return null;
    }


}
