package IBM.ProjectAssisment;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class jsonpath {
	@Test(enabled=true)
	public void postmethod()
	
	{
    Response respost = RestAssured.get("http://localhost:3000/Games");
    
    System.out.println("*********************************************************");
    //Reading the expected data from entire response
    //Get the number of courses
    JsonPath jsp2 = new JsonPath(respost.asString());
    System.out.println("The Games Count is :"+jsp2.getInt("Games.size()"));
    System.out.println("all names :"+jsp2.getString("name"));
    System.out.println("particular hobby  :"+jsp2.getString("hobbies[3]"));
}

}
