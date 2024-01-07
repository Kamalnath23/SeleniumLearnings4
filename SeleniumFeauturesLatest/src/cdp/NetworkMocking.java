package cdp;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v106.fetch.Fetch;
import org.testng.annotations.AfterMethod;

public class NetworkMocking {
	ChromeDriver driver;
	DevTools devtools;

	@Test
	public void f() throws InterruptedException {
		driver.get("https://www.rahulshettyacademy.com/angularAppdemo/");
		driver.manage().window().maximize();

		WebElement lib_button = driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]"));
		lib_button.click();
		
		Thread.sleep(2550);
		
		WebElement output= driver.findElement(By.cssSelector("p"));
		String op=output.getText();
		System.out.println(op);
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		devtools = driver.getDevTools();
		devtools.createSession();

		devtools.send(Fetch.enable(Optional.empty(), Optional.empty()));

		devtools.addListener(Fetch.requestPaused(), request -> {
			if (request.getRequest().getUrl().contains("shetty")) {
				String newURL = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
				System.out.println(newURL);

				devtools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(newURL),
						Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty(),
						java.util.Optional.empty()));
			} else {
				devtools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()),
						Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty(),
						java.util.Optional.empty()));
			}

		});
	}

	@AfterMethod
	public void afterMethod() {
		//driver.close();
	}

}
