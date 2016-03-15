package com.mycompany.a1;

public class Dog extends Animals {
	private int scratch;

	public int getScratch() {
		return scratch;
	}

	public void setScratch(int scratch) {
		this.scratch = scratch;
	}

	public String toString() {
		return ("Dog: loc=" + getLocationX() + ", " + getLocationY() + " color=" + getColor() + " size=" + getSize()
				+ " speed=" + getSpeed() + " dir=" + getDirection() + " scratches=" + getScratch());
	}
}
