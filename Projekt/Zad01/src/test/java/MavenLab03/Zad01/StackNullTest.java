package MavenLab03.Zad01;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StackNullTest {
	private MyStackImpl stack ;
	
	@Before
	public void setUp() throws Exception {
		stack = new MyStackImpl();
	}

	@Test
	public void NullStackTest() {
		stack.setStack(null);
		boolean result = stack.IsNull();
		assertThat(result, is(equalTo(true)));
		assertThat(stack.getStack(), is(equalTo(null)));
	}
	
	@Test
	public void NotNullStackTest() {
		stack.setStack(new ArrayList<Integer>());
		boolean result = stack.IsNull();
		assertThat(result, is(equalTo(false)));
		stack.MyPush(3);
		assertThat(stack.getStack(), is(not(equalTo(null))));
		assertThat(stack.getStack().size(), is(equalTo(1)));
		
	}
	
	@After
	public void tearDown() throws Exception {
		stack = null;
	}


}
