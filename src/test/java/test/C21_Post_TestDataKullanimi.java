package test;

import BaseUrlDepo.BaseUrlHerokuappSetUp;
import TestDataDeposu.TestDataHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C21_Post_TestDataKullanimi extends BaseUrlHerokuappSetUp {
/*
Request Body
   {
    "firstname": "Mehmet",
    "lastname": "Bulut",
    "totalprice": 500,
    "depositpaid": false,
    "bookingdates": {
        "checkin": "2021-06-01",
        "checkout": "2021-06-10"
    }

Expected Data soruda verilmisti...
{
     "bookingid": 24,
     "booking":{
       "firstname": "Mehmet",
       "lastname": "Bulut",
       "totalprice": 500,
       "depositpaid": false,
        "bookingdates": {
          "checkin": "2021-06-01",
          "checkout": "2021-06-10"

          ,
          "additionalneeds":wi-fi
    }



Response data yi postmandan aldim ve buraya tasidim
{
    "firstname": "Mehmet",
    "lastname": "Bulut",
    "totalprice": 500,
    "depositpaid": false,
    "bookingdates": {
        "checkin": "2021-06-01",
        "checkout": "2021-06-10"
    }
}


 */


@Test
    public void t33(){
//1 adim request url ve body olustur post gonderecegimiz icin body ye ihtiyac var...
    //Test data deposu package ina yeni class ac...Standar istenenleri oraya olustur...
    // Request body oraya olustur...

     specHerokuapp.pathParam("pp1","booking");

    TestDataHerokuapp testDataHerokuapp = new TestDataHerokuapp();
    //test data deposunda ruquest body olustur...
    JSONObject requestBody = testDataHerokuapp.getRequestOlustur();


    // 2. adim da soruda expected data isteniyorsa test depoda olustur...
    //test data deposunda expected data olusturdum...
    JSONObject expectedData = testDataHerokuapp.postRequestExpectedDataOlustur();

    //3- response olustur , request gonderip response kaydet...

    Response response = given().
            spec(specHerokuapp).
            contentType(ContentType.JSON).
            when().body(requestBody.toString()).
            post("/{pp1}");
    response.prettyPrint();

    //4-response id haric (cunku her defasinda degisir) assert edelim...
    //response jsonpathe  cevir...
    JsonPath responseJsonPath = response.jsonPath();

    assertEquals(expectedData.
                             getJSONObject("booking").
                             getString("firstname") , //virgul

                             responseJsonPath.
                             getString("booking.firstname"));




    assertEquals(expectedData.getJSONObject("booking").getString("lastname") , responseJsonPath.getString("booking.lastname"));
    assertEquals(expectedData.getJSONObject("booking").getInt("totalprice") , responseJsonPath.getInt("booking.totalprice"));
    assertEquals(expectedData.getJSONObject("booking").getBoolean("depositpaid") , responseJsonPath.getBoolean("booking.depositpaid"));

    assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").getString("checkin") , responseJsonPath.getString("booking.bookingdates.checkin"));
    assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").getString("checkout") , responseJsonPath.getString("booking.bookingdates.checkout"));

    assertEquals(expectedData.getJSONObject("booking").getString("additionalneeds") , responseJsonPath.getString("booking.additionalneeds"));



}








}
