package acceture.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import accenture.TestComponents.BaseTest;
import accenture.pageobjects.CardPage;
import accenture.pageobjects.CheckoutPage;
import accenture.pageobjects.ConfirmationPage;
import accenture.pageobjects.LandingPage;
import accenture.pageobjects.OrderPage;
import accenture.pageobjects.ProductCatalouge;

public class SubmitOrderTest_Final extends BaseTest {
	
	String productName = "ZARA COAT 3";

	@Test(dataProvider ="getData", groups= "purchase")
	public void SubmitOrder(HashMap<String,String> input ) throws IOException {

		
		// WebDriverManager.chromedriver().setup();
		// WebDriver driver = new ChromeDriver();
		// driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// LandingPage landingPage = new LandingPage(driver);
		// landingPage.goTo();
		//LandingPage landingPage = lunchAppliation();
		ProductCatalouge productCatalouge = landingPage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productCatalouge.getProductList();
		productCatalouge.addProductToCart(input.get("product"));
		CardPage cardPage = productCatalouge.goToCardPage();
		Boolean match = cardPage.VerifyProductDisplay(input.get("product"));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cardPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMsg = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	}
	
	@Test(dependsOnMethods = {"SubmitOrder"})
	public void OrderHistoryTest() {
		
		ProductCatalouge productCatalouge = landingPage.loginApplication("sourabhgole@gmail.com", "Galaxysg@1994");
		OrderPage orderPage = productCatalouge.goToOrdersPage();
		Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));
	}
	
	
	
	

	@DataProvider
	public Object[][] getData() throws IOException {
		
		/*
		 * HashMap<String, String> map = new HashMap<String, String>(); map.put("email",
		 * "sourabhgole@gmail.com"); map.put("password", "Galaxysg@1994");
		 * map.put("product", "ZARA COAT 3");
		 * 
		 * 
		 * HashMap<String, String> map1 = new HashMap<String, String>();
		 * map1.put("email", "sourabh1gole1@gmail.com"); map1.put("password",
		 * "Galaxysg@1994"); map1.put("product", "ADIDAS ORIGINAL");
		 */
		
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//accenture//data//PurchaseOrder.json");
		return new Object [][]{{data.get(0)},{data.get(1)}};
	
		
		
	}
}
