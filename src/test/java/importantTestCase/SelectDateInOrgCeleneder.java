package importantTestCase;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.tyss.genricUtility.ConfigerClass.MainClass;
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

public class SelectDateInOrgCeleneder extends MainClass {

	 @Test
	   public void electDateInOrgCeleneder() throws EncryptedDocumentException, IOException {
		 excellUtiles = new ExcellUtility(FrameWorkConstatnt.TEST_EXCELL_FILE_PATH);
		  propUtiles = new PropertyUtility(FrameWorkConstatnt.TEST_PROPERTY_FILE_PATH_VTIGER);
	  
		// Comman Data
		String browser = propUtiles.getPropertyData(PropertyKey.BROWSER);
		Long timeout = Long.parseLong(propUtiles.getPropertyData(PropertyKey.TIMEOUT));
		String url = propUtiles.getPropertyData(PropertyKey.URL);
		String username = propUtiles.getPropertyData(PropertyKey.USERNAME);
		String password = propUtiles.getPropertyData(PropertyKey.PASSWORD);
		System.out.println(url);

		// Test Deta
		String sheetName = ExcelEnumKey1.CELENDERTEST.getSheetName();
		String testCaseName="SelectDateInOrgCeleneder";
		Map<String, String> map = excellUtiles.getExcelData(sheetName, testCaseName);
		System.out.println(map);
		 
		String reqMont = map.get("ReqMonth");
		String reqYear = map.get("ReqYear");
		String reqDay = map.get("ReqDay");
		//System.out.println(reqMont+reqDay);
      	// pre-setting for Browser
 		seleniumUtility.maximizeBrowser();
		waitUtility.waitElementLoad(driver, timeout);
		// Navigate the application
		seleniumUtility.launchApplication(url);

		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[contains(@title,'Open Calendar...')]")).click();

		// fetch current month and year
		WebElement ele = driver.findElement(By.xpath("//td[@class='calHdr']/a/b"));
		// fetch current month and tyear
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(ele));
		String currMothYear = ele.getText();
		System.out.println(currMothYear);
		// Store Month and year Saprate
		String currMonth = currMothYear.split(" ")[0];
		String currYear = currMothYear.split(" ")[1];
		System.out.println(currMonth + currYear);

		// jaunary month ---->MMMM 01------>,mm,yyyy,DD,sss,MMM

		int reqMontNum = javaUtility.getMonnthNumber(reqMont, "MMMM");
		int reqYearNum = javaUtility.parseNumber(reqYear);
		 System.out.println(reqMontNum);
		int curMonthNum = javaUtility.getMonnthNumber(currMonth, "MMMM");
		int curYearNum = javaUtility.parseNumber(currYear);

		while (reqMontNum > curMonthNum || reqYearNum > curYearNum) {
			driver.findElement(By.xpath("//img[@src='themes/images/small_right.gif']")).click();
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//td[@class='calHdr']/a/b"))));
			currMothYear = driver.findElement(By.xpath("//td[@class='calHdr']/a/b")).getText();
			System.out.println(currMothYear);
			currMonth = javaUtility.split(currMothYear, " ")[0];
			currYear = javaUtility.split(currMothYear, " ")[1];
			curMonthNum = javaUtility.getMonnthNumber(currMonth, "MMMM");
			curYearNum = javaUtility.parseNumber(currYear);
		}

		while (reqMontNum < curMonthNum || reqYearNum < curYearNum) {
			driver.findElement(By.xpath("//img[@src='themes/images/small_left.gif']")).click();
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//td[@class='calHdr']/a/b"))));
			currMothYear = driver.findElement(By.xpath("//td[@class='calHdr']/a/b")).getText();
			System.out.println(currMothYear);
			currMonth = javaUtility.split(currMothYear, " ")[0];
			currYear = javaUtility.split(currMothYear, " ")[1];
			curMonthNum = javaUtility.getMonnthNumber(currMonth, "MMMM");
			curYearNum = javaUtility.parseNumber(currYear);
		}

		// click date
		driver.findElement(By.xpath("//a[contains(@href,'view=day') and text()='" + reqDay + "']")).click();
		waitUtility.pause(5000l);
		seleniumUtility.closeBrowser();

	}

}
