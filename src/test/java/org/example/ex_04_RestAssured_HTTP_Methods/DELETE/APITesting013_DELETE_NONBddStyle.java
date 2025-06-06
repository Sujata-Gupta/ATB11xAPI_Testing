package org.example.ex_04_RestAssured_HTTP_Methods.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;



public class APITesting013_DELETE_NONBddStyle {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
            public void test_delete_non_bdd() {


        String token = "b5c9fe30fbc70f6";
        String bookingId = "3798";



        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + bookingId);
        r.contentType(ContentType.JSON);
        r.cookie("token", token);

        r.log().all();

        response = r.when().log().all().delete();


        vr = response.then().log().all();
        vr.statusCode(201);
    }

}
