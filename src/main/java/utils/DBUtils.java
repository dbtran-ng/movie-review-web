package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.UsersLogin;
import model.Review;
import model.UsersRegister;
 
public class DBUtils {
 
    public static UsersLogin findUser(Connection conn,
            String userName, String password) throws SQLException {
 
        String sql = "Select user_name, user_password from LOGIN " //
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
 
        String sql = "Select user_name, user_password from LOGIN " 
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
 
//    public static List<Review> queryReview(Connection conn) throws SQLException {
//        String sql = "Select a.Code, a.Name, a.Price from Review a ";
// 
//        PreparedStatement pstm = conn.prepareStatement(sql);
// 
//        ResultSet rs = pstm.executeQuery();
//        List<Review> list = new ArrayList<Review>();
//        while (rs.next()) {
//            String code = rs.getString("Code");
//            String name = rs.getString("Name");
//            float price = rs.getFloat("Price");
//            Review Review = new Review();
//            Review.setCode(code);
//            Review.setName(name);
//            Review.setPrice(price);
//            list.add(Review);
//        }
//        return list;
//    }
// 
//    public static Review findReview(Connection conn, String code) throws SQLException {
//        String sql = "Select a.Code, a.Name, a.Price from Review a where a.Code=?";
// 
//        PreparedStatement pstm = conn.prepareStatement(sql);
//        pstm.setString(1, code);
// 
//        ResultSet rs = pstm.executeQuery();
// 
//        while (rs.next()) {
//            String name = rs.getString("Name");
//            float price = rs.getFloat("Price");
//            Review Review = new Review(code, name, price);
//            return Review;
//        }
//        return null;
//    }
// 
//    public static void updateReview(Connection conn, Review Review) throws SQLException {
//        String sql = "Update Review set Name =?, Price=? where Code=? ";
// 
//        PreparedStatement pstm = conn.prepareStatement(sql);
// 
//        pstm.setString(1, Review.getName());
//        pstm.setFloat(2, Review.getPrice());
//        pstm.setString(3, Review.getCode());
//        pstm.executeUpdate();
//    }
// 
//    public static void insertReview(Connection conn, Review Review) throws SQLException {
//        String sql = "Insert into Review(Code, Name,Price) values (?,?,?)";
// 
//        PreparedStatement pstm = conn.prepareStatement(sql);
// 
//        pstm.setString(1, Review.getCode());
//        pstm.setString(2, Review.getName());
//        pstm.setFloat(3, Review.getPrice());
// 
//        pstm.executeUpdate();
//    }
// 
//    public static void deleteReview(Connection conn, String code) throws SQLException {
//        String sql = "Delete From Review where Code= ?";
// 
//        PreparedStatement pstm = conn.prepareStatement(sql);
// 
//        pstm.setString(1, code);
// 
//        pstm.executeUpdate();
//    }
// 
}