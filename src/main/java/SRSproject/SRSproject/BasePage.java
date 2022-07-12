package SRSproject.SRSproject;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage
{ 

	public static Properties prop;
	public static  WebDriver driver;
	
	
	
	
	    //FIS
	    //public static String configpath ="src/main/java/config_staging/configuration_staging_fis.properties";
		//public static String configpath ="src/main/java/config_prod/config_prod_fis.properties";
		// public static String configpath ="src/main/java/config_staging2/config_stage2_fis.properties";
		
		//CPS
		//public static String configpath ="src/main/java/config_prod/config_prod_cps.properties";
		//public static String configpath ="src/main/java/config_staging2/config_stage2_cps.properties";
		//public static String configpath ="src/main/java/config_staging/configuration_staging_cps.properties";
		
		//NFI
	    //public static String configpath ="src/main/java/config_staging/configuration_staging_nfi.properties
		//public static String configpath ="src/main/java/config_staging2/config_stage2_nfi.properties";
		public static String configpath ="src/main/java/config_prod/config_prod_nfi.properties" ;
	
        //WCC
		//public static String configpath="src/main/java/config_prod/config_prod_wolf.properties";
		// public static String configpath="src/main/java/config_staging2/config_stag2_wolf.properties";
		//public static String configpath ="src/main/java/config_staging/configuration_staging_Wolf.properties" ;
	//GLB
	   // public static String configpath ="src/main/java/config_prod/config_prod_glb.properties";
		
	
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
//				System.setProperty("webdriver.chrome.driver",
//						System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
				
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
	
	public static String addScreenshot() throws IOException {
	    File scrFile = ((TakesScreenshot) BasePage.driver).getScreenshotAs(OutputType.FILE);
	    String encodedBase64 = null;
	    FileInputStream fileInputStreamReader = null;
	    
	    String destination = "../build/Screenshots/" + System.currentTimeMillis() + ".jpg";
	    File finalDestination = new File(destination);
	    FileUtils.copyFile(scrFile, finalDestination);

	    try {
	        fileInputStreamReader = new FileInputStream(finalDestination);
	        byte[] bytes = new byte[(int)finalDestination.length()];
	        fileInputStreamReader.read(bytes);
	        encodedBase64 = new String(Base64.encodeBase64(bytes));
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return "data:image/jpg;base64,"+encodedBase64;
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
		String path = System.getProperty("user.dir") + "screenshots" + System.currentTimeMillis() + ".jpeg";
		File destination = new File(path);

		try {
//			String property = System.getProperty("user.dir" )+ "/build/Screenshots" ;
//			System.out.println(property);
//			File destinations = new File(property);
//			FileUtils.cleanDirectory(destinations);
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
	
	
	public static boolean elementDisplayed(WebElement element) throws Exception {
        try {
			boolean displayed = element.isDisplayed();
			return displayed;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
        

	}
	public static boolean elementEnabled(WebElement element) throws Exception {
        try {
			boolean enabled = element.isEnabled();
			return enabled;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
    }
	
	public static boolean elementSelected(WebElement element) throws Exception {
        try {
			boolean selected = element.isSelected();
			return selected;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
        }
	
	
	public static void elementClear(WebElement element) {
		
		try {
			waitUntilElementVisibility(element);
			if (elementDisplayed(element)&&elementEnabled(element))  {	
				element.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public static void inputValueMethod(WebElement element, String value) {
		try {
			waitUntilElementVisibility(element);
			if (elementDisplayed(element)&&elementEnabled(element)) {
				element.clear();
				element.sendKeys(value);
				
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	public static void elementClick(WebElement element) throws Throwable {
		try {
			waitUntilElementVisibility(element);
			element.click();
		} catch (Exception e) {
		e.printStackTrace();

		}
		
	}
	
	public static String getElementText(WebElement element) {
		try {
			waitUntilElementVisibility(element);
			String text = element.getText();
			return text;
		} catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException();
		}
		
	}
	
	public static String getElementAttributetext(WebElement element) throws Throwable {
     try {
		waitUntilElementVisibility(element);
		 String attribute = element.getAttribute("value");
		 return attribute;
	} catch (Exception e) {
	e.printStackTrace();
	throw new Exception();
	}
}
	
//	public String getTitle() {
//		try {
//			String title = driver.getTitle();
//			return title;
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException();
//		}
//	}
	
	public static void selectValueFromDD(WebElement element, String options, String value) throws Exception {
		try {
			
			Select sc = new Select(element);
			if (options.equalsIgnoreCase("index")) {
				sc.selectByIndex(Integer.parseInt(value));
			}else if (options.equalsIgnoreCase("value")) {
				sc.selectByValue(value);
			}else if (options.equalsIgnoreCase("visibletext")) {
				sc.selectByVisibleText(value);
			}
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
	
	public static void dragAndDrop(WebElement source, WebElement target) {
		try {
			waitUntilElementVisibility(source);
			Actions ac = new Actions(driver);
			ac.dragAndDrop(source, target).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public static void doubleclick(WebElement element) {
		try {
			waitUntilElementVisibility(element);
			Actions ac = new Actions(driver);
			ac.doubleClick(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	
	public static void contextClick(WebElement element) {
		try {
			waitUntilElementVisibility(element);
			Actions ac = new Actions(driver);
			ac.contextClick(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public static void elementClickUsingActions(WebElement element) {
		try {
			waitUntilElementVisibility(element);
			Actions ac = new Actions(driver);
			ac.contextClick(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public static void elementInputValueUsingActions(WebElement element, String value) {
		try {
			waitUntilElementVisibility(element);
			Actions ac = new Actions(driver);
			ac.sendKeys(element, value);
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
	
	public static void scrollUpandDownUsngCoordinates(String width, String height) {
		
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("windows.scrollBy("+width+","+height+")");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public static File takeScreenShot(String filename) throws IOException  {
		try {
			File f = new File(System.getProperty("user.dir")+"\\Library\\"+filename+".png");
			TakesScreenshot ts = (TakesScreenshot) driver;
			File temp=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(temp, f);
			return f;
		} catch (WebDriverException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} 
	}

	 public static void scrolltoBottomPage() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,document.body.scrollHeaith)");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	 
	 public static void waitForAlertIsPresent() {
		 try {
			WebDriverWait wb = new WebDriverWait(driver, 50);
			 wb.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
		 e.printStackTrace();
		 throw new RuntimeException();
		}
	 }
	 
	 public static void simpleAlert() {
		 try {
			waitForAlertIsPresent();
			 Alert alert = driver.switchTo().alert();
			 alert.accept();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	 }
	 
	 public static void confirmAlert(String options) {
		 try {
			waitForAlertIsPresent();
			 Alert alert = driver.switchTo().alert();
			 if (options.equalsIgnoreCase("confirm")) {
				alert.accept();
			}else if (options.equalsIgnoreCase("dismiss")) {
				alert.dismiss();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	 }
	 
	 public static void promptAlert(String options, String values) {
		 try {
			waitForAlertIsPresent();
			 Alert alert = driver.switchTo().alert();
			 if (options.equalsIgnoreCase("confirm")) {
				alert.sendKeys(values);
				alert.accept();
			}else if (options.equalsIgnoreCase("dismiss")) {
				alert.dismiss();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	 }
	 public static void scrolltoTopPage() {
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,-document.body.scrollHeaith)");
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}
	 
	 public static WebDriver navigationtToUrl(String url) {
		try {
			driver.navigate().to(url);
			 
			 return driver;
		} catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException();
		}
		 
	 }
	 
	 public static WebDriver navigationCommands(String option) {
		try {
			if (option.equalsIgnoreCase("back")) {
				driver.navigate().back();
			}else if (option.equalsIgnoreCase("forward")) {
				driver.navigate().forward();
			}else if (option.equalsIgnoreCase("refresh")) {
				driver.navigate().refresh();
			}
			 
			 return driver;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		 
	 }
	 
	 public static void swithToIframe(String options, Object value) {
		 try {
			if (options.equalsIgnoreCase("index")) {
				driver.switchTo().frame(Integer.parseInt((String)value));
			}else if (options.equalsIgnoreCase("name")) {
				driver.switchTo().frame((String)value);
			}else if (options.equalsIgnoreCase("element")) {
				driver.switchTo().frame((WebElement)value);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			
		}
	 }
	 
	 public static void switchToDefaultContent() {
	        try {
				driver.switchTo().defaultContent();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
	}
	 
	 public static void switchToSecondWindow() {
		try {
			String cid = driver.getWindowHandle();
			Set<String> pid = driver.getWindowHandles();
			for (String x : pid) {
				if (!x.equals(cid)) {
					driver.switchTo().window(x);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}
	 
	 public static void switchToMultipleWindow(int index) {
		 try {
			String cid = driver.getWindowHandle();
			 Set<String> pid = driver.getWindowHandles();
			 List<String> li = new ArrayList<String>();
			 li.addAll(pid);
			 driver.switchTo().window(li.get(index));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		 
	 }
	 
	 public static void getValueFromWebtable(String element, int i) {
		 try {
			WebElement table = driver.findElement(By.xpath(element));
			 List<WebElement> findElements = table.findElements(By.xpath("//tr[0]//td["+i+"]"));
			 for (WebElement x : findElements) {
				 System.out.println(x.getText());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	 }
	 
	 public static void driverQuit() {
		 driver.quit();
	 }
	 
//	 public static String getValuesfromExcel(String fileName, String sheetname, int rownum, int cellnum)
//				throws Throwable {
//
//			try {
//				File f = new File(System.getProperty("user.dir") + "\\src\\test\\reource\\library\\" + fileName + ".xlsx");
//				FileInputStream fin = new FileInputStream(f);
//				Workbook wb = new XSSFWorkbook(fin);
//				Sheet sheet = wb.getSheet(sheetname);
//				Cell cell = sheet.getRow(rownum).getCell(cellnum);
//				CellType cellType = cell.getCellType();
//				String string = null;
//				if (cellType.equals(CellType.STRING)) {
//					string = cell.getStringCellValue();
//				} else if (cellType.equals(CellType.NUMERIC)) {
//					double numericCellValue = cell.getNumericCellValue();
//					long l = (long) numericCellValue;
//					string = String.valueOf(l);
//				}
//				return string;
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				throw new RuntimeException();
//
//			}
//
//		}

		public static void setValuetoExcel(String fileName, String sheetname, int rownum, int cellnum, String value) throws Throwable {

			try {
				File f = new File(System.getProperty("user.dir") + "\\src\\test\\java\\org\\maven\\runner\\" + fileName + ".xlsx");
				FileInputStream fin = new FileInputStream(f);
				Workbook wb = new XSSFWorkbook(fin);
				Sheet sheet = wb.getSheet(sheetname);
				Row row = sheet.getRow(rownum);
				if (row==null) {
					row = sheet.createRow(rownum);
				}
				Cell cell = row.getCell(cellnum);
				if (cell == null) {
					Cell createCell = sheet.getRow(rownum).createCell(cellnum);
					createCell.setCellValue(value);
				} else {
					cell.setCellValue(value);
				}
				FileOutputStream fout = new FileOutputStream(f);
				wb.write(fout);
				fout.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();


			}

		}
		
		
		public static String testData(String key) throws FileNotFoundException {
			  // File f = new File("./target/props.properties");
			  File f = new File("C:\\Users\\DELL\\eclipse-workspace2\\org.comp\\config.properties");
			  FileReader reader = new FileReader(f);
			  Properties prop = new Properties();
			  try {
			   prop.load(reader);
			  } catch (IOException e) {
			   e.printStackTrace();
			  }
			  return prop.getProperty(key);
		}
	
	
	

}
