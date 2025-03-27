package waysToCreatePostReqBody;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

public class UsingPojoClass {
	
//	3) Post request body creation using POJO class
	@Test
	public void testPostRequestusingPojoClass() {
		
		Pojo pojo = new Pojo();
		pojo.setName("Anubhav");
		pojo.setJob("Tester");

		given().contentType("application/json").body(pojo)

				.when().post("https://reqres.in/api/users")

				.then().statusCode(201).body("name", equalTo("Anubhav")).body("job", equalTo("Tester"))
				.header("Content-Type", "application/json; charset=utf-8").log().all();
	}

}
