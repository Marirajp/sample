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
	
	@FindBy(id = "ui-id-4") WebElement BrandsHeader;
    
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
    
    @FindBy(xpath ="//strong[@class='product name product-item-name']") List<WebElement> lineItemList;
    
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

	
	@FindBy(xpath = "//div[@class='quick-order-label']")
	WebElement QuickOrderPad;
	@FindBy(xpath = "//div[@class='quick-order-modal']")
	WebElement QuickOrderPopup;
	
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
	
	public String mouseHoverSelectCategory()
	 {
		
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ShopProducts));
		    act= new Actions(driver);
			act.moveToElement(ShopProducts).build().perform();
			act.moveToElement(FirstLayerCategory).build().perform();
			act.moveToElement(SecondLayerCategory).click();
			SecondLayerCategory.click();
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

	String Username = prop.getProperty("UnApprovedLogin_email");
	String Passwords = prop.getProperty("UnApprovedLogin_Pswd");

	Thread.sleep(5000);

	act = new Actions(driver);

	wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(Account));
	act.moveToElement(Account).build().perform();

	LoginEmail.sendKeys(Username);
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
}