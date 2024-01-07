package autoIT;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

public class FileUploadTest {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException, IOException {
	  driver.get("https://smallpdf.com/word-to-pdf");
	  
	  WebElement chooseFiles = driver.findElement(By.cssSelector("button.l3tlg0-0"));
	  chooseFiles.click();
	  
	  Thread.sleep(7000);
	  
	  //java part
	  // "D:\IT Skill Up Zone - Practicals\AutoIT\fileupload.exe"
	  Runtime.getRuntime().exec("D:\\IT Skill Up Zone - Practicals\\AutoIT\\fileupload.exe");
	 // Runtime.getRuntime().exec("D:\\IT Skill Up Zone - Practicals\\AutoIT\fileupload.exe");
	  
	  WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='r5zwp6-2 gMrRSQ'][@aria-hidden=\"false\"]/div[@class='r5zwp6-0'])[1]")));
	  //Thread.sleep(7000);
	  
	  WebElement download= driver.findElement(By.xpath("(//div[@class='r5zwp6-2 gMrRSQ'][@aria-hidden=\"false\"]/div[@class='r5zwp6-0'])[1]"));
	  download.click();
	  
	  //THIS METHOD ONLY WORKS FOR LOCAL SYSTEM NOT A JENKINS/OTHERS SYSTEM
	  File f=new File("C:\\Users\\Kamalnath\\Downloads\\test.pdf");
	  if(f.exists()) {
		  System.out.println("file found");
	  }else {
		  System.out.println("file not found");
	  }
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {

	  System.setProperty("webdriver.chrome.driver",
				"D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
  }
}
