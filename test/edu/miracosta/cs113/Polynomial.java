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
		
		System.out.print("Top of addTerm() myPoly.size(): " + myPoly.size() + "\n");
		int count = 0;
		LinkedList<Term> tempList = new LinkedList<Term>();
		boolean sorted = false;
		boolean newTermAdded = false;
		
		if(myPoly.size() == 0) {
			myPoly.addFirst(o);
		} else {
			
			while(myPoly.size() != 0) {
				System.out.println("myPoly.size(): " + myPoly.size());
				if(o.getExponent() > myPoly.get(myPoly.size()-1).getExponent() /*&& myPoly.size() != 1*/) {
					//System.out.println("o.getExponent():" + o.getExponent());
					//System.out.println("myPoly.get(myPoly.size()-1).getExponent()" + myPoly.get(myPoly.size()-1).getExponent());
					tempList.addFirst(myPoly.pollLast());
					//System.out.println("tempList.addFirst(): " + tempList);
					//System.out.println("myPoly:" + myPoly);
				} else if(o.getExponent() == myPoly.get(myPoly.size()-1).getExponent()){
					Term tempTerm = new Term(myPoly.get(myPoly.size()-1).getCoefficient() + o.getCoefficient(),o.getExponent());
					tempList.addFirst(tempTerm);
					myPoly.removeLast();
					newTermAdded = true;
				}
					else{
						//System.out.println("Added first" + o);
					tempList.addFirst(o);
					newTermAdded = true;
					//System.out.println("tempList from else: " + tempList);
					//System.out.println("myPoly.size(): " + myPoly.size());
				}
				if(myPoly.size() == 0 && !newTermAdded) {
					tempList.addFirst(o);
				}
				 while(myPoly.size() != 0 && newTermAdded) {
					 tempList.addFirst(myPoly.pollLast());
			 }
			}
		} 
		
			
		

			System.out.print("myPoly.size() after while loop: " + myPoly.size() + "\n");
				//then consider what to do when exponents are equal
		
				//repopulate myPoly
				System.out.println("tempList.size(): " + tempList.size());
				System.out.print("tempList before last while loop: " + tempList + "\n");
				while(tempList.size() != 0) {
					myPoly.addFirst(tempList.removeLast());
				}
				
		
				
	System.out.print("From myPolynomial: " + myPoly + "\n");
		
		
	}
	
	
	
		
	public Term getTerm(int i) {
		Term temp = myPoly.get(i);
		
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
		if(myPoly.size() == 0)
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
