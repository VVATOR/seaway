package by.gsu.seawar.engine.battle;

import by.gsu.seawar.enums.FieldStatus;

public class Point {
    private int x;
    private int y;
    private FieldStatus status;

    public Point(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

	public FieldStatus getStatus() {
		return status;
	}

	public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setStatus(FieldStatus status) {
		this.status = status;
	}

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Shot [x=");
        builder.append(x);
        builder.append(", y=");
        builder.append(y);
        builder.append("]");
        return builder.toString();
    }

}
