package Pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.record.PageBreakRecord.Break;

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



public class HomePage_Global extends BasePage {


	

	WebDriverWait wait;
	WebDriver driver;
	Actions act;
	@FindBy(xpath="//a[@class='logo']") WebElement HomeLink;
	
	@FindBy(xpath = "//div[@class='quick-order-label']")
	WebElement QuickOrderPad;
	@FindBy(xpath = "//div[@class='quick-order-modal']")
	WebElement QuickOrderPopup;
	
	@FindBy(xpath="//span[text()='Shop Products']") WebElement ShopProducts;
	@FindBy(xpath="//a[@id='ui-id-5']") WebElement FirstLayerCategory;
	@FindBy(xpath="//a[@id='ui-id-8']") WebElement SecondLayerCategory;
	@FindBy(xpath="/html/body/div[1]/main/div[3]/div/section/div/div[1]/div/a") WebElement FirstCategory;
	@FindBy(xpath="//a[text()='Locations']") WebElement Locations;
	@FindBy(xpath="/html/body/div[1]/main/div[3]/div/section/div/div[1]/div[1]/a/div[2]/span") WebElement SecondCategory;
	@FindBy(xpath="/html/body/div[1]/main/div[3]/div/section/div/div[1]/div[1]/a/div[2]/span") WebElement ThirdCategory;
    @FindBy(id = "ui-id-4") WebElement BrandsHeader;
    @FindBy(className = "ambrands-letter letter-B" ) WebElement B_Aplhabet;
    @FindBy(xpath="/html/body/div[2]/div[1]/header/div[2]/div/div[1]/nav/ul/li[2]/div/div/div[2]/section[1]/div/div/div[1]/a") WebElement Brand;
    @FindBy(xpath="//a[@title='become-a-customer']") WebElement BecomeACustomer_Header;
    @FindBy(xpath="(//a[text()='Become a Customer'])[3]") WebElement BecomeACustomer_Footer;
    @FindBy(xpath="//a[text()='Sitemap']") WebElement SiteMapLink;
    @FindBy(xpath="//a[text()='Terms & Conditions of Sale']") WebElement TermsLink;
    @FindBy(xpath="(//a[text()='Register Now'])[1]") WebElement RegisterNow;
    @FindBy(xpath="(//strong[text()='Login'])[1]")  WebElement AddToCart;
    @FindBy(xpath="(//span[@class='product-image-wrapper'])[1]") WebElement GuestMessage;
    @FindBy(id = "search") WebElement SearchField; 
    
    @FindBy(xpath ="//strong[@class='product name product-item-name']") List<WebElement> lineItemList;
    
    @FindBy(xpath ="//div[@class='klevu-name']") List<WebElement> lineItemListauto;
    
    @FindBy(xpath = "//a[@class='account-header']")
	WebElement Account;
	@FindBy(xpath = "//input[@id='header-email']")
	WebElement LoginEmail;
	@FindBy(xpath = "//input[@title='Password']")
	WebElement Password;
	@FindBy(xpath = "//button[@class='action login primary']")
	WebElement Signin;
	@FindBy(xpath = "//a[@class='logout-link']")
	WebElement SignOut;
    
	@FindBy(xpath = "//div[@class='swal2-content']")
	WebElement errorPopupMsg;
	@FindBy(xpath = "//button[@class='swal2-close']")
	WebElement popupClose;
	
	@FindBy(xpath="//div[@id='modal-content-1']//div") WebElement BrandSelectPopup;
	@FindBy(xpath="(//a[@class='dckap-redirect-link']//img)[2]") WebElement BrandSelectPopupPCS;
	@FindBy(xpath="(//a[@class='dckap-redirect-link']//img)[1]") WebElement BrandSelectPopupFIS;
	@FindBy(xpath="(//a[@class='dckap-redirect-link']//img)[3]") WebElement BrandSelectPopupQPS;
	@FindBy(xpath="(//a[@class='dckap-redirect-link']//img)[4]") WebElement BrandSelectPopupCPS;
    
	public HomePage_Global(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage_Global clickOnHomeLink()
	{

				((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
				WebDriverWait wait= new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.visibilityOf(HomeLink));
				HomeLink.click();
		return new HomePage_Global(driver);
	}
	
	public void mouseHoverToShopByCategory()
	{
		WebDriverWait wait= new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOf(ShopProducts));
	    act= new Actions(driver);
		act.moveToElement(ShopProducts).build().perform();
		ShopProducts.click();
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
		//FIS
	/*	wait.until(ExpectedConditions.visibilityOf(SecondCategory));
		SecondCategory.click();*/
	
		
		
		//ThirdCategory.click();
		
		return new ProductListPage(driver);

	}
	
	public WebElement  Locations_Link() throws InterruptedException
	{
		
		Thread.sleep(8000);
		WebDriverWait wait= new WebDriverWait(driver, 120);
	wait.until(ExpectedConditions.visibilityOf(Locations));

	
	
	return Locations;
		

	}
	
	
	
	public StoreLocatorPage Locations_click() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
	
	 js.executeScript("arguments[0].scrollIntoView();", HomeLink);
	//	WebDriverWait wait= new WebDriverWait(driver, 20);
//	wait.until(ExpectedConditions.visibilityOf(Locations));

	 Thread.sleep(8000);
		WebDriverWait wait= new WebDriverWait(driver, 120);
	wait.until(ExpectedConditions.visibilityOf(Locations));
	Locations.click();
	
	return new StoreLocatorPage(driver);
		

	}
	
	public String BrandSelection() throws InterruptedException
	{
		
		 Thread.sleep(11000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	
	 js.executeScript("arguments[0].scrollIntoView();", HomeLink);
	
	// BrandsHeader.click();
	   act= new Actions(driver);
	   
			act.moveToElement(BrandsHeader).build().perform();
			Thread.sleep(1000);
			Brand.click();
			Thread.sleep(500);
			
	 String brandpage = driver.getCurrentUrl();
	
	
System.out.println(brandpage);

return brandpage;
		

	}
	

	public String BecomeACustomer_Header_click() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
	
	 js.executeScript("arguments[0].scrollIntoView();", HomeLink);
	//	WebDriverWait wait= new WebDriverWait(driver, 20);
//	wait.until(ExpectedConditions.visibilityOf(Locations));

	 Thread.sleep(8000);
		
	BecomeACustomer_Header.click();
	
	return driver.getTitle();
		

	}
	
	
	public String BecomeACustomer_Footer_click() throws InterruptedException
	{
		
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
		

	 Thread.sleep(8000);
		
	BecomeACustomer_Footer.click();
	
	return driver.getTitle();
		

	}
	
	public String Sitemap_Footer_click() throws InterruptedException
	{
		
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
	 Thread.sleep(8000);
	 SiteMapLink.click();
		
	
	
	return driver.getTitle();
		

	}
	
	public String Terms_Footer_click() throws InterruptedException
	{
		
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
	
	 Thread.sleep(8000);
	 TermsLink.click();
		
	
	
	return driver.getTitle();
		

	}
	
	public String Banner_RegisterNow_click() throws InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		 js.executeScript("arguments[0].scrollIntoView();", ShopProducts);
	
	 Thread.sleep(8000);
	 RegisterNow.click();
		
	
	
	return driver.getCurrentUrl();
		

	}
	
	public WebElement AddToCart_click() throws InterruptedException
	{
		
		Thread.sleep(800);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		 js.executeScript("arguments[0].scrollIntoView();", GuestMessage);	
	
	 

	
		
	
	
	return AddToCart;
		

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
		  
		  Thread.sleep(500);
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
		  
		  Thread.sleep(500);
}


public String ValidLoginPCS() throws InterruptedException

{

	String PCS_Username = prop.getProperty("ValidLoginPCS_email");
	String PCS_Password = prop.getProperty("ValidLoginPCS_Pswd");

	Thread.sleep(5000);

	act = new Actions(driver);

	wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(Account));
	act.moveToElement(Account).build().perform();

	LoginEmail.sendKeys(PCS_Username);
	Password.sendKeys(PCS_Password);

	Signin.click();
	return driver.getTitle();

}


public LoginPage UnApprovedLoginPCS() throws InterruptedException

{

	String PCS_Username = prop.getProperty("UnApprovedLoginPCS_email");
	String PCS_Password = prop.getProperty("UnApprovedLoginPCS_Pswd");

	Thread.sleep(5000);

	act = new Actions(driver);

	wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(Account));
	act.moveToElement(Account).build().perform();

	LoginEmail.sendKeys(PCS_Username);
	Password.sendKeys(PCS_Password);

	Signin.click();
	return new LoginPage(driver);

}

public String UnApprovedLoginMultiBrandPCS() throws InterruptedException

{

	String PCS_Username = prop.getProperty("UnApprovedLoginMultiPCS_email");
	String PCS_Password = prop.getProperty("UnApprovedLoginMultiPCS_Pswd");

	Thread.sleep(5000);

	act = new Actions(driver);

	wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(Account));
	act.moveToElement(Account).build().perform();

	LoginEmail.sendKeys(PCS_Username);
	Password.sendKeys(PCS_Password);
	Signin.click();
	return driver.getTitle();
			

}

public String ValidLoginFIS() throws InterruptedException

{

	String FIS_Username = prop.getProperty("ValidLoginFIS_email");
	String FIS_Password = prop.getProperty("ValidLoginFIS_Pswd");

	Thread.sleep(5000);

	act = new Actions(driver);

	wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(Account));
	act.moveToElement(Account).build().perform();

	LoginEmail.sendKeys(FIS_Username);
	Password.sendKeys(FIS_Password);

	Signin.click();
	return driver.getTitle();

}

public String ValidLoginMultiBrandFIS() throws InterruptedException

{

	String FIS_Username = prop.getProperty("ValidLoginMulti_email");
	String FIS_Password = prop.getProperty("ValidLoginMulti_Pswd");

	Thread.sleep(5000);

	act = new Actions(driver);

	wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(Account));
	act.moveToElement(Account).build().perform();
	Thread.sleep(1000);
	LoginEmail.sendKeys(FIS_Username);
	Password.sendKeys(FIS_Password);
	Signin.click();
	//wait = new WebDriverWait(driver, 30);
	//wait.until(ExpectedConditions.visibilityOf(BrandSelectPopup));
	Thread.sleep(5000);
	BrandSelectPopupFIS.click();
	return driver.getTitle();
	

}

public String UnApprovedLoginFIS() throws InterruptedException

{

	String FIS_Username = prop.getProperty("UnApprovedLoginFIS_email");
	String FIS_Password = prop.getProperty("UnApprovedLoginFIS_Pswd");

	Thread.sleep(5000);

	act = new Actions(driver);

	wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(Account));
	act.moveToElement(Account).build().perform();

	LoginEmail.sendKeys(FIS_Username);
	Password.sendKeys(FIS_Password);

	Signin.click();
	return driver.getTitle();

}

public String UnApprovedLoginMultiBrandFIS() throws InterruptedException

{

	String FIS_Username = prop.getProperty("UnApprovedLoginMultiFIS_email");
	String FIS_Password = prop.getProperty("UnApprovedLoginMultiFIS_Pswd");

	Thread.sleep(5000);

	act = new Actions(driver);

	wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(Account));
	act.moveToElement(Account).build().perform();

	LoginEmail.sendKeys(FIS_Username);
	Password.sendKeys(FIS_Password);
	Signin.click();
	return driver.getTitle();
			

}

public String ValidLoginQPS() throws InterruptedException

{

	String QPS_Username = prop.getProperty("ValidLoginQPS_email");
	String QPS_Password = prop.getProperty("ValidLoginQPS_Pswd");

	Thread.sleep(5000);

	act = new Actions(driver);

	wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(Account));
	act.moveToElement(Account).build().perform();

	LoginEmail.sendKeys(QPS_Username);
	Password.sendKeys(QPS_Password);

	Signin.click();
	return driver.getTitle();
	

}

public String ValidLoginPEP() throws InterruptedException

{

	String PEP_Username = prop.getProperty("ValidLoginPEP_email");
	String PEP_Password = prop.getProperty("ValidLoginPEP_Pswd");

	Thread.sleep(5000);

	act = new Actions(driver);

	wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(Account));
	act.moveToElement(Account).build().perform();

	LoginEmail.sendKeys(PEP_Username);
	Password.sendKeys(PEP_Password);

	Signin.click();
	return driver.getTitle();
	

}
public String ValidLoginAgon() throws InterruptedException

{

	String Agon_Username = prop.getProperty("ValidLoginAgon_email");
	String Agon_Password = prop.getProperty("ValidLoginAgon_Pswd");

	Thread.sleep(5000);

	act = new Actions(driver);

	wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(Account));
	act.moveToElement(Account).build().perform();

	LoginEmail.sendKeys(Agon_Username);
	Password.sendKeys(Agon_Password);

	Signin.click();
	return driver.getTitle();
	

}

public String ValidLoginMultiBrandQPS() throws InterruptedException

{

	String QPS_Username = prop.getProperty("ValidLoginMulti_email");
	String QPS_Password = prop.getProperty("ValidLoginMulti_Pswd");

	Thread.sleep(5000);

	act = new Actions(driver);

	wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(Account));
	act.moveToElement(Account).build().perform();

	LoginEmail.sendKeys(QPS_Username);
	Password.sendKeys(QPS_Password);
	Signin.click();
	Thread.sleep(5000);
	BrandSelectPopupQPS.click();
	return driver.getTitle();
	

}

public String UnApprovedLoginQPS() throws InterruptedException

{

	String QPS_Username = prop.getProperty("UnApprovedLoginQPS_email");
	String QPS_Password = prop.getProperty("UnApprovedLoginQPS_Pswd");

	Thread.sleep(5000);

	act = new Actions(driver);

	wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(Account));
	act.moveToElement(Account).build().perform();

	LoginEmail.sendKeys(QPS_Username);
	Password.sendKeys(QPS_Password);

	Signin.click();
	return driver.getTitle();

}

public String UnApprovedLoginMultiBrandQPS() throws InterruptedException

{

	String QPS_Username = prop.getProperty("UnApprovedLoginMultiQPS_email");
	String QPS_Password = prop.getProperty("UnApprovedLoginMultiQPS_Pswd");

	Thread.sleep(5000);

	act = new Actions(driver);

	wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(Account));
	act.moveToElement(Account).build().perform();

	LoginEmail.sendKeys(QPS_Username);
	Password.sendKeys(QPS_Password);
	Signin.click();
	return driver.getTitle();
			

}

public String ValidLoginCPS() throws InterruptedException

{

	String CPS_Username = prop.getProperty("ValidLoginCPS_email");
	String CPS_Password = prop.getProperty("ValidLoginCPS_Pswd");

	Thread.sleep(5000);

	act = new Actions(driver);

	wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(Account));
	act.moveToElement(Account).build().perform();

	LoginEmail.sendKeys(CPS_Username);
	Password.sendKeys(CPS_Password);

	Signin.click();
	return driver.getTitle();
	

}


public String UnApprovedLoginCPS() throws InterruptedException

{

	String CPS_Username = prop.getProperty("UnApprovedLoginCPS_email");
	String CPS_Password = prop.getProperty("UnApprovedLoginCPS_Pswd");

	Thread.sleep(5000);

	act = new Actions(driver);

	wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(Account));
	act.moveToElement(Account).build().perform();

	LoginEmail.sendKeys(CPS_Username);
	Password.sendKeys(CPS_Password);

	Signin.click();
	return driver.getTitle();

}

public String UnApprovedLoginMultiBrandCPS() throws InterruptedException

{

	String CPS_Username = prop.getProperty("UnApprovedLoginMultiCPS_email");
	String CPS_Password = prop.getProperty("UnApprovedLoginMultiCPS_Pswd");

	Thread.sleep(5000);

	act = new Actions(driver);

	wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(Account));
	act.moveToElement(Account).build().perform();

	LoginEmail.sendKeys(CPS_Username);
	Password.sendKeys(CPS_Password);
	Signin.click();
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
public String SignOut() {
	// Accept.click();

	act = new Actions(driver);
	wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(Account));

	act.moveToElement(Account).build().perform();

//JavascriptExecutor js = (JavascriptExecutor) driver;
//
//js.executeScript("arguments[0].scrollIntoView();", ReorderPad);
	SignOut.click();
	return driver.getTitle();

}
public String ValidLoginMultiBrandPCS() throws InterruptedException

{

	String Username = prop.getProperty("ValidLoginMulti_email");
	String UserPassword = prop.getProperty("ValidLoginMulti_Pswd");

	Thread.sleep(5000);

	act = new Actions(driver);

	wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(Account));
	act.moveToElement(Account).build().perform();

	LoginEmail.sendKeys(Username);
	Password.sendKeys(UserPassword);
	Signin.click();
	Thread.sleep(8000);
	
 
		   BrandSelectPopupPCS.click();

	
	return driver.getTitle();

}
public String ValidLoginMultiBrandCPS() throws InterruptedException

{

	String CPS_Username = prop.getProperty("ValidLoginMulti_email");
	String CPS_Password = prop.getProperty("ValidLoginMulti_Pswd");

	Thread.sleep(5000);

	act = new Actions(driver);

	wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(Account));
	act.moveToElement(Account).build().perform();

	LoginEmail.sendKeys(CPS_Username);
	Password.sendKeys(CPS_Password);
	Signin.click();
	Thread.sleep(8000);
	BrandSelectPopupCPS.click();
	return driver.getTitle();
	

}

public String InValidLoginMultiBrand() throws InterruptedException

{

	String Username = prop.getProperty("InValidLoginMulti_email");
	String password = prop.getProperty("InValidLoginMulti_Pswd");

	Thread.sleep(5000);

	act = new Actions(driver);

	wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(Account));
	act.moveToElement(Account).build().perform();

	LoginEmail.sendKeys(Username);
	Password.sendKeys(password);
	Signin.click();
	Thread.sleep(8000);
	
	return driver.getTitle();

}

public String UnApprovedLoginMultiBrand() throws InterruptedException

{

	String FIS_Username = prop.getProperty("UnApprovedLoginMulti_email");
	String FIS_Password = prop.getProperty("UnApprovedLoginMulti_Pswd");

	Thread.sleep(5000);

	act = new Actions(driver);

	wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(Account));
	act.moveToElement(Account).build().perform();

	LoginEmail.sendKeys(FIS_Username);
	Password.sendKeys(FIS_Password);
	Signin.click();
	return driver.getTitle();

}


	

}


