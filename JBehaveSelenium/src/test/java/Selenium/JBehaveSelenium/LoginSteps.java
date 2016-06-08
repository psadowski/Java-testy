package Selenium.JBehaveSelenium;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.jbehave.core.annotations.*;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

import Selenium.JBehaveSelenium.Pages;


public class LoginSteps{
	
	private final Pages pages;
	private static WebDriver driver;
	WebElement element;
	private String baseUrl;
	public LoginSteps(Pages pages) {
		this.pages = pages;
	}
	
	@Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "https://photogramrails.herokuapp.com/users/sign_in";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	
	@Given("user is on Home page")
	public void givenUserIsOnHomePage(){
		pages.login().open();
	}
	
	@Then("succes flash is shown")
	public void thenSuccesFlashIsShown(){
		
		assertEquals("Signed in successfully.", driver.findElement(By.className("alert alert-info text-center")));
	}
	@When("user pass invalid login data")
	public void whenUserPassInvalidLoginData(){
		WebElement login_mail = driver.findElement(By.id("user_email"));
		WebElement login_pass = driver.findElement(By.id("user_password"));
		WebElement button = driver.findElement(By.name("commit"));
		login_mail.sendKeys("asdasda");
		login_pass.sendKeys("asdasd");
		button.click();
		//assertEquals("Invalid email or password.", driver.findElement(By.className("alert alert-warning text-center")));
	}
	@Then("error flash is shown")
	public void thenErrorFlashIsShown(){
		assertEquals("Invalid email or password.", driver.findElement(By.className("alert alert-warning text-center")));
	}
	@When("user pass correct login data")
	public void whenUserPassCorrectLoginData(){
		driver.get(baseUrl + "/users/sign_in");
	    driver.findElement(By.id("user_email")).sendKeys("test@test.pl");
	    driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password1234");
	    WebElement button = driver.findElement(By.name("commit"));
	    button.click();
	}
	
//	@AfterClass
//	public static void cleanp() {
//		driver.quit();
//	}
}
