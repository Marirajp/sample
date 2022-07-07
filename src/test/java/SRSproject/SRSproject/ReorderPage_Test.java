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
import Pages.LoginPage;
import Pages.QuickOrderPadPage;
import Pages.Reorder_Page;
import Utils.Constants;

public class ReorderPage_Test  extends BaseTest
{

	
	Reorder_Page Rp;
	ArrayList<String> Reorder_list=null;
	


	@Test(priority=1)
	public void ReorderPage_Redirection() throws InterruptedException, IOException 
	{
		//BasePage.initializtion();
		Thread.sleep(8000);
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		Thread.sleep(7000);
		HomePage Hp = new HomePage(driver);
		Hp.MyAccount_Hover();
		Hp.Reorder_Hover();
	 String	Reorder_Title= driver.getTitle();
		Assert.assertEquals(Reorder_Title,Constants.Reorder_PageTitle);
		

}
	
 @Test(priority=2)
	public void UploadFile_Redirection() throws InterruptedException, CsvValidationException, IOException 
	{
	 Thread.sleep(2000);
		Rp= new Reorder_Page(driver);
		Rp.Fileupload();
		Thread.sleep(8000);
	ArrayList<String>List = Rp.GetLineItme();
	Reorder_list=List;
	
	QuickOrderPadPage qp = new QuickOrderPadPage(driver);
	
	List<String> arr = qp.ReadfileData(); 
	
	
	Assert.assertEquals(Reorder_list,arr);
		

}
 
 @Test(priority=3)
	public void UOM_Validation() throws InterruptedException 
	{
		
		Thread.sleep(5000);
		ArrayList<String>List = Rp.GetLineItme();
		Reorder_list=List;
		
		if (List.size()>3)
		{
			String uom1=Rp.First_Product_UOM().getText();
			
			String str1 = uom1.replaceAll("[^a-zA-Z0-9]"," "); 
			String UOM1= 	str1.replaceAll("\\d","");
			
			String Uom1=UOM1.trim().replaceAll(" +", " ");
			
			String uom2=Rp.Second_Product_UOM().getText();
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
			Thread.sleep(1000);
			String uom1=Rp.First_Product_UOM().getText();
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
	
 @Test(priority=4)
	public void SaveAnReorderList_Validation() throws Exception 
	{
		Rp= new Reorder_Page(driver);
		Thread.sleep(8000);
		
		Rp.ReorderNameField().sendKeys(prop.getProperty("Reorder_Name1"));
		Thread.sleep(400);
		Rp.Save_button().click();
		Thread.sleep(3000);
		Rp.Proceed_Btn();
		
}
	
	
 @Test(priority=9)
	public void InvalidFile_Validation() throws InterruptedException, CsvValidationException, IOException 
	{

		driver.navigate().refresh();
		Thread.sleep(8000);
		Rp= new Reorder_Page(driver);
		HomePage Hp = new HomePage(driver);
		Hp.clickOnHomeLink();
		Hp.MyAccount_Hover();
		Hp.Reorder_Hover();
		Thread.sleep(8000);
		Rp.Invalid_Fileupload();
		Thread.sleep(4000);
	String notification =Rp.ItemsNotAdded_Notification();
	Thread.sleep(3000);
	//Rp.close_button_click();
	Assert.assertEquals(notification.contains(Constants.Notification), true);
		
}
	
	@Test(priority=5)
	public void CreateNewReorder_Redirection()throws InterruptedException, CsvValidationException, IOException 
	{
		Thread.sleep(8000);
		Rp= new Reorder_Page(driver);
		Thread.sleep(8000);
		Rp.Create_New_ReorderPad().click();
		String Reorder_DetailPage= driver.getCurrentUrl();
		Assert.assertEquals(Reorder_DetailPage, prop.getProperty("ReOrder_Detai_URL"));
	}


	@Test(priority=6)
	public void CreateNew_ReorderPad_AndLegacySearch_Validation() throws Exception 
	{
		Thread.sleep(8000);
	
		
		

			
			Rp.EnterProduct();
			Rp.Enter_LegacyPartNo();
			Thread.sleep(900);
			Rp.ReorderNameField().sendKeys(prop.getProperty("Reorder_Name2"));
			Thread.sleep(900);
			
			Rp.Save_button().click();
//			Thread.sleep(2000);
			Rp.Proceed_Btn();
				
			
			
	Reporter.log("Able to create new reorder pad",true);
		
			}
	
	@Test(priority=7)
	public void View_Validation() throws Exception 
	{
		driver.navigate().refresh();
		driver.navigate().refresh();
		Thread.sleep(8000);
		Rp= new Reorder_Page(driver);
		HomePage Hp = new HomePage(driver);
		Hp.MyAccount_Hover();
		Hp.Reorder_Hover();
		Thread.sleep(12000);
	
		waitUntilElementVisibility(Rp.View_Click());
		//Rp.View_Click();
		Rp.Add_All_Items().click();
		
		Thread.sleep(5000);
	
		String Success_msg= Rp.Items_addtocart_msg();
		Thread.sleep(8000);
		 System.out.println(Success_msg);
		Assert.assertEquals(Success_msg.contains(" Items have been successfully added to your Cart"), true);
//        System.out.println(Success_msg);
 

		
		
	}
}
