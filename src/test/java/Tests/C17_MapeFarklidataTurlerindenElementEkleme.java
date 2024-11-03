package Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class C17_MapeFarklidataTurlerindenElementEkleme {

    @Test
    public void test01(){

        /*
            Asagidaki degerlere sahip bir map olusturun

             {
                "firstname" : "Hasan",
                "lastname" : "Yagmur",
                "totalprice" : 500,
                "depositpaid" : false,
              }
         */

        Map<String,Object > requestMap = new HashMap<>();

        requestMap.put("firstname","Hasan");
        requestMap.put("lastname","Yagmur");
        requestMap.put("totalprice",500);
        requestMap.put("depositpaid",false);

        System.out.println(requestMap);
        // {firstname=Hasan, totalprice=500, depositpaid=false, lastname=Yagmur}


        // fiyatin 300'den buyuk oldugunu test edin

        Assertions.assertTrue( (Integer)requestMap.get("totalprice") > 300  );


        // ismin uzunlugunun soyismin uzunlugundan kisa oldugunu test edin

        int isminUzunlugu = ((String)requestMap.get("firstname")).length();
        int soyisminUzunlugu = ((String)requestMap.get("lastname")).length();

        Assertions.assertTrue(isminUzunlugu<soyisminUzunlugu);



        // depositpaid true ise "kapora odediginiz icin tesekkurler" yazdirin,
        // false ise "kapora odemediginizi hatirlatmak istiyorum" yazdirin

        if ( (Boolean)requestMap.get("depositpaid") ){ // == true

            System.out.println("kapora odediginiz icin tesekkurler");
        } else System.out.println("kapora odemediginizi hatirlatmak istiyorum");

    }


}
