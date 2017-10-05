package by.gsu.seawar.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.gsu.seawar.GameStatus;
import by.gsu.seawar.beans.User;
import by.gsu.seawar.db.DBAccessor;
import by.gsu.seawar.engine.Game;
import by.gsu.seawar.engine.battle.Point;
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		GameStatus action = GameStatus.valueOf(request.getParameter("action").toUpperCase());

		String view = "RootController"; // "/WEB-INF/views/dashboard.jsp";
		try {
			switch (action) {
			case CREATE_WAIT:

				int user1 = Integer.parseInt(request.getParameter("player1"));
				int user2 = Integer.parseInt(request.getParameter("player2"));
				DBAccessor.createGame(user1, user2);
				break;
			case VERIFY:
				DBAccessor.verifyBattle(Integer.parseInt(request.getParameter("game")));
				break;
			case REJECT:
				DBAccessor.rejectBattle(Integer.parseInt(request.getParameter("game")));
				break;
			case SURRENDER:
				User userSurrenderId = (User) request.getSession().getAttribute("current_user");
				System.out.println(userSurrenderId);
				int gameId = Integer.parseInt(request.getParameter("game"));
				DBAccessor.setWin(gameId, userSurrenderId);
				break;
			case PLAY:
				System.out.println("play vva");
				// User userSurrenderId = (User)
				// request.getSession().getAttribute("current_user");
				// System.out.println(userSurrenderId);
				boolean isFieldFill = (request.getParameter("game") != null ? true : false);
				int game = Integer.parseInt(request.getParameter("game"));
				//request.setAttribute("game", Integer.parseInt(request.getParameter("game")));
				System.out.println("action vva 1 gameId "+game+" - r: "+request.getParameter("game"));
				User userPlay = (User) request.getSession().getAttribute("current_user");
				int userId = userPlay.getId();
				List<Point> listUserPosition = DBAccessor.fieldIsExist(game, userId);
				System.out.println("action vva 2");
				if (listUserPosition.size() > 0) {
					// DBAccessor.getBattleFieldByUserID(g, userPlay);
					System.out.println("action vva 3");
					// view = "/WEB-INF/views/battle/battleField.jsp";
					HttpSession session = request.getSession();
					session.setAttribute("userFieldPositions",listUserPosition);
					view = "/BattleController";
					System.out.println("action vva BattleController");
					
				} else {
					view = "/WEB-INF/views/battle/createField.jsp";
					
				//	DBAccessor.createFieldByUser(userId, positions);
					System.out.println("action vva createField");
					
				}
				
				System.out.println("end vva");
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
