package org.example.ex_06_TestAssetions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting026_TestNG_Assertions {

    @Test
    public void test_hardAssertExample()
    {
        System.out.println("Start");
         Boolean ismade=false;
        Assert.assertTrue(ismade);
        System.out.println("tc1");
    }

    @Test
    public void test_softAssertExample()
    {
        System.out.println("Start");
        SoftAssert SA= new SoftAssert();
        SA.assertEquals("pramod","Pramod");
        System.out.println("End");
        SA.assertAll();
    }
}
