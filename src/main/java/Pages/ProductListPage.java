package Pages;


import java.util.List;

import org.openqa.selenium.Alert;
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

public class ProductListPage {

	WebDriverWait wait;
	WebDriver driver;
	Actions act;
	
	@FindBy(xpath="//Strong[text()='Register']") WebElement RegisterLink;
	@FindBy(xpath="/html/body/div[2]/main/div[4]/div[1]/div[2]/div[2]/ol/li[1]/div/a/span/span[1]/img") WebElement img;
	@FindBy(xpath="//a[@class='product photo product-item-photo']") WebElement Product;
	@FindBy(xpath="//a[@id='mode-list']") WebElement List;
	
	@FindBy(css=".products.wrapper.grid.products-grid") WebElement gridView;
	
	@FindBy(css="ol.products>li:nth-of-type(1)>div>a") WebElement firstProduct;
	@FindBy(xpath="(//input[@name='qty'])[1]") WebElement FirstItem_Qty;
    @FindBy(xpath="(//button[@title='Add to Cart'])[1]") WebElement AddToCart;
    @FindBy(xpath="//p[text()='has been added to your cart']") WebElement text;

	
	public ProductListPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String validatePlpTitle()
	{
          return driver.getTitle();
	}
	
	public String GuestUser_ClickRegister()
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		 js.executeScript("arguments[0].scrollIntoView();", List);
		 
		 WebDriverWait wait= new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(RegisterLink));
		RegisterLink.click();
		return driver.getCurrentUrl();
		
	}
	
	public ProductDetailPage GuestUser_ClickItem()
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		 js.executeScript("arguments[0].scrollIntoView();", List);
		 Product.click();
		 
		return new ProductDetailPage(driver);
		
	}
	
	public String AddItem() throws InterruptedException
	{
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		 js.executeScript("arguments[0].scrollIntoView();", List);
		 Thread.sleep(1000);
		FirstItem_Qty.sendKeys("2");
		 
		 WebDriverWait wait= new WebDriverWait(driver, 50);
		 wait.until(ExpectedConditions.visibilityOf(AddToCart));
	AddToCart.click();
	 
	wait.until(ExpectedConditions.visibilityOf(text));
System.out.println(	text.getText());
return text.getText();

	
	}
	
	
	

}
