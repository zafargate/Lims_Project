package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.tyss.genricUtility.AnnotationClass.Report;

import api.endpoint.UserEndPoint;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {
	
	
	Faker faker;
	User userPayload;
	
	
	@BeforeClass
	public void setupData() 
	{
		 faker=new Faker();
		 userPayload=new User();
		 
		 userPayload.setId(faker.idNumber().hashCode());
		 userPayload.setUsername(faker.name().username());
		 userPayload.setFirstname(faker.name().firstName());
		 userPayload.setLastname(faker.name().lastName());
		 userPayload.setEmail(faker.internet().safeEmailAddress());
		 userPayload.setPassword(faker.internet().password());
		 userPayload.setPhone(faker.phoneNumber().cellPhone());	
		 
		 System.out.println(userPayload.getUsername());
	}
	
	@Report(author = "zafar", assign = { "Mohan" })
	@Test(priority=1)
	public void testPostUser() 
	{
		Response response = UserEndPoint.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Report(author = "zafar", assign = { "Mohan" })
	@Test(priority = 2)
	public void testGetUserByName()
	{
		System.out.println("2-->"+this.userPayload.getUsername());
		
		Response response = UserEndPoint.readUsers(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Report(author = "zafar", assign = { "Mohan" })
	@Test(priority = 3)
	public void testUpdateByUserName() 
	{
		System.out.println("3-->"+this.userPayload.getUsername());
		Response response = UserEndPoint.updateParameter(this.userPayload.getUsername(),userPayload);
		response.then().log().all().statusCode(200);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		//checking data after update
		 Response responseAfterUpdated = UserEndPoint.readUsers(this.userPayload.getUsername());
		 Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Report(author = "zafar", assign = { "Mohan" })
	@Test(priority = 4)
	public void testDeleteByName()
	{
		System.out.println("4-->"+this.userPayload.getUsername());
		Response response = UserEndPoint.deleteUser(this.userPayload.getUsername());
		 Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}
