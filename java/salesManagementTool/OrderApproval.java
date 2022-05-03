package salesManagementTool;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OrderApproval extends SmtTest {
	@Test(priority = 4, groups = "Smoke")
	public void loginCpApproval () {
		WebElement username = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]"));
		username.sendKeys("iremide292@gmail.com");
		WebElement password = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/div[2]/input[1]"));
		password.sendKeys("p@ssw0rd");
		driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
		
	}
	
	@Test(priority = 5, groups = {"functionality", "Smoke"})
	public void orderPage () {
		
		driver.findElement(By.linkText("Purchases")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.xpath("//body/div[3]/aside[1]/div[1]/div[1]/div[2]/ul[1]/li[7]/ul[1]/li[1]/a[1]")).click();
		SoftAssert softassert = new SoftAssert();
		String expectedText = "INQUIRIES";
		String actualText = "INQUIRIES";
		softassert.assertEquals(actualText, expectedText, "Order Inquiry page failed to load");
		softassert.assertAll();
		WebElement searchField = driver.findElement(By.xpath("//body/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/label[1]/input[1]"));
		searchField.sendKeys("purchaseOrderNumber");
		WebElement gearIcon = driver.findElement(By.xpath("//tbody/tr[1]/td[14]/div[1]/a[1]"));
		gearIcon.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		
	}

}
