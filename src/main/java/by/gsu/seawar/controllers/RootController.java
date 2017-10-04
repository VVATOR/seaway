package by.gsu.seawar.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.gsu.seawar.beans.User;
import by.gsu.seawar.db.DBAccessor;

/**
 * Servlet implementation class RootController
 */
@WebServlet("/RootController")
public class RootController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int num=0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RootController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("current_user");
		String view = "";
		
		num++;
		System.out.println("op - "+num);
		if (user == null) {
			view = "/authorisation.jsp";
		} else {
			view = "/WEB-INF/views/dashboard.jsp";

			try {
				session.setAttribute("listPlayers", DBAccessor.getListUsers(user.getId()));

				session.setAttribute("listBattleOffirs", DBAccessor.getListBattleOffersForUser(user.getId()));

				session.setAttribute("listActiveGames", DBAccessor.listActiveGames(user.getId()));

				session.setAttribute("listGamesHistory", DBAccessor.listGamesHistory(user.getId()));

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		request.getRequestDispatcher(view).forward(request, response);

	}

}
