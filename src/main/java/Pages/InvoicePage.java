package Pages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import SRSproject.SRSproject.BasePage;

public class InvoicePage extends BasePage{
	
	WebDriverWait wait;
	WebDriver driver;
	Actions act;
	
	@FindBy(xpath="//a[text()='Invoice History']") WebElement InvoiceBtn;
    @FindBy(xpath="//select[@title='Per page']") WebElement pagesdropdwn;
	@FindBy(xpath ="//span[@class='label label-default']") WebElement noofProd ; 
	@FindBy(xpath ="//span[text()='Download CSV']")WebElement Downloadfile ;
	@FindBy(xpath="(//input[@name='view'])[1]") WebElement Checkbox1;
	@FindBy(xpath="(//input[@name='view'])[2]") WebElement Checkbox2;
	@FindBy(xpath="(//input[@name='view'])[3]") WebElement Checkbox3;
	@FindBy(xpath="//*[@id=\"invoices-counter\"]") WebElement InvoiceCounter ; 
	@FindBy(xpath = "(//a[@href='javascript:void(0);'])[1]") WebElement Invoiceno ; 
	@FindBy(css = "main#maincontent>div:nth-of-type(3)>div>div:nth-of-type(3)>div:nth-of-type(2)>div>div>div>div>h3>span:nth-of-type(2)") WebElement Invoicenos;
	
	
	@FindBy(xpath="//button[@class='action primary view-button']") WebElement Viewselect_Invoice ;
	public InvoicePage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void InvoiceClk() throws Exception{
		waitUntilElementVisibility(InvoiceBtn);
		InvoiceBtn.click();	
	
	}
	
	public String  PagenationSize() {
		
		int PaginationSize = driver.findElements (By.xpath("//li[contains(@class,'footable-page visible')]//a")).size();
        String s2 = "No of Pagess : " + PaginationSize;		
		
		return s2;
	}
public String NoofLintItems() {
	String noofLineItems = noofProd.getText();
	String s1 = "No of Orders : " + noofLineItems;
	
	return s1;
		
	}
public  void dropdownorder(String  s ){
	
	Select sc = new Select(pagesdropdwn);
	sc.selectByVisibleText(s);
	System.out.println("no of lineItems afterselect dropdown :"+NoofLintItems());
	System.out.println("Pagenation size after select the dropdown :"+PagenationSize());
	
	
	
}
public void Downloadfile() throws Exception {
	waitUntilElementVisibility(Downloadfile);
	Downloadfile.click();
}
public void Checkbox() throws Exception {
	
		
	jsClick(Checkbox1);
	jsClick(Checkbox2);
	
}
	public void viewSelectInvoiceCounter() throws Exception {
		if(!Checkbox2.isSelected()) {
			String text = InvoiceCounter.getText();
			System.out.println("Invoice Counter : " + text);
			
		}else if (!Checkbox3.isSelected()) {
			String text = InvoiceCounter.getText();
			System.out.println("Invoice Counter : " +text);
			
		}
			
		
	}
	public String  Invoicenumber() throws Exception {
		String invoiceno = Invoiceno.getText();
		System.out.println(invoiceno);
		jsClick(Invoiceno);
		return invoiceno;
		
		
		
	}
	
	public String Invoicenumbers() {
		String text = Invoicenos.getText();
		System.out.println(text);
		return text;
	}
	
	

	
}
