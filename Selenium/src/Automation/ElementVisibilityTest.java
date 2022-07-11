package Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.Select;

public class ElementVisibilityTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\JavaProjects\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();// maximize the browser
		driver.manage().deleteAllCookies(); //delete all cookies
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60)); //wait for page to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); //waits for all web elements to load
		
		driver.get("https://www.freecrm.com/"); //launch site
		
		explyWait(driver, driver.findElement(By.linkText("Sign Up")),Duration.ofSeconds(10));
		
		
		// Is displayed metthod: applicable for all element
		boolean b1 = driver.findElement(By.name("action")).isDisplayed();
		System.out.println(b1);
		
		//is Enable method
		boolean b2 = driver.findElement(By.name("action")).isEnabled();
		System.out.println(b2);
		
		Thread.sleep(3000);
		driver.findElement(By.id("country")).click();
		driver.findElement(By.xpath("//input[contains(@class, 'search')]")).sendKeys("India");
		driver.findElement(By.xpath("//div[contains(@data-value, 'in')]")).click();
		
		/*
		 * Select val = new
		 * Select(driver.findElement(By.xpath("//i[@class='dropdown icon']")));
		 * val.selectByVisibleText("India (+91)");
		 */
		
		//isSelected method only applicable for checkbox, dropdown, radiobutton
		boolean b3 = driver.findElement(By.xpath("//div[contains(text(), 'India (+91)')]")).isSelected();
		System.out.println(b3);
		//*[@id="country"]/input[2]
	}
	
	public static void explyWait(WebDriver driver, WebElement locator, Duration i) {
		new WebDriverWait(driver, i).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}

}
