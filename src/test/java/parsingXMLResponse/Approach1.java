package parsingXMLResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class Approach1 {

	//approach 1 for static data 
	@Test
	void testXMLResponse()
	{
		given()
		
		.when().get("https://mocktarget.apigee.net/xml ")
		
		.then()
			.statusCode(200)
			.header("Content-Type", "application/xml; charset=utf-8")
			.body("root.firstName",equalTo("John")).log().all();
	}
	
}
