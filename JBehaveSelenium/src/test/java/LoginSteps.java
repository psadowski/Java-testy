import org.jbehave.core.annotations.*;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;

import Selenium.JBehaveSelenium.Pages;


public class LoginSteps{
	
	private final Pages pages;

	public LoginSteps(Pages pages) {
		this.pages = pages;
	}
	
	@Given("user is on Home page")
	@Pending
	public void givenUserIsOnHomePage(){
		 //TODO 
	}
	@Then("succes flash is shown")
	@Pending
	public void thenSuccesFlashIsShown(){
		 //TODO 
	}
	@When("user pass invalid login data")
	@Pending
	public void whenUserPassInvalidLoginData(){
		 //TODO 
	}
	@Then("error flash is shown")
	@Pending
	public void thenErrorFlashIsShown(){
		 //TODO 
	}
	@When("user pass correct login data")
	@Pending
	public void whenUserPassCorrectLoginData(){
		 //TODO 
	}
}