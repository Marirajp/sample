package SRSproject.SRSproject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;

public class ChangeBranch_shipto_Test  extends BaseTest 

{
	
	HomePage Hp ;
	@Test(priority=1,description="Changing Shipto")
	public void Change_Shito_Validation() throws InterruptedException, IOException 
	{
		BasePage.initializtion();
		Thread.sleep(10000);
		
		Hp=  new HomePage(driver);
		
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		Thread.sleep(8000);
		
		String shipto =Hp.ChangeShipTo();
		Assert.assertEquals(shipto,prop.getProperty("Shipto"));

}
	
@Test(priority=2, description="Changing Branch")
	    public void ChangeBranch_Validation() throws Exception 
	    {
	Thread.sleep(10000);
	//LoginPage Lp = new LoginPage(driver);
	//Lp.ValidLogin();
	
	String Yourbranch =Hp.ChangeBranch();
	Assert.assertEquals(Yourbranch,prop.getProperty("Branch3"));
		driver.close();
	     }
}
