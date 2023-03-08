package org.domain.Genral.Clients;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Client_EditClients
{
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException, IOException {
      

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
    	 String expTestCaseName="AddClientInformation";
    	 String expTestKey="ClientPassword";
    	 String map=excellUtiles.getExcellData(sheetName, expTestCaseName, expTestKey);
    	 System.out.println(map);
    	 
    	 String expLastName=map+"_"+javaUtility.getRandomNumber(100);
    	 System.out.println(expLastName);
    	 
    	 WebDriver driver = seleniumUtility.lounchBrowser(browser);
    	 IntractionUtility intractionUtility=new IntractionUtility(driver);
    	 
    	 //pre-setting for Browser
    	 seleniumUtility.maximizeBrowser();
    	 waitUtility.waitElementLoad(driver, 10l);
    	 //Navigate the application
    	 seleniumUtility.launchApplication(url);
    	 
    	 //login to the app
    	 driver.findElement(By.xpath("//input[@placeholder='username']")).sendKeys(username);
    	 driver.findElement(By.xpath("(//input[@placeholder='password'])[1]")).sendKeys(password);
    	 driver.findElement(By.xpath("//button[normalize-space()='login']")).click();
    	 driver.findElement(By.xpath("//a[normalize-space()='CLIENTS']")).click();
    	 waitUtility.waitElementLoad(driver, 10l);
    	 driver.findElement(By.xpath("//a[text()='Add Client']")).click();
    	 
    	 

  /*      // confirmation of homepage
//        String home_text = driver.findElement(By.xpath("//div[@class='inner-text']")).getText();
//        System.out.println(home_text);
//        if (home_text.contains("welcome")) {
//            System.out.println("Home Page is Open");
//        } else {
//            System.out.println("home Page Is Not Open");
//        }
        
        
        
        waitUtility.waitElementLoad(driver, timeout);
        //click on clients module
        driver.findElement(By.xpath("//a[normalize-space()='CLIENTS']")).click();


        // clients module confirmation page
        String client_page_url = driver.getCurrentUrl();

//        if (client_page_url.equals("http://rmgtestingserver/domain/Life_Insurance_Management_System/client.php")) {
//            System.out.println("client page is opened sucessfully");
//        }
//        else
//        {
//            System.out.println("clients page  not Open");
//        }

        driver.findElement(By.xpath("(//a[contains(text(),'Client Status')])[1]")).click();

//        String client_page_text=  driver.findElement(By.xpath("//h1[@class='page-head-line']")).getText();
//
//      if(client_page_text.equals("CLIENT'S STATUS"))
//      {
//          System.out.println("clients status page is opened sucessfully");
//      }
//      else
//      {
//          System.out.println("clients page is not opened ");
//
//      }

      driver.findElement(By.xpath("//a[text()='Edit Client']")).click();

//      String editclient_page_text=driver.findElement(By.xpath("//h1[@class='page-head-line']")).getText();
//
//      if (editclient_page_text.equals("CLIENTS INFORMATION"))
//      {
//          System.out.println("edit client page is opened sucessfully");
//      }
//      else
//      {
//          System.out.println("edit client page is not opened");
//      }

      File file= new File(imagepath);
       String absolute_path=file.getAbsolutePath();
       driver.findElement(By.xpath("//input[@name='fileToUpload']")).sendKeys(imagepath);
      // Thread.sleep(2000);
       waitUtility.waitElementLoad(driver, timeout);

      driver.findElement(By.xpath("//input[@placeholder='clients name..']"));
      WebElement name=driver.findElement(By.xpath("//input[@placeholder='clients name..']"));
      name.clear();
      name.sendKeys(excellUtiles.getExcellData(sheetName, expTestCaseName, "name"));

      WebElement gender=driver.findElement(By.xpath("(//input[@placeholder='clients gender..'])[1]"));
      gender.clear();
      gender.sendKeys(excellUtiles.getExcellData(sheetName, expTestCaseName, "Gender"));

      WebElement dob= driver.findElement(By.xpath("//input[@placeholder='clients Birth Date..']"));
      dob.clear();
      dob.sendKeys(excellUtiles.getExcellData(sheetName, expTestCaseName, "BirthDate"));

      WebElement phn=driver.findElement(By.xpath("//input[@placeholder='clients Phone..']"));
      phn.clear();
      phn.sendKeys(excellUtiles.getExcellData(sheetName, expTestCaseName, "Phone"));
      driver.findElement(By.xpath("//input[@name='submit']")).click();

      // confirmation massage is pending

        //click on clients module
        driver.findElement(By.xpath("//a[normalize-space()='CLIENTS']")).click();

//        List<WebElement> allLink = driver.findElements(By.xpath("//tbody/tr/td[2]"));
//        int count=allLink.size();
//        System.out.println(count);
//
//        for(int i=0; i<count;i++)
//        {
//            String text1=allLink.get(i).getText();
//
//            if(text1.equals("md zafar alam"))
//            {
//                System.out.println("edit client is sucessfully");
//                break;
//            }
//
//        }

        //confirmation of logout page
        String crrnt_url2=driver.getCurrentUrl();

        if (crrnt_url2.contains("Life_Insurance_"))
        {
            System.out.println("Logout is sucessfully");
        }
        else
        {
            System.out.println("Not Logout");
        }

        driver.close();  */


    }
}
