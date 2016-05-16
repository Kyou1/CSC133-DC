package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandUp extends Command{
	
	private static CommandUp commandUp;
	private static GameWorld game;
	
	public CommandUp() {
		super("Moved Up.");
	}

	public static CommandUp getInstance() {
		if(commandUp == null)
			commandUp = new CommandUp();
		return commandUp;
	}

	public static void setTarget(GameWorld gameWorld) {
		if( game == null )
			game = gameWorld;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			System.out.println("Moved up.");
			game.moveUp();
		} catch (NullPointerException e1) {
			
		}
	}
}
