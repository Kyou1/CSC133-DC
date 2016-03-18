package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandRight extends Command {
	private static CommandRight commandRight;
	private static GameWorld game;
	
	public CommandRight() {
		super("Moved right.");
		// TODO Auto-generated constructor stub
	}

	public static CommandRight getInstance() {
		if(commandRight == null)
			commandRight = new CommandRight();
		return commandRight;
	}

	public static void setTarget(GameWorld gameWorld) {
		if( game == null )
			game = gameWorld;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Moved right.");
		game.moveRight();
	}
}
