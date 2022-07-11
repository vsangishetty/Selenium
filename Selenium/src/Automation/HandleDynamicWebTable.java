package Automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleDynamicWebTable {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\JavaProjects\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();// maximize the browser
		driver.manage().deleteAllCookies(); //delete all cookies
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60)); //wait for page to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); //waits for all web elements to load
		
		driver.get("https://www.freecrm.com/"); //launch site
		explyWait(driver, driver.findElement(By.linkText("Login")),Duration.ofSeconds(20));			
		
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
		driver.findElement(By.xpath("//span[contains(text(), 'Contacts')]")).click();
		mhover.moveToElement(driver.findElement(By.id("dashboard-toolbar"))).build().perform();
		Thread.sleep(2000);
		
		
		//Method 1 for handling web table 
		//driver.findElement(By.xpath("//a[contains(text(), 'Sham D Singh')]/parent::td//preceding-sibling::td//div")).click();
		//Vikas  T Patil, vikas N patil
		//Method 2
		String before_xpath = "//*[@id='main-content']/div/div[2]/div/table/tbody/tr[";
		String after_xpath = "]/td[2]/a";
		
		
		
		List<WebElement> pagecnt = driver.findElements(By.xpath("//tfoot/descendant::div[contains(@class, 'custom-pagination')]//a"));
		System.out.println(pagecnt.size());
		
		boolean flag = false;
		for(int j=1; j<pagecnt.size()-1;j++) {
			List<WebElement> rowcnt = driver.findElements(By.cssSelector("div.table-wrapper>table>tbody>tr>td:nth-child(2)>a"));
			System.out.println(rowcnt.size());
			for(int i=1; i<=rowcnt.size(); i++) {
				String name = driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
				if(name.contains("Akash Mui")) {
				driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/table/tbody/tr["+i+"]/td[1]/div")).click();
				flag = true;
				//break;
				}
			
			}
			if(flag) {
				break;
			}
			String nextpg = driver.findElement(By.xpath("//tfoot/descendant::div[contains(@class, 'custom-pagination')]//a[@class='item active']//following::a[1]")).getAttribute("class");
			
			if(nextpg.equals("item")) {
				driver.findElement(By.xpath("//tfoot/descendant::div[contains(@class, 'custom-pagination')]//a[@class='item active']//following::a[1]")).click();
			}
			
			
		}
		
		System.out.println("End of Script");

	}
	public static void explyWait(WebDriver driver, WebElement locator, Duration i) {
		new WebDriverWait(driver, i).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}
	

}
