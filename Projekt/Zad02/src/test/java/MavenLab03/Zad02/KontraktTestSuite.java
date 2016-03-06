package MavenLab03.Zad02;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CyfroKradNullTest.class, CyfroKradTest.class, HeheszkiExceptionTest.class, HeheszkiTest.class,
		HultajChochlaExceptionTest.class, HultajChochlaTest.class, NieksztaltekCorrectTest.class,
		NieksztaltekCustomValuesTest.class, NieksztaltekNoChangeTest.class, TititCorrectTest.class,
		TititExceptionTest.class })
public class KontraktTestSuite {

}
