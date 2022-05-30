package SRSproject.SRSproject;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage_Global;
import Pages.LoginPage;
import Utils.Constants;

public class GlobalMultibrandLogin extends BaseTest{
	
	HomePage_Global  Hpg ;
	BasePage  Bp;
	LoginPage Lp;
	

	@Test(priority = 1)
	public void ValidMultiSelectPCS() throws Exception {
		Hpg = new HomePage_Global(driver);
		Hpg.ValidLoginMultiBrandPCS();
		Thread.sleep(10000) ;
		System.out.println(driver.getCurrentUrl());
		Hpg.SignOut();
		
		
		
	}
	
	@Test(priority = 2)
	public void ValidMultiSelectCPS() throws Exception {
     getUrl(prop.getProperty("url"));
		Hpg = new HomePage_Global(driver);
		Hpg.ValidLoginMultiBrandCPS();
		Thread.sleep(8000) ;
		System.out.println(driver.getCurrentUrl());
		
		

	}
	
	@Test(priority = 3)
	public void ValidMultiSelectFIS() throws Exception {
		 getUrl(prop.getProperty("url"));
		Hpg = new HomePage_Global(driver);
		Hpg.ValidLoginMultiBrandFIS();
		Thread.sleep(8000) ;
		System.out.println(driver.getCurrentUrl());
	}
	@Test(priority = 4)
	public void ValidMultiLoginSelectQPS() throws Exception {
		 getUrl(prop.getProperty("url"));
		Hpg = new HomePage_Global(driver);
		Hpg.ValidLoginMultiBrandQPS();
		Thread.sleep(8000) ;
		
	
		System.out.println(driver.getCurrentUrl());
	}
	
	@Test(priority = 5)
	public void InvalidMultiLogin() throws Exception {
		 getUrl(prop.getProperty("url"));
		Hpg = new HomePage_Global(driver);
		Hpg.InValidLoginMultiBrand();
		Lp = new LoginPage(driver);
		Thread.sleep(3000);
		String errorMsg = Lp.handlePopup();
		if (errorMsg.equals(Constants.InvalidErrormsge)) {
			System.out.println("Invalid login or password.");

		} else {
			System.out.println("The user is logged in ");
		}
		Assert.assertEquals(errorMsg, Constants.InvalidErrormsge);

		
	}
		

	@Test(priority = 6)
	public void UnApprovedLoginMultiBrandValidation() throws Exception {
		 getUrl(prop.getProperty("url"));
		Hpg = new HomePage_Global(driver);

		Hpg.UnApprovedLoginMultiBrand();
		Lp = new LoginPage(driver);
		Thread.sleep(3000);
		String errorMsg = Lp.handlePopup();
		if (errorMsg.equals(Constants.NotApprovedErrorMessage)) {
			System.out.println("The user is not approved and shows appropriate error message");

		} else {
			System.out.println("The user is logged in ");
		}
		Assert.assertEquals(errorMsg, Constants.NotApprovedErrorMessage);

		
	}
}
	



