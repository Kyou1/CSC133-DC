package com.mycompany.a3;

import java.util.Collection;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;

public class MapView extends Container implements IObserver {
	
	private GameWorld gameworld;
	private GameObjectCollection objects;
	private Collection gameStart;
	private Point pCmpRelPrnt;

	public MapView() {
	}
	
	public void update(IObservable o) {
		gameworld = (GameWorld)o; 
        objects = gameworld.getGameObjectCollection(); 
        gameStart = gameworld.getStart(); 
        repaint(); 
	}
	
    @Override
	public void paint(Graphics g) { 
         super.paint(g); 
         int x = getX(); 
         int y = getY();

        IIterator iterator = objects.getIterator();
         while (iterator.hasNext()){ 
             GameObject nxt = iterator.getNext();
             Point pCmpRelPrnt = new Point(this.getX(),this.getY());
             if(nxt instanceof Cat){
                 Cat cat = (Cat)nxt;
                 cat.draw(g, pCmpRelPrnt);
                 cat.move();
             } 
             if(nxt instanceof Dog){ 
                 Dog dog = (Dog)nxt;
                 dog.draw(g, pCmpRelPrnt);
                 dog.move();
             } 
             if(nxt instanceof Net){ 
                 Net net = (Net)nxt;
                 net.draw(g, pCmpRelPrnt);
             } 
 

         } 
 

     }
}
