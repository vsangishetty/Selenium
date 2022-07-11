package Automation;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;




public class BrokenLinks {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\JavaProjects\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();// maximize the browser
		driver.manage().deleteAllCookies(); //delete all cookies

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60)); //wait for page to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); //waits for all web elements to load

		driver.get("https://www.saucedemo.com/inventory.html"); //launch site
		
		
		List<WebElement> list = driver.findElements(By.tagName("a"));
		//list.addAll(driver.findElements(By.tagName("img")));
		System.out.println("Total links--> "+ list.size());
		
		
		List<WebElement> activelinks = new ArrayList<WebElement>();
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getAttribute("href"));
			if(list.get(i).getAttribute("href") != null) {
				activelinks.add(list.get(i));
				
			}
		}	
		
		System.out.println("Actual links without null--> "+activelinks.size());
		
		for(int j=0; j<activelinks.size(); j++) {
			
			HttpURLConnection connection = (HttpURLConnection)new URL(activelinks.get(j).getAttribute("href")).openConnection();
			
			connection.connect();
			connection.getResponseMessage();
			connection.getResponseCode();
			connection.disconnect();
			System.out.println(activelinks.get(j).getAttribute("href")+"-->"+connection.getResponseMessage()+" "+connection.getResponseCode());
			
			
			
		}
		

	}
	


}
