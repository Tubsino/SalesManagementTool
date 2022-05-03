package common;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TakeShot extends BrowserSetup {

//	public void captureScreenshot() throws IOException {
//		TakesScreenshot scrShot = ((TakesScreenshot) driver);
//		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
//		File destFile = new File("C://Users//Bluechip//eclipse-workspaceSMT//target//Screenshot/screenshot.png");
//		FileUtils.copyFile(srcFile, destFile);
//
//	}
//	
	
	 public void make_screenshot(String filename){

	        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	       try {
	        FileUtils.copyFile(scrFile, new File("test-output\\" +filename +".png").getAbsoluteFile());
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}

}
