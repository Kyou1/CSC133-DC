package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandContract extends Command {
	private static CommandContract commandContract;
	private static GameWorld game;
	
	public CommandContract() {
		super("Contract Net");
	}
	
	public static CommandContract getInstance() {
		if(commandContract == null)
			commandContract = new CommandContract();
		return commandContract;
	}

	public static void setTarget(GameWorld gameWorld) {
		if( game == null )
			game = gameWorld;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			System.out.println("Net has contracted.");
			game.netContract();
		} catch (NullPointerException e1) {
			
		}
	}
}
