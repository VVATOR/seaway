package by.gsu.seawar.engine.battle;

import java.util.List;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class BattleField {

    private List<Ship> ships;
    private List<Shot> shots;

    public BattleField() {
        super();
    }

    public void placeShip(int x, int y) {
    	throw new NotImplementedException();
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

    public void makeShot(int x, int y) {
    	throw new NotImplementedException();
    }

    public boolean isDefeat() {

        throw new NotImplementedException();
    }

}
