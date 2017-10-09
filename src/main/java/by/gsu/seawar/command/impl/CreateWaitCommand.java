package by.gsu.seawar.command.impl;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import by.gsu.seawar.Dispatcher;
import by.gsu.seawar.command.AbstractCommand;
import by.gsu.seawar.db.DBAccessor;

public class CreateWaitCommand extends AbstractCommand {

    public CreateWaitCommand(Dispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void exec() throws SQLException {
        int user1 = Integer.parseInt(dispatcher.getRequest().getParameter("player1"));
        int user2 = Integer.parseInt(dispatcher.getRequest().getParameter("player2"));
        DBAccessor.createGame(user1, user2);
    }

}
 