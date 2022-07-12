package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class Reorder_Page extends BasePage {

	WebDriverWait wait;
	WebDriver driver;
	Actions act;
	
	@FindBy(xpath="//a[@class='action upload-csv']") WebElement Uploadcsv;
	@FindBy(xpath="//input[@id='file-upload']") WebElement File;
	@FindBy(xpath="//span[text()='Upload File']") WebElement Uploadfile_btn;
	
	@FindBy(xpath="//div[@class='field product-part']") List<WebElement> LineItem_PartNo;
	
//	@FindBy(xpath="//div[@class='pad-title']")  WebElement Reorder_Name;
	@FindBy(xpath="//input[@class='input-text editable-title reorder-pad-name active']") WebElement Reorder_Name; 
	@FindBy(xpath="(//button[@title='Save & Close'])[1]") WebElement Save_btn;
	
	@FindBy(xpath="//div[@id='swal2-content']") WebElement Notification;
	@FindBy(xpath="//button[@class='swal2-close']") WebElement close_btn;
	@FindBy(xpath="//div[@class='reorderpad-help-text']/following-sibling::a[1]") WebElement CreateNew_Pad;
	
	@FindBy(xpath="(//input[@id='id-items0sku'])[1]") WebElement Product_input;
	
	@FindBy(xpath="(//div[@class='pad-title']//a)[1]") WebElement First_List_View;
	@FindBy(xpath="//a[@href='https://qps-stg2.heritagepoolplus.com/reorder-pads/index/detail/?id=3636']") WebElement Click_view ; 
	@FindBy(xpath="(//button[@title='Add All Items To Cart'])[1]") WebElement Add_All_Items_btn;
	
	@FindBy(xpath = "//p[text()=' Items have been successfully added to your Cart']") WebElement Success_msg;
	@FindBy(xpath = "(//span[text()='View Cart'])[2]") WebElement view_cart;
	@FindBy(css = "body > div.swal2-container.swal2-center.swal2-fade.swal2-shown > div > div.swal2-header > button") WebElement Pop_close;
	@FindBy(css ="body > div.modals-wrapper > aside.modal-popup.message-modal-container._show > div.modal-inner-wrap > header > button") WebElement close;
//	@FindBy(css="html>body>div:nth-of-type(2)>aside:nth-of-type(22)>div:nth-of-type(2)>footer>button:nth-of-type(2)>span") WebElement Proceed_Btn ;
	@FindBy(xpath = "(//button[@class='action-primary'])[2]") WebElement Proceed_Btn ;
	@FindBy(xpath="//a[@class='account-header']") WebElement Account;
	@FindBy(xpath="//input[@id='header-email']") WebElement LoginEmail;
	@FindBy(xpath="//input[@title='Password']") WebElement Password;
	@FindBy(xpath="//button[@class='action login primary']") WebElement Singin;
	@FindBy(xpath="//a[@class='logout-link']") WebElement SingOut;
	@FindBy(xpath="(//span[text()='Delete Reorder Pad'])[1]") WebElement DeleteBtn;
	@FindBy(xpath="//input[@type='checkbox']") WebElement toggle;
	@FindBy(xpath="(//select[@class='reorder-pad-list'])[1]")WebElement addingReorderpad;
	@FindBy(xpath="(//h1[@class='modal-title'])[2]") WebElement productheading;
	@FindBy(xpath="//button[@class='action primary add-to-reorder-pad']") WebElement AddtoReorderpad;
	@FindBy(xpath="(//button[@class='action cancel']/following-sibling::button)[2]") WebElement keepshoping;
	@FindBy(xpath="//button[@class='action primary add-to-reorder-pad']") WebElement PDPReorderpad ; 
	@FindBy(xpath ="//select[@class='reorder-pad-list']") WebElement addreorderpadPdp ;
	@FindBy(xpath ="(//button[@class='action primary add-to-reorder-pad'])[2]") WebElement keepshopingPdp ;
	@FindBy(xpath="(//h1[@class='modal-title'])[4]") WebElement productheadingpdp;
	@FindBy(xpath="(//button[@class='action remove'])[3]") WebElement productDlt ;
	@FindBy(xpath = "(//div[@class='field product-your_price'])[1]") WebElement FirstProduct_UOM;
	@FindBy(xpath = "(//div[@class='field product-your_price'])[2]")  WebElement SecondProduct_UOM;
	@FindBy(xpath = "//button[@class='action-add-new-line']") WebElement Add_New_lineItem;
	@FindBy(xpath="(//input[@id='id-items1sku'])[1]") WebElement Product2_input;
	
	public Reorder_Page(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	public MyAccountPage Fileupload() throws InterruptedException
	
{
		
	
		 Thread.sleep(5000);
		 Uploadcsv.click();
		Thread.sleep(3000);
		
		File.sendKeys(System.getProperty("user.dir") + prop.getProperty("valid_csvfile"));

		
		
		Thread.sleep(3000);
		
		Uploadfile_btn.click();
		return new MyAccountPage(driver);
	
}
	
	public MyAccountPage Invalid_Fileupload() throws InterruptedException
	
	{
			
		
			 Thread.sleep(5000);
			 Uploadcsv.click();
			Thread.sleep(3000);
			File.sendKeys(System.getProperty("user.dir") + prop.getProperty("Invalid_csvfile"));
//			File.sendKeys(prop.getProperty("Invalid_csvfile"));

			
			
			Thread.sleep(3000);
			
			Uploadfile_btn.click();
			return new MyAccountPage(driver);
		
	}
	
	public ArrayList<String> GetLineItme() throws InterruptedException
	
{
		 
		 
		List<WebElement> list1= LineItem_PartNo;
		ArrayList<String> a1= new ArrayList<String>();
		for (WebElement option:list1)
		{
			String text= option.getText();
			
			a1.add(text);
			
		}
		return a1;
}
	
public  WebElement ReorderNameField() 
	
	{
	
  return Reorder_Name;
	}

	
	public  WebElement Save_button() 
	
	{
		return Save_btn;
	}
	
	public WebElement Proceed_Btn() throws Exception {
		jsClick(Proceed_Btn);
		return Proceed_Btn ;
	}
	
	
	
public String  ItemsNotAdded_Notification() 
	
	{
		return Notification.getText();
	}

public  void close_button_click() 

{
close_btn.click();
}

public  WebElement Create_New_ReorderPad() 

{
	return CreateNew_Pad;
}

public  void EnterProduct() throws InterruptedException 

{
	 Product_input.sendKeys(prop.getProperty("KeywordSearch"));

		Thread.sleep(8000);
//		WebElement Item=driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/div[1]/div[2]/form/div[4]/fieldset/div[2]/div/ul[1]/li[1]/a"));
		WebElement Item=driver.findElement(By.xpath("(//li[@class='ui-menu-item']//span)[1]"));	
		Thread.sleep(1000);
//		WebDriverWait wait = new WebDriverWait(driver, 2000);
//			wait.until(ExpectedConditions.visibilityOf(Item));
			Item.click();
		Thread.sleep(1000);
	
}

public  WebElement  View_Click() 

{
	First_List_View.click();
	return First_List_View;
}

public  WebElement Add_All_Items() 

{
	return Add_All_Items_btn;
}

public  String Items_addtocart_msg() throws InterruptedException 

{
	
	return Success_msg.getText();
	
}

public  WebElement PopUp_Closebutton() 

{
	return Pop_close;
}

public  WebElement Closebutton() 

{
	return close;
}
public void ReorderPadLogin_usingview_and_edit_access() throws InterruptedException

{
	
	Thread.sleep(8000);
  act= new Actions(driver);

		//wait = new WebDriverWait(driver,30);
	//	wait.until(ExpectedConditions.visibilityOf(Account));
		act.moveToElement(Account).build().perform();
	LoginEmail.sendKeys(prop.getProperty("Reorderpad_view_editLogin_email"));
	Password.sendKeys(prop.getProperty("Reorderpad_view_editLogin_pswd"));
	Singin.click();
	
}

public void ReorderPadLogin_usingview_access() throws InterruptedException

{
	
	Thread.sleep(8000);
  act= new Actions(driver);

		//wait = new WebDriverWait(driver,30);
	//	wait.until(ExpectedConditions.visibilityOf(Account));
		act.moveToElement(Account).build().perform();
	LoginEmail.sendKeys(prop.getProperty("Reorderpad_view_Login_email"));
	Password.sendKeys(prop.getProperty("Reorderpad_view_Login_pswd"));
	Singin.click();
	
}

public void ReorderPadLogin_withoutview_Edit_access() throws InterruptedException

{
	
	Thread.sleep(8000);
  act= new Actions(driver);

		//wait = new WebDriverWait(driver,30);
	//	wait.until(ExpectedConditions.visibilityOf(Account));
		act.moveToElement(Account).build().perform();
	LoginEmail.sendKeys(prop.getProperty("Reorderpad_noacess_Login_email"));
	Password.sendKeys(prop.getProperty("Reorderpad_noacess_Login_pswd"));
	Singin.click();
	
}
public  WebElement Deletebutton() 

{
	return DeleteBtn;
}
public  WebElement Acesstoggle() 

{
	return toggle;
}
public WebElement ViewCart() {
	
	return view_cart;
}
	
public WebElement AddReorderpad() {
	Select reorderlist = new Select(addingReorderpad);
	reorderlist.selectByValue(prop.getProperty("Reorder_List_Value1"));
	return addingReorderpad;

}
public void Addreorderpad1() throws InterruptedException {
	

		addingReorderpad.isDisplayed();
		Select reorderlist = new Select(addingReorderpad);
		reorderlist.selectByValue(prop.getProperty("Reorder_List_Value1"));
	
		
		
		
	}
		
	

public WebElement AddReorderpadpdp() {
	Select reorderlist = new Select(addreorderpadPdp);
	reorderlist.selectByValue(prop.getProperty("Reorder_List_Value1"));
	return addreorderpadPdp;

}
public WebElement addreorderpadPdpenble() {

	return addreorderpadPdp;

}
public WebElement Productheading_verify() {
	
	return productheading;

}
public void Add_to_reorderpad() {
	AddtoReorderpad.click();
}
public void KeepShopping() {
	keepshoping.click();
}

public void pdpReorderpad() {
	PDPReorderpad.click();
}


public void AddreorderpadPdp() {
	addreorderpadPdp.click();
}

public String Productheadingpdp_verify() {
	
	return productheadingpdp.getText();

}

public void KeepShoppingpdp() {
	
	keepshopingPdp.click();
}
public WebElement uploadbtn() {
	return Uploadcsv;
}

public  WebElement ProductInput() 

{
	return Product_input;
	
}
public void Productdelete() throws InterruptedException {

		scrollUpandDownUsingElement(Add_All_Items_btn);
		Thread.sleep(3000);
		productDlt.isDisplayed();
		
		productDlt.click();
		System.out.println("delete is present ");
	
		
	
	
}

public WebElement  First_Product_UOM()
{
	return FirstProduct_UOM;
}

public WebElement  Second_Product_UOM()
{
	return SecondProduct_UOM;
}
public  void Enter_LegacyPartNo() throws InterruptedException 

{
	Add_New_lineItem.click();
	 Product2_input.sendKeys(prop.getProperty("Legacy_PartNo"));

		Thread.sleep(8000);
//		WebElement Item=driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/div[1]/div[2]/form/div[4]/fieldset/div[2]/div/ul[1]/li[1]/a"));
		WebElement Item=driver.findElement(By.xpath("(//li[@class='ui-menu-item']//a)[1]"));	
		
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.visibilityOf(Item));
			Item.click();
		Thread.sleep(5000);
	
}

}