package Pages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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

import com.opencsv.CSVReader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.BufferedReader;
import java.io.FileReader;
import com.opencsv.exceptions.CsvValidationException;

import SRSproject.SRSproject.BasePage;
import Utils.Constants;

public class QuickOrderPadPage extends BasePage{

	WebDriverWait wait;
	WebDriver driver;
	Actions act;
	
	@FindBy(xpath="//div[@class='quick-order-label']") WebElement QuickOrderPad;
	
	@FindBy(xpath="//a[@class='logo']") WebElement HomeLink;
	
	@FindBy(xpath="//button[@class='amqorder-button -empty -cart']") WebElement AddToCart;
	
	@FindBy(xpath="//button[@class='amasty-action-file']") WebElement uploadfile;
	
	@FindBy(xpath="//input[@id='amqorder-file']") WebElement file;
	
	@FindBy(xpath="//button[text()='Upload now']")  WebElement UploadNow;
	
	@FindBy(xpath="/html/body/div[2]/main/div[4]/div/aside/div/div[1]/h5") WebElement ProductNotExistCount;
	
	@FindBy(xpath="//button[text()='Accept']") WebElement Accept;
	
	

	public QuickOrderPadPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement  QuickOrder() throws InterruptedException
	{
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		 js.executeScript("arguments[0].scrollIntoView();", HomeLink);
		WebDriverWait wait= new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOf(QuickOrderPad));

		 Thread.sleep(1000);
		return QuickOrderPad;
	}
	
	
	public String QuickOrder_Click() throws InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		 js.executeScript("arguments[0].scrollIntoView();", HomeLink);
	

		 Thread.sleep(3000);
		QuickOrderPad.click();
		 Thread.sleep(2000);

		List <WebElement>  listele= driver.findElements(By.xpath("//input[@class='amqorder-input -search']"));
			

	    listele.size();
			 
	    Thread.sleep(1000);
			

		listele.get(0).click();
		listele.get(0).sendKeys(prop.getProperty("ValidProductSKU"));
		QuickOrderPad.click();
		Thread.sleep(4000);
		
		List <WebElement>  listele1= driver.findElements(By.xpath("//span[@class='amqorder-name']"));
		 
		listele1.size();
		
		Thread.sleep(8000);
		listele1.get(0).click();
		
		 Thread.sleep(4000);
		
		AddToCart.click();
		Thread.sleep(600);
		
		return  driver.getCurrentUrl();



}
	
	public BulkOrderPage Fileupload() throws InterruptedException
	
{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		 js.executeScript("arguments[0].scrollIntoView();", HomeLink);
	

		 Thread.sleep(10000);
		QuickOrderPad.click();
		Thread.sleep(3000);
		uploadfile.click();
		 Thread.sleep(1000);
//		file.sendKeys("C:\\Users\\DELL\\Downloads\\Tester2.csv");
//		file.sendKeys(prop.getProperty("valid_csvfile"));
		
	
		file .sendKeys(System.getProperty("user.dir") + prop.getProperty("valid_csvfile"));

		
		
		Thread.sleep(3000);
		
		UploadNow.click();
		return new BulkOrderPage(driver);
	
}
	
	public String InvalidFileupload() throws InterruptedException
	
	{
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			 js.executeScript("arguments[0].scrollIntoView();", HomeLink);
		

			 Thread.sleep(5000);
			QuickOrderPad.click();
			Thread.sleep(3000);
			uploadfile.click();
			 Thread.sleep(1000);
			//file.sendKeys("C:\\Users\\DCKAP\\Downloads\\Invalidfile1.csv");
			 file .sendKeys(System.getProperty("user.dir") + prop.getProperty("Invalid_csvfile"));

//			file.sendKeys(prop.getProperty("Invalid_csvfile"));
			
			// js.executeScript("arguments[0].scrollIntoView();", file);
			Thread.sleep(3000);
			
			UploadNow.click();
			
			WebDriverWait wait= new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(ProductNotExistCount));
			
			Thread.sleep(4000);
		
	    String	ProductNotExistMsg=ProductNotExistCount.getText();

			Thread.sleep(3000);
			
			//WebDriverWait wait= new WebDriverWait(driver, 60);
//			wait.until(ExpectedConditions.visibilityOf(Accept));

	
			Accept.click();
		return ProductNotExistMsg;
		
	}
	
	public  List<String> ReadfileData() throws InterruptedException, CsvValidationException, IOException
	
	{
//		 file .sendKeys(System.getProperty("user.dir") + prop.getProperty("Invalid_csvfile"));
	 String file = System.getProperty("user.dir") + prop.getProperty("valid_csvfile");
		 
		 
	       String delimiter = ",";
	     
	       String line;
	       List<String> lines = new ArrayList();
	        try (BufferedReader br =  new BufferedReader(new FileReader(file)))
	        {
	            while((line = br.readLine()) != null)
	            {
	            	 while((line = br.readLine()) != null)
	            	 {
	            		
	                List<String> values = Arrays.asList(line.split(delimiter));
	               
	                lines.add(values.get(0));
	          
	            }
	            }
	           System.out.println(lines);
	           
	        } 
	     
	        catch (Exception e)
	        {
	            System.out.println(e);
	        }
		      return (lines);
}
	

		

}

