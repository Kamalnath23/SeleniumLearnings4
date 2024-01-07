package KamalIndustries.Tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import KamalIndustries.PageObjects.cartPage;
import KamalIndustries.PageObjects.checkOutPage;
import KamalIndustries.PageObjects.confirmationPage;
import KamalIndustries.PageObjects.landingPage;
import KamalIndustries.PageObjects.orderPage;
import KamalIndustries.PageObjects.productCatalogue;
import KamalIndustries.TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class submitOrderTest extends BaseTest {
	//String productName = "zara coat 3";
	
	@Test(dataProvider="getData",groups= {"purchase"})
	public void submitOrder(HashMap<String, String> input) throws IOException {
		
		// landingPage LandingPage= launchApplication();   --> this method is used before 'BeforeMethod'
		System.out.println("Submit order test automation started");
		productCatalogue PC = LandingPage.loginApplication(input.get("email"), input.get("password"));

		List<WebElement> products = PC.getProductList();

		PC.addProductToCart(input.get("productName"));

		cartPage cp = PC.goToCartPage();

		Boolean match = cp.VerifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match);

		checkOutPage CheckOut = cp.goToCheckOut();
		CheckOut.selectCountry();

		confirmationPage confirmPage = CheckOut.submitOrder();
		String confirmedMsg = confirmPage.getConfirmationMessgae();

		Boolean check = confirmedMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER.");
		System.out.println(check);
		Assert.assertTrue(check);
		System.out.println("Submit order test automation ended");
	}
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void orderHistoryTest() {
		System.out.println("Order History test automation started");
		String productName= "zara coat 3";
		productCatalogue PC = LandingPage.loginApplication("kamalnath121998@gmail.com", "Password1*");
		orderPage OrderPage= PC.goToOrderPage();
		OrderPage.VerifyOrderDisplay(productName);
		
		Assert.assertTrue(OrderPage.VerifyOrderDisplay(productName));
		
		System.out.println("Order History test automation ended");
	}
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		List<HashMap<String,String>> data = getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\KamalIndustries\\Data\\purchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
	/* @DataProvider
	public Object[][] getData() {
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("email", "kamalnath121998@gmail.com");
		map.put("password", "Password1*");
		map.put("productName", "zara coat 3");
		
		HashMap<String, String> map2=new HashMap<String, String>();
		map2.put("email", "kamalnath199812@gmail.com");
		map2.put("password", "Password23$");
		map2.put("productName", "ADIDAS ORIGINAL");
		return new Object[][] {{map},{map2} };
	} */

}
