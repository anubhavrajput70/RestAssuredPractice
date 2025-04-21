package schemaValidation;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;

//xml  to xmlSchema (.xsd)
//https://www.convertsimple.com/convert-xml-to-xsd-xml-schema/ 
public class XmlSchemaValidation {
	
	@Test
	public void xmlSchemaValidation()
	{
		given()
		
		.when()
			.get("https://mocktarget.apigee.net/xml")
		
		.then()
			.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("xmlSchema.xsd"));
	}

}
