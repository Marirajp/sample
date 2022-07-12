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
		
		for (int i = 0; i < 1; i++) {
		
//			WebDriver url = getUrl("https://fis-stg.heritageplus.com/");
			
			System.out.println(i+": Time Execution");	
			System.out.println(driver.getTitle());					
			Long loadtime = (Long)((JavascriptExecutor)driver).executeScript(
		            "return performance.timing.loadEventEnd - performance.timing.navigationStart;"); 
		
			  System.out.println(loadtime + " milliseconds");			
			continue ;	
			
		}
		}
	
	
	
	

}
