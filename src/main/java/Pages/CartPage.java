package Pages;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.fraction.ProperBigFractionFormat;
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
import org.testng.annotations.Factory;

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
	@FindBy(xpath="//span[text()[normalize-space()='Use these Reorder Pads to save items and quantities for fast reordering in the future.']]/following::input") WebElement createreordername ;
	@FindBy(xpath ="//span[text()='Create Reorder Pad']") WebElement Clickbtn_createReorder;
	@FindBy(xpath="//span[@class='item-no']") WebElement Total_No_Items;
	

	
	@FindBy(xpath="(//span[@class='cart-price']//span)[2]") WebElement UOM;
	
	@FindBy(xpath="(//span[@class='toolbar-number'])[1]") WebElement number;
	
	
	@FindBy(xpath ="//span[text()='View Reorder Pad']") WebElement View_Reorder_Pad ;
	
	@FindBy(xpath="(//button[@class='action primary add-to-reorder-pad'])[1]") WebElement ClkAddToReorder ;
	
	@FindBy(xpath="(//div[@class='pad-items']//span)[1]") WebElement Totalitems_in_Reorderpad ;
	
@FindBy(xpath="(//h1[@class='modal-title'])[2]")WebElement	Msg ;
	
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
	
	
	public String validateCartSubtotal() throws InterruptedException
	{
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// js.executeScript("arguments[0].scrollIntoView();", NeedHelpmsg);
		//wait = new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.visibilityOf(cartSubtotal));
		Thread.sleep(9000);
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
	
	public void ReOrderSelection1()
	{
		Select reorderlist = new Select(ReorderList);
		reorderlist.selectByValue(prop.getProperty("Reorder_List_Value1"));
	}
	
	public void ReOrderSelection()
	{
		Select reorderlist = new Select(ReorderList);
		reorderlist.selectByValue(prop.getProperty("Reorder_List_Value"));
	}
	
	public void  CreatenewReOrder() throws InterruptedException
	{
		Select reorderlist = new Select(ReorderList);
		reorderlist.selectByVisibleText("Create New Reorder Pad");
		
		
		
		
		
		
	}
	public WebElement  createreordername() {
		createreordername.click();
		return createreordername ;	
			
	}
	public WebElement Clickbtn_createReorder() {
		Clickbtn_createReorder.click();
		return Clickbtn_createReorder;
	}
	
	public void ReOrderSelectionaftercreate_NewReorderpad()
	{
		Select reorderlist = new Select(ReorderList);
		reorderlist.selectByVisibleText(prop.getProperty("New_Reorder_Pad"));
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
	
	public void ClkAddToReorder() {
		ClkAddToReorder.click();
		
	}
	public WebElement KeepShopping()
	{
		return  Keepshopping_btn;
		
		
		}
	
	public WebElement ViewReorderPad() throws Exception {
		
		jsClick(View_Reorder_Pad);
		return View_Reorder_Pad;
		
	}
	
	public WebElement Totalitems_in_Reorderpad() {
		
		
		
		return Totalitems_in_Reorderpad;
		
		
	}
	public WebElement Msg() {
		
		
		
		return Msg;
		
		
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

	public int PageSize() throws IOException {
	
	
		int PaginationSize = driver.findElements (By.xpath("//*[@id=\"form-validate\"]/div[2]/div[1]/div/div/ul/li")).size();
		List <String> names = new ArrayList<String>() ;
		System.out.println(PaginationSize);
	
		
		for(int i = 1; i<=PaginationSize-1;i++) {
			String PagenationSelctor="//*[@id=\"form-validate\"]/div[2]/div[1]/div/div/ul/li["+i+"]" ;
			driver.findElement(By.xpath(PagenationSelctor)).click();
			
			List<WebElement>listofNames=     driver.findElements(By.xpath("//td[@data-th='Item']"));
			for ( WebElement name : listofNames){
	 			names.add(name.getText());
			
		}
		}
		for (String  naame : names) {
			System.out.println(naame);
	    
		}
		int size = names.size();
		
		System.out.println(size);
		
		return size;
		
		
	}
	public String TotalNo_Items()
	{ 
		String total_items= Total_No_Items.getText();
	
		return total_items.replaceAll(" .*", "");

	}
	public WebElement ReorderpadList() {
		return  ReorderList;
				}
	


	
	public WebElement  UOM()
	{
		return UOM;
}
	
	public int Number()
	{
		
		int total_item=0;
		String items= TotalNo_Items();
		int i=Integer.parseInt(items);  
		if(i>20)
		{
		String num= number.getText();
		String[] strArray = null;  
			strArray = num.split(" ");  
		String num1= strArray[5];
		int i2=Integer.parseInt(num1);
		System.out.println("value"+num1);
		total_item = i2;
		
	}
		else
		{
			String num2= TotalNo_Items();
			int i3=Integer.parseInt(num2);  
			System.out.println("value"+i3);
			total_item = i3;
		}
		
		
		return total_item;
}
}

