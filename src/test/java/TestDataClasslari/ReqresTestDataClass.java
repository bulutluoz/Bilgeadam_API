package TestDataClasslari;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

public class ReqresTestDataClass {

    public static final String baseUrl = "https://reqres.in/api";


    public static JSONObject expectedResponseBodyJsonOlustur(int id, String email, String first_name,
                        String last_name, String avatar, String url , String text){
       /*

        {
            "data": {
                    "id": 1,
                    "email": "george.bluth@reqres.in",
                    "first_name": "George",
                    "last_name": "Bluth",
                    "avatar": "https://reqres.in/img/faces/1-image.jpg"
                    },
            "support": {
                        "url": "https://reqres.in/#support-heading",
                        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
                         }
        }

        */

        JSONObject dataJsonObject = new JSONObject();
        dataJsonObject.put("id",id);
        dataJsonObject.put("email",email);
        dataJsonObject.put("first_name",first_name);
        dataJsonObject.put("last_name",last_name);
        dataJsonObject.put("avatar",avatar);

        JSONObject supportJsonObje = new JSONObject();
        supportJsonObje.put("url",url);
        supportJsonObje.put("text",text);

        JSONObject expectedResponseBodyJson = new JSONObject();
        expectedResponseBodyJson.put("data",dataJsonObject);
        expectedResponseBodyJson.put("support",supportJsonObje);

        return expectedResponseBodyJson;

    }

    public static void responseAssertYap(JSONObject expectedResponseBody, Response actualResponse) {

        JsonPath actualResponseJsonpath = actualResponse.jsonPath();

        Assertions.assertEquals(
                expectedResponseBody.getJSONObject("data").getInt("id"),
                actualResponseJsonpath.getInt("data.id")
        );

        Assertions.assertEquals(
                expectedResponseBody.getJSONObject("data").getString("email"),
                actualResponseJsonpath.getString("data.email")
        );

        Assertions.assertEquals(
                expectedResponseBody.getJSONObject("data").getString("first_name"),
                actualResponseJsonpath.getString("data.first_name")
        );

        Assertions.assertEquals(
                expectedResponseBody.getJSONObject("data").getString("last_name"),
                actualResponseJsonpath.getString("data.last_name")
        );

        Assertions.assertEquals(
                expectedResponseBody.getJSONObject("data").getString("avatar"),
                actualResponseJsonpath.getString("data.avatar")
        );

        Assertions.assertEquals(
                expectedResponseBody.getJSONObject("support").getString("url"),
                actualResponseJsonpath.getString("support.url")
        );

        Assertions.assertEquals(
                expectedResponseBody.getJSONObject("support").getString("text"),
                actualResponseJsonpath.getString("support.text")
        );

    }
}
