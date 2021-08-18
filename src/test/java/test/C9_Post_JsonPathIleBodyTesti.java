package test;

import io.restassured.http.ContentType;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class C9_Post_JsonPathIleBodyTesti {

    @Test
    public void post01(){

        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject reqBody = new JSONObject();
        JSONObject bookingJsonObj = new JSONObject();

        bookingJsonObj.put("checkin","2020-06-13");
        bookingJsonObj.put("checkout","2021-01-29");

        reqBody.put("firstname","Ali");
        reqBody.put("lastname","Veli");
        reqBody.put("totalprice",106);
        reqBody.put("depositpaid",false);
        reqBody.put("bookingdates",bookingJsonObj);


      Response response = given().contentType(ContentType.JSON).
              when().body(reqBody.toString()).
              post(url);

response.prettyPrint();

      response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
              body("booking.firstname",equalTo("Ali"),
                     "booking.lastname",equalTo("Veli"),
                      "booking.totalprice",equalTo(106),
                     "booking.bookingdates.checkin",equalTo("2020-06-13"),
                      "booking.bookingdates.checkout",equalTo("2021-01-29"));


}

}