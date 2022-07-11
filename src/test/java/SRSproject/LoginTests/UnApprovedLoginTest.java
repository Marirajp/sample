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
	LoginPage Lp;
	HomePage_Global Hpg;

	@Test(priority = 0)
	public void UnApprovedLoginValidationFIS() throws InterruptedException {

		HomePage_Global Hpg = new HomePage_Global(driver);
		Hpg.UnApprovedLoginFIS();
		LoginPage Lp = new LoginPage(driver);
		Thread.sleep(8000);
		String FIS_errorMsg = Lp.handlePopup();
		if (FIS_errorMsg.equals(Constants.NotApprovedErrorMessage)) {
			System.out.println("FIS - The user is not approved and shows appropriate error message");

		} else {
			System.out.println("Incorrect error message displayed");
		}
		Assert.assertEquals(FIS_errorMsg, Constants.NotApprovedErrorMessage);

	}
	
	@Test(priority = 1)
	public void UnApprovedLoginValidationCPS() throws InterruptedException {

		HomePage_Global Hpg = new HomePage_Global(driver);
		Hpg.UnApprovedLoginCPS();
		LoginPage Lp = new LoginPage(driver);
		Thread.sleep(8000);
		String CPS_errorMsg = Lp.handlePopup();
		if (CPS_errorMsg.equals(Constants.NotApprovedErrorMessage)) {
			System.out.println("CPS - The user is not approved and shows appropriate error message");

		} else {
			System.out.println("Incorrect error message displayed");
		}
		Assert.assertEquals(CPS_errorMsg, Constants.NotApprovedErrorMessage);

	}
} 