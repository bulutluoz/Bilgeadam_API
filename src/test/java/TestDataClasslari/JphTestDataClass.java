package TestDataClasslari;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

public class JphTestDataClass {


    protected String baseUrl = "https://jsonplaceholder.typicode.com/posts";
    protected JSONObject expectedResponseJsonObject;
    protected JSONObject requestBodyJsonObject;


    protected Map<String,Object> requestBodyMap;
    protected Map<String,Object> expectedResponseMapBody;
    protected Map<String,Object> postRequestBodyMap;

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

    protected void requestBodyMapOlustur(String title, String body , Integer userId, Integer id){
        /*
                {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
         */

        requestBodyMap = new HashMap<>();
        requestBodyMap.put("title",title);
        requestBodyMap.put("body",body);
        requestBodyMap.put("userId",userId);
        requestBodyMap.put("id",id);
    }

    protected void expectedResponseBodyMapOlustur(String title, String body , Double userId, Double id){
        /*
                {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
         */

        expectedResponseMapBody = new HashMap<>();
        expectedResponseMapBody.put("title",title);
        expectedResponseMapBody.put("body",body);
        expectedResponseMapBody.put("userId",userId);
        expectedResponseMapBody.put("id",id);
    }

    protected void responseIleMapExpectedBodyAssertion(Response actualResponse, Map<String,Object> expectedResponseMapBody){

        // actualResponse  <==> expectedResponseMapBody

        Map<String,Object> responseBodyMap = actualResponse.as(HashMap.class);

        // responseBodyMap  <==> expectedResponseMapBody

        //{id=70.0, title=Ahmet, body=Merhaba, userId=10.0}

        //{id=70.0, title=Ahmet, body=Merhaba, userId=10.0}

        Assertions.assertEquals(expectedResponseMapBody.get("id"),responseBodyMap.get("id"));
        Assertions.assertEquals(expectedResponseMapBody.get("title"),responseBodyMap.get("title"));
        Assertions.assertEquals(expectedResponseMapBody.get("body"),responseBodyMap.get("body"));
        Assertions.assertEquals(expectedResponseMapBody.get("userId"),responseBodyMap.get("userId"));







    }

    protected void postRequestBodyMapOlustur(String title, String body , Integer userId){
        /*
                {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,

            }
         */

        postRequestBodyMap = new HashMap<>();
        postRequestBodyMap.put("title",title);
        postRequestBodyMap.put("body",body);
        postRequestBodyMap.put("userId",userId);

    }

}
