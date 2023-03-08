package org.domain.Genral.Clients;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tyss.genricUtility.Constants.FrameWorkConstatnt;
import com.tyss.genricUtility.Enum.ExcelEnumKey1;
import com.tyss.genricUtility.Enum.PropertyKey;
import com.tyss.genricUtility.ExtarnalUtility.ExcellUtility;
import com.tyss.genricUtility.ExtarnalUtility.PropertyUtility;
import com.tyss.genricUtility.Miscl.IntractionUtility;
import com.tyss.genricUtility.Miscl.JavaUtility;
import com.tyss.genricUtility.Miscl.VerificationUtility;
import com.tyss.genricUtility.WebAction.SeleniumUtility;
import com.tyss.genricUtility.WebAction.WaitUtility;

public class LoginApplication {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
	
	 PropertyUtility propUtiles=new PropertyUtility(FrameWorkConstatnt.TEST_PROPERTY_FILE_PATH);
	 ExcellUtility excellUtiles=new ExcellUtility(FrameWorkConstatnt.TEST_EXCELL_FILE_PATH);
	 JavaUtility javaUtility= new JavaUtility();
	 SeleniumUtility seleniumUtility=new SeleniumUtility();
	 VerificationUtility verificationUtility=new VerificationUtility();
	 WaitUtility waitUtility=new WaitUtility();
	 
	 
	 //Comman Data
	 String browser=propUtiles.getPropertyData(PropertyKey.BROWSER);
	 Long timeout=Long.parseLong(propUtiles.getPropertyData(PropertyKey.TIMEOUT));
	 String url=propUtiles.getPropertyData(PropertyKey.URL);
	 String username=propUtiles.getPropertyData(PropertyKey.USERNAME);
	 String password=propUtiles.getPropertyData(PropertyKey.PASSWORD);
	 String imagepath=propUtiles.getPropertyData(PropertyKey.IMAGEPATH);
	 //System.out.println(url);
	 
	 
	 //Test Deta
	 String sheetName=ExcelEnumKey1.ORGANIZATION.getSheetName();
	 String addClientForm="AddClientInformation";
	 String addNomineeForm="Client Information";
	 
	 int expLastName=javaUtility.getRandomNumber(100);
	 System.out.println(expLastName);
	 System.out.println(excellUtiles.getExcellData(sheetName, addClientForm, "ClientPassword"));
	 
	 WebDriver driver = seleniumUtility.lounchBrowser(browser);
	 IntractionUtility intractionUtility=new IntractionUtility(driver);
	 
	 //pre-setting for Browser
	 seleniumUtility.maximizeBrowser();
	 waitUtility.waitElementLoad(driver, timeout);
	 //Navigate the application
	 seleniumUtility.launchApplication(url);
	 
	 //LoginPage Verifation
	 verificationUtility.partialUrlVarify(driver, "Life_Insurance_Management_System");
	 //login to the app
	 driver.findElement(By.xpath("//input[@placeholder='username']")).sendKeys(username);
	 driver.findElement(By.xpath("(//input[@placeholder='password'])[1]")).sendKeys(password);
	 driver.findElement(By.xpath("//button[normalize-space()='login']")).click();
	 //Home page Verifation
	 verificationUtility.partialUrlVarify(driver, "Home Page is Open");
	 
	 

   }
}
