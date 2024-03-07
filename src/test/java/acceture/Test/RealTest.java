package acceture.Test;

import java.util.List;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class RealTest {

	@Test
	public static void loginPowerBI() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		driver.get(
				"https://apps.powerapps.com/play/e/7b742607-aab4-4064-bff3-7c3a75d9c9c4/a/563d4e7c-8e22-4895-b65f-99e7f74ee170?tenantId=e0793d39-0939-496d-b129-198edd916feb&source=portal&hidenavbar=true");

		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("sourabh.gole@accenture.com");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys("Poojasg@1994");

		WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#i0118")));
		driver.findElement(By.xpath("//input[@data-report-event='Signin_Submit']")).click();
		
	
		driver.findElement(By.cssSelector("#fullscreen-app-host"));
		//System.out.println("Total number of iframes"+ iframes.size());
		
		
		
		
		
		//driver.findElement(By.xpath("//button[@data-control-part='button']")).click();
		 
		
		
		/*
		 * try { Alert alert = driver.switchTo().alert();
		 * System.out.println("Alert Text:" + alert.getText());
		 * 
		 * alert.accept();
		 * 
		 * } catch (Exception e) { System.out.println("No alert found"); }
		 */

		
	}

}
