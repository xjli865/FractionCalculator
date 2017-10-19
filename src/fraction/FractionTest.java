package fraction;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FractionTest {

	@Test
	public void testConstructor() {
		assertEquals("3/5", new Fraction(3, 5).toString());
		assertEquals("-2/3", new Fraction(8, -12).toString());
		assertEquals("5/2", new Fraction(10, 4).toString());
		assertEquals("4", new Fraction(20, 5).toString());
		assertEquals("1/20", new Fraction(4, 80).toString());
		assertEquals("20", new Fraction(20).toString());
		assertEquals("0/1", new Fraction(0).toString());
		assertEquals("10/3", new Fraction("10 / 3").toString());
		assertEquals("-5/3", new Fraction("10 / -6").toString());
		assertEquals("-10", new Fraction("-10").toString());
		assertEquals("0/1", new Fraction("0").toString());
	}
	
	@Test(expected = NumberFormatException.class)
	public void testMalformedInput() {
		new Fraction("123abc");
	}
	
	@Test(expected=ArithmeticException.class)
	public void testDivideByZero() {
		new Fraction(3, 2);
		new Fraction("-1/0");
		Fraction errorTest = new Fraction(8,-12);
		errorTest.add(new Fraction(2, 0));
		errorTest.subtract(new Fraction("5/0"));
	}

	@Test
	public void testAdd() {
	    Fraction base1 = new Fraction(8,-12);
	    assertEquals("4/3", base1.add(new Fraction(2,1)).toString());
	    Fraction base2 = new Fraction("25/12");
	    assertEquals("17/6", base2.add(new Fraction("3/4")).toString());
	}
	
	@Test 
	public void testSubtract(){
		Fraction base1 = new Fraction(8,-12);
		assertEquals("-8/3", base1.subtract(new Fraction(2,1)).toString());
		Fraction base2 = new Fraction(18/3);
		assertEquals("28/5", base2.subtract(new Fraction(2,5)).toString());
	}
	
	@Test 
	public void testMultiply(){
		Fraction base1 = new Fraction(8,-12);
		assertEquals("-4/3", base1.multiply(new Fraction(2,1)).toString());
		Fraction base2 = new Fraction(6);
		assertEquals("-10/3", base2.multiply(new Fraction("5/ -9")).toString());
	}
	
	@Test
	public void testDivide(){
		Fraction base1 = new Fraction(8,-12);
		assertEquals("-1/3", base1.divide(new Fraction(2,1)).toString());
		Fraction base2 = new Fraction(6);
		assertEquals("-54/5", base2.divide(new Fraction("5/ -9")).toString());
	}
	
	@Test
	public void testAbs(){
		Fraction base1 = new Fraction(8,-12);
		assertEquals("2/3",base1.abs().toString());
		Fraction base2 = new Fraction("-42/2");
		assertEquals("21",base2.abs().toString());
		Fraction base3 = new Fraction(6,4);
		assertEquals("3/2",base3.abs().toString());
	}
	
	@Test
	public void testNegate(){
		Fraction base1 = new Fraction(8,-12);
		assertEquals("2/3",base1.negate().toString());
		Fraction base2 = new Fraction("42/2");
		assertEquals("-21",base2.negate().toString());
	}
	
	@Test
	public void testInverse(){
		Fraction base1 = new Fraction(8,-12);
		assertEquals("-3/2",base1.inverse().toString());
		Fraction base2 = new Fraction("42/2");
		assertEquals("1/21",base2.inverse().toString());
	}
	
	@Test
	public void testEquals(){
		Fraction base1 = new Fraction(2,1);
		assertTrue(base1.equals(new Fraction("2/1")));
		Fraction base2 = new Fraction(0);
		assertTrue(base2.equals(new Fraction("0/1")));	
	}	
	
	@Test
	public void testCompareTo(){
		Fraction base1 = new Fraction(2, 11);
		assertTrue(base1.compareTo(new Fraction("2/11")) == 0);
		Fraction base2 = new Fraction(3/11);
		assertTrue(base2.compareTo(new Fraction("-11/12")) > 0);
		Fraction base3 = new Fraction(1, 4);
		assertTrue(base3.compareTo(new Fraction("4")) < 0);
	}
}
