package Tests;

import TestDataClasslari.JphTestDataClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class C11_Get_TestDataKullanimi extends JphTestDataClass {

     /*
        https://jsonplaceholder.typicode.com/posts/22 url'ine
        bir GET request yolladigimizda
        donen response’in
            status kodunun 200
            ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Response body :
        {
            "userId":3,
            "id":22,
            "title":"dolor sint quo a velit explicabo quia nam",
            "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
                         um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
        }
     */

    @Test
    public void test01(){

        // 1.adim : end point'i belirle ve eger gerekli ise request body olustur
        String endpoint = baseUrl + "/22";

        // 2.adim : eger gorevde varsa expected response body olustur

        String title = "dolor sint quo a velit explicabo quia nam";
        String body = "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear\n" +
                "                         um mollitia molestiae aut atque rem suscipit\nnam impedit esse";
        expectedResponseJsonObjectOlustur(3,22,title,body);

        // 3.adim : request'i yollayip, donen response'i actualResponse olarak kaydet

        Response actualResponse = RestAssured.given()
                                                .when()
                                                .get(endpoint);


        // 4.adim : istenen assertion'lari yapin

        //status kodunun 200
        Assertions.assertEquals(
                basariliSorguStatusKodu,
                actualResponse.statusCode()
        );

        //ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
        // expectedResponseJsonobject <==> actualResponse

        responseAssertionYap(expectedResponseJsonObject,actualResponse);


    }




}
