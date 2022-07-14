package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import SRSproject.SRSproject.BasePage;

public class AccountDashboardPage extends BasePage {

	WebDriverWait wait;
	WebDriver driver;
	Actions act;
	

	
	
	@FindBy(xpath="//span[normalize-space()='Account']")WebElement Account;
	@FindBy(xpath="//a[@title='Account Dashboard']//span[@class='mini-account-link']")WebElement AccountDashboard;
	@FindBy(xpath="//span[normalize-space()='Edit Organization Info']")WebElement EditOrganizationInfo;
	@FindBy(xpath="//strong[normalize-space()='Dashboard']")WebElement DashBoard;
	
	@FindBy(xpath="//a[normalize-space()='Open Orders']")WebElement OpenOders;
	@FindBy(xpath="//a[normalize-space()='Invoice History']")WebElement InvoiceHistory;
	@FindBy(xpath="//a[normalize-space()='Reorder Pads']")WebElement ReorderPads;
	@FindBy(xpath="//a[normalize-space()='User Management']")WebElement UserManagement;
	@FindBy(xpath="//a[normalize-space()='Account Statement']")WebElement AccountStatement;
	@FindBy(xpath="//span[@class='base']")WebElement OrganizationInformationPage;
	
	@FindBy(xpath="//select[@id='country_id']")WebElement CountryOption;
	@FindBy(xpath="//select[@title='Country']//option[1]")WebElement CountryOptionEmpty;
	@FindBy(xpath="//div[@class='field country_id _required required active']//option[1]")WebElement CountrySpace;
	@FindBy(xpath="//span[@data-bind='text: companyInfo().name']")WebElement NewBerlin_Test_Corp;
	@FindBy(xpath="//span[starts-with(text(),'Account # ')]")WebElement AccountNumber;
	@FindBy(xpath="//a[@title='Edit Profile']")WebElement EditProfile;
	@FindBy(xpath="//span[normalize-space()='Edit your Personal Information']")WebElement EditPersonalInfo;
	
	@FindBy(xpath="//div[@id='postcode-error']")WebElement InvalidPostInumber;
	@FindBy(xpath="//div[@id='telephone-error']")WebElement InValidPhoneNumber;
	@FindBy(xpath="//input[@id='postcode']")WebElement PostalCode;
	@FindBy(xpath="//input[@id='telephone']")WebElement PhoneNumber;
	@FindBy(xpath="//button[@title='Confirm']//span[contains(text(),'Confirm')]")WebElement ConfirmButton;
	
	@FindBy(xpath="//input[@id='company_email']")WebElement CompanyEmail;
	
	public AccountDashboardPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	

	
	public void EditOrganization() throws InterruptedException {
		
//		act.moveToElement(Account).moveToElement(AccountDashboard).perform();
//		Thread.sleep(3000);
//		AccountDashboard.click();
		
		String Display1 = DashBoard.getText();
		Thread.sleep(6000);
		boolean Display11 = DashBoard.isEnabled();
		System.out.println(Display1);
		System.out.println(Display11);
		
		String Display2 = OpenOders.getText();
		Thread.sleep(2000);
		boolean Display22 = OpenOders.isEnabled();
		System.out.println(Display2);
		System.out.println(Display22);
		
		String Display3 = InvoiceHistory.getText();
		Thread.sleep(3000);
		boolean Display33 = DashBoard.isEnabled();
		System.out.println(Display3);
		System.out.println(Display33);
		
		String Display4 = ReorderPads.getText();
		Thread.sleep(3000);
		boolean Display44 = ReorderPads.isEnabled();
		System.out.println(Display4);
		System.out.println(Display44);
		
		String Display5 = UserManagement.getText();
		Thread.sleep(3000);
		boolean Display55 = UserManagement.isEnabled();
		System.out.println(Display5);
		System.out.println(Display55);
		
		String Display6 = AccountStatement.getText();
		Thread.sleep(3000);
		boolean Display66 = AccountStatement.isEnabled();
		System.out.println(Display6);
		System.out.println(Display66);
		
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(3000);
		  act= new Actions(driver);	
		  act.moveToElement(EditOrganizationInfo).perform();
		  EditOrganizationInfo.click();
		  JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,700)");
			Thread.sleep(3000);
			
			
			String Display7 = OrganizationInformationPage.getText();
			Thread.sleep(3000);
			boolean Display77 = OrganizationInformationPage.isEnabled();
			System.out.println(Display7);
			System.out.println(Display77);
			
			boolean main = OrganizationInformationPage.isDisplayed();
			System.out.println(main);
			
			
			
			act.moveToElement(CountryOption).perform();
			CountryOption.click();
			Thread.sleep(4000);
	//act.moveToElement(CountryOptionEmpty).perform();
	CountryOptionEmpty.click();
			
		Thread.sleep(4000);
			act.moveToElement(PostalCode).perform();
			PostalCode.click();
			PostalCode.clear();
			String po = prop.getProperty("Invalidpostalcode");
			PostalCode.sendKeys(po);
			Thread.sleep(4000);
			act.moveToElement(PhoneNumber).perform();
			PhoneNumber.click();
			PhoneNumber.clear();
			String so = prop.getProperty("Invalidphonenumber");
			PhoneNumber.sendKeys(so);
			Thread.sleep(4000);
			
			act.moveToElement(ConfirmButton).perform();
			ConfirmButton.click();
			
			boolean pos = InvalidPostInumber.isDisplayed();
			String pos1 = InvalidPostInumber.getText();
			System.out.println(pos);
			System.out.println(pos1);
			Thread.sleep(4000);
			boolean innum = InValidPhoneNumber.isDisplayed();
			
			String innum1 = InValidPhoneNumber.getText();
	        System.out.println(innum);
	        System.out.println(innum1);
	}	
	public void AccountModule() throws InterruptedException {
		scrollUpandDownUsingElement(Account);
		act=new Actions(driver);
		act.moveToElement(Account).perform();
		boolean Berlin = NewBerlin_Test_Corp.isDisplayed();
		String Ber = NewBerlin_Test_Corp.getText();
		System.out.println(Berlin);
		System.out.println(Ber);
		Thread.sleep(8000);
		boolean AccNo = AccountNumber.isDisplayed();
		String Acc = AccountNumber.getText();
		System.out.println(AccNo);
		System.out.println(Acc);
		Thread.sleep(8000);
		boolean Edit = EditProfile.isDisplayed();
		String ed = EditProfile.getText();
		System.out.println(Edit);
		System.out.println(ed);
		
		act.moveToElement(EditProfile).perform();
		EditProfile.click();
		Thread.sleep(8000);
		
		
	}
}
