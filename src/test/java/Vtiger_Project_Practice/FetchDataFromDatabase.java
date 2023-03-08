package Vtiger_Project_Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;



public class FetchDataFromDatabase {
	public static void main(String[] args) throws SQLException {

		Connection connection=null;
		//Step1 :- create instance for driver --> register driver to jdbc
		try {	
			Driver dbDriver=new Driver();
			DriverManager.registerDriver( dbDriver);


			//Step2 : get connection ---> dbUrl, un, pw    :  
			connection=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");

			//step3  
			Statement statement = connection.createStatement();

			//step 4 -->	 Execute query

			ResultSet result=statement.executeQuery("select * from project");
			int size=result.getMetaData().getColumnCount(); 
			for (int i = 1; i <=size; i++) {
			System.out.println(result.getMetaData().getColumnName(i));
		    int result2=statement.executeUpdate("insert into project values('zafar01','Manoj','08/02/2023','selenium_zafar01','on going',03);");
				if(result2==1)
				{
					System.out.println("Data is Update sucessfully");
				}

			}

					 while(result.next())
					 {
			//			  
			//		     String manager=result.getString("created_by");
						 String projectName=result.getString("project_name");
						 String projectID=result.getString("project_id");
			//			 String status=result.getString("status");
			//			 String createdOn=result.getString("created_on");
			//			 String teamSize=result.getString("team_size");   
			//		 System.out.println(projectName+" "+manager+" "+projectID+" "+status+" "+createdOn+" "+teamSize);
			//		 
			      	 } 
					 
					 
					 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		finally
		{
			try {
				connection.close();
				System.out.println("Connection close");
			}
			catch(Exception e)
			{
				System.out.println("Cnnection close");
			}
		}
	}


}


