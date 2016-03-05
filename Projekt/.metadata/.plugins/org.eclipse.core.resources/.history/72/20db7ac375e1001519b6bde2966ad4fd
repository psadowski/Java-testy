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

public class StackPushTest {
	private MyStackImpl stack;
	private ArrayList<Integer> beforePush;
	private int pushedVal;
	private ArrayList<Integer> expectedResult;
	
	@Parameters
	public static Collection<Object[]> data() {
		 Object[][] c = { 
        	{new ArrayList<Integer>() {{ add(1); add(2); add(3); }}, 4, new ArrayList<Integer>() {{add(1); add(2); add(3); add(4);}}},
        	{new ArrayList<Integer>(), 1,  new ArrayList<Integer>() {{add(1);}} },
        	{new ArrayList<Integer>() {{add(1);}}, 4, new ArrayList<Integer>() {{add(1); add(4);}}},
        	{new ArrayList<Integer>() {{add(1);}}, Integer.MAX_VALUE, new ArrayList<Integer>() {{add(1); add(2147483647);}}},
        	{new ArrayList<Integer>() {{add(1);}}, Integer.MIN_VALUE, new ArrayList<Integer>() {{add(1); add(-2147483648);}}}	
        };
      return  Arrays.asList(c);
	}
	
	
	@Before
	public void setUp() throws Exception {
		stack = new MyStackImpl();
	}

	
	public StackPushTest(ArrayList<Integer>data, int value, ArrayList<Integer>expected){
		beforePush = data;
		pushedVal = value;
		expectedResult = expected;
	}
	
	@Test
	public void StackPopCorrectTest() {
		stack.setStack(beforePush);
		stack.MyPush(pushedVal);
		List<Integer> result = stack.getStack();
		assertEquals(expectedResult, result);
	}
	
	
	@After
	public void tearDown() throws Exception {
		stack = null;
	}

	

}
