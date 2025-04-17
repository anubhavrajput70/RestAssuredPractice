package parsingXMLResponse;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Approach2 {

	// approach 2 by returning data into a variable 
	@Test
	void testXMLResponse() {
		Response res = given()

				.when().get("https://mocktarget.apigee.net/xml ");

		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
		String firstName = res.xmlPath().get("root.firstName").toString();// it will return object type so we need to
																			// convert it into string
		Assert.assertEquals(firstName, "John");
	}
}
