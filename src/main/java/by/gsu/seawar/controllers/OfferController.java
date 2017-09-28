package by.gsu.seawar.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gsu.seawar.GameStatus;
import by.gsu.seawar.db.DBAccessor;
import by.gsu.seawar.engine.Game;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Servlet implementation class OfferController
 */
@WebServlet("/OfferController")
public class OfferController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OfferController() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		GameStatus action = GameStatus.valueOf(request.getParameter("action").toUpperCase());

		String view = "/WEB-INF/views/dashboard.jsp";
		try {
			switch (action) {
			case CREATE_WAIT:
				
				int user1  = Integer.parseInt(request.getParameter("player1"));
				int user2  = Integer.parseInt(request.getParameter("player2"));
				DBAccessor.createGame(user1,user2);
				break;				
			case VERIFY:
				DBAccessor.verifyBattle(Integer.parseInt(request.getParameter("game")));
				break;
			case REJECT:		
				DBAccessor.rejectBattle(Integer.parseInt(request.getParameter("game")));
				break;

			default:
				throw new NotImplementedException(); // TODO

			}
		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher(view).forward(request, response);
	}

}
