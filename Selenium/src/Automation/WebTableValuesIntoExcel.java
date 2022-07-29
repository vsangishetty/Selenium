package Automation;

import java.io.IOException;
import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import test.utility.Xls_Reader;

public class WebTableValuesIntoExcel {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\JavaProjects\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();// maximize the browser
		driver.manage().deleteAllCookies(); //delete all cookies

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60)); //wait for page to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); //waits for all web elements to load

		driver.get("https://www.w3schools.com/html/html_tables.asp"); //launch site
		String comp_b = "//*[@id=\"customers\"]/tbody/tr[";
		String comp_a = "]/td[1]";
		String cont_b = "//*[@id=\"customers\"]/tbody/tr[";
		String cont_a = "]/td[2]";
		
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr"));
		
		Xls_Reader reader = new Xls_Reader("D:\\JavaProjects\\git\\Selenium\\Selenium\\WebTableData.xlsx");
		
		if(!reader.isSheetExist("Table")) {
			reader.addSheet("Table");
			reader.addColumn("Table", "Company");
			reader.addColumn("Table", "Contact");
		}
		
		
		for(int i=2; i<=rows.size(); i++) {
			String tabledata = driver.findElement(By.xpath(comp_b+i+comp_a)).getText();
			 
			reader.setCellData("Table", "Company", i, tabledata);
			
			String tabledata2 = driver.findElement(By.xpath(cont_b+i+cont_a)).getText();
			
			reader.setCellData("Table", "Contact", i, tabledata2);
		}
		driver.quit();
	}

}
