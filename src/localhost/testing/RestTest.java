package localhost.testing;

import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 
public class RestTest {
 
	@Test(priority = 0)
	public void GetConfig()
	{   
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://localhost:3000/config";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/getconfig");
 
		System.out.println("Response Body is =>  " + response.asString());
		
		int statusCode = response.getStatusCode();
		assertEquals(statusCode, 200);
		System.out.println("Status code is: " + statusCode);
		
		String statusLine = response.getStatusLine();
		assertEquals(statusLine, "HTTP/1.1 200 OK");
		System.out.println("Status Line is: " + statusLine);
 
	}
	
	@Test(priority = 1)
	public void SetConfig()
	{   
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://localhost:3000/config";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.POST, "/setconfig");
 
		
 
	}
 
}