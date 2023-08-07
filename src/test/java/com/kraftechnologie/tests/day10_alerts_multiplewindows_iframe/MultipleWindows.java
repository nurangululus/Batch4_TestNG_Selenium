package com.kraftechnologie.tests.day10_alerts_multiplewindows_iframe;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void switchedBetweenTwoWindows() throws InterruptedException {
        WebElement clickHereButton = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHereButton.click();

        Thread.sleep(2000);

        //switched between windows
        String currentWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            if(!currentWindow.equals(windowHandle)){
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        //verification
        WebElement newWindow = driver.findElement(By.xpath("//h3[.='New Window']"));
        String actual = newWindow.getText();
        String expected = "New Window";
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void switchBetweenMultipleWindows(){
        WebElement clickHereButton = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHereButton.click();
        clickHereButton.click();
        clickHereButton.click();
        clickHereButton.click();
        clickHereButton.click();

        String expectedUrl = "https://the-internet.herokuapp.com/windows/new";

        //switched between multiple windows by using known url
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if(driver.getCurrentUrl().equals(expectedUrl)){
                break;
            }
        }
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
    }
}
