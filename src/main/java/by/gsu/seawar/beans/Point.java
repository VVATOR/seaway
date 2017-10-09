package by.gsu.seawar.beans;

import by.gsu.seawar.constants.FireStatus;

public class Point {
    private int x;
    private int y;
    private FireStatus status;

    public Point() {
        super();
    }

    public Point(int x, int y) {
        super();
        this.x = x;
        this.y = y;
        this.status = FireStatus.UNKNOWN;
    }

    public Point(int x, int y, FireStatus status) {
        this(x,y);
        this.status = status;
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

    public FireStatus getStatus() {
        return status;
    }

    public void setStatus(FireStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Point [x=");
        builder.append(x);
        builder.append(", y=");
        builder.append(y);
        builder.append(", status=");
        builder.append(status);
        builder.append("]");
        return builder.toString();
    }

}
