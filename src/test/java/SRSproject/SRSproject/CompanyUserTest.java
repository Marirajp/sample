package SRSproject.SRSproject;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AddNewUserRolesPage;
import Pages.CompanyUsersPage;
import Pages.HomePage;
import Pages.HomePage_Global;
import Pages.LoginPage;
import Pages.UserRolesPage;
import SRSproject.SRSproject.BasePage;
import SRSproject.SRSproject.BaseTest;

public class CompanyUserTest extends BaseTest {
	
//Run Brand configuration properties file
	CompanyUsersPage CUpg;
	HomePage Hp;
	AddNewUserRolesPage AddNewRolePg;
	UserRolesPage UserRolesPg;

	@Test(priority = 0)
	public void CreateCompanyUser() throws Exception {
		 BasePage.initializtion();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Hp = new HomePage(driver);
		Hp.ValidLogin();
		Thread.sleep(11000);
		Hp.Account_Hover();
		Hp.ClickUserManagement();
		Thread.sleep(5000);
		CUpg = new CompanyUsersPage(driver);

		CUpg.clickAddNewUserBtn();
//		CUpg.enterAddNewUserPopup();
//		Thread.sleep(2000);
		CUpg.enterFirstName();
		CUpg.enterLastName();
		CUpg.enterEmail();
		CUpg.selectUserRole("Default User");
		CUpg.selectDefaultBranch(0);
		CUpg.selectDefaultShipTo(0);
		CUpg.selectStatus(0);
		CUpg.selectSupervisorName(1);
		CUpg.clickSaveUser();
		
		String successMsg = CUpg.captureSuccessMsg();
		System.out.println(successMsg);

	}

	@Test(priority = 1)
	public void AddNewUserRole() throws InterruptedException, IOException {
 BasePage.initializtion();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Hp = new HomePage(driver);
		Hp.ValidLogin();
		Thread.sleep(5000);
		Hp.Account_Hover();
		Thread.sleep(2000);
		Hp.ClickUserManagement();
		Thread.sleep(5000);
		CUpg = new CompanyUsersPage(driver);
		CUpg.clickEditUserRolesBtn();
		Thread.sleep(5000);
		UserRolesPg = new UserRolesPage(driver);
		UserRolesPg.clickAddNewUserRole();
		Thread.sleep(5000);
		AddNewRolePg = new AddNewUserRolesPage(driver);
		AddNewRolePg.enterRoleName();
		Thread.sleep(5000);
		AddNewRolePg.clickAllAccessRights();
		Thread.sleep(11000);

		AddNewRolePg.clickSaveRole();
		Thread.sleep(5000);

	}

}
