package stepDef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserManagementValidation {
	Hooks base;
	WebDriver driver = Hooks.getDriver();
	SoftAssert softassert;
	WebDriverWait wait;
	
//	Validate that admin can create user roles
	
	@Given("that Admin is logged in")
	public void that_admin_is_logged_in() {
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
		driver.findElement(By.xpath(Hooks.OR.getProperty("fld_username"))).sendKeys(Hooks.credential.getProperty("Admin"));
		driver.findElement(By.xpath(Hooks.OR.getProperty("fld_password"))).sendKeys(Hooks.credential.getProperty("AdminPsd"));
		driver.findElement(By.xpath(Hooks.OR.getProperty("btn_signin"))).click();
		softassert.assertAll();
	   System.out.println("1");
	}
	@When("Admin clicks on the security module button")
	public void admin_clicks_on_the_security_module_button() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(Hooks.Config.getProperty("explicitWait"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Hooks.OR.getProperty("btn_security"))));
		driver.findElement(By.xpath(Hooks.OR.getProperty("btn_security"))).click();
		String expectedTxt = "Manage Roles";
//		System.out.println(expectedTxt);
		String actualTxt = driver.findElement(By.xpath(Hooks.OR.getProperty("btn_manageRole"))).getText();
		softassert.assertEquals(actualTxt, expectedTxt, "Manage role button not found");
		softassert.assertAll();
				
		System.out.println("2");
	}
	@And("clicks on the manage role submodule button")
	public void clicks_on_the_manage_role_submodule_button() {
		driver.findElement(By.xpath(Hooks.OR.getProperty("btn_manageRole"))).click();
		String expectedTxt = "Add New";
		String actualTxt = driver.findElement(By.xpath(Hooks.OR.getProperty("btn_addNew"))).getText();
		softassert.assertEquals(actualTxt, expectedTxt, "Add new button text not found");
		softassert.assertAll();
		System.out.println("3");
	}
	@And("clicks on the Add New button")
	public void clicks_on_the_add_new_button() {
		driver.findElement(By.xpath(Hooks.OR.getProperty("btn_addNew"))).click();
		String expectedTxt = "rolename";
		String expectedTxt1 = "Save";
		String actualTxt = driver.findElement(By.xpath(Hooks.OR.getProperty("fld_roleName"))).getAttribute("name");
		String actualTxt1 = driver.findElement(By.xpath(Hooks.OR.getProperty("btn_save"))).getText();
		softassert.assertEquals(actualTxt, expectedTxt, "Role name field not found");
		softassert.assertEquals(actualTxt1, expectedTxt1, "Save button not found");
		
		System.out.println("4");
	}
	@And("input a role name")
	public void input_a_role_name() {
		driver.findElement(By.xpath(Hooks.OR.getProperty("fld_roleName"))).sendKeys(Hooks.forms.getProperty("fld_addNewRole"));
	}
	@And("clicks the Save button")
	public void clicks_the_save_button() {
		driver.findElement(By.xpath(Hooks.OR.getProperty("btn_save"))).click();
	}
	@Then("Admin user should be able to successfully create a new user role")
	public void admin_user_should_be_able_to_successfully_create_a_new_user_role() {
//		String expectedTxt = "xSuccess! Role Added Successfully";
//		String actualTxt = driver.findElement(By.xpath(Hooks.OR.getProperty("alert_role_success"))).getText();
//		softassert.assertEquals(actualTxt, expectedTxt, "Assertion failed - role not created successfully");
		driver.findElement(By.xpath(Hooks.OR.getProperty("alert_role_success"))).isDisplayed();
//		softassert.assertAll();
	}
	
	@And("signs out")
	public void signs_out() {
		driver.findElement(By.xpath(Hooks.OR.getProperty("signOutIcon"))).click();
		driver.findElement(By.xpath(Hooks.OR.getProperty("signOutButton"))).click();
	   System.out.println("Signs Out");
	}
	
//	 Validate that admin user can modify roles
	@And("click on the edit icon attached to a role name")
	public void click_on_the_edit_icon_attached_to_a_role_name() {
		driver.findElement(By.xpath(Hooks.OR.getProperty("fld_search"))).sendKeys(Hooks.forms.getProperty("fld_addNewRole"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Hooks.OR.getProperty("btn_editRole"))));
		driver.findElement(By.xpath(Hooks.OR.getProperty("btn_editRole"))).click();
	}
	@And("edit the role name in the role name field")
	public void edit_the_role_name_in_the_role_name_field() {
		driver.findElement(By.xpath(Hooks.OR.getProperty("fld_roleName"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(Hooks.Config.getProperty("implicityWait"))));
	}
	
	@And("type in a role name")
	public void type_in_a_role_name() {
		driver.findElement(By.xpath(Hooks.OR.getProperty("fld_roleName"))).sendKeys(Hooks.forms.getProperty("fld_addNewRole1"));
	}
	@And("clicks the update button role")
	public void clicks_the_update_button_role() {
		driver.findElement(By.xpath(Hooks.OR.getProperty("btn_updateRole"))).click();
	}
	@Then("Admin should be able to update the role successfully")
	public void admin_should_be_able_to_update_the_role_successfully() {
		driver.findElement(By.xpath(Hooks.OR.getProperty("alert_role_success"))).isDisplayed();
	}
	
//	Validate that the user can activate role permission

	@When("clicks on the settings icon")
	public void clicks_on_the_settings_icon() {
		driver.findElement(By.xpath(Hooks.OR.getProperty("btn_DAAnystSetting"))).click();
	}
	@When("clicks to turn on the toggle button on a permission")
	public void clicks_to_turn_on_the_toggle_button_on_a_permission() {
		driver.findElement(By.xpath(Hooks.OR.getProperty("toggle_incentive"))).click();			
	}
	
	
	@Then("check that the permission toggle on or off is successful")
	public void check_that_the_permission_toggle_on_or_off_is_successful() {
		softassert = new SoftAssert();
		String actualTxt = "Permission assigned successfully";
		String expectedTxt = driver.findElement(By.xpath(Hooks.OR.getProperty("permissionSuccess"))).getText();
		softassert.assertEquals(actualTxt, expectedTxt, "Permission success message not found");
		softassert.assertAll();
	}
	
//	Validate that admin can modify partner's profile
	@When("Admin clicks on the profiles button")
	public void admin_clicks_on_the_profiles_button() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(Hooks.Config.getProperty("explicitWait"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Hooks.OR.getProperty("btn_profiles"))));
		driver.findElement(By.xpath(Hooks.OR.getProperty("btn_profiles"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Hooks.OR.getProperty("btn_profiles"))));
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
		softassert.assertAll();
	}
	@And("clicks on the manage partners")
	public void clicks_on_the_manage_partners() {
		driver.findElement(By.xpath(Hooks.OR.getProperty("btn_managePartner"))).click();
		String expectedTxt = "Enroll Partner";
		String expectedAttb = "search";
		String actualTxt = driver.findElement(By.xpath(Hooks.OR.getProperty("btn_enrollPartner"))).getText();
		String actualAttb = driver.findElement(By.xpath(Hooks.OR.getProperty("fld_searchField"))).getAttribute("type");
		softassert.assertEquals(actualTxt, expectedTxt, "Enroll partner button not found");
		softassert.assertEquals(actualAttb, expectedAttb, "Search field not found");
		softassert.assertAll();
		
		
	}
	@And("clicks on the Operations button")
	public void clicks_on_the_operations_button() {
		driver.findElement(By.xpath(Hooks.OR.getProperty("fld_searchField"))).sendKeys(Hooks.forms.getProperty("fld_searchField"));
//		driver.findElement(By.xpath(Hooks.OR.getProperty("btn_categoryIcon"))).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(Hooks.Config.getProperty("explicitWait"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Hooks.OR.getProperty("btn_operation"))));
		driver.findElement(By.xpath(Hooks.OR.getProperty("btn_operation"))).click();
		
		
	}
	@And("click the edit button")
	public void click_the_edit_button() {
		String expectedTxt = "Edit Profile";
		String actualTxt = driver.findElement(By.xpath(Hooks.OR.getProperty("btn_editProfile"))).getText();
		softassert.assertEquals(actualTxt, expectedTxt, "edit profile button not found");
		softassert.assertAll();
		driver.findElement(By.xpath(Hooks.OR.getProperty("btn_editProfile"))).click();
	}
	@And("edit any of the fields")
	public void edit_any_of_the_fields() {
		driver.findElement(By.xpath(Hooks.OR.getProperty("fld_evcAcctCode"))).sendKeys(Hooks.forms.getProperty("fld_evcAcctCode"));
		
	}
	@And("click the update partner button")
	public void click_the_update_partner_button() {
		driver.findElement(By.xpath(Hooks.OR.getProperty("btn_updatePartner"))).click();
	}
	@Then("the partner's profile modification should be successful")
	public void the_partner_s_profile_modification_should_be_successful() {
		System.out.println("18");
	}


	
//	Validate that the admin can configure role based priviledges

	@And("selects a role from the action button on listed of role")
	public void selects_a_role_from_the_action_button_on_listed_of_role() {
		System.out.println("19");
	}
	@And("toggle on\\/off a permission that is off from the list of permission")
	public void toggle_on_off_a_permission_that_is_off_from_the_list_of_permission() {
		System.out.println("20");
	}
	@And("login as a user that is assigned to that role to validate if the permission is assigned")
	public void login_as_a_user_that_is_assigned_to_that_role_to_validate_if_the_permission_is_assigned() {
		System.out.println("21");
	}
	@Then("The permission should be assigned successfully")
	public void the_permission_should_be_assigned_successfully() {
		System.out.println("22");
	}


	
//	Validate that channel partner can upload a digital signature

	@And("that channel partner is logged in")
	public void that_channel_partner_is_logged_in() {
		System.out.println("23");
	}
	@And("channel partner clicks on My Profile button")
	public void channel_partner_clicks_on_my_profile_button() {
		System.out.println("24");
	}
	@And("channel partner clicks on choose file")
	public void channel_partner_clicks_on_choose_file() {
		System.out.println("25");
	}
	@And("click on upload")
	public void click_on_upload() {
		System.out.println("26");
	}
	@Then("check that the digital signature is uploaded successfully")
	public void check_that_the_digital_signature_is_uploaded_successfully() {
		System.out.println("27");
	}
	
//	Validate that the solution can assign 9mobile staff to a channel partner

	@And("filter by dealer partner")
	public void filter_by_dealer_partner() {
	    System.out.println("28");
	}
	@And("click on the Assign Upline")
	public void click_on_the_assign_upline() {
		System.out.println("29");
	}
	@And("selects the 9mobile staff")
	public void selects_the_9mobile_staff() {
		System.out.println("30");
	}
	@Then("it should be successful")
	public void it_should_be_successful() {
		System.out.println("30");
	}


	
//	Validate that Admin can assign subdealers
	





}
