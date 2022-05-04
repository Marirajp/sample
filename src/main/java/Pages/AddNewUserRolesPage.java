package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import SRSproject.SRSproject.BasePage;

public class AddNewUserRolesPage extends BasePage {
	WebDriverWait wait;
	WebDriver driver;
	Actions act;

	@FindBy(xpath = "//button[@title='Add New User Role']//span[1]")
	WebElement AddNewUserRole;
	@FindBy(xpath = "//span[text()='Role Name']/following::input")
	WebElement RoleName;
	//@FindBy(xpath = "//a[@id='BlueAcorn_SrsDistribution::approve_order_anchor']")
	//WebElement AccessRights;
	@FindBy(xpath = "//button[contains(@class,'action save')]//span[1]")
	WebElement SaveRole;
	@FindBy(xpath = "//a[@class='action secondary']/span")
	WebElement CancelAddRole;
	@FindBy(xpath = "//a[@class='action goback']/span")
	WebElement GoBackToUserRolesPage;
	@FindBy(css = ".jstree-icon.jstree-checkbox")
	WebElement AccessRights;

	public AddNewUserRolesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public AddNewUserRolesPage enterRoleName() {
		RoleName.sendKeys(prop.getProperty("RoleName"));
		return this;
	}

	public AddNewUserRolesPage clickAllAccessRights() {
		
		List<WebElement> AllCheckboxes = driver.findElements(By.cssSelector(".jstree-icon.jstree-checkbox"));

		int size = AllCheckboxes.size();
		System.out.println(size);

		for (int i = 1; i < size; i++) {

			AllCheckboxes.get(i).click();

		}

		return this;

	}

	public UserRolesPage clickSaveRole() {
		SaveRole.click();
		return new UserRolesPage(driver);
		
	}

}
