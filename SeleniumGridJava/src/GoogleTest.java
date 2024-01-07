import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GoogleTest {
	@Test
	public void HomePageCheck() throws MalformedURLException {
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setBrowserName("chrome");
		caps.setPlatform(Platform.WIN11);
		// caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		// caps.setCapability(CapabilityType.PROXY, true);
		
		WebDriver driver= new RemoteWebDriver(new URL("http://192.168.0.103:4444"),caps);
		
		driver.get("https://www.google.com/?gws_rd=ssl");
		WebElement searchBar= driver.findElement(By.name("q"));
		searchBar.sendKeys("Ind vs pak 2022 scorecaed");
		String title=driver.getTitle();
		System.out.println(title);
		searchBar.sendKeys(Keys.ENTER);
		
	
		
	}
}
