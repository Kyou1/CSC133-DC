/***
 *	Author: 	Clyde Pabro
 *	Created:	2/25/2016
 *	Revised:  	2/25/2016
 * 	Class: 		CSC 133-01 
 * 	Term: 		CSUS Spring 2016
 * 	Assign: 	1
 * 	
 * 	Title:		Dog Catcher
 * 	
 * 	Description:
 * 	This is a text-based game about a net, dogs, and cats.
 * 
***/

package com.mycompany.a1;

import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

public class Starter {
	private Form current;
	private Resources theme;

	public void init(Object context) {
		theme = UIManager.initFirstTheme("/theme");

		// Pro only feature, uncomment if you have a pro subscription
		// Log.bindCrashProtection(true);
	}

	public void start() {
		if (current != null) {
			current.show();
			return;
		}
		new Game();
	}

	public void stop() {
		current = Display.getInstance().getCurrent();
	}
}
