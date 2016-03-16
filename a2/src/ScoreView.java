package com.mycompany.a2;

import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.GridLayout;

public class ScoreView extends Container implements IObserver {

	Label totalScore;
	
	
	public ScoreView() {
		Container scoreContainer = new Container();
		scoreContainer.add(totalScore);
	}

	@Override
	public void update(IObservable o) {
		// TODO Auto-generated method stub
		totalScore = new Label("   Total Score: " + ((GameWorld) o).getTotalScore());
		
		this.setVisible(true);
	}
}
