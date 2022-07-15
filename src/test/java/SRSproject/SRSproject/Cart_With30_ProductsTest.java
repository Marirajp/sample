package SRSproject.SRSproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Pages.BulkOrderPage;
import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.LoginPage;
import Pages.MiniCartPage;
import Pages.QuickOrderPadPage;
import Utils.Constants;

public class Cart_With30_ProductsTest extends BaseTest {

	CheckoutPage COp;
	ArrayList<String> MyList = null;
	int total_No_items;

	@Test(priority = 1, description = "Cart to Checkout Redirection ")
	public void Checkout_MoreProducts_Validation() throws InterruptedException, IOException {
		// BasePage.initializtion();

		Thread.sleep(8000);
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		Thread.sleep(5000);
		try {
			QuickOrderPadPage qp = new QuickOrderPadPage(driver);
			Thread.sleep(9000);
			qp.Fileupload();
			Thread.sleep(20000);
			BulkOrderPage Bp = new BulkOrderPage(driver);
			Bp.AddAllItem_TOCart().click();
			Thread.sleep(20000);
			MiniCartPage Mp = new MiniCartPage(driver);
			Mp.MiniCart().click();
			Mp.ClickViewCart();

			Thread.sleep(5000);

			CartPage Cp = new CartPage(driver);
			ArrayList<String> a1 = Cp.getItemName1();
			// System.out.println(a1);
			MyList = a1;
			String total_items = Cp.TotalNo_Items();
			int number = Integer.parseInt(total_items);
			total_No_items = number;
			// System.out.println(MyList);
			Thread.sleep(1000);

			Cp.clickOnProceedToCheckout();
			String title = driver.getTitle();
			Assert.assertEquals(title, Constants.CheckoutPageTitle);
			Reporter.log(title, true);
		} catch (Exception e) {
			driver.navigate().refresh();
			Thread.sleep(9000);
			MiniCartPage Mp = new MiniCartPage(driver);
			Mp.MiniCart().click();
			Mp.ClickViewCart();

			Thread.sleep(1000);

			CartPage Cp = new CartPage(driver);
			ArrayList<String> a1 = Cp.getItemName1();
			// System.out.println(a1);
			MyList = a1;
			String total_items = Cp.TotalNo_Items();
			int number = Integer.parseInt(total_items);
			total_No_items = number;
			// System.out.println(MyList);
			Thread.sleep(1000);

			Cp.clickOnProceedToCheckout();
			String title = driver.getTitle();
			Assert.assertEquals(title, Constants.CheckoutPageTitle);
			Reporter.log(title, true);
			System.out.println(
					"Due to High buffer on uploading csv with 30+ product, normal checkout flow has take place with existing cart items");
		}

		COp = new CheckoutPage(driver);
		COp.Shipto_Selection();

		COp.Branch_Selection();

		COp.PO_Number();
		COp.Ordernotes();
		COp.RequestedDate();

		COp.clickOnCalendarsNextBtn();
		List<WebElement> dateList = COp.clickOnSelectDate();
		COp.NextStep1().click();
		COp.ShipVia();
		Thread.sleep(3000);

		COp.NextStepp();

		CartPage Cp = new CartPage(driver);

		// ArrayList<String> a1= Cp.getItemName1();
		// System.out.println(a1);

		Thread.sleep(30000);

		List<WebElement> list2 = COp.getCheckout_ItemName();
		ArrayList<String> a2 = new ArrayList<String>();
		for (WebElement option : list2) {
			String text = option.getText();

			a2.add(text);
		}
		int items = a2.size();
		System.out.print("Total No of Items" + total_No_items);
		Assert.assertEquals(items, total_No_items);

	}

}
