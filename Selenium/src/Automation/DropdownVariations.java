package Automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownVariations {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\JavaProjects\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();// maximize the browser
		driver.manage().deleteAllCookies(); //delete all cookies

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60)); //wait for page to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); //waits for all web elements to load

		driver.get("https://www.jquery-az.com/jquery/demo.php?ex=152.0_1"); //launch site
		driver.findElement(By.xpath("//div[contains(@class, 'dropdownCheckboxes')]//button[@id='btndropdown']")).click();
		List<WebElement> list = driver.findElements(By.xpath("//div[contains(@class, 'dropdown cq-dropdown dropdownCheckboxes open')]//ul//li//label"));
		
		for(int i=0; i<list.size();i++) {
			if(list.get(i).getText().contains("HTML")) {
				list.get(i).click();
				break;
			}
			
		}


	}

}
