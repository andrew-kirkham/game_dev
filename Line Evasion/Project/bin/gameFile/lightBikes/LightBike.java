package gameFile.lightBikes;

import javax.swing.JPanel;


public class LightBike extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8627191644265601708L;
	private int x;
	private int y;
	private int speed;
	private int direction;
	
	private boolean IsAlive = true;

	public LightBike(int x, int y, int speed, int direction) {
		
		this.x = x;
		this.y = y;
		this.speed = speed;
		
		this.direction = direction;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void moveBike() {
		
		/*
		 * Direction 0 = Right
		 * Direction 1 = Up
		 * Direction 2 = Left
		 * Direction 3 = Down
		 */
			
		if (direction == 0) {
			x = x + speed;
		} else if (direction == 1) {
			y = y - speed;
		} else if (direction == 2) {
			x = x - speed;
		} else if (direction == 3) {
			y = y + speed;
		}
		
	}
		


	public int getDirection() {
		return direction;
	}

	public void moveLeft() {
		if (direction == 0) {
			direction++;
		} else if (direction == 1) {
			direction++;
		} else if (direction == 2) {
			direction++;
		} else if (direction == 3) {
			direction = 0;
		}

	}

	public void moveRight() {
		if (direction == 3) {
			direction--;
		} else if (direction == 2) {
			direction--;
		} else if (direction == 1) {
			direction--;
		} else if (direction == 0) {
			direction = 3;
		}
	}

	public boolean IsAlive() {
		return IsAlive;
	}

}
