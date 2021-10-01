import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * @author Emily Summers
 * animate Class 
 * Works to initialize JPanels that change 
 * visibility to mimick animation. 
 * Extends JPanel to initialize. 
 */
public class animate extends JPanel {

	    private Image img; // image 

	    /**
	     * Parameterized Constructor 
	     * @param file
	     * @param a
	     * @param b
	     */
	    public animate( String file, int a, int b) {
	    	
	    	// sets size of JPanel with passed in values 
	        setPreferredSize(new Dimension(a, b));	 
	        
	        // Try/Catch to read in picture image 
	        try{
	            img = ImageIO.read(new File(file));
	        } catch(IOException e) {
	            System.out.println(e.toString());
	            }
	    }

	    /**
	     * Paint Graphics Method that colors in 
	     * Selected image 
	     */
	    @Override
	    protected void paintComponent(Graphics g) {
	        g.drawImage(img,0,0,getWidth(),getHeight(), this);
	        super.paintComponent(g);
	    }
	}



	  


