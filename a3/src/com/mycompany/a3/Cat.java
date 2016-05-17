package com.mycompany.a3;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Dimension2D;
import com.codename1.ui.geom.Point;

public class Cat extends Animals implements IDrawable, ICollider {
	private static GameWorld game;
	static int gameSizeWidth = Display.getInstance().getDisplayWidth();
	static int gameSizeHeight = Display.getInstance().getDisplayHeight();
	private boolean collision;
	private Sounds collisionSound;
	private Random rand = new Random();
	private int size, currentX = 0, currentY = 0, incX, incY;
	
	Cat() {

	}
	
	public static void setTarget(GameWorld gw) {
		if(game == null)
			game = gw;			
	}
	
	@Override
	public String toString() {
		return ("Cat: loc=" + getLocationX() + ", " + getLocationY() + " color=" + getColor() + " size=" + getSize()
				+ " speed=" + getSpeed() + " dir=" + getDirection());
	}
	
	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		currentX = (int) getLocationX();
		currentY = (int) getLocationY();
		incX = getSpeed();
		incY = getSpeed();
		
		g.setColor(ColorUtil.BLUE);
		
		Point top      = new Point(pCmpRelPrnt.getX()+currentX, pCmpRelPrnt.getY()+currentY + (getSize()/2)); 
	    Point bottomLeft  = new Point(pCmpRelPrnt.getX()+currentX - (getSize()/2), pCmpRelPrnt.getY()+currentY  - (getSize()/2)); 
	    Point bottomRight = new Point(pCmpRelPrnt.getX()+currentX + (getSize()/2), pCmpRelPrnt.getY()+currentY  - (getSize()/2)); 
	     
	      
	    int [] xPts = new int [] {top.getX(), bottomLeft.getX(), bottomRight.getX()} ; 
	    int [] yPts = new int [] {top.getY(), bottomLeft.getY(), bottomRight.getY()} ; 
	    
	    g.fillPolygon(xPts, yPts, 3); 
	}
	
	public void move(Dimension dCmpSize) {
		currentX += incX;
		currentY += incY;
		if ( (currentX+size >= dCmpSize.getWidth()) || (currentX < 0) ) incX = -incX ; 
		if ( (currentY+size >= dCmpSize.getHeight()) || (currentY < 0) ) incY = -incY; 
	}
	
	@Override
	public boolean collidesWith(GameObject anotherObject) {
        float p1x = getLocationX(); 
        float p2x = getLocationX() + getSize(); 
        float p3x = getLocationX(); 
        float p4x = getLocationX() + getSize(); 
        float p1y = getLocationY(); 
        float p2y = getLocationY(); 
        float p3y = getLocationY() + getSize(); 
        float p4y = getLocationY() + getSize(); 

        Animals animal = (Animals) anotherObject; 
        float a1x = animal.getLocationX(); 
        float a2x = animal.getLocationX() + animal.getSize(); 
        float a3x = animal.getLocationX(); 
        float a4x = animal.getLocationX() + getSize(); 
        float a1y = animal.getLocationY(); 
        float a2y = animal.getLocationY(); 
        float a3y = animal.getLocationY() + animal.getSize(); 
        float a4y = animal.getLocationY() + animal.getSize(); 

        if ((p1x > a1x && p1x < a2x) && (p1y > a1y && p1y < a3y) ||//good 
        	(p2x > a1x && p2x < a2x) && (p2y > a1y && p2y < a3y) ||//good 
        	(p3x > a1x && p3x < a2x) && (p3y > a1y && p3y < a3y) ||//good 
        	(p4x > a1x && p4x < a2x) && (p4y > a1y && p4x < a3x)) { //good 
 
        	// System.out.println("collision"); 
        	collision = true; 
        	return true; 
        } else { 
        	collision = false; 
        	return false; 
        } 

	}

	@Override
	public void handleCollision(GameObject anotherObject, GameWorld gw) {
		// TODO Auto-generated method stub
		gw.produceKitten();
	}

}
