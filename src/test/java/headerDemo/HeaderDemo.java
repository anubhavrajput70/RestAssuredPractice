package headerDemo;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;


public class HeaderDemo {

	@Test(priority = 1)
	void testHeaders() {
		given()

				.when().get("https://www.google.com")

				.then().header("Content-Type", "text/html; charset=ISO-8859-1").header("Content-Encoding", "gzip")

				.and().header("Server", "gws")
				;
	}

	@Test(priority = 2)
	void getHeaders() {
		Response res = given()

				.when().get("https://www.google.com");
		
		//get single header info
		String headerValue=res.getHeader("Content-Type");
		System.out.println("value of Content-Type header value: "+headerValue);
		
		//by default it is printing all the headers by log().all() method
		//to print only header log().headers()
		//get all headers info
		Headers myHeaders= res.getHeaders();
		
		for(Header hd:myHeaders)
		{
			System.out.println(hd.getName()+"        "+hd.getValue());
		}
	}
}
