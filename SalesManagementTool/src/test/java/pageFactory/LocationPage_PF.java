package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static smtUtils.BaseDriver.*;

public class LocationPage_PF {
	
	@FindBy(xpath = "//a[contains(text(),'Create New Location')]")
	WebElement btn_createNewLocation;
	
	
	public LocationPage_PF() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void verifyLocation() {
		btn_createNewLocation.isDisplayed();
	}

}
