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

import Pages.BulkOrderPage;
import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MiniCartPage;
import Pages.ProductListPage;
import Pages.QuickOrderPadPage;
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
	//	BasePage.initializtion();
		
		
		Thread.sleep(8000);
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		Thread.sleep(5000);
		//
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
		
	}
	@Test(priority=2, description=  "Date Picker validation and other basic info updation ")
	public void Date_Validation() throws InterruptedException 
	{
		COp =  new CheckoutPage(driver);
		Thread.sleep(3000);
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
		
		Thread.sleep(30000);
		

		List<WebElement> list2=COp.getCheckout_ItemName();
		ArrayList<String> a2= new ArrayList<String>();
		for (WebElement option:list2)
		{
			String text= option.getText();
			
			a2.add(text);
		}
		int items= a2.size();
		System.out.print( "Total No of Items"+total_No_items);
		 Assert.assertEquals(items,  total_No_items);
		// driver.close();	}
}
	
	@Test(priority=4,  description= "UOM validation")
	public void UOM_Validation() throws InterruptedException 
	{
		Thread.sleep(7000);
		
		String uom=COp.UOM().getText();
		String str2 = uom.replaceAll("[^a-zA-Z0-9]"," "); 
		String UOM= 	str2.replaceAll("\\d","");
		
		String Uom=UOM.trim().replaceAll(" +", " ");
		
		
		
		 switch(Uom)
		 {
		  case "EA":
			  System.out.println(Uom);
			  Reporter.log("UOM EA is Present in PLP", true);
			  
			  
	      break;
	  case "FT":
		  System.out.println(Uom);
		  Reporter.log("UOM FT is Present in PLP", true);
		 
		 
	  break;
	  case "RL":
		  System.out.println(Uom);
		  Reporter.log("UOM RL is Present in PLP", true);
		 
	  break;
	  
		  
	 
	  default: Uom= "Call for pricing";
	  Assert.assertNotSame(Uom,"Call for pricing" );
	}


		
}

}
