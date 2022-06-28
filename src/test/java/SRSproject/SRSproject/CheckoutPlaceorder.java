package SRSproject.SRSproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.print.attribute.standard.Copies;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Pages.BulkOrderPage;
import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MiniCartPage;
import Pages.ProductDetailPage;
import Pages.ProductListPage;
import Utils.Constants;

public class CheckoutPlaceorder extends BasePage {
	HomePage Hp;
	BulkOrderPage Bp ;

	CartPage Cp;
	
	String  noofItems1;
	String Pricetotal ;
	
	@Test(priority=1, description= "Adding Item to Cart with correct qty")
	public void AddingItemToCart() throws Exception 
	{
		BasePage.initializtion();
		Thread.sleep(8000);
		
		
		Thread.sleep(1000);
			LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		Thread.sleep(8000);
		
		HomePage hp= new HomePage(driver);
		
		Thread.sleep(5000);
		
		Bp= new BulkOrderPage(driver);
		Cp = new CartPage(driver);
		MiniCartPage Mp= new MiniCartPage(driver);
		String BulkOrderTitle= Bp.BulkOrderPadClick();
		Assert.assertEquals(BulkOrderTitle, Constants.BulkOrderTitle);
		Bp.Fileupload();
		Thread.sleep(1000);
		waitUntilElementVisibility(Bp. Addallitems());
		Bp.Addallitems().click();
		Thread.sleep(8000);
		Mp.MiniCart().click();
		Thread.sleep(8000);
		Mp.ClickViewCart();
//		Thread.sleep(2000);
//		Cp.clickcart();
////		Cp.clickcart().click();
		Thread.sleep(1000);
//		Mp.ViewCart();
		String noofItems	= Cp.NoofItems();
		 noofItems1 = noofItems.substring(0, 2);
		System.out.println("No of products in cart page :"+ noofItems1);
		
	}

	@Test(priority=2, description= "Check the Item are added Cart to Checkout verify ")
	public void CheckoutValidation() throws Exception 
	{
	Thread.sleep(1000);
	
	CartPage Cp= new CartPage(driver);
	 Thread.sleep(1000);
	
	Cp.clickOnProceedToCheckout();
	String title= driver.getTitle();
	Assert.assertEquals(title, Constants.CheckoutPageTitle);
	Reporter.log(title, true);
	
	CheckoutPageTest Ch = new CheckoutPageTest();
	
	Ch.Date_Validation();
	CheckoutPage COp= new CheckoutPage(driver) ;
	COp.NextStep1().click();
	COp.ShipVia();
	Thread.sleep(1000);
	COp.NextStepp();	
	
	Thread.sleep(8000);
	List<WebElement> list2=COp.getCheckout_ItemName();
	Integer  sizes = list2.size();
	String Cartqty = sizes.toString();
	System.out.println("No of products in Chekout page : "+Cartqty);
	System.out.println("No of products in cart page : "+ noofItems1);
		if(noofItems1.equals (Cartqty))
		
		{
			System.out.println("No of Item in Cart Page"+ noofItems1);
			System.out.println("Item in Checkout Page"+ Cartqty);
			
		System.out.println("The products in cart and checkout added Sucessfully ");
		
	}else
	{
		System.out.println("Item in Cart Page"+ noofItems1);
		System.out.println("Item in Checkout Page"+ Cartqty);
		System.out.println("The products in cart and checkout Not added Sucessfully ");
	
	
	}
		COp.scroll();
		Thread.sleep(16000);
		COp.Terms_Check();
		Thread.sleep(2000);
//		COp.Holdorder();
//	
//		Thread.sleep(5000);
//		System.out.println(driver.getTitle());
//		String PricefromOpenorderpage = driver.findElement(By.xpath("//td[contains(@class,'column column--orderTotal')]")).getText();
//		PricefromOpenorderpage.equalsIgnoreCase(Pricetotal);
//		
	COp.PlaceOrder();
	Thread.sleep(3000);
	String Sucessmsge = driver.findElement(By.xpath("//p[text()='Your order has been submitted to your selected branch. ']")).getText();
		System.out.println(Sucessmsge);
		Assert.assertEquals(prop.getProperty(Sucessmsge), Sucessmsge);
		Thread.sleep(10000);
		System.out.println(driver.getTitle());
		String SucesspagePrice = driver.findElement(By.xpath("(//span[@class='price'])[3]")).getText();
		SucesspagePrice.equalsIgnoreCase(Pricetotal);
		
		
		
		
	
	}
	
	@Test(priority = 3,enabled = false)
	public void placeorder_holdorder() throws Exception {
		CheckoutPage COp= new CheckoutPage(driver) ;
		COp.checkbox();
		COp.Holdorder();
		System.out.println(driver.getTitle());
		
	}
	
@org.testng.annotations.AfterClass(enabled = false)
public void close() {
	driver.quit();
}

}

	
	


	
	
		
				




