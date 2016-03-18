package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandQuit extends Command{
	private static CommandQuit commandQuit;
	
	public CommandQuit() {
		super("Quit");
		// TODO Auto-generated constructor stub
	}

	public static CommandQuit getInstance() {
		if(commandQuit == null)
			commandQuit = new CommandQuit();
		return commandQuit;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Game quited.");
		System.exit(0);
	}
}
