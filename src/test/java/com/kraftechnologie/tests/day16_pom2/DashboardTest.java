package com.kraftechnologie.tests.day16_pom2;

import com.kraftechnologie.pages.DashboardPage;
import com.kraftechnologie.pages.LoginPage;
import com.kraftechnologie.tests.TestBase;
import com.kraftechnologie.utilities.BrowserUtils;
import com.kraftechnologie.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DashboardTest extends TestBase {

    /**
     * login with Mike
     * verify that you are on the dashboard page by using 'Dashboard' keyword at top-left
     * Verify that uptitles are following by using BrowserUtils method
     * Dashboard
     * Developers
     * Components
     * Forms
     * JavaScript
     * mike
     */
    @Test
    public void basicDashboardMenuTest() {
        driver.get(ConfigurationReader.get("url"));
        LoginPage loginPage = new LoginPage();
        loginPage.login();

        BrowserUtils.waitFor(2);

        DashboardPage dashboardPage = new DashboardPage();

        String expected = "Dashboard";
        String actual = dashboardPage.dashboardElement.getText();
        //first assertion
        Assert.assertEquals(actual,expected);

        List<String> actualList = BrowserUtils.getElementsText(dashboardPage.upTitles);
        List<String> expectedList = new ArrayList<>(
                Arrays.asList("Dashboard", "Developers", "Components", "Forms", "JavaScript","mike"));

        //second verification
        Assert.assertEquals(actualList,expectedList);
    }

    /**
     * login with Mike
     * go to 'developers' tab via navigateToModule()
     * validate that you are on the right page through url
     */
    @Test
    public void navigateMenu_1(){
        driver.get(ConfigurationReader.get("url"));

        LoginPage loginPage = new LoginPage();
        loginPage.login();

        BrowserUtils.waitFor(2);

        loginPage.navigateToModule("Developers");

        BrowserUtils.waitFor(2);

        String expectedUrl = "https://www.krafttechexlab.com/developers";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
    }
    /**
     * login with Mike
     * go to 'Components --> Modal' submodule via navigateToModule()
     * validate that you are on the right page through url
     */
    @Test
    public void navigateMenu_2(){
        driver.get(ConfigurationReader.get("url"));

        LoginPage loginPage = new LoginPage();
        loginPage.login();

        BrowserUtils.waitFor(2);

        loginPage.navigateToModule("Components", "Modal");

        BrowserUtils.waitFor(2);

        String expectedUrl = "https://www.krafttechexlab.com/components/modal";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
    }
}
