package SRSproject.SRSproject;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.HomePage_Global;
import Pages.LoginPage;
import SRSproject.SRSproject.BasePage;
import SRSproject.SRSproject.BaseTest;

public class ApprovedLoginTest extends BaseTest {

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
		Assert.assertEquals(URL, prop.get("Homepage_url"));
		Hp.confirmLogin(); 
		// assertTrue(FIS_URL.equals(exp1) || FIS_URL.equals(exp2));

	}}
	