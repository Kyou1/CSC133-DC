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
			kittenMenuButton.getAllStyles().setPadding(20,20,20,20);
			kittenMenuButton.getAllStyles().setBgTransparency(255);
			kittenMenuButton.getAllStyles().setBgColor(ColorUtil.BLUE);
			kittenMenuButton.getAllStyles().setFgColor(ColorUtil.WHITE);
			
			fightMenuButton.setCommand(CommandFight.getInstance());
			fightMenuButton.getAllStyles().setPadding(20,20,20,20);
			fightMenuButton.getAllStyles().setBgTransparency(255);
			fightMenuButton.getAllStyles().setBgColor(ColorUtil.BLUE);
			fightMenuButton.getAllStyles().setFgColor(ColorUtil.WHITE);
			
			tickMenuButton.setCommand(CommandTick.getInstance());
			tickMenuButton.getAllStyles().setPadding(20,20,20,20);
			tickMenuButton.getAllStyles().setBgTransparency(255);
			tickMenuButton.getAllStyles().setBgColor(ColorUtil.BLUE);
			tickMenuButton.getAllStyles().setFgColor(ColorUtil.WHITE);

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
			expandMenuButton.getAllStyles().setPadding(20,20,20,20);
			expandMenuButton.getAllStyles().setBgTransparency(255);
			expandMenuButton.getAllStyles().setBgColor(ColorUtil.BLUE);
			expandMenuButton.getAllStyles().setFgColor(ColorUtil.WHITE);

			upMenuButton.setCommand(CommandUp.getInstance());		
			upMenuButton.getAllStyles().setPadding(20,20,20,20);
			upMenuButton.getAllStyles().setBgTransparency(255);
			upMenuButton.getAllStyles().setBgColor(ColorUtil.BLUE);
			upMenuButton.getAllStyles().setFgColor(ColorUtil.WHITE);
			
			leftMenuButton.setCommand(CommandLeft.getInstance());		
			leftMenuButton.getAllStyles().setPadding(20,20,20,20);
			leftMenuButton.getAllStyles().setBgTransparency(255);
			leftMenuButton.getAllStyles().setBgColor(ColorUtil.BLUE);
			leftMenuButton.getAllStyles().setFgColor(ColorUtil.WHITE);
			
			jumpToDogMenuButton.setCommand(CommandJumpToDog.getInstance());		
			jumpToDogMenuButton.getAllStyles().setPadding(20,20,20,20);
			jumpToDogMenuButton.getAllStyles().setBgTransparency(255);
			jumpToDogMenuButton.getAllStyles().setBgColor(ColorUtil.BLUE);
			jumpToDogMenuButton.getAllStyles().setFgColor(ColorUtil.WHITE);
			
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
			contractMenuButton.getAllStyles().setPadding(20,20,20,20);
			contractMenuButton.getAllStyles().setBgTransparency(255);
			contractMenuButton.getAllStyles().setBgColor(ColorUtil.BLUE);
			contractMenuButton.getAllStyles().setFgColor(ColorUtil.WHITE);
			
			downMenuButton.setCommand(CommandDown.getInstance());		
			downMenuButton.getAllStyles().setPadding(20,20,20,20);
			downMenuButton.getAllStyles().setBgTransparency(255);
			downMenuButton.getAllStyles().setBgColor(ColorUtil.BLUE);
			downMenuButton.getAllStyles().setFgColor(ColorUtil.WHITE);
			
			rightMenuButton.setCommand(CommandRight.getInstance());		
			rightMenuButton.getAllStyles().setPadding(20,20,20,20);
			rightMenuButton.getAllStyles().setBgTransparency(255);
			rightMenuButton.getAllStyles().setBgColor(ColorUtil.BLUE);
			rightMenuButton.getAllStyles().setFgColor(ColorUtil.WHITE);
			
			jumpToCatMenuButton.setCommand(CommandJumpToCat.getInstance());		
			jumpToCatMenuButton.getAllStyles().setPadding(20,20,20,20);
			jumpToCatMenuButton.getAllStyles().setBgTransparency(255);
			jumpToCatMenuButton.getAllStyles().setBgColor(ColorUtil.BLUE);
			jumpToCatMenuButton.getAllStyles().setFgColor(ColorUtil.WHITE);
			
			scoopMenuButton.setCommand(CommandScoop.getInstance());		
			scoopMenuButton.getUnselectedStyle().setPadding(20,20,20,20);
			scoopMenuButton.getAllStyles().setBgTransparency(255);
			scoopMenuButton.getAllStyles().setBgColor(ColorUtil.BLUE);
			scoopMenuButton.getAllStyles().setFgColor(ColorUtil.WHITE);
			
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
