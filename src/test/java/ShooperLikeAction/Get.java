package ShooperLikeAction;

import java.io.File;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Get 
{
	
	@Test
	void postShoppers() {
		
		baseURI="https://www.shoppersstack.com/shopping";
//		File f1=new File("./src/test/resources/Data1.xml");
		File f2=new File("./src/test/resources/Data.json");
		
	 	given()
	 	.auth().basic("admin", "admin")
	 	 .contentType(ContentType.JSON)
	 	 .body(f2)
		   .when().post("/shoppers")
		 .then().assertThat().statusCode(201).log().all();
	 
	}
	
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
	

	
	@Test
	void getShoppers() {
		
		baseURI="https://www.shoppersstack.com/shopping";
        String token="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlci56YWZhcmdhdGVAZ21haWwuY29tIFNIT1BQRVIiLCJleHAiOjE2ODE5MzgxOTUsImlhdCI6MTY4MTkwMjE5NX0.-UV28RIzz0hkrDH84bVkGvwQfjga8O9x7fKK-EnUo_w";
		
	 	given()
	 	  .auth().oauth2(token)
	 	  .pathParam("shopperId",20303)
		   .when().get("/shoppers/{shopperId}")
		 .then().assertThat().statusCode(200).log().all();
	 
	}
	
	@Test
	void patchRequest() {
		
		baseURI="https://www.shoppersstack.com/shopping";
		File f2=new File("./src/test/resources/Data.json");
		 String token="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlci56YWZhcmdhdGVAZ21haWwuY29tIFNIT1BQRVIiLCJleHAiOjE2ODE5MzgxOTUsImlhdCI6MTY4MTkwMjE5NX0.-UV28RIzz0hkrDH84bVkGvwQfjga8O9x7fKK-EnUo_w";
			
	 	given()
	 	 .auth().oauth2(token)
	 	  .pathParam("shopperId",20303)
	 	 .contentType(ContentType.JSON)
	 	 .body(f2)
		   .when().patch("/shoppers/{shopperId}")
		 .then().assertThat().statusCode(200).log().all();
	 
	}
	
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
	
	 
	
	@Test
	void verifyAccount() {
		
		baseURI="https://www.shoppersstack.com/shopping";
        String token="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlci56YWZhcmdhdGVAZ21haWwuY29tIFNIT1BQRVIiLCJleHAiOjE2ODE5MzgxOTUsImlhdCI6MTY4MTkwMjE5NX0.-UV28RIzz0hkrDH84bVkGvwQfjga8O9x7fKK-EnUo_w";
	 	given()
	 	
	 	.header("password","Zafar@123")
	 	.auth().oauth2(token)
	 	.queryParam("token", "")
		   .when().post("/users/verify-account")
		 .then().assertThat().statusCode(200).log().all();
	 
	}

}

