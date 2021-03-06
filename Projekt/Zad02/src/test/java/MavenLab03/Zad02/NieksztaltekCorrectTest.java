package MavenLab03.Zad02;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import static org.hamcrest.Matchers.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class NieksztaltekCorrectTest {

	private Kontrakt kontrakt;
	private int testData;
	private int expectedResult;
	
	@Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[][]{ 
                	{3, 8},
                	{7, 1},
                	{6, 9},
                	{-3334, -8884},
                	{-71285, -11285},

                });
    }
	
	@Before
	public void setUp() throws Exception {
		kontrakt = new Kontrakt();
	}

	public NieksztaltekCorrectTest(int data, int expected){
		testData = data;
		expectedResult = expected;
	}
	
	
	@Test
	public void NieksztaltekTest() {
		int result = kontrakt.Nieksztaltek(testData);
		assertThat(result, is(equalTo(expectedResult)));
	}
	
	@After
	public void tearDown() throws Exception {
		kontrakt = null;
	}

}
