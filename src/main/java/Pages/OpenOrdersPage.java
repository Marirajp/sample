package Pages;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
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

public class OpenOrdersPage extends BasePage {

	WebDriverWait wait;
	WebDriver driver;
	Actions act;
	
	int Total_order;
	
	@FindBy(xpath="//td[@class='column column--orderNumber']") List<WebElement> Openorders;
	@FindBy(xpath="//li[@data-page='next']") WebElement Next_btn;
	@FindBy(css="#order-table > tbody > tr:nth-child(1) > td.column.column--View.column--disableSort.footable-first-visible > input[type=checkbox]") WebElement First_openorder;
	@FindBy(css="#order-table > tbody > tr:nth-child(2) > td.column.column--View.column--disableSort.footable-first-visible > input[type=checkbox]") WebElement Second_Openorder;
	@FindBy(css="#order-table > tbody > tr:nth-child(3) > td.column.column--View.column--disableSort.footable-first-visible > input[type=checkbox]") WebElement Third_openorder;
	@FindBy(xpath="//button[@id='view-orders']") WebElement view_orders;
	@FindBy(xpath="//span[text()='Open Orders']") WebElement Open_orders_title;
	@FindBy(xpath="//span[text()='Order #']") List<WebElement> Orders;
	@FindBy(xpath="//span[text()='Go back']") WebElement Go_Back;
	@FindBy(xpath="//span[text()='Download CSV']") WebElement download_btn;
	@FindBy(xpath="//span[@class='label label-default']") WebElement  noofProd;
	@FindBy(xpath="//span[text()='Download XLSX']") WebElement download_xlx_btn;
	public OpenOrdersPage(WebDriver driver) 
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	
	public ArrayList<String> GetLineOrders() throws InterruptedException
	

		{
		 Thread.sleep(5000);
		List<WebElement> list1= Openorders;
		ArrayList<String> a1= new ArrayList<String>();
		for (WebElement option:list1)
		{
			String text= option.getText();
			
			a1.add(text);
			
		}
		
		
		return a1;
}

	public void Selecting_Order() throws InterruptedException
	{
		
			 Thread.sleep(5000);
			List<WebElement> list1= Openorders;
			ArrayList<String> a1= new ArrayList<String>();
			for (WebElement option:list1)
			{
				String text= option.getText();
				
				a1.add(text);
				
			}
			
		Total_order= a1.size();
		if(Total_order>=4)
		{
			First_openorder.click();
			Second_Openorder.click();
			Third_openorder.click();
			 scrollUpandDownUsingElement(Open_orders_title);
			 view_orders.click();
			
			
		}
		
		else
		{
			First_openorder.click();
			 scrollUpandDownUsingElement(Open_orders_title);
			 view_orders.click();


		}
	}
	
	
	
	
	
	public void Second_Page_Listing() throws Exception
	{
		
		 
	/*	 Thread.sleep(5000);
		List<WebElement> list1= Openorders;
		ArrayList<String> a1= new ArrayList<String>();
		for (WebElement option:list1)
		{
			String text= option.getText();
			
			a1.add(text);
			
		}
		int size= a1.size();*/
		
	
		try {
			
			
			Next_btn.isDisplayed();
	Next_btn.click();
	 Thread.sleep(5000);
	 scrollUpandDownUsingElement(Open_orders_title);
	 Thread.sleep(500);
	 First_openorder.click();
	 scrolltoTopPage();
	 view_orders.click();
}

		catch (NoSuchElementException e) {
	scrollUpandDownUsingElement(Open_orders_title);
	First_openorder.click();
	 view_orders.click();
	System.out.print("Consist of Less than 10 open orders");
	}

	}
	

public int Orders() throws Exception {

	
	
	 Thread.sleep(5000);
	List<WebElement> orderlist=  Orders;
	ArrayList<String> a1= new ArrayList<String>();
	for (WebElement option:orderlist)
	{
		String text= option.getText();
		
		a1.add(text);
		
	}
	
	int order_count=a1.size();
	return order_count;

}

public WebElement Go_back() {
	return Go_Back; 
}

public void Downloadfile() throws InterruptedException 
{
	download_btn.click();
	Thread.sleep(5000);
}


public  int Read_DownloadedfileData() throws InterruptedException, CsvValidationException, IOException

{
//	 file .sendKeys(System.getProperty("user.dir") + prop.getProperty("Invalid_csvfile"));
 //String file = System.getProperty("user.dir") + prop.getProperty("downloaded_file");
 String filePath = System.getProperty("user.dir") + "\\DownloadCSV\\order.csv";
	 
       String delimiter = ",";
     
       String line;
       int order_count=0;
       List<String> lines = new ArrayList();
        try (BufferedReader br =  new BufferedReader(new FileReader(filePath)))
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
          
           
        } 
     
        catch (Exception e) 
        {
            System.out.println(e);
        }
	      return (order_count);
}

public int Next_button() throws InterruptedException 
{
	try {
						
			
		Next_btn.isDisplayed();
			
		String noofLineItems = noofProd.getText();
		String s1 =noofLineItems;
		System.out.println(s1);
	//	String S2	= s1.substring(7);
		String S2 = s1.substring(s1.lastIndexOf(" ")+1);
		int i=Integer.parseInt(S2);  
		
		return i;
			}
			catch (NoSuchElementException e) {
			//throw new RuntimeException("This is where you put the message"+e);
				 Thread.sleep(5000);
					List<WebElement> orderlist=  Orders;
					ArrayList<String> a1= new ArrayList<String>();
					for (WebElement option:orderlist)
					{
						String text= option.getText();
						
						a1.add(text);
						
					}
					
					int order_count1=a1.size();
					return order_count1;
			}
}



public void DownloadExcel() throws InterruptedException 
{
	download_xlx_btn.click();
	Thread.sleep(5000);
}

public  int  ReadXLdata() throws Exception
{
	 String file = System.getProperty("user.dir") + "\\DownloadCSV\\order.xlsx";
	
    FileInputStream fis = new FileInputStream(file);
    XSSFWorkbook workbook = new XSSFWorkbook(fis);
    XSSFSheet sheet = workbook.getSheet("Orders");
    XSSFRow row = sheet.getRow(0);
    int colNum = row.getLastCellNum();
    System.out.println("Total Number of Columns in the excel is : "+colNum);
    int rowNum = sheet.getLastRowNum();
    System.out.println("Total Number of Rows in the excel is : "+rowNum);
	return rowNum;
}



}