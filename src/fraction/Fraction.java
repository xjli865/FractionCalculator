package fraction;

/**
 * This is a <b> Fraction </b> calculator. <p> In this Fraction API,
 * the user enters fractions or Integers to do arithmetic calculations.
 * The program accepts a list of commands, displaying at beginning of
 * the program. The user needs to first enter a number, and then tell 
 * the calculator program what to do via commands.<p>
 * 
 * The program can detect invalid user input. The user can follow the
 * message display on the calculator to continue.  
 * @author Jenny Li
 * @version 0
 */
public class Fraction implements Comparable {

	private int denominator;
	private int numerator;
	
	/**
	 * Constructs two integers into Fraction type
	 * <ol>
	 *   <li> detect if denominator of fraction is zero </li>
	 * </ol>
	 * @param n A numerator
	 * @param d A denominator
	 */
	public Fraction(int n, int d){
			this.numerator = n;
			this.denominator = d;
			normalize();
		if (denominator == 0){
			throw new ArithmeticException("Don't divide by zero");
		}
	}
	
	/**
	 * Constructs a Integers into Fraction type;
	 * @param wholeNumber A integer/fraction number 
	 */
	public Fraction(int wholeNumber){
		this.numerator = wholeNumber;
		this.denominator = 1;
		
	}
	
	/**
	 * Constructs a String into Fraction type
	 * <ol>
	 *   <li> detect if denominator of fraction is zero </li>
	 * </ol>
	 * @param fraction A integer/fraction number  
	 */
	public Fraction (String fraction){
		int n;
		int d;
		if(fraction.contains("/")){
			String[] part = fraction.split("/");
			String part1 = part[0].trim();
			n = Integer.parseInt(part1);
			String part2 = part[1].trim();
			d = Integer.parseInt(part2);
		}else{
			n = Integer.parseInt(fraction);
			d = 1;
		}
		this.numerator = n;
		this.denominator = d;
		normalize();
	}
	
	/**
	 * Normalize a fraction in the lowest term.
	 * <ol>
	 *   <li>Use Euclid's algorithm to find Greatest Common Divisor (GCD),</li>
	 *   <li>Divide numerator by GCD,</li>
	 *   <li>Divide denominator by GCD,</li>
	 * </ol>
	 */
	private void normalize(){
		int n = numerator;
		int d = denominator;
		int GCD = 0;
		int remainder = numerator % denominator;
		if (remainder == 0){
			GCD = denominator;
		}else{
			while (remainder != 0){
				n = d;
				d = remainder;
				remainder = n % d;
				if (remainder == 0){
					GCD = d;
				}
			}
		}
		this.numerator = numerator/GCD;
		this.denominator = denominator/GCD;
		if(denominator < 0){
			numerator *= -1;
			denominator *= -1;
		}
	}
	
	/**
	 * Returns a string that represents this object
	 */
	@Override 
	public String toString(){
		if (this.denominator == 1 && this.numerator != 0){
			return numerator + "" ;
		}else{
			return this.numerator + "/" + this.denominator;
		}
	}
	
    /**
     * Adds two fractions
     * @param f A fraction
     * @return A new fraction that is the sum of two fractions
     */
	public Fraction add(Fraction f){
		int newNumerator = this.numerator * f.denominator + this.denominator*f.numerator;
		int newDenominator = this.denominator * f.denominator;
		Fraction fraction = new Fraction(newNumerator, newDenominator);
		return fraction;
	}
	
	/**
	 * Subtracts two fractions
	 * @param f A fraction
	 * @return A new fraction that is the difference of two fractions
	 */
	public Fraction subtract(Fraction f){ 
		int newNumerator = this.numerator * f.denominator - this.denominator*f.numerator;
		int newDenominator = this.denominator * f.denominator;
		Fraction fraction = new Fraction(newNumerator, newDenominator);
		return fraction;
	}
	
	/**
	 * Multiplies two fractions
	 * @param f A fraction 
	 * @return A new fraction that is the product of two fractions
	 */
	public Fraction multiply(Fraction f){
		int newNumerator = this.numerator*f.numerator;
		int newDenominator = this.denominator * f.denominator;
		Fraction fraction = new Fraction(newNumerator, newDenominator);
		return fraction;		
	}
	
	/**
	 * Divides two fractions
	 * @param f A fraction
	 * @return A new fraction that is the quotient of two fractions
	 */
	public Fraction divide(Fraction f){
		int newNumerator = this.numerator*f.denominator;
		int newDenominator = this.denominator * f.numerator;
		Fraction fraction = new Fraction(newNumerator, newDenominator);
		return fraction;
	}
	
	/**
	 * Takes absolute value of a fraction 
	 * @return A fraction that is the absolute value of original fraction
	 */
	public Fraction abs(){
		int newDenominator = Math.abs(denominator);
		int newNumerator = Math.abs(numerator);
		Fraction fraction = new Fraction(newNumerator, newDenominator);
		return fraction;	
	}
	
	/**
	 * Makes a fraction into a negative value
	 * @return A fraction that is the negative value of original fraction
	 */
	public Fraction negate(){
		int newNumerator = numerator* -1;
		Fraction fraction = new Fraction(newNumerator, denominator);
		return fraction;	
	}
	
	/**
	 * Makes the inverse of a fraction
	 * @return A fraction that is the inverse value of original fraction
	 */
	public Fraction inverse(){
		int newNumerator = denominator;
		int newDenominator = numerator;
		Fraction fraction = new Fraction(newNumerator, newDenominator);
		if (denominator == 0){
			throw new ArithmeticException ("Can not be divide by zero!");
		}
		return fraction;
	}
	
	/**
	 * Returns true if a Fraction object that represents the same Fraction
	 * value as this object
	 */
	@Override
	public boolean equals(Object o){
		if (o instanceof Fraction){
			Fraction f = (Fraction)o;
			if (f.denominator == this.denominator && f.numerator == this.numerator){
				return true;
			}else {
				return false;
			}
		}else{
			return false;
		}
	}
	
	/**
	 * Compares this one Fraction instance with another.
	 */
	@Override
	public int compareTo(Object o){
		if (o instanceof Fraction){
			Fraction f =(Fraction) o;
			if (this.subtract(f).numerator < 0){
				return -1;
			}else if (this.subtract(f).numerator == 0) {
				return 0;
			}else if(this.subtract(f).numerator > 0){
				return 1;
			}
		}else if(o instanceof Fraction){
			int f = (Integer) o;
			if (this.subtract(new Fraction(f)).numerator < 0){
				return -1;
			}else if (this.subtract(new Fraction(f)).numerator == 0){
				return 0;
			}else if (this.subtract(new Fraction(f)).numerator > 0){
				return 1;
			}
		}
		else{
			throw new ClassCastException();
		}
		return 0;
	}
	
	
	
}

	
	


	