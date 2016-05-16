package com.mycompany.a3;

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
		try {

		totalScore = new Label();
		capturedDogs = new Label();
		capturedCats = new Label();
		remainingDogs = new Label();
		remainingCats = new Label();
		sound = new Label();
		
		this.add(totalScore)
			.add(capturedDogs)
			.add(capturedCats)
			.add(remainingDogs)
			.add(remainingCats)
			.add(sound);
		
		} catch (NullPointerException e1) {
			
		}
		this.setVisible(true);
	}

	@Override
	public void update(IObservable o) {
		// TODO Auto-generated method stub
		totalScore.setText("   Total Score: " + ((GameWorld) o).getTotalScore());
		capturedDogs.setText("   Dogs Captured: " + ((GameWorld) o).getCaughtDogs());
		capturedCats.setText("   Cats Captured: " + ((GameWorld) o).getCaughtCats());
		remainingDogs.setText("   Remaining Dogs: " + ((GameWorld) o).getDogsRemaining());
		remainingCats.setText("   Remaining Cats: " + ((GameWorld) o).getCatsRemaining());
		
		if(((GameWorld) o).isSoundOn()){
			sound.setText("   Sound: ON");
		}else{
			sound.setText("   Sound: OFF");
		}
		
		this.setVisible(true);
	}
}
