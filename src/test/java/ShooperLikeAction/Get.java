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
	

	

	

	

	

	

	
	 
	


}

