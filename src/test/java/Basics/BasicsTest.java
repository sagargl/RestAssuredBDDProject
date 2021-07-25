package Basics;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;

import Files.Payload;
import Files.ReUsableMethods;

public class BasicsTest {
	public static void main(String[] args) throws IOException {
			
	
	//Validate  if Add place Api is working as expected
		//given --> All Input Details
		//when -->  Submit the API-resource, http method
		//Then -->  Validate the response
		//Content of the file to String --> Content of file can convert into Byte--> And then
		//convert Byte data to String
	RestAssured.baseURI="https://rahulshettyacademy.com";
	String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
	//.body(Payload.AddPlace()).when().post("maps/api/place/add/json")
	/*This will help to convert the file to an byte format first and then it coverts the byte format to String */
	.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\swath\\eclipse-workspace\\RestAssured_Rahul\\InputFiles\\Files.json"))))
	.when().post("maps/api/place/add/json")
	.then().assertThat().statusCode(200).body("scope",equalTo("APP"))
	.header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
	
	System.out.println(response);
	JsonPath js=new JsonPath(response);//JsonPath is used for Parsing JSON
	String placeid=js.getString("place_id");
	String id=js.getString("id");
	System.out.println("Placeid is :"+placeid);
	System.out.println("Id is"+id);
	
	//Update Place
	String newAddress="Summer Walk, Africa";
	given().log().all().queryParam("Key", "qaclick123").header("Content-Type","application/json")
	.body("{\r\n"
			+ "\"place_id\":\""+placeid+"\",\r\n"
			+ "\"address\":\""+newAddress+"\",\r\n"
			+ "\"key\":\"qaclick123\"\r\n"
			+ "}\r\n"
			+ "")
	.when().put("maps/api/place/update/json")
	.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));

	//Get Place
	String getPlaceResponse=given().log().all().queryParam("key", "qaclick123")
	.queryParam("place_id",placeid)
	.when().get("maps/api/place/get/json")
	.then().assertThat().log().all().statusCode(200).extract().response().asString();
	System.out.println("GetPlaceResponse"+getPlaceResponse);
	
	JsonPath js1=ReUsableMethods.rawToJson(getPlaceResponse);
	String actual=js1.getString("address");
	System.out.println("Actualaddress"+actual);
	Assert.assertEquals(actual, newAddress);
	
			
	
	
}
}
