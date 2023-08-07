package com.kraftechnologie.tests.day15_pom1;

import com.kraftechnologie.pages.LoginPage;
import com.kraftechnologie.tests.TestBase;
import com.kraftechnologie.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    /**
     * go to kraft login page
     * login as Mike
     * validate that you are on the dashboard with url
     */
    @Test
    public void loginTest_1() throws InterruptedException {
        driver.get(ConfigurationReader.get("url"));

        //OLD WAY
        /*WebElement emailInputBox = driver.findElement(By.cssSelector("#email"));
        WebElement passwordInputBox = driver.findElement(By.cssSelector("#yourPassword"));
        WebElement loginButton = driver.findElement(By.xpath("//button[.='Login']"));
        emailInputBox.sendKeys("...");
        passwordInputBox.sendKeys("...");
        loginButton.click();*/

        LoginPage loginPage = new LoginPage();

        WebElement emailBox = loginPage.emailInputBox;
        WebElement passwordBox = loginPage.passwordInputBox;
        WebElement login = loginPage.loginButton;

        emailBox.sendKeys(ConfigurationReader.get("userEmail"));
        passwordBox.sendKeys(ConfigurationReader.get("userPassword"));
        login.click();

        Thread.sleep(3000);

        String expected = "https://www.krafttechexlab.com/index";
        String actual = driver.getCurrentUrl();

        Assert.assertEquals(actual,expected);
    }

    /**
     * go to kraft login page
     * login as Mike
     * use login(String username, String password)
     * validate that you are on the dashboard with url
     */
    @Test
    public void loginTest_2(){
        driver.get(ConfigurationReader.get("url"));

        LoginPage loginPage = new LoginPage();

        //call login() method
        loginPage.login(ConfigurationReader.get("userEmail"),ConfigurationReader.get("userPassword"));

        String expected = "https://www.krafttechexlab.com/index";
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(actual,expected);
    }

    /**
     * go to kraft login page
     * login as Mike
     * use login()
     * validate that you are on the dashboard with url
     */
    @Test
    public void loginTest_3(){
        //driver.get(ConfigurationReader.get("url"));

        LoginPage loginPage = new LoginPage();
        //call login() method
        loginPage.login();

        //assertion
        String expected = "https://www.krafttechexlab.com/index";
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(actual,expected);
    }
    }
