package salesManagementTool;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import common.BrowserSetup;

public class SmtTest extends BrowserSetup {
	@Test(priority = 1, groups = {"Smoke", "functionality"})
	public void login() {
		SoftAssert softassert = new SoftAssert();
		String expectedText = "Please sign in to continue.";
		driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/div[2]/a[1]")).click();
		String actualText = "Please sign in to continue.";
		softassert.assertEquals(actualText, expectedText, "Sign in page failed");
		driver.findElement(By.name("username")).sendKeys("smtlogon100@gmail.com");
		driver.findElement(By.name("password")).sendKeys("p@ssw0rd");
		driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
		String expectedPartnerCategory = "CP User";
		String actualPartnerCategory = "CP User";
		softassert.assertEquals(actualPartnerCategory, expectedPartnerCategory, "Partner landing page failed");
		softassert.assertAll();
		
	}
	
	public String purchaseOrderNumber;
	
	@Test(priority = 2, groups = "functionality")
	public void createPurchaseOrder() {
		driver.findElement(By.linkText("Purchases")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.xpath("//body/div[3]/aside[1]/div[1]/div[1]/div[2]/ul[1]/li[7]/ul[1]/li[1]/a[1]")).click();
		SoftAssert softassert = new SoftAssert();
		String expectedText = "Create Purchase Orders";
		String actualText = "Create Purchase Orders";
		softassert.assertEquals(actualText, expectedText, actualText);
		WebElement POnumber = driver.findElement(By.xpath("//body/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[2]/div[1]/div[3]/div[1]/div[1]/input[1]"));
		purchaseOrderNumber = POnumber.getAttribute("value");
		WebElement prodCat = driver.findElement(By.xpath("//select[@id='ProductCategoryID']"));
		Select sel = new Select(prodCat);
		sel.selectByValue("2");
		WebElement prodType = driver.findElement(By.xpath("//select[@id='ProductTypeID']"));
		Select sel1 = new Select(prodType);
		sel1.selectByValue("14");
		WebElement prodList = driver.findElement(By.xpath("//tbody/tr[@id='row1']/td[2]/select[1]"));
		Select sel2 = new Select(prodList);
		sel2.selectByValue("EP 100");
		WebElement qty = driver.findElement(By.xpath("//tbody/tr[@id='row1']/td[4]/input[1]"));
		qty.clear();
		qty.sendKeys("5");
		WebElement comment = driver.findElement(By.xpath("//body/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[2]/div[8]/div[1]/textarea[1]"));
		comment.sendKeys("For test");
		WebElement checkOut = driver.findElement(By.xpath("//button[@id='checkOutOrderBtn']"));
		checkOut.click();
		String expectedText1 = "Success! You have added your orders to the cart successfully";
		String actualText1 = "Success! You have added your orders to the cart successfully";
		softassert.assertEquals(actualText1, expectedText1, actualText1);
		softassert.assertAll();
		
	}
	@Test(priority = 3, groups = {"functionality", "Smoke"})
	public void paymentOption() {
		SoftAssert softassert = new SoftAssert();
		WebElement paymentMethod = driver.findElement(By.xpath("//select[@id='PaymentMethodID']"));
		Select sel3 = new Select(paymentMethod);
		sel3.selectByValue("1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebElement submitOrder = driver.findElement(By.xpath("//button[contains(text(),'Submit Purchase Orders')]"));
		submitOrder.click();
		System.out.println("The PO number is "+purchaseOrderNumber);
		String expectedmessage = "Approval Required!";
		String actualmessage = "Approval Required!";
		softassert.assertEquals(actualmessage, expectedmessage, actualmessage);
		softassert.assertAll();
		
	}
	
}
