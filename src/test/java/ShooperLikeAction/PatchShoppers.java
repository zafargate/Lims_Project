package ShooperLikeAction;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PatchShoppers {
	
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

}
