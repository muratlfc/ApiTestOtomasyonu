package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C10_Get_ResponseBodyTestiListKullanimi {

@Test
    public void gettest01(){
    String url = "http://dummy.restapiexample.com/api/v1/employees";

    Response response = given().when().get(url);
    response.prettyPrint();

    response.then().assertThat().
            statusCode(200).
            contentType(ContentType.JSON).
            body("data.id", hasSize(24),
                    "data.employee_name",hasItem("Ashton Cox"),
                    "data.employee_age",hasItems(61,30,40));







}


}
