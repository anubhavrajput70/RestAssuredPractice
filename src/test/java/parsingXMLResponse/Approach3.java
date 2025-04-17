package parsingXMLResponse;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class Approach3 {
	// approach 3 by returning data into a variable we can do some more additional
	// validations also on by saving the response in a variable
	// if you are converting the data then you have to use toString() method
	// but if you are converting the entire response into string then you need to
	// use asString() method
	@Test
	void testXMLResponse() {
		Response res = given()

				.when().get("https://mocktarget.apigee.net/xml ");

		XmlPath xmlobj = new XmlPath(res.asString()); // asString() method will convert the entire response into string
														// format
		// getting the list of all the persons
		List<String> persons = xmlobj.getList("root");
		Assert.assertEquals(persons.size(), 1);

		// verify a specific data is present in the response or not
		List<String> persons_names = xmlobj.getList("root.firstName");
		boolean status = false;
		for (String personsnames : persons_names) {
			if (personsnames.equals("John")) {
				status = true;
				break;
			}
		}
		Assert.assertEquals(status, true);

	}

}
