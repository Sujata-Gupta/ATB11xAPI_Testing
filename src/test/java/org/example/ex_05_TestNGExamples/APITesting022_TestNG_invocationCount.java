package org.example.ex_05_TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting022_TestNG_invocationCount {
    @Test(invocationCount = 6)
    public void test01() {
        Assert.assertTrue(true);
    }
    @Test(invocationCount = 2)
    public void test02() {
        Assert.assertTrue(true);
    }
    @Test
    public void test03() {
        Assert.assertTrue(true);
    }
}
