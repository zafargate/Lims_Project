package ShooperLikeAction;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class GetShoppers {

	
	
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
}
