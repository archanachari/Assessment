package assessmentpackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class login_signup_bug extends base {

	// sign in icon at the right end corner of the page
	@FindBy(className = "login")
	public WebElement cls_signin_icon;

	// authentication label on the authentication page (login /Sign up page)
	@FindBy(xpath = "//*[@id=\'center_column\']/h1")
	public WebElement xauthentication_lbl;

	// email text box in already registered section
	@FindBy(id = "email")
	public WebElement id_email_signin_txt;

	// password in the already registered section
	@FindBy(id = "passwd")
	public WebElement id_password_txt;

	// sign in button under already registered section
	@FindBy(xpath = "//*[@id=\'SubmitLogin\']/span/i")
	public WebElement xsignin_btn;

	// Error message for invalid email address for sign in try
	@FindBy(xpath = "//*[@id=\'center_column\']/div[1]")
	public WebElement xerror_msg_signin_lbl;

	// email text box in create an account section
	@FindBy(id = "email_create")
	public WebElement id_email_create_txt;

	// create an account button
	@FindBy(xpath = "//*[@id=\'SubmitCreate\']/span/i")
	public WebElement xcreate_acct_btn;

	// Error message for invalid email address for create an account
	@FindBy(id = "create_account_error")
	public WebElement ierrormsg_create_lbl;
	
	public login_signup_bug() {
		PageFactory.initElements(driver, this);
	}

	// Validation of error messages while logging in and signing up
	public void validate_error_message() {
		cls_signin_icon.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(xauthentication_lbl));

		id_email_signin_txt.sendKeys("@adbc.com");
		id_password_txt.sendKeys("password123");

		xsignin_btn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("thread interuppted");
		}
		Boolean signin_error = xerror_msg_signin_lbl.isDisplayed();
		Assert.assertTrue(signin_error, "Error message is displayed when email ID is invalid during sign in");

		id_email_create_txt.sendKeys("@xyz.com");
		xcreate_acct_btn.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("thread interuppted");
		}
		Boolean create_error = ierrormsg_create_lbl.isDisplayed();
		Assert.assertTrue(create_error,
				"Error message is displayed when email ID is invalid while creating an account");

		Assert.assertFalse(signin_error, "Error message is displayed when email ID is invalid during sign in");
		System.out.println(
				"Both the error messages are displayed at the same time. Error message while login try should have disappeared");
	}

}
