package MavenLab03.Zad01;

import static org.junit.Assert.*;

import java.util.ArrayList;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StackPopExceptionTest {
	private MyStackImpl stack;
	@Before
	public void setUp() throws Exception {
		stack = new MyStackImpl();
	}
	
	@Test
	public void NullStackException() {
		stack.setStack(null);
		try {
				stack.MyPush(13);
			} catch (NullPointerException e) {
				assertTrue(true);
		}
	}
	
	@Test
	public void EmptyStackException(){
		stack.setStack(new ArrayList<Integer>());
		try {
			stack.MyPop();
		} catch (ArrayIndexOutOfBoundsException e) {
			assertTrue(true);
	}
			
	}

	@After
	public void tearDown() throws Exception {
		stack = null;
	}


}
