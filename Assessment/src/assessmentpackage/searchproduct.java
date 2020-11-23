package assessmentpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class searchproduct extends base{

	// Web element Search text box
	@FindBy(id = "search_query_top")
	public WebElement i_search_txt;

	// search button submit icon
	@FindBy(name = "submit_search")
	public WebElement nm_search_btn;

	// no result found
	@FindBy(xpath="//*[@id=\'center_column\']/p")
	public WebElement xnoresult_lbl;

	// no result found
	@FindBy(xpath="//*[@id=\'center_column\']/h1/span")
	public WebElement xzeroresults_lbl;

	// search dress
	@FindBy(xpath = "//*[@id=\'center_column\']/ul/li[1]/div/div[2]/h5/a")
	public WebElement xdress_lnk;

	// search blouse
	@FindBy(xpath = "//*[@id=\'center_column\']/ul/li/div/div[2]/h5/a")
	public WebElement xblouse_lnk;

	// search t0shirt
	@FindBy(xpath = "//*[@id=\'center_column\']/ul/li/div/div[2]/h5/a")
	public WebElement xtshirt_lnk;
	
	public searchproduct() {
		PageFactory.initElements(driver, this);
	}

	// Search for pant
	public void validate_search_pant() {
		try{
			Thread.sleep(3000);
			}
			catch(InterruptedException e){
				System.out.println("thread interuppted");
			}
		i_search_txt.clear();
		i_search_txt.sendKeys("pant");
		nm_search_btn.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Boolean no_results = xnoresult_lbl.isDisplayed();
		Assert.assertTrue(no_results, "There are no results fetched for pants");
		Boolean zero_results = xnoresult_lbl.isDisplayed();
		Assert.assertTrue(zero_results, "There are no results fetched for pants. Validation passed");

	}

	//search for dress
	public void validate_search_dress() {
		i_search_txt.clear();
		i_search_txt.sendKeys("printed summer dress");
		nm_search_btn.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Boolean dress = xdress_lnk.isDisplayed();
		Assert.assertTrue(dress, "Dress items are displayed for the search. Validation passed");
	}

	//search for blouse
	public void validate_search_blouse() {
		i_search_txt.clear();
		i_search_txt.sendKeys("blouse");
		nm_search_btn.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Boolean blouse = xblouse_lnk.isDisplayed();
		Assert.assertTrue(blouse, "Blouse item is displayed for the search. Validation passed");
	}

	//search for T-shirt
	public void validate_search_tshirt() {
		i_search_txt.clear();
		i_search_txt.sendKeys("t-shirt");
		nm_search_btn.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Boolean tshirt = xtshirt_lnk.isDisplayed();
		Assert.assertTrue(tshirt, "T-shirt item is displayed for the search. Validation passed");
	}

}
