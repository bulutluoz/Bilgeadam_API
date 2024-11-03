package Tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class C06_Post_ResponseBodyTesti {

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
        String endPoint = "https://jsonplaceholder.typicode.com/posts";

        JSONObject requestBody = new JSONObject();
        requestBody.put("title","API");
        requestBody.put("body" , "API ogrenmek ne guzel");
        requestBody.put("userid",10);

        // 2.adim : eger gorevde varsa expected response body olustur

        // 3.adim : request'i yollayip, donen response'i actualResponse olarak kaydet

        Response actualResponse = RestAssured.given().contentType(ContentType.JSON)
                                                .when().body(requestBody.toString())
                                                .post(endPoint);


        // 4.adim : istenen assertion'lari yapin
        // status code’unun 201,
        //             ve content type’inin application/json
        //             ve Response Body'sindeki,
        //                  "title"'in "API" oldugunu
        //                  "userid" degerinin 100'den kucuk oldugunu
        //                  "body" nin "API" kelimesi icerdigini test edin.


        actualResponse.then()
                        .assertThat()
                        .statusCode(201)
                        .contentType(ContentType.JSON)
                        .body("title", Matchers.equalTo("API"))
                        .body("userid",Matchers.lessThan(100))
                        .body("body",Matchers.containsString("API"));


        // Eger assertion'lari yaparken tekrar tekrar body ve Matchers yazmak istemezseniz

        actualResponse.then()
                .assertThat()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body(
                    "title",equalTo("API")  ,
                    "userid",lessThan(100),
                    "body",containsString("API")
                );

    }
}
