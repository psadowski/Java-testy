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
public class NieksztaltekCustomValuesTest {

	private Kontrakt kontrakt;
	private int testData;
	private ArrayList<Integer> expectedResult;
	
	@Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[][]{ 
                	{376, new ArrayList<Integer>() {{ add(876); add(316); add(379);}}},
                	{-192763505, new ArrayList<Integer>() {{ add(-192768505); add(-192163505); add(-192793505);}}},
                	{376376376, new ArrayList<Integer>() {{ add(876876876); add(316316316); add(379379379);}}},
                });
    }
	
	@Before
	public void setUp() throws Exception {
		kontrakt = new Kontrakt();
	}

	public NieksztaltekCustomValuesTest(int data, ArrayList<Integer>expected){
		testData = data;
		expectedResult = expected;
	}
	
	
	@Test
	public void NieksztaltekTest() {
		int result = kontrakt.Nieksztaltek(testData);
		assertThat(expectedResult, hasItem(result));
	}
	
	@After
	public void tearDown() throws Exception {
		kontrakt = null;
	}

}
