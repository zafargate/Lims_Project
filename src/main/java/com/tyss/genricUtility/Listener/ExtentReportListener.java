package com.tyss.genricUtility.Listener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.tyss.genricUtility.AnnotationClass.Report;
import com.tyss.genricUtility.ConfigerClass.MainClass;
import com.tyss.genricUtility.Enum.PropertyKey;
import com.tyss.genricUtility.ExtarnalUtility.PropertyUtility;
import com.tyss.genricUtility.ExtentsRerportUtility.Reportutility;
import com.tyss.genricUtility.Miscl.UtilityInstanceTransf;

/**
 * This is ExtentReportListener Class Wich is implemented to the ITestListener
 * @author khanz
 *
 */
public class ExtentReportListener implements ITestListener {
	protected Reportutility report;
	public static Reportutility sReport;
	PropertyUtility propertyUtility = null; 
	
	/**
	 * This is Used For @BeforSuit lavel initiallization like as Reportutility();
	 * And Here initialliza to the satic sReport = report for the perpose of global using perpose
	 */
	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart--> Test");
		report = new Reportutility();
		sReport = report;
		
	}
	
	/**
	 * This methos is used for @AfterSuit Level close like as report.saveReport();
	 */
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish");
		report.saveReport();
	}
    
	/**
	 * This is Method is used for @BeforeTest level annotation 
	 * Here using  method declarion
	 * Here using  reportAnnotation.author(); for initiallization of the name of author
	 */
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
		report.createTest(result.getMethod().getMethodName());
		Report reportAnnotation = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Report.class);
		System.out.println(reportAnnotation.author());
		System.out.println(reportAnnotation.catagry());
		report.addAuthor(UtilityInstanceTransf.getExtentTest(), reportAnnotation.author());
		report.addCatagry(UtilityInstanceTransf.getExtentTest(), reportAnnotation.catagry());

	}
    
	/**
	 * this method used once the test will success
	 * massege is just pass
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");
		report.pass(UtilityInstanceTransf.getExtentTest(), result.getMethod().getMethodName() + " is Pass");
	}
    
	/**
	 * this method is used for once the test will be fail 
	 * report fail msg will pass With Attach Screenshot base64 as well as absolute pathg both
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");
		report.fail(UtilityInstanceTransf.getExtentTest(), result.getMethod().getMethodName() + " is fail",
				                                                                result.getThrowable());

		String screenShotPath = null;
//		screenShotPath = MainClass.class.cast(result.getMethod().getInstance()).seleniumUtility.takeScreenShot(
//				result.getMethod().getRealClass().getSimpleName(),
//				MainClass.class.cast(result.getMethod().getInstance()).javaUtility);	 
		screenShotPath = MainClass.class.cast(result.getMethod().getInstance()).seleniumUtility.takeScreenShot();
		report.attAchScreenshot(UtilityInstanceTransf.getExtentTest(), screenShotPath,
				propertyUtility.getPropertyData(PropertyKey.EXTENTREPORTTITLE), "base64");
		report.info(UtilityInstanceTransf.getExtentTest(), "Screenshot is taken");
	}

	/**
	 * once the will skip just pass the masg skip
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");
		report.skip(UtilityInstanceTransf.getExtentTest(), result.getMethod().getMethodName() + " is Failed",
				result.getThrowable());

	}
    
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

}
