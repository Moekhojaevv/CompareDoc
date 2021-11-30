package restAssuredDemo;

import static org.hamcrest.core.IsInstanceOf.instanceOf;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;


public class FirstRestAssuredTest2 {
	@Test
	public  void main() {
		System.out.println("started");
		Assert.assertEquals(RestAssured.config(), instanceOf(RestAssuredConfig.class));
		System.out.println("ended");
	}

}
