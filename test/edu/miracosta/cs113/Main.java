package edu.miracosta.cs113;
import java.util.Scanner;  // Import the Scanner class

public class Main {
	public static void main(String args[]) {
		
		Scanner keyboard = new Scanner(System.in);
		String c = ""; //coefficient
		String e; //exponent
		String ce;
	
		
		
		Term term, term2;
		Polynomial newPoly = new Polynomial();
		
		while(c != "e") {
		
			System.out.println("Enter 'e' to exit\nEnter 'c' to clear\nEnter 'a' to add a new term\n ");
		
			c = keyboard.next();
			
						
			if(c.equals("e")) {
				System.out.println("Program exiting...");
				System.exit(0);
			} else if(c.equals("c")){
				newPoly.clear();
			}
			else if(c.equals("a"))
			{
				System.out.println("Enter a Term in this format: +4x^7:");
				c = keyboard.next();
				term = new Term(c);
				newPoly.addTerm(term);
				System.out.println("\nYour Polynomial: " + newPoly + "\n");
				//System.out.println("c: " + c);
			}
	
		}
						
		
	}
	
	

}
