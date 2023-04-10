package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.tyss.genricUtility.AnnotationClass.Report;

import api.endpoint.UserEndPoint;
import api.endpoint.UserEndPoint2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest2 
{
	
	Faker faker;
	User userPayload;

	public Logger logger;

	@BeforeClass
	public void setup() {
		faker = new Faker();
		userPayload = new User();

		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().cellPhone());

		System.out.println(userPayload.getUsername());

		// Logger
		logger = LogManager.getLogger(this.getClass());
		logger.debug("debugging.......");

	}

	@Report(author = "zafar", assign = { "Mohan" })
	@Test(priority = 1)
	public void testPostUser() {
		logger.info("********** Creating user ********");
		Response response = UserEndPoint2.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("********** User Info Is Display ********");
	}

	@Report(author = "zafar", assign = { "Mohan" })
	@Test(priority = 2)
	public void testGetUserByName() {
		logger.info("********** Getting user ********");

		System.out.println("2-->" + this.userPayload.getUsername());
		Response response = UserEndPoint2.readUsers(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);

		logger.info("********** Updating is Gated ********");

	}

	@Report(author = "zafar", assign = { "Mohan" })
	@Test(priority = 3)
	public void testUpdateByUserName() {
		logger.info("********** Updating User ********");

		System.out.println("3-->" + this.userPayload.getUsername());
		Response response = UserEndPoint2.updateParameter(this.userPayload.getUsername(), userPayload);
		response.then().log().all().statusCode(200);

		Assert.assertEquals(response.getStatusCode(), 200);
		// checking data after update
		Response responseAfterUpdated = UserEndPoint.readUsers(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("********** User Updated ********");
	}

	@Report(author = "zafar", assign = { "Mohan" })
	@Test(priority = 4)
	public void testDeleteByName() {
		logger.info("********** Deleting User ********");

		System.out.println("4-->" + this.userPayload.getUsername());
		Response response = UserEndPoint2.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);

		logger.info("********** User is Deleted ********");
	}


}
