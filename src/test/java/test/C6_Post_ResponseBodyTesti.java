package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C6_Post_ResponseBodyTesti {

    @Test
    public void post01(){


        String url = "https://jsonplaceholder.typicode.com/posts";

        JSONObject reqBody = new JSONObject();
        reqBody.put("title" , "Api");
        reqBody.put("body","API ogrenmek guzel");
        reqBody.put("userId", 10);



        Response response = given().contentType(ContentType.JSON).
                            when().body(reqBody.toString()).
                            post(url);

response.prettyPrint();



            response.then().assertThat().
                    statusCode(201).
                    contentType(ContentType.JSON).
                    body("title", Matchers.equalTo("Api")).
                    body("userId" , Matchers.lessThan(100)).
                    body("body",Matchers.containsString("API"));

    }





}
