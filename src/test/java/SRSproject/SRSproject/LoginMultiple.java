package SRSproject.SRSproject;

import java.io.IOException;
import java.util.Date;
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
			Date d = new Date();
			System.out.println("Execution start :"+ i+":"+d);
		Hp.ValidLogin();
		
		Hp.ChangeBranch();
		Thread.sleep(5000);
		Hp.SignOut();
		Date d1 = new Date();
		 System.out.println("Execution Ended:"+i +" :" + d1);
		Thread.sleep(1500000);

		}
}
	
		}

