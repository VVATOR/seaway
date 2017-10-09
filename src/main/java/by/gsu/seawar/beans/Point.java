package by.gsu.seawar.beans;

import by.gsu.seawar.constants.FireStatus;

import by.gsu.seawar.enums.FieldStatus;

public class Point {
    private int x;
    private int y;
<<<<<<< HEAD:src/main/java/by/gsu/seawar/engine/battle/Point.java
    private FieldStatus status;
=======
    private FireStatus status;

    public Point() {
        super();
    }
>>>>>>> 3055d83261f7fe24710cb3a8f2758867b768af67:src/main/java/by/gsu/seawar/beans/Point.java

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
