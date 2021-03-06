package MavenLab03.Zad02;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)
public class TititCorrectTest {
	private Kontrakt kontrakt;
	private int testData;
	private int licz_dziel;
	private boolean expectedResult;
	
	@Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[][]{ 
                	{123, 1, true},
                	{123, 200, false},
                	{12954812, 2, true},
                	{1231251251, 3, false}
                });
    }
	
	@Before
	public void setUp() throws Exception {
		kontrakt = new Kontrakt();
	}

	public TititCorrectTest(int data, int value, boolean expected){
		testData = data;
		licz_dziel = value;
		expectedResult = expected;
	}
	
	
	@Test
	public void HultajChoclaTest() {
		boolean result = kontrakt.Titit(testData, licz_dziel);
		assertThat(result, is(equalTo(expectedResult)));
	}
	
	@After
	public void tearDown() throws Exception {
		kontrakt = null;
	}

	

}
