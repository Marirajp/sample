package SRSproject.SRSproject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.InvoicePage;

public class Invoice extends BaseTest {
	HomePage Hp ;
	InvoicePage Ip = new InvoicePage(driver);;
	
	@Test(priority = 1)
	public void invoices() throws Exception {
		
		
		Hp = new HomePage(driver);
		Hp.ValidLogin();
		Thread.sleep(8000);
		
		
		Ip = new InvoicePage(driver);
		Ip.InvoiceClk();
		System.out.println(Ip.PagenationSize());
		System.out.println(Ip.NoofLintItems());
		
		Ip.dropdownorder("20");
	}	
		
		
		
	@Test(description = "Invoice Numbers validation  after clicking ")	
public void InvoiceNumbervalidation() throws Exception {
	

		String invoicenumber = Ip.Invoicenumber();
		String invoicenumbers = Ip.Invoicenumbers();
    Assert.assertEquals(invoicenumber, invoicenumbers);
		
		
		
}
	
	@Test(priority = 2)
	public void DownlodFileInvoice() throws Exception {
	
		 String filePath = System.getProperty("user.dir") + "\\DownloadCSV";
	      //Creating the File object
	      File file = new File(filePath);
	      FileUtils.cleanDirectory(file);
	    
	      System.out.println("Files deleted........");
	      Thread.sleep(20000);
	      Ip.Downloadfile();
	      System.out.println("File Downloded");
	
	
	}
	@Test(priority = 3, description = "check the checkbox are select or not")
	public void CheckBox() throws Exception {
		Ip.Checkbox();
	  Ip.viewSelectInvoiceCounter();
		 
	
	}
}
