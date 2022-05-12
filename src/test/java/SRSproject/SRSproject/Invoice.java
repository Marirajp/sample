package SRSproject.SRSproject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Pages.HomePage;

public class Invoice extends BaseTest {
	HomePage Hp ;
	@Test
	public void invoices() throws InterruptedException {
		
		
		Hp = new HomePage(driver);
		Hp.ValidLogin();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//a[text()='Invoice History']")).click();
		
		List <String> nameslist = new ArrayList <String> ();
		int PaginationSize = driver.findElements (By.xpath("//li[contains(@class,'footable-page visible')]//a")).size();
		List <WebElement> listofNames;
		System.out.println(PaginationSize);


}

	
	
}
