package Listeners;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import SRSproject.SRSproject.BasePage;


public class ExtentReport extends BasePage implements ITestListener
{
	
	
	public static final String OUTPUT_FOLDER = "./build/";
	public static final String FILE_NAME = "SRS-TestExecutionReport.html";
	
	

//	test.log(Status.PASS,"Attached Screenshot ", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+base64).build();

	String concatenate = ".";
	
	public static ExtentReports extent = init();
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

	public static ExtentReports init() {
		
		
		
		Path path = Paths.get(OUTPUT_FOLDER);
		// if directory exists?
		if (!Files.exists(path)) {
			try {
				Files.createDirectories(path);
			} catch (IOException e) {
				// fail to create directory
				e.printStackTrace();
			}
		}
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(OUTPUT_FOLDER + FILE_NAME);
		htmlReporter.config().setDocumentTitle("TestExecutionReport");
		
	
		htmlReporter.config().setReportName("Automation Test Results Of: APS  Prod" );//
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setReportUsesManualConfiguration(true);
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("HostName", "LocalHost");

		return extent;
	}

	public synchronized void onStart(ITestContext context) {
		System.out.println("Test Suite started!");
	}

	public synchronized void onFinish(ITestContext context) {
		System.out.println(("Test Suite is ending!"));
		extent.flush();
		test.remove();
	}

	public synchronized void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String qualifiedName = result.getMethod().getQualifiedName();
		int last = qualifiedName.lastIndexOf(".");
		int mid = qualifiedName.substring(0, last).lastIndexOf(".");
		String className = qualifiedName.substring(mid + 1, last);

		System.out.println(methodName + " started!");
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),
				result.getMethod().getDescription());

		extentTest.assignCategory(result.getTestContext().getSuite().getName());
		/*
		 * methodName = StringUtils.capitalize(StringUtils.join(StringUtils.
		 * splitByCharacterTypeCamelCase(methodName), StringUtils.SPACE));
		 */
		extentTest.assignCategory(className);
		test.set(extentTest);
		test.get().getModel().setStartTime(getTime(result.getStartMillis()));
	}

	public synchronized void onTestSuccess(ITestResult result) {
//		System.out.println((result.getMethod().getMethodName() + " passed!"));
//		test.get().pass("Test passed");
//		test.get().getModel().setEndTime(getTime(result.getEndMillis()));
		String logText = "<b>Test Method " + result.getMethod().getMethodName() + " Successful</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		test.get().log(Status.PASS, m);
	}
//
//	public synchronized void onTestFailure(ITestResult result) {
//	//	System.out.println((result.getMethod().getMethodName() + " failed!"));
//		
//		String logText = "<b>Test Method " +  result.getMethod().getMethodName()  + " Failed</b>";
//		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
//		test.get().log(Status.FAIL, m);
//		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
//		test.get().fail("<details><summary><b><font color=red>" +
//						"Exception Occured, click to see details:"+ "</font></b></summary>" +
//						exceptionMessage.replaceAll(",", "<br>") + "</details> \n");
//		
//		try {
//			
//			
//
//			test.get().fail("<b><font color=red>" + "Screenshot of failure" + "</font></b>",
//					MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
//			
//			test.get().fail("Snapshot below: " + test.get().addScreenCaptureFromPath(getScreenshot()));
//			 
//			 
////			test.get().fail( (Markup) MediaEntityBuilder.createScreenCaptureFromPath("." + getScreenshot()).build());
//
//			test.get().log(Status.INFO,result.getThrowable());
//			test.get().log(Status.INFO,result.getThrowable());
//
//		} catch (IOException | InterruptedException e) {
//			test.get().fail("Test Failed, cannot attach screenshot");
//		}
//		
//	}
	
	

	public synchronized void onTestFailure(ITestResult result) {
		
		
		
		String logText = "<b>Test Method " +  result.getMethod().getMethodName()  + " Failed</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		test.get().log(Status.FAIL, m);
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		test.get().fail("<details><summary><b><font color=red>" +
						"Exception Occured, click to see details:"+ "</font></b></summary>" +
						exceptionMessage.replaceAll(",", "<br>") + "</details> \n");
		
		try {
			
			String Screenshotpath = concatenate + getScreenshot();
			
			
//
			test.get().fail("<b><font color=red>" + "Screenshot of failure" + "</font></b>",
					MediaEntityBuilder.createScreenCaptureFromPath(addScreenshot()).build());
//			test.get().fail(exceptionMessage, MediaEntityBuilder.createScreenCaptureFromPath(getBase64Screenshot( driver, "Aps")).build());
			test.get().fail(exceptionMessage,MediaEntityBuilder.createScreenCaptureFromPath(addScreenshot()).build());
			
		
	
			test.get().log(Status.INFO,result.getThrowable());
			test.get().log(Status.INFO,result.getThrowable());

		} catch (IOException | InterruptedException e) {
			
			test.get().fail("Test Failed, cannot attach screenshot");
		}
		
	}
	

	public synchronized void onTestSkipped(ITestResult result) {
		String logText = "<b>Test Method " + result.getMethod().getMethodName() + " Skipped</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		test.get().log(Status.SKIP, m);
	}

	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
	 
	


}
