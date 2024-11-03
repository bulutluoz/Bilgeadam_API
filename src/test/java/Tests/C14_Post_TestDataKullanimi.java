package Tests;

import TestDataClasslari.HerokuTestDataClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class C14_Post_TestDataKullanimi extends HerokuTestDataClass {

    /*
        https://restful-booker.herokuapp.com/booking url’ine
        asagidaki body'ye sahip bir POST request gonderdigimizde
        donen response’un id haric asagidaki gibi oldugunu test edin.

        Request body
        {
        "firstname" : "Hasan",
        "lastname" : "Yagmur",
        "totalprice" : 500,
        "depositpaid" : false,
        "bookingdates" : {
            "checkin" : "2021-06-01",
            "checkout" : "2021-06-10"
            },
        "additionalneeds" : "wi-fi"
        }


        Expected Response Body
        {
        "bookingid":24,
        "booking":{
            "firstname":"Hasan",
            "lastname":"Yagmur",
            "totalprice":500,
            "depositpaid":false,
            "bookingdates":{
                "checkin":"2021-06-01",
                "checkout":"2021-06-10"
                },
            "additionalneeds":"wi-fi"
        }}
         */
    @Test
    public void test01(){

        // 1.adim : end point'i belirle ve eger gerekli ise request body olustur

        String endpoint = baseUrl + "/booking";
        requestBodyJsonObjectOlustur("Hasan","Yagmur",500,false,
                                        "2021-06-01","2021-06-10","wi-fi");

        // 2.adim : eger gorevde varsa expected response body olustur

        expectedResponseJsonObjectOlustur("Hasan","Yagmur",500,false,
                                            "2021-06-01","2021-06-10","wi-fi");

        // 3.adim : request'i yollayip, donen response'i actualResponse olarak kaydet

        Response actualResponse = RestAssured.given().contentType(ContentType.JSON)
                                        .when().body(requestBody.toString())
                                        .post(endpoint);

        // 4.adim : istenen assertion'lari yapin
        //  donen response’un id haric asagidaki gibi oldugunu test edin.

        responseAssertionYap(expectedResponseJsonObject,actualResponse);


    }




}
