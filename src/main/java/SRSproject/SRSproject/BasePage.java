package SRSproject.SRSproject;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.collections.LRUMap;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

public class BasePage
{ 

	public static Properties prop;
	public static WebDriver driver;
	
	
	

	//PCS
	//	public static String configpath ="src/main/java/config_staging/configuration_staging_pcs.properties";
		public static String configpath="src/main/java/config_staging2/configuration_staging2_pcs.properties";
	//	public static String configpath ="src/main/java/config_prod/config_prod_pcs.properties";
	//	public static String configpath ="src/main/java/config/configuration_pcs.properties"; //QA
	
	
	//QPS
	//	public static String configpath ="src/main/java/config_staging/configuration_staging_qps.properties";
	//	public static String configpath ="src/main/java/config_staging2/configuration_staging2_qps.properties";
	//  public static String configpath ="src/main/java/config_prod/config_prod_qps.properties";
    
	//glb
	//	public static String configpath ="src/main/java/config_prod/config_prod_glb.properties";
	//	public static String configpath ="src/main/java/config_staging/configuration_staging_glb.properties";
	 // public static String configpath= "src/main/java/config_staging2/configuration_staging2_glb.properties";
	
	//Aqua-gon
	//public static String configpath="src/main/java/config_staging2/configuration_staging2_Aquagon.properties";
	//public static String configpath="src/main/java/config_prod/config_prod_Aquagon.properties";
		
	//PEP	
     //public static String configpath="src/main/java/config_staging2/configuration_staging2_PEP.properties";
	//public static String configpath="src/main/java/config_prod/config_prod_PEP.properties";
		
	//FWP	
	//public static String configpath ="src/main/java/config_staging2/configuration_staging2_FWP.properties";

		
	//APS 
    
	//public static String configpath = "src/main/java/config_prod/config_prod_Aps.properties";
	// public static String configpath="src/main/java/config_staging2/configuration_staging2_Aps.properties";
	  
    
	//TPS 
	//public static String configpath ="src/main/java/config_prod/config_prod_Tps.properties";
	 // public static String configpath="src/main/java/config_staging2/configuration_staging2_Tps.properties";
	
	//Conely
	//public static String configpath = "src/main/java/config_prod/configuration_pro_conley.properties";
	 //  public static String configpath="src/main/java/config_staging2/configuration_staging2_Tps.properties";

	//Emsco
	//public static String configpath ="src/main/java/config_prod/configuration_pro_emscp.properties";
	
		
	//to run your selenium’s tests in parallel, Webdriver object should be thread-safe, i.e. a single object can be used with multiple threads at the same time without causing problems. 
	//thread local driver object for webdriver,
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	
	//multithreading  
	public static synchronized WebDriver getDriver()
	{
		return tdriver.get();
		
	}
	
	public static WebDriver initializtion() throws IOException 
	{
		prop = new Properties();
	
		FileInputStream ip = new FileInputStream(configpath);
		prop.load(ip);

		String BrowserName= prop.getProperty("browser");
		
		if(BrowserName.equalsIgnoreCase("chrome"))
		{
			
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
				
				//driver = new ChromeDriver();
				ChromeOptions options = new ChromeOptions();

				Map<String, Object> prefs = new HashMap<String, Object>();
//				String path = System.getProperty("user.dir")+ "\\DownloadCSV" ;
				prefs.put("download.default_directory", System.getProperty("user.dir") + "\\DownloadCSV");

				options.setExperimentalOption("prefs", prefs);
				driver = new ChromeDriver(options);
				
				

//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
		}
		else {
			WebDriverManager.edgedriver().browserVersion("10.0.18362.1139").setup();
			driver = new EdgeDriver();
//			EdgeDriver driver = new EdgeDriver();
//			System.out.println(driver.getCapabilities().toString());
		}
		
	//	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		((JavascriptExecutor)driver).executeScript("window.resizeTo(screen.width, screen.height)");
		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(2558,1378)); 
		driver.findElement(By.tagName("body")).sendKeys(Keys.F11);
		driver.get(prop.getProperty("url"));
		tdriver.set(driver);
		return getDriver();
	}
	public static void waitUntilElementVisibility(WebElement element) throws Exception {
		try {
			WebDriverWait wb = new WebDriverWait(driver, 50);
			wb.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
		e.printStackTrace();
		}
			}
	
	/***
	 * 
	 * screenshot
	 * 
	 *
	 */
	
	public String getScreenshot() throws IOException, InterruptedException
	{
		
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/build/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		String absolutePath = destination.getAbsolutePath();
		
		

		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("screenshot captured failed...");
		}

		return absolutePath;
	}
	
	public static String   Reportname() {
		prop = new Properties();
		return prop.getProperty("site");
	}
	
	//javascript click
	
	public static void jsClick(WebElement element) throws Exception {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	
		
	      //  js.executeScript("arguments[0].focus();", element);

	        js.executeScript("arguments[0].scrollIntoView(true);", element);
	       js.executeScript("arguments[0].click()", element);
	    }

	public static WebDriver getbrowser(String browsername) throws Exception {
		try {
			if (browsername.equalsIgnoreCase("chrome")) {
				
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				
			} else if (browsername.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\Driver\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				
			}else if (browsername.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\Driver\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
			}else {
				throw new Exception("Not a valid Browser");
			}
			return driver;
			
		} catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException();
		}
	} 	
	
	public static WebDriver getUrl(String url) throws Exception {
		try {
			driver.get(url);
		
//			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			return driver ;
		} catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException();
		}
	}
	
	public static void moveToElement(WebElement element) {
		try {
			waitUntilElementVisibility(element);
			Actions ac = new Actions(driver);
			ac.moveToElement(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
	
	public static void scrollUpandDownUsingElement(WebElement element) {
		try {
			waitUntilElementVisibility(element);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	
	

}
