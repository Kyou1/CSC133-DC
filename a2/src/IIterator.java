package com.mycompany.a2;

public interface IIterator {
	boolean hasNext();
	Object getNext();
	public int getIndex();
	public Object objectAt(int i);
	public void remove();
}
