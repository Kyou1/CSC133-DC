package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandJumpToDog extends Command{
	private static CommandJumpToDog commandJumpToDog;
	private static GameWorld game;
	
	public CommandJumpToDog() {
		super("Jumped to dog.");
		// TODO Auto-generated constructor stub
	}

	public static CommandJumpToDog getInstance() {
		if(commandJumpToDog == null)
			commandJumpToDog = new CommandJumpToDog();
		return commandJumpToDog;
	}

	public static void setTarget(GameWorld gameWorld) {
		if( game == null )
			game = gameWorld;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Jumped to dog.");
		game.JumpToDog();
	}
}
