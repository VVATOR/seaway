package by.gsu.seawar.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gsu.seawar.beans.*;
import by.gsu.seawar.db.DBAccessor;

/**
 * Servlet implementation class CheckFillFieldsOfEnemyController
 */
@WebServlet("/CheckFillFieldsOfEnemyController")
public class CheckFillFieldsOfEnemyController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckFillFieldsOfEnemyController() {
        super();
        // TODO Auto-generated constructor stub
    }

    static int num = 0;

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("CHECK");
        int gameId = Integer.parseInt(request.getParameter("gameId"));
        int enemyId = Integer.parseInt(request.getParameter("enemyId"));

        System.out.println(gameId + "****" + enemyId);
        PrintWriter out = response.getWriter();
        num++;

        // if (num % 10 == 0) {
        List<Point> list;
        try {
            list = DBAccessor.getListPositions(gameId, enemyId);

            if (list.size() != 0) {
                out.append("YES");
                System.out.println("YES");
                // DBAccessor.getListUsers(currentUserId);
            } else {
                out.append("NO");
                System.out.println("NO");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("ERROR");
        }
        System.out.println("wait");
    }

}
