package SRSproject.SRSproject;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Ignore;
import org.openqa.selenium.By;

import org.openqa.selenium.By.ById;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.openqa.selenium.support.*;



import Pages.CartPage;
import Pages.LoginPage;
import Pages.MiniCartPage;
import Pages.ProductListPage;
import Utils.Constants;
import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.Explicit;
import net.bytebuddy.asm.Advice.Enter;

public class CartPageTest  extends BaseTest
{

	CartPage Cp;
	String Total_items_in_cart ;
	

	@Test(priority=1, description= "Minicart to cartpage redirection")
	public void MiniCartToCartPage_Redirection() throws InterruptedException, IOException 
	{
		BasePage.initializtion();
		Thread.sleep(8000);
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		Thread.sleep(10000);
		MiniCartPage Mp= new MiniCartPage(driver);
		Mp.MiniCart().click();
		Thread.sleep(8000);
		Mp.ClickViewCart();
	String	CartPageTitle= driver.getTitle();
	Assert.assertEquals(CartPageTitle,Constants.CartPageTitle);
	
}
	
 
@Test(priority=2, description= "Pricing validaiton")
	public void ProductInformationValidation() throws InterruptedException
	{
	
	Cp= new CartPage(driver);
	
		String price=Cp.validatePrice();
		Float cartPrice=Float.parseFloat(price);
	
		String price_pdp=	Cp.validatePriceOfItemInPDP();
		
		Thread.sleep(5000);
		driver.navigate().back();
		
		Thread.sleep(5000);
		
		Float price2=Float.parseFloat(price_pdp);
		
		if(cartPrice.equals(price2))
		{
			Assert.assertEquals(cartPrice, price2);
			Reporter.log("Items price is same in PDP and Cart Page i.e "+ "Cart Price : " +cartPrice +" = "+ "PDP Price : " +price2, true);
		}
		else
		{
			Reporter.log("Items price differs on pdp and cart page i.e "+"Cart Price : " +cartPrice +" = "+ "PDP Price : " +price2,true);
		}
		
	
	}
	
	
	
	@Test(priority=3,description= "Subtotal validation")
	public void CartSubtotalValidationfn() throws InterruptedException
	{
		Cp= new CartPage(driver);
		float sum=0;
			List<WebElement> list=driver.findElements(By.xpath("//td[5]"));
			
			
			ArrayList<Float> a1= new ArrayList<Float>();
			for (WebElement option:list)
			{
				String text= option.getText();
				
				String tim=text.replaceAll("[$,]", "");
				float f=Float.parseFloat(tim);
				a1.add(f);
				 sum=sum+f;
				 System.out.println(sum);
			}
			
		
			
			
	
			System.out.println( sum+" The subtotal after adding line item");
			
		//System.out.println( Math.round(sum)+" The subtotal after adding line item");
		
		String cartsubtotal =Cp.validateCartSubtotal();	
		Float subtotal=Float.parseFloat(cartsubtotal);
		System.out.println(subtotal);
		if(subtotal.equals(sum))
			
		{
			Assert.assertTrue(true);
			System.out.println("the line item total " +sum+" = "+"the cart subtotal displayed " +subtotal);
		}else
			System.out.println(subtotal + "Total is not same ");
		System.out.println( sum+ "Total is not same ");
		
	}

	
	@Test(priority=4, description= "Updating cart Validation")
	public void CartUpdateValidation() throws InterruptedException

	{
		WebElement enterQty= Cp.enterQty1();
		enterQty.clear();
		enterQty.sendKeys(prop.getProperty("Quantity"));
		enterQty.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
	String	Price1= driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody[1]/tr[1]/td[5]/span/span")).getText();
		String t1=Price1.replaceAll("[$,]", "");
		Float ExtendedPrice=Float.parseFloat(t1);
		
		
		
		String	Price2= driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody[1]/tr[1]/td[2]/span/span/span")).getText();
				String t2=Price2.replaceAll("[$,]", "");
				Float ActualPrice=Float.parseFloat(t2);
				System.out.println("Actual Price is"+ ActualPrice);
				System.out.println("Extended Price"+ExtendedPrice);
				
				Thread.sleep(3000);
String	qty = prop.getProperty("Quantity");
Float quantity=Float.parseFloat(qty);

float MultipliedPrice= ActualPrice * quantity;

				
				if( Float.compare(MultipliedPrice,ExtendedPrice)== 0)
				{
					Assert.assertTrue(true);
					System.out.println(" Cart Got Updated");
				}
	}
	
	
	@Test(priority=5, description= "Adding item to cart using search option in cart page")
	public void AddItemToCart_Validation() throws Exception

	{
		Thread.sleep(18000);
		WebElement SearchField = Cp.Searcfield();
		 Thread.sleep(25000);
		SearchField.click();
		SearchField.sendKeys(prop.getProperty("KeywordSearch"));
		 Thread.sleep(8000);
		List <WebElement>  listele1= driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
		
		 
		listele1.size();
		
		 Thread.sleep(5000);
		 WebDriverWait wait= new WebDriverWait(driver, 80);
		
		 wait.until(ExpectedConditions.visibilityOf(listele1.get(0)));
		listele1.get(0).click();
		
		
		Cp.AddToCart().click();
		
		String a = SearchField.getText();
		System.out.print(a);
		String b="";
		
		Assert.assertEquals(b, a);
		
		
		
			
	}
	
	@Test(priority=6,description= "Adding items to an reorder list")
	public void Reorder_Validation() throws InterruptedException

	{
		Thread.sleep(9000);
	Cp.ReOrderSelection();
	Thread.sleep(8000);
	String msg= Cp.Message();
	System.out.println(msg);
	Total_items_in_cart = msg.substring(14, 16);
	System.out.println("Total_Itemsin Cart" +Total_items_in_cart);

	String ReorderItemCount=msg.replaceAll("[^\\d]", "");

	
	 Cp.ClickAddToReorder();
	 String msg1= Cp.Message();
	 System.out.println(msg);
		String ReorderItemAdded=msg.replaceAll("[^\\d]", "");
		
	
		 if(ReorderItemCount.equals(ReorderItemAdded))
		    {
		    	Assert.assertTrue(true);
		    	Reporter.log("Items are added from cart to Reorder List selected" , true);
		    	Thread.sleep(3000);
		    	Cp.KeepShopping().click();
		    	

		    	
		    	
		    }
		    else
		    {
		    	Reporter.log(" Not All Items are added from cart to Reorder List selected" , true);
				   
		    }	
	}
	
	@Test(priority=9, description= "Adding item  cart to reorder validate the item will be added or nt  " )
	public void AddItemToCart_ValidationTo_Reorder() throws Exception

	{
		Thread.sleep(5000);
		MiniCartPage Mp= new MiniCartPage(driver);
		Mp.MiniCart().click();
		Thread.sleep(8000);
		Mp.ClickViewCart();
	Thread.sleep(3000);
		Cp.CreatenewReOrder();
		Thread.sleep(3000);
	 Cp.createreordername().sendKeys(prop.getProperty("New_Reorder_Pad"));
	 
		
		Cp.Clickbtn_createReorder();
		Thread.sleep(5000);
		
		Cp.ReOrderSelectionaftercreate_NewReorderpad();
		Thread.sleep(3000);
		String msg= Cp.Message();
		System.out.println(msg);
		String ReorderItemCount=msg.replaceAll("[^\\d]", "");

		 Cp.ClkAddToReorder(); 
		 String msg1= Cp.Message();
			String ReorderItemAdded=msg.replaceAll("[^\\d]", "");
	
			 if(ReorderItemCount.equals(ReorderItemAdded))
			    {
			    	Assert.assertTrue(true);
			    	Reporter.log("Items are added from cart to Reorder List selected" , true);
			    	Thread.sleep(3000);
			    	
			    	Cp.ViewReorderPad();
			    	String Totalitems = Cp.Totalitems_in_Reorderpad().getText();
			    	
			    	
		
			    	System.out.println("Total items in Reorderpad : " + Totalitems);
			    	System.out.println("Total items in CartPage :"+Total_items_in_cart);
			    	
			    	if (Totalitems.equalsIgnoreCase(Total_items_in_cart)) {
			    		System.out.println("Products in cart to Reorderpad QTY is same");
						
					}
			    	
			    	
			    	Thread.sleep(3000);
			    	

			    	driver.close();
					
			    	
			    	
			    }
			    else
			    {
			    	Reporter.log(" Not All Items are added from cart to Reorder List selected" , true);
			    	driver.close();
					 
			    }
			
	    
			 
				
		
		
			
	}
	@Test(priority = 7, description = "BackOrder Warning")
	public void Backorder_Warning() throws Exception {
	    WebElement stock_count = driver.findElement(By.xpath("//td[@class ='col stock']/span[1]"));
	    if ((stock_count.getText().equals("In Stock"))) {
	        Cp= new CartPage(driver);
	        WebElement enterQty = Cp.enterQty1();
	        enterQty.clear();
	        enterQty.sendKeys("2000");
	        enterQty.sendKeys(Keys.ENTER);
	        Thread.sleep(9000);
	        driver.findElement(By.xpath("(//div[@class='cart item message error']/span[1])[1]"));
	        Reporter.log("Product was in stock now Backorder Warning is Present", true);

	    }
	    else if ((stock_count.getText().equals("Call for availability"))){
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("(//div[@class='cart item message error']/span[1])[1]"));
	        Reporter.log("Call for Availability is there and Backorder Warning is Present", true);
	    }
	    else {
	        WebElement enterQty = Cp.enterQty1();
	        enterQty.clear();
	        String s = stock_count.getText();
	        int i = Integer.parseInt(s);
	        int quantity = i+1;
	        driver.findElement(By.xpath("//*[@class='input-text qty'][1]")).sendKeys("" + quantity +"\n");
	        Thread.sleep(9000);
	        WebElement backorder_msg = driver.findElement(By.xpath("(//div[@class='cart item message error']/span[1])[1]"));
	        Reporter.log("Quantity was present now Backorder Warning is Present", true);
	    }


	}
	
	@Test(priority = 6, description = "Inventory Count")
	public void Inventory_Count() throws Exception {
	    WebElement stock_count = driver.findElement(By.xpath("//td[@class ='col stock']/span[1]"));
	    if ((stock_count.getText().equals("In Stock"))) {
	        Reporter.log("In stock Text is Present ", true);
	    } else if ((stock_count.getText().equals("Call for availability"))) {
	        Reporter.log("Call for Availability Text is Present", true);
	    } else {
	        if (StringUtils.isNumeric(String.valueOf(stock_count.getText()))) {
	            Reporter.log("Product Inventory count is Present", true);
	        } else {
	            Reporter.log("Invalid data is Present", true);
	        }

	    }
	    
	}
	@Test
	public void CartPage_Count() throws InterruptedException, IOException 
	{
		BasePage.initializtion();
		Thread.sleep(8000);
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		Thread.sleep(10000);
		MiniCartPage Mp= new MiniCartPage(driver);
		Mp.MiniCart().click();
		Thread.sleep(8000);
		Mp.ClickViewCart();
		  Cp= new CartPage(driver);
		  Cp.PageSize();
		  driver.close();
}
	
}
