package Practice;

import org.json.JSONObject;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.Assert;
import  org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoint.RoutsContains;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserDummy {
	
	int id;
	String username;
	String firstname;
	String lastname;
	String email;
	String password;
	String phone;
	int userStatus=0;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}


@Test
public void  createUser()
{
	 
	Faker faker = new Faker();
	UserDummy userPayload=new UserDummy();

	userPayload.setId(faker.idNumber().hashCode());
	userPayload.setUsername(faker.name().username());
	userPayload.setFirstname(faker.name().firstName());
	userPayload.setLastname(faker.name().lastName());
	userPayload.setEmail(faker.internet().safeEmailAddress());
	userPayload.setPassword(faker.internet().password());
	userPayload.setPhone(faker.phoneNumber().cellPhone());
	 
	System.out.println(userPayload);
	
	Response response = given()
			
	   .pathParam("username","caleb.adams" )
	.when()
	  .get("https://petstore.swagger.io/v2/user/{username}");
	 
	    response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
 
	 
 
}

}
