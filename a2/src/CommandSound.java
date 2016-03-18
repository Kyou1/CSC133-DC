package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandSound extends Command{
	//private static CommandSound commandSound;
	private static GameWorld game;

	public CommandSound() {
		super("Sound");
	}
	public static CommandDown getInstance() {
		return null;
	}

	public static void setTarget(GameWorld gameWorld) {
		if( game == null )
			game = gameWorld;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Sound off.");
	}
}
