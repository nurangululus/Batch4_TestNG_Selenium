package com.kraftechnologie.tests.day18_ExtendReports;

import com.kraftechnologie.pages.LoginPage;
import com.kraftechnologie.tests.TestBase;
import com.kraftechnologie.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    @Test
    public void loginTest() {
        LoginPage loginPage=new LoginPage();
        extentLogger= report.createTest("Login Test 1");
        extentLogger.info("Go to Kraftech Login page");
        driver.get(ConfigurationReader.get("url"));
        extentLogger.info("login method");
        loginPage.login();
        System.out.println("1");
    }
    @Test
    public void loginTest2() {
        LoginPage loginPage=new LoginPage();
        extentLogger= report.createTest("Login Test 2");
        extentLogger.info("Go to Kraftech Login page");
        // driver.get(ConfigurationReader.get("url"));
        extentLogger.info("login method 2");
        loginPage.login();
        System.out.println("2");
    }
}
