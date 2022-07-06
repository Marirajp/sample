package SRSproject.SRSproject;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

import Pages.CartPage;
import Pages.HomePage;
import Pages.InvoicePage;
import Pages.LoginPage;
import Pages.OpenOrdersPage;
import Pages.ProductDetailPage;
import Pages.ProductListPage;
import Pages.QuickOrderPadPage;
import Pages.Reorder_Page;
import Utils.Constants;

public class ReorderpadEditaccesrightsTest extends BaseTest {
	ProductDetailPage pdp;
	Reorder_Page Rp;
	ArrayList<String> Reorder_list=null;
	
	@Test(priority=1,description =  "verify the dashborad the view and edit acces has present ")
	public void ReorderPage_Redirection() throws InterruptedException, IOException 
	{
		
		Thread.sleep(2000);
	     Rp = new Reorder_Page(driver);
	     
		Rp.ReorderPadLogin_usingview_and_edit_access();
		
		
		Thread.sleep(2000);
		HomePage Hp = new HomePage(driver);
		
		WebElement vieworder = Hp.vieworder();
		System.out.println(vieworder.getText());
		Assert.assertEquals(vieworder.getText(), "✔");
		WebElement editorder = Hp.editorder();
		System.out.println(editorder.getText());
		Assert.assertEquals(editorder.getText(), "✔");
		
		Thread.sleep(2000);
		Hp.MyAccount_Hover();
		Hp.Reorder_Hover();
		
	
	 String	Reorder_Title= driver.getTitle();
		Assert.assertEquals(Reorder_Title,Constants.Reorder_PageTitle);
		

}
	
	 @Test(priority=2)
		public void UploadFile_Redirection_add_a_product_using_search() throws InterruptedException, CsvValidationException, IOException 
		{
			Rp= new Reorder_Page(driver);
			Rp.Fileupload();
			Thread.sleep(20000);
		ArrayList<String>List = Rp.GetLineItme();
		Reorder_list=List;
		
		QuickOrderPadPage qp = new QuickOrderPadPage(driver);
		
		List<String> arr = qp.ReadfileData(); 
		
		
		Assert.assertEquals(Reorder_list,arr);
		Rp.EnterProduct();

	}
	 
	 @Test(priority=3,description = "verify  Delete button is enabled and Save the Reorderpad ")
		public void SaveAnReorderList_Validation() throws Exception 
		{
			Rp= new Reorder_Page(driver);
			Thread.sleep(8000);
			Assert.assertTrue(Rp.Deletebutton().isDisplayed());
			Rp.Productdelete();
			Rp.ReorderNameField().sendKeys(prop.getProperty("Reorder_Name"));
			Thread.sleep(400);
			Rp.Save_button().click();
			Thread.sleep(3000);
			Rp.Proceed_Btn();
			
	}
	 
	 @Test(priority=4)
		public void View_Validation_Reorderpad_to_cart() throws Exception 
		{
			
			Thread.sleep(5000);
			Assert.assertTrue(Rp.Acesstoggle().isEnabled());
			Thread.sleep(2000);
			Rp.View_Click();
			Thread.sleep(5000);
			Rp.Add_All_Items().click();
			
			Thread.sleep(20000);
		
			String Success_msg= Rp.Items_addtocart_msg();
			Thread.sleep(5000);
			Assert.assertEquals(Success_msg.contains("successfully added to your Cart"), true);
	        System.out.println(Success_msg);

        
			
			
		}
	 
	 @Test(priority = 5,description =  "Add to Reorder Pad option on Cart")
	 public void Add_to_Reorder_Pad_in_cartPage() throws InterruptedException {
		 Rp = new Reorder_Page(driver);
		 Thread.sleep(2000);
		 Rp.ViewCart().click();
		 
		CartPage Cp = new CartPage(driver);
			Thread.sleep(9000);
			Cp.ReOrderSelection1();
			Thread.sleep(8000);
			String msg= Cp.Message();
			System.out.println(msg);
		String 	Total_items_in_cart = msg.substring(14, 16);
			System.out.println("Total_Itemsin Cart" +Total_items_in_cart);

			String ReorderItemCount=msg.replaceAll("[^\\d]", "");

			
			 Cp.ClickAddToReorder();
			
			 System.out.println(msg);
				String ReorderItemAdded=msg.replaceAll("[^\\d]", "");
				
			
				 if(ReorderItemCount.equals(ReorderItemAdded))
				    {
				    	Assert.assertTrue(true);
				    	Reporter.log("Items are added from cart to Reorder List selected" , true);
				    	Thread.sleep(3000);
				    	Cp.KeepShopping().click();
				    	

				    	
				    	
				    }
				    else
				    {
				    	Reporter.log(" Not All Items are added from cart to Reorder List selected" , true);
						   
				    }
		 
				 
					
	 }
	
	 @Test(priority = 6,description =  "Add to Reorder Pad option on PLP")
	 public void Add_Product_to_ReorderPad_from_PLP() throws InterruptedException {
		
		 HomePage hp= new HomePage(driver);
		 Thread.sleep(3000);
			hp.mouseHoverSelectCategory();
			Thread.sleep(10000);
			Rp.AddReorderpad();
			Thread.sleep(3000);
			Rp.Add_to_reorderpad();
			Thread.sleep(2000);
			Rp.KeepShopping();
	 }
	 @Test(priority = 7,description =  "Add to Reorder Pad option on PDP")
	 public void Add_Product_to_ReorderPad_from_PDP() throws Exception {
		
		 HomePage hp= new HomePage(driver);
		 Thread.sleep(5000);
			hp.SearchByKeyword();
			pdp = new ProductDetailPage(driver);
			ProductListPage	plp = new ProductListPage(driver);
			pdp=plp.GuestUser_ClickItem();
			Thread.sleep(3000);
		Rp.AddReorderpadpdp();
		Thread.sleep(3000);
		Rp.pdpReorderpad();
			
			Thread.sleep(2000);
			Rp.KeepShoppingpdp();
			
	 }
	 @Test(priority = 8,description =  "Add to Reorder Pad option on Invoice ")
	 public void Add_Product_to_ReorderPad_from_Invoice() throws Exception {
		
		 HomePage hp= new HomePage(driver);
		 Thread.sleep(5000);
			
		 hp.Account_Hover();
			Thread.sleep(2000);
			hp.Invoice_History();
			
			InvoicePage	Ip = new InvoicePage(driver);
			
			String title = driver.getTitle();
			Assert.assertEquals(title, Constants.Invoice_Title);
			Ip.Invoicenumber();
		Thread.sleep(3000);
			Ip.Reorderpad();
			Thread.sleep(3000);
			Ip.AddTOReorderPad();
				
				Thread.sleep(2000);
				Ip.keepshoping();
			
			
			
	 }
	 
	 @Test(priority = 9,description =  "Add to Reorder Pad option on Openorder")
	 public void Add_Product_to_ReorderPad_from_Open_order() throws Exception {
		
		 HomePage hp= new HomePage(driver);
		 Thread.sleep(5000);
			
		 hp.Account_Hover();
			Thread.sleep(2000);
			hp.OpenOrder_Hover();			
			
			 String Title=	 driver.getTitle();
			 Assert.assertEquals(Title,Constants.OpenOrder_Title);
			
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//td[@class='column column--orderNumber'])[1]")).click();
			OpenOrdersPage op = new OpenOrdersPage(driver);
			op.Reorderpadclk();
			Thread.sleep(3000);
			
			InvoicePage Ip = new InvoicePage(driver);
			
			Ip.AddTOReorderPad();
				
				Thread.sleep(2000);
				Ip.keepshoping();
		} catch (Exception e) {
			System.out.println( "open orderpad is empty");
			
		}
			
			
			
	 }
	 
}
