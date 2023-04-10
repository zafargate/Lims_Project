package com.tyss.genricUtility.ConfigerClass;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
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
	 * 
	 */
 
	@BeforeClass()
	public void initiallizeUtility() throws IOException {
		// initiallization of All File
		//report = ExtentReportListener.sReport;
		propUtiles = new PropertyUtility(FrameWorkConstatnt.TEST_PROPERTY_FILE_PATH);
		excellUtiles = new ExcellUtility(FrameWorkConstatnt.TEST_EXCELL_FILE_PATH);
		javaUtility = new JavaUtility();
		seleniumUtility=new SeleniumUtility();
	 
	}
//
//	/**
//	 * This Method uset to Close the Browser
//	 * @throws IOException 
//	 */
//	@AfterClass()
//	public void tearDown() throws IOException {
//		excellUtiles.close();
//	}

}
