package stepDef;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	
	private static WebDriver driver;
	public static FileInputStream fis;
	public static Properties Config;
	public static Properties OR;
	public static Properties forms;
	public static Properties expected;
	public static Properties credential;
	public static WebDriverWait wait;
	
	@BeforeAll
	public static void setup(){
		if(driver == null) {
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Config = new Properties();
			try {
				Config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			OR = new Properties();
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			forms = new Properties();
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\forms.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				forms.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			expected = new Properties();
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\forms.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				expected.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			credential = new Properties();
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\credential.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				credential.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(Config.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(Config.getProperty("appUrl"));
//			driver.findElement(By.xpath(OR.getProperty("partnerLogin"))).click();
			
		} else if(Config.getProperty("browser").equals("fireFox")) {
			WebDriverManager.firefoxdriver().setup();;
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(Config.getProperty("appUrl"));
		}
		
	}
	
//	@Before
//	public static void loginPage() {
//		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(Config.getProperty("explicitWait"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("partnerLogin"))));
//		driver.findElement(By.xpath(Hooks.OR.getProperty("partnerLogin"))).click();
//	}
	
//	@After
//	public static void signOut() {
//		driver.findElement(By.xpath(OR.getProperty("signOutIcon"))).click();
//		driver.findElement(By.xpath(OR.getProperty("signOutButton"))).click();
//	}
	
	
	public static WebDriver getDriver() {
		return driver;
	}
	
//	@AfterAll
//	public static void tearDown() {
//		if(driver != null) {
//			driver.close();
//		}
//	}

}
