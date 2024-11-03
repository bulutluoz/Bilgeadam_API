package Tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.module.ResolutionException;

public class C09_Get_ExpectedDataKullanimi {

        /*
        https://jsonplaceholder.typicode.com/posts/22 url'ine
        bir GET request yolladigimizda
        donen response body’sinin asagida verilen ile ayni oldugunu test ediniz

        expected Response body :

        {
        "userId":3,
        "id":22,
        "title":"dolor sint quo a velit explicabo quia nam",
        "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
        }
     */

    @Test
    public void test01(){

        // 1.adim : end point'i belirle ve eger gerekli ise request body olustur
        String endpoint = "https://jsonplaceholder.typicode.com/posts/22";

        // 2.adim : eger gorevde varsa expected response body olustur
        JSONObject expectedResponseJson = new JSONObject();
        expectedResponseJson.put("userId",3);
        expectedResponseJson.put("id",22);
        expectedResponseJson.put("title","dolor sint quo a velit explicabo quia nam");
        expectedResponseJson.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        // 3.adim : request'i yollayip, donen response'i actualResponse olarak kaydet

        Response actualResponse = RestAssured.given()
                                                .when()
                                                .get(endpoint);

        JsonPath actualRespJsonpath = actualResponse.jsonPath();


        // 4.adim : istenen assertion'lari yapin
        // donen actual response body’sinin
        // asagida verilen expected response body ile ayni oldugunu test ediniz
        // artik testlerimizi yavas yavas dinamik hale getirmek istiyoruz
        // expectedResponseJson   <==> actualResponse
        //   JsonOBJECT                  Response / Jsonpath'e cast ettik

        /*
            expectedResponse olarak hazirladigimiz objenin data turu JsonOBJECT
            expectedResponseJson.get("userId")  ==> 3
            expectedResponseJson.get("id") ==> 22
            expectedResponseJson.get("title") ==> "dolor...."

            actualResponse'in data turu ise Response
            ve Response uzerinden bilgi almak mumkun olmayabilir
            bunun yerine
            actualResponse'i kolay bilgi alabilecegimiz
            Jsonpath objesine cast edecegiz

            actualRespJsonpath.getInt("userId") ==> 3
            actualRespJsonpath.getInt("id") ==> 22
            actualRespJsonpath.getString("title") ==> "dolor...
         */

        Assertions.assertEquals(expectedResponseJson.get("userId"),actualRespJsonpath.getInt("userId"));
        Assertions.assertEquals(expectedResponseJson.get("id"),actualRespJsonpath.getInt("id"));
        Assertions.assertEquals(expectedResponseJson.get("title"),actualRespJsonpath.getString("title"));




    }
}










