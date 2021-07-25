package Basics;



import static io.restassured.RestAssured.given;


import java.util.ArrayList;

import java.util.Arrays;

import java.util.List;
import io.restassured.parsing.Parser;

import io.restassured.path.json.JsonPath;

import io.restassured.response.Response;

import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;





public class GetCourse {

public static WebDriver driver;

public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub
//	
//	WebDriverManager.chromedriver().setup();
//	  driver=new ChromeDriver();
//	  
//	  String[] coursetitle= {"Selenium WebDriver Java","Cypress","Protractor"};
//	  driver.get("https://accounts.google.com/o/oauth2/auth/identifier?redirect_uri=storagerelay%3A%2F%2Fhttps%2Fin.bookmyshow.com%3Fid%3Dauth264705&response_type=permission%20id_token&scope=email%20profile%20openid&openid.realm&client_id=990572338172-iibth2em4l86htv30eg1v44jia37fuo5.apps.googleusercontent.com&ss_domain=https%3A%2F%2Fin.bookmyshow.com&fetch_basic_profile=true&gsiwebsdk=2&flowName=GeneralOAuthFlow");
//	  Thread.sleep(3000);
//	  
String url ="https://accounts.google.com/o/oauth2/auth/identifier?redirect_uri=storagerelay%3A%2F%2Fhttps%2Fin.bookmyshow.com%3Fid%3Dauth264705&response_type=permission%20id_token&scope=email%20profile%20openid&openid.realm&client_id=990572338172-iibth2em4l86htv30eg1v44jia37fuo5.apps.googleusercontent.com&ss_domain=https%3A%2F%2Fin.bookmyshow.com&fetch_basic_profile=true&gsiwebsdk=2&flowName=GeneralOAuthFlow";



String partialcode=url.split("&client_id=")[1];
String clientcode=partialcode.split("&ss_domain=")[0];

System.out.println(clientcode);
/*RequestSpecification accesstokenResponse=given().urlEncodingEnabled(false)
//System.out.println("stest"+accesstokenResponse);
.queryParams("client_id",clientcode);

*/


}



}
