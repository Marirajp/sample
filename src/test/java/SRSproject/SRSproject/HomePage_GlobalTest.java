package SRSproject.SRSproject;

import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.tools.ant.taskdefs.condition.Contains;
import org.jsoup.select.Evaluator.ContainsData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Pages.HomePage_Global;
import Pages.ProductListPage;
import Pages.RegistrationForm;
import Utils.Constants;


public class HomePage_GlobalTest extends BaseTest {
	
	HomePage_Global Hpg;

	@Test(priority=1)
	public void homepageglobal() throws InterruptedException 
	{
		Hpg = new HomePage_Global(driver);
	
	String	BrandPage= Hpg.BrandSelection();
	Assert.assertEquals(BrandPage, prop.get("BrandPage_URL"));
	driver.navigate().back();
	
}
	
	@Test(priority=2)
	public void CategorySelection_Validation() throws InterruptedException 
	{
		Thread.sleep(8000);
		Hpg = new HomePage_Global(driver);
	
 String CategoryPageTitle= Hpg.mouseHoverSelectCategory();
 Assert.assertEquals(CategoryPageTitle, prop.get("CategoryPageTitle"));
	driver.navigate().back();
	
	
}
	
	@Test(priority=3)
	public void Become_ACustomer_Validation() throws InterruptedException 
	{
		Thread.sleep(8000);
		Hpg = new HomePage_Global(driver);
	
 String BecomeCustomerTitle= Hpg.BecomeACustomer_Header_click();
 Assert.assertEquals(BecomeCustomerTitle, Constants.BecomeACustomerTitle);

 
 
// driver.close();
//	ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
 //driver.switchTo().window(newTab.get(0));
	
}
	
@Test(priority=4)
	public void Logo_Validation() throws InterruptedException 
	{
		Thread.sleep(8000);
		Hpg = new HomePage_Global(driver);
		Hpg.clickOnHomeLink();
		
	
 String HomePageTitle= Hpg.validateHomePageTitle();
 Assert.assertEquals(HomePageTitle,prop.get("HomePageTitle") );

 
 
}
	
	@Test(priority=6)
	public void BecomeACustomer_Footer_Validation() throws InterruptedException 
	{
		Thread.sleep(8000);
		Hpg = new HomePage_Global(driver);
		

		 String BecomeCustomerTitle= Hpg.BecomeACustomer_Footer_click();
		 
		 driver.navigate().back();
		 Assert.assertEquals(BecomeCustomerTitle, Constants.BecomeACustomerTitle);
		 
		


 
 
}
	@Test(priority=5)
	public void siteMap_Redirection_Validation() throws InterruptedException 
	{
		Thread.sleep(8000);
		Hpg = new HomePage_Global(driver);
		

		 String SiteMapTitle= Hpg.Sitemap_Footer_click();
		 driver.navigate().back();
		 System.out.println(SiteMapTitle);
		// Assert.assertEquals(SiteMapTitle, Constants.SitemapTitle);
		 
		



 
 
}
	
@Test(priority=7)
	public void Terms_Redirection_Validation() throws InterruptedException 
	{
		Thread.sleep(8000);
		Hpg = new HomePage_Global(driver);
		

		
		 String TermsTitle= Hpg.Terms_Footer_click();
		 driver.navigate().back();
		 Assert.assertEquals(TermsTitle, Constants.TermsPageTitle);
		 Thread.sleep(500);
		


 
 
}
	
@Test(priority=8)
	public void Banner_RegisterNowLink_Validation() throws InterruptedException 
	{
		Thread.sleep(8000);
		Hpg = new HomePage_Global(driver);
		

		
		 
		 
		Hpg.clickOnHomeLink();
		
		
		String title=Hpg.Banner_RegisterNow_click();
		driver.navigate().back();
		Assert.assertEquals(title, Constants.REGISTRATIONFORM_URL);
		
		 


 
}
	

	@Test(priority=9)
	public void Login_Redirection_Validation() throws InterruptedException, TimeoutException 
	{
		Thread.sleep(8000);
		Hpg = new HomePage_Global(driver);
		

		
		 
		 
		Hpg.AddToCart_click().click();
		String loginPage=driver.getCurrentUrl();
		Assert.assertEquals(loginPage, prop.get("LoginPageURL"));
		
		
		}
		
	
	@Test(priority=12)
	public void Search_KeywordValidation() throws InterruptedException, TimeoutException 
	{
		
		Hpg = new HomePage_Global(driver);
		

		
		Hpg.SearchByKeyword();
		
		List<WebElement> list1=Hpg.LineItemsList();
		ArrayList<String> a1= new ArrayList<String>();
		for (WebElement option:list1)
		{
			String text= option.getText();
			a1.add(text);
		}
		System.out.println(a1);
		if (a1.isEmpty()) {
			Reporter.log("Items are Not listed in search result page",true);
        } else {
        	Reporter.log("Items are listed in search result page ",true);
        }
		System.out.println("*****************");
		
		
		}
	


 

	


@Test(priority=10)
public void Search_Keyword_Autosuggestion() throws InterruptedException, TimeoutException 
{
	
	Hpg = new HomePage_Global(driver);
	
	
	Hpg.SearchByKeyword_Autosuggestion();
	
	List<WebElement> list1=Hpg.LineItemsListAuto();
	ArrayList<String> a1= new ArrayList<String>();
	for (WebElement option:list1)
	{
		String text= option.getText();
		
		a1.add(text);
	}
	System.out.println(a1);
	if (a1.isEmpty()) {
			Reporter.log("Items are Not listed in autosuggestion on Search by Keyword",true);
        } else {
        	Reporter.log("Items are listed in autosuggestion on Search by Keyword",true);
        }
	System.out.println("*****************");
	
	
	}
	
	@Test(priority=11)
	public void Search_PartNo_Autosuggestion() throws InterruptedException, TimeoutException 
	{
		
		Hpg = new HomePage_Global(driver);
		
		
		Hpg.SearchByPartNo_Autosuggestion();
		
		List<WebElement> list1=Hpg.LineItemsListAuto();
		ArrayList<String> a1= new ArrayList<String>();
		for (WebElement option:list1)
		{
			String text= option.getText();
			
			a1.add(text);
		}
		System.out.println(a1);
		if (a1.isEmpty()) {
				Reporter.log("Items are Not listed in autosuggestion on Search by Part No",true);
	        } else {
	        	Reporter.log("Items are listed in autosuggestion on Search by Part No",true);
	        }
		System.out.println("*****************");
		
		
		}






}