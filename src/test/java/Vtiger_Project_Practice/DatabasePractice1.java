package Vtiger_Project_Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;

import com.mysql.cj.jdbc.Driver;




public class DatabasePractice1 {


	static Connection connection=null;
	public static void main(String[] args)  {

		try {
			Driver dbDriver=new Driver();
			DriverManager.registerDriver(dbDriver);

			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","root");


			Statement statement = connection.createStatement();
			ResultSet result =statement.executeQuery("select * from student");
			System.out.println(result);
			while(result.next())
			{

				String name=result.getString("name");
				System.out.println(name);
				String id=result.getString("id");
				System.out.println(id);
				System.out.println("connection close");

			}


		}
		catch(Exception e)
		{

			System.out.println("Sql exception");
		}


		finally 
		{
			try {
				connection.close();	
			}

			catch(Exception e)
			{

			}
		}
	}
}