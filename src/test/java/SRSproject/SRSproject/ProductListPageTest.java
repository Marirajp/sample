package SRSproject.SRSproject;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

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
import Pages.ProductDetailPage;
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
		
		driver.close();
		
	}
	
	@Test(priority=2, description= "Adding Item to Cart")
	public void AddToCart_Validation() throws Exception 
	{
		BasePage.initializtion();
		Thread.sleep(8000);
		
		
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
	

@Test(priority=3, description= "Validating Recently viewed is  List in PLP")
	public void Recently_viewedItems_validation() throws Exception 
	{
		Thread.sleep(7000);
		HomePage hp= new HomePage(driver);
		
		
		hp.SearchByKeyword();
		Thread.sleep(10000);
		
	
	
	plp.GuestUser_ClickItem();
	Thread.sleep(3000);
	driver.navigate().back();
	Thread.sleep(5000);
	HomePage	Hp = new HomePage(driver);
	ProductDetailPage	pdp = new ProductDetailPage(driver);
	Hp.BrandSelection();
	System.out.print(plp.Recently_Viewed().getText());
	plp.First_Recently_Viewed().click();
	String pdp_page_spec= pdp.Spec_PDP_Title().getText();
	Assert.assertEquals(pdp_page_spec, "Specs");
	
		
				
	}

@Test(priority=4, description= "Adding Recently viewed Item to cart in PLP")
public void Recently_viewedItems_Add_validation() throws InterruptedException, IOException 
{
	driver.navigate().back();
	Thread.sleep(8000);
	plp.Add_Recently_viwed().click();
	
	String successmsg= plp.AddItem_recently_viewed();
	Assert.assertEquals(successmsg.contains(Constants.Success_Msg_Reorder), true);



}

@Test(priority=5, description= "Validating Recently viewed is  List in PLP")
public void Recently() throws InterruptedException, IOException 
{
	Thread.sleep(7000);
	HomePage hp= new HomePage(driver);
	
	
	hp.SearchByKeyword();
	Thread.sleep(10000);
	driver.close();

}

	
}
