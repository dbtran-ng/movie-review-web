package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import model.AdminLogin;
import utils.DBUtils;
import utils.MyUtils;

@WebServlet(urlPatterns = { "/admin" })
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminDao adminDao;

	public AdminController() {
		super();
	}

	public void init() {
		adminDao = new AdminDao();
	}

	// Show Login page.
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Forward to /WEB-INF/views/loginView.jsp
		// (admins can not access directly into JSP pages placed in WEB-INF)
		RequestDispatcher dispatcher //
				= this.getServletContext().getRequestDispatcher("/WEB-INF/view/adminLogin.jsp");

		dispatcher.forward(request, response);

	}

	// When the admin enters adminName & password, and click Submit.
	// This method will be executed.
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("admin_username");
		String password = request.getParameter("admin_password");
		String rememberMeStr = request.getParameter("rememberMe");
		boolean remember = "Y".equals(rememberMeStr);

		AdminLogin admin = null;
		boolean hasError = false;
		String errorString = null;

		if (username == null || password == null || username.length() == 0 || password.length() == 0) {
			hasError = true;
			errorString = "Required username and password!";

			System.out.println("Required username and password!");

		} else {
			Connection conn = MyUtils.getStoredConnection(request);
			try {
				// Find the admin in the DB.
				admin = adminDao.findAdmin(conn, username, password);

				if (admin == null) {
					hasError = true;
					errorString = "username or password invalid";
				}
			} catch (SQLException e) {
				e.printStackTrace();
				hasError = true;
				errorString = e.getMessage();
			}
		}
		// If error, forward to /WEB-INF/views/login.jsp
		if (hasError) {
			admin = new AdminLogin();
			admin.setUsername(username);
			admin.setPassword(password);

			// Store information in request attribute, before forward.
			request.setAttribute("errorString", errorString);
			request.setAttribute("admin", admin);

			// Forward to /WEB-INF/views/login.jsp
			RequestDispatcher dispatcher //
					= this.getServletContext().getRequestDispatcher("/WEB-INF/view/adminLogin.jsp");

			dispatcher.forward(request, response);
		}
		// If no error
		// Store admin information in Session
		// And redirect to adminInfo page.
		else {

			// Redirect to adminInfo page.
			response.sendRedirect(request.getContextPath() + "/listMovies");
		}
	}

}