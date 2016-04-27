package com.example.seleniumdemo;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {

	private static WebDriver driver;
	WebElement element;

	@BeforeClass
	public static void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testWithProperData()
	{
		driver.get("http://demo.hongkiat.com/html5-loginpage/index.html");
		Login login = new Login(driver);
		login.login("eldo@uszatek.pl", "1234");
		assertEquals("404 Not Found", driver.getTitle());
	}
	
	@Test
	public void testWithInvalidData()
	{
		driver.get("http://demo.hongkiat.com/html5-loginpage/index.html");
		Login login = new Login(driver);
		login.login("eldo", "1234");
		assertEquals("HTML5 Login Page - Hongkiat.com", driver.getTitle());
	}
	
	@Test
	public void testWithNoData()
	{
		driver.get("http://demo.hongkiat.com/html5-loginpage/index.html");
		Login login = new Login(driver);
		login.login("", "");
		assertEquals("HTML5 Login Page - Hongkiat.com", driver.getTitle());
	}
	
	@AfterClass
	public static void cleanp() {
		driver.quit();
	}

}
