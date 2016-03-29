package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.components.SpanButton;
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
import com.codename1.ui.plaf.Border;


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
			
			Container topContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
			topContainer.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.GRAY));
			topContainer.getAllStyles().setBgColor(ColorUtil.GRAY);
			topContainer.addComponent(scoreView);
			this.add(BorderLayout.NORTH, topContainer);
			
			Container bottomContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
			bottomContainer.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.GRAY));
			bottomContainer.setLayout(new FlowLayout(Component.CENTER));
			
			Button kittenMenuButton = new Button("Kitten");
			Button fightMenuButton = new Button("Fight");
			Button tickMenuButton = new Button("Tick");

			kittenMenuButton.setCommand(CommandKitten.getInstance());
			kittenMenuButton.getUnselectedStyle().setPadding(20,20,20,20);
			kittenMenuButton.getUnselectedStyle().setBgTransparency(255);
			kittenMenuButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
			kittenMenuButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
			
			fightMenuButton.setCommand(CommandFight.getInstance());
			fightMenuButton.getUnselectedStyle().setPadding(20,20,20,20);
			fightMenuButton.getUnselectedStyle().setBgTransparency(255);
			fightMenuButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
			fightMenuButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
			
			tickMenuButton.setCommand(CommandTick.getInstance());
			tickMenuButton.getUnselectedStyle().setPadding(20,20,20,20);
			tickMenuButton.getUnselectedStyle().setBgTransparency(255);
			tickMenuButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
			tickMenuButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);

			bottomContainer.addComponent(kittenMenuButton);
			bottomContainer.addComponent(fightMenuButton);
			bottomContainer.addComponent(tickMenuButton);
			
			this.add(BorderLayout.SOUTH, bottomContainer);
			
			Container leftContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
			leftContainer.getAllStyles().setPadding(Component.TOP, 50);
			
			Button expandMenuButton = new Button("Expand");
			Button upMenuButton = new Button("Up");
			Button leftMenuButton = new Button("Left");
			Button jumpToDogMenuButton = new Button("JumpToDog");
			
			expandMenuButton.setCommand(CommandExpand.getInstance());		
			expandMenuButton.getUnselectedStyle().setPadding(20,20,20,20);
			expandMenuButton.getUnselectedStyle().setBgTransparency(255);
			expandMenuButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
			expandMenuButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);

			upMenuButton.setCommand(CommandUp.getInstance());		
			upMenuButton.getUnselectedStyle().setPadding(20,20,20,20);
			upMenuButton.getUnselectedStyle().setBgTransparency(255);
			upMenuButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
			upMenuButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
			
			leftMenuButton.setCommand(CommandLeft.getInstance());		
			leftMenuButton.getUnselectedStyle().setPadding(20,20,20,20);
			leftMenuButton.getUnselectedStyle().setBgTransparency(255);
			leftMenuButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
			leftMenuButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
			
			jumpToDogMenuButton.setCommand(CommandJumpToDog.getInstance());		
			jumpToDogMenuButton.getUnselectedStyle().setPadding(20,20,20,20);
			jumpToDogMenuButton.getUnselectedStyle().setBgTransparency(255);
			jumpToDogMenuButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
			jumpToDogMenuButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
			
			leftContainer.addComponent(expandMenuButton);
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
			contractMenuButton.getUnselectedStyle().setPadding(20,20,20,20);
			contractMenuButton.getUnselectedStyle().setBgTransparency(255);
			contractMenuButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
			contractMenuButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
			
			downMenuButton.setCommand(CommandDown.getInstance());		
			downMenuButton.getUnselectedStyle().setPadding(20,20,20,20);
			downMenuButton.getUnselectedStyle().setBgTransparency(255);
			downMenuButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
			downMenuButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
			
			rightMenuButton.setCommand(CommandRight.getInstance());		
			rightMenuButton.getUnselectedStyle().setPadding(20,20,20,20);
			rightMenuButton.getUnselectedStyle().setBgTransparency(255);
			rightMenuButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
			rightMenuButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
			
			jumpToCatMenuButton.setCommand(CommandJumpToCat.getInstance());		
			jumpToCatMenuButton.getUnselectedStyle().setPadding(20,20,20,20);
			jumpToCatMenuButton.getUnselectedStyle().setBgTransparency(255);
			jumpToCatMenuButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
			jumpToCatMenuButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
			
			scoopMenuButton.setCommand(CommandScoop.getInstance());		
			scoopMenuButton.getUnselectedStyle().setPadding(20,20,20,20);
			scoopMenuButton.getUnselectedStyle().setBgTransparency(255);
			scoopMenuButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
			scoopMenuButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
			
			rightContainer.addComponent(contractMenuButton);
			rightContainer.add(downMenuButton);
			rightContainer.add(rightMenuButton);
			rightContainer.add(jumpToCatMenuButton);
			rightContainer.add(scoopMenuButton);
			this.add(BorderLayout.EAST, rightContainer);
			

			Container centerContainer = new Container(new BorderLayout());
			centerContainer.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLUE));
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
