package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandExpand extends Command{
	private static CommandExpand commandExpand;
	private static GameWorld game;
	
	public CommandExpand() {
		super("Net expanded");
		// TODO Auto-generated constructor stub
	}

	public static CommandExpand getInstance() {
		if(commandExpand == null)
			commandExpand = new CommandExpand();
		return commandExpand;
	}

	public static void setTarget(GameWorld gameWorld) {
		if( game == null )
			game = gameWorld;
	}
	
	public void actionPerformed(ActionEvent e) {
		try  {
			System.out.println("Net expanded.");
			game.netExpand();
		} catch (NullPointerException e1) {
			
		}
	}
}
