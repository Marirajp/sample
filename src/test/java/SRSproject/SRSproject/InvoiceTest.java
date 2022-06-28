package SRSproject.SRSproject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.InvoicePage;
import Pages.OpenOrdersPage;
import Utils.Constants;

public class InvoiceTest extends BaseTest {
	
	HomePage Hp ;
	InvoicePage Ip = new InvoicePage(driver);
	private String substring;;
	String substring2 = null ;
	 int Invoice_count1 = 0;
	 int Invoice_count2 = 0;
	@Test(priority = 1)
	public void invoices() throws Exception {
		
		Hp = new HomePage(driver);
		Hp.ValidLogin();
		Thread.sleep(8000);
		Hp.Account_Hover();
		Thread.sleep(2000);
		Hp.Invoice_History();
		
		Ip = new InvoicePage(driver);
		
//		System.out.println(Ip.PagenationSize());
//		System.out.println(Ip.NoofLintItems());
		
		String title = driver.getTitle();
		Assert.assertEquals(title, Constants.Invoice_Title);
		
		
	}	
		
	@Test(priority = 2,description = "validate if we are give the dropdown value as 20 how many pages shown")
	public void DropdownPagesSelected () throws Exception {
	
		Ip.dropdownorder("20");
		try {
			System.out.println(Ip.PagenationSize());
			System.out.println(Ip.NoofLintItems());
			System.out.println("No of rows and Colums:  "+  Ip.ListOfItem().size());
			
		} catch (Exception e) {
			System.out.println("Only a single page ");
		
			
		}
		
	
	}
	
	
	@Test(priority = 3, description =  "Search using Invoice NO & PO  and Validate the No found after search results ")	
	public void InvoiceSearchUsingInvoice_No_Po_No() throws Exception {	
		Ip.InvoiceClk();
		Thread.sleep(4000);
     WebElement invoiceSearch = Ip.InvoiceSearch();
     String invoicenumberSearch = Ip.InvoicenumberSearch();
     invoiceSearch.sendKeys(invoicenumberSearch);
     
     Ip.ClickFindIvoiceSearch().click();
     
     Thread.sleep(2000);
     String AfterSearchInvoiceNo = Ip.AfterSearchInvoiceNo().getText();
     
     Assert.assertEquals(invoicenumberSearch, AfterSearchInvoiceNo);
     
	invoiceSearch.clear();
	Thread.sleep(2000);
	Hp.Account_Hover();
	Thread.sleep(2000);
	Hp.Invoice_History();
	Thread.sleep(8000);
	String poSearch = Ip.POSearch();
	 invoiceSearch.sendKeys(poSearch);	
	 Thread.sleep(2000);
	 Ip.ClickFindIvoiceSearch().click();
	 
	 String poName = Ip.PoName().getText();
	 
	 Assert.assertEquals(poSearch, poName);
	 
	}
		
		
	@Test(priority = 4,description =  "Invoice Numbers validation  after clicking ")	
public void InvoiceNumbervalidation() throws Exception {
		
		Ip.InvoiceClk();
		Thread.sleep(4000);
		String invoicenumber = Ip.Invoicenumber();
		Thread.sleep(2000);
		String invoicenumbers = Ip.Invoicenumbers();
    Assert.assertEquals(invoicenumber, invoicenumbers);
    
    
		
		
}
	
	
	@Test(priority = 5, description = "check the checkbox are select or not")
	public void CheckBox() throws Exception {
		Ip.Go_back().click();
		Thread.sleep(4000);
		Ip.viewSelectInvoiceCounters();
		int order_count= Ip.Invoicecount();
		if(order_count==3)
		{
		System.out.println("Selected 3 orders and enterd the view order page");
		Assert.assertEquals(order_count, 3);
		}
		else
		{
			System.out.println("Selected 1 order and enterd the view order page");
			Assert.assertEquals(order_count, 1);
		}
}
	@Test(priority=6, description="")
	public void Invoice_SecondPage_Listing() throws Exception 
	{
		Ip.Go_back().click();
		Thread.sleep(2000);
		
		Ip.Second_Page_Listing();
		int order_count= Ip.Invoicecount();
		System.out.println("Selected 1 order and enterd the view order page");
		Assert.assertEquals(order_count, 1);
		
		

}
	
@Test(priority = 7)
public void DownlodFileInvoiceCSV() throws Exception {
	Hp.Account_Hover();
	Thread.sleep(2000);
	Hp.Invoice_History();
Thread.sleep(4000);
	 String filePath = System.getProperty("user.dir") + "\\DownloadCSV";
      //Creating the File object
      File file = new File(filePath);
      FileUtils.cleanDirectory(file);
    
      System.out.println("Files deleted........");
      Thread.sleep(20000);
      Ip.Downloadfile();
      System.out.println("File Downloded");
      Thread.sleep(6000);
      Invoice_count1= Ip.ReadfileData();
      System.out.println("Total No of orders downloaded: "+ Invoice_count1);
	} 

      
    



@Test(priority = 8)
public void DownlodFileInvoiceXL() throws Exception {

	 String filePath = System.getProperty("user.dir") + "\\DownloadCSV";
      //Creating the File object
      File file = new File(filePath);
      FileUtils.cleanDirectory(file);
    
      System.out.println("Files deleted........");
      Thread.sleep(20000);
      Ip.DownloadExcel().click();
      System.out.println("File Downloded");
      Thread.sleep(6000);
       Invoice_count2= Ip.ReadXLdata();
      System.out.println("Total No of orders downloaded: "+ Invoice_count2);
     

      
    

} 
   @Test(priority=9, description="Verify that the downloaded file has the order listed in front end")
public void Downloaded_File_validation() throws Exception 
{
	int orders=Ip.Next_button();
	System.out.println(orders);
	Assert.assertEquals(Invoice_count1, orders);
	Assert.assertEquals(Invoice_count2, orders);
	Thread.sleep(3000);
	
}
}
	
	
	

