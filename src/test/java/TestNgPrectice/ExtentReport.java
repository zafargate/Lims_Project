package TestNgPrectice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tyss.genricUtility.Miscl.JavaUtility;
import com.tyss.genricUtility.WebAction.SeleniumUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReport {
	
	@Test
	public void demoTestReport() {
		ExtentSparkReporter spark=new ExtentSparkReporter("./reports/exteReport.html");
		ExtentReports report=new ExtentReports();
		report.attachReporter(spark);
		ExtentTest abcTest=report.createTest("abc");
		abcTest.log(Status.FAIL, "TestCase Fail");
		abcTest.log(Status.PASS, "TestCase Pass");
		abcTest.log(Status.INFO, "TestCase Info");
		abcTest.log(Status.WARNING, "TestCase Warning");
		abcTest.log(Status.SKIP, "TestCase Skip");
		ExtentTest xyz=report.createTest("xyz");
		xyz.log(Status.INFO, "TestCase Info");
		xyz.log(Status.INFO, "TestCase Info");
		xyz.log(Status.INFO, "TestCase Info");
		xyz.log(Status.INFO, "TestCase Info");
		xyz.log(Status.INFO, "TestCase Info");
		
		
		spark.config().setDocumentTitle("Extent report Title");
		spark.config().setReportName("Lims");
		spark.config().setTheme(Theme.DARK);
		report.setSystemInfo("report","zafar");
		ExtentTest pqr=report.createTest("pqr");
		pqr.fail("TestCase Fail");
		pqr.pass("testCAse pass");
		pqr.info("testCase Info");
		
		JavaUtility javaUtility=new JavaUtility();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		SeleniumUtility seleniumUtility=new SeleniumUtility();
		driver.get("https://instagram.com");
		
		abcTest.addScreenCaptureFromPath( seleniumUtility.takeScreenShot("demoTestReport",javaUtility));
		 
		report.flush();
		
	}

	 
	

}
