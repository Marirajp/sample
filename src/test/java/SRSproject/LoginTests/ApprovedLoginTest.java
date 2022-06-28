package SRSproject.LoginTests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage_Global;
import Pages.LoginPage;
import SRSproject.SRSproject.BasePage;
import SRSproject.SRSproject.BaseTest;

public class ApprovedLoginTest extends BaseTest {
//Run  configuration_staging.properties file
	HomePage_Global Hpg;

	@Test(priority = 0,enabled = false)
	public void LoginValidationPCS() throws InterruptedException {

		Hpg = new HomePage_Global(driver);
		Hpg.ValidLoginPCS();

		Thread.sleep(8000);
		String PCS_URL = driver.getCurrentUrl();
		String PCS_Title = driver.getTitle();
		System.out.println(PCS_Title + "-> " + PCS_URL);

		if (PCS_URL.equals(prop.get("PCSLoginPagePoolURL"))) {
			System.out.println("The User is navigated to the PCS Website");

		} else {
			System.out.println("The User is navigated incorrectly");
		}

		// Object exp1 = prop.get("PCSLoginPageURL");
		// Object exp = prop.get("PCSLoginPagePoolURL");
		Assert.assertEquals(PCS_URL, prop.get("PCSLoginPagePoolURL"));
		Hpg.confirmLogin();

		// assertTrue(PCS_URL.equals(exp1) || PCS_URL.equals(exp2));

		// driver.close();

	}

	@Test(priority = 1)
	public void LoginValidationQPS() throws InterruptedException, IOException {
		// BasePage.initializtion();

		Hpg = new HomePage_Global(driver);
		Hpg.ValidLoginQPS();
		Thread.sleep(8000);
		String QPS_URL = driver.getCurrentUrl();
		String QPS_Title = driver.getTitle();
		System.out.println(QPS_Title + "-> " + QPS_URL);

		if (QPS_URL.equals(prop.get("QPSLoginPagePoolURL"))) {
			System.out.println("The User is navigated to the QPS Website");

		} else {
			System.out.println("The User is navigated incorrectly");
		}

		// Object exp1 = prop.get("QPSLoginPageURL");
		// Object exp2 = prop.get("QPSLoginPagePoolURL");
		Assert.assertEquals(QPS_URL, prop.get("QPSLoginPagePoolURL"));
		Hpg.confirmLogin();

		// assertTrue(QPS_URL.equals(exp1) || QPS_URL.equals(exp2));

		// driver.close();

	}

}
