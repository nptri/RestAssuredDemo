package rest;

// import io.restassured.RestAssured;
// import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

// import org.testng.Assert;
// import org.testng.annotations.Test;

// import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
public class myFirstRestAssuredClass {
   @Test
   private void testGetRequest(){
      // RestAssured.baseURI ="https://reqres.in";
      // RestAssured ApiGet = new RestAssured();
      given()
            .log().all()
      .when()
            .get("https://reqres.in/api/users?page=2")
      .then()
            .log().all();
      // Assert.assertEquals(
      //    response.getStatusCode(), 
      //    200, 
      //    "Status code should be 200");
      // Assert.assertTrue(
      //    response.getBody()
      //    .asString()
      //    .contains("name"), 
      //    "should have name field");
   }
   @Test
   private void testFailRequest(){
      Map<String, Object> params = new HashMap<>();
         params.put("this", "that");
         params.put("these", "those");
      given()
            .log().all()
         .when()
            .queryParams(params)
            .get("https://reqres.in/api/unknown/23")   
         .then()
            .log().all();
   }
 }