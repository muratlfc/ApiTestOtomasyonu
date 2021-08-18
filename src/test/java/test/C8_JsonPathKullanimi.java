package test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;


public class C8_JsonPathKullanimi {

   @Test
    public void jsonObjesiOlusturma(){


       JSONObject kisiBilgisi = new JSONObject();
       JSONObject adresBilgisi = new JSONObject();
       JSONObject cepTelefonu = new JSONObject();
       JSONObject evTel = new JSONObject();

       JSONArray telBilgileri = new JSONArray();

       cepTelefonu.put("type","Cep Telefonu");
       cepTelefonu.put("number","555-1234-2345");


       evTel.put("type","Ev telefonu");
       evTel.put("number","0123-4567-8910");

       telBilgileri.put(cepTelefonu);
       telBilgileri.put(evTel);

       adresBilgisi.put("streetAdress","Yenimahalle kurtulus caddesi");
       adresBilgisi.put("city","Ankara");
       adresBilgisi.put("postalCode","06100");

       kisiBilgisi.put("firstName" , "Ali");
       kisiBilgisi.put("lastName","Bulut");
       kisiBilgisi.put("age",26);
       kisiBilgisi.put("address" , adresBilgisi);
       kisiBilgisi.put("phoneNumbers",telBilgileri);

       System.out.println("isim : " +kisiBilgisi.get("firstName"));

       System.out.println("soyisim : " + kisiBilgisi.get("lastName"));

       System.out.println("Yas : " +kisiBilgisi.get("age"));

       System.out.println("Cadde adresi : " + kisiBilgisi.getJSONObject("address").get("streetAdress"));

      System.out.println("Sehir :" +kisiBilgisi.getJSONObject("address").get("city"));

      System.out.println("Posta Kodu :" + kisiBilgisi.getJSONObject("address").get("postalCode"));

      System.out.println("Cep Tel No :" +
              kisiBilgisi.
              getJSONArray("phoneNumbers").
              getJSONObject(0).get("number"));


      System.out.println("Ev Tel No :" +
                      kisiBilgisi.
                      getJSONArray("phoneNumbers").
                      getJSONObject(1).get("number"));


   }

}
