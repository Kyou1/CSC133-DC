/***
 *	Author: 	Clyde Pabro
 *	Created:	3/10/2016
 *	Revised:  	3/15/2016
 * 	Class: 		CSC 133-01 
 * 	Term: 		CSUS Spring 2016
 * 	Assign: 	2
 * 	
 * 	Title:		Dog Catcher GUI
 * 	
 * 	Description:
 * 	This is a game about a net, dogs, and cats using a gui.
 * 
***/

package com.mycompany.a2;

import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

@SuppressWarnings("unused")
public class Starter {
	private Form current;
//	private Resources theme;

	public void init(Object context) {
/*		theme = UIManager.initFirstTheme("/theme");

		// Pro only feature, uncomment if you have a pro subscription
		// Log.bindCrashProtection(true);
*/	}

	public void start() {
		if (current != null) {
			current.show();
			return;
		}
		Game g = new Game();
	}

	public void stop() {
		current = Display.getInstance().getCurrent();
	}
}
