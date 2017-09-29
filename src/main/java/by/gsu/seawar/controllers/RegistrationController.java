package by.gsu.seawar.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.gsu.seawar.beans.User;
import by.gsu.seawar.db.DBAccessor;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");

        String view = "/index.jsp";

        try {
            DBAccessor.registration(login, password,name);
        } catch (SQLException e) {
            e.printStackTrace();
        }

      
        request.getRequestDispatcher(view).forward(request, response);
    }

}
