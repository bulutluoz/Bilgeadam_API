package Tests;

import TestDataClasslari.JphTestDataClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class C18_Put_DeSerialization extends JphTestDataClass {

     /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine
    asagidaki body’e sahip bir PUT request yolladigimizda
    donen response’in response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Request Body

        {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
        }

        Expected Response Body:

        {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
        }
     */

    @Test
    public void test01(){

        // Sirketin bizden Map ile calismamizi istedigini varsayiyoruz

        // 1.adim : end point'i belirle ve eger gerekli ise request body olustur
        String endpoint = baseUrl + "/70";
        requestBodyMapOlustur("Ahmet","Merhaba",10,70);

        // 2.adim : eger gorevde varsa expected response body olustur
        expectedResponseBodyMapOlustur("Ahmet","Merhaba",10.0,70.0);

        // 3.adim : request'i yollayip, donen response'i actualResponse olarak kaydet

        Response actualResponse = RestAssured
                                    .given().contentType(ContentType.JSON)
                                    .when().body(requestBodyMap)
                                    .put(endpoint);

        // 4.adim : istenen assertion'lari yapin
        responseIleMapExpectedBodyAssertion(actualResponse,expectedResponseMapBody);
    }

}
