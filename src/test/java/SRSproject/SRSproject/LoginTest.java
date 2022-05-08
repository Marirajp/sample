package SRSproject.SRSproject;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.HomePage_Global;
import Pages.LoginPage;
import Pages.ProductDetailPage;
import Pages.ProductListPage;
import SRSproject.SRSproject.BasePage;
import SRSproject.SRSproject.BaseTest;
import Utils.Constants;

public class LoginTest extends BaseTest {
	//Run brand website prop file
	ProductListPage plp;
	ProductDetailPage pdp;
	HomePage Hp;

	@Test(priority = 0)
	public void LoginValidation() throws InterruptedException {
		Thread.sleep(3000);
		Hp = new HomePage(driver);
		Hp.ValidLogin();
		Thread.sleep(8000);
		String URL = driver.getCurrentUrl();
		String Title = driver.getTitle();
		System.out.println(Title + "-> " + URL);

		if (URL.equals(prop.get("Homepage_url"))) {
			System.out.println("The User is navigated to the Brand Website");

		} else {
			System.out.println("The User is navigated incorrectly");
		}

		// Object exp1 = prop.get("PCSLoginPageURL");
		// Object exp2 = prop.get("PCSLoginPagePoolURL");
		Assert.assertEquals(URL, prop.get("Homepage_logurl"));
		Hp.confirmLogin(); 
		// assertTrue(FIS_URL.equals(exp1) || FIS_URL.equals(exp2));

	}
	
	@Test(priority = 1)
	public void UnApprovedLoginValidation() throws InterruptedException {

		HomePage Hp = new HomePage(driver);
		Hp.UnApprovedLogin();
		LoginPage Lp = new LoginPage(driver);
		Thread.sleep(3000);
		String errorMsg = Lp.handlePopup();
		if (errorMsg.equals(Constants.NotApprovedErrorMessage)) {
			System.out.println("The user is not approved and shows appropriate error message");

		} else {
			System.out.println("Incorrect error message displayed");
		}
		Assert.assertEquals(errorMsg, Constants.NotApprovedErrorMessage);

		//driver.close();
	}
	@Test(priority = 1,enabled = false)
	public void LoginFromPLP() throws Exception {
//		
		BasePage.initializtion();
		Thread.sleep(5000);
		for (int i = 0; i < 1; i++) {
			
		
		HomePage hp= new HomePage(driver);
		 Thread.sleep(2000);
		hp.mouseHoverSelectCategory();

	  Thread.sleep(500);
		
		plp = new ProductListPage(driver);
		
		hp.ValidLogin();
		
		Thread.sleep(5000);
		hp.SignOut();
		}
		}
	@Test(priority = 2,enabled = false)
	public void LoginFromPDP() throws Exception {
//		
		BasePage.initializtion();
		Thread.sleep(5000);
		for (int i = 0; i < 1; i++) {
			
		
		HomePage hp= new HomePage(driver);
		 Thread.sleep(2000);
		hp.mouseHoverSelectCategory();

	  Thread.sleep(5000);
		
		plp = new ProductListPage(driver);
		pdp = plp.GuestUser_ClickItem();
		Thread.sleep(2000);
		hp.ValidLogin();
		Thread.sleep(5000);
		hp.SignOut();
		}
	}}
	