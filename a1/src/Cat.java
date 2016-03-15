package com.mycompany.a1;

public class Cat extends Animals {
	public String toString() {
		return ("Cat: loc=" + getLocationX() + ", " + getLocationY() + " color=" + getColor() + " size=" + getSize()
				+ " speed=" + getSpeed() + " dir=" + getDirection());
	}
}
