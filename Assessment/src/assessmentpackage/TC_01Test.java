package assessmentpackage;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TC_01Test extends base{
	
	searchproduct obj_searchproduct;
	add_remove_cart obj_add_remove_checkout;

	public TC_01Test() {
		super();
	}
	
	@BeforeSuite
	public void setUp() {
		initialization();
		obj_searchproduct = new searchproduct();
		obj_add_remove_checkout = new add_remove_cart();
	}

	@Test(priority = 1)
	public void validate_search_button() {
		obj_searchproduct.validate_search_pant();
		obj_searchproduct.validate_search_dress();
		obj_searchproduct.validate_search_blouse();
		obj_searchproduct.validate_search_tshirt();
	}

	@Test(priority = 2)
	public void validate_cart() {
		obj_add_remove_checkout.validate_cartitems();
	}

	@Test(priority = 3)
	public void validate_removeitems() {
		obj_add_remove_checkout.validate_remove_items_from_Cart();
	}

	@Test(priority = 4)
	public void validate_chkout() {
		obj_add_remove_checkout.validate_checkout();
	}

	@AfterSuite
	public void driverquit() {
		driver.quit();
	}

}
