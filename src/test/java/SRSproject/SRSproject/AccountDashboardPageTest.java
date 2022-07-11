package SRSproject.SRSproject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AccountDashboardPage;
import Pages.LoginPage;


public class AccountDashboardPageTest extends BaseTest {
	
	
	AccountDashboardPage HP;
	@Test(priority=1)
	public void Account() throws InterruptedException, IOException {
       HP=new AccountDashboardPage(driver);
		  Thread.sleep(3000);
       
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		Thread.sleep(5000);	
		String URL = driver.getCurrentUrl();
		String Title = driver.getTitle();
		System.out.println(Title + "-> " + URL);
		
	
				
		HP.EditOrganization();
		Thread.sleep(5000);
		String URL1 = driver.getCurrentUrl();
		String Title1 = driver.getTitle();
		String CompanyProfileEdit = prop.getProperty("CompanyProfileEdit");
		System.out.println(Title1 + "-> " + URL1);
		
		if(URL1.equalsIgnoreCase(CompanyProfileEdit)) {
			System.out.println("working fine");
		}
		else {
			System.out.println("error");
			
		}
		
		Assert.assertEquals(URL1, prop.get("CompanyProfileEdit"));
	
			
	}
	@Test(priority=2)
	public void DashBoard() throws InterruptedException, IOException {
		
		
		 HP=new AccountDashboardPage(driver);
		  Thread.sleep(3000);
  
		HP.AccountModule();
		Thread.sleep(3000);
		String AccURL = driver.getCurrentUrl();
		String Title2 = driver.getTitle();
		String EditPersonalInfo = prop.getProperty("EditPersonalInfo");
		System.out.println(Title2 + "-> " + AccURL);
		
		if(AccURL.equalsIgnoreCase(EditPersonalInfo)) {
			System.out.println("working fine");
		}
		else {
			System.out.println("error");
			
		}
		Assert.assertEquals(AccURL, EditPersonalInfo);
			
		
	}
	
	

}
