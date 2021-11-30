package restAssuredDemo;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestAssuredAPIAuthJsonPayload {
	@Test
	public void main() {
		System.out.println("started");
		File jsonFile = new File(
				"E:\\EclipseWorkspace\\Training\\SeleniumTest\\src\\main\\java\\restAssuredPojo\\payload.json");
		RestAssured
				//GIVEN
					.given()
						.baseUri("https://restful-booker.herokuapp.com/auth")
						.contentType(ContentType.JSON)
						.body(jsonFile)
				//WHEN
					.when()
						.post()
				//THEN
					.then()
						.assertThat()
						.statusCode(200)
						.body("token.length()", Matchers.is(15));
		
		
		
		System.out.println("ended");
	}
}