package Practice;

import java.io.IOException;
import java.util.Map;

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

public class FetchingUtilityFIle {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {

		PropertyUtility propUtiles = new PropertyUtility(FrameWorkConstatnt.TEST_PROPERTY_FILE_PATH);
		ExcellUtility excellUtiles = new ExcellUtility(FrameWorkConstatnt.TEST_EXCELL_FILE_PATH);
		JavaUtility javaUtility = new JavaUtility();
		SeleniumUtility seleniumUtility = new SeleniumUtility();
		VerificationUtility verificationUtility = new VerificationUtility();
		 

		// Comman Data
		String browser = propUtiles.getPropertyData(PropertyKey.BROWSER);
		Long timeout = Long.parseLong(propUtiles.getPropertyData(PropertyKey.TIMEOUT));
		String url = propUtiles.getPropertyData(PropertyKey.URL);
		String username = propUtiles.getPropertyData(PropertyKey.USERNAME);
		String password = propUtiles.getPropertyData(PropertyKey.PASSWORD);
		// System.out.println(url);

		// Test Deta
		String sheetName = ExcelEnumKey1.ORGANIZATION.getSheetName();
		String expTestCaseName = "AddClientInformation";
		String expTestKey = "ClientPassword";
		String map = excellUtiles.getExcellData(sheetName, expTestCaseName, expTestKey);
		System.out.println(map);

		String expLastName = map + "_" + javaUtility.getRandomNumber(100);
		System.out.println(expLastName);

		WebDriver driver = seleniumUtility.lounchBrowser(browser);
		IntractionUtility intractionUtility = new IntractionUtility(driver);

		// pre-setting for Browser
		seleniumUtility.maximizeBrowser();
		//waitUtility.waitElementLoad(driver, 10l);
		// Navigate the application
		seleniumUtility.launchApplication(url);

		// login to the app
		driver.findElement(By.xpath("//input[@placeholder='username']")).sendKeys(username);
		driver.findElement(By.xpath("(//input[@placeholder='password'])[1]")).sendKeys(password);
		driver.findElement(By.xpath("//button[normalize-space()='login']")).click();

		// Logout to Application
		driver.findElement(By.xpath("//a[@class='logout']")).click();

		// close the browser
		seleniumUtility.closeBrowser();

	}
}
