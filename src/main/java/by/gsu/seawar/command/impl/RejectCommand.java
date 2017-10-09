package by.gsu.seawar.command.impl;

import java.sql.SQLException;

import by.gsu.seawar.Dispatcher;
import by.gsu.seawar.command.AbstractCommand;
import by.gsu.seawar.db.DBAccessor;

public class RejectCommand extends AbstractCommand {

    public RejectCommand(Dispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void exec() throws NumberFormatException, SQLException {
        DBAccessor.rejectBattle(Integer.parseInt(dispatcher.getRequest().getParameter("game")));
    }

}
 