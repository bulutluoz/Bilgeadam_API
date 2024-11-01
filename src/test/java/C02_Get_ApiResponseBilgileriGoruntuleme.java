
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;

public class C02_Get_ApiResponseBilgileriGoruntuleme {

    @Test
    public void aciklamaOlmadanTest(){

        String endPoint = "https://restful-booker.herokuapp.com/booking/10";

        Response actualResponse = given()
                                        .when()
                                        .get(endPoint);

        actualResponse
                    .then()
                    .assertThat().statusCode(200)
                    .contentType("application/json; charset=utf-8")
                    .header("Server","Cowboy");
    }


    @Test
    public void test01(){

        //  https://restful-booker.herokuapp.com/booking/10 url’ine
        //  bir GET request gonderdigimizde donen Response’un,


        // 1.adim : end point'i belirle ve eger gerekli ise request body olustur
        String endPoint = "https://restful-booker.herokuapp.com/booking/10";

        // 2.adim : eger gorevde varsa expected response body olustur

        // 3.adim : request'i yollayip, donen response'i actualData olarak kaydet
        Response actualResponse = given()
                                    .when()
                                    .get(endPoint);

        // actualResponse.prettyPrint();
        // gorevde yazdirma olmadigi icin
        // testi olustururken gormek amaciyla yazdirabiliriz ama sonra silmeliyiz

        /*
            {
                "firstname": "Susan",
                "lastname": "Wilson",
                "totalprice": 341,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2023-09-29",
                    "checkout": "2024-08-14"
                }
            }
         */


        // 4.adim : istenen assertion'lari yapin

        // 	status code’unun 200,
        //	ve content type’inin application/json; charset=utf-8,
        //	ve Server isimli Header’in degerinin Cowboy,
        //	ve status Line’in HTTP/1.1 200 OK
        //	ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.

        actualResponse
                .then()
                .assertThat().statusCode(200)
                             .contentType("application/json; charset=utf-8")
                             .header("Server","Cowboy");




    }
}
