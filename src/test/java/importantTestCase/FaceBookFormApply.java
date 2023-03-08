package importantTestCase;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mysql.cj.jdbc.Driver;
import com.tyss.genricUtility.Constants.FrameWorkConstatnt;
import com.tyss.genricUtility.Enum.ExcelEnumKey;
import com.tyss.genricUtility.Enum.ExcelEnumKey1;
import com.tyss.genricUtility.Enum.PropertyKey;
import com.tyss.genricUtility.ExtarnalUtility.ExcellUtility;
import com.tyss.genricUtility.ExtarnalUtility.PropertyUtility;
import com.tyss.genricUtility.Miscl.JavaUtility;
import com.tyss.genricUtility.Miscl.VerificationUtility;
import com.tyss.genricUtility.ObjectRepository.FaceBookPage;
import com.tyss.genricUtility.WebAction.SeleniumUtility;
import com.tyss.genricUtility.WebAction.WaitUtility;

public class FaceBookFormApply {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		PropertyUtility propUtiles = new PropertyUtility(FrameWorkConstatnt.TEST_PROPERTY_FILE_PATH);
		ExcellUtility excellUtiles = new ExcellUtility(FrameWorkConstatnt.TEST_EXCELL_FILE_PATH);
		JavaUtility javaUtility = new JavaUtility();
		SeleniumUtility seleniumUtility = new SeleniumUtility();
		VerificationUtility verificationUtility = new VerificationUtility();
		WaitUtility waitUtility = new WaitUtility();

		// Comman Data
		String browser = propUtiles.getPropertyData(PropertyKey.BROWSER);
		Long timeout = Long.parseLong(propUtiles.getPropertyData(PropertyKey.TIMEOUT));
		String url = propUtiles.getPropertyData(PropertyKey.URL);
		String username = propUtiles.getPropertyData(PropertyKey.USERNAME);
		String password = propUtiles.getPropertyData(PropertyKey.PASSWORD);
		String imagepath = propUtiles.getPropertyData(PropertyKey.IMAGEPATH);
		// System.out.println(url);

		// Test Deta
		String sheetName = ExcelEnumKey.ADDFACEBOOK.getExcellSheet(); 
		System.out.println(sheetName);
		String tcName="AddFacebooForm";
		Map<String, String> map = excellUtiles.getExcelData(sheetName, tcName);
		System.out.println(map);
		
		WebDriver driver = seleniumUtility.lounchBrowser(browser);//Launch Brouser
		//seleniumUtility.launchApplication(url);
		seleniumUtility.maximizeBrowser();
		waitUtility.waitElementLoad(driver, timeout);
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.linkText("Create new account")).click();
		FaceBookPage fb=new FaceBookPage(driver);
		fb.addFaceBookKey(map);
		
//		
//		
//		fb.addNomineeSendKey(map);
		
		 
	}

}
