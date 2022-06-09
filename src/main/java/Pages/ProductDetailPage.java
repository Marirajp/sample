package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SRSproject.SRSproject.BasePage;

public class ProductDetailPage extends BasePage  {
	WebDriverWait wait;
	WebDriver driver;
	Actions act;
	
	@FindBy(xpath="//strong[text()='Register']") WebElement RegisterLink;
	@FindBy(xpath="(//div[@class='product attribute part'])[2]") WebElement PartLabel;
	@FindBy(xpath="//span[text()='Add to Cart']") WebElement AddToCart;
	
	@FindBy(xpath="//p[text()='has been added to your cart']") WebElement text;
	
	@FindBy(xpath="//div[@class='block-title title']") WebElement recently_viewed;
	
	@FindBy(css="#maincontent > div.columns > div > div.block.recentlyviewed > div.block-content.content > div > ol > div > div > div.slick-slide.slick-current.slick-active > div > li > div > div > strong > a") WebElement recently_viwed_First_item;

	@FindBy(xpath="//select[@class='reorder-pad-list']") WebElement reorder_pad;
	@FindBy(xpath="//div[@id='tab-label-additional']") WebElement Specs;
	
	@FindBy(xpath="//span[text()='Brand:']") WebElement brand_label;
	
	
	@FindBy(xpath = "/html/body/div[2]/main/div[3]/div/div[6]/div[2]/div/ol/div/div/div[5]/div/li/div/div/div[4]/div[1]/form/button[3]") WebElement recentlyviwed_add;	
	
	@FindBy(xpath="//a[@id='mode-list']") WebElement List;
	@FindBy(css= "#amasty-shopby-product-list > div.products.wrapper.grid.products-grid > ol > li > div > div.product.details.product-item-details > strong > a") WebElement Product;
	  @FindBy(id = "search") WebElement SearchField; 
	  
	  @FindBy(xpath="//strong[@id='block-related-heading']") WebElement RelatedProduct_Title;
	  @FindBy(xpath="(//button[@class='action tocart primary'])[1]") WebElement Related_AddToCart;
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
	
	public String AddingItem() throws Exception 
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		 js.executeScript("arguments[0].scrollIntoView();", PartLabel);
		 
		 WebDriverWait wait= new WebDriverWait(driver, 50);
		
			wait.until(ExpectedConditions.visibilityOf(PartLabel));
			 wait.until(ExpectedConditions.visibilityOf(AddToCart));
	      Thread.sleep(5000);
	      jsClick(AddToCart);
//			AddToCart.click();
			
				wait.until(ExpectedConditions.visibilityOf(text));
			System.out.println(	text.getText());
			
			return text.getText();
		
		
		
		
	}
	
	public String Recently_viwed_Title()
	{
		moveToElement(recently_viewed);
		return recently_viewed.getText();
	
	}
	
	public WebElement Recently_viwed_Item()
	{


		scrollUpandDownUsingElement(recently_viewed);
		return recently_viwed_First_item;
	}

	public WebElement Spec_PDP_Title()
	
	{
		scrollUpandDownUsingElement(reorder_pad); 
		
		return Specs;
		
	}
	
public WebElement Recently_viwed_add()
	
	{
	scrollUpandDownUsingElement(recently_viewed);
	//recentlyviwed_add.click();
	
return	recentlyviwed_add;
		
	}

public String Adding_Recentlview_Sucssmsg() throws InterruptedException 
{
	

	 
	 WebDriverWait wait= new WebDriverWait(driver, 50);
	
		
		
			wait.until(ExpectedConditions.visibilityOf(text));
		System.out.println(	text.getText());
		
		return text.getText();
	
	
	
	
}

public void SearchByKeyword() throws InterruptedException 


{

SearchField.clear();
SearchField.click();

  SearchField.sendKeys(prop.getProperty("Related_Product"));
	  SearchField.sendKeys(Keys.ENTER);
	  Thread.sleep(5000);
 }


public void RelatedProducts() throws InterruptedException 
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	 js.executeScript("arguments[0].scrollIntoView();", List);
	 Product.click();
} 
public String RelatedProductsTitle() throws InterruptedException 
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	 js.executeScript("arguments[0].scrollIntoView();", Specs);
	return RelatedProduct_Title.getText();
}

public WebElement Related_add_tocart()
{
	return Related_AddToCart;
}
}
