package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandTick extends Command{
	
	private static CommandTick commandTick;
	private static GameWorld game;
	
	public CommandTick() {
		super("Ticked Up");
	}

	public static CommandTick getInstance() {
		if(commandTick == null)
			commandTick = new CommandTick();
		return commandTick;
	}

	public static void setTarget(GameWorld gameWorld) {
		if( game == null )
			game = gameWorld;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			System.out.println("Ticked Up.");
			game.gameTick();
		} catch (NullPointerException e1) {
			
		}
	}
}
