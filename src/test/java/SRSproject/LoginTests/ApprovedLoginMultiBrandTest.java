package SRSproject.LoginTests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage_Global;
import Pages.LoginPage;
import SRSproject.SRSproject.BasePage;
import SRSproject.SRSproject.BaseTest;

public class ApprovedLoginMultiBrandTest extends BaseTest {
	// Run configuration_staging.properties file
	HomePage_Global Hpg;

	@Test(priority = 0,enabled = false)
	public void LoginValidationForMultiBrandPCS() throws InterruptedException {
		Thread.sleep(3000);
		Hpg = new HomePage_Global(driver);

		// PCS
		Hpg.ValidLoginMultiBrandPCS();
		Thread.sleep(8000);
		String PCS_URL = driver.getCurrentUrl();
		String PCS_Title = driver.getTitle();
		// Object exp1 = prop.get("PCSLoginPageURL");
		// Object exp2 = prop.get("PCSLoginPagePoolURL");
		System.out.println(PCS_Title + "-> " + PCS_URL);
		// assert (PCS_URL.equals(exp1) || PCS_URL.equals(exp2));

		if (PCS_URL.equals(prop.get("PCSLoginPagePoolURL"))) {
			System.out.println("The User is navigated to the PCS Website");

		} else {
			System.out.println("The User is navigated incorrectly");
		}

		Assert.assertEquals(PCS_URL, prop.get("PCSLoginPagePoolURL"));
		Hpg.confirmLogin();
	}

	//@Test(enabled = false)
	@Test(priority=1)
	
	public void LoginValidationForMultiBrandQPS() throws InterruptedException, IOException {
		// BasePage.initializtion();
		Hpg = new HomePage_Global(driver);
		Hpg.ValidLoginMultiBrandQPS();
		Thread.sleep(8000);
		String QPS_URL = driver.getCurrentUrl();
		String QPS_Title = driver.getTitle();
		// Object exp3 = prop.get("QPSLoginPageURL");
		// Object exp4 = prop.get("QPSLoginPagePoolURL");
		System.out.println(QPS_Title + "-> " + QPS_URL);
		// assert (QPS_URL.equals(exp3) || QPS_URL.equals(exp4));

		if (QPS_URL.equals(prop.get("QPSLoginPagePoolURL"))) {
			// if (QPS_URL.equals(prop.get("QPSAccountLoginPageURL"))) {
			System.out.println("The User is navigated to the QPS Website");

		} else {
			System.out.println("The User is navigated incorrectly");
		}
		Assert.assertEquals(QPS_URL, prop.get("QPSLoginPagePoolURL"));
		// Assert.assertEquals(QPS_URL, prop.get("QPSAccountLoginPageURL"));
		Hpg.confirmLogin();
	}

}
