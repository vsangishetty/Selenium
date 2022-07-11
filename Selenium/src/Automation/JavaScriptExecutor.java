package Automation;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\JavaProjects\\chromedriver_win32\\chromedriver.exe");
		
		//to disable notification
		//ChromeOptions option = new ChromeOptions();
		//option.addArguments("--disable-notifications"); 
		//WebDriver driver = new ChromeDriver(option);

		WebDriver driver = new ChromeDriver();
		
		/*1. testing is happen behind the scene -- browser doesn't lauch
		 * 2. Very fast execution of test cases and performance of the script.
		 * 3. It is not suitable for Action class, user actions ,mousemovement, doubleclick, drag and drop
		 * 4. It is also called Gosht driver.
		 * 5. It is a headless browser
		 * 6. There are headless broser like -- HtmlUnit driver with Java and PhantomJS for Javascript
		 */
		//WebDriver driver = new HtmlUnitDriver();
		
		driver.manage().window().maximize();// maximize the browser
		driver.manage().deleteAllCookies(); //delete all cookies
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60)); //wait for page to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); //waits for all web elements to load
		
		driver.get("https://www.freecrm.com/"); //launch site
		
		driver.findElement(By.linkText("Login")).click();
		Thread.sleep(5000);
		WebElement email = driver.findElement(By.name("email"));//.sendKeys("vinod.sangishetty@gmail.com");
		WebElement pass = driver.findElement(By.name("password"));//.sendKeys("Rom@in811");
		Thread.sleep(2000);
		//driver.findElement(By.cssSelector(".ui.fluid.large.blue.submit.button")).click();
		
		//Highligt the element
		WebElement loginbtn = driver.findElement(By.cssSelector(".ui.fluid.large.blue.submit.button"));
		flash(email, driver);
		flash(pass, driver);
		flash(loginbtn, driver);
		
		//Take screenshot
		//File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//Save the screenshot to folder with image format
		//FileUtils.copyFile(src, new File("D:\\JavaProjects\\ScreenShot\\Highlightimage.png"));
		
		System.out.println("End of Script");
		
	}
	
	public static void flash(WebElement element,WebDriver driver)
	{
		//JavascriptExecutor js=(JavascriptExecutor)driver; 
		String bgcolor = element.getCssValue("backgroundcolor");
		//for(int i=0; i<10; i++) {   ///this for loop will loop the changing color at line 75 and 86 to feel like flashing
			changeColor("rgb(300,0,0)", element, driver); // change the colour to red
			
			//it will take screenshot of that particular element which is highlighted
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				String fileName = new Date().getTime() + ".png";
				FileUtils.copyFile(src, new File("D:\\JavaProjects\\ScreenShot\\" + fileName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			changeColor(bgcolor, element, driver);	//it will make the colour back to its original
		//}
	}
	public static void changeColor(String color,WebElement element,WebDriver driver )	{
		JavascriptExecutor js=(JavascriptExecutor)driver; 
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", element);
		
		try {
			Thread.sleep(300);
			}
		catch (InterruptedException e) {
		}
	}

}
