import java.util.List;

import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;

import Lab6.Zad2.App;


public class MySteps extends Steps{
	
	private List<Integer> a;
	App impl = new App();
	
	@Then("min should $value")
	public void thenGcdabShouldBeEqual2(@Named("value") int value){
		if(impl.Min(a) != value){
			 throw new RuntimeException("Error in test!");
			
		 }
	}
	@Given("a variable x by $value")
	public void givenAVariableXByValue21(@Named("value") List<Integer> value){
		a = value;
	}
	
	@Then("max should $value")
	public void thenGcdabShouldBeEqual32(@Named("value") int value){
		if(impl.Max(a) != value){
			 throw new RuntimeException("Error in test!");
			
		 }
	}
	@Given("a variable y by $value")
	public void givenAVariableXByValue2(@Named("value") List<Integer> value){
		a = value;
	}
	
	
	
}