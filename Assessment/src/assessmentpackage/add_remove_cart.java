package assessmentpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class add_remove_cart extends base {

	// Create object for class search product
	searchproduct obj_searchproduct = new searchproduct();

	// web element add to cart button
	@FindBy(xpath = "//*[@id=\'add_to_cart\']/button/span")
	public WebElement xaddtocart_btn;

	// close button in the pop up
	@FindBy(xpath = "//*[@id=\'layer_cart\']/div[1]/div[1]/span")
	public WebElement xclose_btn;

	// cart button on the page to proceed to cart
	@FindBy(xpath = "//*[@id=\'header\']/div[3]/div/div/div[3]/div/a")
	public WebElement xcart_btn;

	// shopping cart summary label in the cart
	@FindBy(id = "cart_title")
	public WebElement icartsummary_lbl;

	// delete button for the first item in the cart
	@FindBy(xpath = "//*[@id=\'5_19_0_0\']/i")
	public WebElement xdelete_icon1;

	// proceed to check out button in the cart
	@FindBy(xpath = "//*[@id=\'center_column\']/p[2]/a[1]/span/i")
	public WebElement xcheckout_btn;

	// authentication label on the authentication page (login /Sign up page)
	@FindBy(xpath = "//*[@id=\'center_column\']/h1")
	public WebElement xauthentication_lbl;

	public add_remove_cart() {
		PageFactory.initElements(driver, this);
	}

	// add a dress to the cart
	public void add_dress() {
		obj_searchproduct.validate_search_dress();

		obj_searchproduct.xdress_lnk.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(xaddtocart_btn));
		xaddtocart_btn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("thread interuppted");
		}
		xclose_btn.click();
	}

	// add a blouse to the cart
	public void add_blouse() {
		obj_searchproduct.validate_search_blouse();
		obj_searchproduct.xblouse_lnk.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(xaddtocart_btn));
		xaddtocart_btn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("thread interuppted");
		}
		xclose_btn.click();
	}

	// add a T-shirt to the cart
	public void add_tshirt() {
		obj_searchproduct.validate_search_tshirt();
		obj_searchproduct.xtshirt_lnk.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(xaddtocart_btn));
		xaddtocart_btn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("thread interuppted");
		}
		xclose_btn.click();
	}

	// Validate if the items added are displayed in the cart
	public void validate_cartitems() {
		add_dress();
		add_blouse();
		add_tshirt();
		xcart_btn.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(icartsummary_lbl));
		Boolean cart_dress = driver.findElement(By.partialLinkText("dress")).isDisplayed();
		Assert.assertTrue(cart_dress, "Dress added is displayed reflected in the cart. Validation passed");
		Boolean cart_blouse = driver.findElement(By.partialLinkText("Blouse")).isDisplayed();
		Assert.assertTrue(cart_blouse, "Blouse added is displayed reflected in the cart. Validation passed");
		Boolean cart_tshirt = driver.findElement(By.partialLinkText("shirt")).isDisplayed();
		Assert.assertTrue(cart_tshirt, "T-shirt added is displayed reflected in the cart. Validation passed");

	}

	// Remove item from the cart
	Boolean cart_dress;
	public void validate_remove_items_from_Cart() {
		/*
		 * add_dress(); add_blouse(); add_tshirt(); xcart_btn.click();
		 * 
		 * WebDriverWait wait = new WebDriverWait(driver, 10);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(icartsummary_lbl);
		 */

		xdelete_icon1.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("thread interuppted");
		}
		try {
			cart_dress = driver.findElement(By.partialLinkText("dress")).isDisplayed();
			Assert.assertTrue(cart_dress, "Dress added to the cart is not removed. Validation failed");

		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertTrue(cart_dress, "Dress added to the cart is now removed. Validation passed");
		}
	}

	// validation of check out button
	public void validate_checkout() {
		/*
		 * add_dress(); add_blouse(); add_tshirt(); xcart_btn.click(); WebDriverWait
		 * wait = new WebDriverWait(driver, 10);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(icartsummary_lbl);
		 */

		xcheckout_btn.click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(xauthentication_lbl));
		Boolean check_out = xauthentication_lbl.isDisplayed();
		Assert.assertTrue(check_out,
				"Proceed to check out is leading to authentication page. Check-out button validation passed");

	}

}
