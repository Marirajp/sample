package SRSproject.SRSproject;



import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import  java.io.FileNotFoundException;

import org.openqa.selenium.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.hamcrest.Matcher;
import org.hamcrest.core.Is;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.OpenOrdersPage;
import Pages.QuickOrderPadPage;
import Pages.Reorder_Page;
import Utils.Constants;
public class OpenOrderTest extends BaseTest
{

	OpenOrdersPage Op;
	ArrayList<String> OpenOrder_list=null;
	int count=0;
	int Orders_count2=0;
	

	@Test(priority=1, description="Validating Open order redirection on selection")
	public void OpenOrder_Redirection() throws InterruptedException, IOException 
	{
		BasePage.initializtion();
		Thread.sleep(2000);
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		Thread.sleep(2000);
		HomePage Hp = new HomePage(driver);
		Hp.MyAccount_Hover();
		Hp.OpenOrder_Hover();
		
 String Title=	 driver.getTitle();
 Assert.assertEquals(Title,Constants.OpenOrder_Title);
	

}
	@Test(priority=2, description="Validating that open order are listed and its not empty")
	public void OpenOrder_Listing() throws InterruptedException, CsvValidationException, IOException 
	{
		Op =  new OpenOrdersPage(driver);
	ArrayList<String>List = Op.GetLineOrders();
	OpenOrder_list=List;
	System.out.println(OpenOrder_list.size());
	assertFalse(OpenOrder_list.isEmpty());
	

}
	
	@Test(priority=3, description="Selecting orders and verifying that those are listed in view orders page ")
	public void Selecting_Openorder() throws Exception 
	{
		Op =  new OpenOrdersPage(driver);
		Op.Selecting_Order();
		int order_count= Op.Orders();
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
	@Test(priority=4, description="Selecting order and clicking view order in second page if it exist")
	public void OpenOrder_SecondPage_Listing() throws Exception 
	{
		Op.Go_back().click();
		Thread.sleep(2000);
		Op =  new OpenOrdersPage(driver);
		Op.Second_Page_Listing();
		int order_count= Op.Orders();
		System.out.println("Selected 1 order and enterd the view order page");
		Assert.assertEquals(order_count, 1);
		
		

}
	@Test(priority=5, description="Verifying whether on clicking download the file is getting downloaded")
public void Download_Validation() throws Exception 
{
		HomePage Hp = new HomePage(driver);
		Hp.MyAccount_Hover();
		Hp.OpenOrder_Hover();
		Thread.sleep(2000);
	 String filePath = System.getProperty("user.dir") + "\\DownloadCSV";
     //Creating the File object
     File file = new File(filePath);
     FileUtils.cleanDirectory(file);
   
     System.out.println("Files deleted........");
     Thread.sleep(20000);
     
    Op.Downloadfile();
     System.out.println("File Downloded");
     Thread.sleep(20000);
    /* if (file.isDirectory())
     {
    	 String[] files = file.list();
    	long length= file.length();
    
    	
    	Assert.assertTrue(length>0);
     }*/
     int orders_count= Op.Read_DownloadedfileData();
     count=orders_count;
     System.out.println("Total No of orders downloaded: "+ orders_count);
     

}
	
	@Test(priority=6, description="Verify that the downloaded file has the order listed in front end")
	public void Downloaded_File_validation() throws Exception 
	{
		int orders=Op.Next_button();
		System.out.println(orders);
		System.out.println("Order in Front end and the dowloaded file" +orders+count); 
		Assert.assertEquals(count, orders);
	}
	
	@Test(priority = 7)
	public void DownlodFileInvoiceXL() throws Exception {

		 String filePath = System.getProperty("user.dir") + "\\DownloadCSV";
	      //Creating the File object
	      File file = new File(filePath);
	      FileUtils.cleanDirectory(file);
	    
	      System.out.println("Files deleted........");
	      Thread.sleep(20000);
	      Op.DownloadExcel();
	      System.out.println("File Downloded");
	      Thread.sleep(20000);
	   /*   if (file.isDirectory())
	      {
	     	 String[] files = file.list();
	     	long length= file.length();
	     
	     	
	     	Assert.assertTrue(length>0);
	      }*/
	      Thread.sleep(6000);
	       Orders_count2= Op.ReadXLdata();
	      System.out.println("Total No of orders downloaded: "+ Orders_count2);
	      int orders=Op.Next_button();
			System.out.println("Order in Front end and the dowloaded file"+orders+Orders_count2); 
			Assert.assertEquals(Orders_count2, orders);
	     

	      
	    

	} 
	
	
}
