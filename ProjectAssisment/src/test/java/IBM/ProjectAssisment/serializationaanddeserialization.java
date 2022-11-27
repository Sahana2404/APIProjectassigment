	package IBM.ProjectAssisment;

	import org.testng.annotations.Test;

	import com.fasterxml.jackson.core.JsonProcessingException;
	import com.fasterxml.jackson.databind.ObjectMapper;

	import IBM.ProjectAssisment.Pojoclass;
	import io.restassured.RestAssured;
	import io.restassured.response.Response;

	public class serializationaanddeserialization {
		@Test(enabled = true)
	    public void POST() throws JsonProcessingException {
	        RestAssured.baseURI = "http://localhost:3000";
	        
	       Pojoclass objPojo = new Pojoclass();
	        objPojo.setName("san");
	        objPojo.setAge(37);
	        objPojo.setIndoorgame("Chess1");
	        objPojo.setOutdoorgame("basketball");
	        ObjectMapper mapper = new ObjectMapper();
	        String jsonBodyData = mapper.writeValueAsString(objPojo);
	        RestAssured.given().log().all().body(jsonBodyData)
	                .header("Content-Type", "application/json").when().post("/Games");
	        Response resp2 = RestAssured.get("http://localhost:3000/Games");
	        System.out.println(resp2.asString());
	        
	      
	  
	        // De-serialisation -> Back to pojo object 
	        Pojoclass objPojo2 =RestAssured.given().get("http://localhost:3000/Games/29")
	                .as(Pojoclass.class);
	        Pojoclass.ToString(objPojo2);
	      
	    }

	}



