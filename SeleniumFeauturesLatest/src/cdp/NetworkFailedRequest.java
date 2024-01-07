package cdp;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v106.fetch.Fetch;
import org.openqa.selenium.devtools.v106.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v106.network.model.ErrorReason;
import org.testng.annotations.AfterMethod;

public class NetworkFailedRequest {
	ChromeDriver driver;
	DevTools devtools;
  @Test
  public void failedRequest() {
	  driver.get("https://www.rahulshettyacademy.com/angularAppdemo/");
		driver.manage().window().maximize();

		WebElement lib_button = driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]"));
		lib_button.click();
  }
  @BeforeMethod
  public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		devtools = driver.getDevTools();
		devtools.createSession();
		
		//new RequestPattern(Optional.of("*GetBook"), Optional.empty(), Optional.empty());
		// Arrays.asList(new RequestPattern(Optional.of("*GetBook"), Optional.empty(), Optional.empty())); 
		Optional<List<RequestPattern>> patterns = Optional.of(Arrays.asList(new RequestPattern(Optional.of("*GetBook*"), Optional.empty(), Optional.empty())));
		
		devtools.send(Fetch.enable(patterns, Optional.empty()));
		
		devtools.addListener(Fetch.requestPaused(), request->{
			devtools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
		});
  }

  @AfterMethod
  public void afterMethod() {
  }

}
