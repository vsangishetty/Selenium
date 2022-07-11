package Automation;

//import java.io.File;
import java.io.IOException;
import java.time.Duration;
//import java.util.Date;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotUsingJavaScriptExecutor {

	
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\JavaProjects\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();// maximize the browser
		driver.manage().deleteAllCookies(); //delete all cookies
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60)); //wait for page to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); //waits for all web elements to load
		
		driver.get("https://www.freecrm.com/"); //launch site
		Thread.sleep(2000);
		
		//scrollPageDown(driver);
		
		WebElement importExport = driver.findElement(By.xpath("//h3[contains(text(),'Marketing Campaigns')]"));
		ScrollIntoView(importExport, driver);
				
		/*
		 * driver.findElement(By.linkText("Login")).click(); Thread.sleep(5000);
		 * driver.findElement(By.name("email")).sendKeys("vinod.sangishetty@gmail.com");
		 * driver.findElement(By.name("password")).sendKeys("Rom@in8112");
		 * Thread.sleep(2000);
		 * //driver.findElement(By.cssSelector(".ui.fluid.large.blue.submit.button")).
		 * click();
		 * 
		 * 
		 * WebElement loginbtn =
		 * driver.findElement(By.cssSelector(".ui.fluid.large.blue.submit.button"));
		 * 
		 * //flash(loginbtn, driver);//Highligt the element
		 * 
		 * borderColour(loginbtn, driver);
		 * 
		 *  //For Uploading file
		 * String Filename = new Date().getTime() + ".png"; 
		 * File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 * FileUtils.copyFile(src, new File("D:\\JavaProjects\\ScreenShot\\"+ Filename));
		 * 
		 * //generateAlert("There is an issue in login btn", driver);//generate alert
		 * using JScript //driver.switchTo().alert();
		 * //driver.switchTo().alert().accept();
		 * 
		 * clickElementByJS(loginbtn, driver); //click on any element using jscript
		 * 
		 * System.out.println(getTitleByJS(driver));
		 * 
		 * System.out.println(getPageInnerText(driver));
		 */
		
		System.out.println("End of Script");

	}
	
	public static void flash(WebElement element,WebDriver driver)
	{
		//JavascriptExecutor js=(JavascriptExecutor)driver; 
		String bgcolor = element.getCssValue("backgroundcolor");
		for(int i=0; i<10; i++) {   
			changeColor("rgb(300,0,0)", element, driver); // change the colour to red
			changeColor(bgcolor, element, driver);	//it will make the colour back to its original
		}
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
	public static void borderColour(WebElement element, WebDriver driver)
	{
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].style.border = '4px solid red'", element);
		
	}
	public static void generateAlert(String message, WebDriver driver)
	{
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("alert('"+message+"')");
		
	}
	public static void clickElementByJS(WebElement element, WebDriver driver)
	{
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].click();", element);
		
	}
	public static String getTitleByJS(WebDriver driver)
	{
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		String title = jse.executeScript("return document.title;").toString();
		return title;
	}
	public static String getPageInnerText(WebDriver driver)
	{
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		String pageText = jse.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}
	public static void scrollPageDown(WebDriver driver)
	{
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
	}
	public static void ScrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
