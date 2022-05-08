package SRSproject.LoginTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage_Global;
import Pages.LoginPage;
import SRSproject.SRSproject.BasePage;
import SRSproject.SRSproject.BaseTest;
import Utils.Constants;

public class UnApprovedLoginTest extends BaseTest {
	//Run  configuration_staging.properties file
	LoginPage Lp;
	HomePage_Global Hpg;

	@Test(priority = 1)
	public void UnApprovedLoginValidationPCS() throws InterruptedException {

		HomePage_Global Hpg = new HomePage_Global(driver);
		Hpg.UnApprovedLoginPCS();
		LoginPage Lp = new LoginPage(driver);
		Thread.sleep(3000);
		String PCS_errorMsg = Lp.handlePopup();
		if (PCS_errorMsg.equals(Constants.NotApprovedErrorMessage)) {
			System.out.println("PCS - The user is not approved and shows appropriate error message");

		} else {
			System.out.println("Incorrect error message displayed");
		}
		Assert.assertEquals(PCS_errorMsg, Constants.NotApprovedErrorMessage);

		//driver.close();
	}

	@Test(enabled = false)
	public void UnApprovedLoginValidationQPS() throws InterruptedException, IOException {
		//BasePage.initializtion();
		HomePage_Global Hpg = new HomePage_Global(driver);
		Hpg.UnApprovedLoginQPS();
		LoginPage Lp = new LoginPage(driver);
		Thread.sleep(3000);
		String QPS_errorMsg = Lp.handlePopup();
		if (QPS_errorMsg.equals(Constants.NotApprovedErrorMessage)) {
			System.out.println("QPS - The user is not approved and shows appropriate error message");

		} else {
			System.out.println("Incorrect error message displayed");
		}
		Assert.assertEquals(QPS_errorMsg, Constants.NotApprovedErrorMessage);

		

	}

}
