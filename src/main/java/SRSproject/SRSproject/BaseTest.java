package SRSproject.SRSproject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utils.BaseClass;

public class BaseTest extends BasePage {
	
	
	@BeforeSuite
	public void setUp() throws IOException {
		initializtion();
		driver.close();
	}
	
//	@BeforeMethod
//	public void setUp() throws IOException {
//		initializtion();
//	}

//	@AfterClass
//	public void tearDown() {
//		driver.quit(); 
//	}

//	@AfterClass
//	public void tearDown() {
//		BasePage.driver.quit();
//	}

}
