package by.gsu.seawar.command;

import java.io.IOException;
import java.sql.SQLException;

import by.gsu.seawar.Dispatcher;

public class CheckFillFieldsOfEnemyCommand extends AbstractCommand {

    public CheckFillFieldsOfEnemyCommand(Dispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void exec() throws SQLException {

           /* try {
                dispatcher.getResponse().sendRedirect("CheckFillFieldsOfEnemyController");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return;*/
    }

}
