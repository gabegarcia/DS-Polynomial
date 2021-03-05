/**
 * DS-Polynomial Junit Testing Homework 3
 * Driver file
 * CS113
 * Mon 5:30
 * 
 * @author Gabe Garcia
 * @version 1.0
 * @since 2-27-2021
 */


package edu.miracosta.cs113;
import java.util.Scanner;  // Import the Scanner class

public class Main {
	public static void main(String args[]) {
		
		Scanner keyboard = new Scanner(System.in);
		String c = " "; //coefficient
		String e; //exponent
		String ce;
	
		
		
		Term term, term2;
		Polynomial newPoly = new Polynomial();
		Polynomial secondPoly = new Polynomial();
		
		System.out.println("Do stuff to your first polynomial:");
		
		while(c.charAt(0) != 'e') {
		
			System.out.println("Enter 'e' to exit Polynomial Build\nEnter 'c' to clear\nEnter 'a' to add a new term\n ");
		
			c = keyboard.next();
			
						
			if(c.equals("e")) {
				System.out.println("Exiting Polynomial Build...");
				
			} else if(c.equals("c")){
				newPoly.clear();
			}
			else if(c.equals("a"))
			{
				System.out.println("Enter a Term in this format: +4x^7:");
				c = keyboard.next();
				term = new Term(c);
				newPoly.addTerm(term);
				System.out.println("\nYour Polynomial newPoly: " + newPoly + "\n");
				//System.out.println("c: " + c);
			}
	
		}
		
		c = " "; //reset c to "";
		
		System.out.println("Build your second polynomial...");
		while(c.charAt(0) != 'e') {
			
			System.out.println("Enter 'e' to exit Polynomial Build\nEnter 'c' to clear\nEnter 'a' to add a new term\n ");
		
			c = keyboard.next();
			
						
			if(c.equals("e")) {
				System.out.println("Exiting Polynomial Build...");
				
			} else if(c.equals("c")){
				secondPoly.clear();
			}
			else if(c.equals("a"))
			{
				System.out.println("Enter a Term in this format: +2x^7:");
				c = keyboard.next();
				term = new Term(c);
				secondPoly.addTerm(term);
				System.out.println("\nYour Polynomial secondPoly: " + secondPoly + "\n");
				//System.out.println("c: " + c);
			}
	
		}
		
		System.out.println("Adding two polynomials together...");
		newPoly.add(secondPoly);
		System.out.println("Your updated newPoly: " + newPoly);
						
		
	}
	
	

}
