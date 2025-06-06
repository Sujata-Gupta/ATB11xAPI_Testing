package org.example.ex_06_TestAssetions;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
//import jdk.jfr.Description;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class APITesting025_RestAsssured_Assertions {

RequestSpecification requestSpecification;
Response response;
ValidatableResponse validatableResponse;
String token;
Integer bookingID;

@Owner("Sujata")
@Severity(SeverityLevel.CRITICAL)
//@Description("TC#1 - Verify that the Create Booking is working fine, booking ID is not null")
@Test
    public void test_createBooking_POST()
{
    String payload = "{\n" +
            "        \"firstname\": \"Winfield_Kovacek\",\n" +
            "        \"lastname\": \"Mills\",\n" +
            "        \"totalprice\": 676668,\n" +
            "        \"depositpaid\": true,\n" +
            "        \"bookingdates\": {\n" +
            "            \"checkin\": \"2026-03-03\",\n" +
            "            \"checkout\": \"2019-01-01\"\n" +
            "        },\n" +
            "        \"additionalneeds\": \"Breakfast\"\n" +
            "    }";

    requestSpecification = RestAssured.given();
    requestSpecification.baseUri("https://restful-booker.herokuapp.com");
    requestSpecification.basePath("/booking");
    requestSpecification.contentType(ContentType.JSON);
    requestSpecification.body(payload).log().all();

    Response response = requestSpecification.when().post();


    // Get Validatable response to perform validation
    validatableResponse = response.then().log().all();

    // Rest Assured.
    validatableResponse.statusCode(200);

    // firstname == Pramod , Last Name = Dutta
    // Booking ID shouldn't null

     validatableResponse.body("booking.firstname", Matchers.equalTo("Winfield_Kovacek"));
     validatableResponse.body("booking.lastname",Matchers.equalTo("Mills"));
     validatableResponse.body("booking.depositpaid",Matchers.equalTo(true));
     validatableResponse.body("bookingid",Matchers.notNullValue());


}
}
