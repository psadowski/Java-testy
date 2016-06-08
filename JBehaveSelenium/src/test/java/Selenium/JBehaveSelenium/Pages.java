package Selenium.JBehaveSelenium;

import org.jbehave.web.selenium.WebDriverProvider;


public class Pages {

	private WebDriverProvider driverProvider;
	
	//Pages
	private Home home;
	private Login login;
	// ...

	public Pages(WebDriverProvider driverProvider) {
		super();
		this.driverProvider = driverProvider;
	}

	public Home home() {
		if (home == null) {
			home = new Home(driverProvider);
		}
		return home;
	}
	
	public Login login(){
		if (login == null) {
			login = new Login(driverProvider);
		}
		return login;
	}
}
