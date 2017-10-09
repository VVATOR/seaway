package by.gsu.seawar.command.impl;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import by.gsu.seawar.Dispatcher;
import by.gsu.seawar.beans.User;
import by.gsu.seawar.command.AbstractCommand;
import by.gsu.seawar.db.DBAccessor;

public class SurrenderCommand extends AbstractCommand {

    public SurrenderCommand(Dispatcher dispatcher) {
        super(dispatcher);        
    }

    @Override
    public void exec() throws SQLException {
        final HttpServletRequest request = dispatcher.getRequest();
        User userSurrenderId = (User) request.getSession().getAttribute("current_user");
        System.out.println(userSurrenderId);
        int gameId = Integer.parseInt(request.getParameter("game"));
        DBAccessor.setWin(gameId, userSurrenderId);
    }

}
 