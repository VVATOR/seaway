package by.gsu.seawar.engine.battle;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Ship {

    private int length;
    private int x;
    private int y;
    private int wounds = 0;

    public Ship(int length, int x, int y) {
        super();
        this.length = length;
        this.x = x;
        this.y = y;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void makeWound() {
        throw new NotImplementedException();
    }

    public boolean isDestroyed() {
        throw new NotImplementedException();
    }

}
