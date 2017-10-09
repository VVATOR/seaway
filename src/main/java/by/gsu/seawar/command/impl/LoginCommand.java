package by.gsu.seawar.command.impl;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.gsu.seawar.Dispatcher;
import by.gsu.seawar.beans.User;
import by.gsu.seawar.command.AbstractCommand;
import by.gsu.seawar.db.DBAccessor;

public class LoginCommand extends AbstractCommand {

    public LoginCommand(Dispatcher dispatcher) {
        super(dispatcher);
    }

    public void exec() throws SQLException {
        final HttpServletRequest request = dispatcher.getRequest();
        System.out.println("LoginCommand");
        final HttpSession session = request.getSession();
        User userInSession = (User) request.getSession().getAttribute("current_user");
        String view = "";
        if (userInSession == null) {

            String login = request.getParameter("login");
            String password = request.getParameter("password");

            User user = DBAccessor.login(login, password);
            System.out.println(user);
            if (user != null) {
                System.out.println(user);
                session.setAttribute("current_user", user);
                view = "CommandController?action=TO_DASHBOARD";
            } else {
                request.setAttribute("message", "Incorrect login or password");
                view = "/authorisation.jsp";
            }
            System.out.println(view);
        } else {
            view = "CommandController?action=TO_DASHBOARD";
        }
        dispatcher.setView(view);
    }

}
