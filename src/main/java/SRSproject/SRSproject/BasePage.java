package SRSproject.SRSproject;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage
{ 

	public static Properties prop;
	public static  WebDriver driver;
	
	
	
	
	    //FIS
		//public static String configpath ="src/main/java/config_staging/configuration_staging_fis.properties";
		public static String configpath ="src/main/java/config_prod/config_prod_fis.properties";
		//public static String configpath ="src/main/java/config_staging2/config_stage2_fis.properties";
		
		//CPS
		//public static String configpath ="src/main/java/config_prod/config_prod_cps.properties";
		//public static String configpath ="src/main/java/config_staging2/config_stage2_cps.properties";
		//public static String configpath ="src/main/java/config_staging/configuration_staging_cps.properties";
		
		//NFI
		//public static String configpath ="src/main/java/config_staging2/config_stage2_nfi.properties";
		//public static String configpath ="src/main/java/config_prod/config_prod_nfi.properties"
	
        //WCC
		//public static String configpath="src/main/java/config_prod/config_prod_wolf.properties";
		
		//GLB
	//public static String configpath ="C:\\Users\\DELL\\eclipse-workspace_realtime\\heritageplus_Landscape\\src\\main\\java\\config_staging2\\configuration_staging2_glb.properties";
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
			WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
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
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
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
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);

		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("screenshot captured failed...");
		}

		return path;
	}
public static void jsClick(WebElement element) throws Exception {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	
		
	        js.executeScript("arguments[0].focus();", element);

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
	
	
	
	

}
