package by.gsu.seawar.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.gsu.seawar.constants.Constant.*;

import by.gsu.seawar.GameStatus;
import by.gsu.seawar.beans.Gamer;
import by.gsu.seawar.beans.User;
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
		final String sql = "SELECT * from sw_user WHERE login = ? AND pass = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, login);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();

		User user = new User();

		while (rs.next()) {
			user.setId(rs.getInt("id_u"));
			user.setLogin(rs.getString("login"));
			user.setPassword("pass");
			user.setName(rs.getString("name"));
		}

		return user;
	}

	public User getUserById(int id) throws SQLException {
		Connection connection = DBConnection.getConnection();
		final String sql = "SELECT * from sw_user WHERE id_u = ?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
		ps.setInt(0, id);
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

	public static List<User> getListUsers() throws SQLException {
		Connection connection = DBConnection.getConnection();
		final String sql = "SELECT * from sw_user";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
		// TODO ps.close()
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

	public static void setWinner(int gameId, User winner) throws SQLException {
		Connection connection = DBConnection.getConnection();
		final String sql = "UPDATE sw_game SET  winner = ? WHERE id_g=? status=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, winner.getLogin());
		ps.setInt(2, gameId);
		ps.setString(3, GameStatus.END.toString());
		ps.executeUpdate();

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
		final String sql = "SELECT * from sw_game WHERE (id_u1=? OR id_u2=?) and status=?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
		ps.setInt(1, id);
		ps.setInt(2, id);
		ps.setString(3, GameStatus.CREATE_WAIT.toString());
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
		final String sql = "INSERT INTO sw_game (id_u1,id_u2) values (?,?)";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
		ps.setInt(1, user1);
		ps.setInt(2, user2);
		ps.execute();
	}

	public static  List<Game> listGamesHistory(int id) throws SQLException {
		Connection connection = DBConnection.getConnection();
		final String sql = "SELECT * from sw_game WHERE status=?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
		ps.setInt(1, id);
		ps.setString(2, GameStatus.END.toString());
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

	/*
	 * public boolean fire(final int x, final int y) throws SQLException { final
	 * String sql = "SELECT * from sw_ship_position WHERE login = ? AND";
	 * PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
	 * ps.setString(0, login); ps.setString(1, password); ResultSet rs =
	 * ps.executeQuery();
	 * 
	 * User user = new User();
	 * 
	 * while (rs.next()) { user.setLogin(rs.getString("login"));
	 * user.setPassword("password"); user.setName(rs.getString("name")); }
	 * 
	 * return user; }
	 */

}
