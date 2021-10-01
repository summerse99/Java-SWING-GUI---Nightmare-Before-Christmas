import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SuggestionMaker extends UserInteraction implements ActionListener{
	static JTextArea questionArea = new JTextArea(); 
	static JButton button = new ovalButton("Submit");
	JPanel panel2 = new JPanel(); 
	Font myFont = new Font("Verdana", Font.BOLD, 26);
	public static int incorrect = 0; 



	public void SuggestionMaker() { 
		
		questionArea.setText(FileInfo.Questions.get(0));
		questionArea.setBackground(new Color(255,102,0));
		FileInfo.Questions.remove(0);
		questionArea.setFont(myFont);
		questionArea.setEditable(false);
		panel2.add(questionArea);   
		panel2.setBackground(new Color(255,102,0));
		wrong.add(button);
		// gets rid of line surrounding text on Button 
		button.setFocusPainted(false);
		button.setBounds(100,100,100,100);
		button.addActionListener(this);
		button.setForeground(Color.WHITE);
		button.setBackground(Color.BLACK);
		frame.add(panel2,BorderLayout.NORTH); 
	} 
	
	
	/**
	 * questionMaker method updates the question
	 * after the submit button is entered
	 */
	 public void actionPerformed(ActionEvent e) {
			 certificateGetter cert = new certificateGetter(); 
		try{
			 String answer = questionArea.getText(); 
			 if (answer != FileInfo.words.get(0)) {
				 incorrect = incorrect + 1; 
				 suggestions.setText("WRONG! THE CORRECT ANSWER WAS:  " + FileInfo.words.get(0));
				 
			 }
			 
			 else { 
				 suggestions.setText("CORRECT!");
			 }
			 FileInfo.words.remove(0);
			 questionArea.setText(FileInfo.Questions.get(0));
			 FileInfo.Questions.remove(0);
		} 
		catch(Exception c) {
			if (incorrect >= 7) {
				cert.makeCert("Santa.png", "You're like Santa. You know nothing about HalloweenTown.");

			} 
			else if (incorrect >= 4) {
				cert.makeCert("Oogie.jpg", "You are bad like Oogie Boogie.");
			}
			
			else {
				cert.makeCert("JackBack.png", "Congratulations! You are Jack Skellington himself.");

			}
		}
	 }
	
	}
