import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.AfterMethod;

public class setGeoLocations {
	ChromeDriver driver;
	DevTools devtools;

	@Test
	public void testNetflix() {
		driver.get("https://www.google.com/?gws_rd=ssl");
		WebElement searchBar = driver.findElement(By.name("q"));
		searchBar.sendKeys("Netflix");
		String title = driver.getTitle();
		System.out.println(title);
		searchBar.sendKeys(Keys.ENTER);
		
		
		WebElement firstSearch= driver.findElement(By.cssSelector("h3.LC20lb"));
		firstSearch.click();
		
		WebElement firstTitle= driver.findElement(By.cssSelector("h1.our-story-card-title"));
		String title1= firstTitle.getText();
		System.out.println("netflix title in spanish: "+title1);
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method");
		System.setProperty("webdriver.chrome.driver",
				"D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\Chrome\\chromedriver.exe");
		
		
		driver = new ChromeDriver();
		devtools = driver.getDevTools();
		devtools.createSession();

		// co-ordinates
		Map<String, Object> geoLocation = new HashMap<String, Object>();
		//Map geoLocation= new HashMap();
		geoLocation.put("latitude", 40);
		geoLocation.put("longitude", 3);
		geoLocation.put("accuracy", 1);

		driver.executeCdpCommand("Emulation.setGeolocationOverride", geoLocation);
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("after method.");
	}

}
