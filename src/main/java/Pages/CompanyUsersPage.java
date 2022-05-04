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

public class CompanyUsersPage extends BasePage {
	WebDriverWait wait;
	WebDriver driver;
	Actions act;

	@FindBy(xpath = "//span[text()='Add New User']")
	WebElement AddNewUserBtn;
	@FindBy(xpath = "(//div[@class='modal-inner-wrap']//header)[2]")
	WebElement AddNewUserPopup;
	@FindBy(xpath = "//input[@id='firstname']")
	WebElement FirstName;
	@FindBy(xpath = "//input[@id='lastname']")
	WebElement LastName;
	@FindBy(xpath = "//input[@id='email']")
	WebElement Email;
	@FindBy(xpath = "//select[@data-role='role-select']")
	WebElement UserRole;
	@FindBy(xpath = "//select[@title='Default Branch']")
	WebElement DefaultBranch;
	@FindBy(xpath = "//select[@title='Default ShipTo']")
	WebElement DefaultShipTo;
	@FindBy(xpath = "//select[@data-role='status-select']")
	WebElement Status;
	@FindBy(xpath = "//select[@title='Supervisor Name']")
	WebElement SupervisorName;
	@FindBy(xpath = "//input[@title='Supervisor Email']")
	WebElement SupervisorEmail;
	@FindBy(xpath = "//button[@class='action save primary']")
	WebElement SaveUser;
	@FindBy(xpath = "//button[@class='action cancel secondary']")
	WebElement CancelAddUser;
	@FindBy(xpath = "(//button[@class='action-close'])[2]")
	WebElement ClosePopup;
	@FindBy(xpath = "//div[text()='The customer was successfully created.']")
	WebElement SuccessMsg;
	@FindBy(xpath = "//a[@title='Edit User Roles']//span[1]")
	WebElement EditUserRoles;
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
	
	
	
	
	
	
	
	
	//a[@title='Edit User Roles']//span[1]

	// div[@class='swal2-content']//div[1]
	// div[text()='The customer was successfully created.']

	public CompanyUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public CompanyUsersPage clickAddNewUserBtn() {

		AddNewUserBtn.click();
		return this;

	}

	public void enterAddNewUserPopup() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(AddNewUserPopup));

	}

	public CompanyUsersPage enterFirstName() {
		FirstName.sendKeys(prop.getProperty("FirstName_User"));
		return this;
	}

	public CompanyUsersPage enterLastName() {
		LastName.sendKeys(prop.getProperty("LastName_User"));
		return this;
	}

	public CompanyUsersPage enterEmail() {
		Email.sendKeys(prop.getProperty("Email_User"));
		return this;
	}

	public CompanyUsersPage selectUserRole(String option) {
		Select select = new Select(UserRole);
		select.selectByVisibleText(option);
		return this;
	}

	public CompanyUsersPage selectDefaultBranch(int index) {
		Select select = new Select(DefaultBranch);
		select.selectByIndex(index);
		return this;
	}

	public CompanyUsersPage selectDefaultShipTo(int index) {
		Select select = new Select(DefaultShipTo);
		select.selectByIndex(index);
		return this;
	}

	public CompanyUsersPage selectStatus(int index) {
		Select select = new Select(Status);
		select.selectByIndex(index);
		return this;
	}

	public CompanyUsersPage selectSupervisorName(int index) {
		Select select = new Select(SupervisorName);
		select.selectByIndex(index);
		return this;
	}
	// public void enterSupervisorEmail() {
	// SupervisorEmail.sendKeys(prop.getProperty("FirstName_User"));
	// }

	public CompanyUsersPage clickSaveUser() throws Exception {
		waitUntilElementVisibility(SaveUser);
		SaveUser.click();
		return this;
	}

	public CompanyUsersPage clickCancel() {
		CancelAddUser.click();
		return this;
	}

	public CompanyUsersPage clickClose() {
		ClosePopup.click();
		return this;
	}

	public String captureSuccessMsg() {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(SuccessMsg));
		String successMsge = SuccessMsg.getText();
		return successMsge;
	}
	
	
	public UserRolesPage clickEditUserRolesBtn() {
		EditUserRoles.click();
		return new UserRolesPage(driver);
	}
	

}
