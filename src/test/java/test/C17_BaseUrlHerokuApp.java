package test;



import BaseUrlDepo.BaseUrlHerokuappSetUp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

import static io.restassured.RestAssured.given;
public class C17_BaseUrlHerokuApp extends BaseUrlHerokuappSetUp {
    @Test
    public void test01(){
        specHerokuapp.pathParam("pp1","booking");
        Response response=given()
                .spec(specHerokuapp)
                .when()
                .get("/{pp1}");
        response.prettyPrint();
    }
    @Test
    public void t2(){
        specHerokuapp.pathParam("pp1","booking").queryParam("firstname","Susan");
        Response response=given()
                .spec(specHerokuapp)
                .when()
                .get("/{pp1}");
        response.prettyPrint();
        //Assertion
  
        
        response.then().assertThat().statusCode(200).body("bookingid",Matchers.hasSize(3));


        Assert.assertTrue(response.asString().contains("bookingid"));
        System.out.println(response.asString());

    }

    @Test
    public void t3(){
        specHerokuapp.
                pathParam("pp1" , "booking").
                queryParams("firstname","Susan","lastname","Jones");

        Response response =given().spec(specHerokuapp).when().get("/{pp1}");
        response.prettyPrint();

        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertTrue(response.asString().contains("bookingid"));








    }












}



