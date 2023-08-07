package com.kraftechnologie.tests.day18_ExtendReports;

import com.kraftechnologie.pages.LoginPage;
import com.kraftechnologie.tests.TestBase;
import com.kraftechnologie.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WrongUsernameTest extends TestBase {

    @Test
    public void wrongUserEmail() {

        LoginPage loginPage = new LoginPage();

        extentLogger = report.createTest("Wrong User Email Test");

        extentLogger.info("Go to Kraftech Login page");
        driver.get(ConfigurationReader.get("url"));
        extentLogger.info("Enter wrong user email");
        loginPage.emailInputBox.sendKeys("john@gmail.co");
        extentLogger.info("Enter user password");
        loginPage.passwordInputBox.sendKeys("Test1234");
        extentLogger.info("Click login button");
        loginPage.loginButton.click();
        String actualMessage = loginPage.usernameErrorMessage.getText();
        extentLogger.info("Verify that NOT log in");
        // Assert.assertEquals(actualMessage," address is incorrect. Please check"); //For fail
        Assert.assertEquals(actualMessage, " Email address is incorrect. Please check");
        extentLogger.pass("PASSED");

    }

    @Test
    public void wrongPasswordTest() {
        LoginPage loginPage = new LoginPage();

        extentLogger = report.createTest("Wrong Password Test");

        extentLogger.info("Go to Kraftech Login page");
        driver.get(ConfigurationReader.get("url"));
        extentLogger.info("Enter valid user email");
        loginPage.emailInputBox.sendKeys("john@gmail.com");
        extentLogger.info("Enter wrong user password");
        loginPage.passwordInputBox.sendKeys("wrong password");
        extentLogger.info("Click login button");
        loginPage.loginButton.click();
        String actualMessage = loginPage.passwordErrorMessage.getText();
        extentLogger.info("Verify that NOT log in");
        // Assert.assertEquals(actualMessage,"Password is incor. Please check"); //For fail
        Assert.assertEquals(actualMessage, "Password is incorrect. Please check");
        extentLogger.pass("PASSED");
    }
}
