package com.mycompany.a3;

import java.util.Collection;
import java.util.Random;
import java.util.Vector;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;

public class GameWorld implements IObservable{
	
	private static GameObjectCollection objects;
	private Vector<Object> observerArray = new Vector<>();
	private Vector<Animals> collisionArray = new Vector<>();
	
	@SuppressWarnings("rawtypes")
	Collection start;
	
	private int dogNum, catNum;
	private int dogQty, catQty;
	private int totalScore = new Integer(0);
	private int clockTick;
	private int currentTime;
	private int caughtCats, catsRemaining, caughtDogs, dogsRemaining;

	private int initCat;
	private int popCat;
	private int initDog;
	private int popDog;
	
	private Net net;
	private Dog dog;
	private Cat cat;
	static int gameSizeWidth = Display.getInstance().getDisplayWidth();
	static int gameSizeHeight = Display.getInstance().getDisplayHeight();

	private Sounds sounds;
	private boolean sound = false;
	
	Random rand = new Random();

	public int getInitDog() {
		return initDog;
	}
	
	public void setInitDog(int initDog) {
		this.initDog = initDog;
		notifyObservers();
	}
	
	public int getInitCat() {
		return initCat;
	}
	
	public void setInitCat(int initCat) {
		this.initCat = initCat;
		notifyObservers();
	}
	
	public void setDogsCaught(int caughtDogs) {
		this.caughtDogs = caughtDogs;
		notifyObservers();
	}

	public void setCatsCaught(int caughtCats) {
		this.caughtCats = caughtCats;
		notifyObservers();
	}
	
	public void setCatsRemaining(int catsRemaining) {
		this.catsRemaining = catsRemaining;
	}
	
	public void setDogsRemaining(int dogsRemaining) {
		this.dogsRemaining = dogsRemaining;
	}
	
	public int getCatsRemaining() {
		return catsRemaining;
	}
	
	public int getDogsRemaining() {
		return dogsRemaining;
	}

	public GameWorld() {
		objects = new GameObjectCollection();
		dog = new Dog();
		cat = new Cat();
		net = new Net();
	}

	public void init() {
		
		setInitDog(rand.nextInt(7) + 3);
		setInitCat(rand.nextInt(7) + 3);
		
		generateDog();
		generateCat();
		generateNet();
	}

	public void generateDog() {
		for (int i = 0; i < getInitDog(); i++) {
			//dogQty++;
			dog = new Dog();
			dog.setLocation(rand.nextInt(gameSizeWidth), rand.nextInt(gameSizeHeight));
			dog.setSize(rand.nextInt(50 - 20) + 20);
			dog.setDirection(rand.nextInt(360));
			dog.setSpeed(5);
			dog.setColor(ColorUtil.BLACK);
			objects.add(dog);
		}
	}

	public void generateCat() {
		for (int i = 0; i < getInitCat(); i++) {
			//catQty++;
			cat = new Cat();
			cat.setLocation(rand.nextInt(gameSizeWidth), rand.nextInt(gameSizeHeight));
			cat.setSize(rand.nextInt(50 - 20) + 20);
			cat.setDirection(rand.nextInt(360));
			cat.setSpeed(5);
			cat.setColor(ColorUtil.YELLOW);
			objects.add(cat);
		}
	}

	public void generateNet() {
		net.setLocation(rand.nextInt(gameSizeWidth), rand.nextInt(gameSizeHeight));
		net.setSize(100);
		net.setColor(ColorUtil.BLUE);
		objects.add(net);
	}

	public void netExpand() {
		int x = net.getSize();
		if (x < 500) {
			net.setSize(x + 1);
		}
	}

	public void netContract() {
		int x = net.getSize();
		if (x > 50) {
			net.setSize(x - 1);
		}
	}

	public void scoop() {
		float netTop = net.getLocationY() - (net.getSize()/2);
		float netBottom = net.getLocationY() + (net.getSize()/2);
		float netLeft = net.getLocationX() - (net.getSize()/2);
		float netRight = net.getLocationX() + (net.getSize()/2);
		
		IIterator iterator = objects.getIterator();
		Object currentObject;
		
		while(iterator.hasNext()) {
			currentObject = iterator.getNext();
			if( currentObject instanceof Cat ) {
				if(((Cat) currentObject).getLocationX() > netLeft
						&& ((Cat) currentObject).getLocationX() < netRight
						&& ((Cat) currentObject).getLocationY() > netBottom
						&& ((Cat) currentObject).getLocationY() < netTop) {
					
					System.out.println("Cat caught");
					
					setCatsRemaining(getCatsRemaining()+1);
					setInitCat(getInitCat()-1);
					setCatsCaught(getCatsRemaining());
					iterator.remove();
				} // end if
			} // end if Cat
			else if (currentObject instanceof Dog) {
				if (((Dog) currentObject).getLocationX() > netLeft
						&& ((Dog) currentObject).getLocationX() < netRight
						&& ((Dog) currentObject).getLocationY() > netBottom
						&& ((Dog) currentObject).getLocationY() < netTop) {
					
					System.out.println("Dog caught");
					
					setDogsRemaining(getDogsRemaining()+1);
					setInitDog(getInitDog()-1);
					setDogsCaught(getDogsRemaining());
					iterator.remove();
				} // end if dog
			} // if Dog
		} // end while
		notifyObservers();
/*		for (int i = gameObjectsList.size() - 1; i >= 0; i--) {
			if ((gameObjectsList.get(i).getLocationX() >= net.getLocationX() - (net.getSize() / 2))
					&& (gameObjectsList.get(i).getLocationX() <= net.getLocationX() + (net.getSize() / 2))
					&& (gameObjectsList.get(i).getLocationY() <= net.getLocationY() + (net.getSize() / 2))
					&& (gameObjectsList.get(i).getLocationY() >= net.getLocationY() - ((net.getSize() / 2)))) {

				if (gameObjectsList.get(i) instanceof Cat) {
					catQty--;
					gameObjectsList.remove(i);
				}

				if (gameObjectsList.get(i) instanceof Dog) {
					dogQty--;
					gameObjectsList.remove(i);
				}
			}
		}*/
	} // end scoop function

	public void moveRight() {
		net.moveRight();
	}

	public void moveLeft() {
		net.moveLeft();
	}

	public void moveUp() {
		net.moveUp();
	}

	public void moveDown() {
		net.moveDown();
	}

	public void JumpToDog() {
		IIterator iterator = objects.getIterator();
		Object currentObject;
		
		while(iterator.hasNext()) {
			currentObject = iterator.getNext();
			if (currentObject instanceof Dog) {
				net.setLocation(dog.getLocationX(), dog.getLocationY());
			}
		}
	}

	public void JumpToCat() {
		
		IIterator iterator = objects.getIterator();
		Object currentObject;
		
		while(iterator.hasNext()) {
			currentObject = iterator.getNext();
			if (currentObject instanceof Cat) {
				net.setLocation(cat.getLocationX(), cat.getLocationY());
			}
		}
	}

	public void produceKitten() {
		if(getInitCat() < 30 ) {
			cat = new Cat();
			cat.setSpeed(5);
			cat.setColor(ColorUtil.BLACK);
			cat.setLocation(rand.nextInt(), rand.nextInt());			
			cat.setSize(rand.nextInt(30) + 20);
			cat.setDirection(rand.nextInt(360));
			objects.add(cat);
			setInitCat(getInitCat() + 1);
			notifyObservers();
		}
	}

	public void fight() {
		Vector<Object> listOfDogs = new Vector<Object>();
		IIterator iterator = objects.getIterator();
		
		while(iterator.hasNext()) {
			if (iterator.getNext() instanceof Dog) {
				listOfDogs.add(iterator.getIndex());
			} // end if
		} // end while
		notifyObservers();
/*		int temp = rand.nextInt(gameObjectsList.size());
		while (!(gameObjectsList.get(temp) instanceof Dog)) {
			temp = rand.nextInt(gameObjectsList.size());
		}

		int x = ((Dog) gameObjectsList.get(temp)).getScratch();
		if (x < 5) {
			int brighterRed = ColorUtil.rgb(200, 0, 0);
			int speed = ((Dog) gameObjectsList.get(temp)).getSpeed();
			((Dog) gameObjectsList.get(temp)).setSpeed(speed - 1);
			gameObjectsList.get(temp).setColor(brighterRed);
			((Dog) gameObjectsList.get(temp)).setScratch(x + 1);

		}*/
	} // end fight

	public void gameTick(int width, int height) {
		
		clockTick = clockTick + 1;
		
		IIterator iterator = objects.getIterator();
		Object currentObjects;
		
		while(iterator.hasNext()) {
			currentObjects = iterator.getNext();
			if(currentObjects instanceof Animals) {
				((Animals) currentObjects).move();
			}
		}
		notifyObservers();
		
		collision();
			
		if(currentTime+20 < clockTick){
			for(int i = 0; i < collisionArray.size(); i++){
				collisionArray.remove(i);
			}
		}
/*		for (int i = 0; i < gameObjectsList.size(); i++) {
			if (gameObjectsList.get(i) instanceof Animals) {
				((Animals) gameObjectsList.get(i)).move();
			}
		}*/
	}

	private void collision() {
		Object firstObject;
		Object secondObject;
		int intNum;
		
		IIterator iterate1 = objects.getIterator();
		while(iterate1.hasNext()){
			firstObject = iterate1.getNext();
			
			if(firstObject instanceof Dog){
				Dog dog = (Dog) firstObject;
				IIterator iterate2 = objects.getIterator();
				while(iterate2.hasNext()){
					secondObject = iterate2.getNext();
					if(secondObject instanceof Cat){
						Cat cat = (Cat) secondObject;
						if(dog.collidesWith(cat) && !collisionCheck(dog)){
							currentTime = clockTick;
							dog.handleCollision(dog, this);
							addCollision(dog);
						}
					}
				}
			}
			
			if(firstObject instanceof Cat){

			}
		}
	}//end collision function
	
	public boolean collisionCheck(Animals c) {
		for(int i = 0; i < collisionArray.size(); i++){
			if(collisionArray.get(i)==c){
				return true;
			}
		}
		return false;
	}
	
	public void addCollision(Animals cat) {
		collisionArray.add(cat);
	}
	
	public void healDogs() {
		IIterator iterator = objects.getIterator();
		Object currentObjects;
		while(iterator.hasNext()){
			currentObjects = iterator.getNext();
			if(currentObjects instanceof Dog && ((Dog)currentObjects).isSelected()){
				((Dog) currentObjects).setSelected(false);
				((Dog) currentObjects).resetScratches();
				((Dog) currentObjects).setSpeed(5);
				((Dog) currentObjects).setColor(ColorUtil.BLACK);
				notifyObservers();				
			}
		}
	}

	public void points() {
/*		int y = 0;
		for (int i = 0; i < gameObjectsList.size(); i++) {
			if (gameObjectsList.get(i) instanceof Dog) {
				int x = ((Dog) gameObjectsList.get(i)).getScratch();
				y += 10 - x;
			}

		}*/
		int catsCaptured = initCat - catQty;
		int dogsCaptured = initDog - dogQty;
		System.out.println("Current score: ");
		System.out.println("Number of Cats: " + catQty);
		System.out.println("Number of Dogs: " + dogQty);
		System.out.println("Number of Dogs Captured: " + dogsCaptured);
		System.out.println("Number of Cats Captured: " + catsCaptured);
	}

	public void printMap() {
		IIterator iterator = objects.getIterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.getNext().toString());
		} // end while
/*		for (GameObject list : gameObjectsList) {
			System.out.println(list);
		}*/
	} // end while
	
	public GameObjectCollection getGameObjectCollection() {
		return objects;
	}
	
	public void setStart(Collection start){
		this.start = start;
	}
	
	public Collection getStart(){
		return start;
	}
	
	
	public void quit() {
		System.out.println("Game ended.");
		System.exit(0);
	}
	
	public int getTotalScore() {
		
		IIterator iterator = objects.getIterator();
		Object currentObject;
		
		while(iterator.hasNext()) {
			currentObject = iterator.getNext();
			if (currentObject instanceof Dog) {
				totalScore += 10;
			}
		}
		totalScore -= (10* getDogsRemaining());
		return totalScore;
	}
	
	@Override
	public void addObserver(IObserver obs) {
		observerArray.add(obs);	
	}

	@Override
	public void notifyObservers() {
		if(!observerArray.isEmpty()) {
			for(int i = 0; i < observerArray.size(); i++) {
				((IObserver) observerArray.get(i)).update(this);
			} // end for
		} // end if
	} // end notifyObservers
	
	public void soundOn() {
		sound = true;
		notifyObservers();
	}
	
	public void soundOff() {
		sound = false;
		sounds.stopBackGroundClip();
		notifyObservers();
	}
	
	public void soundToggle(){
		sound = !sound;
		notifyObservers();
	}
	
	public boolean getSoundStatus(){
		return sound;
	}
	
	public boolean isSoundOn() {
		return sound;
	}

	public void toggleSound() {
		// TODO Auto-generated method stub
		
	}

	public int getCaughtDogs() {
		// TODO Auto-generated method stub
		return caughtDogs;
	}

	public int getCaughtCats() {
		// TODO Auto-generated method stub
		return caughtCats;
	}

}
