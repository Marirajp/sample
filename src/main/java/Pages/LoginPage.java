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

public class LoginPage extends BasePage {

	WebDriverWait wait;
	WebDriver driver;
	Actions act;
	
	@FindBy(xpath="//a[@class='account-header']") WebElement Account;
	@FindBy(xpath="//input[@id='header-email']") WebElement LoginEmail;
	@FindBy(xpath="//input[@title='Password']") WebElement Password;
	@FindBy(xpath="//button[@class='action login primary']") WebElement Singin;
	@FindBy(xpath="//a[@class='logout-link']") WebElement SingOut;
	//@FindBy(xpath="//a[@title='Reorder Pads']") WebElement ReorderPad;
	@FindBy(xpath="//a[@title='Change Ship-to/Job Account']") WebElement ReorderPad;
	@FindBy(xpath="//span[text()='I Accept']") WebElement Accept;
	@FindBy(xpath="//div[@class='swal2-content']") WebElement errorPopupMsg;
	@FindBy(xpath="//button[@class='swal2-close']") WebElement popupClose;
	
	

	
	
public LoginPage(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver, this);
}

	
	public void Account_Hover()
	{

	    act= new Actions(driver);
		act.moveToElement(Account).build().perform();
		
	}
	
	public void ValidLogin() throws InterruptedException

	{
		
		Thread.sleep(8000);
	  act= new Actions(driver);
	
			//wait = new WebDriverWait(driver,30);
		//	wait.until(ExpectedConditions.visibilityOf(Account));
			act.moveToElement(Account).build().perform();
		LoginEmail.sendKeys(prop.getProperty("ValidLogin_email"));
		Password.sendKeys(prop.getProperty("ValidLogin_Pswd"));
		Singin.click();
		
	}
public String handlePopup() {
		
		String errorMsg = errorPopupMsg.getText();
		return errorMsg;

		
	}
public void closePopup() {
	
	popupClose.click();
	
}
	
	public void SignOut()
	{
		Accept.click();

	    act= new Actions(driver);
		act.moveToElement(Account).build().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		 js.executeScript("arguments[0].scrollIntoView();", ReorderPad);
		SingOut.click();
		
	}


	
	

}
