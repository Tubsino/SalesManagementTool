package stepDefinition;

import org.openqa.selenium.WebDriver;
import static smtUtils.BaseDriver.*;

import java.time.Duration;

import io.cucumber.java.en.*;
import pageFactory.Homepage_PF;
import pageFactory.LandingPage_PF;
import pageFactory.LoginPage_PF;
import pageFactory.StockInquiryPage_PF;
import pageFactory.LocationPage_PF;

public class SmtStep {
	
	WebDriver cdriver;
	Homepage_PF home;
	LoginPage_PF login;
	LandingPage_PF landing;
	StockInquiryPage_PF inventory;
	LocationPage_PF location;
	
	
	@Given("user is on log in page")
	public void user_is_on_log_in_page() {
		cdriver = getDriver();
	    cdriver.get("https://salesmanagement.9mobile.com.ng/salesmgmt/");
	    home = new Homepage_PF();
	    home.toPartnerLogin();
	    login = new LoginPage_PF();
	    login.verifyLoginPage();
	}

	@When("^user enters invalid (.*) and (.*)$")
	public void user_enters_invalid_email_and_invalid_password(String username, String password) {
	    login.enterUsername(username);
	    login.enterPassword(password);
	}

	@And("clicks the Sign In button")
	public void clicks_the_sign_in_button() {
		login.SignIn();
	}

	@Then("user should not be able to sign in")
	public void user_should_not_be_able_to_sign_in() {
	  login.loginErrorMessage();
	  driver.navigate().refresh();
	}

	@Given("user is on login page")
	public void user_is_on_login_page() {
		login = new LoginPage_PF();
		login.verifyLoginPage();
	}

	@When("^user enters valid (.*) and valid (.*)$")
	public void user_enters_valid_email_and_valid_password(String username1, String password1) {
	   login.enterUsername(username1);
	   login.enterPassword(password1);
	}

	@And("clicks the Sign In button for valid login")
	public void clicks_the_sign_in_button_for_valid_login() {
	    login.SignIn();
	}

	@Then("user should be able to sign in successfully")
	public void user_should_be_able_to_sign_in_successfully() {
	    landing = new LandingPage_PF();
	    landing.verifyLandingPage();
	}

	@Given("user is on landing page \\(Dashboard)")
	public void user_is_on_landing_page_dashboard() {
	    landing = new LandingPage_PF();
	    landing.landingPage();
	}

	@When("user clicks on Inventory")
	public void user_clicks_on_inventory() {
	    landing.inventory();
	}
	
	@And("clicks on Stock Inquiry")
	public void clicks_on_stock_inquiry() {
	    landing.stockInquiry();
	}

	@And("clicks on user's name")
	public void clicks_on_user_s_name() {
	    inventory = new StockInquiryPage_PF();
	    inventory.selfName();
	}

	@Then("The list of stocks in the inventory should display successfully for the dealer")
	public void the_list_of_stocks_in_the_inventory_should_display_successfully_for_the_dealer() {
	    inventory.verifySelfStock();
	}

	@Given("user is on stock inquiry page")
	public void user_is_on_stock_inquiry_page() {
	    inventory = new StockInquiryPage_PF();
	    inventory.verifyStockInquiryPage();
	}

	@When("user click on the partner button")
	public void user_click_on_the_partner_button() {
	    inventory.partner();
	}

	@And("click on any partner's name")
	public void click_on_any_partner_s_name() {
		inventory.partnerName();
	}

	@Then("The list of stocks in the partner's inventory should display successfully for the subdealer")
	public void the_list_of_stocks_in_the_partner_s_inventory_should_display_successfully_for_the_subdealer() {
	    inventory.verifyPartnerStock();
	}

	@Given("user is on the landing page Dashboard")
	public void user_is_on_the_landing_page_dashboard() {
		landing = new LandingPage_PF();
		landing.landingPage();
		landing.verifyLandingPage();
	}

	@When("user clicks on Settings")
	public void user_clicks_on_settings() {
	    landing.settings();
	}

	@And("click on Manage Settings")
	public void click_on_manage_settings() {
	    landing.manageSettings();
	}

	@Then("location page should display successfully")
	public void location_page_should_display_successfully() {
	    location = new LocationPage_PF();
	    location.verifyLocation();
	    driver.close();
	}

}
