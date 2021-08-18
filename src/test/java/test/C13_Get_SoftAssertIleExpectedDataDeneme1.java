package test;


import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;


public class C13_Get_SoftAssertIleExpectedDataDeneme1 {

    @Test
    public void gettest01(){

        String url = "http://dummy.restapiexample.com/api/v1/employee/3";
        JSONObject anabody = new JSONObject();
        JSONObject databody = new JSONObject();

        databody.put("id" , 3);
        databody.put("employee_name" , "Ashton Cox");
        databody.put("employee_salary" , 86000);
        databody.put("employee_age",66);
        databody.put("profile_image","");

        anabody.put("status","success");
        anabody.put("data",databody);
        anabody.put("message","Successfully! Record has been fetched.");

        Response response = given().when().get(url);
        response.prettyPrint();

       JsonPath sonucJpath = response.jsonPath();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(sonucJpath.get("status"), anabody.get("status"));
        softAssert.assertEquals(sonucJpath.get("data.id"),anabody.getJSONObject("data").get("id"));
        softAssert.assertEquals(sonucJpath.get("data.employee_name"),anabody.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(sonucJpath.get("data.employee_salary"),anabody.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(sonucJpath.get("data.employee_age"),anabody.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(sonucJpath.get("data.profile_image"),anabody.getJSONObject("data").get("profile_image"));
        softAssert.assertEquals(sonucJpath.get("message"),anabody.get("message"));



        softAssert.assertAll();




    }
}
