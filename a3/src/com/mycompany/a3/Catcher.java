package com.mycompany.a3;

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
	
	@Override
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
	
	@Override
	public void moveUp() {
		
		float x = getLocationX();
		float y = getLocationY();
/*		long bits = Float.floatToIntBits(y);
		bits++;
		y = Float.intBitsToFloat((int) bits);
		if (y < GameWorld.gameSizeHeight - (getSize() / 2)) {
			setLocation(x, y);
		}*/
		if(y > 0){
			y -= 10;
			setLocation(x, y);
		}
	}
	
	@Override
	public void moveDown() {
		float x = getLocationX();
		float y = getLocationY();
/*		long bits = Float.floatToIntBits(y);
		bits--;
		y = Float.intBitsToFloat((int) bits);*/
		if (y > 864 - getSize()) {
			x += 10;
			setLocation(x, y);
		}
	}

	@Override
	public void JumpToDog() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void JumpToCat() {
		// TODO Auto-generated method stub
		
	}
}
