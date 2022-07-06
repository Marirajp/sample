package SRSproject.SRSproject;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.opencsv.exceptions.CsvValidationException;
import Pages.CartPage;
import Pages.HomePage;
import Pages.InvoicePage;
import Pages.ProductDetailPage;
import Pages.ProductListPage;
import Pages.Reorder_Page;
import Utils.Constants;

public class ReorderPadViewAccessrights extends BaseTest{
	ProductDetailPage pdp;
	Reorder_Page Rp;
	ArrayList<String> Reorder_list=null;
	
	@Test(priority=1,description =  "verify the dashborad the view and edit acces has present ")
	public void ReorderPage_Redirection() throws InterruptedException, IOException 
	{
		
		Thread.sleep(2000);
	     Rp = new Reorder_Page(driver);
	     
		Rp.ReorderPadLogin_usingview_access();
		
		
		Thread.sleep(2000);
		HomePage Hp = new HomePage(driver);
		
		WebElement vieworder = Hp.vieworder();
		System.out.println("View orderPad is :"+vieworder.getText());
		Assert.assertEquals(vieworder.getText(), "✔");
		WebElement editorder = Hp.editorder();
		System.out.println(editorder.getText());
		Assert.assertEquals(editorder.getText(), "❌");
		
		Thread.sleep(2000);
		Hp.MyAccount_Hover();
		Hp.Reorder_Hover();
		
	
	 String	Reorder_Title= driver.getTitle();
		Assert.assertEquals(Reorder_Title,Constants.Reorder_PageTitle);
		

}
	@Test(priority=2,description = "Verify UploadCSV and Share acess toggle is enabled or not")
	public void UploadCSV_and_share_acess_is_enabled_or_not()throws InterruptedException, CsvValidationException, IOException 
	{
		Rp= new Reorder_Page(driver);
		
	try {
		boolean uploadcsvdisplayed = Rp.uploadbtn().isEnabled();
		System.out.println(uploadcsvdisplayed);
		System.out.println(Rp.Acesstoggle().isEnabled());
	
	} catch (Exception e) {
		 System.out.println("Element not present");
	}	
	
		
	
} 
	
	@Test(priority=3,description = "Verify Delete btn and search product is enabled in reorderpad and adding all items to cart from Reorderpad")
public void View_Validation_add_ReorderpadProducts_to_cart() throws Exception 
{
		Thread.sleep(8000);
		Rp.View_Click();
		try {
			
			
			
			Assert.assertTrue(Rp.Deletebutton().isDisplayed());
			Assert.assertTrue(Rp.ProductInput().isDisplayed());
			
			System.out.println("Element is present");
		} catch (Exception e) {
			
			System.out.println("Element is not present");
			Thread.sleep(5000);
			Rp.Add_All_Items().click();
			
			Thread.sleep(18000);

			String Success_msg= Rp.Items_addtocart_msg();
			Thread.sleep(5000);
			Assert.assertEquals(Success_msg.contains("successfully added to your Cart"), true);
		    System.out.println(Success_msg);

		    
			
		}	
	
}
	

	 @Test(priority = 4,description =  "verify  to Reorder Pad option is enabled in  Cart")
	 public void Add_to_Reorder_Pad_from_cartPage() throws InterruptedException {
		 Rp = new Reorder_Page(driver);
		 Thread.sleep(2000);
		 Rp.ViewCart().click();
		 
		CartPage Cp = new CartPage(driver);
			Thread.sleep(9000);
			try {
				Cp.ReorderpadList().isDisplayed(); 
			} catch (Exception e) {
			System.out.println("Element is not present");
			}
		
			
	 }
	 

	 @Test(priority = 5,description =  "Verify Add to Reorder Pad option is enabled on PLP")
	 public void Add_Product_to_ReorderPad_from_PLP() throws InterruptedException {
		
		 HomePage hp= new HomePage(driver);
		 Thread.sleep(3000);
			hp.mouseHoverSelectCategory();
			Thread.sleep(10000);
			try {
				Rp.AddReorderpad().isDisplayed();
				Thread.sleep(2000);
				String	text = driver.findElement(By.xpath("//div[@id='swal2-content']")).getText();
				
				Assert.assertEquals("Access Denied. You don't have access.",text);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='swal2-close']")).click();
				System.out.println("PLP "+text);
				System.out.println("PLP Element is present");
			} catch (Exception e) {
				System.out.println("PLP Element is not  present");
			}
				
	 }
	 
	 @Test(priority = 6,description =  "Add to Reorder Pad option on PDP")
	 public void Add_Product_to_ReorderPad_from_PDP() throws Exception {
		
		 HomePage hp= new HomePage(driver);
		 Thread.sleep(5000);
			hp.SearchByKeyword();
			pdp = new ProductDetailPage(driver);
			ProductListPage	plp = new ProductListPage(driver);
			pdp=plp.GuestUser_ClickItem();
			Thread.sleep(3000);
			
    if (Rp.addreorderpadPdpenble().isEnabled()) {
    	 Rp.AddReorderpadpdp();
    	  Thread.sleep(5000);
			String	text = driver.findElement(By.xpath("//div[@id='swal2-content']")).getText();
			
			Assert.assertEquals("Access Denied. You don't have access.",text);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@class='swal2-close']")).click();
			System.out.println("PDP"+text);
			System.out.println("PDP Element is present");
    	  
	} else {
		
		System.out.println("PDP Element is not Present");
	}
	 }
	 @Test(priority = 7,description =  "Add to Reorder Pad option on Invoice ")
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
	
			Ip.Reorderpad1().isSelected();
			Assert.assertFalse(Ip.Reorderpad1().isSelected());
			System.out.println("Reorderpad is not present in Invoice");
		
	
		}
			
			
			
			
			
	  
	 @Test(priority = 8,description =  "Add to Reorder Pad option on Openorder")
	 public void Add_Product_to_ReorderPad_from_Open_order() throws Exception {
		
		 HomePage hp= new HomePage(driver);
		 Thread.sleep(5000);
			
		 hp.Account_Hover();
			Thread.sleep(2000);
			hp.OpenOrder_Hover();			
			
			 String Title=	 driver.getTitle();
			 Assert.assertEquals(Title,Constants.OpenOrder_Title);
			
		try {
			driver.findElement(By.xpath("(//td[@class='column column--orderNumber'])[1]")).click();
			
		} catch (Exception e) {
			System.out.println( "open orderpad is empty");
			System.out.println("Reorderpad is not present in Openorderpad");
			
		}
			
			
			
	 }
	
}
