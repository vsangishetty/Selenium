package Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\JavaProjects\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();// maximize the browser
		driver.manage().deleteAllCookies(); //delete all cookies

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60)); //wait for page to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); //waits for all web elements to load

		driver.get("https://www.saucedemo.com/inventory.html"); //launch site
		String abc = driver.findElement(By.id("root")).getText();
		System.out.println(abc);
	}

}
