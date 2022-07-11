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


public class LoadTimeCalculation extends BasePage  {
	
	@BeforeTest
	public void login() throws Exception {
//		getbrowser("chrome");
		
		
		initializtion();
//		getbrowser("chrome");
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		
		
	}
	@Test
	public void LoadTime() throws Exception {
		
		
		for (int i = 0; i < 3; i++) {
		
//		
		
		//long startTime = System.currentTimeMillis();
			WebDriver url = getUrl("https://cps-stg2.heritageplus.com/rain-bird-1800-series-spray-head-a44120");
			
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
