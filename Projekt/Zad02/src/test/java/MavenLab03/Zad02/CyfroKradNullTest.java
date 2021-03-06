package MavenLab03.Zad02;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
public class CyfroKradNullTest {
	private Kontrakt kontrakt;
	@Before
	public void setUp() throws Exception {
		kontrakt = new Kontrakt();
	}
	
	@Test
	public void NullLiczbaTest() {
		Integer result = kontrakt.CyfroKrad(3);
		assertThat(result, is(equalTo(null)));
	}
	
	@Test
	public void NotNtullLiczbaTest(){
		Integer result = kontrakt.CyfroKrad(13);
		assertThat(result, is(not(equalTo(null))));
	}
	
	@Test
	public void EdgeTestMax(){
		Integer result = kontrakt.CyfroKrad(9);
		assertThat(result, is(equalTo(null)));
	}
	
	@Test
	public void EdgeTestMin(){
		Integer result = kontrakt.CyfroKrad(-9);
		assertThat(result, is(equalTo(null)));
	}

	@Test
	public void EdgeIntTestMax(){
		Integer result = kontrakt.CyfroKrad(Integer.MAX_VALUE);
		assertThat(result, is(not(equalTo(null))));
	}

	@Test
	public void EdgeIntTestMin(){
		Integer result = kontrakt.CyfroKrad(Integer.MIN_VALUE);
		assertThat(result, is(not(equalTo(null))));
	}
	
	@After
	public void tearDown() throws Exception {
		kontrakt = null;
	}


}
