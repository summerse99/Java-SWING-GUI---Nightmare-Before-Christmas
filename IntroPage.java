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
import javax.sound.sampled.AudioSystem;
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


public class IntroPage implements ActionListener {
	
	static File file; 
	static Clip clip;
	static AudioInputStream audioStream;
	
	JFrame Intro = new JFrame (); 
	static JButton begin = new JButton("Start"); 
	JTextArea introa = new JTextArea(); 
	static JPanel holdRule = new JPanel(); 
	textIntroArea label = new textIntroArea("SallyPatch.jpg");
	JLabel rules = new JLabel(); 
	JButton happy = new JButton("Welcome To The Nightmare Before Christmas Test\n");
	JPanel pan = new JPanel (); 
	JPanel panR = new JPanel(); 
	
	
	public void IntroPage(){
		
		Font myFont = new Font("Thriller", Font.BOLD, 15);
		Font rulesFont = new Font("Verdana", Font.BOLD, 20);

	//	label.setPreferredSize(new Dimension(120,120));
		begin.addActionListener(this); 
		begin.setVisible(true);
		
		begin.setPreferredSize(new Dimension(200, 100));
		begin.setForeground(Color.WHITE);
		//begin.setBackground(new Color(0,0,0));
		begin.setFont(rulesFont);
		begin.setLayout(new FlowLayout(FlowLayout.RIGHT));
		// gets rid of line surrounding text on Button 
		begin.setFocusPainted(false);
		begin.setBounds(100,100,100,100);
		begin.setBackground(new Color (255, 102, 0));
		begin.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));		
		
		happy.setBackground(Color.BLACK);
		happy.setForeground(Color.WHITE);
		happy.setFont(rulesFont);
		happy.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));		

		label.setLayout(new BorderLayout());
		label.setBackground(new Color(255,102,0));

		label.setVisible(true);
		//Intro.add(begin, BorderLayout.SOUTH);
		Intro.setVisible(true);
		
		introa.setForeground(Color.WHITE);
//		introa.append("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\t\t\tRules:\n\n" + "\t\t\t\t\t\t  1.) Answer each question carefully. Part of the fun is knowing whether you can "
//		+ "\n\t\t\t\t\t\t get the spelling right, so positioned at the bottom there is a spellchecker. "
//				 + "\n\t\t\t\t\t\t If your answer is not an answer, it will give you suggestions based on\n\t\t\t\t\t\t spelling in the Spellchecker box. \n\n\t\t\t\t\t   2.) There will be ten questions chosen at random. At the end,\n\t\t\t\t\t  you will be graded based on your answers "
//		+ " and given a \n\t\t\t\t\t"
//		+ " certificate that judges your knowledge of the characters and scenes.\n " + "\n\t\t\t\t\t" + "        " + "3.) Have fun! Happy Halloween and Merry Christmas!");
		introa.setFont(myFont);
		introa.setBackground(new Color(1,1,1, (float) 0.01));
		introa.setVisible(true);
		label.setText("sdf");
		
		JLabel ruleT = new JLabel("Rules: "); 
		ruleT.setVisible(true);
		JTextArea panA = new JTextArea();
		panA.setFont(myFont);
		ruleT.setFont(myFont);
		panA.setForeground(new Color (255, 102, 0));
		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File("jack.JPG"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			pan.add(picLabel);
	
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		panA.setText( "RULES:\n 1.) Answer each question carefully. Part of the fun is knowing whether \n"
				+ " you can get the spelling right, so positioned at the bottom there is a \n spellchecker. "
				 + "If your answer is not an answer, it will give you suggestions based on \n spelling in "
				 + "the Spellchecker box.\n 2.) There will be ten questions chosen at random. At the end, you will be\n"
				 + " graded based on your answers and given a certificate \n  that judges your knowledge of the characters\n "
				 + "and scenes.\n3.) Have fun! Happy Halloween and Merry Christmas!");
		panA.setBackground(new Color(213, 134, 145, 123));
		
	    panA.setSize(300,0);
        panA.setLineWrap(true);
        panA.setForeground(Color.WHITE);
		pan.setVisible(true);
		panR.add(panA, BorderLayout.CENTER);
		Intro.pack();
		//panR.setBackground(Color.ORANGE);
		panR.setBackground(new Color(213, 134, 145, 123));
		pan.setOpaque(true);
		panR.setVisible(true);
		panR.setOpaque
		(true);
		panR.setSize(0,0);
		
		introa.setRows(10);
		introa.setColumns(10);
		label.add(begin, BorderLayout.PAGE_END);
		label.add(introa);
		label.add(happy, BorderLayout.PAGE_START);
		label.add(panA, BorderLayout.AFTER_LINE_ENDS); 
		Intro.add(label);
		makeFrameFullSize(Intro);
	}
	
	private void makeFrameFullSize(JFrame aFrame) {
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    aFrame.setSize(screenSize.width, screenSize.height);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		FileInfo.openQuestions(); 
		FileInfo.openDictionary(); 
		UserInteraction.dictionaryFiller(); 
		try { 
			UserInteraction.initializeWindow(); 
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		
		SuggestionMaker suggestions = new SuggestionMaker(); 
		suggestions.SuggestionMaker(); 
	}
	
}
