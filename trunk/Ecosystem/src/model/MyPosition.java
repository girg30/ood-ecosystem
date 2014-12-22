package model;

import java.io.Serializable;

public class MyPosition implements Serializable {

	private static final long serialVersionUID = 0xABL;
	private int x;
	private int y;

	public MyPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public MyPosition getPosition() {
		return new MyPosition(x, y);
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "MyPosition [x=" + x + ", y=" + y + "]";
	}

}
