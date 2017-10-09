package by.gsu.seawar.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.gsu.seawar.Dispatcher;
import by.gsu.seawar.beans.Point;
import by.gsu.seawar.beans.User;
import by.gsu.seawar.db.DBAccessor;

public class CreateFieldCommand extends AbstractCommand {

    public CreateFieldCommand(Dispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void exec() throws SQLException {
        System.out.println("CreateFieldCommand");
        final HttpServletRequest request = dispatcher.getRequest();
        final int g = Integer.parseInt(request.getParameter("game"));

        User userPlay = (User) request.getSession().getAttribute("current_user");

        String[] fill = request.getParameterValues("fill");
        List<Point> positions = new ArrayList<>();
        for (String numberFillField : fill) {
            System.out.print(numberFillField + ", ");
            int x = Integer.parseInt(numberFillField) % 10;
            int y = Integer.parseInt(numberFillField) / 10;
            positions.add(new Point(x, y));
        }
        DBAccessor.createFieldByUser(g, userPlay.getId(), positions);
        System.out.println("add to DB : " + positions);

        User enemy = DBAccessor.getUserById(DBAccessor.getEnemyId(g, userPlay.getId()));
        
        request.setAttribute("enemy", enemy);
        dispatcher.setView("/WEB-INF/views/wait.jsp");

    }

}
 