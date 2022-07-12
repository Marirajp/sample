package SRSproject.SRSproject;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class BaseTest extends BasePage {
	
	
//	@BeforeSuite
//	public void setUp() throws IOException {
//		initializtion();
//		driver.close();
//	}
	

	@BeforeClass
    public void beforeClass() throws IOException{
      System.out.println("Before Class method");
      initializtion();
    }
	
	
	@AfterClass
	public void tearDown() {
	driver.quit();
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
