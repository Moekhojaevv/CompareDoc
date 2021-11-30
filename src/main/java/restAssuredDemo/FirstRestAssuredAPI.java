package restAssuredDemo;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstRestAssuredAPI {

	public static void main(String[] args) {
		System.out.println("started");
		Response response = RestAssured.given().get("https://restful-booker.herokuapp.com/ping");
		int iStatus = response.getStatusCode();
		System.out.println("RESPONSE BODY="+response.getBody().asString());
		System.out.println("RESPONSE STATUS CODE="+iStatus);
		System.out.println("ended");
		
	}
}
