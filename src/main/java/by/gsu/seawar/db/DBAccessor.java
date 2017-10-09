package by.gsu.seawar.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.gsu.seawar.constants.Constant.*;

import by.gsu.seawar.beans.*;
import by.gsu.seawar.constants.Constant;
import by.gsu.seawar.constants.EnemyFieldStatus;
import by.gsu.seawar.constants.FireStatus;
import by.gsu.seawar.constants.GameStatus;
import by.gsu.seawar.engine.Game;

public class DBAccessor {
    // private static Connection connection = DBConnection.getConnection();

    public static void registration(final String login, final String password, final String name) throws SQLException {
        Connection connection = DBConnection.getConnection();
        final String sql = "INSERT INTO sw_user (login,pass,name) values (?,?,?)";
        PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        ps.setString(1, login);
        ps.setString(2, password);
        ps.setString(3, name);
        ps.execute();
    }

    public static User login(final String login, final String password) throws SQLException {
        Connection connection = DBConnection.getConnection();
        final String sql = "SELECT distinct * from sw_user WHERE login = ? AND pass = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, login);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();

        User user = null;

        while (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id_u"));
            user.setLogin(rs.getString("login"));
            user.setPassword("pass");
            user.setName(rs.getString("name"));
        }
        System.out.println("/////////////////////////////////");
        return user;
    }

    public static User getUserById(int id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        final String sql = "SELECT * from sw_user WHERE id_u = ?";
        PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        List<User> users = new ArrayList<>();

        User user = new User();
        while (rs.next()) {
            user.setId(rs.getInt("id_u"));
            user.setLogin(rs.getString("login"));
            user.setPassword("password");
            user.setName(rs.getString("name"));
            users.add(user);
        }
        return user;
    }

    public static List<User> getListUsers(int currentUserId) throws SQLException {
        Connection connection = DBConnection.getConnection();
        final String sql = "SELECT * from sw_user WHERE id_u<>?";
        PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        // TODO ps.close()
        ps.setInt(1, currentUserId);
        ResultSet rs = ps.executeQuery();

        List<User> users = new ArrayList<>();

        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id_u"));
            user.setLogin(rs.getString("login"));
            user.setPassword("password");
            user.setName(rs.getString("name"));
            users.add(user);
        }
        return users;
    }

    public static void setWin(int gameId, User userSurrenderId) throws SQLException {
        Connection connection = DBConnection.getConnection();
        System.out.println(":::::::::::::");
        System.out.println("::gameId::" + gameId);
        System.out.println("::userSurrenderId:::" + userSurrenderId);

        final String sql = "UPDATE sw_game SET "
                + " winner = (SELECT login FROM sw_user u WHERE u.id_u = sw_game.id_u2), "
                + " status = ? "
                + "WHERE id_g=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        // ps.setInt(1, userSurrenderId.getId());
        ps.setString(1, GameStatus.END.toString());
        ps.setInt(2, gameId);

        System.out.println("updated : " + ps.executeUpdate());
    }

    public static void verifyBattle(int gameId) throws SQLException {
        Connection connection = DBConnection.getConnection();
        final String sql = "UPDATE sw_game SET status = ? WHERE id_g=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, GameStatus.VERIFY.toString());
        ps.setInt(2, gameId);
        ps.executeUpdate();
    }

    public static void rejectBattle(int gameId) throws SQLException {
        Connection connection = DBConnection.getConnection();
        final String sql = "UPDATE sw_game SET status = ? WHERE id_g=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, GameStatus.REJECT.toString());
        ps.setInt(2, gameId);
        ps.executeUpdate();
    }

    public static List<Game> getListBattleOffersForUser(int id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        final String sql = "SELECT * from sw_game WHERE (id_u1=? OR id_u2=?) and status=? and status!=?";
        PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setInt(2, id);
        ps.setString(3, GameStatus.CREATE_WAIT.toString());
        ps.setString(4, GameStatus.END.toString());
        ResultSet rs = ps.executeQuery();

        List<Game> games = new ArrayList<>();

        while (rs.next()) {
            Game game = new Game();
            game.setId(rs.getInt("id_g"));
            game.setStatus(GameStatus.valueOf(rs.getString("status")));
            game.setWinner(rs.getString("winner"));
            game.setDateTime(rs.getDate("date_start"));
            // game.setPlayers({new Gamer(), new Gamer()} );

            games.add(game);
        }

        return games;
    }

    public static List<Game> listActiveGames(int id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        final String sql = "SELECT * from sw_game WHERE (id_u1=? OR id_u2=?) and status=?";
        PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setInt(2, id);
        ps.setString(3, GameStatus.VERIFY.toString());
        ResultSet rs = ps.executeQuery();

        List<Game> games = new ArrayList<>();

        while (rs.next()) {
            Game game = new Game();
            game.setId(rs.getInt("id_g"));
            game.setStatus(GameStatus.valueOf(rs.getString("status")));
            game.setWinner(rs.getString("winner"));
            game.setDateTime(rs.getDate("date_start"));
            // game.setPlayers({new Gamer(), new Gamer()} );

            games.add(game);
        }

        return games;
    }

    public static void createGame(int user1, int user2) throws SQLException {
        Connection connection = DBConnection.getConnection();
        final String sql = "INSERT INTO sw_game (id_u1,id_u2,step) values (?,?,?)";
        PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        ps.setInt(1, user1);
        ps.setInt(2, user2);
        ps.setInt(3, user1);
        ps.execute();
    }

    public static List<Game> listGamesHistory(int id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        final String sql = "SELECT * from sw_game WHERE (id_u1=? OR id_u2=?) AND status=?";
        PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setInt(2, id);
        ps.setString(3, GameStatus.END.toString());
        ResultSet rs = ps.executeQuery();

        List<Game> games = new ArrayList<>();

        while (rs.next()) {
            Game game = new Game();
            game.setId(rs.getInt("id_g"));
            game.setStatus(GameStatus.valueOf(rs.getString("status")));
            game.setWinner(rs.getString("winner"));
            game.setDateTime(rs.getDate("date_start"));
            // game.setPlayers({new Gamer(), new Gamer()} );

            games.add(game);
        }

        return games;
    }

    public static void createFieldByUser(int g, int userId, List<Point> positions) throws SQLException {
        System.out.println("DBBBBBBBBBBBBBBBBB");
        Connection connection = DBConnection.getConnection();
        connection.setAutoCommit(false);

        final String sql0 = "INSERT INTO sw_battlefield (id_g,id_u,bf_status) values (?,?,?)";
        PreparedStatement ps0 = (PreparedStatement) connection.prepareStatement(sql0);
        ps0.setInt(1, g);
        ps0.setInt(2, userId);
        ps0.setString(3, EnemyFieldStatus.FILL.toString());
        ps0.execute();

        final String sql1 = "SELECT count(id_bf) id_bf from sw_battlefield";
        PreparedStatement ps1 = (PreparedStatement) connection.prepareStatement(sql1);
        ResultSet rs = ps1.executeQuery();
        rs.next();
        int id_bf = rs.getInt("id_bf");
        System.out.println(id_bf + "----------");

        final String sql = "INSERT INTO sw_ship_position (id_bf,x,y,field_status) values (?,?,?,?)";
        PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);

        for (Point point : positions) {
            System.out.println(id_bf + " - " + point.getX() + "-" + point.getY());
            ps.setInt(1, id_bf);
            ps.setInt(2, point.getX());
            ps.setInt(3, point.getY());
            ps.setString(4, EnemyFieldStatus.FILL.toString());
            ps.execute();
        }

        connection.commit();
        // connection.close(); //TODO anywhere
        System.out.println("CREATE_FIELD_BY_USER");
    }

    public static FireStatus fire(int gameId, int userId, Point point) throws SQLException {
        int enemyId = DBAccessor.getEnemyId(gameId, userId);
        Connection connection = DBConnection.getConnection();
        final String sql = "SELECT * FROM sw_battlefield b INNER JOIN sw_ship_position p ON (b.id_bf = p.id_bf)"
                + " WHERE id_g=? AND id_u=? AND x=? AND y=? AND p.field_status<>?;";
        PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        ps.setInt(1, gameId);
        ps.setInt(2, enemyId);
        ps.setInt(3, point.getX());
        ps.setInt(4, point.getY());
        ps.setString(5, FireStatus.EMPTY.toString());
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            final String sqlUpdate = "UPDATE sw_ship_position "
                    + " SET "
                    + " field_status = ?"
                    + " WHERE id_p=?";
            PreparedStatement ps1 = (PreparedStatement) connection.prepareStatement(sqlUpdate);
            ps1.setString(1, FireStatus.KILLED.toString());
            ps1.setInt(2, rs.getInt("id_p"));
            ps1.executeUpdate();
            return FireStatus.KILLED;
        } else {
            final String sqlBF = "SELECT * FROM sw_battlefield b INNER JOIN sw_ship_position p ON (b.id_bf = p.id_bf)"
                    + " WHERE id_g=? AND id_u=?";
            PreparedStatement pss = (PreparedStatement) connection.prepareStatement(sqlBF);
            pss.setInt(1, gameId);
            pss.setInt(2, enemyId);
            ResultSet r = pss.executeQuery();
            if (r.next()) {
                final String sqlInsert = "INSERT INTO sw_ship_position (id_bf,x,y,field_status) VALUES(?,?,?,?) ";
                PreparedStatement ps1 = (PreparedStatement) connection.prepareStatement(sqlInsert);
                ps1.setInt(1, r.getInt("id_bf"));
                ps1.setInt(2, point.getX());
                ps1.setInt(3, point.getY());
                ps1.setString(4, FireStatus.EMPTY.toString());
                ps1.executeUpdate();
            }
            return FireStatus.EMPTY;

        }
    }

    public static List<Point> getListPositions(int gameId, int userId) throws SQLException {
        List<Point> points = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        final String sql = "SELECT * FROM sw_battlefield b INNER JOIN sw_ship_position p ON (b.id_bf = p.id_bf)"
                + " WHERE id_g=? AND id_u=?";
        PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        ps.setInt(1, gameId);
        ps.setInt(2, userId);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Point point = new Point(rs.getInt("x"), rs.getInt("y"));
            points.add(point);

        }

        return points;
    }

    public static int getEnemyId(int gameId, int userId) throws SQLException {
        List<Point> points = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        final String sql = "SELECT * FROM sw_game "
                + " WHERE id_g=?";
        PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        ps.setInt(1, gameId);

        ResultSet rs = ps.executeQuery();
        int enemyId = 0;
        while (rs.next()) {
            if (rs.getInt("id_u1") == userId) {
                enemyId = rs.getInt("id_u2");
            } else {
                enemyId = rs.getInt("id_u1");
            }
        }

        return enemyId;

    }

    /*
     * public boolean fire(final int x, final int y) throws SQLException { final String sql = "SELECT * from sw_ship_position WHERE login = ? AND"; PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql); ps.setString(0, login);
     * ps.setString(1, password); ResultSet rs = ps.executeQuery();
     * 
     * User user = new User();
     * 
     * while (rs.next()) { user.setLogin(rs.getString("login")); user.setPassword("password"); user.setName(rs.getString("name")); }
     * 
     * return user; }
     */

}
