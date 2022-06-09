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

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MiniCartPage;
import Pages.ProductListPage;
import Pages.ProductDetailPage;
import Pages.RegistrationForm;
import Utils.Constants;

public class CheckoutPageTest extends BaseTest {
	
	CheckoutPage COp;
	ArrayList<String> MyList = null;
	int total_No_items;
	
	
	@Test(priority=1, description= "Cart to Checkout Redirection ")
	public void CartToCheckout_Validation() throws InterruptedException, IOException 
	{
		BasePage.initializtion();
		Thread.sleep(8000);
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		Thread.sleep(9000);
		MiniCartPage Mp= new MiniCartPage(driver);
		Mp.MiniCart().click();
		Mp.ClickViewCart();
		

	Thread.sleep(1000);
	
		CartPage Cp= new CartPage(driver);
		ArrayList<String> a1= Cp.getItemName1();
		// System.out.println(a1);
		 MyList=a1;
		 String total_items=Cp.TotalNo_Items();
		 int number = Integer.parseInt(total_items);
		 total_No_items=number;
		// System.out.println(MyList);
		 Thread.sleep(1000);
		
		Cp.clickOnProceedToCheckout();
		String title= driver.getTitle();
		Assert.assertEquals(title, Constants.CheckoutPageTitle);
		Reporter.log(title, true);
		
	}
	
	@Test(priority=2, description=  "Date Picker validation and other basic info updation ")
	public void Date_Validation() throws InterruptedException 
	{
		COp =  new CheckoutPage(driver);
		Thread.sleep(2000);
		COp.Shipto_Selection();
		
		COp.Branch_Selection();
		
	
		COp.PO_Number();
		COp.Ordernotes();
		COp.RequestedDate();
		
		
	
	
		COp.clickOnCalendarsNextBtn();
		List<WebElement> dateList=COp.clickOnSelectDate();
		int count=dateList.size();
		for(int i=0;i<count;i++)
		{
			String text=dateList.get(i).getText();
			if(text.equals(prop.getProperty("StartDate")))
			{
			  dateList.get(i).click();
			  break;
			}
			if(dateList.get(i).isSelected())
			{
				Assert.assertTrue(false, "the date is not selected");
			}
		}
		
	}


	@Test(priority=3, description = "Product Listing in checkout as per the list in cart")
	public void ProductList_Validation() throws InterruptedException 
	{
		COp.NextStep1().click();
		COp.ShipVia();
		Thread.sleep(1000);
		
		
		//COp =  new CheckoutPage(driver);
		/*COp.Address1();
		COp.City();
		COp.state();
		
		COp.Zipcode();
		COp.phone();*/
		COp.NextStepp();
		
		CartPage Cp= new CartPage(driver);
		
		//ArrayList<String> a1= Cp.getItemName1();
		// System.out.println(a1);
		
		
		

		List<WebElement> list2=COp.getCheckout_ItemName();
		ArrayList<String> a2= new ArrayList<String>();
		for (WebElement option:list2)
		{
			String text= option.getText();
			
			a2.add(text);
		}
		int items= a2.size();
		System.out.print( total_No_items);
		 Assert.assertEquals(items,  total_No_items);
		driver.close();
		/*if(MyList.equals(a2))
		{
			System.out.println("Item in Cart Page"+ MyList);
			System.out.println("Item in Checkout Page"+ a2);
			Reporter.log("Items in Cart are all added to Checkout Page successfully",true);
		}
		else
		{
			System.out.println("Item in Cart Page"+ MyList);
			System.out.println("Item in Checkout Page"+ a2);
			Reporter.log("Not all item from cart are added to checkout page ",true);
		}
		*/
		 }
	
	/*@Test(priority=4,  description= "Placing Order validation")
	public void OrderPlacement_Validation() throws InterruptedException 
	{
		COp.scroll();
		Thread.sleep(500);
		COp.Terms_Check().click();
	//COp.PlaceOrder().click();;
		
	//	System.out.println(driver.getTitle());
		
}*/
}
