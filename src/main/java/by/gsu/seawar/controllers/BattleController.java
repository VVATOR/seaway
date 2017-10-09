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

import by.gsu.seawar.beans.*;
import by.gsu.seawar.constants.GameStatus;
import by.gsu.seawar.db.DBAccessor;

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

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("BattleController");

        String view = "/WEB-INF/views/battle/battleField.jsp";

        int g = Integer.parseInt(request.getParameter("game"));

        User userPlay = (User) request.getSession().getAttribute("current_user");

        System.out.println("START WAR");

        
        try {
            request.setAttribute("enemy", DBAccessor.getUserById(DBAccessor.getEnemyId(g, userPlay.getId())));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        request.getRequestDispatcher(view).forward(request, response);

    }

}
