package by.gsu.seawar.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.gsu.seawar.beans.User;
import by.gsu.seawar.db.DBAccessor;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String login = request.getParameter("login");
		String password = request.getParameter("password");

		String view = "";

		try {
			User user = DBAccessor.login(login, password);
			session.setAttribute("current_user",user);
			if (user != new User()) {
				session.setAttribute("current_user", user);
				view = "RootController";// "/WEB-INF/views/dashboard.jsp";
			} else {
				view = "/index.jsp";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			view = "/authorisation.jsp";
		}
		request.getRequestDispatcher(view).forward(request, response);
	}

}
