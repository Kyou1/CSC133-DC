package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Dimension2D;
import com.codename1.ui.geom.Point;

public class Net extends Catcher implements IDrawable, ICollider {
	@Override
	public String toString() {
		return ("Net: loc=" + getLocationX() + ", " + getLocationY() + " color=" + getColor() + " size=" + getSize());
	}

	@Override
	public boolean collidesWith(GameObject obj) {
		boolean result = false; 
        float thisCenterX = this.getLocationX() + (getSize()/2); // find centers 
        float thisCenterY = this.getLocationY() + (getSize()/2); 
 

         float otherCenterX = obj.getLocationX() + (obj.getSize()/2); 
         float otherCenterY = obj.getLocationY() + (obj.getSize()/2); 
 

         float dx = thisCenterX - otherCenterX; 
         float dy = thisCenterY - otherCenterY; 
         float distBetweenCentersSqr = (dx*dx + dy*dy); 
 

         int thisRadius = getSize()/2; 
         int otherRadius = obj.getSize()/2; 
 

         int radiiSqr = (thisRadius*thisRadius + 2*thisRadius*otherRadius + otherRadius*otherRadius); 


         if (distBetweenCentersSqr <= radiiSqr) { result = true ; } 
 

         return result; 

	}

	@Override
	public void handleCollision(GameObject anotherObject, GameWorld gw) {
		// TODO Auto-generated method stub
		
	}

    public void draw(Graphics g, Point pCmpRelPrnt) { 
         int halfSize = getSize()/2; 
         g.setColor(ColorUtil.YELLOW); 
         g.drawRect(pCmpRelPrnt.getX()-halfSize,pCmpRelPrnt.getY()-halfSize,getSize(),getSize()); 
         g.drawRect(pCmpRelPrnt.getX()-halfSize,pCmpRelPrnt.getY()-halfSize,5,5); 
     }



}
