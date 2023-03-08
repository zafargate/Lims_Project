package Vtiger_Project_Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
 

public class DatabasePractice2 {
	
	public static void main(String[] args) throws SQLException {
		
		//Create connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root@%", "root");
		
		// Create statement
		Statement statement=connection.createStatement();
		
		
		// execute sql statement
		
		//String s="select*from student";
		String s="insert into student value (110,1234569,'zafar659','Benglore',69);";
		
		System.out.println("Program is executed");
		connection.close();
		
		
	}

}
