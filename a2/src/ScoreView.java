package com.mycompany.a2;

import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.GridLayout;

@SuppressWarnings("unused")
public class ScoreView extends Container implements IObserver {

	private Label totalScore;
	private Label capturedDogs;
	private Label capturedCats;
	private Label remainingDogs;
	private Label remainingCats;
	private Label sound;
	
	
	public ScoreView() {
		Container scoreContainer = new Container();
		totalScore = new Label();
		scoreContainer.add(totalScore);
		capturedDogs = new Label();
		scoreContainer.add(capturedDogs);
		capturedCats = new Label();
		scoreContainer.add(capturedCats);
		remainingDogs = new Label();
		scoreContainer.add(remainingDogs);
		remainingCats = new Label();
		scoreContainer.add(remainingCats);
		sound = new Label();
		scoreContainer.add(sound);
		
		this.setVisible(true);
	}

	@Override
	public void update(IObservable o) {
		// TODO Auto-generated method stub
		totalScore.setText("   Total Score: " + ((GameWorld) o).getTotalScore());
		capturedDogs.setText("   Dogs Captured: " + ((GameWorld) o).getCaughtDogs());
		capturedCats.setText("   Cats Captured: " + ((GameWorld) o).getCaughtCats());
		remainingDogs.setText("   Remaining Dogs: " + ((GameWorld) o).getRemainingDogs());
		remainingCats.setText("   Remaining Cats: " + ((GameWorld) o).getRemainingCats());
		
		this.setVisible(true);
	}
}
