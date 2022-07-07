package SRSproject.LoginTests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage_Global;
import Pages.LoginPage;
import SRSproject.SRSproject.BasePage;
import SRSproject.SRSproject.BaseTest;
import Utils.Constants;

public class UnAuthorizedAccessToEmsco extends BaseTest {
	// Run with PCS Config file wherein FIS and QPS user should not be logged in to
	// the PCS website

	HomePage_Global Hpg;

	@Test(priority = 1)
	public void AccessQPS() throws InterruptedException {
		Thread.sleep(3000);

		Hpg = new HomePage_Global(driver);

		if (driver.getCurrentUrl().equals(prop.get("EmscoLoginPagePoolURL"))) {

			Hpg.ValidLoginAgon();
			LoginPage Lp = new LoginPage(driver);
			Thread.sleep(3000);
			String QPS_errorMsg = Lp.handlePopup();
			if (QPS_errorMsg.equals(Constants.UnAuthorizedErrorMessage)) {
				System.out.println("QPS user is unauthorized to login PCS Website and shows appropriate error message");

			} else {
				System.out.println("Incorrect error message displayed");
			}
			Assert.assertEquals(QPS_errorMsg, Constants.UnAuthorizedErrorMessage);
		}
		else {
			System.out.println("Page Navigated incorrectly");
		}
		
		System.out.println(prop.get("PCSLoginPagePoolURL"));
		System.out.println(driver.getCurrentUrl());
		
	}
	}
