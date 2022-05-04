package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage  {
	WebDriverWait wait;
	WebDriver driver;
	Actions act;
	
	@FindBy(xpath="//strong[text()='Register']") WebElement RegisterLink;
	@FindBy(xpath="(//div[@class='product attribute part'])[2]") WebElement PartLabel;
	@FindBy(xpath="//span[text()='Add to Cart']") WebElement AddToCart;
	
	@FindBy(xpath="//p[text()='has been added to your cart']") WebElement text;

	public ProductDetailPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public String Guest_clickProductRegister() 
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		 js.executeScript("arguments[0].scrollIntoView();", PartLabel);
		 
		 WebDriverWait wait= new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(PartLabel));
	
		RegisterLink.click();
		return driver.getCurrentUrl();
		
		
		
		
	}
	
	public String AddingItem() throws InterruptedException 
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		 js.executeScript("arguments[0].scrollIntoView();", PartLabel);
		 
		 WebDriverWait wait= new WebDriverWait(driver, 50);
		
			wait.until(ExpectedConditions.visibilityOf(PartLabel));
			 wait.until(ExpectedConditions.visibilityOf(AddToCart));
	      Thread.sleep(3000);
			AddToCart.click();
			
				wait.until(ExpectedConditions.visibilityOf(text));
			System.out.println(	text.getText());
			
			return text.getText();
		
		
		
		
	}

}
