package com.test;

import org.testng.annotations.Test;

public class InvocationCountTest {
	
	@Test(invocationCount=10)
	public void sum() {
		
		int a=9;
		int b=2;
		int c=a+b;
		System.out.println("Sum is === "+c);
	}

}
