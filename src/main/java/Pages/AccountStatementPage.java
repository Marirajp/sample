
package Pages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencsv.exceptions.CsvValidationException;

import SRSproject.SRSproject.BasePage;

public class AccountStatementPage extends BasePage {
	
	WebDriverWait wait;
	WebDriver driver;
	Actions act;

	
	@FindBy(xpath="//span[normalize-space()='Account']")WebElement Account;
	@FindBy(xpath="//span[normalize-space()='View Invoice History']")WebElement invoice;
 //   @FindBy(xpath="//span[text()='View Account Statement']")WebElement AccountStatement;
    @FindBy(xpath="//span[text()='View Account Statement']")WebElement AccountStatement;
    @FindBy(xpath="//a[normalize-space()='Account Statement']")WebElement AccountStatement1;
    @FindBy(xpath="//span[normalize-space()='Print this Page']")WebElement PrintPage;
    @FindBy(xpath="//span[normalize-space()='Print this']")List<WebElement> PrintPage1;
    
    
    @FindBy(xpath="//span[normalize-space()='Download CSV']")WebElement DownloadCSV;
    @FindBy(xpath="//span[normalize-space()='Download XLSX']")WebElement DownloadXLSX;
    
    @FindBy(xpath="//span[normalize-space()='Total Balance']")WebElement TotalBalance;
    @FindBy(xpath="//span[@class='amount']" )WebElement TotalBalanceAmount;
    @FindBy(xpath="//body/div/main/div/div/div/div/div/div[2]/span[2]")WebElement CurrentBalance;
    @FindBy(xpath="//div[@class='totals']")WebElement BottomTotalBalance;
    @FindBy(xpath="//section[@data-container='items']//span[2]")WebElement BottomTotalBalanceAmount;
    @FindBy(xpath="//span[normalize-space()='1-30 Days']")WebElement onemonth;
    @FindBy(xpath="//span[normalize-space()='31-60 Days']")WebElement TwoMonths;
    @FindBy(xpath="//span[normalize-space()='61-90 Days']")WebElement ThreeMonths;
    @FindBy(xpath="//span[normalize-space()='Over 90 Days']")WebElement OverMonth;
    @FindBy(xpath="//body//div//th[2]")WebElement InvoiceHastag;
    @FindBy(xpath="//tbody/tr[1]/td[1]/a[1]")WebElement InvoiceID;
    @FindBy(xpath="//span[@data-bind='text: invoiceDetails.invoiceHeader.invoiceNumber']")WebElement InvoiceIDNUmber;
    
    @FindBy(xpath="//span[contains(text(),'Click here to Open an Account with BillTrust or ma')]")WebElement AccountBillTrust;
    @FindBy(xpath="//input[@value='Sign Up Now']")WebElement SignUp;
	
    @FindBy(xpath="//a[@class='footable-page-link']")List<WebElement> PageCount;
	public AccountStatementPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	public void AccountStatementButton() throws InterruptedException {
		
	
	
		act=new Actions(driver);
		
		act.moveToElement(Account).perform();
		Thread.sleep(5000);
		Account.click();
		
		act.moveToElement(invoice).perform();
		
		Thread.sleep(3000);
		act.moveToElement(AccountStatement).perform();
		Thread.sleep(3000);
		AccountStatement.click();
		Thread.sleep(3000);
		
	}
	
	public void AccountStatement() throws InterruptedException {
		act=new Actions(driver);
		Thread.sleep(3000);
		act.moveToElement(AccountStatement1).perform();
		AccountStatement1.click();
		Thread.sleep(3000);
	}
	
//	public boolean PrintStatement() throws InterruptedException {
//		
//		if(PrintPage.isDisplayed()) {
//			return true;
//		}else {
//			return false;
//		}
//	}
	public void PrintPageButton() throws InterruptedException {
		act.moveToElement(PrintPage).perform();
		PrintPage.click();
		Thread.sleep(2000);
	}
	
//	public boolean PrintStatement() {
//		try {
//			WebDriverWait wait=new WebDriverWait(driver, 20);
//			wait.until(ExpectedConditions.visibilityOf(PrintPage));
//			return true;
//			
//		}catch(Exception e) {
//			return false;
//		}
//	}
	
	public boolean printStatementAvailable() {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PrintPage));
		if(PrintPage1.size()==0) {
			System.out.println("Print PAge Module is available");
			return true;
		}else {
			System.out.println("Print PAge Module is Not-available");
			return false;
		}		
	}
	public void PrintPageSta() {
		try {
		driver.findElement(By.xpath("//span[normalize-space()='Print this Page']"));
		}
		catch(NoSuchElementException e) {
			System.out.println("not");
			
		}
	}
	public void AccountBalance() throws InterruptedException {
		TotalBalance.isDisplayed();
		String TotalBal = TotalBalance.getText();
		System.out.println(TotalBal);
		Thread.sleep(3000);

		onemonth.isDisplayed();
		String one = onemonth.getText();
		System.out.println(one);
		Thread.sleep(3000);
		TwoMonths.isDisplayed();
		String two = TwoMonths.getText();
		System.out.println(two);
		Thread.sleep(3000);
		ThreeMonths.isDisplayed();
		String three = ThreeMonths.getText();	
		System.out.println(three);
		Thread.sleep(3000);
		OverMonth.isDisplayed();
		String over = OverMonth.getText();
		System.out.println(over);
		Thread.sleep(3000);
		InvoiceHastag.isDisplayed();
		InvoiceHastag.getText();
		BottomTotalBalance.isDisplayed();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);	
		String BottomTotalBal = BottomTotalBalance.getText();
		System.out.println(BottomTotalBal);
		Thread.sleep(3000);
		 String Amo = TotalBalanceAmount.getText();
		System.out.println(Amo);
		String amoun = BottomTotalBalanceAmount.getText();
		System.out.println(amoun);
		Assert.assertEquals(amoun,Amo);
		if(Amo.equals(amoun)) {
			System.out.println("Total balance is equal");
		}else {
			System.out.println("Total balance is Not-equal");
		}
	}
	
	public void InvoiceId() throws InterruptedException {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,300)");
	//	scrollUpandDownUsingElement(InvoiceID);
		Thread.sleep(3000);
		act.moveToElement(InvoiceID).perform();
		String in = InvoiceID.getText();
		System.out.println(in);
		InvoiceID.click();
		Thread.sleep(3000);
		InvoiceIDNUmber.isDisplayed();
		String inn = InvoiceIDNUmber.getText();
		System.out.println(inn);
		Thread.sleep(3000);
		if(in.equals(inn)) {
			System.out.println("Invoice-ID is equal");
		}else {
			System.out.println("Invoice-ID is Not-equal");
		}
			
		}
	
	public void AccountBill() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		AccountBillTrust.isEnabled();
		AccountBillTrust.getText();
		AccountBillTrust.click();
		String newtab = driver.getWindowHandle();
		System.out.println(newtab);
		
		Thread.sleep(3000);
		for(String childTab:driver.getWindowHandles()) {
			driver.switchTo().window(childTab);
		}
		System.out.println(driver.getTitle());
		Thread.sleep(4000);
		SignUp.click();
	}
	
	public String ListOfPage() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		List<WebElement> findElements = driver.findElements (By.xpath("//li[contains(@class,'footable-page visible')]//a"));
		int PaginationSize = findElements.size();
        String s2 = "No of Pagess : " + PaginationSize;		
		System.out.println(s2);
		return s2;
	}
	
	public void Downloadfiles() throws InterruptedException, IOException {
		
		 String filePath = System.getProperty("user.dir") + "\\DownloadCSV";
	      //Creating the File object
	      File file = new File(filePath);
	      FileUtils.cleanDirectory(file);
	    
	      System.out.println("Files deleted........");
	      Thread.sleep(20000);
	      act.moveToElement(DownloadCSV).perform();
	      DownloadCSV.getText();
			DownloadCSV.click();
			Thread.sleep(3000);
			act.moveToElement(DownloadXLSX).perform();
			DownloadXLSX.getText();
			DownloadXLSX.click();
	      System.out.println("File Downloded");
	    
		
		
		
	
	}
	public boolean IsDispayed()
	{
	    try {
	    	PrintPage.isDisplayed();
	    	System.out.println("s");
	    } catch (Exception e) {
	    	System.out.println("n");
	        return false;
	    }
	    return true;
	}
	
//	public void DownloadFileAvailable() {
//		File folder = new File(System.getProperty("user.dir") +"\\DownloadCSV");
//		File[] listOfFiles = folder.listFiles();
//
//		boolean found = false;
//
//		File f = null;
//		 
//
//
//		for (File listOfFile : listOfFiles) {
//
//		 if (listOfFile.isFile()) {
//		      String fileName = listOfFile.getName();
//		       System.out.println("File " + listOfFile.getName());
//		       if (fileName.matches(DownloadCSV)) {
//		           f = new File(fileName);
//		           found = true;
//		            }
//		        }
//		    }
//		Assert.assertTrue("Downloaded document is not found",found );
//
//		f.deleteOnExit();
//	}
	
public  int ReadfileData() throws InterruptedException, CsvValidationException, IOException
	
	{
//		 file .sendKeys(System.getProperty("user.dir") + prop.getProperty("Invalid_csvfile"));
	 String file = System.getProperty("user.dir") + "\\DownloadCSV\\";
		 
	 String delimiter = ",";
     
     String line;
     int order_count=0;
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
          order_count= lines.size();   
          System.out.println("CSV FILE");
      } 
   
      catch (Exception e)
      {
          System.out.println(e);
      }
	      return (order_count);
	      
}



public  int  ReadXLdata() throws Exception
{
	 String file = System.getProperty("user.dir") + "\\DownloadCSV\\statement.xlsx";
	
    FileInputStream fis = new FileInputStream(file);
    XSSFWorkbook workbook = new XSSFWorkbook(fis);
    XSSFSheet sheet = workbook.getSheet("Invoices");
    XSSFRow row = sheet.getRow(0);
    int colNum = row.getLastCellNum();
    System.out.println("XLSX File");
    System.out.println("Total Number of Columns in the excel is : "+colNum);
    int rowNum = sheet.getLastRowNum();
    System.out.println("Total Number of Rows in the excel is : "+rowNum);
	return rowNum;
	
}

	}
	
	

