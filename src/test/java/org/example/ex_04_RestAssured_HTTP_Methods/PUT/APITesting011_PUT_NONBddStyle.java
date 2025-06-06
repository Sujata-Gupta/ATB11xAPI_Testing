package org.example.ex_04_RestAssured_HTTP_Methods.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting011_PUT_NONBddStyle {
RequestSpecification r;
Response response;
ValidatableResponse vr;
        @Test
        public void test_put_non_bdd()
        {

            String token="a048cb850f24739";
            String bookingId="9337";

            String payload=" {\n" +
                    "    \"firstname\" : \"Shikar\",\n" +
                    "    \"lastname\" : \"Gupta\",\n" +
                    "    \"totalprice\" : 111,\n" +
                    "    \"depositpaid\" : true,\n" +
                    "    \"bookingdates\" : {\n" +
                    "        \"checkin\" : \"2018-01-01\",\n" +
                    "        \"checkout\" : \"2019-01-01\"\n" +
                    "    },\n" +
                    "    \"additionalneeds\" : \"Breakfast\"\n" +
                    "}";

            r= RestAssured.given();
            r.baseUri("https://restful-booker.herokuapp.com");
            r.basePath("/booking/"+bookingId);
            r.contentType(ContentType.JSON);
            r.cookie("token",token);

            r.body(payload).log().all();

            response=r.when().log().all().put();
            r.log().all();

            vr= response.then().log().all();
            vr.statusCode(200);




        }
}
