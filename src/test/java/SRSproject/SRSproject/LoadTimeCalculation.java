package SRSproject.SRSproject;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Utils.BaseClass;

public class LoadTimeCalculation extends BasePage  {
	
	@BeforeTest
	public void login() throws Exception {
		
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		getbrowser("chrome");
		
	}
	@Test
	public void LoadTime() throws Exception {
		
		for (int i = 0; i < 3; i++) {
		
//		getbrowser("chrome");
		
		//long startTime = System.currentTimeMillis();
			WebDriver url = getUrl("https://fis-stg2.heritageplus.com/checkout/cart/");
			
			System.out.println(url);
			
			System.out.println(driver.getTitle());		
//			
//			long endTime = System.currentTimeMillis();
//			long totalTime = endTime - startTime;
//			System.out.println("Total Page Load Time: " + totalTime + " milliseconds");
			
			
			
			Long loadtime = (Long)((JavascriptExecutor)driver).executeScript(
		            "return performance.timing.loadEventEnd - performance.timing.navigationStart;");        
		        System.out.println(loadtime + " milliseconds");
			continue ;
//			 
////			    
		}
		}
	
	
	
	

}
