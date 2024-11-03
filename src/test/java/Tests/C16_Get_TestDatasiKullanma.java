package Tests;

import TestDataClasslari.ReqresTestDataClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class C16_Get_TestDatasiKullanma {

    /*
        Jsonplaceholde ve Herokuapp api'larinda
        Test data class'larini extends yaparak kullandik

        extends yapmanin avantaji, icinde oldugumuz class'da
        yeniden variable veya method olusturmadan
        parent class'daki variable ve method'lari
        DIREKT olarak kullanabilmektir.

        AMMMAAA
        eger calistigimiz class baska bir class'a da extends etmek zorunda ise
        Java'da multiple inheritance olmadigindan
        Test data class'ina extends edemeyebiliriz

        bu durumda
        test data class'indaki variable ve method'lara
        static olmasina gore class ismi ile veya object olusturarak ulasabiliriz

        ayrica o class'dan gelen bilgileri
        calistigimiz class'da olusturacagimiz bir variable'a atamamiz gerekir
     */

    /*

        https://reqres.in/api/users/1 url'ine bir GET request yolladigimizda
        donen response'in
        - status kodunun 200
        - Content type'in apllication json
        - Server header'inin degerinin cloudflare
        ve response body'sinin asagidaki gibi oldugunu test edin

        {
            "data": {
                "id": 1,
                "email": "george.bluth@reqres.in",
                "first_name": "George",
                "last_name": "Bluth",
                "avatar": "https://reqres.in/img/faces/1-image.jpg"
               },
            "support": {
                "url": "https://reqres.in/#support-heading",
                "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
               }
        }

     */


    @Test
    public void test01(){


        // 1.adim : end point'i belirle ve eger gerekli ise request body olustur

        String endpoint = ReqresTestDataClass.baseUrl+ "/users/1";

        // 2.adim : eger gorevde varsa expected response body olustur


        String url = "https://reqres.in/#support-heading";
        String text =  "To keep ReqRes free, contributions towards server costs are appreciated!";

        JSONObject expectedResponseBody = ReqresTestDataClass.expectedResponseBodyJsonOlustur(1,"george.bluth@reqres.in",
                "George","Bluth","https://reqres.in/img/faces/1-image.jpg",url,text);


        // 3.adim : request'i yollayip, donen response'i actualResponse olarak kaydet

        Response actualResponse = RestAssured.given()
                                                .when()
                                                .get(endpoint);


        // 4.adim : istenen assertion'lari yapin

        ReqresTestDataClass.responseAssertYap(expectedResponseBody,actualResponse);

    }


}
