package Pages;

import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencsv.exceptions.CsvValidationException;

import SRSproject.SRSproject.BasePage;

public class InvoicePage extends BasePage{
	
	WebDriverWait wait;
	WebDriver driver;
	Actions act;
	@FindBy(xpath="//li[@data-page='next']") WebElement Next_btn;
	@FindBy(xpath="//a[text()='Invoice History']") WebElement InvoiceBtn;
    @FindBy(xpath="//select[@title='Per page']") WebElement pagesdropdwn;
	@FindBy(xpath ="//span[@class='label label-default']") WebElement noofProd ; 
	@FindBy(xpath ="//span[text()='Download CSV']")WebElement Downloadfile ;
	@FindBy(xpath="(//input[@name='view'])[1]") WebElement Checkbox1;
	@FindBy(xpath="(//input[@name='view'])[2]") WebElement Checkbox2;
	@FindBy(xpath="(//input[@name='view'])[3]") WebElement Checkbox3;
	@FindBy(xpath="//*[@id=\"invoices-counter\"]") WebElement InvoiceCounter ; 
	@FindBy(xpath = "(//a[@href='javascript:void(0);'])[1]") WebElement Invoiceno ; 
	@FindBy(xpath = "//span[@data-bind='text: invoiceDetails.invoiceHeader.invoiceNumber']") WebElement Invoicenos;
	@FindBy(xpath="(//input[@type='text'])[4]") WebElement InvoiceSearch ;
	@FindBy(xpath="//button[@id='filters-apply']") WebElement FindInvoice ;
	@FindBy(xpath="//a[@href='javascript:void(0);']") WebElement AftersearchResultInvoiceNo;
    @FindBy(xpath="//td[@class='column column--PONumber']") WebElement POName ;
    @FindBy(xpath="(//a[@href='javascript:void(0);'])[3]") WebElement InvoiceNoforSearch;
    @FindBy(xpath="(//td[@class='column column--PONumber'])[3]")WebElement PoNames ;

    @FindBy(xpath="//li[@data-page='next']") WebElement Nextbtn ;
    @FindBy(xpath="//td[@class='column column--InvoiceNumber']") List<WebElement> Invoice ;
    @FindBy(xpath="//td[@class='column column--InvoiceNumber']") List<WebElement> Invoicehistory ;
    @FindBy(xpath="//button[@id='view-orders']") WebElement view_orders;
    
    @FindBy(xpath="//span[text()='Invoice History']") WebElement Invoicetitle ;
   @FindBy(xpath = "//span[text()='Download XLSX']")WebElement DownloadXLSX ; 
 

    
    @FindBy(xpath="//span[text()='Go back']") WebElement Go_Back;
    @FindBy(xpath="//span[text()='Invoice # ']") List<WebElement> invoicee;
    @FindBy(xpath="//select[@id='select-reorder-pad']") WebElement Reorderpad ;
	@FindBy(xpath="//button[@class='action primary add-to-reorder-pad']") WebElement Addtoreorderpad;
	@FindBy(xpath="//button[@class='action primary view-button']") WebElement Viewselect_Invoice ;
	@FindBy(xpath ="(//button[@class='action primary add-to-reorder-pad'])[2]") WebElement keepshopinginvce ;
	public InvoicePage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement InvoiceClk() throws Exception{
		waitUntilElementVisibility(InvoiceBtn);
		return InvoiceBtn;	
	
	}
	
	public String  PagenationSize() {
		
		List<WebElement> findElements = driver.findElements (By.xpath("//li[contains(@class,'footable-page visible')]//a"));
		int PaginationSize = findElements.size();
        String s2 = "No of Pagess : " + PaginationSize;		
		
		return s2;
	}
public String NoofLintItems() {
	String noofLineItems = noofProd.getText();
	String s1 =noofLineItems;
	
	return s1;
		
	}
public  void dropdownorder(String  s ){
	
	Select sc = new Select(pagesdropdwn);
	sc.selectByVisibleText(s);

	
	
	
}
public void Downloadfile() throws Exception {
	waitUntilElementVisibility(Downloadfile);
	Downloadfile.click();
}
public void Checkbox() throws Exception {
	
		
	jsClick(Checkbox1);
	jsClick(Checkbox2);
	
}
public void viewSelectInvoiceCounters() throws Exception {
Thread.sleep(5000);
List<WebElement> list1= Invoice;
ArrayList<String> a1= new ArrayList<String>();
for (WebElement option:list1)
{
	String text= option.getText();
	
	a1.add(text);
	
}

int Total_order = a1.size();
if(Total_order>=4)
{
	Checkbox1.click();
	Checkbox2.click();
	Checkbox3.click();
 scrollUpandDownUsingElement(Viewselect_Invoice);
 
 Viewselect_Invoice.click();


}

else
{
	Checkbox1.click();
 scrollUpandDownUsingElement( Viewselect_Invoice);
 
 Viewselect_Invoice.click();


}
}
public int Invoicecount() throws Exception {

	
	
	 Thread.sleep(5000);
	List<WebElement> orderlist=  invoicee;
	ArrayList<String> a1= new ArrayList<String>();
	for (WebElement option:orderlist)
	{
		String text= option.getText();
		
		a1.add(text);
		
	}
	
	int order_count=a1.size();
	return order_count;

}


	public String viewSelectInvoiceCounternumber () throws Exception {
		
			String text = InvoiceCounter.getText();
			System.out.println("Invoice Counter : " + text);
			return text;
			
			
		
	}
	public String  Invoicenumber() throws Exception {
		Thread.sleep(2000);
		String invoiceno = Invoiceno.getText();
		System.out.println(invoiceno);
		jsClick(Invoiceno);
		return invoiceno;
		
		
		
	}
	public String InvoiceCounter() {
		String text = InvoiceCounter.getText();
		System.out.println(text);
		return text;
	}
	
	public String Invoicenumbers() {
		String text = Invoicenos.getText();
		System.out.println(text);
		return text;
	}
	
	public WebElement InvoiceSearch() {
		return InvoiceSearch;
	
	}

	public WebElement ClickFindIvoiceSearch() {
		
		return FindInvoice;
	
	
	
	}
	
	public WebElement DownloadExcel() {
		return DownloadXLSX ;
	}

	public WebElement AfterSearchInvoiceNo() {
		
		return AftersearchResultInvoiceNo;

	}
	public void Second_Page_Listing() throws Exception
	{
		
		 
		 Thread.sleep(5000);
		List<WebElement> list1= Invoicehistory;
		ArrayList<String> a1= new ArrayList<String>();
		for (WebElement option:list1)
		{
			String text= option.getText();
			
			a1.add(text);
			
		}
		int size= a1.size();	
		
if (size>=10)
{
	scrollUpandDownUsingElement(Nextbtn);
	Nextbtn.click();

	 Thread.sleep(5000);
	 scrollUpandDownUsingElement(InvoiceBtn);
	 Checkbox1.click();
	 scrolltoTopPage();
	 jsClick(Viewselect_Invoice);
	
}

else
{
	scrollUpandDownUsingElement(InvoiceBtn);
	Checkbox1.click();
	Viewselect_Invoice.click();
	System.out.print("Consist of Less than 10 open orders");
	}

	}
	public void Second_Page_Listing1() throws Exception{

	try {
		Thread.sleep(1500);
		Nextbtn.isDisplayed();
		jsClick(Nextbtn);
		Checkbox1.click();
	}
	catch (NoSuchElementException e) {
System.out.print("Consist of Less than 10 open orders");
}
	}

	
public WebElement PoName() {
		
		return POName;

	}
	public String InvoicenumberSearch() {
		String text = InvoiceNoforSearch.getText();
		return text;
	}
	
	public String POSearch() {
		
		String text = PoNames.getText();
		return text;
	}
	
	public void Nextbutton() {
		Nextbtn.click();

	}
	
	public WebElement DownloadXLSX() {
		return DownloadXLSX; 
	}
	
	
	public WebElement Go_back() {
		return Go_Back; 
	}
	
public  int ReadfileData() throws InterruptedException, CsvValidationException, IOException
	
	{
//		 file .sendKeys(System.getProperty("user.dir") + prop.getProperty("Invalid_csvfile"));
	 String file = System.getProperty("user.dir") + "\\DownloadCSV\\invoice.csv";
		 
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
        
         
      } 
   
      catch (Exception e)
      {
          System.out.println(e);
      }
	      return (order_count);
}



public ArrayList<String> ListOfItem()
{
	// List<String> a1 = new ArrayList();
	 
	List<WebElement> list1= Invoice;
	ArrayList<String> a1= new ArrayList<String>();
	for (WebElement option:list1)
	{
		String text= option.getText();
		
		a1.add(text);
		
	}
	return a1;
}
public  int  ReadXLdata() throws Exception
{
	 String file = System.getProperty("user.dir") + "\\DownloadCSV\\invoice.xlsx";
	
    FileInputStream fis = new FileInputStream(file);
    XSSFWorkbook workbook = new XSSFWorkbook(fis);
    XSSFSheet sheet = workbook.getSheet("Invoices");
    XSSFRow row = sheet.getRow(0);
    int colNum = row.getLastCellNum();
    System.out.println("Total Number of Columns in the excel is : "+colNum);
    int rowNum = sheet.getLastRowNum();
    System.out.println("Total Number of Rows in the excel is : "+rowNum);
	return rowNum;
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
					List<WebElement> invoicelist=  Invoice;
					ArrayList<String> a1= new ArrayList<String>();
					for (WebElement option:invoicelist)
					{
						String text= option.getText();
						
						a1.add(text);
						
					}
					
					int invoice_count1=a1.size();
					return invoice_count1;
			}
}

public WebElement Reorderpad() {
	driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
	Select reorderlist = new Select(Reorderpad);
	reorderlist.selectByValue(prop.getProperty("Reorder_List_Value1"));
	return Reorderpad;

}

public WebElement Reorderpad1() {
	return Reorderpad;

}
public void  AddTOReorderPad() {
	Addtoreorderpad.click();
}


public void  keepshoping() {
	keepshopinginvce.click();
}

public void  ViewselectInvoice() {
	Viewselect_Invoice.click();
}

}




