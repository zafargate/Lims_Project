package org.domain.lims_project.Clients;

import java.io.IOException;
import java.util.Map;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert; 
import org.testng.annotations.Test;
import com.tyss.genricUtility.AnnotationClass.Report;
import com.tyss.genricUtility.ConfigerClass.MainClass;
import com.tyss.genricUtility.Enum.AllKeyClientEditClient;
import com.tyss.genricUtility.Enum.CommonModuleName;
import com.tyss.genricUtility.Miscl.UtilityInstanceTransf;
import com.tyss.genricUtility.ObjectRepository.ClientEditClientPage;
 
public class Client_EditClients extends MainClass
{
    
	@Report(author = "zafar", assign = { "Mohank" })
    @Test(groups={"regration","senity"})
    public void clientEditClient() throws EncryptedDocumentException, IOException {
    	 
    	//Test Deta
    	 String sheetName=AllKeyClientEditClient.CLIENTEDITCLIENTSSHEET.getSheetName();
    	 String expTestCaseName=AllKeyClientEditClient.CLIENTEDITCLIENTSTEST.getTcName();
    	 String nameOfClient=AllKeyClientEditClient.CLIENTEDITCLIENTSTESTDATA.getTcName();
    	 Map<String, String> map=excellUtiles.getExcelData(sheetName, expTestCaseName);
    	 report.info(UtilityInstanceTransf.getExtentTest(), map+"");
    	 String nameOfClient1=excellUtiles.getExcellData(sheetName, nameOfClient,"name");
    	 report.info(UtilityInstanceTransf.getExtentTest(), nameOfClient);
    	 
    	 commonPage.clickOnModule(CommonModuleName.CLIENTS); 
    	 Assert.assertTrue(seleniumUtility.getTitle().contains("Clients"), "Clients Page is not Open");
    	 ClientEditClientPage clientEditClientPage=new ClientEditClientPage(driver); 
    	 javaScriptUtility.scrolRight();
    	 clientEditClientPage.clickClientStatusNameBysWithEdit(nameOfClient1);
    	 Assert.assertTrue(seleniumUtility.getTitle().contains("Edit Client"), "Clients status is not edited is not ");
    	 clientEditClientPage.addTextIntoEditClient(map);
    	 commonPage.clickOnModule(CommonModuleName.CLIENTS); 
   	     Assert.assertTrue(seleniumUtility.getTitle().contains("Clients"), "Clients Page is not Open");
   	     boolean statusOfEditClient = clientEditClientPage.verifyEditClient(verificationUtility, nameOfClient);
   	     Assert.assertFalse( statusOfEditClient, "payment  is not added");
   	      
    }
}
