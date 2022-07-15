package pageFactory;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static smtUtils.BaseDriver.*;

public class Homepage_PF {
	
	@FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[1]/div[2]/a[1]")
	WebElement btn_partner;
	
	
	
	public Homepage_PF() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void toPartnerLogin() {
		btn_partner.click();
	}
	

}
