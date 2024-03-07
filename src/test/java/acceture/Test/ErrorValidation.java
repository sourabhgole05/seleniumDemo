package acceture.Test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import accenture.TestComponents.BaseTest;
import accenture.TestComponents.Retry;
import accenture.pageobjects.CardPage;
import accenture.pageobjects.CheckoutPage;
import accenture.pageobjects.ConfirmationPage;
import accenture.pageobjects.LandingPage;
import accenture.pageobjects.ProductCatalouge;

public class ErrorValidation extends BaseTest {

	@Test(groups = "ErrorHandling", retryAnalyzer= Retry.class )
	public void LoginErrorValidation() throws IOException {

		
		landingPage.loginApplication("sourabh1gole1@gmail.com", "Galaxysg@11994");
		Assert.assertEquals("Incorrect email1 or password.", landingPage.getErrorMessage());
		
	}

}
