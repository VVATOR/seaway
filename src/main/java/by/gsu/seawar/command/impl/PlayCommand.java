package by.gsu.seawar.command.impl;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.gsu.seawar.Dispatcher;
import by.gsu.seawar.beans.Point;
import by.gsu.seawar.beans.User;
import by.gsu.seawar.command.AbstractCommand;
import by.gsu.seawar.db.DBAccessor;

public class PlayCommand extends AbstractCommand {

    public PlayCommand(Dispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void exec() throws SQLException {
        System.out.println("PlayCommand");
        final HttpServletRequest request = dispatcher.getRequest();
        String view = "";
        int game = Integer.parseInt(request.getParameter("game"));
        User userPlay = (User) request.getSession().getAttribute("current_user");
        int userId = userPlay.getId();
        List<Point> listUserPosition = DBAccessor.getListPositions(game, userId);

        if (listUserPosition.isEmpty()) {
            view = "/WEB-INF/views/battle/createField.jsp";
            System.out.println("go to " + view);
        } else {
            // DBAccessor.getBattleFieldByUserID(g, userPlay);
            HttpSession session = request.getSession();
            session.setAttribute("userFieldPositions", listUserPosition);

            try {
                List<Point> currentUserListPositions = DBAccessor.getListPositions(game, userPlay.getId());

                System.out.println("*********" + currentUserListPositions);

                request.setAttribute("currentUserListPositions", currentUserListPositions);
                // request.setAttribute("enemy", DBAccessor.getEnemyUserByGame(g,userPlay.getId()));

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("ERROR CREATE_FIELD_BY_USER");
            }
            User enemy = DBAccessor.getUserById(DBAccessor.getEnemyId(game, userId));
            List<Point> listEnemyPosition = DBAccessor.getListPositions(game, enemy.getId());
            if (listEnemyPosition.isEmpty()) {
                request.setAttribute("enemy", enemy);
                view = "/WEB-INF/views/wait.jsp";
            } else {
                request.setAttribute("enemyUserListPositions", listEnemyPosition);
                
                view = "/BattleController";
            }
            System.out.println("go to " + view);
        }
        dispatcher.setView(view);
    }

}
