import org.junit.jupiter.api.Test;

public class C08_Post_JsonpathIleResponseBilgileriTesti {
    /*
            https://restful-booker.herokuapp.com/booking url’ine
            asagidaki body'ye sahip bir POST request gonderdigimizde
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
                   ve "checkin" tarihinin 2023-01-10
                   ve "checkout" tarihinin 2023-01-20
                   ve "additionalneeds“in,"wi-fi"
              oldugunu test edin


     */

    @Test
    public void test01(){

    }
}
