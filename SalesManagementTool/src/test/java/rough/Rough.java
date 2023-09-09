package rough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import stepDef.Hooks;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Rough {
	
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
		Properties Config = new Properties();
		Config.load(fis);
		
		Properties OR = new Properties();
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis);
		
		driver = new ChromeDriver();
		driver.get("https://salesmanagement.9mobile.com.ng/salesmgmt/");
//		driver.get("https://www.goal.com/en-ng");
		driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/div[2]/a[1]")).click();
		driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]")).sendKeys("Babe");
		
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]")).sendKeys("Daddy");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]")).clear();
		driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]")).sendKeys("Mother");
		
	}

}
