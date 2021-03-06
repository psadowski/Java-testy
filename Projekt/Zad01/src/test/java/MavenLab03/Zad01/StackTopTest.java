package MavenLab03.Zad01;

import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;
import static org.hamcrest.Matchers.*;
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
public class StackTopTest {
	private MyStackImpl stack;
	private ArrayList<Integer> testData;
	private int expectedResult;
	
	@Parameters
	public static Collection<Object[]> data() {
		 Object[][] c = { 
        	{new ArrayList<Integer>() {{ add(1); add(2); add(3); }}, 3},
        	{new ArrayList<Integer>() {{add(1);}}, 1},
        	{new ArrayList<Integer>() {{add(1); add(2); add(3); add(1); add(2); }}, 2}

        };
      return  Arrays.asList(c);
	}
	
	
	
	@Before
	public void setUp() throws Exception {
		stack = new MyStackImpl();
	}

	public StackTopTest(ArrayList<Integer>data, int value){
		testData = data;
		expectedResult = value;
	}
	
	
	@Test
	public void StackTopCorrectTest() {
		stack.setStack(testData);
		int result = stack.MyTop();
		assertThat(result, is(equalTo(expectedResult)));
	}
	
	
	@Test
	public void StackManyTopTest(){
		stack.setStack(new ArrayList<Integer>());
		stack.MyPush(4);
		for(int i = 1; i<=10; i++ ){
			int result = stack.MyTop();
			assertThat(result, is(equalTo(4)));
		}
	}
	

	
	@After
	public void tearDown() throws Exception {
		stack = null;
	}



}
