package edu.miracosta.cs113;

import java.util.regex.Pattern;

public class Term implements Comparable<Term>{

	int c;
	int e;
	//Term constructors
	
	public Term() {}
	
	public Term(String t) {}
	
	//int c represents coefficient
	//int e represents exponent
	
	/*public Term(int c) {
		setCoefficient(c);
	}
	*/
	
	public Term(int c, int e) {}
	
	public Term(Term original) {}
	
	int getCoefficient() {
		
		return c;
	}
	
	int getExponent() {
		
		return e;
	}
	
	void setCoefficient (int c) {
		this.c = c;
	}
	
	void setExponent(int e) {
		this.e = e;
	}
	
	void setAll(int c, int e) {
		this.c = c;
		this.e = e;
	}

	protected Term clone() {
		Term t = null;
		return t;
	}
	
	@Override
	public String toString() {
		String c;
		String e;
		String ce = null;
		
		if(this.c == 0) {
			c = "";
			e = "";
			ce = c+e;
		} else {
			c = Integer.toString(this.c);
			e = Integer.toString(this.e);
			ce = c+e;}
		
		return ce;
	}
	
	public String replaceAll(String regex, String replacement) {  
        return Pattern.compile(regex).matcher((CharSequence) this).replaceAll(replacement);  
} 
	
	@Override
	public int compareTo(Term o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
