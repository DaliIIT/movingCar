package tn.iit.moving_car;

public class Car {

	private int X, Y, rival;
	private boolean left, right, down, up;

	public Car() {
		this.X = 25;
		this.Y = 25;
		rival = -1;
	}

	public int getRival() {
		return rival;
	}

	public void setRival(int rival) {
		this.rival = rival;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;

		this.right = false;
		this.down = false;
		this.up = false;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;

		this.left = false;
		this.down = false;
		this.up = false;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;

		this.right = false;
		this.left = false;
		this.up = false;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;

		this.right = false;
		this.left = false;
		this.down = false;

	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

}
