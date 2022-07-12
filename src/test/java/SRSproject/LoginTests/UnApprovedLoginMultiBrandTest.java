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
	LoginPage Lp;
	HomePage_Global Hpg;

	@Test(priority = 1)
	public void UnApprovedLoginMultiBrandValidationFIS() throws InterruptedException {

		Hpg = new HomePage_Global(driver);

		//Hpg.UnApprovedLoginMultiBrandFIS();
		Lp = new LoginPage(driver);
		Thread.sleep(3000);
		String FIS_errorMsg = Lp.handlePopup();
		if (FIS_errorMsg.equals(Constants.NotApprovedErrorMessage)) {
			System.out.println("FIS - The user is not approved and shows appropriate error message");

		} else {
			System.out.println("The user is logged in ");
		}
		Assert.assertEquals(FIS_errorMsg, Constants.NotApprovedErrorMessage);

		
	}
	
	@Test(priority = 2)
	public void UnApprovedLoginMultiBrandValidationCPS() throws InterruptedException {

		Hpg = new HomePage_Global(driver);

		Hpg.UnApprovedLoginMultiBrandCPS();
		Lp = new LoginPage(driver);
		Thread.sleep(3000);
		String CPS_errorMsg = Lp.handlePopup();
		if (CPS_errorMsg.equals(Constants.NotApprovedErrorMessage)) {
			System.out.println("CPS - The user is not approved and shows appropriate error message");

		} else {
			System.out.println("The user is logged in ");
		}
		Assert.assertEquals(CPS_errorMsg, Constants.NotApprovedErrorMessage);

		
	}
		
		

}
