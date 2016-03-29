package com.mycompany.a2;

import java.util.Random;
import java.util.Vector;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;

public class GameWorld implements IObservable {
	
	private static GameObjectCollection objects;
	private Vector<Object> observerArray = new Vector<>();
	
	private int dogNum = new Integer(3), catNum = new Integer(2);
	private int dogQty, catQty;
	private int totalScore = new Integer(0);
	private int clockTick;
	private int caughtCats, catsRemaining, caughtDogs, dogsRemaining;

	private Net net;
	private Dog dog;
	private Cat cat;
	//private boolean sound;
	static int gameSizeWidth = Display.getInstance().getDisplayWidth();
	static int gameSizeHeight = Display.getInstance().getDisplayHeight();
	Random rand = new Random();

	public GameWorld() {
		objects = new GameObjectCollection();
		dog = new Dog();
		cat = new Cat();
		net = new Net();
	}

	public void init() {
		
		generateDog();
		generateCat();
		generateNet();
	}

	public void generateDog() {
		for (int i = 0; i < dogNum; i++) {
			dogQty++;
			dog = new Dog();
			dog.setLocation(rand.nextInt(gameSizeWidth), rand.nextInt(gameSizeHeight));
			dog.setSize(rand.nextInt(50 - 20) + 20);
			dog.setDirection(rand.nextInt(360));
			dog.setSpeed(5);
			dog.setColor(rand.nextInt(255));
			objects.add(dog);
		}
	}

	public void generateCat() {
		for (int i = 0; i < catNum; i++) {
			catQty++;
			cat = new Cat();
			cat.setLocation(rand.nextInt(gameSizeWidth), rand.nextInt(gameSizeHeight));
			cat.setSize(rand.nextInt(50 - 20) + 20);
			cat.setDirection(rand.nextInt(360));
			cat.setSpeed(5);
			cat.setColor(rand.nextInt(255));
			objects.add(cat);
		}
	}

	public void generateNet() {
		net.setLocation(rand.nextInt(gameSizeWidth), rand.nextInt(gameSizeHeight));
		net.setSize(100);
		net.setColor(rand.nextInt(255));
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
						&& ((Cat) currentObject).getLocationX() > netBottom
						&& ((Cat) currentObject).getLocationX() < netTop) {
					
					System.out.println("Cat caught");
					
					caughtCats++;
					catQty--;
					
					iterator.remove();
				} // end if
			} // end if Cat
			else if (currentObject instanceof Dog) {
				if (((Dog) currentObject).getLocationX() > netLeft
						&& ((Dog) currentObject).getLocationX() < netRight
						&& ((Dog) currentObject).getLocationX() > netBottom
						&& ((Dog) currentObject).getLocationX() < netTop) {
					
					System.out.println("Dog caught");
					
					caughtDogs++;
					dogQty--;
					
					iterator.remove();
					
					if (dogQty == 0 ) {
						System.out.println("*** Game over! ***");
						points();
						System.exit(0);
					} // end if
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
	}

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
		while(((IIterator) objects).hasNext()) {
			if (((IIterator) objects).getNext() instanceof Dog) {
				net.setLocation(dog.getLocationX(), dog.getLocationY());
			}
		}
	}

	public void JumpToCat() {
		while(((IIterator) objects).hasNext()) {
			if (((IIterator) objects).getNext() instanceof Cat) {
				net.setLocation(cat.getLocationX(), cat.getLocationY());
			}
		}
	}

	public void produceKitten() {
		catQty++;
		cat = new Cat();
		cat.setSpeed(5);
		cat.setColor(ColorUtil.BLACK);
		//while(((IIterator) objects).hasNext()) {
		//	if (((IIterator) objects).getNext() instanceof Cat)  {
				cat.setLocation(cat.getLocationX() + 5, cat.getLocationY() + 5);
		//	}
		//}
		cat.setDirection(rand.nextInt(360));
		objects.add(cat);
	}

	public void fight() {
		Vector<Object> listOfDogs = new Vector<Object>();
		IIterator iterator = objects.getIterator();
		
		while(iterator.hasNext()) {
			if (iterator.getNext() instanceof Dog) {
				listOfDogs.add(iterator.getIndex());
			} // end if
		} // end while
		
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

	public void gameTick() {
		
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
/*		for (int i = 0; i < gameObjectsList.size(); i++) {
			if (gameObjectsList.get(i) instanceof Animals) {
				((Animals) gameObjectsList.get(i)).move();
			}
		}*/
	}

	public void points() {
/*		int y = 0;
		for (int i = 0; i < gameObjectsList.size(); i++) {
			if (gameObjectsList.get(i) instanceof Dog) {
				int x = ((Dog) gameObjectsList.get(i)).getScratch();
				y += 10 - x;
			}

		}*/
		int a = catNum - catQty;
		int b = dogNum - dogQty;
		System.out.println("Current score: ");
		System.out.println("Number of Cats: " + catQty);
		System.out.println("Number of Dogs: " + dogQty);
		System.out.println("Number of Dogs Captured: " + b);
		System.out.println("Number of Cats Captured: " + a);
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
	
	public void quit() {
		System.out.println("Game ended.");
		System.exit(0);
	}
	
	public int getTotalScore() {
		return totalScore;
	}
	
	public int getCaughtCats() {
		return caughtCats;
	}
	
	public int getCaughtDogs() {
		return caughtDogs;
	}
	
	public int getRemainingCats() {
		return catsRemaining;
	}
	
	public int getRemainingDogs() {
		return dogsRemaining;
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
	
/*	public void soundOn() {
		sound = true;
		notifyObservers();
	}
	
	public void soundOff() {
		sound = false;
		notifyObservers();
	}
	
	public void soundToggle(){
		if(sound){
			sound = false;
		}else{
			sound = true;
		}
		notifyObservers();
	}
	
	public boolean isSoundOn() {
		return sound;
	}*/
}
