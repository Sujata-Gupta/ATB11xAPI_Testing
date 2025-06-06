package org.example.ex_05_TestNGExamples;

import com.beust.jcommander.Parameter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITesting019_TestNG_Parameter {

    @Parameters("browser")
    @Test
    public void demo1(String value)
    {
        System.out.println("demo1");

        if(value.equalsIgnoreCase("chrome"))
        {
            System.out.println("this is chrome");
        }

        if(value.equalsIgnoreCase("firefox"))
        {
            System.out.println("This is firefox");
        }
    }
}
