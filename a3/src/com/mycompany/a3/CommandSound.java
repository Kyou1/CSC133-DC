package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandSound extends Command{
	private static CommandSound commandSound;
	private static GameWorld game;
	private Sounds sounds = Sounds.getInstance();

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
		try {
			System.out.println("Sound off.");
	        game.toggleSound(); 
	         
	         
	                 if(game.isSoundOn()){ 
	                     sounds.playBackGroundClip(); 
	                 } 
	                 else { 
	                     sounds.stopBackGroundClip(); 
	                 } 
	             

		} catch (NullPointerException e1) {
			
		}
	}
}
