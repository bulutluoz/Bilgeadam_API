import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
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


        // 4.adim : istenen assertion'lari yapin
        // donen actual response body’sinin
        // asagida verilen expected response body ile ayni oldugunu test ediniz





    }
}










