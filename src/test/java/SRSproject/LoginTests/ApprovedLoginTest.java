package SRSproject.LoginTests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage_Global;
import Pages.LoginPage;
import SRSproject.SRSproject.BasePage;
import SRSproject.SRSproject.BaseTest;

public class ApprovedLoginTest extends BaseTest {

	HomePage_Global Hpg;

	@Test(priority = 0)
	public void LoginValidationFIS() throws InterruptedException {
		Thread.sleep(3000);
		Hpg = new HomePage_Global(driver);
		Hpg.ValidLoginFIS();
		Thread.sleep(8000);
		String FIS_URL = driver.getCurrentUrl();
		String FIS_Title = driver.getTitle();
		System.out.println(FIS_Title + "-> " + FIS_URL);

		if (FIS_URL.equals(prop.get("FISLoginPageURL"))) {
			System.out.println("The User is navigated to the FIS Website");

		} else {
			System.out.println("The User is navigated incorrectly");
		}

		// Object exp1 = prop.get("PCSLoginPageURL");
		// Object exp2 = prop.get("PCSLoginPagePoolURL");
		Assert.assertEquals(FIS_URL, prop.get("FISLoginPageURL"));
		Hpg.confirmLogin(); 
		// assertTrue(FIS_URL.equals(exp1) || FIS_URL.equals(exp2));

	}
	@Test(priority = 1)
	public void LoginValidationCPS() throws InterruptedException, IOException {
//		BasePage.initializtion();
		Thread.sleep(3000);
     
		Hpg = new HomePage_Global(driver);
		Hpg.ValidLoginCPS();
		Thread.sleep(8000);
		String CPS_URL = driver.getCurrentUrl();
		String CPS_Title = driver.getTitle();
		System.out.println(CPS_Title + "-> " + CPS_URL);

		if (CPS_URL.equals(prop.get("CPSLoginPageURL"))) {
			System.out.println("The User is navigated to the CPS Website");

		} else {
			System.out.println("The User is navigated incorrectly");
		}

		// Object exp1 = prop.get("PCSLoginPageURL");
		// Object exp2 = prop.get("PCSLoginPagePoolURL");
		Assert.assertEquals(CPS_URL, prop.get("CPSLoginPageURL"));
		Hpg.confirmLogin();
		// assertTrue(FIS_URL.equals(exp1) || FIS_URL.equals(exp2));

	}

}
