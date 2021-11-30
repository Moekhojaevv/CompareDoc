package restAssuredDemo;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class RestAssuredAPIDeSerialization {

	public static void main(String[] args) {
		System.out.println("started");
		Header acceptHeader=new Header("accept", "application/json");
		Response response = RestAssured.given().header(acceptHeader).get("https://restful-booker.herokuapp.com/booking/1");
		response.body().prettyPrint();
		BookingResponse bookingResponse =response.as(BookingResponse.class);
		System.out.println("FNAME="+bookingResponse.getFirstname());
		System.out.println("LNAME="+bookingResponse.getLastname());
		System.out.println("Total Price="+bookingResponse.getTotalprice());
		System.out.println("depositpaid="+bookingResponse.isDepositpaid());
        BookingDates bookingdates = bookingResponse.getBookingdates();
		String checkin = bookingdates.getCheckin();
		System.out.println("checkin="+checkin);
        System.out.println("checkout="+bookingdates.getCheckout());
        
		System.out.println("ended");
		
	}
}



/*
 * int iStatus = response.getStatusCode(); //
 * System.out.println("RESPONSE BODY="+response.getBody().asString());
 * System.out.println("RESPONSE STATUS CODE="+iStatus); //
 * System.out.println("RESPONSE BODY From Print="+response.getBody().print());
 * String resBody=response.getBody().print();
 */
