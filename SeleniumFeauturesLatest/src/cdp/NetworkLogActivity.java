package cdp;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v106.network.Network;
import org.openqa.selenium.devtools.v106.network.model.Request;
import org.openqa.selenium.devtools.v106.network.model.Response;
import org.testng.annotations.AfterMethod;

public class NetworkLogActivity {
	ChromeDriver driver;
	DevTools devtools;
  @Test
  public void f() {
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
		
		devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		//second coded event
		devtools.addListener(Network.requestWillBeSent(), request ->{
			Request req= request.getRequest();
			String url= req.getUrl();
			//System.out.println("REQUEST GET URL: "+url);
			
		});
		
		//event will get fired when we get response back. (1st coded)
		devtools.addListener(Network.responseReceived(), response ->{
			//response.getResponse().getStatus();
			Response res= response.getResponse();
			//System.out.println("RESPONSE GET URL "+res.getUrl());
			//System.out.println("RESPONSE GET STATUS: "+res.getStatusText());
			
			if(res.getStatusText().toString().startsWith("4")) {
				System.out.println(res.getUrl()+" is failed with status code."+res.getStatusText());
			}
		});
		
		
		
  }
 
  @AfterMethod
  public void afterMethod() {
  }

}
