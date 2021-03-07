package com.jsonplaceholder.typicode;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class AutotestQAA {

    @BeforeClass
    public  static void setup(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        RestAssured.requestSpecification=given().header("Language","en");
    }

   /**
    * Get a resource by id
    * Success for id=1-100
    * failure for another values of id
    */
    @Test
    public  void getResById() {
        given().when().request("GET","/posts/1").then().assertThat().statusCode(HttpStatus.SC_OK);
    }

    /**
     * Filtering by query parameters
     * Success for userId=1-10
     * failure for another values of userId
     */
    @Test
    public  void filterByParam() {
        given().get("/posts?userId=2").then().assertThat().statusCode(HttpStatus.SC_OK);

    }

    //Get list of all resources
    @Test
    public  void getListOfAllRes() {
        given().when().request("GET","/posts").then().assertThat().statusCode(HttpStatus.SC_OK);

    }
}
