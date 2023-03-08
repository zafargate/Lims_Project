package TestNgPrectice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tyss.genricUtility.Constants.FrameWorkConstatnt;
import com.tyss.genricUtility.ExtarnalUtility.ExcellUtility;
import com.tyss.genricUtility.ObjectRepository.LimsLoginPage;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class DataProviderDemo {
	
	static WebDriver driver;
	
	static {
		ChromeDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("http://rmgtestingserver/domain/Life_Insurance_Management_System/index.php");
	}
	
	@Test(dataProvider ="List")
	 void test1(String s1,String s2,String s3 ) throws InterruptedException {
		System.out.println(s1 );
		System.out.println(s2);
		System.out.println(s3);
		 
		 LimsLoginPage login=new LimsLoginPage(driver);
		 Thread.sleep(2000);
		 login.loginAction(s1, s2);
		if(driver.getCurrentUrl().contains("home")) {
			 driver.close();
		}
		
	}	
	
	@DataProvider( name="2dArray")
	public  String[][] data() {
		 String name[][]=  {{"test1", "test2","test3"},
				             {"un1","pw1","name"},
				             {"un2","pw2","name"},
				             {"un3","pw3","--"}};
		 return name;
	}
	@DataProvider( name="List")
	public  ListIterator data2() {
		  List al=new ArrayList();
		  al.add("Password");
		  al.add("password");
		  al.add(555);
		  al.add(666);
		  
		 ListIterator it = al.listIterator();
		 return  it;
	}
	
	@DataProvider( name="Excell")
	public  String[][] excellData() throws EncryptedDocumentException, IOException {
		
		ExcellUtility excell=new ExcellUtility(FrameWorkConstatnt.TEST_EXCELL_FILE_PATH);
	     return	excell.getData("AllPasswordData");
		 
	}
	
}		
	

 
