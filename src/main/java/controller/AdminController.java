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

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher //
				= this.getServletContext().getRequestDispatcher("/WEB-INF/view/adminLogin.jsp");

		dispatcher.forward(request, response);

	}

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

		if (hasError) {
			admin = new AdminLogin();
			admin.setUsername(username);
			admin.setPassword(password);

			request.setAttribute("errorString", errorString);
			request.setAttribute("admin", admin);

			RequestDispatcher dispatcher //
					= this.getServletContext().getRequestDispatcher("/WEB-INF/view/adminLogin.jsp");

			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/listMovies");
		}
	}

}