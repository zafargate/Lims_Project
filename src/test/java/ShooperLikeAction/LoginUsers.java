package ShooperLikeAction;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class LoginUsers {
	
	@Test
	void loginUsers() {
		
		baseURI="https://www.shoppersstack.com/shopping";
		
        JSONObject jb=new JSONObject();
        jb.put("email","er.zafargate@gmail.com");
        jb.put("password", "Zafar@123");
        jb.put("role", "SHOPPER");
		
	 	given()
	 	 .contentType(ContentType.JSON)
	 	 .body(jb)
		  .when().post("/users/login")
		 .then().assertThat().statusCode(200).log().all();
	 
	}

}
