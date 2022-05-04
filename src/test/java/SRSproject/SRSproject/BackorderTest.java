package SRSproject.SRSproject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductDetailPage;
import Pages.ProductListPage;
import Utils.Constants;

public class BackorderTest extends BasePage {
	HomePage Hp;
	ProductDetailPage pdp;
	
	@Test(priority=1, description= "Adding Item to Cart with correct qty")
	public void AddingItemToCart() throws InterruptedException, IOException 
	{
		BasePage.initializtion();
		Thread.sleep(8000);
		
		
		Thread.sleep(1000);
			LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		Thread.sleep(8000);
		
		HomePage hp= new HomePage(driver);
		
		
		hp.SearchByKeyword();
		Thread.sleep(10000);
		
		
	ProductListPage	plp = new ProductListPage(driver);
	pdp=plp.GuestUser_ClickItem();
	Thread.sleep(4000);
	

String successmsg= pdp.AddingItem();
Assert.assertEquals(successmsg, Constants.Success_Msg_Reorder);


	
	
		
				
	}
}


