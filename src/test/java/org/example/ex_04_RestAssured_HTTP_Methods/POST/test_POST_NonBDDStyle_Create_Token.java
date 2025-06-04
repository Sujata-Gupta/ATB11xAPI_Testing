package org.example.ex_04_RestAssured_HTTP_Methods.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class test_POST_NonBDDStyle_Create_Token {
    String payload="{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";
    @Test
    public void test_POST_Auth()
    {
        String payload="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth\n")
                .contentType(ContentType.JSON)
                .log().all()
                .body(payload)
                .when()
                .log().all()
                .post()
                .then()
                .log().all()
                .statusCode(200);

    }


}
