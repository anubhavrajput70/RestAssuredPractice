package waysToCreatePostReqBody;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class UsingOrgJsonLibaray {

	// 2) Post Request body creation org.JSON
	// json dependency required
	//if it is taking any integer data then we don't need to give it in double quotations
	@Test(priority = 1)
	public void testPostRequestusingJsonobject() {
		//if you are using this then you need to convert the data in the string format
		JSONObject data = new JSONObject();

		data.put("name", "Anubhav");
		data.put("job", "QA");

		given().contentType("application/json").body(data.toString())

				.when().post("https://reqres.in/api/users")

				.then().statusCode(201).body("name", equalTo("Anubhav")).body("job", equalTo("QA"))
				.header("Content-Type", "application/json; charset=utf-8").log().all();
	}
}
