package schemaValidation;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

//json to jsonschemaconverter(.json)
//https://jsonformatter.org/json-to-jsonschema

public class JsonSchemaValidation {
	
	@Test
	public void jsonSchemaValidation()
	{
		given()
			
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
		//the method to validate the json schema
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchema.json")).statusCode(200);
	}

}
