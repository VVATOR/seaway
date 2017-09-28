package by.gsu.seawar.controllers;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.gsu.seawar.beans.User;

/**
 * Servlet implementation class RootController
 */
@WebServlet("/RootController")
public class RootController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RootController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("current_user");
        String view = "";

        if (user == null) {
            view = "/authorisation.jsp";
        } else {
            view = "/WEB-INF/views/index.jsp";
        }

        request.getRequestDispatcher(view).forward(request, response);

    }

}
