package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Constants { 
//	
	public static final String REGISTRATIONFORM_URL="https://www.heritagepoolplus.com/company/account/create";
//	public static final String REGISTRATIONFORM_URL="https://mcstaging.heritagepoolplus.com/company/account/create";
//	public static final String REGISTRATIONFORM_URL="https://mcstaging2.heritagepoolplus.com/company/account/create";
	public static final String First_ERROR_MSG="First name is required";
	public static final String Last_ERROR_MSG="Last name is required";
	public static final String ERROR_MSG="This is a required field.";
	public static final String EmailMatch_ERROR_MSG="Your new contact emails have to match";
	public static final String Existingemailid_MSG="User with this email already exists in the system. Enter a different email address to continue. If you want to use your current account as an administrator account, please contact the seller.";
	public static final String PswdMismatch_ERROR_MSG="Your new contact emails have to match";
	public static final String Termnotchecked_MSG="This is a required field.";
	public static final String Incorrect_phno_MSG="Please enter a valid phone number. For example (123) 456-7890 or 123-456-7890.";
	public static final String Industry_Professional_Verbiage ="Are you an Industry Professional?";
	public static final String Messageon_yes_Industrial_Prof_option ="Great! Registration for online shopping first requires submission of a C.O.D. or Credit application for review. Once approved you'll be notified and able to shop at our locations and online. Please follow the link below to get started: ";
	public static final String Messageon_Not_Industrial_Prof_option ="Our apologies. Heritage Pool sells only with industry professionals.";
	public static final String AccountCreatePageURL_Global="https://srsqa.dckap.co/pcs/company/account/index";
	public static final String BecomeACustomerURL= "https://heritageplus.com/become-a-customer/";
	//public static final String BulkOrderPageURL="https://srsqa.dckap.co/pcs/quick-order";
	public static final String BecomeACustomerTitle="Become A Customer";
	public static final String SitemapTitle="Sitemap";
	public static final String TermsPageTitle="Heritage Pool+ Terms & Conditions";
	public static final String BulkOrderTitle="Bulk Order";
	public static final String CartPageTitle="Shopping Cart";
	public static final String CheckoutPageTitle="Checkout";
	public static final String Reorder_PageTitle="Reorder Pads";
	public static final String Notification="We can't import Reorder Pad item right now. Product data is not valid. Please check and try again.";
	public static final String Success_Msg_Reorder= "has been added to your cart";
	public static final String NotApprovedErrorMessage="Your account is not yet approved. If you have questions, please contact the seller.";
	public static final String UnAuthorizedErrorMessage="You don't have access to this website.";
	public static final String ConfirmPopup ="You will be redirected to respective branch website and all the cart items will not be moved to other website.";
	public static final String REPORT_ERROR = null;
	public static final String InvalidErrormsge = "Invalid login or password." ;
	
	
}