package com.example.seleniumdemo;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NewWindowTest {

	private static WebDriver driver;
	WebElement element;

	@BeforeClass
	public static void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void newPageTileTest() throws InterruptedException
	{
		driver.get("http://stackoverflow.com/");
		WebElement link = driver.findElement(By.name("q"));
		link.sendKeys("nie znajdziesz nic");
		Actions newwin = new Actions(driver);
		link.sendKeys(Keys.SHIFT, Keys.ENTER);
		Set <String> set = driver.getWindowHandles();
	    Iterator<String> it = set.iterator();
	    String parentWindowId = it.next();
	    String childWindowId = it.next();
		driver.switchTo().window(parentWindowId);
		driver.close();
	    driver.switchTo().window(childWindowId);
	    String actualTitle = driver.getTitle();
	    String expectedTitle = "Posts containing 'nie znajdziesz nic' - Stack Overflow";
	    assertEquals(actualTitle, expectedTitle);

	}
	
	@Test
	public void newPageJavaFindTest() throws InterruptedException
	{
		driver.get("http://stackoverflow.com/");
		WebElement link = driver.findElement(By.name("q"));
		link.sendKeys("java");
		Actions newwin = new Actions(driver);
		link.sendKeys(Keys.SHIFT, Keys.ENTER);
		Set <String> set = driver.getWindowHandles();
	    Iterator<String> it = set.iterator();
	    String parentWindowId = it.next();
	    String childWindowId = it.next();
		driver.switchTo().window(parentWindowId);
		driver.close();
	    driver.switchTo().window(childWindowId);
	    WebElement tags = driver.findElement(By.id("nav-tags"));
	    tags.click();
	    WebElement java = driver.findElement(By.cssSelector("a[href*='/questions/tagged/java']"));
	    java.click();
	    String actualTitle = driver.getTitle();
	    String expectedTitle = "Newest 'javascript' Questions - Stack Overflow";
	    assertEquals(actualTitle, expectedTitle);

	}
	
	@Test
	public void newPageTourFindTest() throws InterruptedException
	{
		driver.get("http://stackoverflow.com/");
		WebElement link = driver.findElement(By.name("q"));
		link.sendKeys("java");
		Actions newwin = new Actions(driver);
		link.sendKeys(Keys.SHIFT, Keys.ENTER);
		Set <String> set = driver.getWindowHandles();
	    Iterator<String> it = set.iterator();
	    String parentWindowId = it.next();
	    String childWindowId = it.next();
		driver.switchTo().window(parentWindowId);
		driver.close();
	    driver.switchTo().window(childWindowId);
	    WebElement tour = driver.findElement(By.cssSelector("a[href*='/tour']"));
	    tour.click();
	    WebElement java = driver.findElement(By.className("about-title"));
	    String actualValue = java.getText();
	    String expectedValue = "Welcome to Stack Overflow";
	    assertEquals(actualValue, expectedValue);

	}
	
	@AfterClass
	public static void cleanp() {
		driver.quit();
	}
}
