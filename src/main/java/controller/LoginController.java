package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;
import dao.RegisterDao;
import model.UsersLogin;
import utils.DBUtils;
import utils.MyUtils;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;

	public void init() {
		loginDao = new LoginDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/login.jsp");
	       dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		authenticate(request, response);
	}

	private void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = request.getParameter("user_name");
		String password = request.getParameter("user_password");
        String rememberMeStr = request.getParameter("rememberMe");
        boolean remember = "Y".equals(rememberMeStr);
        
        UsersLogin loginUsers = null;
        boolean hasError = false;
        String errorMsg = null;
        
        if ( username == null || password == null || username.length() == 0 || password.length() == 0) {
        	hasError = true;
        	errorMsg = "Required username or password";
        } else {
        	Connection connection = MyUtils.getStoredConnection(request);
        	try {
        		loginUsers = loginDao.findUser(connection, username, password);
        		
        		if (loginUsers == null)
        		{
        			hasError = true;
        			errorMsg = " Username or password invalid";
        		}
        	}catch(SQLException e) {
        		e.printStackTrace();
        		hasError = true;
        		errorMsg = e.getMessage();
        	}
        }
        
        if (hasError) {
    		loginUsers = new UsersLogin();
    		loginUsers.setUsername(username);
    		loginUsers.setPassword(password);
 
            // Store information in request attribute, before forward.
            request.setAttribute("errorMsg", errorMsg);
            request.setAttribute("loginUsers", loginUsers);
 
            // Forward to /WEB-INF/views/login.jsp
            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/WEB-INF/view/login.jsp");
            dispatcher.forward(request, response);
        }
        // If no error
        // Store user information in Session
        // And redirect to userInfo page.
        else {
            HttpSession session = request.getSession();
            MyUtils.storeLoginedUser(session, loginUsers);
 
            // If user checked "Remember me".
            if (remember) {
                MyUtils.storeUserCookie(response, loginUsers);
            }
            // Else delete cookie.
            else {
                MyUtils.deleteUserCookie(response);
            }
 
            // Redirect to userInfo page.
            response.sendRedirect(request.getContextPath() + "/movies");
        }
    }
}