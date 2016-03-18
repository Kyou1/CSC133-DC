package com.mycompany.a2;

import com.codename1.ui.Container;

public class MapView extends Container implements IObserver{
	
	public MapView() {

	}
	
	public void update(IObservable o) {
		if(o instanceof GameWorld)
			((GameWorld)o).printMap();
	}

}
