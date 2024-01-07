import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v106.emulation.Emulation;
import org.testng.annotations.AfterMethod;

public class cdpCommandsTest {
	ChromeDriver driver;
	DevTools devtools;
  @Test
  public void f() throws InterruptedException {
		driver.get("https://www.rahulshettyacademy.com/angularAppdemo/");
		
		WebElement togglerIcon= driver.findElement(By.cssSelector(".navbar-toggler-icon"));
		togglerIcon.click();
		
		Thread.sleep(2200);
		 WebElement lib= driver.findElement(By.linkText("Library"));
		 lib.click();
  }
  @BeforeMethod
  public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		devtools = driver.getDevTools();
		devtools.createSession();
		
		Map deviceMetrics= new HashMap();
		deviceMetrics.put("width", 600);
		deviceMetrics.put("height", 1000);
		deviceMetrics.put("deviceScaleFactor", 50);
		deviceMetrics.put("mobile", true);
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
		
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
