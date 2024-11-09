package Tests;

import TestDataClasslari.JphTestDataClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class C19_Post_DeSerialization extends JphTestDataClass {

    /*
           https://jsonplaceholder.typicode.com/posts  url’ine
           asagidaki body ile bir POST request gonderdigimizde
           {
             "title":"API",
             "body":"API ogrenmek ne guzel",
             "userId":10,
             }
           donen Response’un,
             status code’unun 201,
             ve content type’inin application/json
             ve Response Body'sindeki,
                  "title"'in "API" oldugunu
                  "userid" degerinin 100'den kucuk oldugunu
                  "body" nin "API" kelimesi icerdigini test edin.
     */

    @Test
    public void test01(){

        // 1.adim : end point'i belirle ve eger gerekli ise request body olustur
        String endpoint = baseUrl;
        postRequestBodyMapOlustur("API","API ogrenmek ne guzel",10);


        // 2.adim : eger gorevde varsa expected response body olustur
        // 3.adim : request'i yollayip, donen response'i actualResponse olarak kaydet
        Response actualResponse = RestAssured
                                        .given().contentType(ContentType.JSON)
                                        .when().body(postRequestBodyMap)
                                        .post(endpoint);


        /*
        {
            "title": "API",
            "body": "API ogrenmek ne guzel",
            "userId": 10,
            "id": 101
        }
         */

        // 4.adim : istenen assertion'lari yapin


        //status code’unun 201,
        Assertions.assertEquals(201,actualResponse.statusCode());
        //             ve content type’inin application/json
        Assertions.assertEquals("application/json; charset=utf-8" , actualResponse.getContentType());

        //             ve Response Body'sindeki,
        //  actual response bir Response objesi
        //  eger Map ile calismak istiyorsak
        //  actual response'i Map'e cevirmeliyiz

        Map<String,Object>  actualResponseMap = actualResponse.as(HashMap.class);
        // {id=101.0, title=API, body=API ogrenmek ne guzel, userId=10.0}


        //                  "title"'in "API" oldugunu
        Assertions.assertEquals("API", actualResponseMap.get("title"));
        //                  "userid" degerinin 100'den kucuk oldugunu
        Assertions.assertTrue((Double)actualResponseMap.get("userId") < 100);

        //                  "body" nin "API" kelimesi icerdigini test edin.
        Assertions.assertTrue(   ((String)actualResponseMap.get("body")).contains("API")    );

    }



}
