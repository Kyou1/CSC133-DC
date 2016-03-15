package com.mycompany.a1;

import java.util.ArrayList;
import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class GameWorld extends GameObject {
	private ArrayList<GameObject> gameObjectsList;
	private int dogNum = 3, catNum = 2;
	private int dogQty, catQty;

	private Net net;
	private Dog dog;
	private Cat cat;
	static int gameSizeWidth = 1000;
	static int gameSizeHeight = 610;
	Random rand = new Random();

	public GameWorld() {
		dog = new Dog();
		cat = new Cat();
		net = new Net();
	}

	public void initLayout() {
		gameObjectsList = new ArrayList<>();

		generateDog();
		generateCat();
		generateNet();

		for (GameObject list : gameObjectsList) {
			System.out.println(list);
		}
	}

	public void generateDog() {
		for (int i = 0; i < dogNum; i++) {
			dogQty++;
			dog = new Dog();
			dog.setLocation(rand.nextInt(gameSizeWidth), rand.nextInt(gameSizeHeight));
			dog.setSize(rand.nextInt(50 - 20) + 20);
			dog.setDirection(rand.nextInt(360));
			dog.setSpeed(5);
			dog.setColor(dog.getColor());
			gameObjectsList.add(dog);
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
			cat.setColor(cat.getColor());
			gameObjectsList.add(cat);
		}
	}

	public void generateNet() {
		net.setLocation(rand.nextInt(gameSizeWidth), rand.nextInt(gameSizeHeight));
		net.setSize(100);
		net.setColor(net.getColor());
		gameObjectsList.add(net);
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
		for (int i = gameObjectsList.size() - 1; i >= 0; i--) {
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
		}
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
		for (int i = gameObjectsList.size() - 1; i >= 0; i--) {
			if (gameObjectsList.get(i) instanceof Dog) {
				net.setLocation(dog.getLocationX(), dog.getLocationY());
			}
		}
	}

	public void JumpToCat() {
		for (int i = gameObjectsList.size() - 1; i >= 0; i--) {
			if (gameObjectsList.get(i) instanceof Cat) {
				net.setLocation(cat.getLocationX(), cat.getLocationY());
			}
		}
	}

	public void produceKitten() {
		catQty++;
		cat = new Cat();
		cat.setSpeed(5);
		for (int i = 0; i < gameObjectsList.size(); i++) {
			if (gameObjectsList.get(i) instanceof Cat) {
				cat.setLocation(cat.getLocationX() + (5), cat.getLocationY() + (5));
			}
		}
		cat.setDirection(rand.nextInt(360));
		gameObjectsList.add(cat);
	}

	public void fight() {
		int temp = rand.nextInt(gameObjectsList.size());
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

		}
	}

	public void gameTick() {
		for (int i = 0; i < gameObjectsList.size(); i++) {
			if (gameObjectsList.get(i) instanceof Animals) {
				((Animals) gameObjectsList.get(i)).move();
			}
		}
	}

	public void points() {
		int y = 0;
		for (int i = 0; i < gameObjectsList.size(); i++) {
			if (gameObjectsList.get(i) instanceof Dog) {
				int x = ((Dog) gameObjectsList.get(i)).getScratch();
				y += 10 - x;
			}

		}
		int a = catNum - catQty;
		int b = dogNum - dogQty;
		System.out.println("Current score: " + y);
		System.out.println("Number of Cats: " + catQty);
		System.out.println("Number of Dogs: " + dogQty);
		System.out.println("Number of Dogs Captured: " + b);
		System.out.println("Number of Cats Captured: " + a);
	}

	public void map() {
		for (GameObject list : gameObjectsList) {
			System.out.println(list);
		}
	}
}
