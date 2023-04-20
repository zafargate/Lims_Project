package ShooperLikeAction;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ForgotPassword {
	
	
	@Test
	void forgotPassword() {
		
		baseURI="https://www.shoppersstack.com/shopping";
		 	 
	   Response res=given()
	        .header("email","er.zafargate7@gmail.com","role","SHOPPER")
		   .when().post("/users/forgot-password");
	  String token = res.jsonPath().get("data.token");
	   res.then().assertThat().statusCode(200).log().all();
	  System.out.println(token);
	}

}
