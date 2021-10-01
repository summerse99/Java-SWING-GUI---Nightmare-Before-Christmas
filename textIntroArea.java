import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 * @author Emily Summers
 * Class intended to initialize JLabel
 */
public class textIntroArea extends JLabel {

    private Image img;

    public textIntroArea( String file) {
    	
       try{
            img = ImageIO.read(new File(file));
        } catch(IOException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(img,0,0,getWidth(),getHeight(), this);
        super.paintComponent(g);
    }
}