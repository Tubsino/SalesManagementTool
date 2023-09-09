package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static smtUtils.BaseDriver.*;

public class LoginPage_PF {
	
	@FindBy(name = "username")
	WebElement txt_username;
	
	@FindBy(name = "password")
	WebElement txt_password;
	
	@FindBy(xpath = "//button[contains(text(),'Sign in')]")
	WebElement btn_signIn;
	
	@FindBy(xpath = "//h2[contains(text(),'Partner Sign In')]")
	WebElement txt_loginPage;
	
	@FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[1]")
	WebElement txt_errorloggin;
	
	
	
	public LoginPage_PF() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void verifyLoginPage() {
		txt_loginPage.isDisplayed();
	}
	
	public void enterUsername(String username) {
		txt_username.sendKeys(username);
	}
	
	
	public void enterPassword(String password) {
		txt_password.sendKeys(password);
	}
	
	public void SignIn() {
		btn_signIn.click();
	}
	
	public void loginErrorMessage() {
		txt_errorloggin.isDisplayed();
	}

}
