package com.kraftechnologie.tests.day07_testNG_intro;

import org.testng.annotations.*;

public class BeforeAfterMethod {

    @BeforeMethod
    public void setUp() {
        System.out.println("********* Before Method **********");
        System.out.println("WebDriver,Opening Browser");
    }

    @Test
    public void test1() {
        System.out.println("First Test Case");
    }

    @Test
    public void test2() {
        System.out.println("Second Test Case");
    }

    @Test
    public void test3() {
        System.out.println("Thirs Test Case");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("*********** After Method ********");
        System.out.println("Closing Browser,quit");
    }

    @BeforeClass
    public void setUpClass() {
        System.out.println("------Before Class---------");
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("--------After Class-------");
    }
}

