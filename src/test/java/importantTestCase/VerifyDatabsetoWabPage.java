package importantTestCase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;
import com.tyss.genricUtility.Constants.FrameWorkConstatnt;
import com.tyss.genricUtility.Database.DataBaseUtility;
import com.tyss.genricUtility.Enum.ExcelEnumKey1;
import com.tyss.genricUtility.Enum.JDBCPropertyKey;
import com.tyss.genricUtility.Enum.PropertyKey;
import com.tyss.genricUtility.ExtarnalUtility.ExcellUtility;
import com.tyss.genricUtility.ExtarnalUtility.PropertyUtility;
import com.tyss.genricUtility.Miscl.JavaUtility;
import com.tyss.genricUtility.Miscl.VerificationUtility;
import com.tyss.genricUtility.ObjectRepository.JDBCLoginPage;
import com.tyss.genricUtility.WebAction.SeleniumUtility;
import com.tyss.genricUtility.WebAction.WaitUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyDatabsetoWabPage {

	public static void main(String[] args) throws SQLException, IOException {
		
		
		
		 PropertyUtility propUtiles=new PropertyUtility(FrameWorkConstatnt.TEST_PROPERTY_FILE_PATH_JDBC);
    	 ExcellUtility excellUtiles=new ExcellUtility(FrameWorkConstatnt.TEST_EXCELL_FILE_PATH);
    	 JavaUtility javaUtility= new JavaUtility();
    	 SeleniumUtility seleniumUtility=new SeleniumUtility();
    	 VerificationUtility verificationUtility=new VerificationUtility();
    	 WaitUtility waitUtility=new WaitUtility();
    	 
    	 String browser=propUtiles.getPropertyDataJDBC(JDBCPropertyKey.BROWSER);
    	 Long timeout=Long.parseLong(propUtiles.getPropertyDataJDBC(JDBCPropertyKey.TIMEOUT));
    	 String url=propUtiles.getPropertyDataJDBC(JDBCPropertyKey.URL);
    	 String connection_url=propUtiles.getPropertyDataJDBC(JDBCPropertyKey.CONNECTIONURL);
    	 String connection_un=propUtiles.getPropertyDataJDBC(JDBCPropertyKey.CONNECTIONUN);
    	 String connection_pas=propUtiles.getPropertyDataJDBC(JDBCPropertyKey.CONNECTIONPAS);
    	 String username=propUtiles.getPropertyDataJDBC(JDBCPropertyKey.USERNAME);
    	 String password=propUtiles.getPropertyDataJDBC(JDBCPropertyKey.PASSWORD);
    	 String imagepath=propUtiles.getPropertyDataJDBC(JDBCPropertyKey.IMAGEPATH);
    	 String sheetName=ExcelEnumKey1.JDBC.getSheetName();
    	 String jdbcTc="JDBC DATA";
    	 Map<String, String> map = excellUtiles.getExcelData(sheetName,jdbcTc );
    	 
    	 int ran=javaUtility.getRandomNumber(1000);
    	 String ProjectName=   map.get("ProjectName")+ran;
    	 String projectID =  map.get("ProjectId")+ran;
    	 String projectManager = map.get("ProjectManager")+ran;
		 
		 String query = "select * from project";
		 String query2 = "insert into project values('" + projectID
					+ "','Manoj','08/02/2023','selenium_zafar01','on going',03);";
		
		 
		 
		 
		 
		 
		 WebDriver driver=seleniumUtility.lounchBrowser(browser);
		 seleniumUtility.maximizeBrowser();
		 waitUtility.waitElementLoad(driver, timeout);
		 seleniumUtility.launchApplication(url);
		 
		 JDBCLoginPage jdbcLoginPage=new JDBCLoginPage(driver);
		 jdbcLoginPage.loginOfJDBC(username, password);
		 jdbcLoginPage.createProject(ProjectName,projectManager,"On Going");
		 boolean status=jdbcLoginPage.verifyProject(verificationUtility,ProjectName);
		 if(status==true) {
			 javaUtility.consolePrint("Project is created");
		 }
		 
		 else {
			 javaUtility.consolePrint("Project is Not Created");
		 }
		 
		 DataBaseUtility dataBaseUtility=new DataBaseUtility(connection_url, connection_un, connection_pas);
		 ArrayList<String> list = dataBaseUtility.getDataFromDataBase(query,"project_id"  );
		 System.out.println(list);
		 for(String l:list) {
			 if(projectID.equalsIgnoreCase(l)) {
				 System.out.println("verify");
				 break;
			 }
			 
		 }
		 dataBaseUtility.closeDBConnection();
		 seleniumUtility.closeBrowser();
		 
//		Connection connection = null;
//		// Step1 :- create instance for driver --> register driver to jdbc
//		try {
//			Driver dbDriver = new Driver();
//			DriverManager.registerDriver(dbDriver);
//
//			// Step2 : get connection ---> dbUrl, un, pw :
//			connection = DriverManager.getConnection(connection_url,connection_un,connection_pas);
//
//			// step3
//			 
//			 
//			setDataIntoDataBase("select * from project");
//			ResultSet result = statement.executeQuery("select * from project");
//			int size = result.getMetaData().getColumnCount();
//			for (int i = 1; i <= size; i++) {
//				System.out.println(result.getMetaData().getColumnName(i));
//
//			}
//
//			while (result.next()) {
//				//
//				// String manager=result.getString("created_by");
//				// String projectName=result.getString("project_name");
//				   projectID = result.getString("project_id");
//				// String status=result.getString("status");
//				// String createdOn=result.getString("created_on");
//				// String teamSize=result.getString("team_size");
//				// System.out.println(projectName+" "+manager+" "+projectID+" "+status+"
//				// "+createdOn+" "+teamSize);
//				//
//			}
//
//			driver.get(url);
//			driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys(username);
//			driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys(password);
//			driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
//
//			driver.findElement(By.xpath("//a[normalize-space()='Projects']")).click();
//			List<WebElement> table_ID_Data = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
//
//			for (WebElement data : table_ID_Data) {
//				String TableNameText = data.getText();
//				if (TableNameText.equals(projectID)) {
//					System.out.println("Project is created sucessfully");
//					break;
//				}
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		finally {
//			try {
//				connection.close();
//				System.out.println("Connection close");
//			} catch (Exception e) {
//				System.out.println("Cnnection close");
//			}
//		}
//		driver.close();
	}

}
