package MavenLab03.Zad02;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import static org.hamcrest.Matchers.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)

public class CyfroKradTest {
	private Kontrakt kontrakt;
	private int testData;
	private ArrayList<Integer> expectedResult;
	
	@Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[][]{ 
                	{123, new ArrayList<Integer>() {{ add(12); add(23); add(13); }}},
                	{-123, new ArrayList<Integer>() {{ add(-12); add(-23); add(-13); }}},
                	{333, new ArrayList<Integer>() {{ add(33); }}},
                	{4567, new ArrayList<Integer>(){{add(456);add(457);add(467);add(567);}}},
                	{-10, new ArrayList<Integer>() {{add(-1); add(-0);}}}
                });
    }
	
	@Before
	public void setUp() throws Exception {
		kontrakt = new Kontrakt();
	}
	
	public CyfroKradTest(int data, ArrayList<Integer>expected){
		testData = data;
		expectedResult = expected;
	}
	
	@Test
	public void CyfoKradPramTest() {
		int result = kontrakt.CyfroKrad(testData);
		assertThat(expectedResult, hasItem(result));
	}
	
	
	@After
	public void tearDown() throws Exception {
		kontrakt = null;
	}



}
