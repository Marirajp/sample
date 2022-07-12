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

public class UnAuthorizedAccessToFIS extends BaseTest {

	HomePage_Global Hpg;

	//Run with FIS Config file wherein PCS and QPS user should not be logged in to the FIS website

//	@Test
//	public void AccessPCS() throws InterruptedException, IOException {
//		Thread.sleep(3000);
//	
//		Hpg = new HomePage_Global(driver);
//
//		if (driver.getCurrentUrl().equals(prop.get("FISLoginPageURL"))) {
//			Hpg.ValidLoginPCS();
//			LoginPage Lp = new LoginPage(driver);
//			Thread.sleep(3000);
//			String PCS_errorMsg = Lp.handlePopup();
//			if (PCS_errorMsg.equals(Constants.UnAuthorizedErrorMessage)) {
//				System.out.println("PCS user is unauthorized to login FIS Website and shows appropriate error message");
//
//			} else {
//				System.out.println("Incorrect error message displayed");
//			}
//			Assert.assertEquals(PCS_errorMsg, Constants.UnAuthorizedErrorMessage);
//
//			driver.close();
//		} 
//	}
//	@Test
//	public void AccessQPS() throws InterruptedException, IOException {
//		Thread.sleep(3000);
//		Hpg = new HomePage_Global(driver);
//
//		if (driver.getCurrentUrl().equals(prop.get("FISLoginPageURL"))) {
//			Hpg.ValidLoginQPS();
//			LoginPage Lp = new LoginPage(driver);
//			Thread.sleep(3000);
//			String QPS_errorMsg = Lp.handlePopup();
//			if (QPS_errorMsg.equals(Constants.UnAuthorizedErrorMessage)) {
//				System.out.println("QPS user is unauthorized to login FIS Website and shows appropriate error message");
//
//			} else {
//				System.out.println("Incorrect error message displayed");
//			}
//			Assert.assertEquals(QPS_errorMsg, Constants.UnAuthorizedErrorMessage);
//		}
//		driver.close();
//
//	}
	
	@Test
	public void AccessCPS() throws InterruptedException, IOException {
		Thread.sleep(3000);
		Hpg = new HomePage_Global(driver);

		//if (driver.getCurrentUrl().equals(prop.get("FISLoginPageURL"))) {
			Hpg.ValidLoginCPS();
			LoginPage Lp = new LoginPage(driver);
			Thread.sleep(3000);
			String CPS_errorMsg = Lp.handlePopup();
			if (CPS_errorMsg.equals(Constants.UnAuthorizedErrorMessage)) {
				System.out.println("CPS user is unauthorized to login FIS Website and shows appropriate error message");

			} else {
				System.out.println("Incorrect error message displayed");
			}
			Assert.assertEquals(CPS_errorMsg, Constants.UnAuthorizedErrorMessage);
		//}
//		driver.close();

	}

}
