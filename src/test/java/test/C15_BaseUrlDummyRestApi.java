package test;

import BaseUrlDepo.BaseUrlJsonPlaceHolder;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C15_BaseUrlDummyRestApi extends BaseUrlJsonPlaceHolder {

    @Test
    public void test01() {

        //String url = "https://jsonplaceholder.typicode.com"; } //Artik kullanmiyoruz dinamik hale getiriyoruz.


        specJsonPlace.pathParam("pathparametresi1", "posts");


        Response response = given().spec(specJsonPlace).
                when().
                get("/{pathparametresi1}");
        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                body("title", Matchers.hasSize(100));
    }

    @Test
    public void test2() {

        specJsonPlace.pathParams("pathparametresi1",
                "posts",
                "pathparametresi2", 44);


        Response response = given().spec(specJsonPlace).
                when().get("/{pathparametresi1}/{pathparametresi2}");

        response.then().
                assertThat().
                statusCode(200).
                body("title", Matchers.equalTo("optio dolor molestias sit"));

    }

    @Test
    public void test03() {

        specJsonPlace.pathParams("pathparametresi1",
                "posts",
                "pathparametresi2", 50);


        Response response = given().spec(specJsonPlace).
                when().
                delete("/{pathparametresi1}/{pathparametresi2}");

        response.prettyPrint();

    response.then().assertThat().statusCode(200).body("id",Matchers.nullValue());





    }


}
