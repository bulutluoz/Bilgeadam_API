package Tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;

public class C04_Put_ResponseBilgileriAssertion {

    @Test
    public void test01(){

        /*
            https://jsonplaceholder.typicode.com/posts/70 url’ine
            asagidaki Json formatindaki body ile bir PUT request gonderdigimizde

                    {
                    "title":"Ahmet",
                    "body":"Merhaba",
                    "userId":10,
                    "id":70
                    }
            donen Response’un,
                status code’unun 200,
                ve content type’inin application/json; charset=utf-8,
                ve Server isimli Header’in degerinin cloudflare,
                ve status Line’in HTTP/1.1 200 OK
         */


        // 1.adim : end point'i belirle ve eger gerekli ise request body olustur

        String endpoint = "https://jsonplaceholder.typicode.com/posts/70";

        JSONObject requestBody = new JSONObject();
        requestBody.put("title","Ahmet");
        requestBody.put("body","Merhaba");
        requestBody.put("userId",10);
        requestBody.put("id",70);


        // 2.adim : eger gorevde varsa expected response body olustur

        // 3.adim : request'i yollayip, donen response'i actualData olarak kaydet

        Response actualResponse = given().contentType(ContentType.JSON)
                                        .when().body(requestBody.toString())
                                        .put(endpoint);

        // 4.adim : istenen assertion'lari yapin

        //                status code’unun 200,
        //                ve content type’inin application/json; charset=utf-8,
        //                ve Server isimli Header’in degerinin cloudflare,
        //                ve status Line’in HTTP/1.1 200 OK

        actualResponse
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","cloudflare")
                .statusLine("HTTP/1.1 200 OK");

    }
}
