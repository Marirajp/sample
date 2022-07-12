package SRSproject.LoginTests;

import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.HomePage_Global;
import Pages.ProductDetailPage;
import Pages.ProductListPage;
import SRSproject.SRSproject.BasePage;
import SRSproject.SRSproject.BaseTest;

public class LoginMultiple extends BaseTest{
	ProductListPage plp;
	ProductDetailPage pdp;
//	HomePage_Global Hpg;
	HomePage Hp;

	@Test(priority = 0)
	public void LoginMultipleTimes() throws Exception {
		Thread.sleep(3000);
		Hp = new HomePage(driver);
		for (int i = 0; i < 10; i++) {			
		
		Hp.ValidLogin();
		Hp.ChangeBranch();
		Thread.sleep(5000);
		Hp.SignOut();

		}
}
	@Test(priority = 1)
	public void LoginFromPLP() throws Exception {
//		
		BasePage.initializtion();
		Thread.sleep(5000);
		for (int i = 0; i < 2; i++) {
			
		
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
		for (int i = 0; i < 2; i++) {
			
		
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
		}
}
