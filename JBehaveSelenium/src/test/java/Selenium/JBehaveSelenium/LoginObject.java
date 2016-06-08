package Selenium.JBehaveSelenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginObject {

		@FindBy(id="user_email")
		private WebElement emailField;
		
		@FindBy(xpath="//input[@id='user_password']")
		private WebElement passwordField;
		
		@FindBy(name="commit")
		private WebElement loginButton;
		
		public LoginObject(WebDriver driver) {
		  PageFactory.initElements(driver, this);
		}

		public void login(String email, String password) {
		  emailField.sendKeys(email);
		  passwordField.sendKeys(password);
		  loginButton.click();
		}
		
}
