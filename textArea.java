import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JTextArea;

public class textArea extends JTextArea {

    private Image img;

    public textArea(int a, int b, String file) {
    	
        super(a,b);
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