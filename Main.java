import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.*;
import javax.swing.JFrame; 
import java.io.*; 
import java.applet.*;
import java.awt.*;


/**
 * @author Emily Summers
 * Main.java class
 * Holds the main method 
 */
public class Main {
	
	/**
	 * Starts music depending on what is passed in.
	 * @param song
	 * @throws Exception
	 * @throws IOException
	 */
	public static void music (String song) throws Exception, IOException {
		
		Clip clip;

		try {
			AudioInputStream input=AudioSystem.getAudioInputStream(new File("SongOne.wav"));
			clip=AudioSystem.getClip();
			clip.open(input);
			clip.start();
		} catch (Exception e) {
		}
		
	}

	/**
	 * Method that enlarges the frame to a full size
	 * @param aFrame
	 */
	static void makeFrameFullSize(JFrame aFrame) {
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    aFrame.setSize(screenSize.width, screenSize.height);
	}

	/**
	 * Main method used to call on the driving 
	 * methods within program 
	 * @param args
	 */
	public static void main(String[] args) {
				
		Greetings greet = new Greetings(); 
		greet.Greetings(); 
	
	     }
}
