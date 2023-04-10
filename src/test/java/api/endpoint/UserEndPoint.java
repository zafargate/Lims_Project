package api.endpoint;
import api.endpoint.Routs;


import static io.restassured.RestAssured.*;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
 


/**
 * Here We are creating CRUD Opration
 * create, read, update, delete
 * @author khanz
 *
 */
public class UserEndPoint {
	
	

/**
 * 
 * @param payload
 * @return
 */
	public static Response createUser(User payload)
	{
		Response response = given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)
		.when()
		  .post(RoutsContains.post_url);
		
		return response;
	}
	

/**
 * 
 * @param userName
 * @return
 */
	public static Response readUsers(String userName)
	{
		Response response = given()
		   .pathParam("username", userName)
		.when()
		  .get(RoutsContains.get_url);
		
		
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
		Response response = given()
				
				   .pathParam("username", userName)
				   .contentType(ContentType.JSON)
				   .accept(ContentType.JSON)
		           
		           .body(payload)
		.when()
		  .put(RoutsContains.update_url);
		
		return response;
	}
	
	 /**
	  * 
	  * @param userName
	  * @return
	  */
	public static Response deleteUser(String userName)
	{
		Response response = given()
		   .pathParam("username", userName)
		.when()
		  .delete(RoutsContains.delete_url);
 	
		return response;
	}
	
	 

}
