package TestDataClasslari;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

public class HerokuTestDataClass {

    protected final String baseUrl = "https://restful-booker.herokuapp.com";
    protected JSONObject requestBody;
    protected JSONObject expectedResponseJsonObject;




    protected void requestBodyJsonObjectOlustur(String firstname, String lastname, int totalprice, boolean depositpaid, String checkIn, String checkout,String additionalneeds) {

        requestBody = new JSONObject();

        JSONObject bookingdatesJsonObject = new JSONObject();
        bookingdatesJsonObject.put("checkin",checkIn);
        bookingdatesJsonObject.put("checkout",checkout);

        requestBody.put("firstname",firstname);
        requestBody.put("additionalneeds",additionalneeds);
        requestBody.put("bookingdates",bookingdatesJsonObject);
        requestBody.put("totalprice",totalprice);
        requestBody.put("depositpaid",depositpaid);
        requestBody.put("lastname",lastname);

    }

    protected void expectedResponseJsonObjectOlustur(String firstname, String lastname, int totalprice, boolean depositpaid, String checkIn, String checkout,String additionalneeds) {

        expectedResponseJsonObject = new JSONObject();

        JSONObject bookingdatesJsonObject = new JSONObject();
        bookingdatesJsonObject.put("checkin",checkIn);
        bookingdatesJsonObject.put("checkout",checkout);

        JSONObject bookingJsonObject = new JSONObject();

        bookingJsonObject.put("firstname",firstname);
        bookingJsonObject.put("additionalneeds",additionalneeds);
        bookingJsonObject.put("bookingdates",bookingdatesJsonObject);
        bookingJsonObject.put("totalprice",totalprice);
        bookingJsonObject.put("depositpaid",depositpaid);
        bookingJsonObject.put("lastname",lastname);

        expectedResponseJsonObject.put("bookingid",24);
        expectedResponseJsonObject.put("booking",bookingJsonObject);

    }

    protected void responseAssertionYap(JSONObject expectedResponseJsonObject, Response actualResponse){

        JsonPath actualResponseJsonpath = actualResponse.jsonPath();

        //  expectedResponseJsonObject  <==>  actualResponseJsonpath

        Assertions.assertEquals(
                expectedResponseJsonObject.getJSONObject("booking").getString("firstname"),
                actualResponseJsonpath.getString("booking.firstname")
        );

        Assertions.assertEquals(
                expectedResponseJsonObject.getJSONObject("booking").getString("additionalneeds"),
                actualResponseJsonpath.getString("booking.additionalneeds")
        );

        Assertions.assertEquals(
                expectedResponseJsonObject.getJSONObject("booking").getInt("totalprice"),
                actualResponseJsonpath.getInt("booking.totalprice")
        );

        Assertions.assertEquals(
                expectedResponseJsonObject.getJSONObject("booking").getBoolean("depositpaid"),
                actualResponseJsonpath.getBoolean("booking.depositpaid")
        );

        Assertions.assertEquals(
                expectedResponseJsonObject.getJSONObject("booking").getString("lastname"),
                actualResponseJsonpath.getString("booking.lastname")
        );

        Assertions.assertEquals(
                expectedResponseJsonObject
                        .getJSONObject("booking")
                        .getJSONObject("bookingdates")
                        .getString("checkin"),

                actualResponseJsonpath.getString("booking.bookingdates.checkin")

        );

        Assertions.assertEquals(
                expectedResponseJsonObject
                        .getJSONObject("booking")
                        .getJSONObject("bookingdates")
                        .getString("checkout"),

                actualResponseJsonpath.getString("booking.bookingdates.checkout")

        );

    }

}


