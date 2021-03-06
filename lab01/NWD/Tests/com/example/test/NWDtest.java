package com.example.test;
import static org.junit.Assert.*;
import com.example.nwd.NWD;
import org.junit.Before;
import org.junit.Test;
public class NWDtest {
	private NWD test;
	
	@Before
	public  void setUp(){
		test = new NWD();
	}
	
	@Test
	
	public  void nwdCalc(){
		assertEquals(4, test.NWD_calc(4,8));
	}
	
	public void nwdCalc2(){
		assertNotSame(4, test.NWD_calc(4, 8));
	}
	@Test(expected = IllegalArgumentException.class)
	
	public void zeroNwd(){
		test.NWD_calc(0, 5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	
	public void belowZeroNwd(){
		test.NWD_calc(-4, 5);
	}
	
}
