package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C4_Put_ResponseBilgileriAssertion {

 @Test
    public void test1() {

     String url = "https://jsonplaceholder.typicode.com/posts/70";


     JSONObject reqBody = new JSONObject();
     reqBody.put("title", "Ahmet");
     reqBody.put("body", "Merhaba");
     reqBody.put("userId", 10);
     reqBody.put("id", 70);

     Response response = given().contentType(ContentType.JSON).
             when().body(reqBody.toString()).
             put(url);


     response.then().assertThat().
             statusCode(200).
             contentType(ContentType.JSON).
             header("Server","cloudflare").
             statusLine("HTTP/1.1 200 OK");

 }

}
