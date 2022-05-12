package Pages;

import java.util.ArrayList;
import java.util.List;

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

public class CartPage extends BasePage {
	
	WebDriverWait wait;
	WebDriver driver;
	Actions act;

	
	@FindBy(xpath="//a[@class='action showcart']") WebElement MiniCarticon;
	@FindBy(xpath="(//button[@title='Checkout'])[3]") WebElement proceedToCheckout;
	@FindBy(xpath="(//div[@class='product attribute sku'])[2]") WebElement MFGLabel;
	@FindBy(xpath="(//strong[@class='product-item-name'])[9]") WebElement NeedHelpmsg;
	@FindBy(xpath="//a[@class='action showcart']//i[1]") WebElement MiniCart;
	@FindBy(xpath="//tbody[1]/tr[1]/td[2]/span[1]/span[1]/span[1]") WebElement firstProductOfCart;
	@FindBy(xpath="//*[@id=\"shopping-cart-table\"]/tbody[1]/tr[1]/td[1]/div/strong/a") WebElement FirstProductName;
	
	@FindBy(xpath="/html/body/div[2]/main/div[3]/div/div[2]/div[1]/div[5]/div/span/span/span[1]") WebElement PDP_PriceofProduct;
	
	@FindBy(xpath="/html/body/div[1]/main/div[3]/div/div[2]/form/div[2]/table/tfoot/tr/td[2]/span[2]") WebElement cartSubtotal;
	
@FindBy(xpath="//*[@id='shopping-cart-table']/tbody/tr[@class='item-info']") List<WebElement> cartRow;
	
	@FindBy(xpath="//*[@id='shopping-cart-table']/tbody/tr[@class='item-info']/td") List<WebElement> cartCol;
	
@FindBy(css="#shopping-cart-table>tbody>tr>td.qty>div") List<WebElement> qtyLineItem;
	
	@FindBy(css="#shopping-cart-table>tbody>tr>td>div>strong") List<WebElement> itemName;
	@FindBy(xpath="(//div[@class='cart-count-wrapper']//span)[1]") WebElement NoofItems;

	
	@FindBy(xpath="(//input[@class='input-text qty'])[1]") WebElement qtyField;
	
	@FindBy(xpath="(//input[@class='input-text search ui-autocomplete-input'])[1]") WebElement SearchField;
	@FindBy(xpath="(//span[text()='Add to Cart'])[1]") WebElement AddTocart_btn;
	
	@FindBy(xpath="(//h1[@class='modal-title'])[2]") WebElement MsgOnReorder;
	@FindBy(xpath="/html/body/div[3]/aside[11]/div[2]/header/button") WebElement Close_btn;
	@FindBy(xpath="//button[@class='action primary add-to-reorder-pad']") WebElement AddToReorder;
	@FindBy(xpath="//select[@id='select-reorder-pad']") WebElement ReorderList;
	@FindBy(xpath="//span[text()='Keep Shopping']") WebElement Keepshopping_btn;
	@FindBy(xpath="//span[text()='View Reorder Pad']") WebElement viewcart ;
	
	
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String validatePrice()
	{
		String price= firstProductOfCart.getText();
		return price.replaceAll("[$,]", "");	
	}
	
	public String validatePriceOfItemInPDP() throws InterruptedException
	{
		FirstProductName.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		 js.executeScript("arguments[0].scrollIntoView();", MFGLabel);
		 
		 Thread.sleep(5000);
		 WebDriverWait wait= new WebDriverWait(driver, 80);
		 wait.until(ExpectedConditions.visibilityOf(PDP_PriceofProduct));
		
		String PDP_price= PDP_PriceofProduct.getText();
		
		return PDP_price.replaceAll("[$,]", "");	
	}
	
	
	public String validateCartSubtotal()
	{
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// js.executeScript("arguments[0].scrollIntoView();", NeedHelpmsg);
		//wait = new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.visibilityOf(cartSubtotal));
		String subtotal=cartSubtotal.getText();
		return subtotal.replaceAll("[$,]", "");
	}
	
	public CheckoutPage clickOnProceedToCheckout()
	{
//		wait = new WebDriverWait(driver,90);
//		wait.until(ExpectedConditions.visibilityOf(proceedToCheckout));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", proceedToCheckout);
		return new CheckoutPage(driver);
	}
	
	public List<WebElement> enterQty()
	{
		return qtyLineItem;
	}

	public List<WebElement> getItemName()
	{
		return itemName;
	}
	public WebElement clickcart() throws Exception {
		
		MiniCart.click();
		return MiniCart;
	}
	public ArrayList<String> getItemName1()
	{
		// List<String> a1 = new ArrayList();
		 
		List<WebElement> list1= itemName;
		ArrayList<String> a1= new ArrayList<String>();
		for (WebElement option:list1)
		{
			String text= option.getText();
			
			a1.add(text);
			
		}
		return a1;
	}
	
	public List<WebElement> getRow()
	{
		return cartRow;
	}
	
	public List<WebElement> getCol()
	{
		return cartCol;
	}
	
	
	public WebElement enterQty1()
	{
		return qtyField;
	}
	

	public WebElement Searcfield()
	
	{
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		return SearchField;
	}
	
	public WebElement AddToCart()
	{
		return 	AddTocart_btn;
	}
	
	public void ReOrderSelection()
	{
		Select reorderlist = new Select(ReorderList);
		reorderlist.selectByValue(prop.getProperty("Reorder_List_Value"));
	}
	
	public String Message()
	{
		
	return MsgOnReorder.getText();
	
	}
	
	public void ClickAddToReorder() throws InterruptedException
	{
		AddToReorder.click();
		Thread.sleep(3000);
		
		
		}
	
	public WebElement KeepShopping()
	{
		return  Keepshopping_btn;
		
		
		}
	public WebElement viewcart()
	{
		return  viewcart;
		
		
		}
	public String NoofItems()
	{
		String text = NoofItems.getText();
		return text;
				
		
		}
	
}

