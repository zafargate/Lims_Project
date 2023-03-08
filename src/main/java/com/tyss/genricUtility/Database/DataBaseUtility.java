package com.tyss.genricUtility.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.mysql.cj.jdbc.Driver;
 

/**
 * this class contains constructore to initiallize DataBaseUtility (String
 * sbUrl,String dbUserName,String dbPass)
 * 
 * @author khanz
 *
 */
public class DataBaseUtility {

	Connection connection;
	Statement statement;

	/**
	 * this constructore initiallize registerDriver(d),getConnection(sbUrl,
	 * dbUserName, dbPass),createStatement()
	 * 
	 * @param sbUrl
	 * @param dbUserName
	 * @param dbPass
	 */
	public DataBaseUtility(String sbUrl, String dbUserName, String dbPass) {
		try {
			Driver d = new Driver();
			DriverManager.registerDriver(d);
			connection = DriverManager.getConnection(sbUrl, dbUserName, dbPass);
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method is return type is Arraylist and executequery is store in
	 * arrayList getDataFromDataBase(String query,String colName)
	 * 
	 * @param query
	 * @param colName
	 * @return
	 */
	public ArrayList<String> getDataFromDataBase(String query, String colName) {
		ArrayList<String> list = new ArrayList<>();
		try {
			ResultSet result = statement.executeQuery(query);
			while (result.next()) {
				list.add(result.getString(colName));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * This method is return type boolean and its getdataform database and comapre
	 * to the given para meter flag will work according to result
	 * 
	 * @param query
	 * @param colName
	 * @param expectedData
	 * @return
	 */
	public boolean validateofdateBase(String query, String colName, String expectedData) {
		ArrayList<String> list = getDataFromDataBase(query, colName);
		boolean flag = false;
		for (String achualData : list) {
			flag = true;
			break;
		}

		return flag;
	}

	/**
	 * This Method we can set the data into data base with the help of querry If the
	 * queryUpadated is successfully print msg into consol
	 * 
	 * @param query
	 */
	public void setDataIntoDataBase(String query) {
		try {
			int result = statement.executeUpdate(query);
			if (result == 1) {
				System.out.println("Data Updatye Sucessfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This method used to close the database connection and provide consol
	 * confirmation massage
	 */
	public void closeDBConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("While Closing the Database connection we get Connection");
		}
	}
    
	 
//	public static void main(String[] args) {
//		DataBaseUtility db = new DataBaseUtility("jdbc:mysql://localhost:3306/college", "root", "root");
//		String login_data = "select username,password from login  where application='actittime'";
//		ArrayList<String> data = db.getDataFromDataBase(login_data, "username");
//
//		for (int i = 0; i < data.size(); i++) {
//			System.out.println(data.get(i));
//		}
//		boolean x = db.validateofdateBase("select * from student", "id", "110");
//		System.out.println(x);
//
//		db.setDataIntoDataBase("insert into student value (110,1234569,'zafar659','Benglore',69);");
//		db.closeDBConnection();
//
//	}
}
