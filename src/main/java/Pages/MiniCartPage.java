package Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import SRSproject.SRSproject.BasePage;

public class MiniCartPage extends BasePage {
	
	WebDriverWait wait;
	WebDriver driver;
	Actions act;

	
	@FindBy(xpath="//a[@class='action showcart']//i[1]") WebElement MiniCarticon;
	@FindBy(xpath="//span[text()='View Cart']") WebElement ViewCartbutton;
	@FindBy(xpath="//button[@title='Checkout']") WebElement CheckOut_btn;
	
	public MiniCartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement MiniCart()
	{
		return MiniCarticon;
	}
	
	public CartPage ClickViewCart()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		 js.executeScript("arguments[0].scrollIntoView();", ViewCartbutton);
		ViewCartbutton.click();
		return new CartPage(driver);
	}

	public void ViewCart() throws Exception
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		ViewCartbutton.click();
		
		
	}
	
	public CheckoutPage ClickCheckout()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		 js.executeScript("arguments[0].scrollIntoView();", CheckOut_btn);
		CheckOut_btn.click();
		return new CheckoutPage(driver);
	}
	
	

}
