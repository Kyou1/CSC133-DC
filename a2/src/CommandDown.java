package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandDown extends Command{
	
	private static CommandDown commandDown;
	private static GameWorld game;
	
	public CommandDown() {
		super("Move net down");
	}

	public static CommandDown getInstance() {
		if(commandDown == null)
			commandDown = new CommandDown();
		return commandDown;
	}

	public static void setTarget(GameWorld gameWorld) {
		if( game == null )
			game = gameWorld;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Moved down.");
		game.moveDown();
	}
}
