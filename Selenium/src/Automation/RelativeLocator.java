package Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class RelativeLocator {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\JavaProjects\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();// maximize the browser
		driver.manage().deleteAllCookies(); //delete all cookies

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60)); //wait for page to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); //waits for all web elements to load

		driver.get("https://www.google.com/"); //launch site
		
		WebElement searchbtn = driver.findElement(By.xpath("//img[@class='lnXdpd']"));
		
		driver.findElement(org.openqa.selenium.support.locators.RelativeLocator.with(By.tagName("input")).below(searchbtn)).sendKeys("Automation");

	}

}
