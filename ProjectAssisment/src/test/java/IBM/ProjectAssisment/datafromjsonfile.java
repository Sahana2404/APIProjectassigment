package IBM.ProjectAssisment;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class datafromjsonfile {

	@Test(enabled = true)
    public void POST() {
        
        RestAssured.baseURI = "http://localhost:3000";
        RestAssured.given().log().all().body(new File("./Projectdata.json"))
                // Giving header details are important
                .header("Content-Type", "application/json").when().post("/Games");
        Response resp2 = RestAssured.get("http://localhost:3000/Games");
        System.out.println(resp2.asString());
    }
}
