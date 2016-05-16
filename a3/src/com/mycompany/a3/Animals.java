package com.mycompany.a3;

import java.util.Random;
import com.codename1.ui.Display;

public abstract class Animals extends GameObject implements IMoving, ICollider {
	private int speed;
	private int direction;
	private int gameSizeWidth = Display.getInstance().getDisplayWidth();
	private int gameSizeHeight = Display.getInstance().getDisplayHeight();
	@SuppressWarnings("unused")
	private boolean collision;
	private Random rand;
	
	public Animals() {
		rand = new Random();
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
		if( newLocationX < gameSizeWidth-(getSize()/2) && newLocationX > 0 && newLocationY < gameSizeHeight-(getSize()) && newLocationY > 0){
			setLocation(newLocationX,newLocationY);
		}
		else {
			setDirection(rand.nextInt(360));
		}
	} // move
} // Animals class
