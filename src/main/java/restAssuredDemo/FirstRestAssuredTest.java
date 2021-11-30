package restAssuredDemo;

import static org.junit.Assert.assertThat;

import static org.hamcrest.core.IsInstanceOf.instanceOf;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;

public class FirstRestAssuredTest {

	public static void main(String[] args) {
		System.out.println("started");
		assertThat(RestAssured.config(), instanceOf(RestAssuredConfig.class));
		System.out.println("ended");
	}

}
