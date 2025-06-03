package org.example.ex1_RA_Basic;

import io.restassured.RestAssured;

public class L01_RA {
    public static void main(String[] args) {

        RestAssured .given()
                .baseUri("https://restful-booker.herokuapp.com/ping")
                .when()
                .get()
                .then()
                .log().all().statusCode(201);
    }
}
