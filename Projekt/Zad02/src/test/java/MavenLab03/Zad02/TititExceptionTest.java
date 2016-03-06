package MavenLab03.Zad02;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TititExceptionTest {
	private Kontrakt kontrakt;
	
	@Before
	public void setUp() throws Exception {
		kontrakt = new Kontrakt();
	}

	@Test
	public void TititException() {
		try{
			kontrakt.Titit(12312,0);
		} catch(IllegalArgumentException e) {
			assertTrue(true);
		}
		
	}
	
	
	@After
	public void tearDown() throws Exception {
		kontrakt = null;
	}

	

}
