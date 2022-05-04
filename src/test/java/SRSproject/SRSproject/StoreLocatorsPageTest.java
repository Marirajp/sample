package SRSproject.SRSproject;

import java.util.List;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.tools.ant.taskdefs.condition.Contains;
import org.jsoup.select.Evaluator.ContainsData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductListPage;
import Pages.RegistrationForm;
import Pages.StoreLocatorPage;
import Utils.Constants;


public class StoreLocatorsPageTest extends BaseTest {


	StoreLocatorPage slp;
	
	
	
	
@Test(priority=1)
	public void AllBranchValidation() throws InterruptedException, IOException 
	{
	BasePage.initializtion();
	Thread.sleep(9000);
		HomePage hp= new HomePage(driver);
		
	    hp.Locations_click();
//
	Thread.sleep(8000);
	slp = new StoreLocatorPage(driver);
	slp.YourLocation_EnterLocation();
	Thread.sleep(8000);
	slp.AllBranchListing();
	

}

@Test(priority=2)
public void SelectBranch_RedirectionValidation() throws InterruptedException 
{
	HomePage hp= new HomePage(driver);
hp.Locations_click();
slp = new StoreLocatorPage(driver);
Thread.sleep(700);
	
	slp.YourLocation_EnterZipcode();
	
	String BranchPageTitle = slp.BranchNearBy_Click();
	assertEquals(BranchPageTitle, prop.getProperty("BranchPageTitle"));
driver.navigate().back();
	

}



	@Test(priority=4)
	public void LocationBasedBranchValidation() throws InterruptedException 
	{
		HomePage hp= new HomePage(driver);
	hp.Locations_click();
	slp = new StoreLocatorPage(driver);
	Thread.sleep(500);
		
		slp.YourLocation_EnterLocation();
		slp.Radius_50MilesSelection();
		slp.Search_click();
		Thread.sleep(2000);
		slp.BranchAsPerRadius();
		

}
	
	@Test(priority=5)
	public void ZipcodeBasedBranchValidation() throws InterruptedException 
	{
		HomePage hp= new HomePage(driver);
	hp.Locations_click();
	slp = new StoreLocatorPage(driver);
	Thread.sleep(500);
		
		slp.YourLocation_EnterZipcode();;
		slp.Radius_250MilesSelection();
		slp.Search_click();
		Thread.sleep(2000);
		slp.BranchAsPerRadius();
		

}
	@Test(priority=6)
	public void GetDirection_RedirectionValidation() throws InterruptedException 
	{
		HomePage hp= new HomePage(driver);
	hp.Locations_click();
	slp = new StoreLocatorPage(driver);
	Thread.sleep(700);
		
		slp.YourLocation_EnterZipcode();
		
		String DirectionPageTitle = slp.GetDirections_LinkClick();
	Assert.assertEquals((DirectionPageTitle.contains("Google Maps")),true);
	 String windowHandle = driver.getWindowHandle();
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		driver.close();
		   driver.switchTo().window(newTab.get(0));
		

}
	
	@Test(priority=7)
	public void InValidLocationSearch_Validation() throws InterruptedException 
	{
		HomePage hp= new HomePage(driver);
		hp.Locations_click();
		slp = new StoreLocatorPage(driver);
		Thread.sleep(500);
			
			slp.YourLocation_EnterInvalidLocation();
			slp.Radius_250MilesSelection();
			slp.Search_click();
			Thread.sleep(2000);
			String InvalidLocationResult = slp.YourLocation_InvalidLocationResult();
			Assert.assertEquals((InvalidLocationResult.contains("There are no stores found near")),true);
		

}
	
	@Test(priority=8)
	public void ChangeBranchDisplayed_LoggedInUser_Validation() throws InterruptedException 
	{
		
		LoginPage Lp = new  LoginPage(driver);
		Lp.ValidLogin();
		HomePage hp= new HomePage(driver);
		hp.Locations_click();
		slp = new StoreLocatorPage(driver);
		Thread.sleep(500);
		slp.YourLocation_EnterLocation();
			
		WebElement ChangeBranch= slp.ChangeBranchLink();
		Assert.assertEquals(ChangeBranch.isDisplayed(),true);
		//LoginPage Lp = new  LoginPage(driver);
		//Lp.SignOut();
			

}
	
@Test(priority=9)
	public void ChangingBranch_Validation() throws InterruptedException 
	{
	
		HomePage hp= new HomePage(driver);
		hp.Locations_click();
		slp = new StoreLocatorPage(driver);
		Thread.sleep(500);
		slp.YourLocation_EnterLocation();
		
		
		//slp.YourLocation_EnterZipcode();
	String a=	slp.ChangeBranchDropDown();
		Assert.assertEquals(a,prop.getProperty("Branch2"));
		
	//LoginPage Lp = new  LoginPage(driver);
	//	Lp.SignOut();
		
		Thread.sleep(1000);
		
			

}
	
	
}
