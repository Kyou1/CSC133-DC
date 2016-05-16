package com.mycompany.a3;

import java.util.Collection;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;

public class MapView extends Container implements IObserver {
	
	private GameWorld gameworld;
	private GameObjectCollection gameObjCollect;
	private Collection gameStart;

	public MapView() {

	}
	
	public void update(IObservable o) {
		gameworld = (GameWorld)o; 
        gameObjCollect = gameworld.getGameObjectCollection(); 
        gameStart = gameworld.getStart(); 
        repaint(); 
	}
	
    @Override
	public void paint(Graphics g) { 
         super.paint(g); 
         int x = getX(); 
         int y = getY();

        IIterator iter = gameObjCollect.getIterator();
         while (iter.hasNext()){ 
             GameObject nxt = iter.getNext();
             if(nxt instanceof Cat){
                 Cat cat = (Cat)nxt;
                 Point pCatCmpRelPrnt = new Point(this.getX(),this.getY());
                 cat.draw(g, pCatCmpRelPrnt);
             } 
             if(nxt instanceof Dog){ 
                 Dog dog = (Dog)nxt;
                 Point pDogCmpRelPrnt = new Point(this.getX(),this.getY());
                 dog.draw(g, pDogCmpRelPrnt);
             } 
             if(nxt instanceof Net){ 
                 Net net = (Net)nxt;
                 Point pNetCmpRelPrnt = new Point(this.getX(),this.getY());
                 net.draw(g, pNetCmpRelPrnt);
             } 
 

         } 
 

     }
}
