package MavenLab03.Zad01;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StackNullException {
	private MyStackImpl stack ;
	
	@Before
	public void setUp() throws Exception {
		stack = new MyStackImpl();
	}

	@Test
	public void NullStackException() {
		stack.setStack(null);
		try {
			stack.MyTop();
			} catch (NullPointerException e) {
				assertTrue(true);
		}
	}
	
	@After
	public void tearDown() throws Exception {
		stack = null;
	}



}
