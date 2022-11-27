package IBM.ProjectAssisment;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class readdatafromhashmap {


	@Test(enabled=true)
	public void POST() {

	HashMap<String, String> hm = new HashMap<String, String>();
    hm.put("name", "govgty");
    hm.put("age", "32");
    hm.put("indoor", "yu");
    hm.put("outdoor", "io");
    hm.put("id", "32");
    
    System.out.println(hm);
    System.out.println(hm.get("id"));
    
   
	RestAssured.baseURI="http://localhost:3000";
	RestAssured.given().log().all().body(hm).header("Content-Type", "application/json").when().post("/Games");
	
	Response respost= RestAssured.get("http://localhost:3000/Games");
			System.out.println(respost.asString());
	//Extract the response code and response message and print it    
	System.out.println(respost.statusCode());
	System.out.println(respost.statusLine());
	
	}
}
