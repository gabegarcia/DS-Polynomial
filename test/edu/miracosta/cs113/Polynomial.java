package edu.miracosta.cs113;

import java.util.ArrayList;
import java.util.LinkedList;



public class Polynomial extends Term {
	
	
	//private Node<Term> tempNode = new Node<Term>();
	private static int listSize = 0;
	//private Node<Term> head = null;
	
	//Node inner class
	

	
	private LinkedList<Term> myPolynomial = new LinkedList<Term>();
	
	//Constructors
	public Polynomial() {
		//reset size
		listSize = 0;
	}
	
	public Polynomial(Polynomial original) {
		Polynomial newPolynomial = new Polynomial(original);
	}
	
	//Methods
	//addTerm is similar to addFirst()
	public void addTerm(Term o) {
		
		System.out.print("listSize: " + listSize + "\n");
				
		if(listSize == 0) {
			
			myPolynomial.addFirst(o);
		
		} else if(o.getExponent() < myPolynomial.get(listSize-1).getExponent()) {
				
				myPolynomial.addLast(o);
			
		} else 
				
			myPolynomial.addFirst(o);
					
					
		System.out.print("From myPolynomial: " + myPolynomial + "\n");
		
		listSize++;
	}
	
	/*
	private void addFirst(Term item) {
		head = new Node<Term>(item, head);
				
	}
	
	private void addAfter(Node<Term> node, Term item) {
		node.next = new Node<Term>(item, node.next);
	}
	
	private Node<Term> getNode(int index){
		Node<Term> node = head;
		int i = 0;
		while(i < index && node != null) {
			node = node.next;
			i++;
		}
		return node;
	}
*/
	
	public Term getTerm(int i) {
		
		Term temp = new Term();
		return temp; 
	}
	
	public void add(Polynomial p) {
		
	}
	
	public int getNumTerms() {
		//int numTerms = this.size();
		
		return listSize;
	}
	
	@Override
	public String toString() {
		//String c = Integer.toString(this.getCoefficient());
		//String e = Integer.toString(this.getExponent());
		String polyStr, temp;
		
		//handle x = 0
		if(listSize == 0)
			return "0";
		
		temp = myPolynomial.toString();
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
