package accenture.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import accenture.AbstractComponents.AbstractComponent;

public class CardPage extends AbstractComponent {
	
	WebDriver driver ; 
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cardProducts;
	

	public CardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean VerifyProductDisplay(String productName) {
		
		Boolean match = cardProducts.stream().anyMatch(cardProduct -> cardProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	
	public CheckoutPage goToCheckout() {
		
		checkoutEle.click();
		return new CheckoutPage(driver);
	}
	
	
	

}
