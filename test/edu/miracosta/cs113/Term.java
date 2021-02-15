package edu.miracosta.cs113;

import java.util.regex.Pattern;

public class Term implements Comparable<Term>, Cloneable{

	int c, e; //c = coefficient; e = exponent;
	
	//Term constructors
	
	public Term() {
		c = 1;
		e = 1;
	}
	
	public Term(String t) {
		String[] splitTerm = new String[2];
		
		//This function needs to separate the values from the string. 
		//Check is t is empty.
		if(t.length() != 0) {
			//Check is t contains "x" which will be used as a delimiter later.
			if(t.contains("x")) {
				String[] temp = t.split("x"); //split the String t using "x" as delimiter.
				splitTerm[0] = temp[0]; //store the first index into an array that is outside this scope.
						//check if temp has more than 1 index.
						if(temp.length == 2) {
						splitTerm[1] = temp[1]; //The second index is the Exponent.
						//System.out.print("splitTerm[1]: "+splitTerm[1] + "\n" + "Exponent: \n");
						//System.out.print(convertString(splitTerm[1]) + "\n");
						//send both splitTerm[0] and [1] to setters to create a Term
						setCoefficient(convertString(splitTerm[0]));
						setExponent(convertString(splitTerm[1]));
					} else {
						//If temp[] has only 1 index, then Exponent defaults to "1".
						//Send splitTerm[0] and "1" to setters to create a Term.
						//System.out.print("splitTerm[0]: " + splitTerm[0] + "\n" + "Coefficient: \n");
						//System.out.print(convertString(splitTerm[0]) + "\n");
						//System.out.print("Exponent: \n" + "1\n");
						setCoefficient(convertString(splitTerm[0]));
						setExponent(1);
					}
			} else {
				//If String t does not contain "x", add it to splitTerm[0].
				//0 is the default Exponent in this case.
				splitTerm[0] = t;
				//System.out.print("else splitTerm[0]: "+splitTerm[0]+"\n"+"Coefficient: \n");
				//System.out.print(convertString(splitTerm[0]) + "\n");
				//System.out.print("Exponent: \n" + "0\n");
				//send both splitTerm[0] and 0 value to setters
				setCoefficient(convertString(splitTerm[0]));
				setExponent(0);
			}
		} else
			System.out.print("t is empty.\n");
		
		//Then convert them to ints. 
		//Then call setters.
		
		
	}
	
	//int c represents coefficient
	//int e represents exponent
	
	/*public Term(int c) {
		setCoefficient(c);
	}
	*/
	
	public Term(int c, int e) {
		setCoefficient(c);
		setExponent(e);
	}
	
	public Term(Term original) {
		
		setCoefficient(original.getCoefficient());
		setExponent(original.getExponent());
	}
	
	//convert strings from TermTest TERMS[] to int
	int convertString(String termString) {
		int newInt = 0;
		
		if(termString.length() == 1) {
			if(termString.equals("+")) {
				newInt = 1;
				//System.out.print("newInt: " + newInt + "\n");
				return newInt;
			} else if(termString.equals("-")){
				//System.out.print("termString: " + termString + " termString.length(): " + termString.length() +"\n");
				newInt = -1;
				//System.out.print("newInt: " + newInt + "\n");
				return newInt;
				}
		} else if(termString.length() > 1) {
			if(termString.contains("+")) {
				newInt = Integer.parseInt(termString);
				//String[] temp = termString.split("+");
				//newInt = Integer.parseInt(temp[1]); //does this need to be temp[1]
				//System.out.print("newInt: " + newInt + "\n");
				return newInt;
			} else if(termString.contains("^")) {
				String[] temp = termString.split("\\^");
				newInt = Integer.parseInt(temp[1]);
				//System.out.print("Trying to parse split exponent: " + newInt + "\n");
				return newInt;
			} else {
				newInt = Integer.parseInt(termString);
				//System.out.print("newInt: " + newInt + "\n");
				return newInt;
			}
		}
		//System.out.print("Last return newInt: " + newInt + "\n");
		return newInt;
	}
	
	public int getCoefficient() {
		
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

/*
	protected Term clone() {
		Term t = null;
		return t;
	}
*/
	@Override
	public Object clone() throws CloneNotSupportedException
	{
		
		return super.clone();
	}
	
	@Override
	public String toString() {
		String c;
		String e;
		String ce = null;
		
		//handle x = 0
		
		if(this.e == 0) {
			e = "";
			
			if(this.c == 0) {
				c = "";
			} else if (this.c == 1) {
				c = "+x";
				e = "";
			} else if (this.c == -1) {
				c = "-x";
				e = "";
			} else if(this.c > 1) {
				c = "+" + Integer.toString(this.c);
				
			} else if (this.c < -1) {
				c = Integer.toString(this.c);
				
			} else
				c = "";
			
		} else if(this.e == 1) { //handle x = 1
			e = "";
			if(this.c == 0) {
				c = "";
			} else if (this.c == 1) {
				c = "+x";
				e = "";
			} else if (this.c == -1) {
				c = "-x";
				e = "";
			} else if(this.c > 1) {
				c = "+" + Integer.toString(this.c) + "x";
				
			} else if (this.c < -1) {
				c = Integer.toString(this.c) + "x";
				
			} else
				c = "";
		} else {
				e = "^" + Integer.toString(this.e);
				if(this.c == 1) {
					c = "+x";
				} else if(this.c == -1) {
					c = "-x";
				} else if(this.c > 1) {
					c = "+" + Integer.toString(this.c) + "x";
						
				} else if (this.c < -1) {
					c = Integer.toString(this.c) + "x";
						
				} else {
					c = "";
					e = "";		
				} 
				
			}
		
		ce = c + e;
		
		return ce;
	}
	
	public String replaceAll(String regex, String replacement) {  
        return Pattern.compile(regex).matcher((CharSequence) this).replaceAll(replacement);  
} 
	
	@Override
	public int compareTo(Term o) {
		// TODO Auto-generated method stub
		int compareC = 1;
		int compareE = 1;
		int result;
		
		//if coefficients are equal, then set compareC to 0 and compare Exponents
		if(this.getCoefficient() == o.getCoefficient()) {
			compareC = 0;
			if(this.getExponent() == o.getExponent()) {
				compareE = 0;
			} else if (this.getExponent() < o.getExponent()) {
				compareE = -1;
			}
		} else if(this.getCoefficient() < o.getCoefficient()) {
			compareC = -1;
			if(this.getExponent() == o.getExponent()) {
				compareE = 0;
			} else if (this.getExponent() < o.getExponent()) {
				compareE = -1;
			}
		}
		
		result = compareC + compareE;
		
		return result;
	}
	

	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Term)) return false;
        Term term = (Term) o;
        return e == term.e && c == term.c;
    }
	
}
