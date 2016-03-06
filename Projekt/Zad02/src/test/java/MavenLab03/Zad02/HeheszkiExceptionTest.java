package MavenLab03.Zad02;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HeheszkiExceptionTest {
	private Kontrakt kontrakt;
	
	@Before
	public void setUp() throws Exception {
		kontrakt = new Kontrakt();
	}

	@Test
	public void HeheszkiZeroTest() {
		try{
			kontrakt.Heheszki(-34);
		} catch(IllegalArgumentException e) {
			assertTrue(true);
		}
		
	}
	
	@Test
	public void HeheszkiMinIntTest(){
		try{
			kontrakt.Heheszki(Integer.MIN_VALUE);
		} catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	
	@After
	public void tearDown() throws Exception {
		kontrakt = null;
	}

	

}
