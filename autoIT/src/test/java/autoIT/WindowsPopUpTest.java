package autoIT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WindowsPopUpTest {
	WebDriver driver;

	@BeforeTest
	public void chromeSetUp() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void f() {
		//driver.get("https://the-internet.herokuapp.com/");
		// http://Username:Password@SiteURL
		driver.get("http://admin:admin@the-internet.herokuapp.com/");
		WebElement BasicAuth = driver.findElement(By.linkText("Basic Auth"));
		BasicAuth.click();

	}

}
