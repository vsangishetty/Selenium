package Automation;

import java.time.Duration;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDom {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\JavaProjects\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();// maximize the browser
		driver.manage().deleteAllCookies(); //delete all cookies

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60)); //wait for page to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); //waits for all web elements to load

		driver.get("chrome://downloads/"); //launch site
		
		//driver.findElement(By.id("searchInput")).sendKeys("Automation");
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement shadowRoot = (WebElement)(js.executeScript("return document.querySelector('downloads-manager').shadowRoot.getElementById('toolbar').shadowRoot.getElementById('toolbar')"
				+ ".shadowRoot.getElementById('search').shadowRoot.getElementById('searchInput')"));
			
		((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('value','Automation')",shadowRoot);	

	}

}
