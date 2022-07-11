package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgProject {
	
	//Pre-condition annottion -- starting with @Before
	@BeforeSuite
	public void setUp(){
		System.out.println("setup system property for chrome");			
	}
	
	@BeforeTest
	public void launchBrowser(){
		System.out.println("Launch chrome browser");			
	}
	
	@BeforeClass
	public void login(){
		System.out.println("login to app");			
	}
	
	@BeforeMethod
	public void enterURL(){
		System.out.println("enter url");			
	}
	
	
	//test case ---starting with @Test
	@Test
	public void googletitletest() {
		System.out.println("Google Tile Test");
	}
	
	@Test
	public void searchtext() {
		System.out.println("search the text");
	}
	
	@Test
	public void googlelogotest() {
		System.out.println("Google Logo Test");
	}
	
	//Post conditions---starting with @After
	@AfterMethod
	public void logOut() {
		System.out.println("logout from app");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("Close Browser");
	}
	
	@AfterTest
	public void deleteAllCookies() {
		System.out.println("delete all cookies");
	}
	
	@AfterSuite
	public void generateTestReport() {
		System.out.println("generate Test Report");
	}

}
