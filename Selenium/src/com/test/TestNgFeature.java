package com.test;

import org.testng.annotations.Test;

public class TestNgFeature {
	
	@Test
	public void logintest() {
		
		int i=9/0;
		System.out.println(i);
	}
	
	@Test(dependsOnMethods="logintest")
	public void Homepagetest() {
		System.out.println("Home page Test");
	}
	
	@Test(dependsOnMethods="logintest")
	public void SearchPg() {
		System.out.println("SearchPg Test");
	}
	
	@Test(dependsOnMethods="logintest")
	public void RegPage() {
		System.out.println("RegPage Test");
	}
	

}
