package serializationDeserialization;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//pojo object------serialize -------JSON Object--------de-serialize-------Pojo Object

public class SerializationDeserialization {

	// POJO ----------> JSON (Serialization)
	@Test
	void convertPojo2Json() throws JsonProcessingException {

		// created java object using pojo class
		Employee emppojo = new Employee();
		emppojo.setName("Anubhav");
		emppojo.setJob("Tester");

		// convert java object ------ json object (serialization)
		ObjectMapper objMapper = new ObjectMapper();
		String jsonData = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emppojo);
		System.out.println(jsonData);

	}

	// JSON ----------> POJO (DeSerialization)
	@Test
	void convertJson2Pojo() throws JsonProcessingException {

		String jsonData = "{\r\n" + "  \"name\" : \"Anubhav\",\r\n" + "  \"job\" : \"Tester\"\r\n" + "}";

		// convert json data -------> POJO object
		ObjectMapper objMapper = new ObjectMapper();
		Employee empPojo = objMapper.readValue(jsonData, Employee.class);

		System.out.println("Name: " + empPojo.getName());
		System.out.println("Jon: " + empPojo.getJob());

	}

}
