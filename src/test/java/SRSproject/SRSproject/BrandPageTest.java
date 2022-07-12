package SRSproject.SRSproject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Utils.Constants;

public class BrandPageTest extends BaseTest {
	
	HomePage HP;
	@Test(priority=1,enabled=true)
	public void BandsHeaderValid() throws InterruptedException, IOException {
		Thread.sleep(2000);
		HP = new HomePage(driver);
		Thread.sleep(8000); 
		HP. mouseHoverToBrandsA();
		Thread.sleep(6000);
		HP. mouseHoverToBrandsB();
		Thread.sleep(5000);
		String URL = driver.getCurrentUrl();
		String Title = driver.getTitle();
		System.out.println(Title + "-> " + URL);
	if (URL.equals(prop.get("BrandKing_url"))) {
			System.out.println("The User is navigated to the Brand Website");

		} else {
			System.out.println("The User is navigated incorrectly");
		}

		Assert.assertEquals(URL, prop.get("BrandKing_url"));
	
		
	}
	@Test(priority=2,enabled=true)
	public void allBrandsValid() throws InterruptedException {
	
		HP = new HomePage(driver);
		Thread.sleep(3000);
		HP. mouseHoverToallBrands();
		Thread.sleep(3000);
		String URL = driver.getCurrentUrl();
		String Title = driver.getTitle();
		System.out.println(Title + "-> " + URL);
		
		System.out.println(Title + "-> " + URL);
		if (URL.equals(prop.get("BrandBalboa_url1"))) {
			System.out.println("The User is navigated to the Brand Website");

		} else {
			System.out.println("The User is navigated incorrectly");
		}

		
		
		Assert.assertEquals(URL, prop.get("BrandBASF_url"));
		
	}
	@Test(priority=3,enabled=true)
	public void SearchBrandName() throws InterruptedException {
		Thread.sleep(3000);
		HP = new HomePage(driver);
		Thread.sleep(3000);
		HP.SearchByKeywords();
		Thread.sleep(3000);
		String URL = driver.getCurrentUrl();
		//String ads = HP.ResultNotFound().getText();
		if(URL.equals(prop.getProperty("ADS_url"))) {
				System.out.println("NILL PRODUCTS");

			} else {
				System.out.println("PRODUCTS AVAIALABLE");
			
		}
		Assert.assertEquals(URL,prop.getProperty("ADS_url") );
		
	}
		@Test(priority=4,enabled=true)
		public void SearchBrandNamePCS() throws InterruptedException {
			
			HP = new HomePage(driver);
			Thread.sleep(5000);
			HP.SearchByKeywordPCS();
			Thread.sleep(5000);
			String URL = driver.getCurrentUrl();
			//String ads = HP.ResultNotFoundPCS().getText();
			if(URL.equals(prop.getProperty("T&K_url"))) {
					System.out.println("NILL PRODUCTS");

				} else {
					System.out.println("PRODUCTS AVAILABLE");
			Assert.assertEquals(URL, prop.getProperty("T&K_url"));
			}
		}
			@Test(priority=5,enabled=true)
			public void SearchBrandNamePEP() throws InterruptedException {
			
				HP = new HomePage(driver);
				Thread.sleep(5000);
				HP.SearchByKeywordPEP();
				Thread.sleep(6000);
				String URL = driver.getCurrentUrl();
				//String ads = HP.ResultNotFoundPEP().getText();
				if(URL.equals(prop.getProperty("jain_url"))) {
						System.out.println("NILL PRODUCTS");

					} else {
						System.out.println("The User is navigated incorrectly");
					
				}
				Assert.assertEquals(URL, prop.getProperty("jain_url"));
			}
	
			
@Test(priority=6,enabled=true)
public void SearchBrandNameQPS() throws InterruptedException {

	HP = new HomePage(driver);
	Thread.sleep(5000);
	HP.SearchByKeywordPEP();
	Thread.sleep(6000);
	String URL = driver.getCurrentUrl();
	//String ads = HP.ResultNotFoundPEP().getText();
	if(URL.equals(prop.getProperty("jain_url"))) {
			System.out.println("NILL PRODUCTS");

		} else {
			System.out.println("The User is navigated incorrectly");
		
	}
	Assert.assertEquals(URL, prop.getProperty("jain_url"));
}}