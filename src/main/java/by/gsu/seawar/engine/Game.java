package by.gsu.seawar.engine;

import java.sql.Date;

import by.gsu.seawar.beans.Gamer;
import by.gsu.seawar.constants.GameStatus;
import by.gsu.seawar.engine.battle.BattleField;

public class Game {
	
	private int id;
	private Date dateTime;
	private String winner;
	private GameStatus status;
    private BattleField[] fields = new BattleField[2];
    private Gamer[] players = new Gamer[2];

    public Game() {
        super();
    }

    public Game(Gamer player1, Gamer player2) {
        super();
        this.players[0] = player1;
        this.players[1] = player2;

        this.fields[0] = new BattleField();
        this.fields[1] = new BattleField();
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public GameStatus getStatus() {
		return status;
	}

	public void setStatus(GameStatus status) {
		this.status = status;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Gamer[] getPlayers() {
		return players;
	}

	public void setPlayers(Gamer[] players) {
		this.players = players;
	}
    
    

}
