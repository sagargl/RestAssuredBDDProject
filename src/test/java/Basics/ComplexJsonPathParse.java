package Basics;

import org.testng.Assert;

import Files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonPathParse {
	public static void main(String[] args) {
		int sum=0;
		JsonPath js=new JsonPath(Payload.CoursePrice());
		
		//Print no of courses returned by API
		int coursecount=js.getInt("courses.size()");
		System.out.println("course count"+coursecount);
		
		//Print purchase amount
		int purchaseamount=js.getInt("dashboard.purchaseAmount");
		System.out.println("Purchase amount"+purchaseamount);
		
		//Title of the first course
		String title=js.getString("courses[0].title");
		System.out.println("First title"+title);
		
		//Print all course total and their respective prices
		for(int i=0; i<coursecount; i++)
		{
			String coursetitles=js.get("courses["+i+"].title");
			//String courseprices=js.getString("courses["+i+"].price");
			System.out.println("All Course Title is : "+coursetitles);
			//System.out.println("All Course Price is : "+courseprices);
			System.out.println(js.getString("courses["+i+"].price"));
			
		}
		
		//Print No of copies by RPA Course
		System.out.println("Print no of copies sold by RPA Course");
		for(int j=0; j<coursecount; j++)
		{
			String coursetitle=js.get("courses["+j+"].title");
			if(coursetitle.equalsIgnoreCase("RPA"))
			{
				int copies=js.get("courses["+j+"].copies");
				System.out.println(copies);
				break;
				
			}
		}
		
		//Verify If Sum Of All Prices Matches With Purchase Account
		
		for(int k=0; k<coursecount; k++)
		{
			int price=js.getInt("courses["+k+"].price");
			int copies=js.getInt("courses["+k+"].copies");
			int amount=price*copies;
			System.out.println("Amount" +amount);
			sum=sum+amount;
					
		}
		System.out.println("sum of amount :" +sum);
		Assert.assertEquals(sum, purchaseamount);	
		}
	

}
