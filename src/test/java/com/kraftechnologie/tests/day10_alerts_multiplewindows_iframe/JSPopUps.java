package com.kraftechnologie.tests.day10_alerts_multiplewindows_iframe;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSPopUps {

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void jsPopUp_Accept() throws InterruptedException {
        //tap on click For Js Alert button
        WebElement clickForJsAlert = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        clickForJsAlert.click();

        Thread.sleep(2000);

        //create alert object
        Alert alert = driver.switchTo().alert();
        //tap OK button
        alert.accept();

        //verification
        String actual = driver.findElement(By.cssSelector("#result")).getText();
        String expected = "You successfully clicked an alert";
        Assert.assertEquals(actual,expected);

    }

    @Test
    public void jsPopUp_Dismiss() throws InterruptedException {
        //tap on click For JS Confirm button
        WebElement clickForJsConfirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        clickForJsConfirm.click();

        Thread.sleep(2000);

        //create an alert object
        Alert alert = driver.switchTo().alert();
        //tap on cancel button by dismiss()
        alert.dismiss();

        //verification
        String actual = driver.findElement(By.cssSelector("#result")).getText();
        String expected = "You clicked: Cancel";
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void jsPopUp_SendKeys() throws InterruptedException {
        //tap on click for JS Prompt button
        WebElement clickForJsPrompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        clickForJsPrompt.click();

        Thread.sleep(2000);

        //create alert object
        Alert alert = driver.switchTo().alert();

        String text = "Alperen";
        alert.sendKeys(text);

        Thread.sleep(2000);

        alert.accept();

        //make verification
        String actual = driver.findElement(By.cssSelector("#result")).getText();
        String expected = "You entered: " + text;
        Assert.assertEquals(actual,expected);
    }
}
