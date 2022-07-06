package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import SRSproject.SRSproject.BasePage;

public class EditUsersPage extends BasePage {
	WebDriverWait wait;
	WebDriver driver;
	Actions act;

	@FindBy(xpath = "//button[@title='Add New User Role']//span[1]")
	WebElement AddNewUserRole;
	@FindBy(xpath = "//span[text()='Role Name']/following::input")
	WebElement RoleName;
	@FindBy(xpath = "//div[@id='role-tree']")
	WebElement AccessRights;
	@FindBy(xpath = "//button[contains(@class,'action save')]//span[1]")
	WebElement SaveRole;
	@FindBy(xpath = "//a[@class='action secondary']/span")
	WebElement CancelAddRole;
	@FindBy(xpath = "//a[@class='action goback']/span")
	WebElement GoBackAddRole;
	@FindBy(xpath = "(//a[@class='action'])[2]")
	WebElement EditUserRole;

	public EditUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public AddNewUserRolesPage clickAddNewUserRole() {
		AddNewUserRole.click();
		return new AddNewUserRolesPage(driver);
	}
	
}
