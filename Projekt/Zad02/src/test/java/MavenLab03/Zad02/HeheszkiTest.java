package MavenLab03.Zad02;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)
public class HeheszkiTest {
	private Kontrakt kontrakt;
	private int testData;
	private int expectedResult;
	
	@Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[][]{ 
                	{123, 123},
                	{234, 234},
                	{18623123,18623123},
                	{712812,712812}
                });
    }
	
	@Before
	public void setUp() throws Exception {
		kontrakt = new Kontrakt();
	}

	public HeheszkiTest(int data, int expected){
		testData = data;
		expectedResult = expected;
	}
	
	
	@Test
	public void HeheszkiValTest() {
		int result = kontrakt.Heheszki(testData);
		assertThat(result, is(both(greaterThanOrEqualTo(0)).and(lessThan(expectedResult))));
	}
	
	@Test
	public void HeheszkiZeroTest(){
		int result = kontrakt.Heheszki(0);
		assertThat(result, is(equalTo(0)));
	}
	
	@After
	public void tearDown() throws Exception {
		kontrakt = null;
	}

	

}
