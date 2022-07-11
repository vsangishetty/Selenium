package com.test;

import org.testng.annotations.Test;


public class ExceptionTimeOutTest {
	
	@Test(invocationTimeOut=2)
	public void infinitloopTest() {
		
		int i=1;
		while(i==1) {
		System.out.println(i);
		
				
		}
	}
	
	//This pass the test case by writing expectedExceptions key
	@Test(expectedExceptions=NumberFormatException.class)
	public void Test1() {
		
		String x = "100A";
		Integer.parseInt(x);
	}

}
