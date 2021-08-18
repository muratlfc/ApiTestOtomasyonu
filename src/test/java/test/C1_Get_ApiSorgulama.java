package test;


import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;


public class C1_Get_ApiSorgulama {

     @Test
     public void get01(){

         String url = "https://restful-booker.herokuapp.com/booking/10";



         Response response = given().when().get(url);
         response.prettyPrint();
         System.out.println( "Status Code :" +response.getStatusCode());
         System.out.println( "Content Type :" +response.contentType());
         System.out.println("Server Header degeri : " + response.getHeader("Server"));
         System.out.println("Date : " + response.getHeader("Date"));
         System.out.println("Status Line :" + response.statusLine());

         System.out.println("Response suresi:" + response.getTime());
     }














}
