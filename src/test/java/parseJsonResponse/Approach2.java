package parseJsonResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Approach2 {

	@Test(priority = 1)
	void testJsonResponse() {
		// approach 2 for small json responses with capturing the response

		Response res = given().contentType(ContentType.JSON)

				.when().get("https://reqres.in/api/users?page=2");

		Assert.assertEquals(res.getStatusCode(), 200); // validation 1
		Assert.assertEquals(res.getHeader("Content-Type"), "application/json; charset=utf-8");// validation 2
		
		String lastName = res.jsonPath().get("data[5].last_name").toString();
		Assert.assertEquals(lastName, "Howell");

	}
}
