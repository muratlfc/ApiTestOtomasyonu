package test;


import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class $C_12_Post_ExpectedDataVeJsonPathAssertion {

    @Test
    public void postTest(){
        String url="https://restful-booker.herokuapp.com/booking";

        JSONObject requestBody = new JSONObject();
        JSONObject innerBody = new JSONObject();

        innerBody.put("checkin","2021-06-01");
        innerBody.put("checkout","2021-06-10");

        requestBody.put("firstname","Ahmet");
        requestBody.put("lastname","Bulut");
        requestBody.put("totalprice",500);
        requestBody.put("depositpaid",false);
        requestBody.put("bookingdates",innerBody);
        requestBody.put("additionalneeds","wi-fi");


        JSONObject bookindatesBody = new JSONObject();
        JSONObject bookingBody = new JSONObject();
        JSONObject exData = new JSONObject();

        bookindatesBody.put("checkin","2021-06-01");
        bookindatesBody.put("checkout","2021-06-10");

        bookingBody.put("firstname","Ahmet");
        bookingBody.put("lastname","Bulut");
        bookingBody.put("totalprice",500);
        bookingBody.put("depositpaid",false);
        bookingBody.put("bookingdates",bookindatesBody);
        bookingBody.put("additionalneeds","wi-fi");

        exData.put("bookingid",24);
        exData.put("booking",bookingBody);

        Response response=
                given().
                contentType(ContentType.JSON).
                when().
                body(requestBody.toString()).
                post(url);
        response.prettyPrint();


        JsonPath responseJsonPath= response.jsonPath();
        Assert.assertEquals
                (exData.getJSONObject("booking").get("firstname") ,
                responseJsonPath.get("booking.firstname"));
        Assert.assertEquals(exData.getJSONObject("booking").get("lastname"),responseJsonPath.get("booking.lastname"));
        Assert.assertEquals(exData.getJSONObject("booking").get("totalprice"),responseJsonPath.get("booking.totalprice"));
        Assert.assertEquals(exData.getJSONObject("booking").get("depositpaid"),responseJsonPath.get("booking.depositpaid"));
        Assert.assertEquals(exData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),responseJsonPath.get("booking.bookingdates.checkin"));
        Assert.assertEquals(exData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),responseJsonPath.get("booking.bookingdates.checkout"));
        Assert.assertEquals(exData.getJSONObject("booking").get("additionalneeds"),responseJsonPath.get("booking.additionalneeds"));
    }
}
