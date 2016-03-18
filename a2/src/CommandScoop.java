package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandScoop extends Command{
	private static CommandScoop commandScoop;
	private static GameWorld game;
	
	public CommandScoop() {
		super("Scooped!");
		// TODO Auto-generated constructor stub
	}

	public static CommandScoop getInstance() {
		if(commandScoop == null)
			commandScoop = new CommandScoop();
		return commandScoop;
	}

	public static void setTarget(GameWorld gameWorld) {
		if( game == null )
			game = gameWorld;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Scooped.");
		game.scoop();
	}
}
