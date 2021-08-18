package test;


import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C11_Get_ExpectedDataOlusturma {

    @Test
    public void getTest01(){
        String url = "https://jsonplaceholder.typicode.com/posts/22";

        JSONObject exData = new JSONObject();
        exData.put("userId",3);
        exData.put("id",22);
        exData.put("title","dolor sint quo a velit explicabo quia nam");
        exData.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");


        Response response =given().when().get(url);
        response.prettyPrint();

        //Response JsonPath objesine cevir
        JsonPath resJPath =response.jsonPath();



        Assert.assertEquals(exData.get("userId"),resJPath.get("userId"));
        Assert.assertEquals(exData.get("id"),resJPath.get("id"));
        Assert.assertEquals(exData.get("title"),resJPath.get("title"));
        Assert.assertEquals(exData.get("body"),resJPath.get("body"));

    }
}
