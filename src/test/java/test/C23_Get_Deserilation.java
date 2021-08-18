package test;

import BaseUrlDepo.BaseUrlDummySetup;
import TestDataDeposu.TestDataDummyRestApi;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C23_Get_Deserilation extends BaseUrlDummySetup {

    @Test
    public void get010(){

   specDummyRestApi.pathParams("pp1" , "employee" , "pp2" ,3);

        TestDataDummyRestApi testDataDummyRestApi = new TestDataDummyRestApi();
        HashMap<String,Object> expectedData = testDataDummyRestApi.expectedDataMapOlustur();

        Response response = given().
                                    spec(specDummyRestApi).
                                       when().
                                          get("/{pp1}/{pp2}");

response.prettyPrint();

       HashMap<String , Object> responseMap = response.as(HashMap.class);

        System.out.println("expected data :" + expectedData);
        //expected data :
        // {data={profile_image=, employee_name=Ashton Cox, employee_salary=3, id=3, employee_age=3},
        // message=Successfully! Record has been fetched.,
        // status=success}







        System.out.println("response Map :" + responseMap);
        //response Map :{
        // data={id=3, employee_name=Ashton Cox, employee_salary=86000, employee_age=66, profile_image=},
        // message=Successfully! Record has been fetched.,
        // status=success}

        Assert.assertEquals(expectedData.get("status") , responseMap.get("status"));
        Assert.assertEquals(((Map)expectedData.get("data")).get("id") , ((Map)responseMap.get("data")).get("id"));
        Assert.assertEquals(((Map) expectedData.get("data")).get("employee_name") , ((Map) responseMap.get("data")).get("employee_name"));
        Assert.assertEquals(((Map) expectedData.get("data")).get("employee_salary") , ((Map) responseMap.get("data")).get("employee_salary"));








    }












}
