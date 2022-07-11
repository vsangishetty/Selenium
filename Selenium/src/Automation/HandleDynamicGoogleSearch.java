package Automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleDynamicGoogleSearch {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\JavaProjects\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();// maximize the browser
		driver.manage().deleteAllCookies(); //delete all cookies

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60)); //wait for page to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); //waits for all web elements to load

		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Testing");
		List <WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='wM6W7d']"));
		System.out.println("Total number of suggestion:" + list.size());


		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getText().contains("testing techniques")) {
				list.get(i).click(); 
				break; 
			} 
		}

		System.out.println("End of Script");
		
		/*String elementColor = bgColor(driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/div[2]")),driver);
		String elementColor1 = bgColor(driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/div[3]")),driver);
		System.out.println(elementColor);
		System.out.println(elementColor1);*/

	}

}
