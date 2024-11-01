import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;


public class C05_Get_ResponseBodyTesti {

    @Test
    public void test01(){

        // https://jsonplaceholder.typicode.com/posts/44 url'ine
        // bir GET request yolladigimizda
        // donen Response’in
        // status code'unun 200,
        // ve content type'inin Aplication.JSON,
        // ve response body'sinde bulunan userId'nin 5,
        // ve response body'sinde bulunan title'in "optio dolor molestias sit" oldugunu test edin.


        // 1.adim : end point'i belirle ve eger gerekli ise request body olustur
        String endpoint = "https://jsonplaceholder.typicode.com/posts/44";

        // 2.adim : eger gorevde varsa expected response body olustur

        // 3.adim : request'i yollayip, donen response'i actualData olarak kaydet

        Response actualResponse = RestAssured.given()
                                                    .when()
                                                    .get(endpoint);

        // 4.adim : istenen assertion'lari yapin

        actualResponse.then().assertThat()
                                .statusCode(200)
                                .contentType(ContentType.JSON)
                                .body("userId", Matchers.equalTo(5))
                                .body("title", Matchers.equalTo("optio dolor molestias sit"));
    }
}
