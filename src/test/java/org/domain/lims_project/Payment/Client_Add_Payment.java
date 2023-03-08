package org.domain.lims_project.Payment;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.tyss.genricUtility.AnnotationClass.Report;
import com.tyss.genricUtility.ConfigerClass.MainClass;
import com.tyss.genricUtility.Enum.CommonModuleName;
import com.tyss.genricUtility.Enum.ExcelEnumKey1;
import com.tyss.genricUtility.ObjectRepository.Client_Add_PaymentPage;
import com.tyss.genricUtility.Retry.RetryImplementation;
import com.tyss.genricUtility.Retry.SetTestParameter;

import java.io.IOException;
 
import java.util.Map;
@Listeners(SetTestParameter.class)
public class Client_Add_Payment extends MainClass {
    
	@Report(catagry={"regration","Minor"}, assign = { " " }, author = "zafar" )
	@Test(groups={"regration","Minor"} )
	 public void client_Add_Payment() throws EncryptedDocumentException, IOException {

		// Test Deta
		String sheetName1 = ExcelEnumKey1.ORGANIZATION.getSheetName();
		String addPayment =  ExcelEnumKey1.CLIENTADDPAYMENT.getSheetName();
		Map<String, String> nomiData = excellUtiles.getExcelData(sheetName1, addPayment);	
		commonPage.clickOnModule(CommonModuleName.PAYMENTS);
		Assert.assertTrue(seleniumUtility.getCurrentUrl().contains("payment"), "payment Page is not Open");
		Client_Add_PaymentPage clintddPaymentPage = new Client_Add_PaymentPage(driver);
		clintddPaymentPage.clickOnAddPAymentBtn();
		Assert.assertTrue(seleniumUtility.getTitle().contains("Add Payment"), "add payment Page is not Open");
		clintddPaymentPage.addPaymentKeyValue(nomiData); 
		Assert.assertTrue(seleniumUtility.getCurrentUrl().contains("insertPayment"), "Payment is   not insurted");
		commonPage.clickOnModule(CommonModuleName.PAYMENTS);
		Assert.assertTrue(seleniumUtility.getCurrentUrl().contains("payment"), "payment Page is not Open");
		boolean statusAddPayment = clintddPaymentPage.verifyAddPaymen(verificationUtility);
		Assert.assertFalse( statusAddPayment, "payment  is not added");
	}
}
