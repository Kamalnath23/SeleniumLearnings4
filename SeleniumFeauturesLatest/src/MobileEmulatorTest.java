import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v106.emulation.Emulation;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Optional;

import org.openqa.selenium.*;

public class MobileEmulatorTest {
	// STEP 1: Initiate chromedriver
	ChromeDriver driver;
	DevTools devTools;

	@BeforeTest
	public void f() {

		System.setProperty("webdriver.chrome.driver",
				"D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		devTools = driver.getDevTools();
		devTools.createSession();
		
		//send commands to CDP --> CDP methods will invoke and get access to chrome dev
		// https://chromedevtools.github.io/devtools-protocol/tot/Emulation/
		//devTools.send(Emulation.setDeviceMetricsOverride(820, 1180, 35, true, null, null, null, null, null, null, null, null, null));
		devTools.send(Emulation.setDeviceMetricsOverride(820, 1180, 35, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		
	}
	
	@Test
	public void testcase1() throws InterruptedException {
		driver.get("https://www.rahulshettyacademy.com/angularAppdemo/");
		
		WebElement togglerIcon= driver.findElement(By.cssSelector(".navbar-toggler-icon"));
		togglerIcon.click();
		
		Thread.sleep(2200);
		 WebElement lib= driver.findElement(By.linkText("Library"));
		 lib.click();
		 
	}

}
