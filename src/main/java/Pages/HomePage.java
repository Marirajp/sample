package Pages;


import java.util.List;
import java.util.Set;
import java.util.Iterator;

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

public class HomePage extends BasePage {
	
	WebDriverWait wait;
	WebDriver driver;
	Actions act;
	
	@FindBy(xpath="//a[@class='logo']") WebElement HomeLink;
	
	@FindBy(xpath="//span[text()='Shop Products']") WebElement ShopProducts;
	
	@FindBy(xpath="/html/body/div[1]/main/div[3]/div/section/div/div[1]/div[2]/a/div[2]/span") WebElement FirstCategory;
	
	@FindBy(xpath="(//a[text()='Locations'])[1]") WebElement Locations;
	
	@FindBy(xpath="/html/body/div[1]/main/div[3]/div/section/div/div[1]/div[1]/a/div[2]/span") WebElement SecondCategory;
	
	@FindBy(xpath="/html/body/div[1]/main/div[3]/div/section/div/div[1]/div[1]/a/div[2]/span") WebElement ThirdCategory;
	
	@FindBy(xpath="//span[text()='Brands']") WebElement BrandsHeader;
    
	@FindBy(className = "ambrands-letter letter-B" ) WebElement B_Aplhabet;
    
	@FindBy(xpath="(//a[@class='ambrands-inner'])[1]") WebElement Brand;
	//PCS and QPS
//	@FindBy(xpath="//a[@id='ui-id-6']") WebElement FirstLayerCategory;
	//Aqua,PEP
	@FindBy(xpath="(//a[@role='menuitem'])[2]") WebElement FirstLayerCategory;
//	QPS
//	@FindBy(xpath="//span[text()='Water Tubes & Air Pillows']") WebElement SecondLayerCategory;
//	PCS
//	@FindBy(xpath="//span[text()='Above Ground Pumps']") WebElement SecondLayerCategory;
	//aqua,PEP
	@FindBy(xpath="//span[text()='Bulk Chemicals']") WebElement SecondLayerCategory;
	@FindBy(xpath="//button[text()='Change Branch']") WebElement ChangeBranch;
	
	@FindBy(xpath="//button [text()='Change Ship To']") WebElement ChangeShipTo;
	
	@FindBy(xpath="//select[@id='branches']") WebElement ChangeBranchSelection;
	
	@FindBy(xpath="(//button[@class='action primary'])[6]") WebElement Confirm;
	///html/body/div[9]/aside[7]/div[2]/footer/button[1]/span
//	@FindBy(xpath="//*[@id='branches']/option[2]") WebElement YourBranch;
	
	//PCS
//	@FindBy(xpath="//span[text()='POOL CONTRACTORS SUPPLY  BATON ROUGE']") WebElement YourBranch;
	
	//QPS
//	@FindBy(xpath="//span[text()='QUALITY POOL SUPPLY AKRON']") WebElement YourBranch;
	//Aqua_gon
	@FindBy(xpath="//span[@class='customer-header-panel-item-value']") WebElement YourBranch;
	
	//PEP
//		@FindBy(xpath="//span[text()='POOL & ELECTRICAL PRODUCTS PHOENIX']") WebElement YourBranch;
	
	
//	"/html/body/div[2]/div[1]/div/div/div[1]/div[1]/ul/li[1]/span"
//	@FindBy(xpath="//select[@name='shipto']") WebElement Shipto_opt;
	
	//PCS
	@FindBy(xpath="//select[@name='shipto']") WebElement Shipto_opt;
	
//	@FindBy(xpath="/html/body/div[9]/aside[5]/div[2]/footer/button[1]/span") WebElement  shiptoConfirm;
	
//	@FindBy(xpath="//button[text()='Change Branch']") WebElement  shiptoConfirm;
	@FindBy(xpath="(//button[@class='action primary'])[5]") WebElement  shiptoConfirm;
	
//	@FindBy(xpath="(//span[@class='customer-header-panel-item-value'])[4]") WebElement YourShipto;
	//pcs
//		@FindBy(xpath="(//span[text()='MALONE CONSTRUCTION ENTERPRISE,9113 BELLE FLEURS COVE,CORDOVA,TN,38018']") WebElement YourShipto;
	//Aqua
	@FindBy(xpath="(//span[@class='customer-header-panel-item-value'])[4]") WebElement YourShipto;
	//PEP //div[@class='customer-header-panel-item']//span[1]
//	@FindBy(xpath="(//span[text()='TRIBAL WATERS,2630 W. DEER VALLEY RD,PHOENIX,AZ,85027']") WebElement YourShipto;
	//div[text()='']
    @FindBy(id = "search") WebElement SearchField; 
    
    @FindBy(xpath ="//strong[@class='product name product-item-name ']") List<WebElement> lineItemList;
    
    
    @FindBy(xpath ="//div[@class='klevu-name']") List<WebElement> lineItemListauto;
    
    @FindBy(xpath="/html/body/div[1]/footer/div/div[1]/div/div/div/div/div[1]/div[1]/ul/li/a") WebElement BecomeACustomer_Footer;
    
    @FindBy(xpath="//a[text()='Sitemap']") WebElement SiteMapLink;
    
    @FindBy(xpath="//a[text()='Terms & Conditions of Sale']") WebElement TermsLink;
    
    @FindBy(xpath="//a[@class='account-header']") WebElement Account;
    
    @FindBy(xpath="//a[@title='Reorder Pads']") WebElement ReorderPad;
    
    @FindBy(xpath="(//input[@placeholder='Qty'])[1]") WebElement FirstItem_Qty;
    @FindBy(xpath="(//button[@title='Add to Cart'])[1]") WebElement AddToCart;
   
	@FindBy(xpath = "//input[@id='header-email']")
	WebElement LoginEmail;
	@FindBy(xpath = "//input[@title='Password']")
	WebElement Password;
	@FindBy(xpath = "//button[@class='action login primary']")
	WebElement Singin;
	@FindBy(xpath = "//span[text()='User Management']")
	WebElement UserMgmnt;
	@FindBy(xpath = "//a[@class='logout-link']")
	WebElement SignOut;
	@FindBy(xpath = "//div[@id='change-branch-modal-alert']//h3")
	WebElement confirmpopup;
	
	@FindBy(xpath = "//div[@id='change-branch-modal-alert']/h3")
	WebElement ConfirmChangeBranch;
	 @FindBy(xpath=" //span[text()='View Open Orders']") WebElement Open_Orders;
	 @FindBy(xpath="//span[text()='View Invoice History']") WebElement Invoicehistory;
	
	
	@FindBy(xpath = "//div[@class='quick-order-label']")
	WebElement QuickOrderPad;
	@FindBy(xpath = "//div[@class='quick-order-modal']")
	WebElement QuickOrderPopup;
	@FindBy(xpath = "//span[@class='price-uom'][1]") WebElement Uom;
	@FindBy(xpath="//p[text()='Our Texas based Florida Water Products & Pool & Electrical Products branches have rebranded to Texas Pool Supply!!!']") WebElement ErrorPopup ; 
	@FindBy(xpath="//a[text()=' Texas Pool Supply ']") WebElement TPS_link ;
//	@FindBy(xpath ="//span[text()='Shop Products']") WebElement Firstmousehover;
	@FindBy(xpath="(//li[@class='level1 nav-1-1 category-item first parent ui-menu-item'])[1]") WebElement secondmousehover ; 
   @FindBy(xpath="//*[@id=\"ui-id-2\"]/li[1]/ul/li[1]/ul/li[2]") WebElement third ;
   @FindBy(xpath="//*[@id=\"ui-id-2\"]/li[1]/ul/li[1]/ul/li[2]/ul/li[2]") WebElement branndclk ;
	@FindBy(xpath="(//div[@class='item-access-result'])[10]") WebElement Vieworderbox;
	@FindBy(xpath="(//div[@class='item-access-result'])[11]") WebElement Editorderbox;
   @FindBy(xpath="//button[@class='swal2-close']") WebElement CancelBtn ;
   //BRANDS
	

		@FindBy(xpath="//span[normalize-space()='Brands']")
		WebElement BrandsHeaders;
		@FindBy(xpath="//a[@title='All Brands']")
		WebElement AllBrands;
		@FindBy(xpath="//button[@class='ambrands-letter letter-A']")
		WebElement BrandsLetter_A;
		@FindBy(xpath="//span[normalize-space()='A&A Manufacturing']")
		WebElement Brand_AA;
		@FindBy(xpath="//button[@class='ambrands-letter letter-B']")
		WebElement BrandsLetter_B;
		@FindBy(xpath="//button[@data-ambrands-js='filter-letter'][normalize-space()='A']")
		WebElement Letter_A;
		@FindBy(xpath="//button[@data-ambrands-js='filter-letter'][normalize-space()='B']")
		WebElement Letter_B;
		@FindBy(xpath="//button[@data-ambrands-js='filter-letter'][normalize-space()='C']")
		WebElement Letter_C;
		@FindBy(xpath="//a[@title='Balboa']//span[@class='ambrands-empty'][normalize-space()='B']")
		WebElement Product_Balboa;
		@FindBy(xpath="//button[@data-ambrands-js='popup-filter-letter'][normalize-space()='K']")
		WebElement Letter_K;
		@FindBy(xpath="//a[@title='King']//span[@class='ambrands-label']")
		WebElement LetterK_King;
		@FindBy(xpath="//a[@title='AQP']//span[@class='ambrands-label']")
		WebElement AQP_Brand;
		
		//ABB
		@FindBy(xpath="//a[@title='ABB']//span[@class='ambrands-label']")
		WebElement ABB_Brand;
		
		@FindBy(xpath="//span[normalize-space()='Bio-Active']")
		WebElement BioActiveBrand;
		
		@FindBy(xpath="//i[@class='material-icons search__icon']")
		WebElement SearchGoButton;
		
		@FindBy(xpath="//div[@class='message notice']//div[1]")
		WebElement NotFound;
		
		//pcstoqps
		@FindBy(xpath="//strong[@class='filter-title-opened']")
		WebElement ActiveBolt;
		//peptoqps
		@FindBy(xpath="//strong[@class='filter-title-closed']")
		WebElement JainProduct;
	public HomePage(WebDriver driver)
	{
		this.driver=driver; 
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage clickOnHomeLink()
	{

				((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
				WebDriverWait wait= new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.visibilityOf(HomeLink));
				HomeLink.click();
				
		return new HomePage(driver);
	}
	
	
	public void mouseHoverToShopByCategory()
	
	{
		WebDriverWait wait= new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOf(ShopProducts));
	    act= new Actions(driver);
		act.moveToElement(ShopProducts).build().perform();
		ShopProducts.click();
	}
	
	
	public ProductListPage ClickCategory()
	{
		WebDriverWait wait= new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOf(FirstCategory));

		FirstCategory.click();
		return new ProductListPage(driver);

	}
	
	public ProductListPage ClickSecondLevelCategory()  //FIS
	{
		WebDriverWait wait= new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOf(FirstCategory));

		FirstCategory.click();
		
		
		return new ProductListPage(driver);

	 }
	
	public String mouseHoverSelectCategory() throws InterruptedException
	 {
		
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ShopProducts));
		    act= new Actions(driver);
			act.moveToElement(ShopProducts).build().perform();
			
			act.moveToElement(secondmousehover).build().perform();
			
			act.moveToElement(third).build().perform();
			
			branndclk.click();
			
			return driver.getTitle();
			
	  }
	public Boolean confirmLogin() throws InterruptedException {
		Thread.sleep(5000);
		act = new Actions(driver);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(QuickOrderPad));
		act.moveToElement(QuickOrderPad).build().perform();
		Thread.sleep(5000);
		Boolean QuickOrderDisplayed = QuickOrderPopup.isDisplayed();
		System.out.println("Quick Order Popup is enabled :"+ QuickOrderDisplayed);
		act.moveToElement(QuickOrderPad).build().perform();
		return QuickOrderDisplayed;
		

	}
	 public WebElement  Locations_Link() throws InterruptedException
	
	  {
		
		Thread.sleep(8000);
		WebDriverWait wait= new WebDriverWait(driver, 120);
	    wait.until(ExpectedConditions.visibilityOf(Locations));

	 return Locations;
		

	  }
	
	
	
	public void Locations_click() throws InterruptedException
	{
		//JavascriptExecutor js = (JavascriptExecutor) driver;
	
//	 js.executeScript("arguments[0].scrollIntoView();", HomeLink);
		
		((JavascriptExecutor) driver)
	    .executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	
	  Thread.sleep(8000);
	  
	//	WebDriverWait wait= new WebDriverWait(driver, 120);
	 //  wait.until(ExpectedConditions.visibilityOf(Locations));
	   
	Locations.click();
	
	
		

	 }
	
public String BrandSelection() throws InterruptedException
	
	{
		
		 Thread.sleep(11000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	
	 js.executeScript("arguments[0].scrollIntoView();", HomeLink);
	
	   act= new Actions(driver);
	   
			act.moveToElement(BrandsHeader).build().perform();
			Thread.sleep(1000);
			Brand.click();
			Thread.sleep(500);
			
	 String brandpage = driver.getCurrentUrl();
	
	
	 System.out.println(brandpage);

	 return brandpage;
		

	}
	
	public String ChangeBranch() throws Exception
	{
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		wait.until(ExpectedConditions.visibilityOf(ChangeBranch));
		ChangeBranch.click();
		
//		Thread.sleep(1000);
		waitUntilElementVisibility(ChangeBranchSelection);
		Select Brand= new Select(ChangeBranchSelection);
		//for PCS
//		Brand.selectByValue("10178");
		//for QPS
				Brand.selectByValue(prop.getProperty("changebranch_value"));
//		for PEP
//		Brand.selectByValue("10242");
		
//		 for Aquagon
//		Brand.selectByValue("10157");
//		 Thread.sleep(10000);
//		 fro FWP
//				Brand.selectByValue("10248");	
			//wait.until(ExpectedConditions.visibilityOf(Confirm));
		 
		
		
		 Confirm.click();
//		 ChangeBranch.click();
		 ((JavascriptExecutor) driver)
		 .executeScript("window.scrollTo(0, -document.body.scrollHeight)");

		 waitUntilElementVisibility(YourBranch);
		 return YourBranch.getText();
//	 
		 
	   }
	
	public String confirmChangeBranch() throws Exception {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
     waitUntilElementVisibility(ChangeBranch);
		ChangeBranch.click();

		Thread.sleep(1000);

		Select Brand = new Select(ChangeBranchSelection);
		Brand.selectByValue("10013");
		Confirm.click();
		String confirmMsg = ConfirmChangeBranch.getText();
		System.out.println(confirmMsg);
		return confirmMsg;
		
	
		
		
	}
public String confirmpopupmsge() throws Exception {
	waitUntilElementVisibility(ConfirmChangeBranch);
	String text = ConfirmChangeBranch.getText();
	return text;
	}
	public String ChangeShipTo() throws Exception
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOf(ChangeShipTo));
		ChangeShipTo.click();
		 Thread.sleep(1000);
		
		 //pcs
//		 driver.findElement(By.xpath("//div[@class='optionname']")).click();
//		driver.findElement(By.xpath("(//div[text()='MALONE CONSTRUCTION ENTERPRISE'])[1]")).click();
//		//Aqua
//		 driver.findElement(By.xpath("//div[@class='optionname']")).click();
//		driver.findElement(By.xpath("//div[text()='BAKER LANDSCAPING & CONCRETE']")).click();
		//PEP
		 driver.findElement(By.xpath("//div[text()='Choose an option']")).click();
			driver.findElement(By.xpath("//div[@data-value='1']//div[1]")).click();
//		
		//		Select shipto= new Select(Shipto_opt);
//		shipto.selectByValue("1");
//		Aqugon
//		shipto.selectByValue("1");
		 
		
		 
			wait.until(ExpectedConditions.visibilityOf(shiptoConfirm)); 
	shiptoConfirm.click();
	
	
waitUntilElementVisibility(YourShipto);
String yourshipto = YourShipto.getText();
System.out.println(yourshipto);
	return yourshipto;
	
	 	
		 
    }
	
public WebElement vieworder() {
	return Vieworderbox;
}

public WebElement editorder() {
	return Editorderbox;
}

	public void SearchByKeyword() throws InterruptedException 


	{

	SearchField.clear();
	SearchField.click();

	  SearchField.sendKeys(prop.getProperty("KeywordSearch"));
		  SearchField.sendKeys(Keys.ENTER);
		  Thread.sleep(5000);
     }




	public List<WebElement> LineItemsList()
   {
	return lineItemList;
	
    }

	public void SearchByKeyword_Autosuggestion() throws InterruptedException 
    {
	driver.navigate().refresh();

	SearchField.click();

	  SearchField.sendKeys(prop.getProperty("KeywordSearch"));
		  
		  Thread.sleep(1000);
     }

	public List<WebElement> LineItemsListAuto()
{
	return lineItemListauto;
	
}

public void SearchByPartNo_Autosuggestion() throws InterruptedException 


{
	driver.navigate().refresh();
	SearchField.clear();

SearchField.click();

	  SearchField.sendKeys(prop.getProperty("PartNoSearch"));
		  
		  Thread.sleep(1000);
}


public String BecomeACustomer_Footer_click() throws InterruptedException
{
	
	((JavascriptExecutor) driver)
     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
	

 Thread.sleep(8000);
	
BecomeACustomer_Footer.click();

Thread.sleep(1000);
return driver.getTitle();
	

}

public String Sitemap_Footer_click() throws InterruptedException
{
	
	((JavascriptExecutor) driver)
     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
	
 Thread.sleep(8000);
 SiteMapLink.click();
 Thread.sleep(2000);
	


return driver.getTitle();
	

}

public String Terms_Footer_click() throws InterruptedException
{
	
	((JavascriptExecutor) driver)
     .executeScript("window.scrollTo(0, document.body.scrollHeight)");

 Thread.sleep(8000);
 TermsLink.click();
	

 Thread.sleep(2000);
return driver.getTitle();
	

}

public void MyAccount_Hover() throws InterruptedException

{
	
	Thread.sleep(8000);
  act= new Actions(driver);

		act.moveToElement(Account).build().perform();
	
	
}

public Reorder_Page Reorder_Hover() throws InterruptedException

{
	
	Thread.sleep(2000);
  act= new Actions(driver);
 
		act.moveToElement(ReorderPad).perform();
		ReorderPad.click();
		return new Reorder_Page(driver);
	
}
public WebElement  ReorderHover() throws InterruptedException

{
	
	Thread.sleep(2000);
  act= new Actions(driver);
 
		act.moveToElement(ReorderPad).perform();
		
		return  ReorderPad;
	
}

public void ValidLogin() throws InterruptedException

{

	Thread.sleep(8000);
	act = new Actions(driver);

	// wait = new WebDriverWait(driver,30);
	// wait.until(ExpectedConditions.visibilityOf(Account));
	act.moveToElement(Account).build().perform();
	LoginEmail.sendKeys(prop.getProperty("ValidLogin_email"));
	Password.sendKeys(prop.getProperty("ValidLogin_Pswd"));
	Singin.click();

}
public void UnAuthorisedLogin() throws InterruptedException

{

	Thread.sleep(8000);
	act = new Actions(driver);

	// wait = new WebDriverWait(driver,30);
	// wait.until(ExpectedConditions.visibilityOf(Account));
	act.moveToElement(Account).build().perform();
	LoginEmail.sendKeys(prop.getProperty("unAuthorisedLogin_email"));
	Password.sendKeys(prop.getProperty("unAuthorisedLogin_Pswd"));
	Singin.click();

}
public void TPS_Login() throws InterruptedException

{

	Thread.sleep(8000);
	act = new Actions(driver);

	// wait = new WebDriverWait(driver,30);
	// wait.until(ExpectedConditions.visibilityOf(Account));
	act.moveToElement(Account).build().perform();
	LoginEmail.sendKeys(prop.getProperty("TPSLogin_email"));
	Password.sendKeys(prop.getProperty("TPSLogin_Pswd"));
	Singin.click();

}

public void InValidLogin() throws InterruptedException

{

	Thread.sleep(8000);
	act = new Actions(driver);

	// wait = new WebDriverWait(driver,30);
	// wait.until(ExpectedConditions.visibilityOf(Account));
	act.moveToElement(Account).build().perform();
	LoginEmail.sendKeys(prop.getProperty("inValidLogin_email"));
	Password.sendKeys(prop.getProperty("inValidLogin_Pswd"));
	Singin.click();

}
public LoginPage UnApprovedLogin() throws InterruptedException

{
driver.findElement(By.xpath("//button[@class='swal2-close']")).click();
	String Username = prop.getProperty("UnApprovedLogin_email");
	String Passwords = prop.getProperty("UnApprovedLogin_Pswd");

	Thread.sleep(5000);

	act = new Actions(driver);

	wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(Account));
	act.moveToElement(Account).build().perform();
	LoginEmail.clear();
	LoginEmail.sendKeys(Username);
	Password.clear();
	Password.sendKeys(Passwords);

	Singin.click();
	return new LoginPage(driver);

}

public void ValidLoginMultiBrand() throws InterruptedException

{

	Thread.sleep(8000);
	act = new Actions(driver);

	// wait = new WebDriverWait(driver,30);
	// wait.until(ExpectedConditions.visibilityOf(Account));
	act.moveToElement(Account).build().perform();
	LoginEmail.sendKeys(prop.getProperty("ValidLoginMulti_email"));
	Password.sendKeys(prop.getProperty("ValidLoginMulti_Pswd"));
	Singin.click();

}	

public String printBranchList() throws InterruptedException {
	((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
Thread.sleep(8000);
	ChangeBranch.click();

	Thread.sleep(1000);
	Select s = new Select(driver.findElement(By.xpath("//select[@name='branch']")));
	// getting the list of options in the dropdown with getOptions()
	List<WebElement> op = s.getOptions();
	int size = op.size();
	for (int i = 0; i < size; i++) {
		String options = op.get(i).getText();
		System.out.println(options);
	}

	return null;
}
public void Account_Hover() {
	wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(Account));
	act = new Actions(driver);
	act.moveToElement(Account).build().perform();

}
public String SignOut() throws Exception {
	// Accept.click();

	act = new Actions(driver);
	wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(Account));

	act.moveToElement(Account).build().perform();

//JavascriptExecutor js = (JavascriptExecutor) driver;
//
//js.executeScript("arguments[0].scrollIntoView();", ReorderPad);
	waitUntilElementVisibility(SignOut);
	SignOut.click();
	return driver.getTitle();

}

public CompanyUsersPage ClickUserManagement() {

	UserMgmnt.click();
	return new CompanyUsersPage(driver);

}
public OpenOrdersPage OpenOrder_Hover() throws InterruptedException

{
	 
	Thread.sleep(2000);
  act= new Actions(driver);

		act.moveToElement(Open_Orders).perform();
		Open_Orders.click();
		return new OpenOrdersPage(driver);
	
}
public InvoicePage   Invoice_History() throws Exception

{
	 
	Thread.sleep(5000);
  act= new Actions(driver);

		act.moveToElement(Invoicehistory).perform();
		Invoicehistory.click();
		return new InvoicePage(driver);
		
	
}
public WebElement uom() {
	return Uom ;
}
public WebElement Errorpopupmsg() {
	return ErrorPopup;
}

public WebElement TPS_redirected_link() {
	return TPS_link;
	
}

//BrandsList And AllBrands
public void mouseHoverToBrandsA() throws InterruptedException

{
	WebDriverWait wait= new WebDriverWait(driver, 20);
wait.until(ExpectedConditions.visibilityOf(BrandsHeaders));
  act= new Actions(driver);
act.moveToElement(BrandsHeaders).moveToElement(BrandsLetter_A).perform();
Thread.sleep(3000);
	//act.contextClick(BrandsLetter_B).build().perform();
	BrandsLetter_A.click();
}
public void mouseHoverToBrandsB() throws InterruptedException

{
	WebDriverWait wait= new WebDriverWait(driver, 20);
wait.until(ExpectedConditions.visibilityOf(BrandsHeaders));
  act= new Actions(driver);
act.moveToElement(BrandsHeaders).moveToElement(BrandsLetter_B).perform();
	//act.contextClick(BrandsLetter_B).build().perform();
	BrandsLetter_B.click();
	Thread.sleep(2000);
	act.moveToElement(Letter_K).click().perform();
	Thread.sleep(2000);
	act.moveToElement(BrandsLetter_B).click().perform();
	Thread.sleep(2000);
	act.moveToElement(Letter_K).click().perform();
	Thread.sleep(2000);
	act.moveToElement(LetterK_King).click().perform();
	
	
}



public void mouseHoverToallBrands() throws InterruptedException

{
	WebDriverWait wait= new WebDriverWait(driver, 20);
wait.until(ExpectedConditions.visibilityOf(BrandsHeaders));
  act= new Actions(driver);
act.moveToElement(BrandsHeaders).build().perform();
act.moveToElement(BrandsHeaders).moveToElement(AllBrands).perform();
AllBrands.click();
Thread.sleep(3000);
act.moveToElement(Letter_A).click().perform();
Thread.sleep(5000);
act.moveToElement(Letter_B).click().perform();
Thread.sleep(5000);
act.moveToElement(Product_Balboa).click().perform();
Thread.sleep(5000);
//act.moveToElement(Letter_C).click().perform();

	
}

public void ProductAvailable() throws InterruptedException {
	WebDriverWait wait= new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOf(BrandsHeaders));
	    act= new Actions(driver);
	act.moveToElement(BrandsHeaders).moveToElement(BrandsLetter_B).perform();
		//act.contextClick(BrandsLetter_B).build().perform();
		BrandsLetter_B.click();
		Thread.sleep(2000);
		act.moveToElement(Letter_K).click().perform();
		Thread.sleep(2000);
		act.moveToElement(BrandsLetter_B).click().perform();
		Thread.sleep(2000);
		act.moveToElement(Letter_K).click().perform();
		Thread.sleep(2000);
		act.moveToElement(LetterK_King).click().perform();
	
}
public WebElement Brandverify() throws InterruptedException {	

	Thread.sleep(3000);
//	WebDriverWait wait= new WebDriverWait(driver, 60);
//  wait.until(ExpectedConditions.visibilityOf(AQP_Brand));
	return AQP_Brand;
	
}
public WebElement BrandVerifyABB() throws InterruptedException {

	Thread.sleep(3000);
//	WebDriverWait wait= new WebDriverWait(driver, 120);
//  wait.until(ExpectedConditions.visibilityOf(ABB_Brand));
	return ABB_Brand;
}

public void SearchByKeywords() throws InterruptedException 


{

SearchField.clear();
SearchField.click();

SearchField.sendKeys(prop.getProperty("KeywordSearch1"));
Thread.sleep(3000);
SearchGoButton.click();
	  Thread.sleep(5000);
}
//PCS TO QPS
public void SearchByKeywordPCS() throws InterruptedException 


{

SearchField.clear();
SearchField.click();

SearchField.sendKeys(prop.getProperty("KeywordSearch2"));
Thread.sleep(3000);
SearchGoButton.click();
	  Thread.sleep(5000);
}
public void SearchByKeywordPEP() throws InterruptedException 


{

SearchField.clear();
SearchField.click();

SearchField.sendKeys(prop.getProperty("KeywordSearch3"));
Thread.sleep(3000);
SearchGoButton.click();
	  Thread.sleep(5000);
}

public WebElement ResultNotFound() {
	return NotFound;
}
public WebElement ResultNotFoundPCS() {
	return ActiveBolt;
}
public WebElement ResultNotFoundPEP() {
	return JainProduct;
}

//public WebElement Firsthover() {
//	return Firstmousehover ;
//}
public WebElement Secondhover() {
	return secondmousehover ;
}

public WebElement thrid() {
	return third ;
}

public void LegacyPartNo_Autosuggestion() throws InterruptedException 


{
	driver.navigate().refresh();
	SearchField.clear();

SearchField.click();

	  SearchField.sendKeys(prop.getProperty("Legacy_PartNo"));
		  
		  Thread.sleep(1000);
}
public WebElement Cancelbtn() {
	return CancelBtn ;
}
}