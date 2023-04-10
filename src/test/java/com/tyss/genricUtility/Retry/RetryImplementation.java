package com.tyss.genricUtility.Retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementation implements IRetryAnalyzer {
	int count;
	@Override
	public boolean retry(ITestResult result) {
		 
		 int countNum=2;
		 if(count<countNum) {
			 count++;
			 return true;
		 }
		return false;
	}
	

}
