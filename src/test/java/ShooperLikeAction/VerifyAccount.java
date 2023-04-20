package ShooperLikeAction;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class VerifyAccount {
	
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
