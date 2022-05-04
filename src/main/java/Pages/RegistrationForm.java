package Pages;

import java.util.List;


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

public class RegistrationForm extends BasePage {


	WebDriverWait wait;
	WebDriver driver;
	Actions act;
	
	@FindBy(name="title") WebElement title;
	
	@FindBy(xpath="//a[@class='account-header']") WebElement Account;
    @FindBy(xpath= "//span[text()='Register Now']") WebElement RegisterNow;
	
    
    @FindBy(xpath= "//input[@title='First Name']") WebElement FirstNameField;
    @FindBy(xpath= "//div[@id='firstname-error']") WebElement FirstnameError;
    
    @FindBy(xpath= "//div[@id='lastname-error']") WebElement LastnameError;
    @FindBy(xpath= "//input[@id='lastname']") WebElement LastnameField;
    
    
    @FindBy(xpath= "//div[@id='email_address-error']") WebElement EmailaddressError;
	@FindBy(xpath= "//input[@id='email_address']") WebElement EmailidField;
    
	
	@FindBy(xpath= "//span[text()='Submit Account Request']") WebElement submit;
	
	@FindBy(xpath= "//div[@id='company_email-error']") WebElement ConfirmemailidError;
	@FindBy(xpath= "//input[@title='Confirm Email']") WebElement ConfirmemailidField;
	
	@FindBy(xpath= "//div[@id='brand-error']") WebElement PreferredbrandError; 
	
	@FindBy(xpath= "//div[@id='company_name-error']") WebElement  CompanynameError;
	@FindBy(xpath= "//input[@id='company_name']") WebElement CompanynameField;
	
	@FindBy(xpath= "//div[@id='street0-error']") WebElement  Address1Error;
	@FindBy(xpath= "//input[@id='street0']") WebElement Address1Field;
	@FindBy(xpath= "//input[@id='street1']") WebElement Address2Field;
	
	
	@FindBy(xpath= "//div[@id='city-error']") WebElement CityError;
	@FindBy(xpath= "//input[@id='city']") WebElement CityField;
	
	@FindBy(xpath= "//div[@id='region_id-error']") WebElement stateError;
	@FindBy(xpath= "//select[@id='region_id']") WebElement State;
	
	@FindBy(xpath= "//div[@id='postcode-error']") WebElement ZipcodeError;
	@FindBy(xpath= "//input[@id='postcode']") WebElement Zipcodefield;
	
	@FindBy(xpath= "//div[@id='telephone-error']") WebElement PhonenoError;
	@FindBy(xpath= "//input[@id='telephone']") WebElement Phonenofield;
	@FindBy(xpath= "//input[@id='fax']") WebElement Faxfield;
	 
	@FindBy(xpath= "//div[@id='password-error']") WebElement PasswordError;
	@FindBy(xpath= "//div[@id='password-confirmation-error']") WebElement PswdconfirmationError;
	@FindBy(xpath= "//input[@id='password']") WebElement Pswd;
	@FindBy(xpath= "//input[@id='password-confirmation']") WebElement pswdconfirmation; 
	
	@FindBy(xpath= "//div[@id='customer[terms]-error']") WebElement TermsError;
	@FindBy(xpath= "//label[@for='terms']") WebElement Terms;

	@FindBy(xpath= "//label[@for='hls-account-1']") WebElement KnowMyHeritagePlusAccount_opt1;
	
    @FindBy(xpath= "//label[@for='hls-account-2']") WebElement Dont_KnowMyHeritagePlusAccount_opt2;

    @FindBy(xpath= "//label[@for='hls-account-0']") WebElement DontHave_MyHeritagePlusAccount_opt3; 
    
    @FindBy(xpath= "(//div[@class='selected'])[2]") WebElement BecomeaCustomer;
	
	@FindBy(xpath= "//input[@id='account_number']") WebElement company_Account_Field;
					
    @FindBy(xpath="//span[text()='Are you an Industry Professional?']") WebElement Industry_Professional_option;
	
					
    @FindBy(xpath="//span[text()='Yes, I am an industry professional']") WebElement yes_Industrial_Prof_option;
				
					
	@FindBy(xpath="//span[text()='No, I am not an industry professional']") WebElement Not_Industrial_Prof_option;
					
    @FindBy(xpath="//div[@class='selected']") WebElement MSG_on_yes_Industrial_Prof_Selection;
					
	@FindBy(xpath="//div[@class='unselected']") WebElement MSG_on_Not_Industrial_Prof_Selection;
	@FindBy(xpath="//select[@id='brand']") WebElement Heritage_Brand_Selection;
	@FindBy(xpath="//select[@id='branch']") WebElement Branch_Selection;
	
					
	public RegistrationForm(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void mouseHoverToAccount()
	{

	    act= new Actions(driver);
	
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(Account));
		act.moveToElement(Account).build().perform();
		
		
	}
	
	public void Registernowclick()
	{

	    act= new Actions(driver);
		act.moveToElement(Account).build().perform();
		WebDriverWait wait= new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(RegisterNow));
		RegisterNow.click();
	}
	
	public String ClickOnRegisternowOnGlobalSite()
	{

	    act= new Actions(driver);
		act.moveToElement(Account).build().perform();
	
		wait = new WebDriverWait(driver,80);
		wait.until(ExpectedConditions.visibilityOf(RegisterNow));
		
		RegisterNow.click();
		return driver.getCurrentUrl();
		
	}
	
	public void Submitclick() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0,1500)", "");
		 js.executeScript("arguments[0].scrollIntoView();", Pswd);
		 
		 WebDriverWait wait= new WebDriverWait(driver, 60);
		 wait.until(ExpectedConditions.visibilityOf(submit));
		 
Thread.sleep(1000);
		 submit.click();
		
	}
	
	public String PageTitle() throws InterruptedException
	{
		Thread.sleep(1000);
		String PageCurrentTitle = driver.getTitle();
		return PageCurrentTitle;
	
	}
	
	
	public String FirstNameFieldErrorvalidation() throws InterruptedException
	{
 
	return FirstnameError.getText();
 	}

	
	
	
	public String LastNameFieldErrorvalidation() throws InterruptedException
	{


return LastnameError.getText();

	}
	
	public String NoBrandSelectedErrorvalidation() throws InterruptedException
	{
return  PreferredbrandError.getText();

	}
	
	public String CompanynameFieldErrorvalidation() throws InterruptedException
	{

return  CompanynameError.getText();


	}
	
	public String Address1Errorvalidation() throws InterruptedException
	{

return Address1Error.getText();


	}
	
	public String CityFieldErrorvalidation() throws InterruptedException
	{

return  CityError.getText();

	}
	
	public String StateFieldErrorvalidation() throws InterruptedException
	{
return stateError.getText();

	}
	public String ZipcodeFieldErrorvalidation() throws InterruptedException
	{

return  ZipcodeError.getText();

	}
	
	public String EmptyPhonenoErrorvalidation() throws InterruptedException
	{
return  PhonenoError.getText();


}
	
	public String PhonenoFieldvalidation() throws InterruptedException
	{
Phonenofield.sendKeys(prop.getProperty("IncorrectPhoneno"));
return  PhonenoError.getText();


}
	
	
	
	
	public String IncorrectEmailFieldvalidation() throws InterruptedException
	
	{
	
	 EmailidField.sendKeys(prop.getProperty("email1"));
 ConfirmemailidField.sendKeys(prop.getProperty("incorrectconfirmemail"));


 WebDriverWait wait= new WebDriverWait(driver, 60);
 wait.until(ExpectedConditions.visibilityOf(ConfirmemailidError));


return ConfirmemailidError.getText();


	}
	
	
	public String ExistingEmailFieldvalidation() throws InterruptedException
	{
		EmailidField.clear();
		EmailidField.sendKeys(prop.getProperty("existingemail"));
		Thread.sleep(5000);
		ConfirmemailidField.clear();
		ConfirmemailidField.sendKeys(prop.getProperty("existingemail"));
		Thread.sleep(10000);
		
		return EmailaddressError.getText();
	}
	
	
	public String PasswordFieldvalidation() throws InterruptedException
	{
		

Pswd.sendKeys(prop.getProperty("Password"));
Thread.sleep(500);
pswdconfirmation.sendKeys(prop.getProperty("Incorrectconfirmpswd"));
Thread.sleep(900);


Thread.sleep(5000);
WebDriverWait wait= new WebDriverWait(driver, 60);
wait.until(ExpectedConditions.visibilityOf(PswdconfirmationError));


return   PswdconfirmationError.getText();


	}
	
	
	
	public String TermConditionCheckValidation() throws InterruptedException
	{
	
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
 	 js.executeScript("arguments[0].scrollIntoView();", TermsError);




return TermsError.getText();

	}

	public void KnowMyHeritagePlusAccountclick() throws InterruptedException
	
	
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;


		 js.executeScript("arguments[0].scrollIntoView();", Phonenofield);//testing here
		Thread.sleep(500);
		KnowMyHeritagePlusAccount_opt1.click();
		
	}
	
	public WebElement company_Account_Field() //directly retriving webelement
	{
		return company_Account_Field;
		
	}
	
	public void company_Account_Entry() //directly retriving webelement
	{
		 company_Account_Field.click();
		 company_Account_Field.sendKeys(prop.getProperty("CompanyAccountNo"));
		
	}
	
	
	
	

public void Dont_KnowMyHeritagePlusAccountclick() throws InterruptedException


{
	JavascriptExecutor js = (JavascriptExecutor) driver;

	 js.executeScript("arguments[0].scrollIntoView();", Faxfield);


	Thread.sleep(1000);
	Dont_KnowMyHeritagePlusAccount_opt2.click();
}



public void DontHave_MyHeritagePlusAccountclick() throws InterruptedException


{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	
	 js.executeScript("arguments[0].scrollIntoView();", Faxfield);


	Thread.sleep(500);
	DontHave_MyHeritagePlusAccount_opt3.click();
	
}

public WebElement Industry_Professional_option() //directly retriving webelement
{
	return Industry_Professional_option;
	
}

public void yes_Industrial_Professional_option_Click()

{
	yes_Industrial_Prof_option.click();
	
	
}

public String  Messageon_yes_Industrial_Prof_option_Selection()

{
	yes_Industrial_Prof_option.click();
	return  MSG_on_yes_Industrial_Prof_Selection.getText();
	
	
	
}

public void Not_Industrial_Professional_option_Click()

{
	Not_Industrial_Prof_option.click();
	
}

public String Messageon_Not_Industrial_Professional_option_Click()

{
	Not_Industrial_Prof_option.click();
	return	MSG_on_Not_Industrial_Prof_Selection.getText();
	
}

public WebElement  BecomeACustomer()

{
return BecomeaCustomer;
	
	
}

public void Messageon_Not_Industrial_Professional_BecomeACustomerClick()

{
BecomeaCustomer.click();
	
	
}

public WebElement Heritage_Brand_SelectionField() //directly retriving webelement
{
	return Heritage_Brand_Selection;
	
}

public  void Hertiage_Brand_FIS_Selection()

{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 
	
	 js.executeScript("arguments[0].scrollIntoView();",Heritage_Brand_Selection);
Select Brand= new Select(Heritage_Brand_Selection);
 Brand.selectByVisibleText("FIS");
 

}

public void Hertiage_Brand_PCS_Selection()

{

Select Brand= new Select(Heritage_Brand_Selection);
Brand.selectByVisibleText("Pool Contractor Supply");

}
public void Hertiage_Brand_Aqua_gon_Selection() throws InterruptedException

{

Select Brand= new Select(Heritage_Brand_Selection);
Thread.sleep(3000);
Brand.selectByVisibleText("Aqua-Gon");

}


public void Hertiage_Brand_QPS_Selection()

{

Select Brand= new Select(Heritage_Brand_Selection);
Brand.selectByVisibleText("Quality Pool Supply");

}

public void Scrollup_Branch_SelectionField() //directly retriving webelement
{
	

	JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,-250)", "");
}

public WebElement Branch_SelectionField() throws InterruptedException //directly retriving webelement
{
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 
	  js.executeScript("arguments[0].scrollIntoView();",LastnameField);
	  
	  Thread.sleep(5000);

	Branch_Selection.click();

	return Branch_Selection;
	
}

public void Branch_fisSelection() throws InterruptedException //directly retriving webelement
{
	
	Select Brand= new Select(Branch_SelectionField());
	Brand.selectByVisibleText("FIS SANFORD");
	
}

public void Branch_pcsSelection() throws InterruptedException //directly retriving webelement
{
	
	Select Brand= new Select(Branch_SelectionField());
	Brand.selectByVisibleText("POOL CONTRACTORS SUPPLY BIRMINGHAM");
	
}

public void Branch_qpsSelection() throws InterruptedException //directly retriving webelement
{
	
	Select Brand= new Select(Branch_SelectionField());
	Brand.selectByVisibleText("QUALITY POOL SUPPLY PERRYSBURG");
	
}
public void Branch_Aqua_gonSelection() throws InterruptedException //directly retriving webelement
{
	
	Select Brand= new Select(Branch_SelectionField());
	Brand.selectByVisibleText("AQUAGON - NAPERVILLE");
	
}

public  void CompanyField_click() throws InterruptedException


{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,0)", "");
	  js.executeScript("arguments[0].scrollIntoView();",Branch_SelectionField());

	  CompanynameField.click();
	  Thread.sleep(500);
	  CompanynameField.sendKeys(prop.getProperty("CompanyName"));
	  Thread.sleep(500);
	
}

public  void Address1Field_click() throws InterruptedException


{

	  Address1Field.click();
	  Thread.sleep(500);
	  Address1Field.sendKeys(prop.getProperty("Address1"));
	  Thread.sleep(500);
	
}


public  void Address2Field_click() throws InterruptedException


{
	

	  Address2Field.click();
	  Thread.sleep(500);
	  Address2Field.sendKeys(prop.getProperty("Address2"));
	  Thread.sleep(500);
}


public  void CityField_click() throws InterruptedException


{
	

	  CityField.click();
	  Thread.sleep(500);
	  CityField.sendKeys(prop.getProperty("City"));
	  Thread.sleep(500);
}


public  void State_Selection() throws InterruptedException


{
	

	  State.click();
	  Select state= new Select(State);
	 
	  state.selectByVisibleText(prop.getProperty("state"));
}

public  void ZipCode_click () throws InterruptedException


{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 
	js.executeScript("arguments[0].scrollIntoView();",Address2Field);

	  Zipcodefield.click();
	  Thread.sleep(500);
	  Zipcodefield.sendKeys(prop.getProperty("zipcode"));
	  Thread.sleep(500);
	
}


public  void Valid_PhoneNo_click() throws InterruptedException


{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 
	js.executeScript("arguments[0].scrollIntoView();",Address2Field);

	  Phonenofield.click();
	  Thread.sleep(500);
	  Phonenofield.sendKeys(prop.getProperty("ValidPhoneNo"));
	  Thread.sleep(500);
	
}

public  void Fax_click() throws InterruptedException


{
	

	  Faxfield.click();
	  Thread.sleep(500);
	  Faxfield.sendKeys(prop.getProperty("Fax"));
	  Thread.sleep(500);
	
}


public  void FirstName_Entry() throws InterruptedException


{
	

	  FirstNameField.click();
	  Thread.sleep(500);
	  FirstNameField.sendKeys(prop.getProperty("firstname"));
	  Thread.sleep(500);
	
}


public  void LastName_Entry() throws InterruptedException


{
	
	  LastnameField.click();
	  Thread.sleep(500);
	  LastnameField.sendKeys(prop.getProperty("lastname"));
	  Thread.sleep(500);
	
}

public  void Email_Entry_Scenario1() throws InterruptedException


{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	//WebElement x= driver.findElement(By.xpath("/html/body/div[1]/main/div[3]/div/div[2]/span"));
	//js.executeScript("arguments[0].scrollIntoView();", x);
	EmailidField.click();
	EmailidField.sendKeys(prop.getProperty("email1"));
	Thread.sleep(5000);
	ConfirmemailidField.click();
	ConfirmemailidField.sendKeys(prop.getProperty("email1"));
	Thread.sleep(5000);
	
	
	
}

public  void Email_Entry_Scenario2() throws InterruptedException


{
	
	 
	
	EmailidField.click();
	EmailidField.sendKeys(prop.getProperty("email2"));
	Thread.sleep(5000);
	ConfirmemailidField.click();
	ConfirmemailidField.sendKeys(prop.getProperty("email2"));
	Thread.sleep(5000);
	
	
	
}

public  void Email_Entry_Scenario3() throws InterruptedException


{
	
	EmailidField.click();
	EmailidField.sendKeys(prop.getProperty("email3"));
	Thread.sleep(5000);
	ConfirmemailidField.click();
	ConfirmemailidField.sendKeys(prop.getProperty("email3"));
	Thread.sleep(5000);
	
	
	
}



public void ValidPassword_Entry() throws InterruptedException
{
	

Pswd.sendKeys(prop.getProperty("Password"));
Thread.sleep(500);
pswdconfirmation.sendKeys(prop.getProperty("ConfirmPassword"));


Thread.sleep(1000);





}

public void Pagerefresh() throws InterruptedException
{
driver.navigate().refresh();
Thread.sleep(6000);
JavascriptExecutor js = (JavascriptExecutor) driver;
WebElement x= driver.findElement(By.xpath("/html/body/div[1]/main/div[3]/div/div[2]/span"));
js.executeScript("arguments[0].scrollIntoView();", x);
}


public void Terms_Click() throws InterruptedException
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	 js.executeScript("arguments[0].scrollIntoView();", Pswd);
	Terms.click();

}


public String Success_Popup() throws InterruptedException
{
return	driver.switchTo().alert().getText();
	

}



















		
	
	
	
	
}
