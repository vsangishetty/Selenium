package Automation;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleCalendar {

	public static void main(String[] args)throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\JavaProjects\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();// maximize the browser
		driver.manage().deleteAllCookies(); //delete all cookies

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60)); //wait for page to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); //waits for all web elements to load

		driver.get("https://ui.freecrm.com/"); //launch site
		//explyWait(driver, driver.findElement(By.linkText("Login")),Duration.ofSeconds(20));			

		//driver.findElement(By.linkText("Login")).click(); 
		Thread.sleep(5000);
		//driver.findElement(By.name("email")).sendKeys("neelima077@gmail.com");
		driver.findElement(By.name("email")).sendKeys("vinod.sangishetty@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Rom@in811");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".ui.fluid.large.blue.submit.button")).click();


		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60)); 
		Actions mhover = new Actions(driver);
		mhover.moveToElement(driver.findElement(By.id("main-nav"))).build().perform();
		driver.findElement(By.xpath("//span[contains(text(), 'Calendar')]")).click();
		mhover.moveToElement(driver.findElement(By.id("dashboard-toolbar"))).build().perform(); 
		Thread.sleep(2000);
		//*[@id="main-content"]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/div/div[4]/a
		//*[@id="main-content"]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/div/div[5]
		//*[@id="main-content"]/div/div[2]/div/div[2]/div/div[2]/div[3]/div[2]/div/div[3]/a
		//*[@id="main-content"]/div/div[2]/div/div[2]/div/div[1]/span[1]/button[2]/i
		//driver.findElement(By.xpath("//div[@class='rbc-toolbar']//span/descendant::button[@type='button']/i[@class='chevron left icon']")).click();
		//String datelbl = driver.findElement(By.xpath("//div[@class='rbc-toolbar']//descendant::span[@class='rbc-toolbar-label']")).getText();
		//System.out.println(datelbl);
		
		
		String date = "31-May-2022";
		String dateArr[] = date.split("-");
		String day = dateArr[0];
		String month = dateArr[1];
		String year = dateArr[2];
		//*[@id="main-content"]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/div[2]
		//*[@id="main-content"]/div/div[2]/div/div[2]/div/div[2]/div[3]/div[1]/div[2]
		String beforeXpath = "//*[@id=\"main-content\"]/div/div[2]/div/div[2]/div/div[2]/div[";
		String afterXpath = "]/div[2]/div/div[";
		
		final int totalWeekDays = 7;

		
		for(int i=0; i<20; i++) { 
			
			String datelbl = driver.findElement(By.xpath("//div[@class='rbc-toolbar']//descendant::span[@class='rbc-toolbar-label']")).getText();
			
			if(datelbl.contains(month+" "+year)) 
			{ 
				boolean flag = false;
				String dayVal = null;
				for(int rownum=2; rownum<=7; rownum++) 
				{ 
					for(int col=1; col<=totalWeekDays; col++) 
					{
						
						try {
							dayVal = driver.findElement(By.xpath(beforeXpath+rownum+afterXpath+col+"]")).getText();
						} catch (NoSuchElementException e) {
							System.out.println("Please enter correct data value");
							//e.printStackTrace();
							flag=false;
							break;
						}

						String elementColor = bgColor(driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/div[2]/div/div[2]/div["+rownum+"]/div[1]/div["+col+"]")));
						//System.out.println(elementColor+" "+dayVal);
						if(dayVal.equals(day) && elementColor.startsWith("rgba")) { //
							driver.findElement(By.xpath(beforeXpath+rownum+afterXpath+col+"]")).click();
							flag = true;
							break;
						}
					}
					
				}
				if(flag) {
					break;
				}

				break; 
			} 
			driver.findElement(By.xpath("//div[@class='rbc-toolbar']//span/descendant::button[@type='button']/i[@class='chevron left icon']")).click();
		}

		driver.findElement(By.xpath("//div[contains(@class, 'ui buttons')]//div/i[@class='settings icon']")).click();
		driver.findElement(By.xpath("//div[contains(@class, 'ui buttons')]//div/div/a/span[text()='Log Out']")).click();
		
		System.out.println("End of Script");

	}
	
	  public static void explyWait(WebDriver driver, WebElement locator, Duration i) 
	  { 
		  new WebDriverWait(driver, i).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator)); 
		  locator.click(); 
	  }
	 
	
	
	public static String bgColor(WebElement element)
	{
	//JavascriptExecutor js=(JavascriptExecutor)driver; 
	String bgcolor = element.getCssValue("background");
	return bgcolor;
	}

}
