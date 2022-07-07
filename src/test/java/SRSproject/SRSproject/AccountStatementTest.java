package SRSproject.SRSproject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


import Pages.AccountStatementPage;
import Pages.LoginPage;

public class AccountStatementTest extends BaseTest {
	

	AccountStatementPage HP;
	@Test(priority=1,enabled=true)
	public void Account() throws Exception {
		  BasePage.initializtion();
       HP=new AccountStatementPage(driver);
		  Thread.sleep(3000);
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		Thread.sleep(5000);	
		String URL = driver.getCurrentUrl();
		String Title = driver.getTitle();
		System.out.println(Title + "-> " + URL);
		
		HP.AccountStatementButton();
		Thread.sleep(3000);
		HP.Downloadfiles();
		Thread.sleep(3000);
	
		HP.ReadfileData();
		Thread.sleep(5000);
	    HP.ReadXLdata();
		Thread.sleep(3000);
		String get = driver.getCurrentUrl();
		System.out.println(get);
		String AccUrl = prop.getProperty("AccountStatement");
		
		if(get.equalsIgnoreCase(AccUrl)) {
			System.out.println("working fine");
		}
		else {
			System.out.println("error");
			
		}
		Assert.assertEquals(get, AccUrl);
		

}
	@Test(priority=2,enabled=true)
	public void AccountStatementVerify() throws IOException, InterruptedException {
		
			       HP=new AccountStatementPage(driver);
//			  Thread.sleep(3000);
//			LoginPage Lp = new LoginPage(driver);
//			Lp.ValidLogin();
//			Thread.sleep(5000);	
//			String URL = driver.getCurrentUrl();
//			String Title = driver.getTitle();
//			System.out.println(Title + "-> " + URL);
		
			HP.AccountStatement2();
			Thread.sleep(3000);
			HP.AccountBalance();
			Thread.sleep(3000);
			
			String get = driver.getCurrentUrl();
			System.out.println(get);
			String AccUrl = prop.getProperty("AccountStatement");
			
			if(get.equalsIgnoreCase(AccUrl)) {
				System.out.println("working fine");
			}
			else {
				System.out.println("error");
				
			}
			Assert.assertEquals(get, AccUrl);
		
		
	}
	@Test(priority=3,enabled=false)
	public void PrintPageVerify() throws IOException, InterruptedException {
		
		 BasePage.initializtion();
	       HP=new AccountStatementPage(driver);
			  Thread.sleep(3000);
			LoginPage Lp = new LoginPage(driver);
			Lp.ValidLogin();
			Thread.sleep(5000);	
			String URL = driver.getCurrentUrl();
			String Title = driver.getTitle();
			System.out.println(Title + "-> " + URL);
			
		
			
			HP.AccountStatement();
			Thread.sleep(3000);
			
			
			String get = driver.getCurrentUrl();
			System.out.println(get);
			String AccUrl = prop.getProperty("AccountStatement");
			
			HP.PrintPageSta();
			Thread.sleep(3000);
			
//			boolean Available = HP.PrintStatement();
//			Assert.assertTrue(Available, "PrintPage Element Available");
//			System.out.println(Available);
			
//			
//			boolean NotAvailable = HP.printStatementAvailable();
//			Assert.assertFalse(NotAvailable, "PrintPage Element not available");
//			System.out.println(NotAvailable);
			
			String AccUrl1 = prop.getProperty("AccountStatement");
			
			if(get.equalsIgnoreCase(AccUrl1)) {
				System.out.println("working fine");
			}
			else {
				System.out.println("error");
				
			}
			Assert.assertEquals(get, AccUrl1);
	}

	@Test(priority=4,enabled=true)
	public void InvoiceIdVerify() throws IOException, InterruptedException {

		 BasePage.initializtion();
	       HP=new AccountStatementPage(driver);
			  Thread.sleep(8000);
			LoginPage Lp = new LoginPage(driver);
			Lp.ValidLogin();
			Thread.sleep(8000);	
			String URL = driver.getCurrentUrl();
			String Title = driver.getTitle();
			System.out.println(Title + "-> " + URL);
			
		
			
			HP.AccountStatement();
			Thread.sleep(8000);
			HP.InvoiceId();
			Thread.sleep(8000);
			
			String get = driver.getCurrentUrl();
			System.out.println(get);
			String AccUrl = prop.getProperty("AccountStatement");
			System.out.println(AccUrl);
	}
	
	@Test(priority=5,enabled=true)
	public void AccountBillVerify() throws IOException, InterruptedException {

		 BasePage.initializtion();
	       HP=new AccountStatementPage(driver);
			  Thread.sleep(8000);
			LoginPage Lp = new LoginPage(driver);
			Lp.ValidLogin();
			Thread.sleep(5000);	
			String URL = driver.getCurrentUrl();
			String Title = driver.getTitle();
			System.out.println(Title + "-> " + URL);
					
			HP.AccountStatement();
			Thread.sleep(3000);
			HP.AccountBill();
			Thread.sleep(3000);
			
			String get = driver.getCurrentUrl();
			System.out.println(get);
			String AccUrl = prop.getProperty("AccountStatement");
			System.out.println(AccUrl);
	}
	
	@Test(priority=6,enabled=true)
	public void PageCountVerify() throws IOException, InterruptedException {

		 BasePage.initializtion();
	       HP=new AccountStatementPage(driver);
			  Thread.sleep(8000);
			LoginPage Lp = new LoginPage(driver);
			Lp.ValidLogin();
			Thread.sleep(5000);	
			String URL = driver.getCurrentUrl();
			String Title = driver.getTitle();
			System.out.println(Title + "-> " + URL);
					
			HP.AccountStatement();
			Thread.sleep(3000);
			HP.ListOfPage();
			Thread.sleep(3000);
			
			String get = driver.getCurrentUrl();
			System.out.println(get);
			String AccUrl = prop.getProperty("AccountStatement");
			System.out.println(AccUrl);
	}
}
