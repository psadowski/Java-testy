package MavenLab03.Zad02;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HultajChochlaExceptionTest {
	private Kontrakt kontrakt;
	
	@Before
	public void setUp() throws Exception {
		kontrakt = new Kontrakt();
	}

	@Test
	public void HultajChochlaException() {
		try{
			kontrakt.HultajChochla(6);
		} catch(NieudanyPsikusException e) {
			assertTrue(true);
		}
		
	}
	
	@Test
	public void HultajChoclaEdgeValuesMaxTest(){
		try{
			kontrakt.HultajChochla(9);
		} catch(NieudanyPsikusException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void HultajChoclaEdgeValuesMinTest(){
		try{
			kontrakt.HultajChochla(-9);
		} catch(NieudanyPsikusException e) {
			assertTrue(true);
		}
	}
	
	@After
	public void tearDown() throws Exception {
		kontrakt = null;
	}

	

}
