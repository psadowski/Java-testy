package MavenLab03.Zad01;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ StackNullTest.class, StackPopExceptionTest.class, StackPopTest.class, StackPushExceptionTest.class,
		StackPushTest.class, StackTopExceptionTest.class, StackTopTest.class })
public class StackTestSuite {

}
