package by.gsu.seawar.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gsu.seawar.constants.FireStatus;
import by.gsu.seawar.db.DBAccessor;
import by.gsu.seawar.engine.battle.Point;

/**
 * Servlet implementation class FireController
 */
@WebServlet("/FireController")
public class FireController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FireController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("point"));
		int pointParam = Integer.parseInt(request.getParameter("point"));
		
		System.out.println(request.getParameter("gameId")+"*g*************");
		System.out.println(request.getParameter("userId")+"*u*************");
		int gameId =  Integer.parseInt(request.getParameter("gameId"));
		int userId =  Integer.parseInt(request.getParameter("userId"));


		int x = pointParam/10;
		int y = pointParam % 10;
		System.out.println(x+"*x*************");
		System.out.println(y+"*y*************");
		
		Point point = new Point(x, y);
	
		 FireStatus status = FireStatus.ERROR;
		 PrintWriter out = response.getWriter();
		try {
			status = DBAccessor.fire(gameId,userId,point);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		//FireStatus status = FireStatus.YES;
		
		out.println(status.toString());		
	}

}
