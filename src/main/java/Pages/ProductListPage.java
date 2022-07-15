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

public class ProductListPage extends BasePage{

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
	@FindBy(xpath="(//input[@name='qty'])[2]") WebElement Seconditem_Qty;
	@FindBy(xpath="(//input[@name='qty'])[3]") WebElement thirditem_Qty;
	@FindBy(xpath="(//input[@name='qty'])[4]") WebElement Fourthitem_Qty;
	@FindBy(xpath="(//input[@name='qty'])[5]") WebElement Fifthitem_Qty;
    @FindBy(xpath="(//button[@title='Add to Cart'])[1]") WebElement AddToCart;
    @FindBy(xpath="//button[@title='Add all products to Cart']") WebElement Add_all_itmes_to_cart;
    @FindBy(xpath="//p[text()='has been added to your cart']") WebElement text;

    @FindBy(xpath="//a[@class='logo']") WebElement logo;
    @FindBy(xpath="//div[@id='swal2-content']") WebElement text1;
    @FindBy(xpath="//strong[text()='Recently Viewed']") WebElement Recently_viwed_Title;
    
    @FindBy(css = "#maincontent > div > div.sidebar.sidebar-main > div > div > div.block-content.content > div:nth-child(1) > div > strong > a") WebElement First_Recent_Item;
    @FindBy(xpath="(// button[@class='action tocart primary recentlyviewed'])[1]") WebElement Add_Recently_viwed;
    @FindBy(xpath="(//span[@class='price-uom'])[1]") WebElement UOM;
    @FindBy(xpath="/html/body/div[2]/main/div[4]/div[1]/div[2]/div/div[2]/ol/li[1]/div/div[2]/div[4]/span/span/span[1]") WebElement price;
	
	
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
		 
		 WebDriverWait wait= new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(RegisterLink));
		RegisterLink.click();
		return driver.getCurrentUrl();
		
	}
	public String AddmultipleItem() throws Exception
	{
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		 js.executeScript("arguments[0].scrollIntoView();", List);
		
		 try {
         
			 FirstItem_Qty.sendKeys("2");
			 Seconditem_Qty.sendKeys("2");
			 thirditem_Qty.sendKeys("2");
			 Thread.sleep(3000);
			 scrolltoTopPage();
			 Add_all_itmes_to_cart.click();
			 WebDriverWait wait= new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(text1));
	System.out.println(	text1.getText());
		} catch (Exception e) {
			 Seconditem_Qty.sendKeys("2");
			 thirditem_Qty.sendKeys("2");
			 Fourthitem_Qty.sendKeys("2");
			 Fifthitem_Qty.sendKeys("1");
			 Thread.sleep(3000);
			 scrolltoTopPage();
			 Add_all_itmes_to_cart.click();
			 WebDriverWait wait= new WebDriverWait(driver, 40);
	System.out.println(	text1.getText());
		}
		 WebDriverWait wait= new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.visibilityOf(text1));
	
		
return text1.getText();

	
	}
	public ProductDetailPage GuestUser_ClickItem() throws Exception
	{
		jsClick(Product);

		 
		return new ProductDetailPage(driver);
		
	}
	
	public String AddItem() throws Exception
	{
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		 js.executeScript("arguments[0].scrollIntoView();", List);
		 
		 Thread.sleep(500);
		// jsClick(FirstItem_Qty);
		FirstItem_Qty.sendKeys("2");
		 
		 WebDriverWait wait= new WebDriverWait(driver, 50);
		 wait.until(ExpectedConditions.visibilityOf(AddToCart));
	AddToCart.click();
//	 Thread.sleep(8000);
	wait.until(ExpectedConditions.visibilityOf(text));
System.out.println(	text.getText());
return text.getText();

	
	}
	
	public WebElement Recently_Viewed() throws InterruptedException
	
	{
		Thread.sleep(3000);
          return Recently_viwed_Title;
	}
	
	public WebElement First_Recently_Viewed() throws InterruptedException
	{
		Thread.sleep(2000);
		return First_Recent_Item;
	}
	
	public WebElement Add_Recently_viwed()
	{
	return Add_Recently_viwed;
	}
	
	public String AddItem_recently_viewed() throws InterruptedException
	{
		WebDriverWait wait= new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(text));
	System.out.println(	text.getText());
	return text.getText();

		
		}
	public String Uom()
	{
		
          return UOM.getText();
	}
	
	public String Price() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		 js.executeScript("arguments[0].scrollIntoView();", List);
		 Thread.sleep(1000);
          return price.getText();
	}
	

}
