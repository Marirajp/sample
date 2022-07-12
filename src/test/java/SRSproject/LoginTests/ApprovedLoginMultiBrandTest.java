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
	HomePage_Global Hpg;

	@Test(priority = 0)
	public void LoginValidationForMultiBrandFIS() throws InterruptedException {
		// Thread.sleep(3000);

		Hpg = new HomePage_Global(driver);

		Hpg.ValidLoginMultiBrandFIS();
		Thread.sleep(8000);
		String FIS_URL = driver.getCurrentUrl();
		String FIS_Title = driver.getTitle();
		// Object exp1 =prop.get("PCSLoginPageURL");
		// Object exp2 = prop.get("PCSLoginPagePoolURL");
		System.out.println(FIS_Title + "-> " + FIS_URL);

		// assert(PCS_URL.equals(exp1) || PCS_URL.equals(exp2));

		if (FIS_URL.equals(prop.get("FISLoginPageURL"))) {
			System.out.println("The User is navigated to the FIS Website");

		} else {
			System.out.println("The User is navigated incorrectly");
		}

		Assert.assertEquals(FIS_URL, prop.get("FISLoginPageURL"));
		Hpg.confirmLogin();
	}

	@Test(priority = 1)
	public void LoginValidationForMultiBrandCPS() throws InterruptedException {
		// Thread.sleep(3000);

		Hpg = new HomePage_Global(driver);

		Hpg.ValidLoginMultiBrandCPS();
		Thread.sleep(8000);
		String CPS_URL = driver.getCurrentUrl();
		String CPS_Title = driver.getTitle();

		System.out.println(CPS_Title + "-> " + CPS_URL);

		if (CPS_URL.equals(prop.get("CPSLoginPageURL"))) {
			System.out.println("The User is navigated to the CPS Website");

		} else {
			System.out.println("The User is navigated incorrectly");
		}

		Assert.assertEquals(CPS_URL, prop.get("CPSLoginPageURL"));
     Hpg.confirmLogin();
	}

}
