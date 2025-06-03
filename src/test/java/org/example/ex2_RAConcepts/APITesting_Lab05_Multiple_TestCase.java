package org.example.ex2_RAConcepts;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting_Lab05_Multiple_TestCase {

    public static void main(String[] args) {


        String pincode="208003";

        RestAssured.given().baseUri("https://api.zippopotam.us")
                .basePath("/IN/\"+pincode")
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200);


        pincode="@";
        RestAssured.given().baseUri("https://api.zippopotam.us")
                .basePath("/IN/\"+pincode")
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200);

        pincode=" ";
        RestAssured.given().baseUri("https://api.zippopotam.us")
                .basePath("/IN/\"+pincode")
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200);


    }



}
