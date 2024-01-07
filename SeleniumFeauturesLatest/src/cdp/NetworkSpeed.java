package cdp;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v106.network.Network;
import org.openqa.selenium.devtools.v106.network.model.ConnectionType;
import org.openqa.selenium.devtools.v106.network.model.MonotonicTime;
import org.testng.annotations.AfterMethod;

public class NetworkSpeed {
	ChromeDriver driver;
	DevTools devtools;

	@Test
	public void f() {
		long startTime = System.currentTimeMillis();
		driver.get("https://www.rahulshettyacademy.com/angularAppdemo/");
		driver.manage().window().maximize();

		WebElement lib_button = driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]"));
		lib_button.click();
		long endtTime = System.currentTimeMillis();

		long totalTime = endtTime - startTime;
		System.out.println("Time taken to execute the test " + getClass().getName() + " is " + totalTime);
	}

	@Test(enabled= false)
	public void test2() {
		long startTime = System.currentTimeMillis();
		driver.get("https://www.google.com/?gws_rd=ssl");
		WebElement searchBar = driver.findElement(By.name("q"));
		searchBar.sendKeys("Netflix");
		String title = driver.getTitle();
		System.out.println(title);
		searchBar.sendKeys(Keys.ENTER);

		WebElement firstSearch = driver.findElement(By.cssSelector("h3.LC20lb"));
		firstSearch.click();

		WebElement firstTitle = driver.findElement(By.cssSelector("h1.our-story-card-title"));
		String title1 = firstTitle.getText();
		System.out.println("netflix title in spanish: " + title1);

		long endtTime = System.currentTimeMillis();

		long totalTime = endtTime - startTime;
		System.out.println("Time taken to execute the test " + getClass().getName() + " is " + totalTime);
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		devtools = driver.getDevTools();
		devtools.createSession();

		devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devtools.send(Network.emulateNetworkConditions(false, 3000, 20000, 10000, Optional.of(ConnectionType.ETHERNET)));
		
		//devtools.send(Network.emulateNetworkConditions(true, 3000, 20000, 10000, Optional.of(ConnectionType.ETHERNET)));
		devtools.addListener(Network.loadingFailed(), loadingFailed->{
			String loadingfail= loadingFailed.getErrorText();
			System.out.println(loadingfail);
			
			MonotonicTime timeStamp= loadingFailed.getTimestamp();
			System.out.println(timeStamp);
		});
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
