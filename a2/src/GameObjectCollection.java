package com.mycompany.a2;

import java.util.Vector;

public class GameObjectCollection implements ICollection {

	private Vector<Object> collection;
	
	public GameObjectCollection() {
		collection = new Vector<Object>();
	}

	public void add(Object newObject) {
		collection.addElement(newObject);
		// TODO Auto-generated method stub
	}

	public IIterator getIterator() {
		// TODO Auto-generated method stub
		return new GameObjectIterator();
	}
	
	private class GameObjectIterator implements IIterator {

		private int currentIndex;
		
		public GameObjectIterator() {
			currentIndex = -1;
		}
		
		@Override
		public boolean hasNext() {
			if(collection.size() <= 0){
				return false;
			}
			if(currentIndex == collection.size() - 1){
				return false;
			}
			return true;
		}

		@Override
		public Object getNext() {
			currentIndex++;
			return(collection.elementAt(currentIndex));
		}

		@Override
		public void remove() {
			collection.remove(currentIndex);
		}

		@Override
		public int getIndex() {
			return currentIndex;
		}

		@Override
		public Object objectAt(int i) {
			return collection.get(i);
		}
		
	} // end GameObjectIterator
	
} // end GameObjectCollection
