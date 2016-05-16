package com.mycompany.a3;

public interface ICollider {
	boolean collidesWith(GameObject anotherObject);
	void handleCollision(GameObject anotherObject, GameWorld gw);
}
