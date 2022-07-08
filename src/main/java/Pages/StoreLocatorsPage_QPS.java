package Pages;

import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import SRSproject.SRSproject.BasePage;
import Utils.Constants;


public class StoreLocatorsPage_QPS extends BasePage {

	WebDriverWait wait;
	WebDriver driver;
	Actions act;
	
	@FindBy(xpath="//input[@id='stores-autocomplete']") WebElement YourLocation;
	
	@FindBy(xpath="//span[text()='Locations']") WebElement LocationTitle;
	
	@FindBy(xpath="//select[@id='stores-autocomplete-radius']") WebElement Radius;
	
	@FindBy(xpath="//button[@class='action-store-search button']") WebElement Search;
	
	@FindBy(xpath="//h2[text()='Locations near you']") WebElement LocationNearYoutitle;
	
	@FindBy(xpath="//a[@class='storelocator-store-directions-map store-contact-link']") WebElement GetDirections;
	
	@FindBy(xpath="//div[@class='storelocator-arialive-info']") WebElement InvalidLocationResult;
	
	@FindBy(xpath="/html/body/div[1]/main/div[4]/div/div[1]/div[2]/div[2]/ul/li[1]/a") WebElement Branch;
	
	@FindBy(xpath="(//a[text()='Change Branch'])[3]") WebElement ChangeBranchLink;
	
	@FindBy(xpath="//select[@id='branches']") WebElement ChangeBranchSelection;
	
	@FindBy(css ="body > div.modals-wrapper > aside.modal-popup.branch-modal._show > div.modal-inner-wrap > footer > button.action.primary") WebElement Confirm;
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div/div/div[1]/div[1]/ul/li[1]/span") WebElement YourBranch;
	
	@FindBy(xpath="/html/body/div[1]/main/div[4]/div/div[1]/div[2]/div[1]")  WebElement c;
	
	public StoreLocatorsPage_QPS(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void YourLocation_EnterZipcode() throws InterruptedException
	{
		 WebDriverWait wait= new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.visibilityOf(YourLocation));
		YourLocation.clear();
		Thread.sleep(100);
		YourLocation.click();
		Thread.sleep(500);
		YourLocation.sendKeys(prop.getProperty("zipcode"));
		
	}
	
	
	public void YourLocation_EnterLocation() throws InterruptedException
	{
		 WebDriverWait wait= new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.visibilityOf(YourLocation));
		
		YourLocation.click();
		Thread.sleep(500);
		YourLocation.sendKeys(prop.getProperty("location"));
	}
	

	public void YourLocation_EnterInvalidLocation() throws InterruptedException
	{
		 WebDriverWait wait= new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.visibilityOf(YourLocation));
		
		YourLocation.click();
		Thread.sleep(500);
		YourLocation.sendKeys(prop.getProperty("Invalidlocation"));
	}
	
	public String YourLocation_InvalidLocationResult() throws InterruptedException
	{
		 WebDriverWait wait= new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.visibilityOf(LocationNearYoutitle));
			Thread.sleep(2000);
		
	return	InvalidLocationResult.getText();
	}
	
	

	public void Radius_50MilesSelection() throws InterruptedException
	{
		
		
			Radius.click();
			
			Select radius= new Select(Radius);
			radius.selectByVisibleText("50 Miles");
		Thread.sleep(500);


	}
	

	public void Radius_250MilesSelection() throws InterruptedException
	{
		
		
			Radius.click();
			
			Select radius= new Select(Radius);
			radius.selectByVisibleText("250 Miles");
		Thread.sleep(500);


	}
	
	public void Search_click() throws InterruptedException
	{
		
		
			Search.click();
			Thread.sleep(500);

	}
	 
	public void AllBranchListing() 
	{
try
{
		ArrayList<String> a= new ArrayList<String>();
		a.add(prop.getProperty("Branch1"));
		a.add(prop.getProperty("Branch2"));
		a.add(prop.getProperty("Branch3"));
		a.add(prop.getProperty("Branch4"));
		//QPS site
		a.add(prop.getProperty("Branch5"));
	    a.add(prop.getProperty("Branch6"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();", LocationNearYoutitle);
		Thread.sleep(10000);
		
		
		List <WebElement>  searchresult= driver.findElements(By.xpath("//a[@class='storelocator-store-name 2121']"));
	
		ArrayList<String> a1= new ArrayList<String>();
		for (WebElement option:searchresult)
		{
			String text= option.getText();
			a1.add(text);
		}
	if(a.equals(a1))
			{
		System.out.println("All the Branch Are Listed As Expected");
			}
	else
			{
		System.out.println("Branches are Not Listed As Expected");
		System.out.println(a1);
			}
}
catch (Exception e) {
	System.out.print("There is No Branch for the Search Criteria");
}

}
	
	public void BranchAsPerRadius() throws InterruptedException 
	{
		
		try
		{

		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();", LocationNearYoutitle);
		Thread.sleep(8000);
		List <WebElement>  searchresult= driver.findElements(By.xpath("//a[@class='storelocator-store-name test-name']"));
		

		for(int i = 0; i<searchresult.size();i++)
		{
			String temp = searchresult.get(i).getText();
			System.out.println( "For the Location and Radius Selected the Branches are:"+ temp);

}
		}
		catch (Exception e) {
			System.out.print("There is No Branch for the Search Criteria");
	}
	}
	

	public String GetDirections_LinkClick() throws InterruptedException  
	{

		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();", LocationNearYoutitle);
		 Thread.sleep(5000);
	
		 GetDirections.click();
		 String windowHandle = driver.getWindowHandle();
			ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
			   driver.switchTo().window(newTab.get(1));
			  
			 
			//   Thread.sleep(5000);
		return	driver.getTitle();
			
		
			 
}
	
	public String BranchNearBy_Click() throws InterruptedException  
	{

		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();", LocationNearYoutitle);
		 Thread.sleep(900);
		 
		 WebDriverWait wait= new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(Branch));
	
		 Branch.click();
		 Thread.sleep(1000);
		return	driver.getTitle();
		
		
			 
}
	
	public WebElement ChangeBranchLink() throws InterruptedException  
	{
Thread.sleep(1000);
		
		

		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();", LocationNearYoutitle);
		 
		/* Thread.sleep(2000);
		 WebDriverWait wait= new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(Branch));*/
		 
	
	return	 ChangeBranchLink; 
		 
			
		
			 
}
	public String ChangeBranchDropDown() throws InterruptedException  
	{

		Thread.sleep(1000);
		
		

		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();", LocationNearYoutitle);


		 Thread.sleep(1000);
		// WebDriverWait wait= new WebDriverWait(driver, 60);
					
		 
	
	 ChangeBranchLink.click();
	 Thread.sleep(800);
	 
	//	wait.until(ExpectedConditions.visibilityOf(ChangeBranchSelection));
		//ChangeBranchSelection.click();
		Thread.sleep(800);
			
		Select Brand= new Select(ChangeBranchSelection);
		 Brand.selectByVisibleText(prop.getProperty("Branch2"));
		 Thread.sleep(900);
		
		js.executeScript("arguments[0].scrollIntoView();",ChangeBranchSelection);
		
		Thread.sleep(2000);
		 WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.visibilityOf(Confirm));
	 Confirm.click();
		//driver.findElement(By.xpath("/html/body/div[6]/aside[3]/div[2]/footer/button[1]")).click();
		
		 js.executeScript("arguments[0].scrollIntoView();",YourBranch);
		 Thread.sleep(10000);
		 return YourBranch.getText();
		 
			
		
			 
}

}


