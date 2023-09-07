package api_automation.rest_assured_framework;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import Payloads.Payload;

public class BaseTest {
	public String BaseURI = "";
	
	
	/* Given - All the headers and body is given
	 * When - before when all are inputs - define the method here
	 * Then - after then all are op verifications
	 */
	
	
	public static void main(String arg[]) {
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-type","application/json")
		.body(Payload.addPlace()).when().post("maps/api/place/add/json").then().assertThat().statusCode(200)
		.body("scope", equalTo("APP")).extract().response().asString();
		
		// Add place , update and Get place to retrieve
		
		System.out.println("<<>>\n"+response);
		JsonPath jsp = new JsonPath(response);
		String place = jsp.getString("place_id");
		String id = jsp.getString("id");
		System.out.println(id+ place);
		
		
//		given().log().all().queryParam("key", "qaclick123").header("Content-type","application/json")
//		.body("").
		
	}

}
