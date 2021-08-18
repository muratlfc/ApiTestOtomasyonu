package test;

import BaseUrlDepo.BaseUrlHerokuappSetUp;
import TestDataDeposu.TestDataHerokuapp;
import org.junit.Test;

import java.util.Map;

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
specHerokuapp.pathParam("pp1" , "posts");

    TestDataHerokuapp testDataHerokuapp = new TestDataHerokuapp();
    Map<String,Object>requestBody=testDataHerokuapp.requestBodyMapOlustur();

//2-Soruda varsa expected data olustur...


}































}
