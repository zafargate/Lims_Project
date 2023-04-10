package com.tyss.genricUtility.Listener;
import org.testng.IClassListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.tyss.genricUtility.ConfigerClass.MainClass;
 
 

public class ListenerImplementation implements ITestListener,IClassListener,ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		 System.out.println("onStart :-->Suit");
	}

	@Override
	public void onFinish(ISuite suite) {
		 System.out.println("onFinish:-->Suit");
	}

	@Override
	public void onBeforeClass(ITestClass testClass) {
		 System.out.println("onStart-->class");
	}

	@Override
	public void onAfterClass(ITestClass testClass) {
		 System.out.println("onAfterClass-->class");
	}

	@Override
	public void onTestStart(ITestResult result) {
		 System.out.println("onTestStart--->Test");
		
		 
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		 System.out.println("onTestSuccess--->Test");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		 System.out.println("onTestFailure--->Test");
		 MainClass.class.cast(result.getMethod().getInstance()).seleniumUtility.takeScreenShot(
				   result.getMethod().getRealClass().getSimpleName(), 
				   MainClass.class.cast(result.getMethod().getInstance()).javaUtility);
		 
	  
	   
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		 System.out.println("onStart--->Test");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		 System.out.println("onStart--->Test");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		 System.out.println("onTestFailedWithTimeout--->Test");
	}

	@Override
	public void onStart(ITestContext context) {
		 System.out.println("onStart-->ITestContext");
	}

	@Override
	public void onFinish(ITestContext context) {
		 System.out.println("onFinish--->ITestContext");
	}

}
