package com.mycompany.a2;

public class Animals extends GameObject implements IMoving {
	private int speed;
	private int direction;
	private int gameSizeWidth = 1000;
	private int gameSizeHeight = 610;

	public Animals() {

	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void move() {
		float deltaX = (float) Math.cos(90 - getDirection()) * getSpeed();
		float deltaY = (float) Math.sin(90 - getDirection()) * getSpeed();
		float newLocationX = (getLocationX() + deltaX);
		float newLocationY = (getLocationY() + deltaY);

		// Set location to the middle of object.
		if (newLocationX < gameSizeWidth - (this.getSize() / 2) && newLocationX > (this.getSize() / 2)
				&& newLocationY < gameSizeHeight - (this.getSize() / 2) && newLocationY > (this.getSize() / 2)) {
			setLocation(newLocationX, newLocationY);
		}
	} // move
} // Animals class
