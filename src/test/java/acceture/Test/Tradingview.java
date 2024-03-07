package acceture.Test;

import java.io.IOException;

import org.testng.annotations.Test;

import accenture.TestComponents.BaseTest;

public class Tradingview extends BaseTest {

	@Test
	public void Trading() throws IOException {
		//driver = initializeDriver();
		//driver.get("https://in.tradingview.com/chart/");
		driver.get("https://apps.powerapps.com/play/e/7b742607-aab4-4064-bff3-7c3a75d9c9c4/a/563d4e7c-8e22-4895-b65f-99e7f74ee170?tenantId=e0793d39-0939-496d-b129-198edd916feb&source=portal&hidenavbar=true");

	}

}
