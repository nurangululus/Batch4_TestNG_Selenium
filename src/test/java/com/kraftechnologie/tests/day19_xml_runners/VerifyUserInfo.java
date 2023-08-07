package com.kraftechnologie.tests.day19_xml_runners;

import com.kraftechnologie.pages.EditProfilePage;
import com.kraftechnologie.pages.LoginPage;
import com.kraftechnologie.pages.UserProfilePage;
import com.kraftechnologie.tests.TestBase;
import com.kraftechnologie.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.module.Configuration;

public class VerifyUserInfo extends TestBase {

    /** Class Task
     Login as a mike
     Verify that login is successful by using url
     Click on My profile
     Click on Edit Profile
     Verify that job is SDET
     */

    @Test
    public void verifyUserInfoTest(){

        LoginPage loginPage = new LoginPage();
        UserProfilePage userProfilePage= new UserProfilePage();
        EditProfilePage editProfilePage=new EditProfilePage();

        extentLogger = report.createTest("Test for practice");

        extentLogger.info("go to url");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("login as mike");
        loginPage.login();

        extentLogger.info("verify that you are on the home page by using mike");
        String expected="mike";
        String actual = loginPage.getUserAccountName();
        Assert.assertEquals(actual,expected);

        extentLogger.info("click on my profie");
        loginPage.navigateToModule("mike","My Profile");

        extentLogger.info("click on edit profile");
        userProfilePage.navigateToModule("Edit Profile");

        extentLogger.info("verify that the job is SDET");
        String expectedJob="SDET";
        String actualJob=editProfilePage.getSelectedJob();
        Assert.assertEquals(actualJob,expectedJob);

        extentLogger.pass("PASSED");

    }
}
