package test;

import org.json.JSONObject;
import org.junit.Test;


public class C3_JsonObjesiOlusturma {

    @Test
    public void jsonObje1() {

        JSONObject ilkJsonObje = new JSONObject();
        ilkJsonObje.put("title", "Ahmet");
        ilkJsonObje.put("body", "Merhaba");
        ilkJsonObje.put("userId", 1);
        System.out.println(ilkJsonObje);

    }

    @Test
    public void jsonObje2() {
        JSONObject ikinciJsonObje = new JSONObject();
        JSONObject innerJson = new JSONObject();

        innerJson.put("checkin", "2018-01-01");
        innerJson.put("checkout", "2019-01-01");


        ikinciJsonObje.put("firstname", "Jim");
        ikinciJsonObje.put("additionalneeds", "Breakfast");
        ikinciJsonObje.put("bookingdates", innerJson);
        ikinciJsonObje.put("totalprice" ,111);
        ikinciJsonObje.put("depositpaid" , true);
        ikinciJsonObje.put("lastname" , "Brown");


        System.out.println(ikinciJsonObje);
    }
}
