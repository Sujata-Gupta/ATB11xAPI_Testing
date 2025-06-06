package org.example.ex_04_RestAssured_HTTP_Methods.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting012_PATCH_NONBddStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test

    public void test_patch_non_bdd()
    {
        String token="929e1d6bc382f0b";
        String bookingId="6398";

        String payload="{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";

        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingId);
        r.contentType(ContentType.JSON);
        r.cookie("token",token);

        r.body(payload).log().all();

        response=r.when().log().all().patch();
        r.log().all();

        vr= response.then().log().all();
        vr.statusCode(200);



    }
}
