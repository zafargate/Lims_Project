package org.domain.lims_project.Clients;

import java.io.IOException;
import java.util.Map;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.genricUtility.AnnotationClass.Report;
import com.tyss.genricUtility.ConfigerClass.MainClass;
import com.tyss.genricUtility.Enum.CommonModuleName;
import com.tyss.genricUtility.Enum.ExcelEnumKey1;
import com.tyss.genricUtility.Miscl.UtilityInstanceTransf;
import com.tyss.genricUtility.ObjectRepository.AddClientsPage;
import com.tyss.genricUtility.Retry.RetryImplementation;

public class Clients_Add_Client extends MainClass {
	
	@Report(author = "zafar", assign = { " " })
	@Test(groups="senity",retryAnalyzer = RetryImplementation.class)
	public void clients_Add_Client() {
	
		// Test Deta
		String sheetName = ExcelEnumKey1.ORGANIZATION.getSheetName();
		String addClientForm = "Client_Add_ClientInfo";
		String addNomineeForm = "Client_Add_NomineeInfo";
		Map<String, String> addClientData = excellUtiles.getExcelData(sheetName, addClientForm);
		Map<String, String> AddNomineeData = excellUtiles.getExcelData(sheetName, addNomineeForm);
		report.info(UtilityInstanceTransf.getExtentTest(), AddNomineeData+"");
		commonPage.clickOnModule(CommonModuleName.CLIENTS);
		Assert.assertEquals(driver.getTitle(), "Clients", "Clients page  is Open Successfully");
		AddClientsPage addClientsPage = new AddClientsPage(driver);
		addClientsPage.clickOnAddClientsBtn();
		Assert.assertEquals(driver.getTitle(), "Add Client", "Add client Page is Open Successfully");
		addClientsPage.addClientSendKey(addClientData);
		addClientsPage.addNomineeSendKey(AddNomineeData);
		Assert.assertEquals(seleniumUtility.getTitle(), "Add Client", "insertClient   is sucessfully");
		commonPage.clickOnModule(CommonModuleName.CLIENTS);
		Assert.assertEquals(driver.getTitle(), "Clients", "Clients page  is Open Successfully");
		boolean statusAddClient = addClientsPage.verifyAddClients(verificationUtility);
		Assert.assertFalse(statusAddClient, "Client is Add Sucessfully");
	}
}
