package IBM.ProjectAssisment;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class basicoperations {
	
	@Test(enabled=false)
	public void postmethod()
	{
	RestAssured.baseURI="http://localhost:3000";
	String Body = " {\r\n"
			+ "    \"name\": \"San GS\",\r\n"
			+ "    \"age\": 28,\r\n"
			+ "    \"hobbies\": {\r\n"
			+ "      \"indoor\": [\r\n"
			+ "        \"TT\"\r\n"
			+ "      ],\r\n"
			+ "      \"outdoor\": [\r\n"
			+ "        \"Basket ball\"\r\n"
			+ "      ]\r\n"
			+ "    }\r\n"
			+ "  }";
	Response resp2=RestAssured.given().log().all().body(Body).header("Content-Type", "application/json").post("/Games");
	System.out.println(resp2.statusCode());
	System.out.println(resp2.statusLine());
	Response respost= RestAssured.get("http://localhost:3000/Games");
			System.out.println(respost.asString());
	//Extract the response code and response message and print it    
	System.out.println(respost.statusCode());
	System.out.println(respost.statusLine());
	
	}


	@Test(enabled=false)
	 public void getmethod()
	 {
		Response resp = RestAssured.get("http://localhost:3000/Games");
		System.out.println(resp.asPrettyString());
		System.out.println(resp.asString());
	 }
	
	@Test(enabled=false)
	public void deletemethod()
	{
        Response resp3 =RestAssured.delete("http://localhost:3000/Games/32");
        System.out.println(resp3.asPrettyString());
	}
	
	@Test(enabled = false)
    public void PUT() {
        // For PUT request , we always have to provide the ID fr which you wants to do the changes
        String Body = "{\r\n"
        		+ "    \"name\": \"Indi\",\r\n"
        		+ "    \"age\": 82,\r\n"
        		+ "    \"hobbies\": {\r\n"
        		+ "      \"indoor\": [\r\n"
        		+ "        \"CB\"\r\n"
        		+ "      ],\r\n"
        		+ "      \"outdoor\": [\r\n"
        		+ "        \"YG\"\r\n"
        		+ "      ]\r\n"
        		+ "    }\r\n"
        		+ "  }";
        // First fetch the response in the response container
        Response resp12 = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(Body)
                .when()        
                .put("http://localhost:3000/Games/32");
                
        // Extract the response code and response message and print it
        System.out.println("********************************************************************");
        System.out.println("The status Code is :"+resp12.statusCode());
        System.out.println("The status response line s :"+resp12.statusLine());
        System.out.println("********************************************************************");
        Response resp = RestAssured.get("http://localhost:3000/Games/32");
        System.out.println(resp.asString());
	}
   
	@Test(enabled = false)
    public void PATCH() {
        // For PUT request , we always have to provide the ID fr which you wants to do the changes
        String Body ="{\r\n"
        		+ "    \"hobbies\": {\r\n"
        		+ "      \"indoor\": [\r\n"
        		+ "        \"UIO\"\r\n"
        		+ "      ],\r\n"
        		+ "      \"outdoor\": [\r\n"
        		+ "        \"BIO\"\r\n"
        		+ "      ]\r\n"
        		+ "    }\r\n"
        		+ "  }";
        // First fetch the response in the response container
        Response resp = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(Body)
                .when()        
                .patch("http://localhost:3000/Games/31");
                
        // Extract the response code and response message and print it
        System.out.println("********************************************************************");
        System.out.println("The status Code is :"+resp.statusCode());
        System.out.println("The status response line s :"+resp.statusLine());
        System.out.println("********************************************************************");
        Response resp12 = RestAssured.get("http://localhost:3000/Games/31");
        System.out.println(resp12.asString());
	}
   
	// Assertions 
    @Test(enabled = false)
    public void Assertions() {
        Response resp = RestAssured.given()
                .queryParam("id", "29")
                .header("Content-Type", "application/json")
                .when()        
                .get("http://localhost:3000/Games");
                
        // Extract the response code and response message and print it
        System.out.println("********************************************************************");
        System.out.println("The status Code is :"+resp.statusCode());
        System.out.println("The status response line s :"+resp.statusLine());
        assertEquals(200, resp.statusCode());
        assertNotNull( resp.statusCode());
        System.out.println("********************************************************************");
        Response resp2 = RestAssured.get("http://localhost:3000/Games/29");
        System.out.println(resp2.asString()); 
        assertEquals(200, resp.statusCode());   
    }
    
  //Data provider method 
    @DataProvider(name = "DP1")
       public Object[][] dataProviderMethod() {
        
           return new Object[][] { { "29" }, { "30" }, { "31" } };
       }
//Passing the ID from dataProvider table using TestNG 
   @Test(enabled = true ,dataProvider = "DP1")
   public void PATCHUsingDataProvider(String ID) {
       // For PUT request , we always have to provide the ID for which you wants to do the changes
       String Body = "{\r\n"
       		+ "\"age\": 22\"\r\n"
       		+ "}";
       // First fetch the response in the response container
       Response resp = RestAssured.given()
               .header("Content-Type", "application/json")
               .body(Body)
               .when()        
               .patch("http://localhost:3000/Games/"+ID);
               
       // Extract the response code and response message and print it
       System.out.println("********************************************************************");
       System.out.println("The status Code is :"+resp.statusCode());
       System.out.println("The status response line s :"+resp.statusLine());
       System.out.println("******************************************************************");
Response resp2 = RestAssured.get("http://localhost:3000/Games/"+ID);
       System.out.println(resp2.asString());    
       
   }

}
