package cdp;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterMethod;


import org.openqa.selenium.logging.LogEntry;

public class ConsoleLogCapture {
	ChromeDriver driver;

	@Test
	public void f() {
		driver.get("https://www.rahulshettyacademy.com/angularAppdemo/");
		driver.manage().window().maximize();

		WebElement Browser_Product = driver.findElement(By.xpath("//a[@class=\"btn btn-lg btn-success\"]"));
		Browser_Product.click();

		WebElement Selenium = driver.findElement(By.linkText("Selenium"));
		Selenium.click();
		
		  WebElement addToCart= driver.findElement(By.cssSelector("button.add-to-cart"));
		  addToCart.click();
		  
		  WebElement cart= driver.findElement(By.xpath("//a[@routerlink=\"/cart\"]"));
		  cart.click();
		  
		  WebElement RenameQuantityTextBox= driver.findElement(By.cssSelector("input#exampleInputEmail1"));
		  RenameQuantityTextBox.clear();
		  RenameQuantityTextBox.sendKeys("2");
		  
		  LogEntries entry= driver.manage().logs().get(LogType.BROWSER); // get log entries object
		  List<LogEntry>logs = entry.getAll(); // log entry object -get all method on list
		  
		  //Iterating through the list and printing each log msg
		  for(LogEntry e: logs) {
			  String msg= e.getMessage();
			  System.out.println(msg);
		  }
		  

	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\Chrome\\chromedriver.exe");

		driver = new ChromeDriver();

		// listeners - onTestFailure

	}

	@AfterMethod
	public void afterMethod() {
	}

}
