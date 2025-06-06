package org.example.ex_07_Payload_management.String;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class APITesting027_RestAssured_TestNG_AssertJ_Assertions {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingID;

    @Owner("Sujata")
    @Severity(SeverityLevel.CRITICAL)
//@Description("TC#1 - Verify that the Create Booking is working fine, booking ID is not null")
    @Test
    public void test_createBooking_POST() {
        String payload = "{\n" +
                "    \"bookingid\": 2331,\n" +
                "    \"booking\": {\n" +
                "        \"firstname\": \"Sujata\",\n" +
                "        \"lastname\": \"Gupta\",\n" +
                "        \"totalprice\": 676668,\n" +
                "        \"depositpaid\": true,\n" +
                "        \"bookingdates\": {\n" +
                "            \"checkin\": \"2018-01-01\",\n" +
                "            \"checkout\": \"2019-01-01\"\n" +
                "        },\n" +
                "        \"additionalneeds\": \"Breakfast\"\n" +
                "    }\n" +
                "}";

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
        // Rest Assured Validation -5% used
        validatableResponse.body("booking.firstname", Matchers.equalTo("Winfield_Kovacek"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Mills"));
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(true));
        validatableResponse.body("bookingid", Matchers.notNullValue());


        // Testng validation 75% used

        bookingID = response.then().extract().path("bookingid");
        String firstname= response.then().extract().path("booking.firstname");
        String lastname= response.then().extract().path("booking.lastname");
        Boolean depositpaid = response.then().extract().path("booking.depositpaid");


        Assert.assertEquals(firstname,"Sujata");
        Assert.assertEquals(lastname,"Gupta");
        Assert.assertTrue(depositpaid,"false");

        //Asserj

        assertThat(bookingID).isNotNull().isNotZero().isPositive();
        assertThat(firstname).isEqualTo("Sujata").isNotBlank();


        //        String s = ""; //Empty
        //        String s2 = " "; //Blank

    }
    }
