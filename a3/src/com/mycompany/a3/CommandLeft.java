package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandLeft extends Command{
	private static CommandLeft commandLeft;
	private static GameWorld game;
	
	public CommandLeft() {
		super("Moved left.");
		// TODO Auto-generated constructor stub
	}

	public static CommandLeft getInstance() {
		if(commandLeft == null)
			commandLeft = new CommandLeft();
		return commandLeft;
	}

	public static void setTarget(GameWorld gameWorld) {
		if( game == null )
			game = gameWorld;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			System.out.println("Moved left.");
			game.moveLeft();
		} catch (NullPointerException e1) {
			
		}
	}
}
