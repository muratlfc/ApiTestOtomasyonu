package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class C7_Get_BodyTekrarlardanKurtulma {

@Test
    public void get01(){


    String url = "https://restful-booker.herokuapp.com/booking/10";



    Response response=given().when().get(url);
    response.prettyPrint();



    response.then().assertThat().
            statusCode(200).contentType(ContentType.JSON).

//bodyleri tek tek yazmiyorum bir kez yaziyorum.
//Matchers lari siliyorum.
//equalTo lari import ediyorum Matcher.equalTo sec ve importu bu hale getir
// import static org.hamcrest.Matchers.*;


            body ("firstname", equalTo("Eric"),
            "lastname",equalTo("Wilson"),
            "totalprice",equalTo(378),
            "depositpaid",equalTo(false),
            "additionalneeds",equalTo("Breakfast"));









}


}
