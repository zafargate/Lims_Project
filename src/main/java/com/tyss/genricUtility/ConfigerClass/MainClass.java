package com.tyss.genricUtility.ConfigerClass;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.tyss.genricUtility.Constants.FrameWorkConstatnt;
import com.tyss.genricUtility.Enum.PropertyKey;
import com.tyss.genricUtility.ExtarnalUtility.ExcellUtility;
import com.tyss.genricUtility.ExtarnalUtility.PropertyUtility;
import com.tyss.genricUtility.Listener.ExtentReportListener;
import com.tyss.genricUtility.Miscl.JavaUtility;
import com.tyss.genricUtility.Miscl.UtilityInstanceTransf;
import com.tyss.genricUtility.Miscl.VerificationUtility;
import com.tyss.genricUtility.ObjectRepository.CommonPage;
import com.tyss.genricUtility.ObjectRepository.LimsHomePagaeCommonEle;
import com.tyss.genricUtility.ObjectRepository.LimsLoginPage;
import com.tyss.genricUtility.WebAction.JavaScriptUtility;
import com.tyss.genricUtility.WebAction.SeleniumUtility;
import com.tyss.genricUtility.WebAction.WaitUtility;

/**
 * 
 * @author khanz
 *
 */
public class MainClass extends MainClasssDeclration {

	/**
	 * In This Method initiallization of all utitlity class and fetch all Common
	 * Data
	 * 
	 * @throws IOException
	 */
	@Parameters(value = "browser")
	@BeforeClass(alwaysRun = true)
	public void initiallizeUtility( String browser) throws IOException {
		// initiallization of All File
		report = ExtentReportListener.sReport;
		propUtiles = new PropertyUtility(FrameWorkConstatnt.TEST_PROPERTY_FILE_PATH);
		excellUtiles = new ExcellUtility(FrameWorkConstatnt.TEST_EXCELL_FILE_PATH);
		javaUtility = new JavaUtility();
		seleniumUtility = new SeleniumUtility();
		waitUtility = new WaitUtility();
		timeout = Long.parseLong(propUtiles.getPropertyData(PropertyKey.TIMEOUT));
		url = propUtiles.getPropertyData(PropertyKey.URL);
		username = propUtiles.getPropertyData(PropertyKey.USERNAME);
		password = propUtiles.getPropertyData(PropertyKey.PASSWORD);
		imagepath = propUtiles.getPropertyData(PropertyKey.IMAGEPATH);
		// Comman Data
		if (browser.isEmpty() || browser.equalsIgnoreCase("")) {
			browser = propUtiles.getPropertyData(PropertyKey.BROWSER);
			System.out.println(browser);
			report.info(UtilityInstanceTransf.getExtentTest(), browser + " is Lounch ");
			browser=System.getProperty("br");
			
		}
		this.browser = browser;		
		System.out.println("Launch Browser");
		driver = seleniumUtility.lounchBrowser(browser);
		seleniumUtility.launchApplication(url);
		Assert.assertEquals(seleniumUtility.getTitle(), "Login Page", "login PAge is Open Successfully");
		waitUtility.waitElementLoad(driver, timeout);
		javaScriptUtility = new JavaScriptUtility(driver);
	}

	/**
	 * Login the Application and Declration of all common page, home
	 * page,intractionUtility
	 * 
	 * @throws IOException
	 * @throws EncryptedDocumentException
	 */
	@BeforeMethod(alwaysRun = true)
	public void loginApp() throws EncryptedDocumentException, IOException {
		System.out.println("Login Application");
		LimsLoginPage loginPage = new LimsLoginPage(driver);
		commonPage = new CommonPage(driver);
		loginPage.loginAction(username, password);
		report.info(UtilityInstanceTransf.getExtentTest(), " Login Application Successfully");
		Assert.assertEquals(driver.getTitle(), "Home", "Home Page is Open Successfully");
		homePage = new LimsHomePagaeCommonEle(driver);

	}

	/**
	 * This Method used to Logout the Application
	 */
	@AfterMethod(alwaysRun = true)
	public void LogoutApp() {
		System.out.println("Logout AppLication");
		homePage.clickOnLogoutBtn();
		report.info(UtilityInstanceTransf.getExtentTest(), "Logout Application Successfully");
		Assert.assertEquals(driver.getTitle(), "Login Page", "logout is  Successfully");
	}

	/**
	 * This Method uset to Close the Browser
	 */
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		System.out.println("Close Browser");
		seleniumUtility.closeBrowser();
		report.info(UtilityInstanceTransf.getExtentTest(),
				propUtiles.getPropertyData(PropertyKey.BROWSER) + " is close");
	}

}
