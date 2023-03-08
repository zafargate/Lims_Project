package Vtiger_Project_Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JdbcPractice2 {
	
	public static void main(String[] args) throws SQLException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","root");
		
		Statement statement=connection.createStatement();
		String login_data="select username,password from login  where application='actittime'";
		 
		
		ResultSet rs=statement.executeQuery(login_data);
		while(rs.next())
		{
			String username=rs.getString("username");
			System.out.println(username);
			String password=rs.getString("password");
			System.out.println(password);
			
			driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.name("pwd")).sendKeys(password);
			driver.findElement(By.xpath("//a[@id='loginButton']")).click();
		}
		connection.close();
		System.out.println("programm is exucated");
		
	}

}
