package com.rennicke;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.glassfish.api.container.RequestDispatcher;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    //
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String text1 = request.getParameter("text1"); 
		
		String message = text1 + " is a pyramid word";
		
		String word = text1.toLowerCase();
	    
	    //List to keep track of amount of chars
	    ArrayList<Integer> chain = new ArrayList();
	    for(int i = 0; i < 26; i++) {
	    	chain.add(0);
	    }
	    
	    char[] chars = word.toCharArray();
	    
	    //checks to see if the input if too large
	    if(chars.length > 1000) {
	    	message = "Error, input is too large";
	    }
	    
	    //runs through each char
	    for(int i = 0; i < chars.length; i++) {
	    	//checks if char is a letter
	    	if (!Character.isAlphabetic(chars[i])){
	    		message = "Error, invalid input";
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
	    		message = text1 + " is NOT a pyramid word";
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
	    //finished
	    request.setAttribute("message", message);
        request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
