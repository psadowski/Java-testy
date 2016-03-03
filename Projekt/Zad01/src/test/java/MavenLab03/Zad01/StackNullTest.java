package MavenLab03.Zad01;

import static org.junit.Assert.*;

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
		assertEquals(true, result);
	}
	
	@Test
	public void NotNullStackTest() {
		stack.setStack(new ArrayList<Integer>());
		boolean result = stack.IsNull();
		assertEquals(false,result);
	}
	
	@After
	public void tearDown() throws Exception {
		stack = null;
	}


}
