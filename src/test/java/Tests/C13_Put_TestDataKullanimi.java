package Tests;

import TestDataClasslari.JphTestDataClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class C13_Put_TestDataKullanimi extends JphTestDataClass {

     /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine
        asagidaki body’e sahip bir PUT request yolladigimizda
        donen response’in
            status kodunun 200,
            content type’inin “application/json; charset=utf-8”,
            Connection header degerinin “keep-alive”
            ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
         Request Body
            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
        Response body (Expected Data) :
            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
     */

    @Test
    public void test01(){

        // 1.adim : end point'i belirle ve eger gerekli ise request body olustur

        String endpoint = baseUrl + "/70";
        // her ne kadar request body ile expected Response Body ayni olsa da
        // olusturulan obje ve kullanilan method'un farkli olmasi daha guzel olur
        requestBodyJsonObjectOlustur(10,70,"Ahmet","Merhaba");


        // 2.adim : eger gorevde varsa expected response body olustur
        expectedResponseJsonObjectOlustur(10,70,"Ahmet","Merhaba");

        // 3.adim : request'i yollayip, donen response'i actualResponse olarak kaydet

        Response actualResponse = RestAssured.given().contentType(ContentType.JSON)
                                        .when().body(requestBodyJsonObject.toString())
                                        .put(endpoint);

        // 4.adim : istenen assertion'lari yapin

        //            status kodunun 200,
        Assertions.assertEquals(basariliSorguStatusKodu,actualResponse.statusCode());

        //            content type’inin “application/json; charset=utf-8”,
        Assertions.assertEquals(responseContentType,actualResponse.getContentType());

        //            Connection header degerinin “keep-alive”
        Assertions.assertEquals(responseConnectionHeaderValue,actualResponse.getHeader("Connection"));

        //            ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
        responseAssertionYap(expectedResponseJsonObject,actualResponse);



    }


}
