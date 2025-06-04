package org.example.ex_04_RestAssured_HTTP_Methods.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

public class APITesting009_GET_NonBDDStyle {
RequestSpecification r;
Response response;
ValidatableResponse vr;

@Test
    public void test_GET_NonBDD()
    {
        String pincode =  "560066";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);

        response = r.when().log().all().get();

        System.out.println(response.asString());

        vr = response.then().log().all();
        vr.statusCode(200);

    }

    @Test
    public void test_GET_BDD_negative()
    {
        String pincode =  "560066";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);

        response = r.when().log().all().get();

        System.out.println(response.asString());

        vr = response.then().log().all();
        vr.statusCode(400);

    }
}
