package SRSproject.SRSproject;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		}
		
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
		Thread.sleep(10000);
		WebElement SearchField = Cp.Searcfield();
		 Thread.sleep(5000);
		SearchField.click();
		SearchField.sendKeys(prop.getProperty("KeywordSearch"));
		 Thread.sleep(8000);
		List <WebElement>  listele1= driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
		
		 
		listele1.size();
		
		 Thread.sleep(5000);
		 WebDriverWait wait= new WebDriverWait(driver, 80);
		
		 wait.until(ExpectedConditions.visibilityOf(listele1.get(1)));
		listele1.get(1).click();
		
		
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
	String ReorderItemCount=msg.replaceAll("[^\\d]", "");
//	 String items =  driver.findElement(By.xpath("//span[text()='27 Items']")).getText();
//	 System.out.println(items);
	//System.out.println(ReorderItemCount);
	
	 Cp.ClickAddToReorder();
	 String msg1= Cp.Message();
	 System.out.println(msg);
		String ReorderItemAdded=msg.replaceAll("[^\\d]", "");
	//	System.out.println(ReorderItemAdded);
	
		 if(ReorderItemCount.equals(ReorderItemAdded))
		    {
		    	Assert.assertTrue(true);
		    	Reporter.log("Items are added from cart to Reorder List selected" , true);
		    	Thread.sleep(3000);
		    	Cp.KeepShopping().click();
		    	
//		    	Cp.viewcart().click();
		    	
		    	
		    }
		    else
		    {
		    	Reporter.log(" Not All Items are added from cart to Reorder List selected" , true);
				   
		    }
		
			
	}
	
	
}
