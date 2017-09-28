package by.gsu.seawar.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gsu.seawar.beans.User;
import by.gsu.seawar.db.DBAccessor;

/**
 * Servlet implementation class SurrenderController
 */
@WebServlet("/SurrenderController")
public class SurrenderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SurrenderController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User winner = (User) request.getAttribute("winner");
		int gameId = Integer.parseInt(request.getParameter("game"));

		String view = "/WEB-INF/views/dashboard.jsp";
		try {
			DBAccessor.setWinner(gameId, winner);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			view ="";
		}

		request.getRequestDispatcher(view).forward(request, response);
	}

}
