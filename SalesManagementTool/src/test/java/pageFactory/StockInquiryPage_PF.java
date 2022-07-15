package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static smtUtils.BaseDriver.*;

import java.time.Duration;

public class StockInquiryPage_PF {
	
	
	@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]")
	WebElement btn_selfName;
	
	@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]")
	WebElement txt_myStock;
	
	@FindBy(xpath = "//h2[contains(text(),'Stock Inquiries')]")
	WebElement txt_stockInquiryPage;
	
	@FindBy(xpath = "//label[contains(text(),'Partners')]")
	WebElement btn_partner;
	
	@FindBy(xpath = "//label[contains(text(),'Partners')]")
	WebElement btn_partnerName;
	
	@FindBy(xpath = "//label[@id='stockPartnerName']")
	WebElement txt_partnerStock;
	
	@FindBy(xpath = "//body/div[3]/aside[1]/div[1]/div[1]/div[2]/ul[1]/li[2]/a[1]")
	WebElement landingPage;
	
	
	public StockInquiryPage_PF() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void selfName() {
		btn_selfName.click();
	}
	
	
	public void verifySelfStock() {
		txt_myStock.isDisplayed();
	}
	
	
	public void verifyStockInquiryPage() {
		txt_stockInquiryPage.isDisplayed();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	public void partner() {
		btn_partner.click();
	}
	
	public void partnerName() {
		btn_partnerName.click();
	}
	
	public void verifyPartnerStock() {
		txt_partnerStock.isDisplayed();
	}
	
	public void returnToLandingPage() {
		landingPage.click();
	}

}
