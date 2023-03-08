package com.tyss.genricUtility.ConfigerClass;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.tyss.genricUtility.ExtarnalUtility.ExcellUtility;
import com.tyss.genricUtility.ExtarnalUtility.PropertyUtility;
import com.tyss.genricUtility.ExtentsRerportUtility.Reportutility;
import com.tyss.genricUtility.Miscl.IntractionUtility;
import com.tyss.genricUtility.Miscl.JavaUtility;
import com.tyss.genricUtility.Miscl.VerificationUtility;
import com.tyss.genricUtility.ObjectRepository.CommonPage;
import com.tyss.genricUtility.ObjectRepository.LimsHomePagaeCommonEle;
import com.tyss.genricUtility.WebAction.JavaScriptUtility;
import com.tyss.genricUtility.WebAction.SeleniumUtility;
import com.tyss.genricUtility.WebAction.WaitUtility;

public class MainClasssDeclration {
  
	// Genral Utility Key
		public  PropertyUtility propUtiles;
		public  ExcellUtility excellUtiles;
		public  JavaUtility javaUtility;
		public  SeleniumUtility seleniumUtility;
		public  VerificationUtility verificationUtility;
		public  WaitUtility waitUtility;

		// commonData Key
		public  String browser;
		public  Long timeout;
		public  String url;
		public  String username;
		public  String password;
		public  String imagepath;

		// After browser Initiallization Key
		public  WebDriver driver;
		public  LimsHomePagaeCommonEle homePage;
		public  CommonPage commonPage;
		public  IntractionUtility intractionUtility;
		public Reportutility report;
		public ExtentTest test;
		public JavaScriptUtility javaScriptUtility;
}
