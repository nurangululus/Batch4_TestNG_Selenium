package com.kraftechnologie.tests.day14_properties_singleton;

import com.google.common.annotations.VisibleForTesting;
import com.kraftechnologie.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class PropertiesTest {


    @Test
    public void test1(){
        String browser= ConfigurationReader.get("browser");
        System.out.println("browser = " + browser);
        String url=ConfigurationReader.get("url");
        System.out.println("url = " + url);
    }
}
