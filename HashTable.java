
import java.util.ArrayList;

	/**
	 * Hashtable.java class
	 * Represents the hashTable data structure
	 * with external chaining. 
	 */

	public class HashTable{
		
		private ArrayList <Node> position; // current position of type Node
		private int tableSize; //num of buckets 
		private final int ZERO = 0; 
		/**
		 * Default constructor. 
		 * Essentially creating empty buckets with 
		 * linked lists 
		 */
		public HashTable() {
			
			position = new ArrayList<>();
			tableSize = 51001;
			for (int i = ZERO; i < tableSize; i++)
				position.add (null);
			}
		
		/**
		 * @author Emily Summers
		 * Creates a class Node that maintains a reference 
		 * to the linked lists 
		 */
		private class Node {
			
			String word;
			Integer key;
			
			// Reference to next node
			Node next;
			
			// Constructor
			public Node(String word, Integer key){
				
				this.word = word;
				this.key = key;
				}
			}
		
		 /**
		  * Takes the place of the hashCode() function
		  * @param key
		  * @return
		  */
		 private int hashing(String key) {
			 
		     final int ONE = 1; 
			 int num = 1; // used as counter 
			 int tmp = key.length(); // to keep track of length tmp 
			 int hashNum = 33; // used as a hash multiplier
			 
			 // iterate through for loop 
			    for(int i = ZERO; i < tmp; i++) {
			      num = num * hashNum +  (i+ONE) * key.charAt(i);
			    }
			    
				 return Math.abs(num) % tableSize;  
		     }
		 
		 /**
		  * Add function
		  * adds a word and its' key to the hashtable 
		  * @param word
		  * @param key
		  */
		 public void add (String word, Integer key) {
		
	     // sets head to the position hashed 
	     Node head = position.get(hashing(word));

	     // while the node doesn't equal null, iterate 
	     // through linked list 
	     while (head != null) {
	    	 
	         if (head.word.equals(word)) {
	             head.key = key;
	             return;
	         }
	         
	         head = head.next;
	     }
	     
	     head = position.get(hashing(word));
	     
	     //allocate new node 
	     Node newNode = new Node(word, key);
	     
	     // set next = head 
	     newNode.next = head;
	     
	     
	     position.set(hashing(word), newNode);   
	 }
		 
	 
	 /**
	  * Returns a value for a word
	  * or null if it can not be found within the hashtable
	  * @param word
	  * @return
	  */
	 public Integer get(String word) {
	     
	     //initializing the head of the linked list 
	     Node head = position.get(hashing(word)); 

	     //search the word within the chain 
	     while (head != null) {
	    	 
	    	 // if word of type head equals word 
	    	 if (head.word.equals(word))
	    		 return head.key;
	    	 
	    	 head = head.next;
	    	 }
	     return null;
	     }
	 }
