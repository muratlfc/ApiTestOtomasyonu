package test;

import BaseUrlDepo.BaseUrlHerokuappSetUp;
import TestDataDeposu.TestDataHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C24_Post_Deserialization extends BaseUrlHerokuappSetUp {

      /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un asagidaki gibi oldugunu test edin.
    	                Request body
    	           {
    	                "firstname" : "Ahmet",
    	                "lastname" : “Bulut",
    	                "totalprice" : 500,
    	                "depositpaid" : false,
    	                "bookingdates" : {
    	                         "checkin" : "2021-06-01",
    	                         "checkout" : "2021-06-10"
    	                                  },
    	                "additionalneeds" : "wi-fi"
    	            }


    	            	Response Body // expected data
    	            {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                        ,
                        "additionalneeds":"wi-fi"
                    }
     */

@Test
    public void test(){
    //request icin url ve body olustur...
specHerokuapp.pathParam("pp1" , "booking");

    TestDataHerokuapp testDataHerokuapp = new TestDataHerokuapp();
    Map<String,Object>requestBody=testDataHerokuapp.requestBodyMapOlustur();

//2-Soruda varsa expected data olustur...

    Map<String,Object>expectedDataMap=testDataHerokuapp.expectedDataOlustur();
    Response response =
                    given().
                    contentType(ContentType.JSON).
                    spec(specHerokuapp).
                    when().
                            body(requestBody).
                            post("/{pp1}");


    //4-Assert
    //expected data Map ==> response
    Map<String,Object>responseMap=response.as(HashMap.class);
    //expected data Map ==> response Map
    System.out.println("expected data map" + expectedDataMap);
    System.out.println("response map" + responseMap);


    //expected data map
    //   {
    //    booking={firstname=Ahmet,
    //    additionalneeds=wi-fi,
    //          bookingdates={
    //                        checkin=2021-06-01,
    //                        checkout=2021-06-10},
    // totalprice=500,
    // depositpaid=false,
    // lastname=Bulut},
    // bookingid=24
    // }

    // response map{booking={firstname=Ahmet, lastname=Bulut, totalprice=500, depositpaid=false, bookingdates={checkin=2021-06-01, checkout=2021-06-10}, additionalneeds=wi-fi}, bookingid=92}


    assertEquals( ((Map)expectedDataMap.get("booking")).get("firstname"), ((Map)responseMap.get("booking")).get("firstname"));
    assertEquals(((Map)expectedDataMap.get("booking")).get("depositpaid") , ((Map)responseMap.get("booking")).get("depositpaid"));
    assertEquals( ( (Map) ( (Map) expectedDataMap.get("booking") ).get("bookingdates")  ).get("checkin"),
                  ( (Map) ( (Map) responseMap.get("booking")     ).get("bookingdates")  ).get("checkin"));











}































}
