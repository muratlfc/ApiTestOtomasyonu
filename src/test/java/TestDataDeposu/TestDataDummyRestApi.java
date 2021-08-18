package TestDataDeposu;

import org.json.JSONObject;

import java.util.HashMap;

public class TestDataDummyRestApi {
        public int basariliStatusCode = 200;
        public String contentType = "application/json";

        public JSONObject getRequestExpectedDataOlustur() {

                JSONObject expectedData = new JSONObject();
                JSONObject databody = new JSONObject();

                databody.put("id", 3);
                databody.put("employee_name", "Ashton Cox");
                databody.put("employee_salary", 86000);
                databody.put("employee_age", 66);
                databody.put("profile_image", "");

                expectedData.put("status", "success");
                expectedData.put("data", databody);
                expectedData.put("message", "Successfully! Record has been fetched.");


                return expectedData;
        }

        public HashMap<String , Object> expectedDataMapOlustur() {

                HashMap<String, Object> expectedDataMap = new HashMap<>();
                HashMap<String, Object> innerMap = new HashMap<>();

                innerMap.put("id", 3);
                innerMap.put("employee_name", "Ashton Cox");
                innerMap.put("employee_salary", 86000);
                innerMap.put("employee_age", 3);
                innerMap.put("profile_image", "");

                expectedDataMap.put("status" , "success");
                expectedDataMap.put("data", innerMap);
                expectedDataMap.put("message" , "Successfully! Record has been fetched.");
                return expectedDataMap;//53.55 kaldik
        }
}


