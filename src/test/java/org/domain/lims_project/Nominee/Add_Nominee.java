package org.domain.lims_project.Nominee;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.genricUtility.AnnotationClass.Report;
import com.tyss.genricUtility.ConfigerClass.MainClass;
import com.tyss.genricUtility.Enum.CommonModuleName;
import com.tyss.genricUtility.Enum.ExcelEnumKey1;
import com.tyss.genricUtility.Miscl.UtilityInstanceTransf;
import com.tyss.genricUtility.ObjectRepository.AddNomineePage;
import com.tyss.genricUtility.Retry.RetryImplementation;

import java.io.IOException;
import java.util.Map;

public class Add_Nominee extends MainClass {
	
	@Report(author = "zafar", assign = { " " })
	@Test(groups="senity")
	public void addNominee() throws IOException {
		// Test Deta
		String sheetName = ExcelEnumKey1.ORGANIZATION.getSheetName();
		String addNomineeForm =ExcelEnumKey1.ADDNOMINEE.getTcName();
		Map<String, String> nomiData = excellUtiles.getExcelData(sheetName, addNomineeForm); 
		AddNomineePage addNominee1 = new AddNomineePage(driver);
		report.info(UtilityInstanceTransf.getExtentTest(), nomiData+"");
		
		commonPage.clickOnModule(CommonModuleName.NOMINEE);
		Assert.assertTrue(seleniumUtility.getCurrentUrl().contains("nominee"), "Nominee Page not Open");
		addNominee1.clickOnAddNominee();
		Assert.assertTrue(seleniumUtility.getCurrentUrl().contains("addNominee"), "add Nominee Page is not Open");
		addNominee1.addNomineeSendKey(nomiData);
		commonPage.clickOnModule(CommonModuleName.NOMINEE); 
		Assert.assertTrue(seleniumUtility.getCurrentUrl().contains("nominee"), "Nominee Page not Open");
		boolean statusOfNominee = addNominee1.verifyNominee(verificationUtility);
		Assert.assertFalse( statusOfNominee, "Nominee is not added");
	}
}
