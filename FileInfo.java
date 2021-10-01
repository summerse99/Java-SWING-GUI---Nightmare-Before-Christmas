
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Emily Summers
 * FileInfo.java class
 * Reads in Files Containing 
 * Questions and Answers 
 * Holds all file information data 
 */
public class FileInfo {
	
	// holds questions
	public static ArrayList <String> Questions = new ArrayList<String>(); 
	
	// holds answers
	public static ArrayList <String> answers = new ArrayList <String>(); 

	public static  ArrayList <String> words = new ArrayList <String> (); // holds all of the dictionary words
	public static ArrayList <String> wordsToBChecked = new ArrayList <String> (); // holds all of the words that need checked
	public static String [] wordsToBeCheckedA; 
	
	/**
	 * Method that gets rid of any punctuation, 
	 * mainly periods and commas as mentioned 
	 * in project description. 
	 * @param word
	 * @return
	 */
	public static String Punctuation(String word) {
		final int ONE = 1; 
		final int ZERO = 0; 		
		String newWord = null;
		
		for (int k = 0; k < word.length(); k++) {
			
		if (word.charAt(k) == '.'){
			 newWord = word.replace(word.charAt(k), ' ');
			}
		else {
			newWord = word;
		}
		}
		
		if (newWord == null) {
			newWord = " ";
		}
		return newWord;
	}
	
	/**
	 * Method that opens questions 
	 */
	public static void openQuestions() {		

		try {
			// opening file 
			Scanner scanner = new Scanner(new File("Answers")); 
			
			// reading in file 
			while (scanner.hasNextLine() == true){
				
				Questions.add(scanner.nextLine());
				}
				}
		
		// catch block that throws an error if the file cannot open 
			  catch (FileNotFoundException e) { 
				  
				e.printStackTrace();
				System.out.println("Failure to Open The Questions"); 
				}
	}
	
	/**
	 * reads in dictionary.txt to an arrayList 
	 */
	public static void openDictionary() {
		ArrayList <String> wordsA = new ArrayList<String>(); 
		ArrayList <String> wordsB = new ArrayList<String>(); 
		ArrayList <String> wordsC = new ArrayList<String>(); 


		try {
			// opening file 
			Scanner scanner = new Scanner(new File("dictionaryWords.txt")); 
			
			// reading in file 
			while (scanner.hasNextLine() == true){
				
				wordsA.add(scanner.nextLine().toLowerCase());
				}	
			
			
			for (int i = 0; i < wordsA.size(); i ++) {
				String [] wordSplit = wordsA.get(i).split(" ");
				for (int k = 0; k < wordSplit.length; k ++) {
					wordsB.add(wordSplit[k]);
				}
				}
			
			for (int b = 0; b < wordsB.size(); b ++) {
				
				String word = wordsB.get(b); 
				int length = word.length();
				for (int d = 0; d < word.length(); d ++) {
					if ( word.charAt(d) == '.') {
 						 String newWord = word.replace(word.charAt(d), ' ');
 						//System.out.println(newWord); 
 						wordsB.add(newWord);
					}
					
				}
				
		 String [] dunce = wordsB.get(b).split(" "); 
		 for ( int v = 0; v < dunce.length; v++) {
			 //System.out.println(dunce[v]);
			 wordsC.add(dunce[v]);
		 }			}
			
			
			for (int k = 0; k < wordsC.size(); k ++) {
				words.add(wordsC.get(k));
			}
			
			}
		
		// catch block that throws an error if the file cannot open 
			  catch (FileNotFoundException e) { 
				  
				e.printStackTrace();
				System.out.println("Failure to Open dictionaryWords.txt"); 
				}
		}

	}
