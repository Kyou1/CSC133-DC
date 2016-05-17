package com.mycompany.a3;

import java.util.*;

import com.codename1.charts.util.ColorUtil;
import com.codename1.components.SpanButton;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.animations.Timeline;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Point;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;


@SuppressWarnings("unused")
public class Game extends Form implements ActionListener, Runnable {
	private GameWorld gameWorld;
	private MapView mapView;
	private ScoreView scoreView;
	private UITimer timer;
	
	private Button pauseButton; 
	private boolean isGamePaused; 
	private Point curMouse = null; 
	private Point startMouse = null; 
		 
	private CommandTick   	tickCommand 	= CommandTick.getInstance(); 
	private CommandContract	contractCommand	= CommandContract.getInstance(); 
	private CommandDown 	downCommand 	= CommandDown.getInstance(); 
	private CommandExpand 	expandCommand 	= CommandExpand.getInstance(); 
	private CommandLeft 	leftCommand 	= CommandLeft.getInstance(); 
	private CommandRight 	rightCommand 	= CommandRight.getInstance(); 
	private CommandScoop 	scoopCommand 	= CommandScoop.getInstance(); 
	private CommandHeal 	healCommand 	= CommandHeal.getInstance(); 
	private CommandUp 		upCommand 		= CommandUp.getInstance(); 


	public Game() {
		try {
			gameWorld = new GameWorld();
			mapView = new MapView();
			scoreView = new ScoreView();
		
			gameWorld.init();
			//play();
		
			Form dc = new Form("Dog Catcher");
			this.setLayout(new BorderLayout());
			this.setTitle("Dog Catcher");
			
			Toolbar sideMenuToolbar = new Toolbar();
			sideMenuToolbar.getAllStyles().setPadding(20, 0, 0, 0);
			sideMenuToolbar.getAllStyles().setBgColor(ColorUtil.BLUE);
			sideMenuToolbar.getAllStyles().setFgColor(ColorUtil.WHITE);
			setToolbar(sideMenuToolbar);
			
			Button sideMenuScoop = new Button("Scoop");
			sideMenuScoop.setCommand(CommandScoop.getInstance());
			
			sideMenuToolbar.addComponentToSideMenu(sideMenuScoop);
			Command sideMenuSound = new Command("Sound") {
				public void actionPerformed(ActionEvent e) {
					try {
						System.out.println("SOUND");
						//gameWorld.sound();
					} catch (NullPointerException e1) {
						
					}
				}
			};
			
			sideMenuToolbar.addCommandToSideMenu(sideMenuSound);
			Command sideMenuAbout = new Command("About") {
				public void actionPerformed(ActionEvent e) {
					try {
						Dialog.show("ABOUT ME", " Author: Clyde Pabro \n Class: CSC 133 \n Spring 2016 \n Version: 1.0.0.1", "OK", null);
					} catch (NullPointerException e1) {
						
					}
				}
			};
			sideMenuToolbar.addCommandToSideMenu(sideMenuAbout);
			
			Button sideMenuExit = new Button("Exit");
			sideMenuExit.setCommand(CommandQuit.getInstance());
			sideMenuExit.keyPressed('x');
			sideMenuToolbar.addComponentToSideMenu(sideMenuExit);
			
			Command sideMenuItemHelp = new Command("Help?") {
				public void actionPerformed(ActionEvent e) {
					try {
						Dialog.show("KEYBOARD COMMANDS", 
									" e - expand net \n"
									+ " c - contract net \n"
									+ " s - scoop net \n"
									+ " r - move net right \n"
									+ " l - move net left \n"
									+ " u - move net up \n"
									+ " d - move net down \n"
									+ " o - options \n"
									+ " a - about \n"
									+ " k - add kitten \n"
									+ " f - fight \n"
									+ " t - tick up \n"
									+ " q - quit program \n", 
									"PRESS RETURN TO QUIT", null);
					} catch (NullPointerException e1) {
						
					}
				}
			};
			sideMenuToolbar.addCommandToRightBar(sideMenuItemHelp);
			
			Container topContainer = new Container(new GridLayout(1,1));
			//topContainer.setLayout(new FlowLayout(Component.CENTER));
			topContainer.getAllStyles().setPadding(0,0,180,0);
			topContainer.getAllStyles().setBgTransparency(255);
			topContainer.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.GRAY));
			//topContainer.getAllStyles().setBgColor(ColorUtil.GRAY);
			topContainer.getAllStyles().setFgColor(ColorUtil.BLUE);
			topContainer.add(scoreView);
			this.add(BorderLayout.NORTH, topContainer);
			
			Container bottomContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
			bottomContainer.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.GRAY));
			bottomContainer.setLayout(new FlowLayout(Component.CENTER));
			
/*			Button kittenMenuButton = new Button("Kitten");
			Button fightMenuButton = new Button("Fight");
			Button tickMenuButton = new Button("Tick");

			kittenMenuButton.setCommand(CommandKitten.getInstance());
			kittenMenuButton.keyPressed('k');
			kittenMenuButton.getAllStyles().setPadding(20,20,20,20);
			kittenMenuButton.getAllStyles().setBgTransparency(255);
			kittenMenuButton.getAllStyles().setBgColor(ColorUtil.BLUE);
			kittenMenuButton.getAllStyles().setFgColor(ColorUtil.WHITE);
			
			fightMenuButton.setCommand(CommandFight.getInstance());
			fightMenuButton.keyPressed('f');
			fightMenuButton.getAllStyles().setPadding(20,20,20,20);
			fightMenuButton.getAllStyles().setBgTransparency(255);
			fightMenuButton.getAllStyles().setBgColor(ColorUtil.BLUE);
			fightMenuButton.getAllStyles().setFgColor(ColorUtil.WHITE);
			
			tickMenuButton.setCommand(CommandTick.getInstance());
			tickMenuButton.keyPressed('t');
			tickMenuButton.getAllStyles().setPadding(20,20,20,20);
			tickMenuButton.getAllStyles().setBgTransparency(255);
			tickMenuButton.getAllStyles().setBgColor(ColorUtil.BLUE);
			tickMenuButton.getAllStyles().setFgColor(ColorUtil.WHITE);

			bottomContainer.add(kittenMenuButton);
			bottomContainer.add(fightMenuButton);
			bottomContainer.add(tickMenuButton);*/
			
			Button healMenuButton = new Button("Heal");
			Button pauseMenuButton = new Button("Pause");

			healMenuButton.setCommand(CommandHeal.getInstance());
			healMenuButton.keyPressed('h');
			healMenuButton.getAllStyles().setPadding(20,20,20,20);
			healMenuButton.getAllStyles().setBgTransparency(255);
			healMenuButton.getAllStyles().setBgColor(ColorUtil.BLUE);
			healMenuButton.getAllStyles().setFgColor(ColorUtil.WHITE);
			
			pauseMenuButton.setCommand(CommandPause.getInstance());
			pauseMenuButton.keyPressed('p');
			pauseMenuButton.getAllStyles().setPadding(20,20,20,20);
			pauseMenuButton.getAllStyles().setBgTransparency(255);
			pauseMenuButton.getAllStyles().setBgColor(ColorUtil.BLUE);
			pauseMenuButton.getAllStyles().setFgColor(ColorUtil.WHITE);

			bottomContainer.add(healMenuButton);
			bottomContainer.add(pauseMenuButton);
			
			this.add(BorderLayout.SOUTH, bottomContainer);
			
			Container leftContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
			leftContainer.getAllStyles().setPadding(Component.TOP, 50);
			
			Button expandMenuButton = new Button("Expand");
			Button upMenuButton = new Button("Up");
			Button leftMenuButton = new Button("Left");
			Button jumpToDogMenuButton = new Button("JumpToDog");
			
			expandMenuButton.setCommand(CommandExpand.getInstance());
			expandMenuButton.keyPressed('e');
			expandMenuButton.getAllStyles().setPadding(20,20,20,20);
			expandMenuButton.getAllStyles().setBgTransparency(255);
			expandMenuButton.getAllStyles().setBgColor(ColorUtil.BLUE);
			expandMenuButton.getAllStyles().setFgColor(ColorUtil.WHITE);

			upMenuButton.setCommand(CommandUp.getInstance());
			upMenuButton.keyPressed('u');
			upMenuButton.getAllStyles().setPadding(20,20,20,20);
			upMenuButton.getAllStyles().setBgTransparency(255);
			upMenuButton.getAllStyles().setBgColor(ColorUtil.BLUE);
			upMenuButton.getAllStyles().setFgColor(ColorUtil.WHITE);
			
			leftMenuButton.setCommand(CommandLeft.getInstance());
			leftMenuButton.keyPressed('l');
			leftMenuButton.getAllStyles().setPadding(20,20,20,20);
			leftMenuButton.getAllStyles().setBgTransparency(255);
			leftMenuButton.getAllStyles().setBgColor(ColorUtil.BLUE);
			leftMenuButton.getAllStyles().setFgColor(ColorUtil.WHITE);
			
			jumpToDogMenuButton.setCommand(CommandJumpToDog.getInstance());
			jumpToDogMenuButton.keyPressed('o');
			jumpToDogMenuButton.getAllStyles().setPadding(20,20,20,20);
			jumpToDogMenuButton.getAllStyles().setBgTransparency(255);
			jumpToDogMenuButton.getAllStyles().setBgColor(ColorUtil.BLUE);
			jumpToDogMenuButton.getAllStyles().setFgColor(ColorUtil.WHITE);
			
			leftContainer.add(expandMenuButton);
			leftContainer.add(upMenuButton);
			leftContainer.add(leftMenuButton);
			leftContainer.add(jumpToDogMenuButton);
			
			this.add(BorderLayout.WEST, leftContainer);
			
			Container rightContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
			rightContainer.getAllStyles().setPadding(Component.TOP, 50);
			
			Button contractMenuButton = new Button("Contract");
			Button downMenuButton = new Button("Down");
			Button rightMenuButton = new Button("Right");
			Button jumpToCatMenuButton = new Button("JumpToCat");
			Button scoopMenuButton = new Button("Scoop");
			
			contractMenuButton.setCommand(CommandContract.getInstance());
			contractMenuButton.keyPressed('e');
			contractMenuButton.getAllStyles().setPadding(20,20,20,20);
			contractMenuButton.getAllStyles().setBgTransparency(255);
			contractMenuButton.getAllStyles().setBgColor(ColorUtil.BLUE);
			contractMenuButton.getAllStyles().setFgColor(ColorUtil.WHITE);
			
			downMenuButton.setCommand(CommandDown.getInstance());
			contractMenuButton.keyPressed('d');
			downMenuButton.getAllStyles().setPadding(20,20,20,20);
			downMenuButton.getAllStyles().setBgTransparency(255);
			downMenuButton.getAllStyles().setBgColor(ColorUtil.BLUE);
			downMenuButton.getAllStyles().setFgColor(ColorUtil.WHITE);
			
			rightMenuButton.setCommand(CommandRight.getInstance());
			rightMenuButton.keyPressed('r');
			rightMenuButton.getAllStyles().setPadding(20,20,20,20);
			rightMenuButton.getAllStyles().setBgTransparency(255);
			rightMenuButton.getAllStyles().setBgColor(ColorUtil.BLUE);
			rightMenuButton.getAllStyles().setFgColor(ColorUtil.WHITE);
			
			jumpToCatMenuButton.setCommand(CommandJumpToCat.getInstance());
			jumpToCatMenuButton.keyPressed('a');
			jumpToCatMenuButton.getAllStyles().setPadding(20,20,20,20);
			jumpToCatMenuButton.getAllStyles().setBgTransparency(255);
			jumpToCatMenuButton.getAllStyles().setBgColor(ColorUtil.BLUE);
			jumpToCatMenuButton.getAllStyles().setFgColor(ColorUtil.WHITE);
			
			scoopMenuButton.setCommand(CommandScoop.getInstance());
			scoopMenuButton.keyPressed('s');
			scoopMenuButton.getUnselectedStyle().setPadding(20,20,20,20);
			scoopMenuButton.getAllStyles().setBgTransparency(255);
			scoopMenuButton.getAllStyles().setBgColor(ColorUtil.BLUE);
			scoopMenuButton.getAllStyles().setFgColor(ColorUtil.WHITE);
			
			rightContainer.add(contractMenuButton);
			rightContainer.add(downMenuButton);
			rightContainer.add(rightMenuButton);
			rightContainer.add(jumpToCatMenuButton);
			rightContainer.add(scoopMenuButton);
			this.add(BorderLayout.EAST, rightContainer);
			
			Container centerContainer = new Container();
			centerContainer.setLayout(new BorderLayout());
			centerContainer.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLUE));
			this.add(BorderLayout.CENTER, centerContainer);
			this.add(BorderLayout.CENTER, mapView);
			
			gameWorld.addObserver(mapView);
			gameWorld.addObserver(scoreView);
			gameWorld.notifyObservers();
			
			CommandContract.setTarget(gameWorld);
			CommandDown.setTarget(gameWorld);
			CommandExpand.setTarget(gameWorld);
			CommandFight.setTarget(gameWorld);
			CommandJumpToCat.setTarget(gameWorld);
			CommandJumpToDog.setTarget(gameWorld);
			CommandKitten.setTarget(gameWorld);
			CommandLeft.setTarget(gameWorld);
			//CommandQuit.setTarget(this);
			CommandRight.setTarget(gameWorld);
			CommandScoop.setTarget(gameWorld);
			CommandSound.setTarget(gameWorld);
			CommandTick.setTarget(gameWorld);
			CommandUp.setTarget(gameWorld);
			CommandHeal.setTarget(gameWorld);
			CommandPause.setTarget(this);
			
			timer = new UITimer(this);
			timer.schedule(30, false, this);
			
			this.requestFocus();
			this.show();
		} catch (NullPointerException e1) {
			
		}
	} // Game constructor

	@Override
	public void actionPerformed(ActionEvent evt) {
		gameWorld.gameTick(mapView.getWidth(), mapView.getHeight());
	}
	
 	public boolean isPaused(){ 
 		return isGamePaused; 
 	} 
 
 
 	public void pauseGame(){ 
 		timer.cancel(); 
 		isGamePaused = true; 
 		//gw.stopBackGroundClip(); 
 
 
 		healCommand.setEnabled(true); 
 
  		contractCommand.setEnabled(false); 
 		downCommand.setEnabled(false); 
 		expandCommand.setEnabled(false); 
 		rightCommand.setEnabled(false); 
 		scoopCommand.setEnabled(false); 
 		tickCommand.setEnabled(false); 
 		upCommand.setEnabled(false); 
 	} 
 
 
 	public void resumeGame(){ 
 		timer.schedule(1000, false, this); 
 		isGamePaused = false; 
 
 
 		//PLAY SOUND 
 		if(gameWorld.isSoundOn()){ 
 			//gw.playBackGroundClip(); 
 		} 
 
 
 		//ENABLE COMMANDS 
 		contractCommand.setEnabled(true); 
 		downCommand.setEnabled(true); 
 		expandCommand.setEnabled(true); 
 		leftCommand.setEnabled(true); 
 		rightCommand.setEnabled(true); 
 		scoopCommand.setEnabled(true); 
 		tickCommand.setEnabled(true); 
 		upCommand.setEnabled(true); 
 
 
 		//DISABLE COMMANDS 
 		healCommand.setEnabled(false); 

 	}

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
*/

	public void run() {
		// TODO Auto-generated method stub

	}	
} // Game class
