package SRSproject.SRSproject;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.HomePage_Global;
import Pages.LoginPage;
import SRSproject.SRSproject.BasePage;
import SRSproject.SRSproject.BaseTest;
import Utils.Constants;

public class BrandLoginMultiBrandTest extends BaseTest {

	//Run  configuration_staging_pcs.properties file & configuration_staging_qps.properties file
	HomePage Hp;
	
	@Test(priority = 0)
	public void MultiBrandLoginValidation() throws InterruptedException, IOException {
		
		Hp.initializtion();
		Hp = new HomePage(driver);
		Hp.ValidLoginMultiBrand();
		Thread.sleep(5000);
		Hp.printBranchList();
		Thread.sleep(5000);

	

	}
	
	@Test(priority = 0)
	public void MultiBrandChangeValidation() throws Exception {
		
		Hp = new HomePage(driver);
		Hp.ValidLoginMultiBrand();
		Thread.sleep(5000);
		Hp.confirmChangeBranch();
		
		String  errormsge = Hp.confirmpopupmsge();
		Assert.assertEquals(errormsge, Constants.ConfirmPopup);
		System.out.println(errormsge);
		Thread.sleep(5000);
		
	
	}

}
