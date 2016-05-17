package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Dimension2D;
import com.codename1.ui.geom.Point;

public class Dog extends Animals implements IDrawable, ISelectable {
	private int scratch;
	private boolean selected;
	private Sounds sound;
	private Sounds catCollision;
	private int size, currentX, currentY, incX, incY;

	public int getScratch() {
		return scratch;
	}

	public void setScratch(int scratch) {
		this.scratch = scratch;
	}
	
	public void resetScratches() {
		scratch = 0;
	}
	
	Dog() {
	}

	@Override
	public String toString() {
		
		return ("Dog: loc=" + getLocationX() + ", " + getLocationY() + 
				" color=" + getColor() + 
				" size=" + getSize() + 
				" speed=" + getSpeed() + 
				" dir=" + getDirection() + 
				" scratches=" + getScratch());
	}

	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		size = getSize();
		g.setColor(ColorUtil.GREEN);
		g.fillArc(pCmpRelPrnt.getX()+currentX, pCmpRelPrnt.getY()+currentY, size, size, 0, 360);
		g.drawArc(pCmpRelPrnt.getX()+currentX, pCmpRelPrnt.getY()+currentY, size, size, 0, 360);
		move();
	}
	
	public void move(Dimension dCmpSize) {
		currentX += incX;
		currentY += incY;
		if ( (currentX+size >= dCmpSize.getWidth()) || (currentX < 0) ) incX = -incX ; 
		if ( (currentY+size >= dCmpSize.getHeight()) || (currentY < 0) ) incY = -incY; 
	}
	
	@Override
	public boolean collidesWith(GameObject anotherObject) {
		
		boolean result = false;
		float dogCenterX = this.getLocationX() + (getSize()/2);
		float dogCenterY = this.getLocationY() + (getSize()/2);
		float otherCenterX = anotherObject.getLocationX() + (anotherObject.getSize()/2);
		float otherCenterY = anotherObject.getLocationY() + (anotherObject.getSize()/2);		

		float distX = dogCenterX - otherCenterX;
		float distY = dogCenterY - otherCenterY;
		float distBetweenCentersSquare = ( distX * distX + distY * distY );
		
		int dogRadius = getSize() /2;
		int otherRadius = getSize() /2;
		
		int radiiSquare = (dogRadius * dogRadius + 2 * dogRadius * otherRadius + otherRadius * otherRadius);
		
		if(distBetweenCentersSquare <= radiiSquare) {
			result = true;
		}
		
		return result;
	}

	@Override
	public void handleCollision(GameObject anotherObject, GameWorld gw) {
		
		int speed = getSpeed();
		speed--;
		if(speed >= 0){
			setSpeed(speed);
			setColor(ColorUtil.MAGENTA);
		}
		//play collisionSound
	}

	@Override
	public void setSelected(boolean select) {
		
		selected = select;
	}

	@Override
	public boolean isSelected() {
		
		return selected;
	}

	public boolean contains(Point p) {
		
		float x1, x2, y1, y2;
		x1 = getLocationX()-(getSize()/2);
		x2 = getLocationX()+(getSize()/2);
		y1 = getLocationY()-(getSize()/2);
		y2 = getLocationY()+(getSize()/2);
		
		if(p.getX() >= x1 && p.getX() <= x2){
			if(p.getY() >= y1 && p.getY() <= y2){
				return true;
			}
		}
		return false;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
	
	}

}
