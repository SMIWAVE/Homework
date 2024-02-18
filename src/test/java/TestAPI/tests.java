package TestAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class tests {

    private static String url = "https://postman-echo.com";

    @Test
    public void statusTestGet(){
        given()
                    .contentType(ContentType.JSON)
                    .baseUri(url)
                .when()
                    .get()
                .then()
                    .assertThat()
                    .statusCode(200);
    }

    @Test
    public void testFieldsGet(){

        RestAssured.baseURI = "https://postman-echo.com";

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/get")
                .then()
                .log().body()
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-type", equalTo("application/json"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11.0.19)"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("url", equalTo(url+"/get"))
                        .extract().response();
    }

    @Test
    public void testFieldsGetWoops(){

        RestAssured.baseURI = "https://postman-echo.com";

        Response response = given()
                .contentType(ContentType.JSON)
                .queryParams("foo1", "bar1")
                .queryParams("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .log().body()
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .extract().response();
    }

    @Test
    public void testPostRawText(){

        RestAssured.baseURI = "https://postman-echo.com";

        JSONObject request = new JSONObject();
        request.put("test","value");
        System.out.println(request.toJSONString());

        given()
                        .contentType("application/json")
                        .body(request.toJSONString())
                    .when()
                        .post("/post")
                    .then()
                        .statusCode(200)
                        .assertThat()
                        .body("data", equalTo(request))
                        .body("json",equalTo(request));

    }

    @Test
    public void testPostFormData() {

        RestAssured.baseURI = "https://postman-echo.com";

        Response response = given()
                .contentType(ContentType.URLENC.withCharset("UTF-8"))
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"))
                .extract()
                .response();

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
    }

    @Test
    public void testPutRequest() {

        RestAssured.baseURI = "https://postman-echo.com";

        Response response = given()
                .contentType(ContentType.TEXT)
                .body("This is expected to be sent back as part of response body.")
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .extract()
                .response();

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
    }

    @Test
    public void testPatchRequest() {

        RestAssured.baseURI = "https://postman-echo.com";

        Response response = given()
                .contentType(ContentType.TEXT)
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .extract()
                .response();

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
    }

    @Test
    public void testDeleteRequest() {
        // Установка базового URL
        RestAssured.baseURI = "https://postman-echo.com";

        // Отправка PUT-запроса с указанным телом
        Response response = given()
                .contentType(ContentType.TEXT)
                .body("This is expected to be sent back as part of response body.")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .extract()
                .response();

        // Вывод ответа в консоль
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
    }
}
