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
	public void LoginValidation() throws InterruptedException, IOException {
		BasePage.initializtion();
		Thread.sleep(3000);
		Hp = new HomePage(driver);
		Hp.ValidLogin();
		Thread.sleep(8000);
		
		String URL = driver.getCurrentUrl();
		String Title = driver.getTitle();
		System.out.println(Title + "-> " + URL);

		if (URL.equals(prop.get("Homepage_logurl"))) {
			System.out.println("The User is navigated to the Brand Website");

		} else {
			System.out.println("The User is navigated incorrectly");
		}

		
		Assert.assertEquals(URL, prop.get("Homepage_logurl"));
		Hp.confirmLogin(); 
		driver.close();

	}
	@Test(priority = 0)
	public void invalidLoginValidation() throws InterruptedException, IOException {
		Thread.sleep(3000);
		BasePage.initializtion();
		Hp = new HomePage(driver);
		Hp.InValidLogin();
		Thread.sleep(8000);
		String URL = driver.getCurrentUrl();
		String Title = driver.getTitle();
		System.out.println(Title + "-> " + URL);
		LoginPage Lp = new LoginPage(driver);
		String errorMsg = Lp.handlePopup();
		
		if(errorMsg.equals(Constants.InvalidErrormsge))  {
			System.out.println("Invalid login or password.");

		} else {
			System.out.println("Incorrect error message displayed");
		}
		Assert.assertEquals(errorMsg, Constants.InvalidErrormsge);

		driver.close();
	}
		

	
	
	@Test(priority = 1)
	public void UnApprovedLoginValidation() throws InterruptedException, IOException {
BasePage.initializtion();
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

		driver.close();
	}
	@Test(priority = 2)
	public void LoginFromPLP() throws Exception {
//		
		BasePage.initializtion();
		Thread.sleep(5000);
		for (int i = 0; i < 1; i++) {
			
		
		HomePage hp= new HomePage(driver);
		 Thread.sleep(2000);
		 hp.SearchByKeyword();

	  Thread.sleep(500);
		
		plp = new ProductListPage(driver);
		
		hp.ValidLogin();
		
		Thread.sleep(5000);
		hp.SignOut();
		driver.close();
		}
		}
	@Test(priority = 3)
	public void LoginFromPDP() throws Exception {
//		
		BasePage.initializtion();
		Thread.sleep(5000);
		for (int i = 0; i < 1; i++) {
			
		
		HomePage hp= new HomePage(driver);
		 Thread.sleep(2000);
		 hp.SearchByKeyword();
		 

	  Thread.sleep(5000);
		
	  ProductListPage	plp = new ProductListPage(driver);
		pdp=plp.GuestUser_ClickItem();
		Thread.sleep(4000);
		hp.ValidLogin();
		Thread.sleep(5000);
		hp.SignOut();
		Thread.sleep(3000);
		driver.close();
		}
	}
	@Test(priority = 5, description = "validLogin with differsites",enabled = false)
	public void UnAuthorisedLogin() throws InterruptedException, IOException {
		Thread.sleep(3000);
		BasePage.initializtion();
		Hp = new HomePage(driver);
		Hp.UnAuthorisedLogin();
		Thread.sleep(8000);
		
		
		String errorMsg = Hp.Errorpopupmsg().getText();
		System.out.println(errorMsg);
		if(errorMsg.equals(Constants.Error_Popup))  {
			System.out.println("Popup shown site redirected .");
            Hp.TPS_redirected_link().click();
            Thread.sleep(5000);
          String currentUrl = driver.getCurrentUrl(); 
         Assert.assertEquals(currentUrl,Constants.TPS_link);
         Thread.sleep(5000);
         Hp.TPS_Login();
         
         
           
		} else {
			System.out.println("Incorrect error message displayed");
		}
		Assert.assertEquals(errorMsg, Constants.Error_Popup);

		Thread.sleep(3000);
		driver.quit();
	}
	
	
}


	