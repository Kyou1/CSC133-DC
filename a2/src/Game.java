package com.mycompany.a2;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.GridLayout;

@SuppressWarnings("unused")
public class Game extends Form {
	private GameWorld gameWorld;
	private MapView mapView;
	private ScoreView scoreView;

	public Game() {
		gameWorld = new GameWorld();
		mapView = new MapView();
		scoreView = new ScoreView();
		
		gameWorld.init();
		//play();
		
		gameWorld.addObserver(mapView);
		gameWorld.addObserver(scoreView);
		gameWorld.notifyObservers();
		
		this.setLayout(new BorderLayout());
		
		Container topContainer = new Container(new GridLayout(2,3));
		topContainer.add(new Label("Sidebar"))
					.add(new Label("Dog Catcher Game"))
					.add(new Label("Help?"));
		topContainer.add(scoreView);
		this.add(BorderLayout.NORTH, topContainer);
		
		Label myLabel2 = new Label("South");
		this.add(BorderLayout.SOUTH, myLabel2);
		
		Label myLabel3 = new Label("East");
		this.add(BorderLayout.EAST, myLabel3);
		
		Label myLabel4 = new Label("West");
		this.add(BorderLayout.WEST, myLabel4);
		
		Label myLabel5 = new Label("Center");
		this.add(BorderLayout.CENTER, myLabel5);
		
		this.show();
	} // Game constructor


/*	private void play() {
		Label menuLabel = new Label("Enter a command: ");
		this.add(menuLabel);
		final TextField myTextField = new TextField();
		this.add(myTextField);
		this.show();

		myTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String sCommand = myTextField.getText().toString();
				myTextField.clear();

				switch (sCommand.charAt(0)) {
				case 'e':
					gw.netExpand();
					break;
				case 'c':
					gw.netContract();
					break;
				case 's':
					gw.scoop();
					break;
				case 'r':
					gw.moveRight();
					break;
				case 'l':
					gw.moveLeft();
					break;
				case 'u':
					gw.moveUp();
					break;
				case 'd':
					gw.moveDown();
					break;
				case 'o':
					gw.JumpToDog();
					break;
				case 'a':
					gw.JumpToCat();
					break;
				case 'k':
					gw.produceKitten();
					break;
				case 'f':
					gw.fight();
					break;
				case 't':
					gw.gameTick();
					break;
				case 'p':
					gw.points();
					break;
				case 'm':
					gw.map();
					break;
				case 'q':
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Command! Please enter again.");
				} // switch
			} // actionPerformed
		} // NewActionListener()
		); // addActionListener
	} // play
*/} // Game class
