import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

public class C01_Get_ApiSorgulama {

    @Test
    public void test01(){
        // https://restful-booker.herokuapp.com/booking/10 url’ine
        // bir GET request gonderdigimizde donen Response’u yazdirin.


        // 1.adim : end point'i belirle ve eger gerekli ise request body olustur
        // 2.adim : eger gorevde varsa expected response body olustur
        // 3.adim : request'i yollayip, donen response'i actualData olarak kaydet
        // 4.adim : istenen assertion'lari yapin


        // 1.adim : end point'i belirle ve eger request icin gerekli ise request body olustur
        String endPoint = "https://restful-booker.herokuapp.com/booking/10";

        // 2.adim : eger beklenen response body'e sahipse, expected response body olustur

        // 3.adim : request'i yollayip, donen response'i actualData olarak kaydet


        // Response actualResponse = RestAssured.given().when().get();
        // esitligin sag tarafi restAssured kutuphanesini kullanarak bir request gonderir ve
        // Response data turunde bir sonuc döndürür.
        // bizde donen degeri actualResponse olarak kaydederiz

        Response actualResponse = RestAssured.given() // eger request body olsaydi, buraya request body data formatini yazariz
                                                .when() // eger request body olsaydi eklerdik
                                                .get(endPoint);

        System.out.println(actualResponse);
        // io.restassured.internal.RestAssuredResponseImpl@35178483

        System.out.println(actualResponse.toString());
        // io.restassured.internal.RestAssuredResponseImpl@38c2c309

        actualResponse.prettyPrint();
        /*
                {
                    "firstname": "Sally",
                    "lastname": "Wilson",
                    "totalprice": 352,
                    "depositpaid": true,
                    "bookingdates": {
                        "checkin": "2017-06-04",
                        "checkout": "2022-04-26"
                    }
                }

         */


        System.out.println(actualResponse.getTime()); // 876
        System.out.println(actualResponse.getContentType()); // application/json; charset=utf-8
        System.out.println(actualResponse.statusLine()); // HTTP/1.1 200 OK
        System.out.println(actualResponse.getHeader("Server")); // Cowboy



        // 4.adim : 2.adimda hazirlanan expected response ile 3.adimda kaydedilen actual response'i
        //          karsilastirip, istenen assertion'lari yap

    }
}
