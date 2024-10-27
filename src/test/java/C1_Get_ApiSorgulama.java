import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

public class C1_Get_ApiSorgulama {

    @Test
    public void test01(){
        // https://restful-booker.herokuapp.com/booking/10 url’ine
        // bir GET request gonderdigimizde donen Response’u yazdirin.


        // 1.adim : end point'i belirle ve eger request icin gerekli ise request body olustur
        // 2.adim : eger beklenen response body'e sahipse, expected response body olustur
        // 3.adim : request'i yollayip, donen response'i actualData olarak kaydet
        // 4.adim : 2.adimda hazirlanan expected response ile 3.adimda kaydedilen actual response'i
        //          karsilastirip, istenen assertion'lari yap


        // 1.adim : end point'i belirle ve eger request icin gerekli ise request body olustur
        String endPoint = "https://restful-booker.herokuapp.com/booking/10";

        // 2.adim : eger beklenen response body'e sahipse, expected response body olustur

        // 3.adim : request'i yollayip, donen response'i actualData olarak kaydet


        // Response actualResponse = RestAssured.given().when().get();
        // esitligin sag tarafi restAssured kutuphanesini kullanarak bir request gonderir ve
        // Response data turunde bir sonuc döndürür.
        // bizde donen degeri actualResponse olarak kaydederiz



        // 4.adim : 2.adimda hazirlanan expected response ile 3.adimda kaydedilen actual response'i
        //          karsilastirip, istenen assertion'lari yap

    }
}
