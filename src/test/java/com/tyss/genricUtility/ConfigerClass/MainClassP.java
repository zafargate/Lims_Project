//package com.tyss.genricUtility.ConfigerClass;
//
//import java.io.IOException;
//
//import org.apache.poi.EncryptedDocumentException;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Optional;
//import org.testng.annotations.Parameters;
//import com.tyss.genricUtility.Constants.FrameWorkConstatnt;
//import com.tyss.genricUtility.Enum.PropertyKey;
//import com.tyss.genricUtility.ExtarnalUtility.ExcellUtility;
//import com.tyss.genricUtility.ExtarnalUtility.PropertyUtility;
//import com.tyss.genricUtility.Miscl.IntractionUtility;
//import com.tyss.genricUtility.Miscl.JavaUtility;
//import com.tyss.genricUtility.Miscl.VerificationUtility;
//import com.tyss.genricUtility.ObjectRepository.CommonPage;
//import com.tyss.genricUtility.ObjectRepository.LimsHomePagaeCommonEle;
//import com.tyss.genricUtility.ObjectRepository.LimsLoginPage;
//import com.tyss.genricUtility.WebAction.JavaScriptUtility;
//import com.tyss.genricUtility.WebAction.SeleniumUtility;
//import com.tyss.genricUtility.WebAction.WaitUtility;
//
//public class MainClassP extends MainClasssDeclration {
//	
//	 
//		@Parameters(value="browser")
//		@BeforeClass(alwaysRun = true)
//		public void initiallizeUtility(@Optional String browser) throws IOException {
//			// initiallization of All File
//			propUtiles = new PropertyUtility(FrameWorkConstatnt.TEST_PROPERTY_FILE_PATH);
//			excellUtiles = new ExcellUtility(FrameWorkConstatnt.TEST_EXCELL_FILE_PATH);
//		  
//			javaUtility = new JavaUtility();
//			
//			verificationUtility = new VerificationUtility();
//			waitUtility = new WaitUtility();
//			// Comman Data 
//			if(browser.isBlank()|| browser.isEmpty()|| browser.equalsIgnoreCase("")) {
//		     browser = propUtiles.getPropertyData(PropertyKey.BROWSER);
//				System.out.println(browser);
//			}
//			this.browser=browser;
//			timeout = Long.parseLong(propUtiles.getPropertyData(PropertyKey.TIMEOUT));
//			url = propUtiles.getPropertyData(PropertyKey.URL);
//			username = propUtiles.getPropertyData(PropertyKey.USERNAME);
//			password = propUtiles.getPropertyData(PropertyKey.PASSWORD);
//			imagepath = propUtiles.getPropertyData(PropertyKey.IMAGEPATH);
//			javaScriptUtility=new JavaScriptUtility(driver);
//		 
//		
//			System.out.println("Launch Browser");
//			driver = seleniumUtility.lounchBrowser(browser);
//			seleniumUtility = new SeleniumUtility();
//			seleniumUtility.launchApplication(url);
//			Assert.assertEquals(driver.getTitle(), "Login Page", "login PAge is Open Successfully");
//			waitUtility.waitElementLoad(driver, timeout);
//		}
//
//		/**
//		 * Login the Application and Declration of all common page, home
//		 * page,intractionUtility
//		 * @throws IOException 
//		 * @throws EncryptedDocumentException 
//		 */
//		//@BeforeMethod(groups={"regration","senity"})
//		@BeforeMethod(alwaysRun = true)
//		public void loginApp() throws EncryptedDocumentException, IOException {
//		
//			System.out.println("Login Application");
//			LimsLoginPage loginPage = new LimsLoginPage(driver);
//			commonPage = new CommonPage(driver);
//			loginPage.loginAction(username, password);
//			Assert.assertEquals(driver.getTitle(), "Home", "Home Page is Open Successfully");
//			homePage = new LimsHomePagaeCommonEle(driver);
//			intractionUtility = new IntractionUtility(driver);
//		}
//
//		/**
//		 * 
//		 */
//		//@AfterMethod(groups={"regration","senity"})
//		@AfterMethod(alwaysRun = true)
//		public void LogoutApp() {
//			System.out.println("Logout AppLication");
//			homePage.clickOnLogoutBtn();
//			Assert.assertEquals(driver.getTitle(), "Login Page", "logout is  Successfully");
//		}
//
//		/**
//		 * 
//		 */
//		//@AfterClass (groups={"regration","senity"})
//		@AfterClass(alwaysRun = true)
//		public void tearDown() {
//			System.out.println("Close Browser");
//			seleniumUtility.closeBrowser();
//	    	}
//
//		 
//		}
//	
//
