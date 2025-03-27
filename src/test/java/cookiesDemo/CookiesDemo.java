package cookiesDemo;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesDemo {

	//we can only check the cookie is present or not because cookie value is variable
	@Test(priority = 1)
	void testCookies() {
		given()

				.when().get("https://www.google.com")

				// cookie should be generated newly every time you hit the request
				.then().cookie("AEC", "AVcja2eRKoy4KIMBxTDfHwadQZHO1oUKQBrfI9R-OOkkAoql7bvA65BaKA").log().all();
	}

	@Test(priority = 2)
	void getCookiesInfo() {
		Response res = given()

				.when().get("https://www.google.com");

		// get single cookie info
		String cookie_value = res.getCookie("AEC");
		System.out.println("Value of the cookie is ==> "+cookie_value);
		
		//get all the cookies info
		Map<String, String> cookies_value= res.getCookies();
		//printing all the keys of the map
		//System.out.println(cookies_value.keySet());
		
		for(String key: cookies_value.keySet())
		{
			String cookie =res.getCookie(key);
			System.out.println(key+"          "+cookie);
		}

	}

}
