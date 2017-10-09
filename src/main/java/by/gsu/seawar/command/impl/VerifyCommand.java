package by.gsu.seawar.command.impl;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import by.gsu.seawar.Dispatcher;
import by.gsu.seawar.command.AbstractCommand;
import by.gsu.seawar.db.DBAccessor;

public class VerifyCommand extends AbstractCommand {

    public VerifyCommand(Dispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void exec() throws NumberFormatException, SQLException {
        DBAccessor.verifyBattle(Integer.parseInt(dispatcher.getRequest().getParameter("game")));
    }

}
 