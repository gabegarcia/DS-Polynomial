/**
 * DS-Polynomial Junit Testing Homework 3
 * Polynomial.java file
 * CS113
 * Mon 5:30
 * 
 * @author Gabe Garcia
 * @version 1.0
 * @since 2-27-2021
 */

package edu.miracosta.cs113;


import java.util.LinkedList;

public class Polynomial extends Term {
	
	
	private LinkedList<Term> myPoly;
	
	//Constructors
	public Polynomial() {
		
		this.myPoly = new LinkedList();
	}
	
	//copy constructor
	public Polynomial(Polynomial original) {
		//instantiate a new LinkedList; creates a new space in memory
		LinkedList<Term> tempList = new LinkedList<Term>();
		
		//populate tempList with Terms from 'original'
		for(int i = 0; i < original.myPoly.size(); i++) {
			
			int c, e;
			c = original.myPoly.get(i).getCoefficient();
			e = original.myPoly.get(i).getExponent();
						
			tempList.addLast(new Term(c, e));
			
		}
		//I think this is actually a shallow copy of a deep copy.
		myPoly = tempList;
	}
	
	//Methods
	//addTerm is similar to addFirst()
	public void addTerm(Term o) {
		
		LinkedList<Term> tempList = new LinkedList<Term>();
		
		boolean newTermAdded = false; //This boolean help identify when o is added
		
		if(myPoly.size() == 0) {
			myPoly.addFirst(o);
		} else {
			//Compare Terms in myPoly. Remove them and add them to a temp LinkedList to sort them
			while(myPoly.size() != 0) {
				System.out.println("myPoly.size(): " + myPoly.size());
				//compare Exponents
				if(o.getExponent() > myPoly.get(myPoly.size()-1).getExponent() ) {
					
					tempList.addFirst(myPoly.pollLast());
				
				} else if(o.getExponent() == myPoly.get(myPoly.size()-1).getExponent()){
					Term tempTerm = new Term(myPoly.get(myPoly.size()-1).getCoefficient() + o.getCoefficient(),o.getExponent());
					tempList.addFirst(tempTerm);
					myPoly.removeLast();
					newTermAdded = true;
				}
					else {
						
					tempList.addFirst(o);
					newTermAdded = true;
					
				}
				
				if(myPoly.size() == 0 && !newTermAdded) {
					tempList.addFirst(o);
				}
				
				 while(myPoly.size() != 0 && newTermAdded) {
					 tempList.addFirst(myPoly.pollLast());
				 }
			}
		} 
		
		//repopulate myPoly using the temp LinkedList
		while(tempList.size() != 0) {
			myPoly.addFirst(tempList.removeLast());
		}
										
	}
			
	public Term getTerm(int i) {
		
		Term temp = myPoly.get(i);
		
		return temp;
	}
	
	public void add(Polynomial p) {
		
		//Create a new Polynomial to populate with both Polynomials 
		Polynomial temp = new Polynomial();
		
		//use 'this' poly to populate temp
		//use addTerm to add and sort
		for(int i = 0; i < this.myPoly.size(); i++) {
			temp.addTerm(this.myPoly.get(i));
		}
		//use p poly to populate temp
		//use addTerm to add and sort
		for(int j = 0; j < p.myPoly.size(); j++) {
			temp.addTerm(p.myPoly.get(j));
		}
		
		//clear 'this' poly
		this.myPoly.clear();
		
		//repopulate 'this' with temp
		for(int x = 0; x < temp.myPoly.size(); x++) {
			if(temp.myPoly.get(x).getCoefficient() != 0) {
				this.addTerm(temp.myPoly.get(x));
			}
		}

	}
	
	public int getNumTerms() {
		//return the size of myPoly		
		return myPoly.size();
	}
	
	@Override
	public String toString() {
		
		String polyStr, temp;
		
		//handle x = 0
		if(myPoly.size() == 0)
			return "0";
		
		//remove unwanted chars
		temp = myPoly.toString();
		temp = temp.replace("[", "");
		temp = temp.replace("]", "");
		temp = temp.replace(",", "");
		
		
		//remove leading '+' char
		if(temp.charAt(0) == '+') {
			temp=temp.substring(1);
		} else
			return temp;
		
		return temp;
	}

	public void clear() {
		//removing all elements from myPoly
		while(myPoly.size() != 0) {
			myPoly.removeFirst();
		}
	}
	
}
