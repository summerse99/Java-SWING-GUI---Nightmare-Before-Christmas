import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;


/**
 * @author Emily Summers
 * Implements GUI 
 */
public class UserInteraction extends TimerTask {
	
	protected static JTextArea textInput;
	static ArrayList <String> pageContents = new ArrayList <String > (); 
	static ArrayList <String> wrongWords = new ArrayList <String> (); 
	protected static JFrame frame = new JFrame("Please Write your Words for Spellchecking Here: "); 
	protected static JPanel panelO = new JPanel(); 
	protected static JPanel wrong = new JPanel ();
	protected static JTextArea suggestions = new JTextArea (11,30); 
	static JScrollPane scrollBar = new JScrollPane(suggestions);   // JTextArea is placed in a JScrollPane.

	 static int a = 200; 
	    static int b = 250;
	protected static JPanel pumpkin = new animate("pumpkin1.JPG",a,b);
    protected static JPanel pumpkin2 = new animate ("pumpkin2.JPG",a,b);
    protected static JPanel pumpkin3 = new animate ("pumpkin3.JPG",a,b);
    protected static JPanel pumpkin4 = new animate ("pumpkin4.JPG",a,b);
    public static int N = 0 ; // range of number for which a collatz sequence must be computed 
	public static int T = 1; // number of threads the program must create and launch to compute collatz sequences
	public static boolean n = true; 
    private static ReentrantLock mutex = new ReentrantLock();
public static ArrayList <JPanel> sdf = new ArrayList <JPanel>(); 


	    // creates a universal instance of HashTable
		public static HashTable tble = new HashTable(); 
		
		// creates a universal instance of File Info 
		public static FileInfo info = new FileInfo();
		
		// keeps track of how many suggestions are made for a word 
		public static int suggestionTracker = 0; 
		
		public final static int ONE = 1;
		public final static int ZERO = 0; 
		public static Font myFont = new Font("Verdana", Font.BOLD, 20);
		public static Font f = new Font("Verdana", Font.BOLD, 15);

	/**
	 * Sets bounds for JFrame and adds KeyListener
	 * @param x
	 * @param y
	 * @param z
	 * @param b
	 * @throws IOException 
	 */
	public static void initializeWindow() throws IOException {
       sdf.add(pumpkin);
       sdf.add(pumpkin2); 
       sdf.add(pumpkin3); 
       sdf.add(pumpkin4);
		
		textInput = new textArea(5,20,"1580052067-huge.jpg");
		textInput.setBackground(new Color(1,1,1, (float) 0.01));
		  
		String title = "Wrong Words and Suggested Spelling";
		Border border = BorderFactory.createTitledBorder(title);
		wrong.setBorder(border);
		
	    pumpkin.setVisible(true);
	  	pumpkin.setOpaque(false);

	    pumpkin2.setVisible(true);
		pumpkin2.setOpaque(false);

		 pumpkin3.setVisible(true);
		pumpkin3.setOpaque(false);
		 pumpkin4.setVisible(true);
		pumpkin4.setOpaque(false);
		 
	    
		textInput.setForeground(Color.WHITE);
		//textInput.setBackground(Color.BLACK);
		textInput.setFont(myFont);
		suggestions.setLineWrap(true);
		Font myFont = new Font("Chiller", Font.BOLD, 15);

		// set bounds and visibility 
		frame.setBounds(5,5,5,5); // setting bounds 
		frame.setVisible(true); // setting visible 
		scrollBar.setVisible(true); //setting the scrollbar visible 
		textInput.setVisible(true); // setting visible
		suggestions.setVisible(true); 
		suggestions.setFont(f);
	
		suggestions.setText("Wrong words");
	    wrong.add(pumpkin, BorderLayout.EAST); 
	    wrong.add(pumpkin2, BorderLayout.EAST); 
		wrong.add(scrollBar, BorderLayout.CENTER);
	    wrong.add(pumpkin3, BorderLayout.WEST);
	    wrong.add(pumpkin4, BorderLayout.WEST);


		
		wrong.setBackground(new Color(255,102,0));

		frame.add(wrong, BorderLayout.SOUTH); 
		frame.add(panelO); 
		
		Graphics g; 
		
		 //Make JTextArea transparent
		 textInput.setOpaque(false);

		 //Make JTextArea line wrap
		 textInput.setLineWrap(true);

		 //Make JTextArea word wrap
		 textInput.setWrapStyleWord(true);

		 //Get image that we use as JTextArea background
		 ImageIcon ii=new ImageIcon("zero.jpg");
		 Image i=ii.getImage();

		// adds textInput to frame 
		frame.add(textInput);
		makeFrameFullSize(frame);
		
		

		textInput.addKeyListener(new KeyListener() {  
			
			public void keyTyped(KeyEvent e) {
	        }
			public void keyPressed(KeyEvent e) {
				
				wrongWords.clear(); 
				
				// if enter or space key 
				if((e.getKeyCode() == KeyEvent.VK_SPACE ) || (e.getKeyCode() == KeyEvent.VK_ENTER )) {
					
					String word;
					String inputY = textInput.getText(); 
					String [] spacedI =  inputY.split("\r?\n");
					String [] spacedInput = null; 
					
					//replaces the JtextArea textInput with an empty space
					textInput.selectAll();
					textInput.replaceSelection(" ");
	         	    
					// highlight incorrect word pink 
					Highlighter highlighter = textInput.getHighlighter();
					HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.RED);
					
					// parses array to get rid of all spaces between words. 
					for (int j = 0; j < spacedI.length; j ++) {
						
						//splits words by spaces 
						spacedInput = spacedI[j].split(" ");
						
						//parses through a copy of previous array to ensure no spaces are left. 
						for (int i =0; i < spacedInput.length; i ++) {
							
							if ( spacedInput[i] ==" ") {
								// do nothing 
								}
							else {
								// checks if word is in the dictionary through the hashtable 
								boolean y = checkIfNull(spacedInput[i]);
							
							// if word is not in the dictionary 
							if (y == false) {
								
								// insert the word at the end of the text in the JTextArea with a space. 
								textInput.insert(spacedInput[i] + " ", textInput.getText().length()-1);
								
								// retrieve starting and ending indexes of word in order to highlight it. 
								int p0 = textInput.getText().indexOf( spacedInput[i]);
								int p1 = p0 + spacedInput[i].length();
								
								// highlight said word in pink 
								try {
									highlighter.addHighlight(p0, p1, painter );
									} 
								catch (BadLocationException e1) {
									e1.printStackTrace();
									} 	 
								
								 // Jtextarea setting text to a blank 
								 suggestions.setText(" ");
								 
								 //calling on spellchecker method 
							     spellChecker();
	          	            	}
							
							// if the word does exist in the 
							if (y == true){
								word = spacedInput[i]; 
								textInput.insert(spacedInput[i] + " ", textInput.getText().length()-1);
								}
							}
						}
					}
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {	
			}}); 
		
		Timer timer = new Timer();
        TimerTask task = new UserInteraction();
          
        timer.schedule(task, 900, 1400);
		
	}	
	
	
	public static void pumpkinAnimate() {
		
	 
		pumpkin.setBackground(new Color(255,102,0));
		pumpkin.setVisible(true);
		pumpkin3.setVisible(false);
		pumpkin3.setVisible(true);
    }
    		
	 /**
	  * spellChecker method
	  * Checks if word is a space, and if not appends
	  * necessary suggestions and explanations to the suggestions 
	  * JTextArea
	  */
	 public static void spellChecker() { 
		 
		 // sets text back to "Wrong words" in JtextArea 
		 suggestions.setText("Wrong words"); 
		 
		 // iterating through array containing all of the wrong words 
		 for (int i = 0; i < wrongWords.size(); i++ ) {
			 
			// sets index of arraylist to a string word 
			String word =  wrongWords.get(i).toLowerCase();
			
			// if the word equals a space 
			if (word.equals(" ") || word.equals("")) {
				// do nothing 
			}
			
			// if word does not equal a space 
			else {
				
			// display
			suggestions.append("\n\nTHE WORD " + "'" + word + "' IS NOT IN DICTIONARY"); 
	    	suggestions.append("\nSuggested Words: \n");
	    		 
	    	// method for suggested words
	    	wordSuggestor(word);
	    		 
	    	// to keep track of suggestionTracker counter 
	    	// goal is to keep track of whether any suggestions 
	    	// have been made on a single word. 
	    	if (suggestionTracker <= ZERO) {
	    	 
	    	 // if no suggestions have been made, append "no suggestions" 
	    	 suggestions.append("No Suggestions");
	    	 }
	    	}
			}
		 }
	 
	/**
	 * Makes JFrame fill the entire screen
	 * @param aFrame
	 */
	private static void makeFrameFullSize(JFrame aFrame) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		aFrame.setSize(screenSize.width, screenSize.height);
		}
	
	/**
	 * Swapping method used for letterReversed(String)
	 * swaps a word at the char locations of 
	 * the two ints passed in 
	 * @param str
	 * @param i
	 * @param j
	 * @return
	 */
	public static void letterReversed ( String word) {
	
		int i = 0; // counters 
		int t = 1; // counters 
		
		// converts the string to an array and swaps desired char var 
		while (t < word.length()) {
			
			//converts word to an array of chars 
			char [] arr = word.toCharArray(); 
			
			//swapping algorithm 
			char temp = arr[i];
			arr[i] = arr[t];
			arr[t] = temp;
			
			// converting to string 
			String newWord = String.valueOf(arr); 
			
			// if the newword does not equal null
			if (tble.get(newWord) != null) {
				
				// prints it to the suggestions jtextArea 
				suggestions.append(" " + newWord + " ");
				
				// increments the count on suggestiontracker to keep track of 
				// suggestions for 'no suggestions' display
				suggestionTracker = suggestionTracker + 1; 
			}
			// incrementing our counters for the next while loop traversal 
			i = i + ONE;  
			t = t + ONE; 
		}	
	}

	
	
	/**
	 * Determines a suggestion of the correct word based on 
	 * whether there is a letter missing. Runs through the 
	 * alphabet in each possible position in the word to 
	 * figure out if there is another word similar to this one 
	 * being held in the hashtable. 
	 * @param word
	 */
	public static void letterMissing(String word) {
		
		StringBuilder newWord = null;  // StringBuilder variable
		
		// stringBuilder initialization
		StringBuilder stringBuilder = new StringBuilder(word); 
		
		// for loop that iterates through the length of the word
		for (int i = ZERO; i <= word.length(); i ++) {
			
			// for loop that iterates through the alphabet 
			for (char alphabet = 'a'; alphabet <='z'; alphabet++ ) {
				
				// inserts a new letter in a position
				newWord = stringBuilder.insert(i, alphabet);
				
				// figures out if the word is in the hashTable
				Integer y =  tble.get(newWord.toString());
				
				// if y is no equal to null, send it to the screen 
				if (y != null) {
					String x = newWord.toString(); 
					suggestions.append(x);
					suggestionTracker = suggestionTracker + 1; 
					}
				
				// deletes the inputed char to reset the word for next pos
				stringBuilder.deleteCharAt(i);
				}
			}
		}
	
	/**
	 * Checks if there is a suggested word by seeing if there is a word 
	 * that's been added. Prints if a suggestion is found. 
	 * @param word
	 */
	public static void letterAdded(String word) {
		
		String orig = word; // holds a copy of original word
		
		// creates instance of StringBuilder
		StringBuilder stringBuild = new StringBuilder(word); 
		
		// iterating through word length
		for (int j = 0; j < word.length(); j++) {
			
			// delete char at j 
			StringBuilder wordN = stringBuild.deleteCharAt(j);
			
			// convert to a string 
			String t = wordN.toString(); 
			
			// if it exists in the hashtable, then print 
			if (tble.get(t) != null) {
				String x = wordN.toString(); 
				// print it
				suggestions.append(x);
				
				// increments the count on suggestiontracker to keep track of 
				// suggestions for 'no suggestions' display
				suggestionTracker = suggestionTracker + 1; 

				}
			
			//resets the word back to original 
			word = orig;
			
			// creates a new instance of StringBuilder 
			stringBuild = new StringBuilder(word);
			}
		
		}
	

	
	/**
	 * Calls on methods to get various word Suggestions 
	 * @param word
	 */
	 public static void wordSuggestor(String word) {		 
		 letterMissing(word);
		 letterAdded(word); 
		 letterReversed(word);
	 }
	 
	 /**
	  * class dictionaryFiller  
	  * iterates through words ArrayList and wordsToBChecked 
	  * to put and retrieve from hashTable 
	  * if wordsToBChecked words are not retrievable, then it 
	  * calls apon methods to deal with suggestions 
	  */
	 public static void dictionaryFiller() {
		 
		 // for loop that adds dictionary words to hashMap 
		 for (int i = ZERO; i < FileInfo.words.size(); i ++) {
			 
			 String word = FileInfo.words.get(i);
	    	 tble.add(word, ONE + i);
	    	 } 
	 }
	 
	 /**
	  * Checks if word exists within hashtable 
	  * @param word
	  * @return
	  */
	 public static boolean checkIfNull(String word) {
		 
		 Integer l  = tble.get(word.toLowerCase());
		 
		 
		 // if l is not in the hash table return false
		 if (l == null) {
			 wrongWords.add(word);
		 return false; 
		 }
		 
		 // if l is in the hash table, return tre
		 else {
		 return true;
		 }
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
