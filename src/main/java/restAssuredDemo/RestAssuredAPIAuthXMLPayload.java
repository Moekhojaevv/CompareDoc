package restAssuredDemo;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestAssuredAPIAuthXMLPayload {

	public static void main(String[] args) {
		System.out.println("started");
		File xmlFile = new File(
				"E:\\EclipseWorkspace\\Training\\SeleniumTest\\src\\main\\java\\restAssuredPojo\\payload.xml");
		
		Response response = RestAssured.given().contentType(ContentType.XML).body(xmlFile)
				.post("https://restful-booker.herokuapp.com/auth");
		response.body().prettyPrint();

		System.out.println("ended");
	}
}