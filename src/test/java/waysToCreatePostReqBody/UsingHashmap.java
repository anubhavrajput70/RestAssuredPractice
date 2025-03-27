package waysToCreatePostReqBody;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

/*
 * Different ways to create Post Request Body
 * 1) Post request body using hashmap
 * 2) Post Request body creation org.JSON
 * 3) Post request body creation using POJO class
 * 4) Post request body using external json file data
 * */

import org.testng.annotations.Test;

public class UsingHashmap {

	// 1) Post request body using hashmap

	@Test(priority = 1)
	public void testPostRequestusingHashmap() {
		HashMap map = new HashMap();
		map.put("name", "Anubhav");
		map.put("job", "QA");

		given().contentType("application/json").body(map)

				.when().post("https://reqres.in/api/users")

				.then().statusCode(201).body("name", equalTo("Anubhav")).body("job", equalTo("QA"))
				.header("Content-Type", "application/json; charset=utf-8").log().all();
	}

}
