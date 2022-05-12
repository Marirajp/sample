package Pages;

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

import SRSproject.SRSproject.BasePage;

public class CheckoutPage extends BasePage {
	
	WebDriverWait wait;
	WebDriver driver;
	Actions act;
	

	
	@FindBy(xpath="//select[@id='shipto']") WebElement ShiptoAcc;
	@FindBy(xpath="//select[@id='branch']") WebElement Branch;
	@FindBy(xpath="/html/body/div[1]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div[3]/div/input") WebElement PO_field;
	@FindBy(xpath="/html/body/div[1]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div[4]/div/input") WebElement OrderNotes;
	@FindBy(xpath="/html/body/div[1]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div[6]/div/input") WebElement Date;
	
//	@FindBy(xpath="/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div[3]/div/input") WebElement PO_field;
//	@FindBy(xpath="/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div[4]/div/input") WebElement OrderNotes;
//	@FindBy(xpath="/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div[6]/div/input") WebElement Date;
	@FindBy(xpath = "(//span[text()='Next Step'])[1]") WebElement NextStep_Order;
	
	@FindBy(xpath="//span[@class='ui-icon ui-icon-circle-triangle-e']") WebElement calendarNextBtn;
	
	@FindBy(xpath="//a[@class='ui-state-default']") List<WebElement> selectDate;
			
	@FindBy(xpath="//select[@name='ship-via']") WebElement ShipVia;
	
	@FindBy(xpath = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[4]/div[1]/div[2]/form/div[3]/div/button/span/span") WebElement Nextstep_shipping;
	
	@FindBy(xpath = "(//input[@type='checkbox']/following-sibling::label)[2]") WebElement Terms_checkBx;
	@FindBy(xpath=("//button[@data-role='action']//span[1]")) WebElement Close;
			//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div/div[2]/div[2]/div
	
	@FindBy(xpath="//span[text()='Place Order']") WebElement PlaceOrder;
	
	@FindBy(xpath="//li[@id='payment']") WebElement Phone_field;
	
	@FindBy(xpath="(//input[@name='street[0]'])[1]") WebElement Address1;
	@FindBy(xpath="(//input[@name='city'])[1]") WebElement City;
	@FindBy(xpath="(//select[@name='region_id'])[1]") WebElement State;
	@FindBy(xpath="(//input[@name='postcode'])[1]") WebElement Zipcode;
	
	
	@FindBy(xpath = "//strong[@class='product-item-name']") List<WebElement> itemName;
	
	@FindBy(xpath="//span[text()='By submitting this order, I agree to the Online Terms & Conditions of Sale']") WebElement Text;
	@FindBy(xpath="//span[@class='checkout-product product-item-details']") WebElement reviewlab;
    @FindBy(xpath ="(//input[@type='checkbox'])[2]") WebElement Checkbox;
    @FindBy(xpath="(//button[contains(@class,'action secondary')])[1]") WebElement Holdorder;
    @FindBy(xpath="//button[contains(@class,'action secondary')]/following-sibling::button[1]") WebElement Placeorder;
    
    
    
    
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> getCheckout_ItemName()
	{
		return itemName;
	}
	
	public void Shipto_Selection()
	
	{
		WebDriverWait wait= new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(ShiptoAcc));
		Select  Shipto =  new Select (ShiptoAcc);
		Shipto.selectByValue("1");
		
	}
	
	public void Branch_Selection()
	
	
	{
		WebDriverWait wait= new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(Branch));
		Select  branch =  new Select (Branch);
		branch.selectByVisibleText(prop.getProperty("Branch2"));
		
	}
	
public void PO_Number()
	
	{
	WebDriverWait wait= new WebDriverWait(driver, 40);
	wait.until(ExpectedConditions.visibilityOf(PO_field));
	PO_field.click();
		PO_field.sendKeys("Ab123");
		
	}
public void checkbox() throws Exception {
	((JavascriptExecutor) driver)
    .executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	waitUntilElementVisibility(Checkbox);
	Checkbox.click();
	
}
public void Holdorder() throws Exception {
WebElement findElement = driver.findElement(By.cssSelector("button[class='action secondary checkout']"));
	
	jsClick(findElement);
}
public void Placeoder() throws Exception {
	waitUntilElementVisibility(Placeorder);
	Placeorder.click();
}


/*public void Address1()

{
	Address1.clear();
Address1.sendKeys(prop.getProperty("Address1"));
	
	
}

public void City()

{
	City.clear();
City.sendKeys(prop.getProperty("City"));
	
	
}

public void Zipcode()

{
	Zipcode.clear();
Zipcode.sendKeys(prop.getProperty("zipcode"));
	
	
}

public void state()

{
	Select  state =  new Select (State);
	state.selectByVisibleText(prop.getProperty("state"));
	
}*/

public void Ordernotes()

{
	
	OrderNotes.sendKeys(prop.getProperty("ordernotes"));
	
}

public void RequestedDate()

{
		Date.click();
	driver.findElement(By.xpath("//a[text()='30']")).click();
}

public void clickOnCalendarsNextBtn()
{
	calendarNextBtn.click();
}

public List<WebElement> clickOnSelectDate()
{
	return selectDate;
}

public void phone()

{
	WebDriverWait wait= new WebDriverWait(driver, 40);
	wait.until(ExpectedConditions.visibilityOf(Phone_field));
	
	Phone_field.click();
	
}


public WebElement NextStep1()

{
	WebDriverWait wait= new WebDriverWait(driver, 40);
	wait.until(ExpectedConditions.visibilityOf(NextStep_Order));
	
	return  NextStep_Order;
	
}

public void NextStepp()

{
	WebDriverWait wait= new WebDriverWait(driver, 40);
	wait.until(ExpectedConditions.visibilityOf(Phone_field));
	
	  Nextstep_shipping.click();
	
}

public void ShipVia()

{
	Select  shipvia=new  Select (ShipVia);
	shipvia.selectByValue(prop.getProperty("ShipVia_Value"));
	
	
}

public WebElement PlaceOrder()

{
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("arguments[0].scrollIntoView();", PlaceOrder);
	return  PlaceOrder;
	
}

public void scroll() throws InterruptedException

{
	Thread.sleep(8000);
	//((JavascriptExecutor) driver).executeScript("window.scrollBy(0,2000)");
	
	//((JavascriptExecutor) driver)
//    .executeScript("window.scrollTo(0, document.body.scrollHeight)");
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("arguments[0].scrollIntoView();", reviewlab);
	 reviewlab.click();
	 ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,7000)");
//	 js.executeScript("arguments[0].scrollIntoView();", Terms_checkBx);
//	 Terms_checkBx.click();
	

	
}


public WebElement Terms_Check() throws Exception

{
	WebElement findElement = driver.findElement(By.cssSelector("div#checkout-payment-method-load>div>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div>div>label"));
	
	jsClick(findElement);
	//Close.click();
	return  findElement;
	
}




}
