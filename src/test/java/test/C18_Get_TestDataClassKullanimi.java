package test;
import BaseUrlDepo.BaseUrlJsonPlaceHolder;
import TestDataDeposu.TestDataJsonPlaceHolder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.given;
public class C18_Get_TestDataClassKullanimi extends BaseUrlJsonPlaceHolder {


    @Test
    public void t01(){
        specJsonPlace.pathParams("pp1","posts","pp2",22);
        TestDataJsonPlaceHolder testDataJsonPlaceHolder=new TestDataJsonPlaceHolder();

        JSONObject expectedDataJson= testDataJsonPlaceHolder.expectedDataOlustur();

        System.out.println(expectedDataJson);
//        {
//            "userId": 3,
//                "id": 22,
//                "title": "dolor sint quo a velit explicabo quia nam",
//                "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
//        }
        //3- Response olustur, requesti gonderip donen response'i kaydet
        Response response=given()
                .spec(specJsonPlace)
                .when()
                .get("{pp1}/{pp2}");
        response.prettyPrint();
        //4- Assertion
        //iki Assertion metodu ogrendik
        // I. Metot= response.then().assertThat .... response ait temel bilgileri test edebiliyorduk,
        //body'deki degerler icin  de Matchers Class'indan yardim aliyorduk
        // II. Metot = Assert ve softAssert yontemlerini test yapabilriz
        JsonPath responseJPath= response.jsonPath();
        Assert.assertEquals(testDataJsonPlaceHolder.basariliStatusCode,response.getStatusCode());
        Assert.assertEquals(expectedDataJson.getInt("userId"),responseJPath.getInt("userId"));
        Assert.assertEquals(expectedDataJson.getInt("id"),responseJPath.getInt("id"));
        Assert.assertEquals(expectedDataJson.getString("title"),responseJPath.getString("title"));
        Assert.assertEquals(expectedDataJson.getString("body"),responseJPath.getString("body"));
    }
}