package by.gsu.seawar.controllers;

import java.io.IOException;
import java.io.PrintWriter;

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
		
	/*	int gameId = ;
		int userId = ;
		
		int x = ;
		int y = ;
		Point point = new Point(x, y);
	
		FireStatus status = DBAccessor.fire(gameId,userId,point);
		PrintWriter out = response.getWriter();
		out.println(status.toString());		*/
	}

}
