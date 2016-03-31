package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandJumpToCat extends Command {
	private static CommandJumpToCat commandJumpCat;
	private static GameWorld game;
	
	public CommandJumpToCat() {
		super("Jump to Cat");
		// TODO Auto-generated constructor stub
	}
	
	public static CommandJumpToCat getInstance() {
		if(commandJumpCat == null) {
			commandJumpCat = new CommandJumpToCat();
		}
		return commandJumpCat;
	}

	public static void setTarget(GameWorld gameWorld) {
		if( game == null ) {
			game = gameWorld;
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			System.out.println("Jump to Cat.");
			game.JumpToCat();
		} catch (NullPointerException e1) {
			
		}
	}
}
