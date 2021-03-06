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
import static org.hamcrest.Matchers.*;
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
		ArrayList<Integer> result = stack.getStack();
		assertThat(result, is(equalTo(expectedResult)));

	}

	@Test
	public void StackPopNaiveTest(){
		stack.setStack(new ArrayList<Integer>());
		ArrayList<Integer> result = stack.getStack();
		stack.MyPush(3);
		assertThat(result, is(not(equalTo(null))));
		assertThat(result.size(), is(equalTo(1)));
		stack.MyPop();
		assertThat(result, is(not(equalTo(null))));
		assertThat(result.size(), is(equalTo(0)));
	}
	
	@After
	public void tearDown() throws Exception {
		stack = null;
	}
	

}

