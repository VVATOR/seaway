package by.gsu.seawar.command.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import by.gsu.seawar.Dispatcher;
import by.gsu.seawar.beans.Point;
import by.gsu.seawar.command.AbstractCommand;
import by.gsu.seawar.constants.FireStatus;
import by.gsu.seawar.db.DBAccessor;

public class FireCommand extends AbstractCommand {

    public FireCommand(Dispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void exec() throws SQLException {
        HttpServletRequest request = dispatcher.getRequest();
        int pointParam = Integer.parseInt(request.getParameter("point"));
        int gameId = Integer.parseInt(request.getParameter("gameId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        System.out.println("FIRE -> game:" + gameId + " user:" + userId + " point:" + pointParam);

        int x = pointParam / 10;
        int y = pointParam % 10; 
        Point point = new Point(x, y);

        FireStatus status = FireStatus.ERROR;
        PrintWriter out;
        try {
            out = dispatcher.getResponse().getWriter();

            try {
                status = DBAccessor.fire(gameId, userId, point);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println("eeeeeerrrroooorr");

            } 
           System.out.println("x:" + x + "; y:" + y + " -> " + status.toString());
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }

}
