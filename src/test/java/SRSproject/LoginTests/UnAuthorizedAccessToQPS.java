package SRSproject.LoginTests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.HomePage_Global;
import Pages.LoginPage;
import SRSproject.SRSproject.BasePage;
import SRSproject.SRSproject.BaseTest;
import Utils.Constants;

public class UnAuthorizedAccessToQPS extends BaseTest {
	// Run with QPS Config file wherein FIS and PCS user should not be logged in to
    // the QPS website


	HomePage_Global Hpg;
	HomePage Hp;

	@Test(priority = 1)
	public void AccessPCS() throws InterruptedException {
		Thread.sleep(3000);

		Hpg = new HomePage_Global(driver);
		Object object = prop.get("QPSLoginPagePoolURL");
		System.out.println(object);
		if (driver.getCurrentUrl().equals(prop.get("QPSLoginPagePoolURL"))) {

			Hpg.ValidLoginPCS();
			LoginPage Lp = new LoginPage(driver);
			Thread.sleep(3000);
			String PCS_errorMsg = Lp.handlePopup();
			if (PCS_errorMsg.equals(Constants.UnAuthorizedErrorMessage)) {
				System.out.println("PCS user is unauthorized to login QPS Website and shows appropriate error message");

			} else {
				System.out.println("Incorrect error message displayed");
			}
			Assert.assertEquals(PCS_errorMsg, Constants.UnAuthorizedErrorMessage);
		}
	

	}}
