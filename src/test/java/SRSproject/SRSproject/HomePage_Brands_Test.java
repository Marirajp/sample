package SRSproject.SRSproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.mongodb.diagnostics.logging.Logger;

import Pages.HomePage;
import Pages.HomePage_Global;
import Pages.LoginPage;
import Utils.Constants;

public class HomePage_Brands_Test extends BaseTest 

{
	
	HomePage Hp ;

	@Test(priority=1,description="Brand Selection From layout")
	public void homepageglobal() throws InterruptedException, IOException 
	{
		BasePage.initializtion();
		Thread.sleep(10000);
		
		Hp = new HomePage(driver);
	String	BrandPage= Hp.BrandSelection();
	Assert.assertEquals(BrandPage, prop.get("BrandPage_URL"));
	
		
    }
	
	
	
	@Test(priority=2, description="Category Selection From layout")
	public void CategorySelection_Validation() throws InterruptedException 
	{
		Thread.sleep(8000);
	
	
 String CategoryPageTitle= Hp.mouseHoverSelectCategory();
 Assert.assertEquals(CategoryPageTitle, prop.get("CategoryPageTitle"));
	
	
	
     }

	
    @Test(priority=4, description="Logo redirection")
	public void Logo_Validation() throws InterruptedException 
	{
		Thread.sleep(8000);
		
		Hp.clickOnHomeLink();
		
	
 String HomePageTitle= Hp.validateHomePageTitle();
 Assert.assertEquals(HomePageTitle,prop.get("HomePageTitle") );

 
     }
	
	
	
	@Test(priority=5, description="Site Map link Redirection ")
	public void siteMap_Redirection_Validation() throws InterruptedException 
	{
		Thread.sleep(8000);
	
		

		 String SiteMapTitle= Hp.Sitemap_Footer_click();
		 Thread.sleep(1000);
		 driver.navigate().back();
		 Assert.assertEquals(SiteMapTitle, Constants.SitemapTitle);
		 
  
      }
	
    @Test(priority=7,  description="Terms link Redirection ")
	public void Terms_Redirection_Validation() throws InterruptedException 
	{
		Thread.sleep(8000);
		
		

		 String Term_title=	Hp.Terms_Footer_click();
		 Assert.assertEquals(Term_title, Constants.TermsPageTitle);
		 Thread.sleep(1000);
		 driver.navigate().back();
		 Thread.sleep(500);
	
    }
    
    
  /*  @Test(priority=8,  description="Changing Shipto ")
     public void ChangeShipto_Validation() throws InterruptedException 
    {
	Thread.sleep(8000);
	LoginPage Lp = new LoginPage(driver);
	Lp.ValidLogin();
	
	String shipto =Hp.ChangeShipTo();
	Assert.assertEquals(shipto,prop.getProperty("Shipto"));
 
    }
    
    

   @Test(priority=12, description="Changing Branch")
    public void ChangeBranch_Validation() throws InterruptedException 
    {
	Thread.sleep(8000);
	//LoginPage Lp = new LoginPage(driver);
	//Lp.ValidLogin();
	
	String Yourbranch =Hp.ChangeBranch();
	Assert.assertEquals(Yourbranch,prop.getProperty("Branch2"));
	
     }
*/
     
    @Test(priority=11,  description="Search by keyword")
    
    public void Search_KeywordValidation() throws InterruptedException, TimeoutException 
    {
	
	Hp.SearchByKeyword();
	
	List<WebElement> list1=Hp.LineItemsList();
	ArrayList<String> a1= new ArrayList<String>();
	for (WebElement option:list1)
	{
		String text= option.getText();
		a1.add(text);
	}
	System.out.println(a1);
	if (a1.isEmpty())
	{
		Reporter.log("Items are Not listed in search result page",true);
    } else
    {
    	Reporter.log("Items are listed in search result page ",true);
    }
	System.out.println("*****************");
	
	
	}


    @Test(priority=9, description="Search by keyword and its autosuggestion")
    public void Search_Keyword_Autosuggestion() throws InterruptedException, TimeoutException 
   {
    	
    Hp.SearchByKeyword_Autosuggestion();

    List<WebElement> list1=Hp.LineItemsListAuto();
    ArrayList<String> a1= new ArrayList<String>();
    
    for (WebElement option:list1)
    {
	String text= option.getText();
	
	a1.add(text);
    }
    System.out.println(a1);
    
    
    if (a1.isEmpty()) 
    {
		Reporter.log("Items are Not listed in autosuggestion on Search by Keyword",true);
    } else
    {
    	Reporter.log("Items are listed in autosuggestion on Search by Keyword",true);
    }
    System.out.println("*****************");


   }

    @Test(priority=10,  description="Search by Partno and its autosuggestion")
    public void Search_PartNo_Autosuggestion() throws InterruptedException, TimeoutException 
    {
	
	Hp.SearchByPartNo_Autosuggestion();
	
	List<WebElement> list1=Hp.LineItemsListAuto();
	ArrayList<String> a1= new ArrayList<String>();
	
	for (WebElement option:list1)
	{
		String text= option.getText();
		
		a1.add(text);
	}
	System.out.println(a1);
	
	
	if (a1.isEmpty()) 
	{
			Reporter.log("Items are Not listed in autosuggestion on Search by Part No",true);
     } 
	else 
	{
        	Reporter.log("Items are listed in autosuggestion on Search by Part No",true);
      }
	System.out.println("*****************");
	
	
	}





	
	
	
}
		
	


 

	

