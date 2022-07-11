package Automation;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
//import org.openqa.selenium.interactions.Actions;

public class SeleniumPractice {

	
	//@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\JavaProjects\\chromedriver_win32\\chromedriver.exe");
		
		
		ChromeOptions option = new ChromeOptions();
		//option.addArguments("--disable-notifications"); //to disable notification
		option.addArguments("window-size=1400,800");
		option.addArguments("headless");  //-- browser doesn't lauch
		WebDriver driver = new ChromeDriver(option);
		
		/*1. testing is happen behind the scene -- browser doesn't lauch
		 * 2. Very fast execution of test cases and performance of the script.
		 * 3. It is not suitable for Action class, user actions ,mousemovement, doubleclick, drag and drop
		 * 4. It is also called Gosht driver.
		 * 5. It is a headless browser
		 * 6. There are headless broser like -- HtmlUnit driver with Java and PhantomJS for Javascript
		 */
		//WebDriver driver = new HtmlUnitDriver();   //-- browser doesn't lauch
		
		driver.manage().window().maximize();// maximize the browser
		driver.manage().deleteAllCookies(); //delete all cookies
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60)); //wait for page to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); //waits for all web elements to load
		
		driver.get("https://www.freecrm.com/"); //launch site
				
		//List <WebElement> Linklist = driver.findElements(By.tagName("div")); //captures all web elements in list
		//System.out.println(Linklist.size()); // count of web elements in page.
		
		/*Move the mouse to particular element 
		 */
		//Actions act = new Actions(driver);
		//act.moveToElement(driver.findElement(By.xpath("//*[contains(@class,'css-76zvg2 r-jwli3a r-ubezar r-16dba41 r-1pzd9i8')]"))).build().perform();
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.linkText("Login")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("email")).sendKeys("vinod.sangishetty@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Rom@in811");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".ui.fluid.large.blue.submit.button")).click();
		
		System.out.println(driver.getTitle());

		//driver.quit();
	}

}
