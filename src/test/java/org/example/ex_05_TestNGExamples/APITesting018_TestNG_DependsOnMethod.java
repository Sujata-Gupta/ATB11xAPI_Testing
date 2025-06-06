package org.example.ex_05_TestNGExamples;

import org.testng.annotations.Test;

public class APITesting018_TestNG_DependsOnMethod {
    @Test
    public void test_openBrowser()
    {
        System.out.println("open browser");
    }
    @Test(dependsOnMethods = "test_openBrowser")
    public void Test_openimage()
    {
        System.out.println("openImage");
    }
@Test(dependsOnMethods = "test_openBrowser")
    public void test_opendata()
    {
        System.out.println("ope data");
    }
}
