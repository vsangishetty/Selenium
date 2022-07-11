package com.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\JavaProjects\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();// maximize the browser
		driver.manage().deleteAllCookies(); //delete all cookies
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60)); //wait for page to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); //waits for all web elements to load
		driver.get("https://www.google.com");
	}
	
	@Test(priority=1,groups="Test1")         // Test priority and grouping
	public void googletitletest() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Google");           //Assertion
	}
	
	@Test(priority=4,groups="Test3")
	public void googlelogotest() {
		boolean b = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/img")).isDisplayed();
		System.out.println("googlelogotest");
		Assert.assertTrue(b);                //Assertion
	}
	
	@Test(priority=3,groups="Test3")
	public void maillinktest() {
		driver.findElement(By.linkText("Gmail")).isDisplayed();
		System.out.println("maillinktest");
	}
	
	@Test(priority=2,groups="Test3")
	public void mno() {
		
		System.out.println("mno");
	}
	
	@Test(priority=6,groups="Test2")
	public void abc() {
		
		System.out.println("abc");
	}
	@Test(priority=5,groups="Test2")
	public void def() {
		
		System.out.println("def");
	}
	@Test(priority=8,groups="Test1")
	public void ghi() {
		
		System.out.println("ghi");
	}
	@Test(priority=7,groups="Test1")
	public void jkl() {
		
		System.out.println("jkl");
	}
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	

}
