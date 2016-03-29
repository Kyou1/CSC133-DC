package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandFight extends Command {
	private static CommandFight commandFight;
	private static GameWorld game;
	
	public CommandFight() {
		super("Fight!");
		// TODO Auto-generated constructor stub
	}

	public static CommandFight getInstance() {
		if(commandFight == null)
			commandFight = new CommandFight();
		return commandFight;
	}

	public static void setTarget(GameWorld gameWorld) {
		if( game == null )
			game = gameWorld;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			System.out.println("Fight.");
			game.fight();
		} catch (NullPointerException e1) {
			
		}
	}
}
