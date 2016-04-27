package Lab6.StockScenarios;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import Lab6.StockScenarios.MyStackImpl;

public class MySteps extends Steps {

	MyStackImpl impl;
	private ArrayList<Integer> stack;
	private Integer value;
	private Throwable throwable;

	@BeforeScenario
	public void start() {
		impl = new MyStackImpl();
		value = (Integer) null;
		throwable = null;
	}

	@Given("a null stack,")

	public void givenANullStack() {
		impl.setStack(null);
	}

	@Then("an exception is thrown.")

	public void thenAnExceptionIsThrown() {
		assertThat(throwable, is(not(equalTo(null))));
	}

	@When("user get top,")

	public int whenUserGetTop() {
		value = impl.MyTop();
		return value;
	}

	@When("pushed a value $value")

	public void pushStack(@Named("value") int value) {
		try {
			impl.MyPush(value);
		} catch (NullPointerException e) {
			throwable = e;
		}
	}

	@When("poped a value,")

	public void whenPopedAValue() {
		try {
			impl.MyPop();
		} catch (NullPointerException e) {
			throwable = e;
		}
	}

	@Then("a value should be returned.")

	public void thenAValueShouldBeReturned() {
		assertThat(value, is(not(equalTo(null))));
	}

	@Given("a not null stack,")

	public void givenANotNullStack() {
	  impl.setStack((new ArrayList<Integer>() {{ add(1); add(2); add(3); }}));
	}

	
}