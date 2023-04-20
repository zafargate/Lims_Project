package ShooperLikeAction;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ResetPassword {
	
	
	@Test
	void restPassword() {
		
		baseURI="https://www.shoppersstack.com/shopping";
		 JSONObject jb=new JSONObject();
		 String token="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlci56YWZhcmdhdGVAZ21haWwuY29tIFNIT1BQRVIiLCJleHAiOjE2ODE5MzgxOTUsImlhdCI6MTY4MTkwMjE5NX0.-UV28RIzz0hkrDH84bVkGvwQfjga8O9x7fKK-EnUo_w";
			jb.put("password","Zafar@1234");
	   given()
	 	     .auth().oauth2(token)	 	      
	 	     .contentType(ContentType.JSON)
	  .body(jb) 
		   .when().post("/users/reset-password")
	 .then().assertThat().statusCode(200).log().all();
	 
	}

}
