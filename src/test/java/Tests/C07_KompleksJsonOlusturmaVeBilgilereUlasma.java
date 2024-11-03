package Tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class C07_KompleksJsonOlusturmaVeBilgilereUlasma {

    @Test
    public void test01(){

        JSONObject evTelJsonObj= new JSONObject();
        evTelJsonObj.put("type","home");
        evTelJsonObj.put("number","0123-4567-8910");

        JSONObject cepTelJsonObj= new JSONObject();
        cepTelJsonObj.put("type","iPhone");
        cepTelJsonObj.put("number","0123-4567-8888");


        JSONArray telefonBilgileriArr= new JSONArray();
        telefonBilgileriArr.put(evTelJsonObj);
        telefonBilgileriArr.put(cepTelJsonObj);


        JSONObject adresJsonObj= new JSONObject();
        adresJsonObj.put("streetAddress","naist street");
        adresJsonObj.put("city","Nara");
        adresJsonObj.put("postalCode","630-0192");

        JSONObject kisiselBilgiler = new JSONObject();
        kisiselBilgiler.put("firstName","John");
        kisiselBilgiler.put("lastname" ,"Doe");
        kisiselBilgiler.put("age",26);
        kisiselBilgiler.put("adress",adresJsonObj);
        kisiselBilgiler.put("phoneNumbers",telefonBilgileriArr);

        System.out.println(kisiselBilgiler);


        /*
            { "firstName":"John",
              "adress":{
                        "streetAddress":"naist street",
                        "city":"Nara",
                        "postalCode":"630-0192"
                        },
               "age":26,
               "phoneNumbers":
                 [
                    {
                     "number":"0123-4567-8910",
                     "type":"home"
                     },
                     {
                     "number":"0123-4567-8888",
                     "type":"iPhone"
                     }
                   ],
                "lastname":"Doe"
                }
         */
        System.out.println(kisiselBilgiler.getString("firstName")); // John
        System.out.println(kisiselBilgiler.getJSONObject("adress").getString("postalCode")); // 630-0192

        System.out.println(kisiselBilgiler.getJSONArray("phoneNumbers")
                                            .getJSONObject(1)
                                            .getString("number")); // 0123-4567-8888

        // jsonPath kullansaydik ==> phoneNumbers[1].number

    }
}
