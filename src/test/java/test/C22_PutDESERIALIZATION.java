package test;

import BaseUrlDepo.BaseUrlJsonPlaceHolder;
import TestDataDeposu.TestDataJsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C22_PutDESERIALIZATION extends BaseUrlJsonPlaceHolder {


    @Test
    public void puttest01(){
    specJsonPlace.pathParams("pp1" , "posts" , "pp2" , 70);


        TestDataJsonPlaceHolder testDataJsonPlaceHolder = new TestDataJsonPlaceHolder();
        HashMap<String , Object> requestBodyMap = testDataJsonPlaceHolder.requestBodyMapOlustur();
        //  esitligin soluda gelen mapi             //esitligin sag tarafi
        // yeni olusturulan map e atama yapacak     // test data classina gidip mapi olusturup getirecek


        //2- Soruda isteniyorsa expected data olustur...

        HashMap<String , Object> expectedDataMap = testDataJsonPlaceHolder.requestBodyMapOlustur();

        //Response olustur request gonderip donen response ' i  kaydet...
        Response response = given().
                            spec(specJsonPlace).
                            contentType(ContentType.JSON).
                            when().
                            body(requestBodyMap).put("/{pp1}/{pp2}");

        response.prettyPrint();


    //4-Assertion
        //expectedDataMap === response objesi


        //response mape cevir

        HashMap<String , Object> responseMap = response.as(HashMap.class);
//response as() methodu kullanarak HashMap cevirdim...

        System.out.println(responseMap);
        System.out.println(expectedDataMap);


        assertEquals(testDataJsonPlaceHolder.basariliStatusCode , response.getStatusCode());
        assertEquals(expectedDataMap.get("id")  , responseMap.get("id"));
        assertEquals(expectedDataMap.get("title") , responseMap.get("title"));
        assertEquals(expectedDataMap.get("body") , responseMap.get("body"));
        assertEquals(expectedDataMap.get("userId") , responseMap.get("userId"));



    }


}
