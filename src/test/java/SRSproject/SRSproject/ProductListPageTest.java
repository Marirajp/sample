package SRSproject.SRSproject;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.tools.ant.taskdefs.condition.Contains;
import org.jsoup.select.Evaluator.ContainsData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductListPage;
import Pages.RegistrationForm;
import Utils.Constants;



public class ProductListPageTest extends BaseTest {
	
	ProductListPage plp;

	@Test(priority=1, description= "Register now link redirection")
	public void PLP_RegisterRedirection_GuestValidation() throws InterruptedException, IOException 
	{
		BasePage.initializtion();
		Thread.sleep(5000);
		HomePage hp= new HomePage(driver);
		 Thread.sleep(2000);
	//	hp.mouseHoverSelectCategory();
		 

		
			
			
			hp.SearchByKeyword();
			Thread.sleep(10000);


	  Thread.sleep(500);
		
		plp = new ProductListPage(driver);
		
		String title=plp.GuestUser_ClickRegister();
		Assert.assertEquals(title, prop.getProperty("Homepage_url"));
		
		
		
	}
	
	@Test(priority=2, description= "Adding Item to Cart")
	public void AddToCart_Validation() throws InterruptedException, IOException 
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


	
		
		plp = new ProductListPage(driver);
		  Thread.sleep(3000);
		
	String successmsg= plp.AddItem();
	Assert.assertEquals(successmsg.contains(Constants.Success_Msg_Reorder), true);



		
	}
}
