package test;

import BaseUrlDepo.BaseUrlDummySetup;
import TestDataDeposu.TestDataDummyRestApi;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;


import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.unregisterParser;
import static org.junit.Assert.assertEquals;

public class C20_Get_TestDataKullanimi extends BaseUrlDummySetup {
/*Response Body nin asagidaki gibi oldugunu test ediniz...
//GET request gonderdigimiz asagidakileri kontrol ediniz...
     //1)status code 200 oldugunu kontrol edecegiz
    //2)contente type application/json
   //body  asagidaki gibi oldugunu kontrol ediniz...

  {
        "status": "success",
            "data": {
        "id": 3,
                "employee_name": "Ashton Cox",
                "employee_salary": 86000,
                "employee_age": 66,
                "profile_image": ""
    },
        "message": "Successfully! Record has been fetched."
    }
*/    //1)dummy icin URL DEPO olusturacagiz(BASEURL package)
     //URL deposu icerisine BaseURLDummy class olustur...
    //Class'i olusturduktan sonra RequestSpecification objesi olusturunuz...
    //RequestSpecification specDummyRestApi;
    //Objenin adinada specDummyRestApi;
    //@Before annotation olustur...Bu method her test methodundan once caslissin diye hemen yazdik...
    //@Before annotation i junit de kullaniyoruz...

    //@Before
    //public void setup(){

    //Oncelikle extends yapmamiz lazim cunku URL DEPOSUNDAN BASEURL almak icin
    //Ilkin request url ve body olusturunuz

 @Test
    public void t21(){
      specDummyRestApi.pathParams("pp1" , "employee" , "pp2" , 3);


         //Soruda isteniyorsa expected data olustur
      //Test Data deposundaki Test Data  Dummy classinda olusturdugumuz
     //Expected body buraya cagirmak icin Bu classda obeje olusturuyoum...

     TestDataDummyRestApi testDataDummyRestApi = new TestDataDummyRestApi();
     JSONObject expectedData = testDataDummyRestApi.getRequestExpectedDataOlustur();




     //response olustur...request gonderip donen response kaydet...
     //import io.restassured.response.Response;
     //response restassured den import ediyoruz...
     //given() ida more actions uzerine gelip restassured den import ediyoruz...
     //GET request yaptigimiz ve body gondermeyecegimiz icin given dan sonra spec yapip when le devam ediyoruz...
          //Put ile body gonderecek isek given dan sonra
         // spec yapip contente type ve when yapip body le devam edip put yapiyoruz...
     Response response=given().
             spec(specDummyRestApi).
             when().get("/{pp1}/{pp2}");

response.prettyPrint();

  //4. adim Assertion
 //Eger burdaki metotlari kullanmak istiyorsak response jsonpath cevirmemiz lazim...
//Expected dataya json methodlariyla response da jsonpath methodlariyla ulasabilirim...
   //Once expected data sonra actual datayi yazarak karsilastiriyoruz...
//Assert den kurtulmak icin Assert i  sil Alt Enter yap sonra
//junitten import et...

     JsonPath responseJPath = response.jsonPath();

     assertEquals(testDataDummyRestApi.basariliStatusCode , response.getStatusCode());
     assertEquals(testDataDummyRestApi.contentType , response.getContentType());


    assertEquals(expectedData.getString("status") , responseJPath.getString("status"));
    assertEquals(expectedData.getJSONObject("data").getInt("id") , responseJPath.getInt("data.id"));
    assertEquals(expectedData.getJSONObject("data").getString("employee_name") , responseJPath.getString("data.employee_name"));
    assertEquals(expectedData.getJSONObject("data").getInt("employee_salary") , responseJPath.getInt("data.employee_salary"));
    assertEquals(expectedData.getJSONObject("data").getInt("employee_age") , responseJPath.getInt("data.employee_age"));
    assertEquals(expectedData.getJSONObject("data").getString("profile_image") , responseJPath.getString("data.profile_image"));
    assertEquals(expectedData.getString("message"), responseJPath.getString("message"));


 }




}
