package test;

import BaseUrlDepo.BaseUrlJsonPlaceHolder;
import TestDataDeposu.TestDataJsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C19_Put_TestDataClassKullanimi extends BaseUrlJsonPlaceHolder {

 @Test
    public void t12(){

    specJsonPlace.pathParams("pp1" , "posts" ,"pp2" , 70);


     TestDataJsonPlaceHolder testDataJsonPlaceHolder = new TestDataJsonPlaceHolder();
     JSONObject requestBody = testDataJsonPlaceHolder.putRequestBodyOlustur();
     JSONObject expectedDataJson = testDataJsonPlaceHolder.putRequestExpectedBodyOlustur();

     Response response = given().
                                  spec(specJsonPlace).
                                  contentType(ContentType.JSON).
                         when().
                                  body(requestBody.toString()).put("/{pp1}/{pp2}");
     response.prettyPrint();


     JsonPath responseJPath = response.jsonPath();

     assertEquals(testDataJsonPlaceHolder.basariliStatusCode, response.getStatusCode());
     assertEquals(testDataJsonPlaceHolder.contentType , response.getContentType());
     assertEquals(testDataJsonPlaceHolder.connectionHeaderDegeri , response.getHeader("Connection"));

     assertEquals(expectedDataJson.getString("title") , responseJPath.getString("title"));
     assertEquals(expectedDataJson.getString("body") , responseJPath.getString("body"));
     assertEquals(expectedDataJson.getInt("userId"),responseJPath.getInt("userId"));
     assertEquals(expectedDataJson.getInt("id") , responseJPath.getInt("id"));






 }


}
