package com.kraftechnologie.tests.day10_alerts_multiplewindows_iframe;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Nested_Iframe {

    WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        //driver.manage().window().maximize();
        Thread.sleep(1000);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void nestedIframe(){

        //switch the middle frame and get the MIDDLE text
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        System.out.println("driver.findElement(By.cssSelector(\"#content\")).getText() = " + driver.findElement(By.cssSelector("#content")).getText());

        //go to right frame and get text
        driver.switchTo().parentFrame(); // selenium switch to parent
        //driver.switchTo().defaultContent();//selenium switch the directly top
        //driver.switchTo().frame("frame-top");
        driver.switchTo().frame(2);
        System.out.println("driver.findElement(By.tagName(\"body\")).getText() = " + driver.findElement(By.tagName("body")).getText());

        //go to bottom frame and get text
        driver.switchTo().defaultContent();// to go to HTML
        driver.switchTo().frame(1);
        // driver.switchTo().frame("frame-bottom");
        System.out.println("driver.findElement(By.tagName(\"body\")).getText() = " + driver.findElement(By.tagName("body")).getText());

    }
}
