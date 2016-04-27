package com.example.seleniumdemo;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestExp {
	private static WebDriver driver;
	WebElement element;

	@BeforeClass
	public static void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@Test
	public void testWithExplicitWait()
	{
		String parentWindow;

		
		driver.get("https://inf.ug.edu.pl/~mmiotk/TAJAVA/child.html");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("helpButton")));
		parentWindow = driver.getWindowHandle();
		driver.findElement(By.id("helpButton")).click();
	
			driver.switchTo().window(parentWindow);
			driver.close();
    		driver.switchTo().window("mywindow");
    		assertEquals("Help window", driver.getTitle());
    		driver.close();
	
	}
	

	@AfterClass
	public static void cleanp() {
		driver.quit();
	}
}
