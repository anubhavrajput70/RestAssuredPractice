package parseJsonResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Approach1 {

	@Test(priority = 1)
	void testJsonResponse() {
		// approach 1 for small json responses without capturing the response

		given().contentType(ContentType.JSON)

				.when().get("https://reqres.in/api/users?page=2")

				.then().statusCode(200).header("Content-Type", "application/json; charset=utf-8")
				//you can get the json path using json path finder
				.body("data[5].last_name",equalTo("Howell") ).log().body()
				;
	}
}
