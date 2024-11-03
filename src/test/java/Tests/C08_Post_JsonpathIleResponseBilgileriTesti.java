package Tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class C08_Post_JsonpathIleResponseBilgileriTesti {
    /*
            https://restful-booker.herokuapp.com/booking url’ine
            asagidaki body'ye sahip bir POST request gonderdigimizde
              {
                "firstname" : "Ahmet",
                "lastname" : “Bulut",
                "totalprice" : 500,
                "depositpaid" : false,
                "bookingdates" : {
                        "checkin" : "2023-01-10",
                        "checkout" : "2023-01-20"
                        },
                 "additionalneeds" : "wi-fi"
                 }

              donen Response’un,
              status code’unun 200,
              ve content type’inin application-json,
              ve response body’sindeki
                   "firstname“in,"Ahmet",
                   ve "lastname“in, "Bulut",
                   ve "totalprice“in,500,
                   ve "depositpaid“in,false,
                   ve "checkin" tarihinin 2025-01-10
                   ve "checkout" tarihinin 2025-01-20
                   ve "additionalneeds“in,"wi-fi"
              oldugunu test edin


     */

    @Test
    public void test01(){

        // 1.adim : end point'i belirle ve eger gerekli ise request body olustur
        String endpoint = "https://restful-booker.herokuapp.com/booking";

        JSONObject bookingdatesJsonObject = new JSONObject();
        bookingdatesJsonObject.put("checkin","2025-01-10");
        bookingdatesJsonObject.put("checkout","2025-01-20");

        JSONObject requestBody = new JSONObject();
        requestBody.put("firstname","Ahmet");
        requestBody.put("additionalneeds","wi-fi");
        requestBody.put("bookingdates",bookingdatesJsonObject);
        requestBody.put("totalprice",500);
        requestBody.put("depositpaid",false);
        requestBody.put("lastname","Bulut");

        // 2.adim : eger gorevde varsa expected response body olustur

        // 3.adim : request'i yollayip, donen response'i actualResponse olarak kaydet

        Response actualResponse = RestAssured.given().contentType(ContentType.JSON)
                                              .when().body(requestBody.toString())
                                              .post(endpoint);


        // 4.adim : istenen assertion'lari yapin

        //                   ve "additionalneeds“in,"wi-fi"

        actualResponse.then()
                        .assertThat()
                        .statusCode(200)
                        .contentType(ContentType.JSON)
                        .body(
                       "booking.firstname", Matchers.equalTo("Ahmet"),
                        "booking.lastname",Matchers.equalTo("Bulut"),
                        "booking.totalprice",Matchers.equalTo(500),
                        "booking.depositpaid",Matchers.equalTo(false),
                        "booking.bookingdates.checkin",Matchers.equalTo("2025-01-10"),
                        "booking.bookingdates.checkout",Matchers.equalTo("2025-01-20"),
                        "booking.additionalneeds",Matchers.equalTo("wi-fi")
                        );

    }
}
