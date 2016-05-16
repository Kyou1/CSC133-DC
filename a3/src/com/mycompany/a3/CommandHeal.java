package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandHeal extends Command {
	private static CommandHeal healCommand;
	private static GameWorld game;
	
	private CommandHeal() {
		super("heal");
	}
	
	public static CommandHeal getInstance() {
		if(healCommand == null)
			healCommand = new CommandHeal();
		return healCommand;
	}
	
	public static void setTarget(GameWorld gw) {
		if(game == null)
			game = gw;
	}
	
	public void actionPerformed(ActionEvent e){
		game.healDogs();
	}
}
