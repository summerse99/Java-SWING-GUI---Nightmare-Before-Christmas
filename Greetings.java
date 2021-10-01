
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Toolkit;


/**
 * Class Greetings
 * @author Emily Summers
 * Class that defines the introduction page. 
 * Begins playing Song One. 
 */
public class Greetings implements ActionListener {
	
	static File file; 
	static Clip clip;
	static AudioInputStream audioStream;
	
	JFrame Intro = new JFrame (); 
	static JButton begin = new JButton("Next"); 
	JTextArea introa = new JTextArea(); 
	static JPanel holdRule = new JPanel(); 
	textIntroArea label = new textIntroArea("zero.jpg");
	JLabel rules = new JLabel(); 
	JButton happy = new JButton("Welcome To The Nightmare Before Christmas Test\n");
	JPanel pan = new JPanel (); 
	JPanel panR = new JPanel(); 
	
	/**
	 * Constructor that defines the fonts to be used as well 
	 * as Swing Containers
	 */
	public void Greetings(){
		
		// defines fonts 
		Font rulesFont = new Font("Verdana", Font.BOLD, 20);
        
		// defines the next button 
		begin.addActionListener(this); 
		begin.setVisible(true);
		
		//setting desired size
		begin.setPreferredSize(new Dimension(200, 100));
		begin.setForeground(Color.WHITE); // setting font to white 
		begin.setFont(rulesFont);
		
		// gets rid of line surrounding text on Button 
		begin.setFocusPainted(false);
		begin.setBounds(100,100,100,100);
		begin.setBackground(new Color (255, 102, 0));
		
		// giving the next button a black border
		begin.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));		
		
		// defines the welcome button 
		happy.setBackground(Color.BLACK);
		happy.setForeground(Color.WHITE);
		happy.setFont(rulesFont);
		
		// giving the next button a black border
		happy.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));		

		label.setLayout(new BorderLayout());
		label.setBackground(new Color(255,102,0));
		label.setVisible(true);		
		label.add(begin, BorderLayout.SOUTH);
		label.add(happy, BorderLayout.NORTH);

		Intro.add(label);
		Intro.setVisible(true);

		Main.makeFrameFullSize(Intro);
	}
	
	

	/**
	 * actionPerformed method that starts music and
	 * directs to the IntroPage class to display rules. 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		IntroPage intro = new IntroPage();
		intro.IntroPage(); 
		try {
			Main.music("SongOne.WAV");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 		
	}
}
