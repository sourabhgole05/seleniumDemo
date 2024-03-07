package accenture.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import accenture.AbstractComponents.AbstractComponent;


public class LandingPage extends AbstractComponent {

	WebDriver driver ;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	

	@FindBy(css="div[aria-label='Incorrect email or password.']")
	WebElement errorMessage;
	
	public  String getErrorMessage() {
		
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
		
	}
	
	
	public ProductCatalouge loginApplication(String email, String pwd) {
		userEmail.sendKeys(email);
		password.sendKeys(pwd);
		submit.click();
		ProductCatalouge productCatalouge = new ProductCatalouge(driver);
		return productCatalouge;
	}
	
		
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
}
