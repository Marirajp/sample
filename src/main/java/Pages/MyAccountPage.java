package Pages;

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

import SRSproject.SRSproject.BasePage;

public class MyAccountPage extends BasePage {

	WebDriverWait wait;
	WebDriver driver;
	Actions act;
	
	
	
	@FindBy(xpath="//span[normalize-space()='Account']")WebElement Account;
	@FindBy(xpath="//a[@title='Account Dashboard']//span[@class='mini-account-link']")WebElement AccountDashboard;
	@FindBy(xpath="//span[normalize-space()='Edit Account Info']")WebElement EditAccountInfo;
	@FindBy(xpath="//select[@id='ship-via']")WebElement DefaultShipvia;
	@FindBy(xpath="//option[@value='OUR TRUCK']")WebElement DeliverFISTruck;
	@FindBy(xpath="//form[@id='edit-form-validate']//span[contains(text(),'Save')]")WebElement SaveButton;
	@FindBy(xpath="//span[normalize-space()='Cart']")WebElement MiniCart;
	@FindBy(xpath="//button[@id='top-cart-btn-checkout']")WebElement CheckOutButton;
	
//	@FindBy(xpath="//body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[1]/div[3]/div[1]/input[1]")WebElement OrderDetails;
	@FindBy(xpath="/html/body/div[1]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div[3]/div/input")WebElement OrderDetails;
	
//	@FindBy(xpath="//input[@id='dp1655367671921']")WebElement RequestedDate;
	@FindBy(xpath="//input[contains(@id,'dp')]")WebElement RequestedDate;
	@FindBy(xpath="//a[contains(@class,'ui-state-default ui-state-hover')]")WebElement CalenderDate;
	
	@FindBy(xpath="//button[@class='button action continue secondary']//span//span[contains(text(),'Next Step')]")WebElement NextButton;
	@FindBy(xpath=" //button[@class='button action continue primary']//span//span[contains(text(),'Next Step')]")WebElement NextStepButton;          
	
	
	@FindBy(xpath="//span[normalize-space()='UPS Blue (2-Day)']")WebElement UPSBlue;
	//@FindBy(xpath="//option[text()='UPS Blue (2-Day)']")WebElement UPSBlueSame;
	@FindBy(xpath="//div[normalize-space()='UPS Blue (2-Day)']")WebElement UPSBlue2;
	
	
//	@FindBy(xpath="//label[@for='agreement_checkmo_3']")WebElement Checkbox;
	 @FindBy(xpath ="(//input[@type='checkbox'])[2]")WebElement Checkbox;
	 @FindBy(xpath = "(//input[@type='checkbox']/following-sibling::label)[2]") WebElement Terms_checkBx;
	 
	 
	 @FindBy(xpath="//span[normalize-space()='Return to Cart']")WebElement ReturnToCart;
	 @FindBy(xpath="//button[@class='customer-header-panel-button change-branch-modal']")WebElement ChangeBranch;

	 @FindBy(xpath="//select[@id='branches']")WebElement ChangeBranchID;
	 @FindBy(xpath="//option[@value='10124']")WebElement WOLF_CREEK_COMPANY_CLEVELAND;
	 @FindBy(xpath="//body/div[contains(@class,'modals-wrapper')]/aside[7]/div[2]/footer[1]/button[1]")WebElement ConfirmButton;
	 @FindBy(xpath="//aside[contains(@class,'_show')]//span[contains(text(),'Confirm')]")WebElement ConFirmButton;
	               //body/div[contains(@class,'modals-wrapper')]/aside[7]/div[2]/footer[1]/button[1]
	 
	 
	 
	 @FindBy(xpath="//select[@id='branches']") WebElement ChangeBranchSelection;
	 @FindBy(xpath="(//button[@class='action primary'])[6]") WebElement Confirm;
		@FindBy(xpath="//span[@class='customer-header-panel-item-value']") WebElement YourBranch;
		
		//Aquagon-default shipvia
		@FindBy(xpath="//div[normalize-space()='Pickup (Will Call)']")WebElement PickUp;
		@FindBy(xpath="//span[normalize-space()='Pickup (Will Call)']")WebElement PickUp2;
	
	
	
	
	
	public MyAccountPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	public void AccountModule() throws InterruptedException

	{
		act.moveToElement(ReturnToCart).perform();
		ReturnToCart.click();
	  act= new Actions(driver);
	act.moveToElement(Account).moveToElement(AccountDashboard).perform();
	Thread.sleep(3000);
		//act.contextClick(BrandsLetter_B).build().perform();
	AccountDashboard.click();

}
	public void EditAccount() {
		
		
		  act= new Actions(driver);	
		  act.moveToElement(EditAccountInfo).perform();
		  EditAccountInfo.click();
		
	}
	public void ScrollToElement() throws InterruptedException {
		
		act= new Actions(driver);
		act.moveToElement(Account).build().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(3000);
		
		// js.executeScript("arguments[0].scrollIntoView();", DefaultShipvia);
		 DefaultShipvia.click();
		
	}
	public void FISTruck() throws InterruptedException {
		
	//	act = new Actions(driver);
	
		//act.moveToElement(DeliverFISTruck).perform();
		Select se=new Select(DefaultShipvia);
		se.selectByValue("OUR TRUCK");
	se.selectByValue(prop.getProperty("PicUP"));	
		Thread.sleep(3000);
//		se.selectByValue("WCLATER");
//		Thread.sleep(3000);
//		se.selectByValue("UPS GRD");
//		Thread.sleep(3000);
//		se.selectByValue("UPS BLUE");
//		
		//DeliverFISTruck.click();
		Thread.sleep(3000);
SaveButton.click();
		
		Thread.sleep(3000);
		
	}
	public String verify() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		String ups = PickUp.getText();
		System.out.println(ups);
		return ups;
	}
	public void MiniCartPerform() throws InterruptedException {
		act=new Actions(driver);
		act.moveToElement(MiniCart).perform();
		Thread.sleep(8000);
		MiniCart.click();
		Thread.sleep(6000);
		act.moveToElement(CheckOutButton).perform();
		CheckOutButton.click();
		
		
		Thread.sleep(8000);
		//act.moveToElement(OrderDetails).perform();
		OrderDetails.click();
		Thread.sleep(5000);
  	OrderDetails.sendKeys("12");
		Thread.sleep(3000);
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(3000);
		act.moveToElement(RequestedDate).perform();
		RequestedDate.click();
		Thread.sleep(3000);
		act.moveToElement(CalenderDate).perform();
		CalenderDate.click();
		Thread.sleep(3000);
		NextButton.click();
		Thread.sleep(3000);
		
		
		
	}
	public void ShippingShipPage() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(3000);
		Select se=new Select(DefaultShipvia);
		se.selectByValue("OUR TRUCK");
		Thread.sleep(3000);
		se.selectByValue(prop.getProperty("PicUP"));
//		se.selectByValue("WCLATER");
//		Thread.sleep(3000);
//		se.selectByValue("UPS GRD");
//		Thread.sleep(3000);
//		se.selectByValue("UPS BLUE");
		
		//DeliverFISTruck.click();
		Thread.sleep(3000);
		NextStepButton.click();
		Thread.sleep(3000);
		//driver.getCurrentUrl();
	//	driver.getTitle();
		
		
	}
//	public void CheckBoxPerform() throws InterruptedException {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,800)");
//		Thread.sleep(3000);
//		Terms_checkBx.click();
//		
//	}

	public String verifysame() {
		String ups1 = PickUp2.getText();
		System.out.println(ups1);
		return ups1;
		
	}
	
	public void ChangeBranchPage() throws InterruptedException {
		act.moveToElement(ReturnToCart).perform();
		ReturnToCart.click();
		driver.getTitle();
		Thread.sleep(3000);
		ChangeBranch.click();
		Thread.sleep(3000);
		
		Select Brand= new Select(ChangeBranchSelection);

		Brand.selectByValue(prop.getProperty("Change_Branch_val"));
		
		Thread.sleep(3000);

		ConFirmButton.click();
		//act.moveToElement(ConFirmButton).click();
		Thread.sleep(8000);
		
	}	
	public String ChangeBranchmode() throws Exception
	{
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(ChangeBranch));
		ChangeBranch.click();
		
//		Thread.sleep(1000);
		waitUntilElementVisibility(ChangeBranchSelection);
		Select Brand= new Select(ChangeBranchSelection);

		Brand.selectByValue(prop.getProperty("changebranch_value"));
		
//		 Thread.sleep(10000);
		 
			//wait.until(ExpectedConditions.visibilityOf(Confirm));
		 
		 
		 Confirm.click();

//		 ((JavascriptExecutor) driver)
//		 .executeScript("window.scrollTo(0, -document.body.scrollHeight)");

		 Thread.sleep(5000);
		 ((JavascriptExecutor) driver)
		 .executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		 return YourBranch.getText();
	 
		 
	   }
		
	}
	
	