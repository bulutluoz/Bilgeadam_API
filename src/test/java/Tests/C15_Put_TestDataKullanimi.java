package Tests;

import TestDataClasslari.HerokuTestDataClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.lang.module.ResolutionException;

public class C15_Put_TestDataKullanimi extends HerokuTestDataClass {

    /*
        https://restful-booker.herokuapp.com/booking url’ine
        "Kemal", "Brown", 200, true, "2025-02-01", "2025-02-10", "wifi"
        bilgilerine sahip bir POST request gonderdigimizde
        donen response’un id haric yukardaki bilgilere sahip
        standart response oldugunu test edin

     */

    @Test
    public void test01(){

        // 1.adim : end point'i belirle ve eger gerekli ise request body olustur

        String endpoint = baseUrl + "/booking";
        requestBodyJsonObjectOlustur("Kemal", "Brown", 200, true, "2025-02-01", "2025-02-10", "wifi");

        // 2.adim : eger gorevde varsa expected response body olustur
        expectedResponseJsonObjectOlustur("Kemal", "Brown", 200, true, "2025-02-01", "2025-02-10", "wifi");

        // 3.adim : request'i yollayip, donen response'i actualResponse olarak kaydet
        Response actualResponse = RestAssured.given().contentType(ContentType.JSON)
                                                .when().body(requestBody.toString())
                                                .post(endpoint);

        // 4.adim : istenen assertion'lari yapin
        responseAssertionYap(expectedResponseJsonObject,actualResponse);
    }
}
