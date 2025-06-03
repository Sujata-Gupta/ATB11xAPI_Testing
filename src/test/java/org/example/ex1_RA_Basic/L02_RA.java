package org.example.ex1_RA_Basic;

import io.restassured.RestAssured;

public class L02_RA {
    public static void main(String[] args) {
        RestAssured
                .given()
                     .baseUri("https://api.zippopotam.us")
                      .basePath("/IN/560016")
                .when()
                     .get()
                .then().log().all()
                     .statusCode(200);


    }
}
