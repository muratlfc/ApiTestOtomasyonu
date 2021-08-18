package test;


import BaseUrlDepo.BaseUrlHerokuappSetUp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C16_BaseUrlHerokuapp extends BaseUrlHerokuappSetUp {


    @Test
    public void test1(){
        specHerokuapp.pathParam("paramPath" , "booking");
        Response response = given().spec(specHerokuapp).when().get("/{paramPath}");
        response.prettyPrint();

        response.then().assertThat().
                statusCode(200).
                body("booking", Matchers.hasSize(22));
    }
    
    
    
    @Test
    public void test02(){
        specHerokuapp.pathParam("pathParam" , "booking");

        JSONObject anabody =new JSONObject();
        JSONObject icbody = new JSONObject();

        icbody.put("checkin","2021-06-01");
        icbody.put("checkout","2021-06-10");


        anabody.put("firstname" , "Mehmet");
        anabody.put("lastname","Bulut1");
        anabody.put("totalprice" , 500);
        anabody.put("depositpaid" , false);
        anabody.put("bookingdates" , icbody);
        anabody.put("additionalneeds" , "wifi");

        Response response = given().spec(specHerokuapp).
                                    contentType(ContentType.JSON).
                                    when().body(anabody.toString()).
                                    post("/{pathParam}");
        response.prettyPrint();

        response.then().
                statusCode(200).
                body("booking.firstname" , Matchers.equalTo("Mehmet"));
    }







}


