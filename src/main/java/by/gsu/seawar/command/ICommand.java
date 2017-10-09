package by.gsu.seawar.command;

import java.sql.SQLException;

public interface ICommand {

    public void exec() throws SQLException;
}
