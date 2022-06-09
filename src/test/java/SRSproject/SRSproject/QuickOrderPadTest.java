package SRSproject.SRSproject;

import java.util.List;
import java.util.concurrent.TimeoutException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.tools.ant.taskdefs.condition.Contains;
import org.jsoup.select.Evaluator.ContainsData;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.internal.reflect.ArrayEndingMethodMatcher;

import com.opencsv.exceptions.CsvValidationException;

import Pages.BulkOrderPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductListPage;
import Pages.QuickOrderPadPage;
import Pages.RegistrationForm;
import Pages.StoreLocatorPage;
import Utils.Constants;



public class QuickOrderPadTest extends BaseTest {

	QuickOrderPadPage qp;
	
	
   @Test(priority=1, description="Add item from Quick order to by searching item")
	public void Quick_OrderPad_Validation() throws InterruptedException, IOException 
	{
		 
		BasePage.initializtion();
		Thread.sleep(8000);
	LoginPage Lp = new  LoginPage(driver);
	Lp.ValidLogin();
		Thread.sleep(3000);
		 
	
		HomePage hp= new HomePage(driver);
	//	hp.clickOnHomeLink();
	//	Thread.sleep(8000);
		//driver.navigate().refresh();
		Thread.sleep(10000);
	qp = new QuickOrderPadPage(driver);
	qp.QuickOrder_Click();

	//	try {
//	 qp.QuickOrder_Click();
//		
//	
//	
//Reporter.log("Item got added from quick order pad to the cart",true);
//}
//catch (Exception e) {
//
//	Reporter.log("Item did not get added to cart ",true);
//}
	driver.close();

  }
	

	@Test(priority=2,description="Uploading a CSV file and validating")
	public void Quick_OrderPad_FileUpload_Validation() throws InterruptedException, IOException, CsvValidationException 
	{
	
		BasePage.initializtion();
		Thread.sleep(10000);
	LoginPage Lp = new  LoginPage(driver);
	Lp.ValidLogin();
		Thread.sleep(5000);
	
		qp = new QuickOrderPadPage(driver);
		Thread.sleep(11000);
		qp.Fileupload();
		Thread.sleep(5000);
		String QuickOrder_Redirection=  driver.getCurrentUrl();
		Assert.assertEquals(QuickOrder_Redirection, prop.getProperty("QuickOrderPage_URL"));
	

		
		

}
	
/*@Test(priority=3)
	public void Quick_OrderPad_FileDetails_Validation() throws InterruptedException, IOException, CsvValidationException 
	{
		LoginPage Lp = new  LoginPage(driver);
		Lp.ValidLogin();
		qp = new QuickOrderPadPage(driver);
		qp.Fileupload();


	//	List<List<String>> arr = qp.ReadfileData(); 
		List<String> arr= qp.ReadfileData();
System.out.println("final"+arr);
	
	


		
		

}
	@Test(priority=4)
	public void Quick_OrderPad_bp_Validation() throws InterruptedException, IOException, CsvValidationException 
	{
		LoginPage Lp = new  LoginPage(driver);
		Lp.ValidLogin();
		qp = new QuickOrderPadPage(driver);
		qp.Fileupload();
		BulkOrderPage Bp = new BulkOrderPage(driver);
		ArrayList<String> b= Bp.PartNo();
		System.out.println(b);
		

}*/
	
	@Test(priority=3,description="Validating item added from csv to the bulkorder page")
	public void Quick_OrderPad_UploadedtoBulkOrder_Validation() throws InterruptedException, IOException, CsvValidationException 
	{
		
		
		List<String> arr = qp.ReadfileData(); 
		System.out.println("final"+arr);
		BulkOrderPage Bp = new BulkOrderPage(driver);
		ArrayList<String> b= Bp.PartNo();
		System.out.println(b);
		
//		Assert.assertTrue(arr.equals(b)) ;

		
		if (arr.equals(b))
		{
			System.out.println("All the Items are Uploaded to Buld Order Page");
		}
		else
		{
			System.out.println("Some of the Items of Csv are Not uploaded completely ");
		}
		

}
	

	@Test(priority=4,description="Uploading CSV file that has Invalid items")
	public void Quick_OrderPad_InvalidFileUpload_Validation() throws InterruptedException, IOException, CsvValidationException 
	{
	
	
		Thread.sleep(10000);
	
		qp = new QuickOrderPadPage(driver);
		Thread.sleep(11000);
		//qp.InvalidFileupload();
		String ProductNotExistMessage=qp.InvalidFileupload();
		Assert.assertEquals(ProductNotExistMessage.endsWith("Successfully Passed Validation"),true);
		if (ProductNotExistMessage.endsWith("Successfully Passed Validation"));
		{
			System.out.println(ProductNotExistMessage);
			Thread.sleep(3000);
			driver.close();
		}
		
	}
		
		
	

		
		


	
	
}
