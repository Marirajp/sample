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

public class UserRolesPage extends BasePage {
	WebDriverWait wait;
	WebDriver driver;
	Actions act;

	@FindBy(xpath = "//button[@title='Add New User Role']")
	WebElement AddNewUserRole;
	
	@FindBy(xpath = "//a[@class='action goback']/span")
	WebElement GoBackToCompanyUsersPage;
	@FindBy(xpath = "(//a[@class='action'])[2]")
	WebElement EditUserRole;
	

	public UserRolesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public AddNewUserRolesPage clickAddNewUserRole() {
		AddNewUserRole.click();
		return new AddNewUserRolesPage(driver);
	}
	public EditUsersPage clickEditUserRole() {
		EditUserRole.click();
		return new EditUsersPage(driver);
	}
	
	public CompanyUsersPage clickGoBackAddRole() {
		GoBackToCompanyUsersPage.click();
		return new CompanyUsersPage(driver);
	}
}
