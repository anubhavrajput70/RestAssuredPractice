package parseJsonResponse;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Approach3 {
	@Test(priority = 1)
	void testJsonResponse() {
		// approach 2 for small json responses with capturing the response

		Response res = given().contentType(ContentType.JSON)

				.when().get("https://reqres.in/api/users?page=2");

		// to parse the entire json response we have to use JSONObject class
		//printing all the first names from the responsees
		JSONObject jo = new JSONObject(res.getBody().asString()); // converting response to json object type

		for (int i = 0; i < jo.getJSONArray("data").length(); i++)// getting the length of the internal data array
		{
			String firstName = jo.getJSONArray("data").getJSONObject(i).get("first_name").toString();
			System.out.println("First Name: "+firstName);
		}
		
		boolean status =false;
		//finding specific name in the response
		for (int i = 0; i < jo.getJSONArray("data").length(); i++)
		{
			String name =jo.getJSONArray("data").getJSONObject(i).get("first_name").toString();
			if(name.equals("Lindsay"))
			{
				status = true;
				break;
			}
		}
		
		Assert.assertEquals(status, true);
		
	}

}
