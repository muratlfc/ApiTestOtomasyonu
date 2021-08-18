package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C13_Get_SoftAssertIleExpectedDataTesti {

    @Test
    public void get01(){
        String url = "http://dummy.restapiexample.com/api/v1/employee/3";

        JSONObject exData= new JSONObject();
        JSONObject dataBody = new JSONObject();

        dataBody.put("id",3);
        dataBody.put("employee_name","Ashton Cox");
        dataBody.put("employee_salary",86000);
        dataBody.put("employee_age",66);
        dataBody.put("profile_image","");


        exData.put("status","success");
        exData.put("data",dataBody);
        exData.put("message","Successfully! Record has been fetched.");


       Response response=given().when().get(url);
        response.prettyPrint();

        //COK ONEMLI UNUTMA: Response body json formata ceviriyoruz
        JsonPath resJasonPath=response.jsonPath();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(resJasonPath.get("status"),exData.get("status"));
        softAssert.assertEquals(resJasonPath.get("data.id"),exData.getJSONObject("data").get("id"));
        softAssert.assertEquals(resJasonPath.get("data.employee_name"),exData.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(resJasonPath.get("data.employee_salary"),exData.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(resJasonPath.get("data.employee_age"),exData.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(resJasonPath.get("data.profile_image"),exData.getJSONObject("data").get("profile_image"));
        softAssert.assertEquals(resJasonPath.get("message"),exData.get("message"));



        softAssert.assertAll();








    }
}
