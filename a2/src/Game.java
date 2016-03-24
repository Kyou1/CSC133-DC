package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
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
			this.setTitle("Dog Catcher");
			
			Toolbar sideMenuToolbar = new Toolbar();
			setToolbar(sideMenuToolbar);
			Command sideMenuItem1 = new Command("Command 1");
			sideMenuToolbar.addCommandToSideMenu(sideMenuItem1);
			Command sideMenuItemHelp = new Command("Help?");
			sideMenuToolbar.addCommandToRightBar(sideMenuItemHelp);
			
			Container topContainer = new Container(new GridLayout(1,8));
			topContainer.addComponent(scoreView);
			this.add(BorderLayout.NORTH, topContainer);
			

			Container bottomContainer = new Container(new FlowLayout());
			Button kittenMenuButton = new Button("Kitten");
			Button fightMenuButton = new Button("Fight");
			Button tickMenuButton = new Button("Tick");
			kittenMenuButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
			bottomContainer.addComponent(kittenMenuButton);
			bottomContainer.add(fightMenuButton);
			bottomContainer.add(tickMenuButton);
			this.add(BorderLayout.SOUTH, bottomContainer);
			
			Container leftContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
			Button expandMenuButton = new Button("Expand");
			Button upMenuButton = new Button("Up");
			Button leftMenuButton = new Button("Left");
			Button jumpToDogMenuButton = new Button("JumpToDog");
			leftContainer.addComponent(expandMenuButton);
			leftContainer.add(upMenuButton);
			leftContainer.add(leftMenuButton);
			leftContainer.add(jumpToDogMenuButton);
			this.add(BorderLayout.WEST, leftContainer);
			

			Container rightContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
			Button contractMenuButton = new Button("Contract");
			Button downMenuButton = new Button("Down");
			Button rightMenuButton = new Button("Right");
			Button jumpToCatMenuButton = new Button("JumpToCat");
			Button scoopMenuButton = new Button("Scoop");
			rightContainer.addComponent(contractMenuButton);
			rightContainer.add(downMenuButton);
			rightContainer.add(rightMenuButton);
			rightContainer.add(jumpToCatMenuButton);
			rightContainer.add(scoopMenuButton);
			this.add(BorderLayout.EAST, rightContainer);
			

			Container centerContainer = new Container(new BorderLayout());
			//centerContainer.addComponent(mapView);
			this.add(BorderLayout.CENTER, centerContainer);
			
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
