package pageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static smtUtils.BaseDriver.*;

import java.time.Duration;

public class LandingPage_PF {
	
	@FindBy(xpath = "//body/div[3]/aside[1]/div[1]/div[1]/div[2]/ul[1]/li[2]/a[1]")
	WebElement btn_dashboard;
	
	@FindBy(xpath = "//body/div[3]/aside[1]/div[1]/div[1]/div[2]/ul[1]/li[3]/a[1]")
	WebElement btn_inventory;
	
	@FindBy(xpath = "//a[contains(text(),'Stock Inquiry')]")
	WebElement btn_stockInquiry;
	
	
	@FindBy(xpath = "//body/div[3]/aside[1]/div[1]/div[1]/div[2]/ul[1]/li[10]/a[1]")
	WebElement btn_settings;
	
	@FindBy(xpath = "//a[contains(text(),'Manage Settings')]")
	WebElement btn_manageSettings;
	
	@FindBy(xpath = "//h2[contains(text(),'Welcome, Olatunbosun Oshodi!')]")
	WebElement txt_landingPage;
	
	
	public LandingPage_PF() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void landingPage() {
		btn_dashboard.click();
	}
	
	public void inventory() {
		btn_inventory.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	public void stockInquiry() {
		btn_stockInquiry.click();
	}
	
	public void settings() {
		btn_settings.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",btn_manageSettings );
		//js.executeScript("window.scrollBy(0,-200)");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(btn_manageSettings));
	}
	
	public void manageSettings() {
		btn_manageSettings.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	
	}
	
	public void verifyLandingPage() {
		txt_landingPage.isDisplayed();
	}

}
