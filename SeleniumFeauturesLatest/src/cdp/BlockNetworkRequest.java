package cdp;

import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;

import org.testng.annotations.BeforeMethod;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v106.network.Network;
import org.testng.annotations.AfterMethod;

public class BlockNetworkRequest {
	ChromeDriver driver;
	DevTools devtools;
  @Test
  public void blockNetworkTest() throws InterruptedException {
	  driver.get("https://www.rahulshettyacademy.com/angularAppdemo/");
	  driver.manage().window().maximize();
	  
	  WebElement Browser_Product= driver.findElement(By.xpath("//a[@class=\"btn btn-lg btn-success\"]"));
	  Browser_Product.click();
	  
	  WebElement Selenium= driver.findElement(By.linkText("Selenium"));
	  Selenium.click();
	  
	  WebElement addToCart= driver.findElement(By.cssSelector("button.add-to-cart"));
	  addToCart.click();
	  
	  Thread.sleep(1111);
	  WebElement para= driver.findElement(By.cssSelector("p.sp"));
	  String verifivation= para.getText();
	  System.out.println(verifivation);
  }
  @BeforeMethod
  public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		devtools = driver.getDevTools();
		devtools.createSession();
		
		//CSS, Images
		devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devtools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg","*.css"))); //it may improve the time
  }

  @AfterMethod
  public void afterMethod() {
  }

}
