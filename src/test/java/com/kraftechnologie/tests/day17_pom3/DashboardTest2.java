package com.kraftechnologie.tests.day17_pom3;

import com.kraftechnologie.pages.DashboardPage;
import com.kraftechnologie.pages.LoginPage;
import com.kraftechnologie.tests.TestBase;
import com.kraftechnologie.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DashboardTest2 extends TestBase {


    @Test
    public void verifyList() {
        driver.get(ConfigurationReader.get("url"));
        LoginPage loginPage=new LoginPage();
        loginPage.login();

        //BrowserUtils.waitFor(2);

        DashboardPage dashboardPage = new DashboardPage();

        String expected = "Dashboard";
        String actual = dashboardPage.dashboardElement.getText();
        //first assertion
        Assert.assertEquals(actual,expected);

        List<String> expectedList=new ArrayList<>();
        expectedList.add("Dashboard");
        expectedList.add("Developers");
        expectedList.add("Components");
        expectedList.add("Forms");
        expectedList.add("JavaScript");
        expectedList.add("mike");

        List<String> actualList=new ArrayList<>();

        for (WebElement menu:dashboardPage.upTitles ) {
            System.out.println("menu.getText() = " + menu.getText());
            actualList.add(menu.getText());
        }

        Assert.assertEquals(actualList,expectedList);

    }
}
