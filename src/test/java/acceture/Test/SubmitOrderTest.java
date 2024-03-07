package acceture.Test;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import accenture.pageobjects.CardPage;
import accenture.pageobjects.CheckoutPage;
import accenture.pageobjects.ConfirmationPage;
import accenture.pageobjects.LandingPage;
import accenture.pageobjects.ProductCatalouge;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String productName = "I PHONE";

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		LandingPage landingPage = new LandingPage(driver);

		landingPage.goTo();
		ProductCatalouge productCatalouge = landingPage.loginApplication("sourabhgole@gmail.com", "Galaxysg@1994");
		// ProductCatalouge productCatalouge = new ProductCatalouge(driver);
		List<WebElement> products = productCatalouge.getProductList();
		productCatalouge.addProductToCart(productName);
		CardPage cardPage = productCatalouge.goToCardPage();

		Boolean match = cardPage.VerifyProductDisplay(productName);

		// driver.findElement(By.id("userEmail")).sendKeys("sourabhgole@gmail.com");
		// driver.findElement(By.id("userPassword")).sendKeys("Galaxysg@1994");
		// driver.findElement(By.id("login")).click();

		// <!TKE>
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		/*
		 * List<WebElement> products = driver.findElements(By.cssSelector(".mb-3 "));
		 * WebElement prod = products.stream().filter(product ->
		 * product.findElement(By.cssSelector("b")).getText().equals(productName)).
		 * findFirst().orElse(null);
		 * prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		 */
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		// // toast-container option visible
		// wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

		// List<WebElement> cardProducts =
		// driver.findElements(By.cssSelector(".cartSection h3"));
		// Boolean match = cardProducts.stream().anyMatch(cardProduct ->
		// cardProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		// driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();
		CheckoutPage checkoutPage = cardPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMsg = confirmationPage.getConfirmationMessage();

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".totalRow
		// button")));
		// driver.findElement(By.cssSelector(".totalRow button")).click();
		// Actions a = new Actions(driver);
		// a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select
		// Country']")), "india").build().perform();
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

		// driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		// Thread.sleep(2000);
		// WebElement checkoutButton =
		// driver.findElement(By.cssSelector(".action__submit"));
		// a.moveToElement(checkoutButton).click().build().perform();
		// driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		// wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action__submit")));
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Place
		// Order ')]")));
		// driver.findElement(By.cssSelector(".action__submit")).click();
		// driver.findElement(By.xpath("//*[contains(text(),'Place Order ')]")).click();
		// String confirmMsg =
		// driver.findElement(By.cssSelector(".hero-primary")).getText();

		Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();

	}

}
