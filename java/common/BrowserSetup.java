package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserSetup {
	public WebDriver driver;
	
	
	@BeforeClass (groups = {"Smoke","functionality"})
	public void smtLogin() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://salesmanagement.9mobile.com.ng/salesmgmt/");	
	}
	
	@AfterClass (groups = {"Smoke","functionality"})
	public void closeBrowser() {
		driver.close();
	}

}
