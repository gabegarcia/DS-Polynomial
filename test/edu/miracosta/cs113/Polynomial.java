package edu.miracosta.cs113;

import java.util.ArrayList;
import java.util.LinkedList;



public class Polynomial extends Term {
	
	
	//private Node<Term> tempNode = new Node<Term>();
	private static int listSize = 0;
	//private Node<Term> head = null;
	
	//Node inner class
	

	
	private LinkedList<Term> myPoly;
	
	//Constructors
	public Polynomial() {
		//reset size
		this.myPoly = new LinkedList();
	}
	
	public Polynomial(Polynomial original) {
		Polynomial newPolynomial = new Polynomial(original);
	}
	
	//Methods
	//addTerm is similar to addFirst()
	public void addTerm(Term o) {
		
		System.out.print("myPoly.size(): " + myPoly.size() + "\n");
		int i = 0;
		LinkedList<Term> tempList = new LinkedList<Term>();
		if(myPoly.size() == 0) {
			myPoly.addFirst(o);
			
		} else if(myPoly.peekLast().getExponent() > o.getExponent()) {
				System.out.print("peekLast(): " + myPoly.peekLast().getExponent() + "\n");
				System.out.print("getExponent(): " + o.getExponent() + "\n");
				myPoly.addLast(o);
			} else {
				//myPoly.addFirst(o); //TODO need to figure out how to insert if peekLast < getExponent()
				
				while(myPoly.size() != 0) {
					
					if(myPoly.peekLast().getExponent() < o.getExponent()) {
						tempList.addLast(myPoly.removeLast());
						if(myPoly.size() == 0) {
							tempList.addFirst(o);
						}
					} else {
						tempList.addFirst(o);
						tempList.addFirst(myPoly.removeLast());
						System.out.println("From tempList else statement: " + tempList);
					}
					
				}
			}
				
				
				//then consider what to do when exponents are equal
		
				//repopulate myPoly
				System.out.println("tempList.size(): " + tempList.size());
				while(tempList.size() != 0) {
					myPoly.addFirst(tempList.removeLast());
				}
				
	System.out.print("From myPolynomial: " + myPoly + "\n");
		
		
	}
	
		
	public Term getTerm(int i) {
		
		Term temp = new Term();
		return temp; 
	}
	
	public void add(Polynomial p) {
		
	}
	
	public int getNumTerms() {
		//int numTerms = this.size();
		
		return myPoly.size();
	}
	
	@Override
	public String toString() {
		//String c = Integer.toString(this.getCoefficient());
		//String e = Integer.toString(this.getExponent());
		String polyStr, temp;
		
		//handle x = 0
		if(listSize == 0)
			return "0";
		
		temp = myPoly.toString();
		temp = temp.replace("[", "");
		temp = temp.replace("]", "");
		temp = temp.replace(",", "");
		
		if(temp.charAt(0) == '+') {
			temp=temp.substring(1);
		}
		
		
		System.out.print("From toString(): " + temp + "\n");
		return temp;
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
}
