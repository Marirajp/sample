package SRSproject.LoginTests;

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

public class BrandLoginMultiBrandChangeTest extends BaseTest {
//Run  configuration_staging.properties file
	// Run configuration_staging_pcs.properties file &
	// configuration_staging_qps.properties file
	HomePage Hp;

	@Test(priority = 0)
	public void MultiBrandChangeValidation() throws InterruptedException {

		Hp = new HomePage(driver);
		Hp.ValidLoginMultiBrand();
		Thread.sleep(5000);
		Hp.confirmChangeBranch();
		Thread.sleep(5000);
		

	}
}
