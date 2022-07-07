package SRSproject.LoginTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage_Global;
import Pages.LoginPage;
import SRSproject.SRSproject.BasePage;
import SRSproject.SRSproject.BaseTest;
import Utils.Constants;

public class UnApprovedLoginMultiBrandTest extends BaseTest {
	
	//Run  configuration_staging.properties file
	LoginPage Lp;
	HomePage_Global Hpg;

	@Test(priority = 1,enabled = false)
	public void UnApprovedLoginMultiBrandValidationPCS() throws InterruptedException {

		Hpg = new HomePage_Global(driver);

		Hpg.UnApprovedLoginMultiBrandPCS();
		Lp = new LoginPage(driver);
		Thread.sleep(3000);
		String PCS_errorMsg = Lp.handlePopup();
		if (PCS_errorMsg.equals(Constants.NotApprovedErrorMessage)) {
			System.out.println("PCS - The user is not approved and shows appropriate error message");

		} else {
			System.out.println("The user is logged in ");
		}
		Assert.assertEquals(PCS_errorMsg, Constants.NotApprovedErrorMessage);

		//driver.close();
	}
		
		@Test()
		public void UnApprovedLoginMultiBrandValidationQPS() throws InterruptedException, IOException {

		//BasePage.initializtion();
		Hpg = new HomePage_Global(driver);
		Hpg.UnApprovedLoginMultiBrandQPS();
		LoginPage Lp = new LoginPage(driver);
		Thread.sleep(3000);
		String QPS_errorMsg = Lp.handlePopup();
		if (QPS_errorMsg.equals(Constants.NotApprovedErrorMessage)) {
			System.out.println("QPS - The user is not approved and shows appropriate error message");

		} else {
			System.out.println("The user is logged in ");
		}
		Assert.assertEquals(QPS_errorMsg, Constants.NotApprovedErrorMessage);


	}

}
