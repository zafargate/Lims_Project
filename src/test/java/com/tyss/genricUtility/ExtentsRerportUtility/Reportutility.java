package com.tyss.genricUtility.ExtentsRerportUtility;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tyss.genricUtility.Constants.FrameWorkConstatnt;
import com.tyss.genricUtility.Enum.PropertyKey;
import com.tyss.genricUtility.ExtarnalUtility.PropertyUtility;
import com.tyss.genricUtility.Miscl.JavaUtility;
import com.tyss.genricUtility.Miscl.UtilityInstanceTransf;

public class Reportutility {
	
	public  ExtentReports report;
	 

	
	public Reportutility() {
		init();
	}
	/**
	 * 
	 * @param filePath
	 * @param title
	 * @param reportName
	 * @param browserName
	 */
	private void init() {
		PropertyUtility propertyUtility=null;
		try {
			propertyUtility = new PropertyUtility(FrameWorkConstatnt.EXTENT_REPORT_PROPERTYFILE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String overrideOrNot=propertyUtility.getPropertyData(PropertyKey.OVERRIDEREPORT);
		String rendomName="";
		if(overrideOrNot.equalsIgnoreCase("no")) {
		 rendomName="_"+new JavaUtility().getSimpleDateFormate();
		}
		ExtentSparkReporter spark = new ExtentSparkReporter(FrameWorkConstatnt.EXTENT_REPORT_PATH+"extentreport"+rendomName+".html");
		spark.config().setDocumentTitle(propertyUtility.getPropertyData(PropertyKey.EXTENTREPORTTITLE));
		spark.config().setReportName(propertyUtility.getPropertyData(PropertyKey.EXTENTREPORTNAME));
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports(); 
		report.attachReporter(spark);
		report.setSystemInfo("browser",propertyUtility.getPropertyData(PropertyKey.BROWSER));
		report.setSystemInfo("os", System.getProperty("os.name"));
	}
	
	/**
	 * 
	 * @param testName
	 */
	public void createTest(String testName) {
		 ExtentTest test=report.createTest(testName);
		 UtilityInstanceTransf.setExtentTest(test);
  
	}
	
	/**
	 * 
	 * @param test
	 * @param name
	 */
	public void addAuthor(ExtentTest test,String... name) {
		test.assignAuthor(name);
	}
	/**
	 * 
	 * @param massege
	 */
	public void addCatagry( ExtentTest test,String... massege) {
		test.assignCategory(massege);
	}
	
	/**
	 * 
	 * @param massege
	 */
	public void fail( ExtentTest test,String massege,Throwable errMsg) {
		test.fail(massege);
		test.fail(errMsg);
	}
	 
	/**
	 * 
	 * @param errormassege
	 */
	public void skip( ExtentTest test,String massege,Throwable errormassege) {
		test.skip(massege);
		test.skip(errormassege);
		System.out.println(massege);
	}
	
	/**
	 * 
	 * @param massege
	 */
	public void pass(ExtentTest test,String massege) {
		test.pass(massege);
		System.out.println(massege);
	}
	
	 
	
	/**
	 * 
	 * @param massege
	 */
	public void warn(ExtentTest test,String massege) {
		test.warning(massege);
		System.out.println(massege);
	}
	
	/**
	 * 
	 * @param massege
	 */
	public void info(ExtentTest test,String massege) {
		test.info(massege);
		System.out.println(massege);
	}
	
	/**
	 * 
	 * @param screenShotPath
	 * @param title
	 * @param strategy
	 */
	public void attAchScreenshot(ExtentTest test,String screenShotPath,String title,String strategy){
		if(strategy.equalsIgnoreCase("base64")) {
			test.addScreenCaptureFromBase64String(screenShotPath,title);
		}
		else {
			test.addScreenCaptureFromPath(screenShotPath, title);
		}
	}
	
	/**
	 * 
	 */
	public void saveReport() {
		report.flush();
	}

	 
	
	
	
	
	
	
}
