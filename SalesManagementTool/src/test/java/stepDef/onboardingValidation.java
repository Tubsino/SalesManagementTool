package stepDef;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class onboardingValidation {

	WebDriver driver = Hooks.getDriver();
	Hooks base;
	SoftAssert softassert;
	WebDriverWait wait;
//	String originalWindow;
//	Validate that admin can login successfully

	@Given("that user is on the login page")
	public void that_users_is_on_the_login_page() {
		softassert = new SoftAssert();
		driver.findElement(By.xpath(Hooks.OR.getProperty("partnerLogin"))).click();
		String expectedEmailFld = "username";
		String expectedPwsdFld = "password";
		String expectedSignIn = "Sign in";
		String expectedText = "Please sign in to continue.";
		String actualText = driver.findElement(By.xpath(Hooks.OR.getProperty("verifyLoginPage"))).getText();
		softassert.assertEquals(actualText, expectedText, "User is not on login page");
		String actualEmailFld = driver.findElement(By.xpath(Hooks.OR.getProperty("fld_username"))).getAttribute("name");
		softassert.assertEquals(actualEmailFld, expectedEmailFld, "email field not present");
		String actualPwsdFld = driver.findElement(By.xpath(Hooks.OR.getProperty("fld_password"))).getAttribute("name");
		softassert.assertEquals(actualPwsdFld, expectedPwsdFld, "password field not present");
		String actualSignIn = driver.findElement(By.xpath(Hooks.OR.getProperty("btn_signin"))).getText();
		softassert.assertEquals(actualSignIn, expectedSignIn, "Sign in button not found");
		softassert.assertAll();
		System.out.println("Onboarding - step1");
	}

	@When("Admin enters username in the username field")
	public void admin_enters_username_in_the_username_field() {
		driver.findElement(By.xpath(Hooks.OR.getProperty("fld_username"))).sendKeys("Administrator@9mobile.com.ng");
//		System.out.println("Admin enters username");
		System.out.println("Onboarding - step2");
	}

	@And("enters password in the password field and click on sign in")
	public void enters_password_in_the_password_field_and_click_on_sign_in() {
		driver.findElement(By.xpath(Hooks.OR.getProperty("fld_password"))).sendKeys("p@ssw0rd");
		System.out.println("Admin enters password");
		System.out.println("Onboarding - step3");
	}

	@Then("Admin should be logged in successfully")
	public void admin_should_be_logged_in_successfully() {
		softassert = new SoftAssert();
		driver.findElement(By.xpath(Hooks.OR.getProperty("btn_signin"))).click();
		String expectedWlcm = "Welcome, 9Mobile Limited!";
//		String expectedDashbTxt = "Dashboard";
		String expectedProfileTxt = "Profiles";
//		String actualWlcm = driver.findElement(By.xpath(Hooks.OR.getProperty("verifyAdminWelcomeMsg"))).getText();
//		String actualDashbTxt = driver.findElement(By.xpath(Hooks.OR.getProperty("verifyDasboard"))).getText();
		String actualProfileTxt = driver.findElement(By.xpath(Hooks.OR.getProperty("btn_profiles"))).getText();
//		softassert.assertEquals(actualWlcm, expectedWlcm, "Welcome message not found");
//		softassert.assertEquals(actualDashbTxt, expectedDashbTxt, "Dashboard button not found");
		softassert.assertEquals(actualProfileTxt, expectedProfileTxt, "Dashboard button not found");
		softassert.assertAll();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(Hooks.Config.getProperty("implicityWait"))));
		System.out.println("Onboarding - step4");
		
		
		
	}

//	Validate that admin can enroll channel members

	@Given("that admin is logged in")
	public void that_admin_is_logged_in() {
		softassert = new SoftAssert();
//		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		String expectedText = "Partner Level:Administrator";
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Hooks.OR.getProperty("verifyAdminLandingPage"))));
		String actualText = driver.findElement(By.xpath(Hooks.OR.getProperty("verifyAdminLandingPage"))).getText();
		softassert.assertEquals(actualText, expectedText, "Admin is not on the landing page");
		softassert.assertAll();
		System.out.println("Onboarding - step5");

	}

	@When("Admin click on the profile submenu button")
	public void Admin_click_on_the_profile_submenu_button() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(Hooks.Config.getProperty("implicityWait"))));
		softassert = new SoftAssert();
		String expectedManagePartner = "Manage Partners";
		String expectedManageUser = "Manage Users";
		String expectedCommPrinter = "Commercial Printers";
//		String expectedAddNewCommPrinter = "Add New Commercial Printer";
		String actualManagePartner = driver.findElement(By.xpath(Hooks.OR.getProperty("btn_managePartner"))).getText();
		String actualManageUser = driver.findElement(By.xpath(Hooks.OR.getProperty("btn_manageUsers"))).getText();
		String actualCommPrinter = driver.findElement(By.xpath(Hooks.OR.getProperty("btn_commercialPrinter"))).getText();
//		String actualAddNewCommPrinter = driver.findElement(By.xpath(Hooks.OR.getProperty("Add New Commercial Printer"))).getText();
		softassert.assertEquals(expectedManagePartner, actualManagePartner, "Manage partner submodule button not found");
		softassert.assertEquals(expectedManageUser, actualManageUser, "Manage user submodule button not found");
		softassert.assertEquals(expectedCommPrinter, actualCommPrinter, "Commercial printer submodule button not found");
//		softassert.assertEquals(expectedAddNewCommPrinter, actualAddNewCommPrinter, "Add New Commercial printer submodule button not found");
		System.out.println("Onboarding - step6");
		
		

	}

	@And("Admin clicks manage partners")
	public void admin_clicks_manage_partners() {
		softassert = new SoftAssert();
		driver.findElement(By.xpath(Hooks.OR.getProperty("btn_profiles"))).click();
		driver.findElement(By.xpath(Hooks.OR.getProperty("btn_managePartner"))).click();
		String expectedEnrolledUserText = "Enrolled Users";
		String expectedLocationChange = "Approve Location Change";
		String expectedFilterBtn = "filter";
		String actualEnrolledUserText = driver.findElement(By.xpath(Hooks.OR.getProperty("btn_enrolledUser"))).getText();
		String actualLocationChange = driver.findElement(By.xpath(Hooks.OR.getProperty("btn_approveLocationChange"))).getText();
		String actualFilterBtn = driver.findElement(By.xpath(Hooks.OR.getProperty("btn_filterPartner"))).getAttribute("value");
		softassert.assertEquals(actualEnrolledUserText, expectedEnrolledUserText, "Enrolled Users button not found");
		softassert.assertEquals(actualLocationChange, expectedLocationChange, "expected location change button not found");
		softassert.assertEquals(actualFilterBtn, expectedFilterBtn, "filter button not found");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Onboarding - step7");
	}

	@And("clicks the enroll partner button")
	public void clicks_the_enroll_partner_button() {
		driver.findElement(By.xpath(Hooks.OR.getProperty("btn_enrolPartner"))).click();
		System.out.println("Onboarding - step8");
	}

	@And("fills the form")
	public void fills_the_form() {
		driver.findElement(By.xpath(Hooks.OR.getProperty("fld_partnerName")))
				.sendKeys(Hooks.forms.getProperty("fld_partnerName"));
		driver.findElement(By.xpath(Hooks.OR.getProperty("fld_evcAccountCode")))
				.sendKeys(Hooks.forms.getProperty("fld_evcAccountCode"));
		driver.findElement(By.xpath(Hooks.OR.getProperty("fld_phoneNo")))
				.sendKeys(Hooks.forms.getProperty("fld_phoneNo"));
		driver.findElement(By.xpath(Hooks.OR.getProperty("fld_emailAddy")))
				.sendKeys(Hooks.forms.getProperty("fld_emailAddy"));
		WebElement partnerCat = driver.findElement(By.xpath(Hooks.OR.getProperty("slt_partnerCategory")));
		Select sel = new Select(partnerCat);
		sel.selectByValue(Hooks.OR.getProperty("subdealer_cat_value"));
		driver.findElement(By.xpath(Hooks.OR.getProperty("fld_addy"))).sendKeys(Hooks.forms.getProperty("fld_addy"));
		WebElement uplineCat = driver.findElement(By.xpath(Hooks.OR.getProperty("slt_assignUpline")));
		Select sel1 = new Select(uplineCat);
		sel1.selectByVisibleText(Hooks.OR.getProperty("upline_cat_name"));
		driver.findElement(By.xpath(Hooks.OR.getProperty("toggle_lockUserAccount"))).click();
		System.out.println("Onboarding - step9");

	}

	@And("clicks the Add Partner button")
	public void clicks_the_add_partner_button() {
		driver.findElement(By.xpath(Hooks.OR.getProperty("btn_addPartner"))).click();
		System.out.println("Onboarding - step10");
	}

	@Then("it should be successfull")
	public void it_should_be_successfull() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String expectedText = "Partner List";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Hooks.OR.getProperty("btn_partnerList"))));
		String actualText = driver.findElement(By.xpath(Hooks.OR.getProperty("btn_partnerList"))).getText();
		Assert.assertEquals(actualText, expectedText, "user not enrolled successfully");
		System.out.println("Onboarding - step11");
	}

//	Validate that the solution can prevent duplicate of channel members at the point of creation

	@Given("Admin is on the landing page")
	public void admin_is_on_the_landing_page() {
		
		softassert = new SoftAssert();
		String expectedText = "Administrator";
		String actualText = driver.findElement(By.xpath(Hooks.OR.getProperty("verifyAdminPage"))).getText();
		softassert.assertEquals(actualText, expectedText, "Admin is not logged in");
		softassert.assertAll();
		System.out.println("Onboarding - step12");
	}

	@When("Admin clicks on the profile submenu btn")
	public void admin_clicks_on_the_profile_submenu_btn() {
		driver.findElement(By.xpath(Hooks.OR.getProperty("btn_profiles"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Onboarding - step13");
	}

	@And("Admin clicks manage partners btn")
	public void admin_clicks_manage_partners_btn() {
		driver.findElement(By.xpath(Hooks.OR.getProperty("btn_managePartner"))).click();
		System.out.println("Onboarding - step14");
	}

	@And("clicks the enroll partner btn")
	public void clicks_the_enroll_partner_btn() {
		driver.findElement(By.xpath(Hooks.OR.getProperty("btn_enrolPartner"))).click();
		System.out.println("Onboarding - step15");
	}

	@And("fills the form in the page")
	public void fills_the_form_in_the_page() {
		driver.findElement(By.xpath(Hooks.OR.getProperty("fld_partnerName")))
				.sendKeys(Hooks.forms.getProperty("fld_partnerName"));
		driver.findElement(By.xpath(Hooks.OR.getProperty("fld_evcAccountCode")))
				.sendKeys(Hooks.forms.getProperty("fld_evcAccountCode"));
		driver.findElement(By.xpath(Hooks.OR.getProperty("fld_phoneNo")))
				.sendKeys(Hooks.forms.getProperty("fld_phoneNo"));
		driver.findElement(By.xpath(Hooks.OR.getProperty("fld_emailAddy")))
				.sendKeys(Hooks.forms.getProperty("fld_emailAddy"));
		WebElement partnerCat = driver.findElement(By.xpath(Hooks.OR.getProperty("slt_partnerCategory")));
		Select sel = new Select(partnerCat);
		sel.selectByValue(Hooks.OR.getProperty("subdealer_cat_value"));
		driver.findElement(By.xpath(Hooks.OR.getProperty("fld_addy"))).sendKeys(Hooks.forms.getProperty("fld_addy"));
		WebElement uplineCat = driver.findElement(By.xpath(Hooks.OR.getProperty("slt_assignUpline")));
		Select sel1 = new Select(uplineCat);
		sel1.selectByVisibleText(Hooks.OR.getProperty("upline_cat_name"));
		driver.findElement(By.xpath(Hooks.OR.getProperty("toggle_lockUserAccount"))).click();
		System.out.println("Onboarding - step16");
	}

	@And("clicks the Add Partner btn")
	public void clicks_the_add_partner_btn() {
		driver.findElement(By.xpath(Hooks.OR.getProperty("btn_addPartner"))).click();
		System.out.println("Onboarding - step17");
	}

	@Then("it should not be successfull")
	public void it_should_not_be_successfull() {
		softassert = new SoftAssert();
		String expectedAlert = "To List";
		String actualAlert = driver.findElement(By.xpath(Hooks.OR.getProperty("verify_duplicate"))).getText();
		softassert.assertEquals(actualAlert, expectedAlert, "user not enrolled successfully");
		softassert.assertAll();
		System.out.println("Onboarding - step18");
	}
	
//	Validate that the system allow single user access at a time
	
	
	@Given("that Admin launches the app on a new window")
	public String that_admin_launches_the_app_on_a_new_windowb() {
//		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		String originalWindow = driver.getWindowHandle();
		assert driver.getWindowHandles().size() ==1;
	    driver.switchTo().newWindow(WindowType.WINDOW);
//	    wait.
	    driver.get(Hooks.Config.getProperty("appUrl"));
		return originalWindow;
		
	}
	@When("Admin logs into the application")
	public void Admin_logs_into_the_application() {
		String originalWindow = this.that_admin_launches_the_app_on_a_new_windowb();
		driver.findElement(By.xpath(Hooks.OR.getProperty("fld_username"))).sendKeys("Administrator@9mobile.com.ng");
		driver.findElement(By.xpath(Hooks.OR.getProperty("fld_password"))).sendKeys("p@ssw0rd");
		driver.findElement(By.xpath(Hooks.OR.getProperty("btn_signin"))).click();
		for (String windowHandle : driver.getWindowHandles()) {if(!originalWindow.contentEquals(windowHandle)) {
	        driver.switchTo().window(windowHandle);
	        break;}
		}
		System.out.println("Onboarding - step19");
		    
	}
	@And("goes back to the previous tab")
	public void goes_back_to_the_previous_tab() {
		System.out.println("Onboarding - step20");
	}
	@And("refreshing the page")
	public void refreshing_the_page() {
		System.out.println("Onboarding - step21");
	}
	@Then("a error message should display")
	public void a_error_message_should_display() {
		System.out.println("Onboarding - step22");
	}

}
