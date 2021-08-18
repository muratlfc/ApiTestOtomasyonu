package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C14_Put_SoftAssertIleExpectedDataTestiDeneme2 {


     /*
    http://dummy.restapiexample.com/api/v1/update/21 url’ine
    asagidaki body’ye sahip bir PUT request gonderdigimizde
    donen response’un asagidaki gibi oldugunu test edin.

    Request Body
            {
            "status": "success",
            "data": {
                "name": "Ahmet",
                "salary": "1230",
                "age": "44",
                "id": 40
                    }
           }

    Response Body
            {
            "status": "success",
            "data": {
                "status": "success",
                "data": {
                    "name": "Ahmet",
                    "salary": "1230",
                    "age": "44",
                    "id": 40
                }
            },
            "message": "Successfully! Record has been updated."
        }
     */




    @Test
    public void gettest(){
        String url="http://dummy.restapiexample.com/api/v1/update/21";

        JSONObject ustbody = new JSONObject();
        JSONObject databody = new JSONObject();

        databody.put("name","Ahmet");
        databody.put("id",33);
        databody.put("salary","1200");
        databody.put("age","33");

        ustbody.put("status","success");
        ustbody.put("data",databody);




        JSONObject sorubody = new JSONObject();
        JSONObject soruicbody = new JSONObject();
        JSONObject sorudisbody =new JSONObject();

        soruicbody.put("name","Ahmet");
        soruicbody.put("salary","1200");
        soruicbody.put("age","33");
        soruicbody.put("id",33);

        sorudisbody.put("status","success");
        sorudisbody.put("data",soruicbody);

        sorubody.put("status","success");
        sorubody.put("data",sorudisbody);
        sorubody.put("message","Successfully! Record has been updated.");

        Response response=given().contentType(ContentType.JSON).
                          when().body(ustbody.toString()).
                          put(url);
        response.prettyPrint();

        JsonPath sonucJPath = response.jsonPath();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(sonucJPath.get("status"),sorubody.get("status"));
        softAssert.assertEquals(sonucJPath.get("data.data.name"),sorubody.getJSONObject("data").getJSONObject("data").get("name"));
        softAssert.assertEquals(sonucJPath.get("data.data.id"),sorubody.getJSONObject("data").getJSONObject("data").get("id"));
        softAssert.assertEquals(sonucJPath.get("data.data.salary"),sorubody.getJSONObject("data").getJSONObject("data").get("salary"));
        softAssert.assertEquals(sonucJPath.get("data.data.age"),sorubody.getJSONObject("data").getJSONObject("data").get("age"));
        softAssert.assertEquals(sonucJPath.get("status"),sorubody.getJSONObject("data").get("status"));
        softAssert.assertEquals("message","message");


        softAssert.assertAll();



































    }




}
