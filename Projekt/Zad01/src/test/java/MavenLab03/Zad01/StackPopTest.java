package MavenLab03.Zad01;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class StackPopTest {

	private MyStackImpl stack;
	private ArrayList<Integer> testData;
	private ArrayList<Integer> expectedResult;
	
	@Parameters
	public static Collection<Object[]> data() {
		 Object[][] c = { 
        	{new ArrayList<Integer>() {{ add(1); add(2); add(3); }}, new ArrayList<Integer>() {{add(1); add(2);}}},
        	{new ArrayList<Integer>() {{ add(1);}}, new ArrayList<Integer>() },
        	{new ArrayList<Integer>() {{ add(1); add(2); add(3); add(4); add(5); }},new ArrayList<Integer>() {{ add(1); add(2); add(3); add(4);}}}	
        };
      return  Arrays.asList(c);
	}
	
	@Before
	public void setUp() throws Exception {
		stack = new MyStackImpl();
	}

	public StackPopTest(ArrayList<Integer>data, ArrayList<Integer>expected){
		testData = data;
		expectedResult = expected;
	}
	
	
	@Test
	public void StackPopCorrectTest() {
		stack.setStack(testData);
		stack.MyPop();
		List<Integer> result = stack.getStack();
		assertEquals(expectedResult, result);
	}
	
	
	
	@After
	public void tearDown() throws Exception {
		stack = null;
	}
	

}

