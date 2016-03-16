package com.mycompany.a2;

public class Catcher extends GameObject implements IGuided {
	@Override
	public void moveRight() {
		float x = getLocationX();
		float y = getLocationY();
		long bits = Float.floatToIntBits(x);
		bits++;
		x = Float.intBitsToFloat((int) bits);
		if (x < GameWorld.gameSizeWidth - (getSize() / 2)) {
			setLocation(x, y);
		}
	}

	public void moveLeft() {
		float x = getLocationX();
		float y = getLocationY();
		long bits = Float.floatToIntBits(x);
		bits--;
		x = Float.intBitsToFloat((int) bits);
		if (x > (getSize() / 2)) {
			setLocation(x, y);
		}
	}

	public void moveUp() {
		float x = getLocationX();
		float y = getLocationY();
		long bits = Float.floatToIntBits(y);
		bits++;
		y = Float.intBitsToFloat((int) bits);
		if (y < GameWorld.gameSizeHeight - (getSize() / 2)) {
			setLocation(x, y);
		}
	}

	public void moveDown() {
		float x = getLocationX();
		float y = getLocationY();
		long bits = Float.floatToIntBits(y);
		bits--;
		y = Float.intBitsToFloat((int) bits);
		if (y > (getSize() / 2)) {
			setLocation(x, y);
		}
	}

	public void JumpToDog() {

	}

	public void JumpToCat() {

	}
}
