

package SRSproject.SRSproject;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.MyAccountPage;

public class MyAccountPageTest extends BaseTest {
	
	MyAccountPage HP;
	@Test(priority=1,enabled=true)
	public void Account() throws InterruptedException, IOException {
    
		HP = new MyAccountPage(driver);
		Thread.sleep(5000);
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		Thread.sleep(5000);	
		String URL = driver.getCurrentUrl();
		String Title = driver.getTitle();
		System.out.println(Title + "-> " + URL);	
		
		HP.EditAccount();
		Thread.sleep(5000);
		String URL1 = driver.getCurrentUrl();
		String Title1 = driver.getTitle();
		System.out.println(Title1 + "-> " + URL1);	
		
		HP.ScrollToElement();
		Thread.sleep(5000);
		HP.FISTruck();
		Thread.sleep(5000);
		  String sa = HP.verify();
		
			Thread.sleep(8000);
	     
		HP.MiniCartPerform();
		Thread.sleep(3000);
		driver.getCurrentUrl();
		HP.ShippingShipPage();
		Thread.sleep(3000);
		driver.getCurrentUrl();
	//	HP.CheckBoxPerform();
		Thread.sleep(3000);
         
		 String sae = HP.verifysame();
		Thread.sleep(5000);
		
		
		Thread.sleep(5000);
			
		if (URL.equals(prop.get("Homepage_logurl"))) {
			System.out.println("The User is navigated to the EditAccount");

		} else {
			System.out.println("The User is navigated incorrectly");
		}

		Assert.assertEquals(URL, prop.get("Homepage_logurl"));
		
		Assert.assertEquals(sa,sae);
		
	}
	@Test(priority=2,enabled=true)
	public void ChangeBranch() throws Exception {
		 
			String URL = driver.getCurrentUrl();
			String Title = driver.getTitle();
			System.out.println(Title + "-> " + URL);	
			Thread.sleep(3000);
	HP.AccountModule();
	Thread.sleep(3000);
		HP.ChangeBranchmode();
		Thread.sleep(3000);
		
		HP.EditAccount();
		Thread.sleep(5000);
		
		HP.ScrollToElement();
		Thread.sleep(5000);
		HP.FISTruck();
		Thread.sleep(5000);
		  String sa = HP.verify();
		
			Thread.sleep(3000);
	     
		HP.MiniCartPerform();
		Thread.sleep(3000);
		driver.getCurrentUrl();
		HP.ShippingShipPage();
		Thread.sleep(3000);
		 String sae = HP.verifysame();
			Thread.sleep(5000);
	

		if (URL.equals(prop.get("Homepage_logurl"))) {
			System.out.println("The User is navigated to the EditAccount");

		} else {
			System.out.println("The User is navigated incorrectly");
		}

		Assert.assertEquals(URL, prop.get("Homepage_logurls"));
		
		Assert.assertEquals(sa,sae);
		
			
		
	}
	
	
	
}

