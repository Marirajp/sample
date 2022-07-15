package SRSproject.SRSproject;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.tools.ant.taskdefs.condition.Contains;
import org.jsoup.select.Evaluator.ContainsData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductListPage;
import Pages.ProductDetailPage;
import Pages.RegistrationForm;
import Utils.Constants;



public class ProductDetailPageTest extends BaseTest {
	
ProductDetailPage pdp;

	@Test(priority=1, description= "Register now link redirection")
	public void PDP_RegisterRedirection_GuestValidation() throws Exception 
	{
	//BasePage.initializtion();
	Thread.sleep(2000);
	
	
	HomePage hp= new HomePage(driver);

	 
	 hp.SearchByKeyword();
		Thread.sleep(2000);
		
		
	ProductListPage	plp = new ProductListPage(driver);
	pdp=plp.GuestUser_ClickItem();
//	Thread.sleep(2000);

//pdp = new ProductDetailPage(driver);
String title=pdp. Guest_clickProductRegister();
Assert.assertEquals(title, prop.getProperty("Homepage_url"));
Thread.sleep(500);
				
	}
	
	@Test(priority=2, description= "Adding Item to Cart")
	public void AddingItemToCart() throws Exception 
	{
		//BasePage.initializtion();
		driver.navigate().back();
		Thread.sleep(3000);
		
		 

			LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		Thread.sleep(3000);
		
		HomePage hp= new HomePage(driver);
		
		
		hp.SearchByKeyword();
		Thread.sleep(2000);
		
		
	ProductListPage	plp = new ProductListPage(driver);
	pdp=plp.GuestUser_ClickItem();
	Thread.sleep(1000);
	

String successmsg= pdp.AddingItem();
Assert.assertEquals(successmsg, Constants.Success_Msg_Reorder);
 

	
	
		
				
	}
	
	@Test(priority=3, description= "validating Recently viewed Items is in PDP")
	public void Recently_viewedItems_validation() throws Exception 
	{
		Thread.sleep(4000);
		HomePage hp= new HomePage(driver);
		
		
		hp.SearchByKeyword();
		Thread.sleep(2000);
		
		
	ProductListPage	plp = new ProductListPage(driver);
	pdp=plp.GuestUser_ClickItem();
	Thread.sleep(4000);
	


System.out.println(pdp.Recently_viwed_Title());

String tile = pdp.Recently_viwed_Title();
//pdp.Recently_viwed_Item().click();

Assert.assertEquals(tile,"Recently Viewed");
	
	
		
				
	}
	/*@Test(priority=4, description= "validating Recently viewed Items is in PDP")
	public void Recently_viewed_Add_validation() throws InterruptedException, IOException 
	{
		Thread.sleep(8000);
		pdp.Recently_viwed_add().click();
		Thread.sleep(500);
		String successmsg= pdp.Adding_Recentlview_Sucssmsg();
		Assert.assertEquals(successmsg, Constants.Success_Msg_Reorder);
	} 
	*/
	@Test(priority=5, description= "validating Related Products Items is in PDP")
	public void RelatedProducts_validation() throws InterruptedException, IOException 
	{
		try
		{
		Thread.sleep(2000);
	pdp.SearchByKeyword();
		Thread.sleep(3000);
		
		pdp.RelatedProducts();
	String	tile = pdp.RelatedProductsTitle();
		System.out.println(tile);
		Assert.assertEquals(tile,"Related Items");
		}
		catch (Exception e) {
			System.out.println("No Related Products for this Product"+ e);
		}
	
		
	} 
	
	@Test(priority=6, description= "validating Related Products Adding to Cart")
	public void Adding_RelatedProduct_validation() throws InterruptedException, IOException 
	{
		Thread.sleep(3000);
		try
		{
		pdp.Related_add_tocart().click();
		Thread.sleep(1000);
		String successmsg= pdp.Adding_Recentlview_Sucssmsg();
		Assert.assertEquals(successmsg, Constants.Success_Msg_Reorder);
		}
		catch (Exception e) {
			System.out.println("No Related Products for this Product"+ e);
		}
	
	
		
	} 
	
	@Test(priority=7, description= "Validating UOM in PDP")
	public void UOM_Validation() throws Exception 
	{
		Thread.sleep(4000);
		HomePage hp= new HomePage(driver);
		
		
		hp.SearchByKeyword();
		
		Thread.sleep(3000);
		ProductListPage	plp = new ProductListPage(driver);
		pdp=plp.GuestUser_ClickItem();
		Thread.sleep(2000);
		String uom = pdp.Uom();
		String uom1=uom.replaceAll("[^a-zA-Z0-9]", "");
		String price = pdp.Price();
		
		if (!price.isEmpty())
			
			
				{
			System.out.println(price);
		
		 switch(uom1)
		 {
		  case "EA":
			  System.out.println(uom1);
			  Reporter.log("UOM EA is Present in PLP", true);
			  
			  
	      break;
	  case "FT":
		  System.out.println(uom1);
		  Reporter.log("UOM FT is Present in PLP", true);
		 
		 
	  break;
	  case "RL":
		  System.out.println(uom1);
		  Reporter.log("UOM RL is Present in PLP", true);
		 
	  break;
	  
		  
	 
	  default: uom1= "Call for pricing";
	  Assert.assertNotSame(uom1,"Call for pricing" );
	}
				}
		 else
		 {
			 Reporter.log("UOM is not displayed as expected", true);
		 }
		
		
	}

}