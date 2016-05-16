package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class CommandPause extends Command{ 
     private static CommandPause pauseCommand; 
     private static Game game; 
 
 
     private CommandPause(){ 
         super("Pause"); 
     } 
 
 
     //ONLY ONE INSTANCE 
     public static CommandPause getInstance(){ 
         if(pauseCommand == null) 
             pauseCommand = new CommandPause(); 
         return pauseCommand; 
     } 
 
 
     //FOR ACCESSING GAMEWORLD FUNCTIONS 
     public static void setTarget(Game g){ 
         if(game == null) 
             game = g; 
     } 
 
     //ACTUALLY PERFORM THE ACTION 
     public void actionPerformed(ActionEvent e){ 
         if(game.isPaused()){ 
             game.resumeGame(); 
         } 
         else if(!game.isPaused()){ 
             game.pauseGame(); 
         } 
     } 

}