package com.tyss.genricUtility.Miscl;
import com.aventstack.extentreports.ExtentTest;

public class UtilityInstanceTransf {

	 
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	/**
	 * 
	 * @return
	 */
	public static ExtentTest getExtentTest() {
		return extentTest.get();
	}

	/**
	 * 
	 * @param setExtentTest
	 */
	public static void setExtentTest(ExtentTest setExtentTest) {
		extentTest.set(setExtentTest);
	}
	 

	 

}
