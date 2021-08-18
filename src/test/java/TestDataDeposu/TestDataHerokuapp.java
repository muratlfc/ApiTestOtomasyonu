package TestDataDeposu;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDataHerokuapp {


        //{
//    "firstname": "Mehmet",
//    "lastname": "Bulut",
//    "totalprice": 500,
//    "depositpaid": false,
//    "bookingdates": {
//        "checkin": "2021-06-01",
//        "checkout": "2021-06-10"
//    }
        public JSONObject getRequestOlustur() {

            JSONObject requestBody = new JSONObject();
            JSONObject innerBody = new JSONObject();

            innerBody.put("checkin", "2021-06-01");
            innerBody.put("checkout", "2021-06-10");

        requestBody.put("firstname", "Mehmet");
        requestBody.put("lastname", "Bulut");
        requestBody.put("totalprice", 500);
        requestBody.put("depositpaid", false);
        requestBody.put("bookingdates", innerBody);
        requestBody.put("additionalneeds", "wi-fi");

        return requestBody;

    }


    public JSONObject postRequestExpectedDataOlustur() {

    JSONObject expectedData = new JSONObject();
    JSONObject bookingBody = new JSONObject();
    JSONObject bookingdatesBody = new JSONObject();



    bookingdatesBody.put("checkin","2021-06-01");
    bookingdatesBody.put("checkout" , "2021-06-10");


        bookingBody.put("firstname" , "Mehmet");
        bookingBody.put("lastname" , "Bulut");
        bookingBody.put("totalprice" ,  500);
        bookingBody.put("depositpaid"  , false);
        bookingBody.put("bookingdates" , bookingdatesBody);
        bookingBody.put("additionalneeds" , "wi-fi");


        expectedData.put("bookingdid" , 24);
        expectedData.put("booking" , bookingBody);


        return expectedData;
    }
public Map<String , Object>requestBodyMapOlustur(){
            /*
            Request body
            {
    	                "firstname" : "Ahmet",
    	                "lastname" : “Bulut",
    	                "totalprice" : 500,
    	                "depositpaid" : false,
    	                "bookingdates" : {
    	                         "checkin" : "2021-06-01",
    	                         "checkout" : "2021-06-10"
    	                                  },
    	                "additionalneeds" : "wi-fi"
    	            }
*/
    Map<String,Object>requestBodyMap=new HashMap<>();

    requestBodyMap.put("firstname","Ahmet");
    requestBodyMap.put("lastname","Bulut");
    requestBodyMap.put("totalprice",500);
    requestBodyMap.put("depositpaid",false);
    requestBodyMap.put("bookingdates",bookingdatesMapOlustur());
    requestBodyMap.put("additionalneeds","wi-fi");





    return requestBodyMap;

        }

public Map<String , Object> bookingdatesMapOlustur(){

            Map<String,Object>bookingdatesMap= new HashMap<>();
            bookingdatesMap.put("checkin","2021-06-01");
            bookingdatesMap.put("checkout","2021-06-10");

            return  bookingdatesMap;
    }

     public Map<String,Object>expectedDataOlustur(){

            /*
            	Response Body // expected data
    	            {
                 1. map   "bookingid":24,
                 2. map   "booking":{ //bookinMap biraz once olusturdugumuz requestBody ile tamamen ayni
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                3. map  "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                        ,
                        "additionalneeds":"wi-fi"
                    }
             */
           //expected datada icice 3 map var ve toplam 9 attribute var
          // ama biz onceki olusturdugumuz metotlari kullanarak
         //sadece 3 SATIRDA expected datayi olusturduk
Map<String,Object>expectedDataMap=new HashMap<>();
expectedDataMap.put("bookingid",24);
expectedDataMap.put("booking",requestBodyMapOlustur());


return expectedDataMap;
    }

}




