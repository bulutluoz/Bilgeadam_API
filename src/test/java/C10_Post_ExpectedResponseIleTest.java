import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class C10_Post_ExpectedResponseIleTest {

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
        }
        }
         */

    @Test
    public void test01(){

        // 1.adim : end point'i belirle ve eger gerekli ise request body olustur
        String endpoint = "https://restful-booker.herokuapp.com/booking";

        JSONObject bookingdatesJsonObject = new JSONObject();
        bookingdatesJsonObject.put("checkin","2021-06-01");
        bookingdatesJsonObject.put("checkout","2021-06-10");

        JSONObject requestBody = new JSONObject();
        requestBody.put("firstname","Hasan");
        requestBody.put("additionalneeds","wi-fi");
        requestBody.put("bookingdates",bookingdatesJsonObject);
        requestBody.put("totalprice",500);
        requestBody.put("depositpaid",false);
        requestBody.put("lastname","Yagmur");


        // 2.adim : eger gorevde varsa expected response body olustur

        JSONObject expectedResponseJson = new JSONObject();
        expectedResponseJson.put("bookingid",24);
        expectedResponseJson.put("booking",requestBody);


        // 3.adim : request'i yollayip, donen response'i actualResponse olarak kaydet

        Response actualResponse = RestAssured.given().contentType(ContentType.JSON)
                                        .when().body(requestBody.toString())
                                        .post(endpoint);

        JsonPath actualRespJsonpath = actualResponse.jsonPath();

        // 4.adim : istenen assertion'lari yapin
        //             expectedResponseJson  <===>  actualResponse
        //  data turu :      JsonObject               Response/ Jsonpath objesine cast yapalim


        Assertions.assertEquals(
              expectedResponseJson.getJSONObject("booking").getString("firstname"),
              actualRespJsonpath.getString("booking.firstname")
        );

        Assertions.assertEquals(
                expectedResponseJson.getJSONObject("booking").getString("lastname"),
                actualRespJsonpath.getString("booking.lastname")
        );

        Assertions.assertEquals(
                expectedResponseJson.getJSONObject("booking").getInt("totalprice"),
                actualRespJsonpath.getInt("booking.totalprice")
        );

        Assertions.assertEquals(
                expectedResponseJson.getJSONObject("booking").getBoolean("depositpaid"),
                actualRespJsonpath.getBoolean("booking.depositpaid")
        );

        Assertions.assertEquals(
                expectedResponseJson.getJSONObject("booking").getString("additionalneeds"),
                actualRespJsonpath.getString("booking.additionalneeds")
        );







    }
}












