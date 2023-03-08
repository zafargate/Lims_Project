//package importantTestCase;
//
//import java.io.IOException;
//import java.util.List;
//
//import org.apache.poi.EncryptedDocumentException;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//import com.mysql.cj.jdbc.Driver;
//import com.tyss.genricUtility.IntractionUtility;
//import com.tyss.genricUtility.JavaUtility;
//import com.tyss.genricUtility.VerificationUtility;
//
//import Contants.FrameWorkConstatnt;
//import Enum.ExcelEnumKey1;
//import Enum.PropertyKey;
//import ExternalUtility.ExcellUtility;
//import ExternalUtility.PropertyUtility;
//import WebAction.SeleniumUtility;
//import WebAction.WaitUtility;
//
//public class SelectOrganizationInListTest {
//	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//		 PropertyUtility propUtiles=new PropertyUtility(FrameWorkConstatnt.TEST_PROPERTY_FILE_PATH_VTIGER);
//		 ExcellUtility excellUtiles=new ExcellUtility(FrameWorkConstatnt.TEST_EXCELL_FILE_PATH);
//		 JavaUtility javaUtility= new JavaUtility();
//		 SeleniumUtility seleniumUtility=new SeleniumUtility();
//		 VerificationUtility verificationUtility=new VerificationUtility();
//		 
//		 //Comman Data
//		 String browser=propUtiles.getPropertyData(PropertyKey.BROWSER);
//		 Long timeout=Long.parseLong(propUtiles.getPropertyData(PropertyKey.TIMEOUT));
//		 String url=propUtiles.getPropertyData(PropertyKey.URL);
//		 String username=propUtiles.getPropertyData(PropertyKey.USERNAME);
//		 String password=propUtiles.getPropertyData(PropertyKey.PASSWORD);
//		 System.out.println(url);
//		 
//		 //Test Deta
//		 String sheetName=ExcelEnumKey1.CONTACTS.getSheetName();
//		 String testCaseName1="SelectOrganizationListTest";
//		 String testCaseName2="Client Information";
//		 
//		  
//		// System.out.println(expLastName);
//		// System.out.println(excellUtiles.getExcellData(sheetName, testCaseName1, "OrgName"));
//		 
//		 WebDriver driver = seleniumUtility.lounchBrowser(browser);
//		 IntractionUtility intractionUtility=new IntractionUtility(driver);
//		 WaitUtility waitUtility=new WaitUtility(driver,10);
//		 //pre-setting for Browser
//		 seleniumUtility.maximizeBrowser();
//		 waitUtility.waitElementLoad(driver, 10l);
//		 //Navigate the application
//		 seleniumUtility.launchApplication(url);
//		 
//		 String expLastName= excellUtiles.getExcellData(sheetName, testCaseName1, "OrgName")+javaUtility.getRandomNumber(100);
//		 String colName= excellUtiles.getExcellData(sheetName, testCaseName1, "ColumnName");
//		 
//		 driver.findElement(By.name("user_name")).sendKeys(username);
//	     driver.findElement(By.name("user_password")).sendKeys(password);
//	     driver.findElement(By.id("submitButton")).click();
//	     driver.findElement(By.linkText("Organizations")).click();
//	     driver.findElement(By.xpath("//img[contains(@title,'Open Calendar...')]")).click();
//	     driver.findElement(By.linkText("Organizations")).click();
//	     
//	    List< WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[1]/td/a"));
//	     
//	     int count=0;
//	     
//	     for (int i = 0; i < list.size(); i++) {
//			String actHadder = list.get(i).getText();
//			if(colName.equals(actHadder)) {
//			count=i+2;
//			break;
//		}
//	     
//		 
//	}
//          String strPage = driver.findElement(By.xpath("//a[normalize-space()='Create Mail Merge templates']")).getText();
//          
//          int pages = javaUtility.parseNumber(javaUtility.split(strPage, " ")[1]);
//          System.out.println(pages);
//          boolean flag=false;
//          for (int i = 0; i < pages; i++) {
//        	  List<WebElement> listOrg = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td["+count+"]"));
//        	  
//        	  for(WebElement webElement : listOrg) {
//        		  String actOrg = webElement.getText();
//        		  javaUtility.consolePrint(actOrg);
//        		  if(actOrg.equals(testCaseName1)) {
//        			  driver.findElement(By.xpath("//a[text()='"+testCaseName1+"']/../preceding-sibling::"));
//        			  flag=true;
//        			  break;
//        			  
//        		  }
//        		  
//        	  }
//        	  
//        	  if(flag) {
//        		  break;
//        	  }else {
//        		  driver.findElement(By.xpath("//a[@title='Next']")).click();
//        		  waitUtility.waitUntilUntilInvisible("//div[@id='status']");
//        	  }
//		}
//          waitUtility.pause(5000l);
//          seleniumUtility.closeBrowser();
//	}
//}
