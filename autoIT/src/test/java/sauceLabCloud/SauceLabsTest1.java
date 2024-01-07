package sauceLabCloud;

import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;

public class SauceLabsTest1 {
	RemoteWebDriver driver;
  @Test
  public void f() {
		driver.get("https://www.google.com/?gws_rd=ssl");
		WebElement searchBar = driver.findElement(By.name("q"));
		searchBar.sendKeys("Netflix");
		String title = driver.getTitle();
		System.out.println(title);
		searchBar.sendKeys(Keys.ENTER);
		
		

  }
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException {
	  //DesiredCapabilities cap = new DesiredCapabilities();
	  //cap.setCapability(null, cap);
	  //251f62f4-885f-4ecc-b09f-7de064f0c3a9
	  
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability("browserName", "chrome");
	  caps.setCapability("platform", "Windows 7");
	  caps.setCapability("version", "51");
	  caps.setCapability("build", "251f62f4-885f-4ecc-b09f-7de064f0c3a9");
	  caps.setCapability("name", "oauth-kamalnath121998-a4597");

	  URL url = new URL("https://oauth-kamalnath121998-a4597:251f62f4-885f-4ecc-b09f-7de064f0c3a9@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
	  driver = new RemoteWebDriver(url, caps);
  }

}
