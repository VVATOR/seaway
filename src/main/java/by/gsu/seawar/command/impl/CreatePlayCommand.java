package by.gsu.seawar.command.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.gsu.seawar.Dispatcher;
import by.gsu.seawar.beans.Point;
import by.gsu.seawar.beans.User;
import by.gsu.seawar.command.AbstractCommand;
import by.gsu.seawar.db.DBAccessor;

public class CreatePlayCommand extends AbstractCommand {

    public CreatePlayCommand(Dispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void exec() throws SQLException {
        final HttpServletRequest request = dispatcher.getRequest();

        int g = Integer.parseInt(request.getParameter("game"));

        User userPlay = (User) request.getSession().getAttribute("current_user");

        System.out.println("aaaaaaaaaaa");
        System.out.println("START WAR");

        List<Point> positions = new ArrayList<>();
 
        String[] fill = request.getParameterValues("fill");
        // String[] fill = {"11","21","53","33"};

        for (String numberFillField : fill) {

            System.out.print(numberFillField + ", ");
            int x = Integer.parseInt(numberFillField) % 10;
            int y = Integer.parseInt(numberFillField) / 10;
            positions.add(new Point(x, y));
        }

        System.out.println("\n" + positions);
        System.out.println("START CREATE_FIELD_BY_USER");
        try {
            DBAccessor.createFieldByUser(g, userPlay.getId(), positions);

            List<Point> currentUserListPositions = DBAccessor.getListPositions(g, userPlay.getId());

            System.out.println("*********" + currentUserListPositions);

            request.setAttribute("currentUserListPositions", currentUserListPositions);
            // request.setAttribute("enemy", DBAccessor.getEnemyUserByGame(g,userPlay.getId()));

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR CREATE_FIELD_BY_USER");
        }
        dispatcher.setView("/BattleController");
    }

}
