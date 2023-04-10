package api.test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tyss.genricUtility.AnnotationClass.Report;
import com.tyss.genricUtility.ConfigerClass.MainClass;
import com.tyss.genricUtility.ExtarnalUtility.ExcellUtility;

import api.endpoint.UserEndPoint;
import api.payload.User;
import io.restassured.response.Response;

public class DataDrivenTest {
	public ExcellUtility excellUtility;
	
	
	@DataProvider(name = "Data")
	@BeforeClass
	public String[][] run() throws EncryptedDocumentException, IOException {
		excellUtility = new ExcellUtility("./testData/ApiDataProviderData.xlsx");
		String[][] data = excellUtility.getData("Sheet1");
		System.out.println(data[0][1]);
		return data;
	}
	
	@Report(author = "zafar", assign = { "Mohank" })
	@Test(dataProvider = "Data",groups={"regration","senity"})
	public void testPosture(String userID,String userName,String fname,String lname,String usermail,String pwd ,String ph )
	{
		User userPayload=new User();
		userPayload.setId(Integer.parseInt(userID));
		 userPayload.setUsername(userName);
		 userPayload.setFirstname(fname);
		 userPayload.setLastname(lname);
		 userPayload.setEmail(usermail);
		 userPayload.setPassword(pwd);
		 userPayload.setPhone(ph);	
		 
		 System.out.println(userPayload.getUsername());
		 
		 Response response = UserEndPoint.createUser(userPayload);
			response.then().log().all();
			Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Report(author = "zafar", assign = { "Mohan" })
	@Test(priority = 2, dataProvider = "Data")
	public void testDeleteUserName(String userID,String userName,String fname,String lname,String usermail,String pwd ,String ph)
	{
		
		System.out.println(userName);
    	 Response response = UserEndPoint.deleteUser("testuser3");
		 response.then().log().all();
		 Assert.assertEquals(response.getStatusCode(), 202);
	}
	
}
