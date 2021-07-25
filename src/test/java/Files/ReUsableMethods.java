package Files;

import io.restassured.path.json.JsonPath;

public class ReUsableMethods {
	public static JsonPath rawToJson(String response)
	{
		JsonPath js1=new JsonPath(response);
		//String actual=js1.getString("address");
		return js1;
		
	}
	public static JsonPath rawToJson1(String response)
	{
		JsonPath js2=new JsonPath(response);
		return js2;
	}

}
