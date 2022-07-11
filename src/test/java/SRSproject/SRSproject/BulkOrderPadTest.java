package SRSproject.SRSproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Pages.BulkOrderPage;
import Pages.LoginPage;
import Pages.QuickOrderPadPage;
import Utils.Constants;

public class BulkOrderPadTest extends BaseTest {

	BulkOrderPage Bp ;
	ArrayList<String> BulkOrderPage_List = null;

	@Test(priority=1)
	public void BulOrder_Redirection() throws InterruptedException, IOException 
	{
	
		//BasePage.initializtion();
		Thread.sleep(8000);
		
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		Thread.sleep(8000);
		Bp= new BulkOrderPage(driver);
		String BulkOrderTitle= Bp.BulkOrderPadClick();
		Assert.assertEquals(BulkOrderTitle, Constants.BulkOrderTitle);
}
	
	@Test(priority=2)
	public void AddItemtoBulkOrder_Validation() throws InterruptedException 
	{
	
		
			Thread.sleep(2000);
		
		Bp.ProductEntry();
	
		
		Reporter.log("Items added to bulk order as expected",true);
		}
		 
	

	@Test(priority=3)
	public void AddNewLineItem_LegacyNo_Validation() throws InterruptedException 
	{
	
		
		
			Thread.sleep(1000);
			
		Bp.AddNewLineItem();
		
		Reporter.log("Items added to bulk order as expected by searching by leagcy part no",true);
		}
		 

	
	@Test(priority=4)
	public void UpdateQunatity_Validation() throws InterruptedException 
	{
	
		
		
		WebElement qty_field=Bp.UpdateQuantity();
		qty_field.clear();
		qty_field.sendKeys(prop.getProperty("BulkOrder_qty"));
		Thread.sleep(1000);
		qty_field.sendKeys(Keys.ENTER);
		Reporter.log("Items added to bulk order as expected",true);
		}
		

	

		@Test(priority=5)
		public void AddAll_ItemToCart_Validation() throws InterruptedException 
		{
			
			
				Thread.sleep(1000);
				
					
		Bp.AddAllItem_TOCart().click();
		
		Reporter.log("Items added to cart",true);
			}
			
			
			@Test(priority=6)
			public void ListofItem_Validation() throws Exception 
			{
				Thread.sleep(15000);
				
				
						Bp.Fileupload();
						Thread.sleep(25000);
					ArrayList<String> List= Bp.ListOfItem();
					BulkOrderPage_List = List;
					
					System.out.println("one"+BulkOrderPage_List);
					QuickOrderPadPage qp = new QuickOrderPadPage(driver);
					
					List<String> arr = qp.ReadfileData(); 
					System.out.println("two"+arr);
					
					Assert.assertEquals(BulkOrderPage_List,arr);
					
					
			Reporter.log("Items are uploaded",true);
				}
			
			@Test(priority=7)
			public void UOM_Validation() throws InterruptedException 
			{
				
				Thread.sleep(5000);
				ArrayList<String> List= Bp.ListOfItem();
				BulkOrderPage_List = List;
				
				if (List.size()>3)
				{
					String uom1=Bp.First_Product_UOM().getText();
					
					String str1 = uom1.replaceAll("[^a-zA-Z0-9]"," "); 
					String UOM1= 	str1.replaceAll("\\d","");
					
					String Uom1=UOM1.trim().replaceAll(" +", " ");
					
					String uom2=Bp.Second_Product_UOM().getText();
					String str2 = uom2.replaceAll("[^a-zA-Z0-9]"," "); 
					String UOM2= 	str2.replaceAll("\\d","");
					
					String Uom2=UOM2.trim().replaceAll(" +", " ");
					
					
					
					 switch(Uom1)
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
				  
					  
				 
				  default: System.out.println("Call for pricing");
				}
					 
					 switch(Uom2)
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
				  
					  
				 
				  default: System.out.println("Call for pricing");
				}
					
					
				}
				else
				{
					String uom1=Bp.First_Product_UOM().getText();
					String str1 = uom1.replaceAll("[^a-zA-Z0-9]"," "); 
					String UOM1= 	str1.replaceAll("\\d","");
					
					String Uom1=UOM1.trim().replaceAll(" +", " ");
					
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
				  
					  
				 
				  default: System.out.println("Call for pricing");
				}
				}
					 
					
				}
			
			
			
			@Test(priority=8)
			public void InValid_FileUpload_Validation() throws InterruptedException 
			{
				Thread.sleep(10000);
				
				
						System.out.println(Bp.InvalidFileupload());
						
					
					
			Reporter.log("Valid Items are uploaded",true);
				}
				
			
			
			
	
	
	
	

}
