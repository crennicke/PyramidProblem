import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Pyramid {

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter word");

	    String word = myObj.nextLine();  // Read user input
	    word = word.toLowerCase();
	    
	    ArrayList<Integer> chain = new ArrayList();
	    for(int i = 0; i < 26; i++) {
	    	chain.add(0);
	    }
	    
	    char[] chars = word.toCharArray();
	    for(int i = 0; i < chars.length; i++) {
	    	//checks if valid input
	    	if (!Character.isAlphabetic(chars[i])){
	    		System.out.println("Error: invalid input");
	    		return;
	    	}
	    	else {
	    		chain.set((int) chars[i] - 97, 
						chain.get((int) chars[i] - 97) + 1);
	    		
	    	}
	    	System.out.println(chain);
	    	
	    }
	    Collections.sort(chain);
	    
	    int index = 25;
	    int currentHigh = chain.get(index);
	    
	    //runs through each appearing letter
	    while (currentHigh != 0) {
	    	//checks to see if the next smallest is not 1 apart
	    	if(currentHigh - chain.get(index - 1) != 1) {
	    		//TODO failure
	    		System.out.println(word +" is not a pyramid");
	    		return;
	    	}
	    	//sets next row and continues
	    	else {
	    		index -= 1;
	    		currentHigh = chain.get(index);
	    	}
	    	if(index == 0) {
	    		currentHigh = 0;
	    	}
	    }
	    
	    System.out.println(chain.toString());
	    System.out.println(chain.get(0));
	    
	    System.out.println(word + " is a pyramid");
	}

}
