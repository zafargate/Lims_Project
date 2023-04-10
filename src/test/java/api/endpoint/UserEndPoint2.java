package api.endpoint;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoint2 
{
	// method created for getting URLs from property file
	static ResourceBundle getURL(){
		ResourceBundle route=ResourceBundle.getBundle("routes");
		return route;
	}

/**
 * 
 * @param payload
 * @return
 */
	public static Response createUser(User payload)
	{
		String post_url = getURL().getString("post_url");
		
		Response response = given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)
		.when()
		  .post(post_url);
		
		return response;
	}
	

/**
 * 
 * @param userName
 * @return
 */
	public static Response readUsers(String userName)
	{
		String get_url = getURL().getString("get_url");
		Response response = given()
		   .pathParam("username", userName)
		.when()
		  .get(get_url);
		
		
		return response;
	}
	
	
	/**
	 * 
	 * @param userName
	 * @param payload
	 * @return
	 */
	public static Response updateParameter(String userName,User payload)
	{
		
		String update_url = getURL().getString("update_url");
		Response response = given()
				
				   .pathParam("username", userName)
				   .contentType(ContentType.JSON)
				   .accept(ContentType.JSON)
		           
		           .body(payload)
		.when()
		  .put(update_url);
		
		return response;
	}
	
	 /**
	  * 
	  * @param userName
	  * @return
	  */
	public static Response deleteUser(String userName)
	{
		String delete_url = getURL().getString("delete_url");
		
		Response response = given()
		   .pathParam("username", userName)
		.when()
		  .delete(RoutsContains.delete_url);
 	
		return response;
	}
	public static void main(String[] args) {
		System.out.println(getURL().getString("post_url"));
	}

}
