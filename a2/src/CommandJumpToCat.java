package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandJumpToCat extends Command {
	private static CommandKitten commandKitten;
	private static GameWorld game;
	
	public CommandJumpToCat() {
		super("Made kittens.");
		// TODO Auto-generated constructor stub
	}
	
	public static CommandKitten getInstance() {
		if(commandKitten == null)
			commandKitten = new CommandKitten();
		return commandKitten;
	}

	public static void setTarget(GameWorld gameWorld) {
		if( game == null )
			game = gameWorld;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Cat added.");
		game.produceKitten();
	}
}
