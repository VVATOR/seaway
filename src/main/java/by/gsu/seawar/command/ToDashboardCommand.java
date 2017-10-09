package by.gsu.seawar.command;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import by.gsu.seawar.Dispatcher;
import by.gsu.seawar.beans.User;
import by.gsu.seawar.db.DBAccessor;

public class ToDashboardCommand extends AbstractCommand {

    public ToDashboardCommand(Dispatcher dispatcher) {
        super(dispatcher);
    }

    public void exec() throws SQLException {
        final HttpSession session = dispatcher.getRequest().getSession();
        User user = (User) session.getAttribute("current_user");
        session.setAttribute("listPlayers", DBAccessor.getListUsers(user.getId()));
        session.setAttribute("listBattleOffirs", DBAccessor.getListBattleOffersForUser(user.getId()));
        session.setAttribute("listActiveGames", DBAccessor.listActiveGames(user.getId()));
        session.setAttribute("listGamesHistory", DBAccessor.listGamesHistory(user.getId()));
        dispatcher.setView("/WEB-INF/views/dashboard.jsp");
    }
}
