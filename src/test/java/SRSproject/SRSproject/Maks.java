package SRSproject.SRSproject;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Maks {

	public void TestRobo() throws Exception{
		System.setProperty("webdriver.gecko.driver","F:\\drivers\\geckodriver.exe");  
		     WebDriver driver = new FirefoxDriver();
		     driver.manage().window().maximize();
		     driver.get("http://www.facebook.com");

		     driver.findElement(By.id("email")).sendKeys("Kumar");
		     driver.findElement(By.id("pass")).sendKeys("12345");
		 
		     Robot r=new Robot();
		     r.keyPress(KeyEvent.VK_ENTER);
		     r.keyRelease(KeyEvent.VK_ENTER);
		}

}
