package Files;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import Files.Payload;
import Files.ReUsableMethods;

public class DynamicJson {
  @Test(dataProvider="BookData")
  public void addBook(String isbn, String aisle) {
	 String response= RestAssured.baseURI="http://216.10.245.166";
	 given().log().all().header("Content-Type","application/json")
	 .body(Payload.AddBook(isbn, aisle))
	 .when()
	 .post("/Library/Addbook.php")
	 .then().assertThat().statusCode(200)
	 .extract().response().asString();
	 System.out.println(response);
	 JsonPath js2=new JsonPath(response);
	 //JsonPath js=ReUsableMethods.rawToJson(response);
	// String id=js2.get("ID");
	 //System.out.println("ID is : " +id);
	 String message=js2.getString("Msg");
	 System.out.println("message is : "+message);
	 
	 
  }
  
  @DataProvider(name="BookData")
  public Object[][] getdata()
  {
	return new Object[][] {{"sagars","133333"},{"arvinds","144344"},{"vikrams","443545"}};

  }
  }
