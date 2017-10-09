package by.gsu.seawar.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gsu.seawar.Dispatcher;
import by.gsu.seawar.beans.User;
import by.gsu.seawar.command.CommandFactory;
import by.gsu.seawar.command.ICommand;

/**
 * Servlet implementation class CommandController
 */
@WebServlet("/CommandController")
public class CommandController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommandController() {
        super();
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

      //  User current_user = (User) request.getSession().getAttribute("current_user");
        
        String view = "CommandController?action=TO_DASHBOARD"; // "/WEB-INF/views/dashboard.jsp";
        Dispatcher dispatcher = new Dispatcher(view, request, response);
        ICommand command = CommandFactory.newCommand(dispatcher);

        try {
            command.exec();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        send(dispatcher);
    }

    private void send(Dispatcher dispatcher) throws ServletException, IOException {
        dispatcher.getRequest().getRequestDispatcher(dispatcher.getView()).forward(dispatcher.getRequest(), dispatcher.getResponse());
    }

}
