package SRSproject.SRSproject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.HomePage;
import Pages.InvoicePage;
import Pages.MiniCartPage;
import Pages.ProductDetailPage;
import Pages.ProductListPage;
import Pages.Reorder_Page;
import Utils.Constants;

public class Reorderpad_no_access extends BaseTest {

	
	Reorder_Page Rp;
	
	@Test(priority=1,description =  "verify the dashborad the view and edit acces has present ")
	public void ReorderPage_Redirection() throws InterruptedException, IOException 
	{
		
		Thread.sleep(2000);
	     Rp = new Reorder_Page(driver);
	     
		Rp.ReorderPadLogin_withoutview_Edit_access();
		
		
		Thread.sleep(2000);
		HomePage Hp = new HomePage(driver);
		
		WebElement vieworder = Hp.vieworder();
		System.out.println(vieworder.getText());
		Assert.assertEquals(vieworder.getText(), "❌");
		WebElement editorder = Hp.editorder();
		System.out.println(editorder.getText());
		Assert.assertEquals(editorder.getText(), "❌");
		
		Thread.sleep(2000);
		Hp.MyAccount_Hover();
		
		boolean displayed = Hp.ReorderHover().isSelected();
		Assert.assertFalse(displayed);
}
	@Test(priority = 2,description =  "verify  to Reorder Pad option is enabled in  Cart")
	 public void Add_to_Reorder_Pad_from_cartPage() throws InterruptedException {
		MiniCartPage Mp= new MiniCartPage(driver);
		Mp.MiniCart().click();
		Thread.sleep(8000);
		Mp.ClickViewCart();
		 
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
				Rp.AddReorderpad().isEnabled();
				Thread.sleep(2000);
				String	text = driver.findElement(By.xpath("//div[@id='swal2-content']")).getText();
				
				Assert.assertEquals("Access Denied. You don't have access.",text);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='swal2-close']")).click();
				System.out.println(text);
				System.out.println("Element is present");
			} catch (Exception e) {
				System.out.println("Element is not  present");
			}
				
	 }
	 
	 @Test(priority = 6,description =  "Add to Reorder Pad option on PDP")
	 public void Add_Product_to_ReorderPad_from_PDP() throws Exception {
		
		 HomePage hp= new HomePage(driver);
		 Thread.sleep(5000);
			hp.SearchByKeyword();
			ProductDetailPage	pdp = new ProductDetailPage(driver);
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
			Assert.assertFalse(Ip.Reorderpad().isSelected());
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
