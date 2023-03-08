//package TestNgPrectice;
//
//import java.io.IOException;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Listeners;
//import org.testng.annotations.Optional;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.tyss.genricUtility.AnnotationClass.Report;
//import com.tyss.genricUtility.ConfigerClass.MainClasssDeclration;
//import com.tyss.genricUtility.Constants.FrameWorkConstatnt;
//import com.tyss.genricUtility.Enum.PropertyKey;
//import com.tyss.genricUtility.ExtarnalUtility.ExcellUtility;
//import com.tyss.genricUtility.ExtarnalUtility.PropertyUtility;
//import com.tyss.genricUtility.Miscl.IntractionUtility;
//import com.tyss.genricUtility.Miscl.JavaUtility;
//import com.tyss.genricUtility.Miscl.VerificationUtility;
//import com.tyss.genricUtility.ObjectRepository.CommonPage;
//import com.tyss.genricUtility.ObjectRepository.LimsHomePagaeCommonEle;
//import com.tyss.genricUtility.WebAction.SeleniumUtility;
//import com.tyss.genricUtility.WebAction.WaitUtility;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//@Listeners(com.tyss.genricUtility.Listener.ListenerImplementation.class)
// 
//public class BasePracticeClass extends MainClasssDeclration   {
// 
//	 
//	@Report(catagry = "senity", assign = { "Manoj" }, author = "zafar")
//	@Parameters(value="browser")
//	@BeforeClass(alwaysRun = true)
//	void LaunchBrowser(@Optional String browser) throws IOException {
//		System.out.println("LaunchBrowser");
//		propUtiles = new PropertyUtility(FrameWorkConstatnt.TEST_PROPERTY_FILE_PATH);
//		excellUtiles = new ExcellUtility(FrameWorkConstatnt.TEST_EXCELL_FILE_PATH);
//		javaUtility = new JavaUtility();
//		seleniumUtility = new SeleniumUtility();
//		verificationUtility = new VerificationUtility();
//		waitUtility = new WaitUtility();
//		
//		if (browser.isBlank() || browser.isEmpty() || browser.equalsIgnoreCase("")) {
//			browser = propUtiles.getPropertyData(PropertyKey.BROWSER);
//			System.out.println(browser);
//		}
//	    this.browser=browser;
//		seleniumUtility = new SeleniumUtility();
//		driver = seleniumUtility.lounchBrowser(browser);
//	 	
//	}
//	
//	@BeforeMethod(alwaysRun = true)
//	void Login() {
//		System.out.println("Login");
//		
//	}
//	
//	 
//	 @AfterMethod(alwaysRun = true)
//		void logout() {
//			System.out.println("logout");
//		}
//		
//	 @AfterMethod(alwaysRun = true)
//		void tearDown() {
//			System.out.println("tearDown");
//			seleniumUtility.closeBrowser();
//		}
//		
//		
//		   
//		
//
//
//}
