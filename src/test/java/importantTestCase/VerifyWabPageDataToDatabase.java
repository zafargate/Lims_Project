package importantTestCase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyWabPageDataToDatabase {
	static Connection connection = null;
	static WebDriver driver;

	public static void main(String[] args) throws SQLException, InterruptedException, IOException {
        
		Random rendom = new Random();
		int ran = rendom.nextInt(1000);
		
		
		
		FileInputStream fis= new FileInputStream("./src/test/resources/commonData/commonData.properties");
		Properties p=new Properties();
		p.load(fis);
		
		
		
		String broser=p.getProperty("browser");
		String timeout=p.getProperty("timeout");
		String url=p.getProperty("url");
		String connection_url=p.getProperty("connectionurl");
		String connection_un=p.getProperty("connectionun");
		String connection_pas=p.getProperty("connectionpas");
		String username=p.getProperty("username");
		String password=p.getProperty("password");
		String projectname=p.getProperty("projectname");
		String projectManager = "Manoj K";
		String query = "select * from project";
		String projectName = projectname+ran;
		
		fis.close();
		
		switch(broser)
		{
		case "chrome":{ WebDriverManager.chromedriver().setup();
		                   driver = new ChromeDriver(); 
		                  break;                                  }
		              
		case "firefox": { WebDriverManager.firefoxdriver().setup();
                          driver = new FirefoxDriver(); 
                          break;                           }     
		case "ie": {    WebDriverManager.iedriver().setup();
                               driver = new InternetExplorerDriver(); 
                               break;                            }
		
		}
		
//		WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver(); 
        

		WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(timeout));

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(timeout), TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys(password);
		driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();

		driver.findElement(By.xpath("//a[normalize-space()='Projects']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Create Project']")).click();

		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(projectName);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys(projectManager);

		WebElement list = driver.findElement(By.xpath("//form[@action='#']//select[@name='status']"));

		Select s = new Select(list);
		System.out.println(s.getAllSelectedOptions().size());
		s.selectByValue("Completed");

		driver.findElement(By.xpath("//input[@value='Add Project']")).click();

		 wait.until(ExpectedConditions.titleContains(driver.getTitle()));
		//Thread.sleep(4000);

		driver.findElement(By.xpath("//a[normalize-space()='Projects']")).click();

		List<WebElement> table_name_Data = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));

		for (WebElement data : table_name_Data) {
			String TableNameText = data.getText();
			if (TableNameText.equals(projectName)) {
				System.out.println("Project is created sucessfully");
				break;
			}
		}

//		try
//		{
			connection = DriverManager.getConnection(connection_url,connection_un,connection_pas);

			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			int size=result.getMetaData().getColumnCount();
			for (int i = 1; i <=size; i++) {
				System.out.println(result.getMetaData().getColumnName(i));
			}
//
//			while (result.next()) 
//			{
//
//				String manager = result.getString("created_by");
//				String projectName1 = result.getString("project_name");
//				System.out.println(manager+","+projectName1);
//
//				if (projectName1.equals(projectName)) {
//					System.out.println("data is verify on the database");
//				}
//				String projectID=result.getString("project_id");
//				String status=result.getString("status");
//				String createdOn=result.getString("created_on");
//				String teamSize=result.getString("team_size");   
//				System.out.println(projectName1+" "+manager+" "+projectID+" "+status+" "+createdOn+" "+teamSize);
//
//			}
//		}
//		
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
//
//		
//		
//		finally
//		{
//			try {
//				connection.close();
//				System.out.println("Connection close");
//			    } catch (Exception e) {
//				System.out.println("Cnnection close");
//			}
//		}
//		driver.close();
		
		}
}
