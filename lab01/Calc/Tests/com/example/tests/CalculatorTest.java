package com.example.tests;

import static org.junit.Assert.*;
import com.example.calc.Calculator;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	
	private Calculator test;
	
	@Before
	public  void setUp(){
		test = new Calculator();
	}
	
	@Test
	
	public void addCheck(){

		assertEquals(5, test.add(3, 2));
	}

	@Test
	
	public void subCheck(){
		assertEquals(1, test.sub(3, 2));
	}
	
	@Test
	
	public void multCheck(){
		assertEquals(6, test.mult(3,2));
	}
	
	@Test
	
	public void divCheck(){
		assertEquals(2, test.div(4, 2));
	}
	
	@Test
	
	public void greaterCheck(){
		assertEquals(true, test.greater(3, 2));
	}
	
	@Test(expected = ArithmeticException.class)
	
	public void zeroCheck(){
		test.div(4 , 0);
	}
	


}
