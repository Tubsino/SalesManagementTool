package common;


import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends TakeShot implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("Test case "+result.getName()+" is starting");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailure(ITestResult result) {
		make_screenshot("Myscreenshot");
		System.out.println("Screenshot captured");
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("Failed due to timeout issue");
	}

}
