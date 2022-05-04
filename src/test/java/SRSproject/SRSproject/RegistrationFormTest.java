package SRSproject.SRSproject;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.tools.ant.taskdefs.condition.Contains;
import org.jsoup.select.Evaluator.ContainsData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.RegistrationForm;
import Utils.Constants;



public class RegistrationFormTest extends BaseTest{ 
	
	RegistrationForm rf;
	
	@Test(priority=1)
	public void RegistrationForm_RegisternowRedirectionValidation() throws InterruptedException 
	{
		
		rf= new RegistrationForm(driver);
		String title=rf.ClickOnRegisternowOnGlobalSite();
		Assert.assertEquals(title, Constants.REGISTRATIONFORM_URL);
		
	}
	

@Test(priority=9)
	public void RegistrationForm_GLobalsite_FieldErrorValidation() throws InterruptedException 
	{
		rf.KnowMyHeritagePlusAccountclick();
		
		rf.Submitclick();
		String FirstnameErr = rf.FirstNameFieldErrorvalidation();
		//String FirstnameErr = rf.FirstNameFieldErrorvalidation();
		Assert.assertEquals(FirstnameErr, Constants.First_ERROR_MSG);
		String LastnameErr= rf.LastNameFieldErrorvalidation();
		Assert.assertEquals(LastnameErr, Constants.Last_ERROR_MSG);
		
String PreferredbrandErr=	rf.NoBrandSelectedErrorvalidation();
	Assert.assertEquals(PreferredbrandErr, Constants.ERROR_MSG);
	String CompanynameErr = rf.CompanynameFieldErrorvalidation();
	Assert.assertEquals(CompanynameErr, Constants.ERROR_MSG);
	String Address1Err=	rf.Address1Errorvalidation();
		Assert.assertEquals(Address1Err, Constants.ERROR_MSG);
	String CityErr =	rf.CityFieldErrorvalidation();
		Assert.assertEquals(CityErr, Constants.ERROR_MSG);
		
		String stateErr = rf.StateFieldErrorvalidation();
		Assert.assertEquals(stateErr, Constants.ERROR_MSG);
		String ZipcodeErr = rf.ZipcodeFieldErrorvalidation();
		Assert.assertEquals(ZipcodeErr, Constants.ERROR_MSG);
		String PhonenoErr= rf.EmptyPhonenoErrorvalidation();
		Assert.assertEquals(PhonenoErr, Constants.ERROR_MSG);

	}
	
@Test(priority=10)
	
	public void RegistrationForm_GLobalsite_PhoneNoValidation () throws InterruptedException
	{
	String IncorrectPhonenoError = rf.PhonenoFieldvalidation();
	Assert.assertEquals(IncorrectPhonenoError, Constants.Incorrect_phno_MSG);
	
	}
	@Test(priority=11)
	
public void RegistrationForm_GLobalsite_IncorrectEmailValidation () throws InterruptedException
	{
	
	String ConfirmemailidMismatchErr = rf.IncorrectEmailFieldvalidation();
	rf.Submitclick();
	Assert.assertEquals(ConfirmemailidMismatchErr, Constants.EmailMatch_ERROR_MSG);
}

@Test(priority=12)
	
public void RegistrationForm_GLobalsite_ExistingEmailValidation () throws InterruptedException
	{
	
	String ExistingEmailErrMsg = rf.ExistingEmailFieldvalidation();
	
//	Assert.assertEquals(ExistingEmailErrMsg, Constants.Existingemailid_MSG);
}
	
	


@Test(priority=13)

public void RegistrationForm_GLobalsite_TermNotCheckedValidation () throws InterruptedException
{
String TermsNotcheckedError = rf.TermConditionCheckValidation();
Assert.assertEquals(TermsNotcheckedError, Constants.Termnotchecked_MSG);
}

@Test(priority=3)

public void RegistrationForm_KnowMyHeritagePlusAccount() throws InterruptedException
{
	Thread.sleep(1000);
	rf.KnowMyHeritagePlusAccountclick();
	WebElement CompanyAccount=rf.company_Account_Field();
	Assert.assertEquals(CompanyAccount.isEnabled(), true);
	if (CompanyAccount.isEnabled()) {
		  System.out.println("Company Account Field has got enabled and active");
		 } else {
		  System.out.println("Company Account Field  is not visible");
		
		 }
	
}

@Test(priority=4)

public void RegistrationForm_Dont_KnowMyHeritagePlusAccountValidation() throws InterruptedException
{
	Thread.sleep(1000);
	rf.Dont_KnowMyHeritagePlusAccountclick();
	WebElement CompanyAccount=rf.company_Account_Field();
	Assert.assertEquals(CompanyAccount.isDisplayed(),false);
	if (CompanyAccount.isEnabled()) {
		  System.out.println("Company Account Field has got enabled and active");
		 } else {
		  System.out.println("Company Account Field  is not visible as expected");
		
		 }
	
}

@Test(priority=5)

public void RegistrationForm_DontHave_MyHeritagePlusAccountValidation() throws InterruptedException
{

	Thread.sleep(1000);
rf.DontHave_MyHeritagePlusAccountclick();
WebElement Industry_Professional_option = rf.Industry_Professional_option();
//Assert.assertEquals(CompanyAccount.isDisplayed(),false);

if(Industry_Professional_option.isDisplayed())
{
String Industry_Professional_Verbiage =Industry_Professional_option.getText();
Assert.assertEquals(Industry_Professional_Verbiage, Constants.Industry_Professional_Verbiage);

	 
} else {
 System.out.println("Industry_Professional_Verbiage and option is not displayed");

}
}

@Test(priority=6)

public void RegistrationForm_AccountInfoSelectionValidation() throws InterruptedException

{Thread.sleep(1000);
	
	WebElement CompanyAccount=rf.company_Account_Field();
	WebElement Industry_Professional_verb = rf.Industry_Professional_option();
	
	rf.KnowMyHeritagePlusAccountclick();
    if (CompanyAccount.isEnabled())
	{
		  System.out.println("Company Account Field has got enabled and active");
		 } 
	
	else {
		  System.out.println("Company Account Field  is not visible");
		
		 }
	
	
    rf.Dont_KnowMyHeritagePlusAccountclick();
    if (CompanyAccount.isEnabled())
	
	{
		  System.out.println("Company Account Field has got enabled and active");
		 } 
	
	else if (Industry_Professional_verb.isDisplayed())
			{ 
		  System.out.println("Industry_Professional_Verbiage should not be displayed");
		
		 }
	else
		 {
			 System.out.println("Both Company Account Field  And Industry_Professional_Verbiage  is not visible as expected");
		 }
			 
	
	rf.DontHave_MyHeritagePlusAccountclick();
	if (CompanyAccount.isEnabled())
		
	{
		  System.out.println("Company Account Field has got enabled and active");
		 } 
	
	else
	{
	String Industry_Professional_Verbiage = Industry_Professional_verb.getText();
	Assert.assertEquals(Industry_Professional_Verbiage, Constants.Industry_Professional_Verbiage);

		 }



}

@Test(priority=7)

public void RegistrationForm_yes_Industrial_ProfessionalValidation() throws InterruptedException
{
	Thread.sleep(1000);
	rf.DontHave_MyHeritagePlusAccountclick();
	String Messageon_yes_Industrial_Prof_option =  rf.Messageon_yes_Industrial_Prof_option_Selection();
	
	//System.out.println(Messageon_yes_Industrial_Prof_option);
	//Assert.assertEquals(Messageon_yes_Industrial_Prof_option, Constants.Messageon_yes_Industrial_Prof_option);
	
	
}

@Test(priority=8)

public void RegistrationForm_Not_Industrial_ProfessionalValidation() throws InterruptedException
{
	Thread.sleep(1000);
	rf.DontHave_MyHeritagePlusAccountclick();
	String Messageon_Not_Industrial_Prof_option = rf.Messageon_Not_Industrial_Professional_option_Click();
	
	Assert.assertEquals(Messageon_Not_Industrial_Prof_option, Constants.Messageon_Not_Industrial_Prof_option);
}

@Test(priority=2)

public void RegistrationForm_BrandFieldDisplayed() throws InterruptedException
{
	WebElement Heritage_Brand_Selection = rf.Heritage_Brand_SelectionField();
	
	Assert.assertEquals((Heritage_Brand_Selection.isDisplayed()), true);
}
	
	

/*@Test(priority=14)

public void RegistrationForm_FIS_BrandAndBranchValidation() throws InterruptedException
{
	driver.navigate().refresh();
	Thread.sleep(6000);
	rf.Hertiage_Brand_FIS_Selection();
	Thread.sleep(6000);
	rf.Scrollup_Branch_SelectionField();
	Thread.sleep(1000);
	WebElement a = rf.Branch_SelectionField();
	Thread.sleep(6000);
	a.click();
	Thread.sleep(6000);
	Select s = new Select(a);
	List<WebElement> op = s.getOptions();
	
	int size = op.size();
	try
	{
    for(int i =0; i<size ; i++)
    {
       String options = op.get(i).getText();
       String BranchPref = "FIS";
       String BranchdefPref= "Preferred Branch Location";
     if((options.contains(BranchPref))||options.contains(BranchdefPref))
    		 {
    	 System.out.println(options);
    }
     
    
     
     else
     {
    	 System.out.println("Some Other branch are also listed"+options);
    }

}
	}
	catch (Exception e)
	{
		System.out.println(e);
	}

}
*/
@Test(priority=15)

public void RegistrationForm_PCS_BrandAndBranchValidation() throws InterruptedException
{
	driver.navigate().refresh();
	Thread.sleep(6000);
	//Thread.sleep(1000);
	rf.Hertiage_Brand_PCS_Selection();
	Thread.sleep(6000);
	rf.Scrollup_Branch_SelectionField();
	Thread.sleep(1000);
	WebElement a = rf.Branch_SelectionField();
	Thread.sleep(6000);
	a.click();
	Thread.sleep(6000);
	Select s = new Select(a);
	List<WebElement> op = s.getOptions();
	
	int size = op.size();
	try
	{
    for(int i =0; i<size ; i++)
    {
       String options = op.get(i).getText();
       String BranchPref = "POOL CONTRACTORS SUPPLY";
       String BranchdefPref= "Preferred Branch Location";
      // Assert.assertEquals(options.startsWith(BranchPref)||options.startsWith(BranchdefPref), true);
     if((options.contains(BranchPref))||options.contains(BranchdefPref))
    		 {
    	 System.out.println(options);
    }
     
    
     
     else
     {
    	 System.out.println("Some Other branch are also listed"+options);
    }

}
	}
	catch (Exception e)
	{
		System.out.println(e);
	}

}

@Test(priority=16)

public void RegistrationForm_QPS_BrandAndBranchValidation() throws InterruptedException
{

	//Thread.sleep(1000);
	rf.Hertiage_Brand_QPS_Selection();
	Thread.sleep(7000);
	WebElement a = rf.Branch_SelectionField();
	Thread.sleep(6000);
	a.click();
	Thread.sleep(6000);
	Select s = new Select(a);
	List<WebElement> op = s.getOptions();
	
	int size = op.size();
	try
	{
    for(int i =0; i<size ; i++)
    {
       String options = op.get(i).getText();
       String BranchPref = "QUALITY POOL SUPPLY";
       String BranchdefPref= "Preferred Branch Location";
      // Assert.assertEquals(options.startsWith(BranchPref)||options.startsWith(BranchdefPref), true);
     if((options.contains(BranchPref))||options.contains(BranchdefPref))
    		 {
    	 System.out.println(options);
    }
     
    
     
     else
     {
    	 System.out.println("Some Other branch are also listed"+ options);
    }

}
	}
	catch (Exception e)
	{
		System.out.println(e);
	}

}
@Test(priority=15,enabled = false)

public void RegistrationForm_Aqua_gon__BrandAndBranchValidation() throws InterruptedException
{
	driver.navigate().refresh();
	Thread.sleep(6000);
	//Thread.sleep(1000);
	rf.Hertiage_Brand_Aqua_gon_Selection();
	Thread.sleep(6000);
	rf.Scrollup_Branch_SelectionField();
	Thread.sleep(1000);
	WebElement a = rf.Branch_SelectionField();
	Thread.sleep(6000);
	a.click();
	Thread.sleep(6000);
	Select s = new Select(a);
	List<WebElement> op = s.getOptions();
	
	int size = op.size();
	try
	{
    for(int i =0; i<size ; i++)
    {
       String options = op.get(i).getText();
       String BranchPref = "AQUA-GON";
       String BranchdefPref= "Preferred Branch Location";
      // Assert.assertEquals(options.startsWith(BranchPref)||options.startsWith(BranchdefPref), true);
     if((options.contains(BranchPref))||options.contains(BranchdefPref))
    		 {
    	 System.out.println(options);
    }
     
    
     
     else
     {
    	 System.out.println("Some Other branch are also listed"+options);
    }

}
	}
	catch (Exception e)
	{
		System.out.println(e);
	}

}

//PCS


//@Test(priority=17,enabled =false)
//
//public void RegistrationForm_DontKnowHertiageAccount_RegistrationValidation() throws InterruptedException, IOException
//{
//	BasePage.initializtion();
//	Thread.sleep(8000);
//rf= new RegistrationForm(driver);
//rf.ClickOnRegisternowOnGlobalSite();
//Thread.sleep(8000);
//	rf.FirstName_Entry();
//	rf.LastName_Entry();
//	rf.Email_Entry_Scenario1();
//	rf.Heritage_Brand_SelectionField();
//	rf.Hertiage_Brand_PCS_Selection();
//	rf.Branch_SelectionField();
//	rf.Branch_pcsSelection();
//	rf.CompanyField_click();
//	rf.Address1Field_click();
//	rf.Address2Field_click();
//	rf.CityField_click();
//	rf.State_Selection();
//	rf.ZipCode_click();
//	rf.Valid_PhoneNo_click();
//	rf.Fax_click();
//	rf.Dont_KnowMyHeritagePlusAccountclick();
//	rf.ValidPassword_Entry();
//	rf.Terms_Click();
//
//	rf.Submitclick();
//Thread.sleep(10000);
//	
//	String AccountCreatePage = rf.PageTitle();
//	Thread.sleep(100);
//	
//	
//	Assert.assertEquals(AccountCreatePage,prop.getProperty("HomePageTitle"));
//	
//	Thread.sleep(3000);
//	
//	
//	
//}
//
//
//
//
//@Test(priority=18)
//
//public void RegistrationForm_KnowHertiageAccount_RegistrationValidation() throws InterruptedException, IOException
//{
//	//BasePage Bp= new BasePage();
//	BasePage.initializtion();
//	Thread.sleep(8000);
//rf= new RegistrationForm(driver);
//	rf.ClickOnRegisternowOnGlobalSite();
//	rf.FirstName_Entry();
//	rf.LastName_Entry();
//	rf.Email_Entry_Scenario2();
//	rf.Heritage_Brand_SelectionField();
//	rf.Hertiage_Brand_PCS_Selection();
//	rf.Branch_SelectionField();
//	rf.Branch_pcsSelection();
//	rf.CompanyField_click();
//	rf.Address1Field_click();
//	rf.Address2Field_click();
//	rf.CityField_click();
//	rf.State_Selection();
//	rf.ZipCode_click();
//	rf.Valid_PhoneNo_click();
//	rf.Fax_click();
//	rf.KnowMyHeritagePlusAccountclick();
//	rf.company_Account_Entry();
//	rf.ValidPassword_Entry();
//	rf.Terms_Click();
//	rf.Submitclick();
//	
//Thread.sleep(10000);
//	
//	String AccountCreatePage = rf.PageTitle();
//	Thread.sleep(100);
//	
//	
//	Assert.assertEquals(AccountCreatePage,prop.getProperty("HomePageTitle"));
//	
//	Thread.sleep(3000);
//	
//}}
//
//
//@Test(priority=19)
//
//public void RegistrationForm_QPSBranch_RegistrationValidation() throws InterruptedException, IOException
//{
//	BasePage.initializtion();
//	Thread.sleep(8000);
//	rf.ClickOnRegisternowOnGlobalSite();
//	rf.FirstName_Entry();
//	rf.LastName_Entry();
//	rf.Email_Entry_Scenario3();
//	rf.Heritage_Brand_SelectionField();
//	rf.Hertiage_Brand_QPS_Selection();
//	rf.Branch_SelectionField();
//	rf.Branch_qpsSelection();
//	rf.CompanyField_click();
//	rf.Address1Field_click();
//	rf.Address2Field_click();
//	rf.CityField_click();
//	rf.State_Selection();
//	rf.ZipCode_click();
//	rf.Valid_PhoneNo_click();
//	rf.Fax_click();
//	rf.KnowMyHeritagePlusAccountclick();
//	rf.company_Account_Entry();
//	rf.ValidPassword_Entry();
//	rf.Terms_Click();
//	rf.Submitclick();
//
//Thread.sleep(10000);
//	
//	String AccountCreatePage = rf.PageTitle();
//	Thread.sleep(100);
//	
//	
//	Assert.assertEquals(AccountCreatePage,prop.getProperty("HomePageTitle"));
//	
//	Thread.sleep(3000);
//	
//
//}
	


//@Test(priority=20)
//
//public void RegistrationForm_DontHaveHertiageAccount_RegistrationValidation() throws InterruptedException, IOException
//{
//	BasePage.initializtion();
//	Thread.sleep(8000);
//	rf= new RegistrationForm(driver);
//	rf.ClickOnRegisternowOnGlobalSite();
//	rf.FirstName_Entry();
//	rf.LastName_Entry();
//	rf.Heritage_Brand_SelectionField();
//	rf.Hertiage_Brand_PCS_Selection();
//	rf.Branch_SelectionField();
//	rf.Branch_pcsSelection();
//	rf.CompanyField_click();
//	rf.Address1Field_click();
//	rf.Address2Field_click();
//	rf.CityField_click();
//	rf.State_Selection();
//	rf.ZipCode_click();
//	rf.Valid_PhoneNo_click();
//	rf.Fax_click();
//	rf.DontHave_MyHeritagePlusAccountclick();
//	rf.yes_Industrial_Professional_option_Click();
//	Thread.sleep(2000);
//	rf.BecomeACustomer().click();
//	
//	Thread.sleep(2000);
//	String BecomeACustomerPage = rf.PageURL();
//	Thread.sleep(2000);
//	String windowHandle = driver.getWindowHandle();
//	ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
//	   driver.switchTo().window(newTab.get(1));
//	  
//	 
//	  Thread.sleep(5000);
//	
//	Assert.assertEquals(BecomeACustomerPage, Constants.BecomeACustomerURL);
//	
//	Thread.sleep(3000);
//	 //driver.switchTo().window(newTab.get(0));
//	
//	//driver.navigate().back();
//	
//}}
////Aqua-gon
//
@Test(priority=17,enabled = false)

public void RegistrationForm_DontKnowHertiageAccount_RegistrationValidation() throws InterruptedException, IOException
{
	BasePage.initializtion();
	Thread.sleep(8000);
rf= new RegistrationForm(driver);
rf.ClickOnRegisternowOnGlobalSite();
Thread.sleep(8000);
	rf.FirstName_Entry();
	rf.LastName_Entry();
	rf.Email_Entry_Scenario1();
	rf.Heritage_Brand_SelectionField();
	rf.Hertiage_Brand_Aqua_gon_Selection();
   rf.Branch_SelectionField();
	rf.Branch_Aqua_gonSelection();
	rf.CompanyField_click();
	rf.Address1Field_click();
	rf.Address2Field_click();
	rf.CityField_click();
	rf.State_Selection();
	rf.ZipCode_click();
	rf.Valid_PhoneNo_click();
	rf.Fax_click();
	rf.Dont_KnowMyHeritagePlusAccountclick();
	rf.ValidPassword_Entry();
	rf.Terms_Click();

	rf.Submitclick();
Thread.sleep(10000);
	
	String AccountCreatePage = rf.PageTitle();
	Thread.sleep(100);
	
	
	Assert.assertEquals(AccountCreatePage,prop.getProperty("HomePageTitle"));
	
	Thread.sleep(3000);
	
	
	
}



@Test(priority=18,enabled = false)

public void RegistrationForm_KnowHertiageAccount_RegistrationValidation() throws InterruptedException, IOException
{
	//BasePage Bp= new BasePage();
	BasePage.initializtion();
	Thread.sleep(8000);
rf= new RegistrationForm(driver);
	rf.ClickOnRegisternowOnGlobalSite();
	rf.FirstName_Entry();
	rf.LastName_Entry();
	rf.Email_Entry_Scenario2();
	rf.Heritage_Brand_SelectionField();
	rf.Hertiage_Brand_Aqua_gon_Selection();
	rf.Branch_SelectionField();
	rf.Branch_Aqua_gonSelection();
	rf.CompanyField_click();
	rf.Address1Field_click();
	rf.Address2Field_click();
	rf.CityField_click();
	rf.State_Selection();
	rf.ZipCode_click();
	rf.Valid_PhoneNo_click();
	rf.Fax_click();
	rf.KnowMyHeritagePlusAccountclick();
	rf.company_Account_Entry();
	rf.ValidPassword_Entry();
	rf.Terms_Click();
	rf.Submitclick();
	
Thread.sleep(10000);
	
	String AccountCreatePage = rf.PageTitle();
	Thread.sleep(100);
	
	
	Assert.assertEquals(AccountCreatePage,prop.getProperty("HomePageTitle"));
	
	Thread.sleep(3000);
	

}}



