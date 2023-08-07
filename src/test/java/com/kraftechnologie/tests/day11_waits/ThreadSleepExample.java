package com.kraftechnologie.tests.day11_waits;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThreadSleepExample {

    WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


    /**  HOME TASK
     https://the-internet.herokuapp.com/dynamic_loading
     Example 2: Element rendered after the fact -->click
     click that element
     verify that hello world is not displayed
     click start button
     verify that hello element is displayed
     and verify that "Hello World!" text is present
     */

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        driver.findElement(By.partialLinkText("Example 2:")).click(); //lazy way
        Thread.sleep(2000);
        String hello="Hello World!";

        WebElement body =driver.findElement(By.tagName("body"));
        System.out.println("body.getText() = " + body.getText());
        Assert.assertFalse(body.getText().contains(hello));

        driver.findElement(By.cssSelector("#start>button")).click();
        Thread.sleep(5000);
        //first way
        System.out.println("body.getText() = " + body.getText());
        Assert.assertTrue(body.getText().contains(hello));
        //second way
        WebElement helloWorld= driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        Assert.assertTrue(helloWorld.isDisplayed());

    }
}
