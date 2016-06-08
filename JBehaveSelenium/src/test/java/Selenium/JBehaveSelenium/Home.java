package Selenium.JBehaveSelenium;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

public class Home extends WebDriverPage {

	public Home(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public void open() {
		get("https://photogramrails.herokuapp.com/");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
}