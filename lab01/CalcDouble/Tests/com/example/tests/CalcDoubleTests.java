package com.example.tests;

import static org.junit.Assert.*;
import com.example.calcdouble.CalcDouble;
import org.junit.Before;
import org.junit.Test;

public class CalcDoubleTests {
	private CalcDouble calc = new CalcDouble();
	
	@Test
	
	public void addD_check(){
		assertEquals(2.668634, calc.addD(1.323400 , 1.345234), 0.00001);
	}
	
	@Test
	
	public void subD_check(){
		assertEquals(-0.021834, calc.subD(1.323400 , 1.345234), 0.00001);
	}
	
	@Test
	
	public void multD_check(){
		assertEquals(1.78028268, calc.multD(1.323400 , 1.345234), 0.00001);
	}
	
	@Test
	
	public void divD_check(){
		assertEquals( 0.983769367, calc.divD(1.323400 , 1.345234), 0.00001);
	}
	
	@Test
	
	public void greaterD_check(){
		assertEquals(true, calc.greaterD(3, 2));
	}
	
}
