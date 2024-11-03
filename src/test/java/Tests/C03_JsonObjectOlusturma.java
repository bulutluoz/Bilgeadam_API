package Tests;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;


public class C03_JsonObjectOlusturma {

    @Test
    public void test01(){
        /*

                JSonObje'leri data turu acisindan esnek oldugu,
                ayni bilgileri baska formatlara gore daha az data boyutuyla tasidigi icin
                gunumuzde en cok tercih edilen data turudur

                EGER ic ice birden fazla JsonObject varsa
                once ictekileri olusturup
                sonra distaki JSonObje'ye gecmek gerekir.
         */

        /*
                {
                     "firstname":"Jim",
                     "additionalneeds":"Breakfast",
                     "bookingdates":{
                                        "checkin":"2018-01-01",
                                        "checkout":"2019-01-01"
                                   },
                      "totalprice":111,
                      "depositpaid":true,
                      "lastname":"Brown"
                 }

         */

        JSONObject bookingdatesJsonObject = new JSONObject();
        bookingdatesJsonObject.put("checkin","2018-01-01");
        bookingdatesJsonObject.put("checkout","2019-01-01");

        JSONObject rezervasyonJsonObject = new JSONObject();
        rezervasyonJsonObject.put("firstname","Jim");
        rezervasyonJsonObject.put("additionalneeds","Breakfast");
        rezervasyonJsonObject.put("bookingdates",bookingdatesJsonObject);
        rezervasyonJsonObject.put("totalprice",111);
        rezervasyonJsonObject.put("depositpaid",true);
        rezervasyonJsonObject.put("lastname","Brown");


        System.out.println(rezervasyonJsonObject.toString());
        // {"firstname":"Jim","additionalneeds":"Breakfast","bookingdates":{"checkin":"2018-01-01","checkout":"2019-01-01"},"totalprice":111,"depositpaid":true,"lastname":"Brown"}

        /*
                { "firstname":"Jim",
                  "additionalneeds":"Breakfast",
                  "bookingdates":{
                                    "checkin":"2018-01-01",
                                    "checkout":"2019-01-01"},
                  "totalprice":111,
                  "depositpaid":true,
                  "lastname":"Brown"
                  }
         */


    }
}
