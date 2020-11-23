package assessmentpackage;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TC_02Test  extends base {
	login_signup_bug obj_login_signup_bug;
	public TC_02Test() {
		super();
	}
	@BeforeSuite
	public void setUp() {
		initialization();
		obj_login_signup_bug = new login_signup_bug();
	}

	@Test
	public void validate_error_msg() {
		obj_login_signup_bug.validate_error_message();
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
