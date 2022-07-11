package Automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SeleniumWithSikuliAutomateFlashObjects {

	public static void main(String[] args) throws FindFailed, InterruptedException {
		/*
		 * Automate using images 
		 * No API to lunch browser and URL - need to use selenium
		 * Can automate flash objects - YouTube videos 
		 * Desktop application automation
		 */
		
		System.setProperty("webdriver.chrome.driver", "D:\\JavaProjects\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();// maximize the browser
		driver.manage().deleteAllCookies(); //delete all cookies

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60)); //wait for page to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); //waits for all web elements to load

		driver.get("https://www.youtube.com");
		//driver.get("https://www.youtube.com/watch?v=BUjXzrgntcY");
		Thread.sleep(5000);
		
		WebElement search = driver.findElement(By.xpath("//div//input[@id='search']"));
		search.sendKeys("BRAHMASTRA");
		search.sendKeys(Keys.SPACE);
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='sbsb_a']//ul[@class='sbsb_b']//li")); //b[text()=' trailer hindi']"))
		System.out.println(list.size());
		
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains("trailer hindi")) 
			{
				
				list.get(i).click();
				break;
			}
			
		}
		
			
		
		//create the object of screen class
		Screen s = new Screen();
		
		Pattern scrtile = new Pattern("D:\\JavaProjects\\Selenium\\BrahmastraTeaser.PNG");
		s.wait(scrtile,5000);
		s.click();
		
				
		Pattern pauseTag = new Pattern("D:\\JavaProjects\\Selenium\\Chrm_Pause_btn.PNG");
		s.wait(pauseTag,5000);
		s.click();	
		
		Pattern playTag = new Pattern("D:\\JavaProjects\\Selenium\\Chrm_Play_btn.PNG");
		s.wait(playTag,5000);
		s.click();
		
		Pattern settingsTag = new Pattern("D:\\JavaProjects\\Selenium\\Chrm_Setting_btn.PNG");
		s.wait(settingsTag,5000);
		s.click();
		
		Pattern auto = new Pattern("D:\\JavaProjects\\Selenium\\Chrm_Auto_btn.PNG");
		s.wait(auto,5000);
		s.click();
		
		Pattern reso = new Pattern("D:\\JavaProjects\\Selenium\\Chrm_480p_btn.PNG");
		s.wait(reso,5000);
		s.click();
		
		Pattern pauseTag1 = new Pattern("D:\\JavaProjects\\Selenium\\Chrm_Pause_btn.PNG");
		s.wait(pauseTag1,5000);
		s.click();

	}

}
