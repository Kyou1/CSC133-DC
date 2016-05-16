package com.mycompany.a3;

import java.io.IOException;
import java.io.InputStream;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;

@SuppressWarnings("unused")
public class Sounds {
	private Media m;
	private static Sounds gameSounds;
	private static Sounds catCollision;
	private static Sounds fightCollision;
	private static Sounds backGround;
	private static Sounds scoopNet;
	
	public Sounds (String fileName) throws IOException {

		InputStream iStream = Display.getInstance().getResourceAsStream(getClass(), "/"+fileName);
		m = MediaManager.createMedia(iStream, "audio/wav");
	}
	
	public Sounds() {
		// TODO Auto-generated constructor stub
	}

	public static Sounds getInstance() {
		if(gameSounds == null){
			gameSounds = new Sounds();
		}
		return gameSounds;
	}
	
	public void play() {
		m.setTime(0);
		m.play();
	}
	
	public void pause() {
		m.setTime(0);
		m.pause();
	}
	
	public void run() {
		m.setTime(0);
		m.play();
	}
	
    public void playCatCollisionClip(){ 
         catCollision.play(); 
     } 
     public void playFightCollisionClip(){ 
         fightCollision.play(); 
     } 
     public void playScoopNetClip(){ 
         scoopNet.play(); 
     } 
     public void playBackGroundClip(){ 
         backGround.run(); 
     } 

	public void stopBackGroundClip(){ 
         backGround.pause(); 
     } 

	
} // end sound class
