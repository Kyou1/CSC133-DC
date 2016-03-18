package com.mycompany.a2;

public class Net extends Catcher {
	@Override
	public String toString() {
		return ("Net: loc=" + getLocationX() + ", " + getLocationY() + " color=" + getColor() + " size=" + getSize());
	}
}
