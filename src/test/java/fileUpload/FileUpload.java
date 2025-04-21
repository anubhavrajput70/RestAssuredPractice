package fileUpload;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

public class FileUpload {

    @Test
    void fileUpload() {
        File file = new File("C:\\Users\\anubh\\Downloads\\LambdaTest.txt");

        given()
        //for file upload thest two are very important
            .multiPart("file", file)
            .contentType("multipart/form-data")
        .when()
            .post("https://api.escuelajs.co/api/v1/files/upload")
        .then()
            .statusCode(201)
            .log().all();
    }
}
