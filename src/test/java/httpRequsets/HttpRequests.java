package httpRequsets;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

/*
 * given() => pre requisites 
 * 		content type, set cookies, add auth, add param, set header info, etc
 * 
 * when() => requests
 * 		get, post, put, delete, patch
 * 
 * then() => validation
 * 		validate status code, extract response, extract header cookies & response body
 * 
 * for these import static packages
 */

public class HttpRequests {
	
	int id;
	
	@Test(priority =1)
	void getUsers()
	{
		//whichever method starts first you no need to specify the dot(.)

		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
			
		.then()
			.statusCode(200)
			.body("page",equalTo(2))
			//print all the response on the console
			.log().all();
	}

	@Test(priority = 2)
	void createUser()
	{
		HashMap data = new HashMap();
		data.put("name", "Anubhav");
		data.put("job", "QA");
		
		id=given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");	
	
//		.then()
//			.statusCode(201)
//			//print all the response on the console
//			.log().all();
	}
	
	@Test(priority =3, dependsOnMethods ="createUser" )
	void updateUser()
	{
		
		HashMap data = new HashMap();
		data.put("name", "Anubhav");
		data.put("job", "QA Engineer");
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.put("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(200)
			.log().all();	
	}
	
	@Test
	void deleteUser()
	{
		
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+id)		
		.then()
			.statusCode(204)
			.log().all();
		
	}
	
	
}
