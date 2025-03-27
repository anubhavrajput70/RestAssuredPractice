package waysToCreatePostReqBody;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class UsingExternalJsonFile {
//	4) Post request body using external json file data
	@Test
	public void testPostRequestusingPojoClass() throws FileNotFoundException {

		File file = new File(System.getProperty("user.dir")+"\\src\\test\\java\\waysToCreatePostReqBody\\body.json");
		FileReader fr = new FileReader(file);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);

		given().contentType("application/json").body(data.toString())

				.when().post("https://reqres.in/api/users")

				.then().statusCode(201).body("name", equalTo("morpheus")).body("job", equalTo("leader"))
				.header("Content-Type", "application/json; charset=utf-8").log().all();
	}

}
