package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandQuit extends Command{
	private static CommandQuit commandQuit;
	
	public CommandQuit() {
		super("Exit");
		// TODO Auto-generated constructor stub
	}

	public static CommandQuit getInstance() {
		if(commandQuit == null)
			commandQuit = new CommandQuit();
		return commandQuit;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			System.out.println("Game quited.");
			System.exit(0);
		} catch (NullPointerException e1) {
			
		}
	}
}
