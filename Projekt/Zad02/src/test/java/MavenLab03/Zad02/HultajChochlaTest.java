package MavenLab03.Zad02;

import static org.hamcrest.Matchers.hasItem;
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
public class HultajChochlaTest {
	private Kontrakt kontrakt;
	private int testData;
	private ArrayList<Integer> expectedResult;
	
	@Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[][]{ 
                	{123, new ArrayList<Integer>() {{ add(213); add(312); add(231); add(321); add(132); add(123);}}},
                	{-123, new ArrayList<Integer>() {{ add(-123); add(-213); add(-312); add(-231); add(-321); add(-132);}}},
                	{333, new ArrayList<Integer>() {{ add(333); }}},
                	{-10, new ArrayList<Integer>() {{add(-01); add(-10);}}},
                	{-111, new ArrayList<Integer>() {{add(-111);}}}
                });
    }
	
	@Before
	public void setUp() throws Exception {
		kontrakt = new Kontrakt();
	}

	public HultajChochlaTest(int data, ArrayList<Integer>expected){
		testData = data;
		expectedResult = expected;
	}
	
	
	@Test
	public void HultajChoclaTest() throws NieudanyPsikusException {
		int result = kontrakt.HultajChochla(testData);
		assertThat(expectedResult, hasItem(result));
	}
	
	@After
	public void tearDown() throws Exception {
		kontrakt = null;
	}

	

}
