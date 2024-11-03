package TestDataClasslari;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

public class JphTestDataClass {


    protected String baseUrl = "https://jsonplaceholder.typicode.com/posts";
    protected JSONObject expectedResponseJsonObject;
    protected JSONObject requestBodyJsonObject;

    protected final int basariliSorguStatusKodu = 200;
    protected final String responseContentType = "application/json; charset=utf-8";
    protected final String responseConnectionHeaderValue = "keep-alive";




    protected void expectedResponseJsonObjectOlustur(int userId, int id, String title, String body) {

        expectedResponseJsonObject = new JSONObject();
        expectedResponseJsonObject.put("userId",userId);
        expectedResponseJsonObject.put("id",id);
        expectedResponseJsonObject.put("title",title);
        expectedResponseJsonObject.put("body",body);

    }

    protected void requestBodyJsonObjectOlustur(int userId, int id, String title, String body) {

        requestBodyJsonObject = new JSONObject();
        requestBodyJsonObject.put("userId",userId);
        requestBodyJsonObject.put("id",id);
        requestBodyJsonObject.put("title",title);
        requestBodyJsonObject.put("body",body);

    }

    protected void responseAssertionYap(JSONObject expectedResponseJsonObject, Response actualResponse) {

        JsonPath actualResponseJsonpath = actualResponse.jsonPath();

        Assertions.assertEquals(
                expectedResponseJsonObject.getInt("id"),
                actualResponseJsonpath.getInt("id")
        );

        Assertions.assertEquals(
                expectedResponseJsonObject.getInt("userId"),
                actualResponseJsonpath.getInt("userId")
        );

        Assertions.assertEquals(
                expectedResponseJsonObject.getString("title"),
                actualResponseJsonpath.getString("title")
        );

        Assertions.assertEquals(
                expectedResponseJsonObject.getString("body"),
                actualResponseJsonpath.getString("body")
        );
    }



}
