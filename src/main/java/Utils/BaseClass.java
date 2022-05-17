package Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.RowIdLifetime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class BaseClass {
	
	
		public static WebDriver driver;
      
		
		
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
			
//				driver.manage().window().maximize();
//				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
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
		
		public static void waitUntilElementVisibility(WebElement element) throws Exception {
			try {
				WebDriverWait wb = new WebDriverWait(driver, 50);
				wb.until(ExpectedConditions.visibilityOf(element));
			} catch (Exception e) {
			e.printStackTrace();
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
		
		public static String getTitle() {
			try {
				String title = driver.getTitle();
				return title;
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}
		
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
		public static void jsClick(WebElement element) throws Exception {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
		
			
		        js.executeScript("arguments[0].focus();", element);

		        js.executeScript("arguments[0].scrollIntoView(true);", element);
		       js.executeScript("arguments[0].click()", element);
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
		 
//		 public static String getValuesfromExcel(String fileName, String sheetname, int rownum, int cellnum)
//					throws Throwable {
//
//				try {
//					File f = new File(System.getProperty("user.dir") + "\\src\\test\\reource\\library\\" + fileName + ".xlsx");
//					FileInputStream fin = new FileInputStream(f);
//					Workbook wb = new XSSFWorkbook(fin);
//					Sheet sheet = wb.getSheet(sheetname);
//					Cell cell = sheet.getRow(rownum).getCell(cellnum);
//					CellType cellType = cell.getCellType();
//					String string = null;
//					if (cellType.equals(CellType.STRING)) {
//						string = cell.getStringCellValue();
//					} else if (cellType.equals(CellType.NUMERIC)) {
//						double numericCellValue = cell.getNumericCellValue();
//						long l = (long) numericCellValue;
//						string = String.valueOf(l);
//					}
//					return string;
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//					throw new RuntimeException();
//
//				}
//
//			}

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



















	

