/*
 * @author Charlie Rennicke
 * Problem for Fetch Rewards
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Pyramid {
	
	/*
	 * Method to calculate if a string is a pyramid, ie if there is an
	 * increasing occurrence of each letter in the string.
	 * Ex: banana is a pyramid, 3 a, 2 n, 1 b, while bandana is not
	 * 
	 * Strings that contain characters other than letters are rejected, same
	 * with string > 1000 chars
	 * 
	 * @param word String input, to be found if it is a pyramid
	 * @return string of success or failure.  Failure can take multiple shapes
	 * 
	 */
	public static void main(String[] args) {
		Scanner scanned = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter pyramid word: ");

	    String word = scanned.nextLine();  // Read user input
	    word = word.toLowerCase();
	    
	    //List to keep track of amount of chars
	    ArrayList<Integer> chain = new ArrayList();
	    for(int i = 0; i < 26; i++) {
	    	chain.add(0);
	    }
	    
	    char[] chars = word.toCharArray();
	    
	    //checks to see if the input if too large
	    if(chars.length > 1000 || chars.length == 0) {
	    	System.out.println("Error: input is too large or null");
	    	return;
	    }
	    
	    //runs through each char
	    for(int i = 0; i < chars.length; i++) {
	    	//checks if char is a letter
	    	if (!Character.isAlphabetic(chars[i])){
	    		System.out.println("Error: invalid input");
	    		return;
	    	}
	    	else {
	    		//increments the total of the character
	    		chain.set((int) chars[i] - 97, 
						chain.get((int) chars[i] - 97) + 1);	
	    	}	
	    }
	    //sorts the list
	    Collections.sort(chain);
	    
	    int index = 25;
	    int currentHigh = chain.get(index);
	    
	    //runs through each node where occurrence != 0 
	    while (currentHigh != 0) {
	    	//checks to see if the next smallest is not 1 apart, ie has a gap
	    	if(currentHigh - chain.get(index - 1) != 1) {
	    		System.out.println(word +" is not a pyramid");
	    		return;
	    	}
	    	//moves onto the next node
	    	else {
	    		index -= 1;
	    		currentHigh = chain.get(index);
	    	}
	    	//edge case where 
	    	//abbcccddddeeeeeffffffggggggghhhhhhhhiiiiiiiiijjjjjjjjjjkkkkkkkkkkkllllllllllllmmmmmmmmmmmmmnnnnnnnnnnnnnnoooooooooooooooppppppppppppppppqqqqqqqqqqqqqqqqqrrrrrrrrrrrrrrrrrrsssssssssssssssssssttttttttttttttttttttuuuuuuuuuuuuuuuuuuuuuvvvvvvvvvvvvvvvvvvvvvvwwwwwwwwwwwwwwwwwwwwwwwxxxxxxxxxxxxxxxxxxxxxxxxyyyyyyyyyyyyyyyyyyyyyyyyyzzzzzzzzzzzzzzzzzzzzzzzzzz
	    	//or some iteration, is entered
	    	if(index == 0) {
	    		currentHigh = 0;
	    	}
	    }
	    //success
	    System.out.println(word + " is a pyramid");
	}
	
    
}
