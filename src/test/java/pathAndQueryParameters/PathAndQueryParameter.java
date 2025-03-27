package pathAndQueryParameters;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class PathAndQueryParameter {
	
	//https://reqres.in/api/users?page=2&id=5
	
	@Test
	void testPathAndQueryParameter()
	{
		given()
			.pathParam("myPath","users") //path parameter
			.queryParam("page", 2)
			.queryParam("id", 5)
			
			//query parameters go along with the request
			//only path parameter we need to refer using curlly braces
		.when()
			.get("https://reqres.in/api/{myPath}")
		
		.then()
		.statusCode(200)
		.log().all();
	}

}
