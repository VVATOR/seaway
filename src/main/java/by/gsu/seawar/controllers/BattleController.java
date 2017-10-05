package by.gsu.seawar.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gsu.seawar.GameStatus;
import by.gsu.seawar.beans.User;
import by.gsu.seawar.db.DBAccessor;
import by.gsu.seawar.engine.battle.Point;

/**
 * Servlet implementation class BattleController
 */
@WebServlet("/BattleController")
public class BattleController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BattleController() {
        super();
        // TODO Auto-generated constructor stub
    }

    enum BattleAction {
        BATTLE_CREATE
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	// BattleAction action = BattleAction.valueOf(request.getParameter("action"));
    	 GameStatus action = GameStatus.valueOf(request.getParameter("action"));

        String view = view = "/WEB-INF/views/battle/battleField.jsp";
        switch (action) {
        case PLAY:
            // TODO Auto-generated method stub
            int g = Integer.parseInt(request.getParameter("game"));
            
            User userPlay = (User) request.getSession().getAttribute("current_user");

            System.out.println("aaaaaaaaaaa");
            System.out.println("START WAR");

            List<Point> positions = new ArrayList<>();
            
            //String[] fill = request.getParameterValues("fill");
            
            String[] fill = {"11","21","53","33"};
            for (String numberFillField : fill) {

                System.out.print(numberFillField + ", ");
                int x = Integer.parseInt(numberFillField) % 10;
                int y = Integer.parseInt(numberFillField) / 10;
                positions.add(new Point(x, y));
            }
            System.out.println("\n" + positions);

            try {
                DBAccessor.createFieldByUser(g, userPlay.getId(), positions);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            break;

        default:
            break;
        }
   
        request.getRequestDispatcher(view).forward(request, response);

    }

}
