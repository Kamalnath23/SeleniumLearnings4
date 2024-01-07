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

public class CricBuzzTest2 {
	@Test
	public void HomePageCheck() throws MalformedURLException {
		DesiredCapabilities caps=new DesiredCapabilities();
		// caps.setBrowserName("firefox");
		// caps.setPlatform(Platform.WIN11);
		// caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		// caps.setCapability(CapabilityType.PROXY, true);
		caps.setCapability(CapabilityType.BROWSER_NAME, "firefox");
		
		WebDriver driver= new RemoteWebDriver(new URL("http://192.168.0.103:4444"),caps);
		
		driver.get("https://www.cricbuzz.com/cricket-commentary/43061/ind-vs-pak-16th-match-super-12-group-2-icc-mens-t20-world-cup-2022");
		String title=driver.getTitle();
		System.out.println(title);
	
		
	}
}
