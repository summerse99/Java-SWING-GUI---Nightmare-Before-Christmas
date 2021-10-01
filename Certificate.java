import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author Emily Summers
 * Class that designs the first 
 * certificate. Uses TimerTask 
 * to animate JPanel's using Visibility. 
 */
public class Certificate extends TimerTask implements ActionListener {
	
	// Constant variables for JPanel Sizes 
	protected static final int a = 100; 
	protected static final int b = 150;
	protected static final int c = 200; 
	protected static final int d = 250;
	
	// Initializes all of Containers 
	protected static JFrame certificate = new JFrame();
	protected static JTextArea cert; 
	protected static JPanel p = new JPanel(); 
	protected static JPanel main = new JPanel();
	
	// creates an arrayList of JPanels
	protected static ArrayList <JPanel> sdf = new ArrayList <JPanel>(); 
	
    
    // Initializes JPanels used in animations with respective JPanels
	protected static JPanel pan1 = new animate("jack1.JPG", a, b); 
	protected static JPanel pan2 = new animate("Jack2.JPG",a,b); 
	protected static JPanel pan3 = new animate("jack 3.JPG",a,b); 
	protected static JPanel pan4 = new animate("jack4.JPG",a,b); 
	protected static JPanel pan5 = new animate("Jack5.JPG",a,b);
	protected static JPanel pan6 = new animate("Jack6.JPG",a,b); 
	protected static JPanel pan7 = new animate("Jack7.JPG",a,b); 
	protected static JPanel pan8 = new animate("Jack8.JPG",a,b); 
	protected static JPanel pan9 = new animate("Jack9.JPG",a,b); 
	protected static JPanel pan10 = new animate("Jack10.JPG",a,b); 
	
	// Initializes constants
	protected static int T = 1; // counter  
	protected static int N = 0; //counter 
	
	// initializes Font for multi-class use 
	protected static Font myFont = new Font ("Verdana", Font.BOLD, 30);

	
	/**
	 * Defualt Constructor 
	 */
	public void makeCert (String image, String Congratulations) {
		
		makeFrameFullSize(certificate); 
		
		pan1.setOpaque(false); 
		pan1.setVisible(true);
		
		pan2.setVisible(true);
		pan2.setOpaque(false);
		pan3.setVisible(true);
		pan3.setOpaque(false); 
		
		pan4.setVisible(true);
		pan4.setOpaque(false); 
		
		pan5.setVisible(true);
		pan5.setOpaque(false); 
		
		pan6.setVisible(true);
		pan6.setOpaque(false); 
		
		pan7.setVisible(true);
		pan7.setOpaque(false); 
		
		pan8.setVisible(true);
		pan8.setOpaque(false); 
		
		pan9.setVisible(true);
		pan9.setOpaque(false); 
		
		pan10.setVisible(true);
		pan10.setOpaque(false); 

		
		

		cert = new textArea(20, 5,image);
		cert.setBackground(new Color(1,1,1, (float) 0.01));
		cert.setText("\n\n\t" + Congratulations);
		cert.setForeground(Color.WHITE);
		cert.setFont(myFont);
		cert.setVisible(true);
		
		
		p.setBackground(new Color(255,102,0));
		p.add(pan1, BorderLayout.EAST);
		p.add(pan2,BorderLayout.EAST);
		p.add(pan5, BorderLayout.EAST);
		p.add(pan6,BorderLayout.EAST);
		p.add(pan3, BorderLayout.WEST);
		p.add(pan4, BorderLayout.WEST);
		p.add(pan7, BorderLayout.WEST);
		p.add(pan8,BorderLayout.WEST);
		p.setVisible(true);

		certificate.add(cert); 
		certificate.add(p, BorderLayout.PAGE_END); 
		certificate.setVisible(true);
		
		
		sdf.add(pan1);
		sdf.add(pan2); 
		sdf.add(pan3);
		sdf.add(pan4);
		
		Timer timer = new Timer();
        TimerTask task = new Certificate();
          
        timer.schedule(task, 900, 1400);
	}
	
	/**
	 * Makes JFrame fill the entire screen
	 * @param aFrame
	 */
	private static void makeFrameFullSize(JFrame aFrame) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		aFrame.setSize(screenSize.width, screenSize.height);
		}
	 public void actionPerformed(ActionEvent e) {
	 }
	 

		@Override
		public void run() {
		   if (T>2) {
			   T = 1; 
		   }
		 	if (T ==1) {
			sdf.get(N).setVisible(false);
			sdf.get(N+1).setVisible(true); 
			sdf.get(N+2).setVisible(false);
			sdf.get(N+3).setVisible(true);
		 	} 
		 	else {
		 		sdf.get(N).setVisible(true);
				sdf.get(N+1).setVisible(false); 
				sdf.get(N+2).setVisible(true);
				sdf.get(N+3).setVisible(false);
		 	}
	 T = T +1; 
		}
		 }


