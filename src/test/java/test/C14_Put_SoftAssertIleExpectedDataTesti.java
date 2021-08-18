package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C14_Put_SoftAssertIleExpectedDataTesti {

    @Test
    public void getTest01(){
        String url="http://dummy.restapiexample.com/api/v1/update/21";

        JSONObject ustBody= new JSONObject();
        JSONObject databody =new JSONObject();

        databody.put("name","Ahmet");
        databody.put("salary","1230");
        databody.put("age","44");
        databody.put("id",40);

        ustBody.put("status","success");
        ustBody.put("data",databody);



        JSONObject altbody = new JSONObject();
        JSONObject disbody = new JSONObject();
        JSONObject icbody = new JSONObject();


        icbody.put("name","Ahmet");
        icbody.put("salary","1230");
        icbody.put("age","44");
        icbody.put("id",40);

        disbody.put("status","success");
        disbody.put("data",icbody);

        altbody.put("status","success");
        altbody.put("data",disbody);
        altbody.put("message","Successfully! Record has been updated.");


        Response response=given().contentType(ContentType.JSON).
                when().body(ustBody.toString()).
                put(url);
        response.prettyPrint();


        JsonPath ustPath = response.jsonPath();

        SoftAssert softAssert = new SoftAssert();
                                 //a                     //e
        softAssert.assertEquals(ustPath.get("status"),altbody.get("status"));
        softAssert.assertEquals(ustPath.get("data.data.name"),altbody.getJSONObject("data").getJSONObject("data").get("name"));
        softAssert.assertEquals(ustPath.get("data.data.id"),altbody.getJSONObject("data").getJSONObject("data").get("id"));
        softAssert.assertEquals(ustPath.get("data.data.salary"),altbody.getJSONObject("data").getJSONObject("data").get("salary"));
        softAssert.assertEquals(ustPath.get("data.data.age"),altbody.getJSONObject("data").getJSONObject("data").get("age"));
        softAssert.assertEquals(ustPath.get("data.status"),altbody.getJSONObject("data").get("status"));
        softAssert.assertEquals(ustPath.get("message"),altbody.get("message"));


        softAssert.assertAll();

    }
}
