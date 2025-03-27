package loggingDemo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class LoggingDemo {
	@Test
	void testLogs()
	{
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
		//print the complete response
		.log().all()
		
		//to print only response body
		.log().body()
		
		//to print only cookies from response
		.log().cookies()
		
		//to print only header from the response
		.log().headers();
	}
}
