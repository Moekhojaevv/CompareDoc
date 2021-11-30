package restAssuredDemo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import restAssuredPojo.AuthRequest;

public class RestAssuredAPIAuth {

	public static void main(String[] args) {
		System.out.println("started");
		
		AuthRequest authReq=new AuthRequest();
		authReq.setUsername("admin");
		authReq.setPassword("password123");
		
		Response response = RestAssured.given()
//				.contentType("application/json")
				.contentType(ContentType.JSON)
				.body(authReq)
				.post("https://restful-booker.herokuapp.com/auth");
		response.body().prettyPrint();
		
				System.out.println("ended");
	}
}