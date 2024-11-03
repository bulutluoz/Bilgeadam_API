package Tests;

import TestDataClasslari.JphTestDataClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class C12_Get_TestDataKullanimi extends JphTestDataClass {

     /*
        https://jsonplaceholder.typicode.com/posts/40 url'ine
        bir GET request yolladigimizda
        donen response’in
            status kodunun 200
            ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Response body :
        {
            "userId":4,
            "id":40,
            "title":"enim quo cumque",
            "body":"ut voluptatum aliquid illo tenetur nemo sequi quo facilis\nipsum rem optio mollitia quas\nvoluptatem eum voluptas qui\nunde omnis voluptatem iure quasi maxime voluptas nam"
        }
     */

    @Test
    public void test01(){

        // 1.adim : end point'i belirle ve eger gerekli ise request body olustur

        String endpoint = baseUrl + "/40";

        // 2.adim : eger gorevde varsa expected response body olustur

        String body ="ut voluptatum aliquid illo tenetur nemo sequi quo facilis\nipsum rem optio mollitia quas\nvoluptatem eum voluptas qui\nunde omnis voluptatem iure quasi maxime voluptas nam";
        expectedResponseJsonObjectOlustur(4,40,"enim quo cumque",body);

        // 3.adim : request'i yollayip, donen response'i actualResponse olarak kaydet

        Response actualResponse = RestAssured.given()
                                                .when()
                                                .get(endpoint);

        // 4.adim : istenen assertion'lari yapin

        //status kodunun 200
        Assertions.assertEquals(basariliSorguStatusKodu,actualResponse.statusCode());

        //ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

        responseAssertionYap(expectedResponseJsonObject,actualResponse);

    }





}
