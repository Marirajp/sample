package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import SRSproject.SRSproject.BasePage;

public class MyAccountPage extends BasePage {

	WebDriverWait wait;
	WebDriver driver;
	Actions act;
	
	public MyAccountPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}

}
