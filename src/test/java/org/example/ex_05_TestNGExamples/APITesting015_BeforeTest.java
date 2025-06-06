package org.example.ex_05_TestNGExamples;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITesting015_BeforeTest {

    @BeforeTest
    public void getToken()
    {
        System.out.println("get token");
    }
    @BeforeTest

    public void bookingID()
    {
        System.out.println("booking iD");
    }

    @Test
    public void test_put()
    {
        System.out.println("test case");
    }
}
