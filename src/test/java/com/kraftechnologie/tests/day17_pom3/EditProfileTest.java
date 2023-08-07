package com.kraftechnologie.tests.day17_pom3;

import com.kraftechnologie.pages.DashboardPage;
import com.kraftechnologie.pages.EditProfilePage;
import com.kraftechnologie.pages.LoginPage;
import com.kraftechnologie.pages.UserProfilePage;
import com.kraftechnologie.tests.TestBase;
import com.kraftechnologie.utilities.BrowserUtils;
import com.kraftechnologie.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditProfileTest extends TestBase {
    /** Class Task
     * THIS TASK WILL BE IMPLEMENTED USING POM
     * which means we will have one test class for the test
     * and one corresponding page having all locators and actions for the page
     * go to https://www.krafttechexlab.com/login
     * enter valid credentials
     *      --> john@gmail.com
     *      --> John1234.
     * go to John --> myProfile
     * create a method that navigate you to specific module based on the given parameter
     * go to Edit Profile page using the method just mentioned above
     * fill out the fields
     *      -->about --> SDET programme , graduated from KraftTech
     *      -->Company --> Google
     *      -->Job  --> QA Automation Engineer
     *      -->Website --> www.google.com
     *      -->Location --> Istanbul
     *      -->Skills --> Java,Selenium, TestNG
     *      click save changes button
     *      verify that "profile updated" appears
     */

    @Test
    public void editProfileTest() {

        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        UserProfilePage userProfilePage = new UserProfilePage();
        EditProfilePage editProfilePage = new EditProfilePage();


        driver.get(ConfigurationReader.get("url"));
        loginPage.login("john@gmail.com", "John1234.");

        BrowserUtils.waitForVisibility(dashboardPage.userAccountName, 5);

        dashboardPage.navigateToModule("John", "My Profile");
        userProfilePage.navigateToOverViewMenu("Edit Profile");
        BrowserUtils.waitFor(1);
        editProfilePage.aboutInputBox.clear();
        editProfilePage.aboutInputBox.sendKeys("SDET programme , graduated from KraftTech");
        BrowserUtils.waitFor(1);
        editProfilePage.companyInputBox.clear();
        editProfilePage.companyInputBox.sendKeys("Google");
        /**
         Select select=new Select(editProfilePage.jobInputBox);
         select.selectByVisibleText("QA Automation Engineer");
         */
        BrowserUtils.waitFor(1);
        editProfilePage.selectJob("QA Automation Engineer");
        BrowserUtils.waitFor(1);
        editProfilePage.websiteInputBox.clear();
        editProfilePage.websiteInputBox.sendKeys("www.google.com");
        BrowserUtils.waitFor(1);
        editProfilePage.locationInputBox.clear();
        editProfilePage.locationInputBox.sendKeys("Istanbul");
        BrowserUtils.waitFor(1);
        editProfilePage.skillsInputBox.clear();
        editProfilePage.skillsInputBox.sendKeys("Java,Selenium,TestNG");
        BrowserUtils.waitFor(1);
        editProfilePage.saveChangeBtn.click();

        String expectedMesage="Profile Updated";
        //String actualMessage=userProfilePage.updateMessage.getText();
        String actualMessage=userProfilePage.updateMessageGetText();

        Assert.assertEquals(actualMessage,expectedMesage);


    }

    /** Add experience
     *  ADD EDUCATİON
     */


}




