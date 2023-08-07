package com.kraftechnologie.tests.day08_typeOfWebElements;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {

    @Test
    public void displayedTest1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement startBtn=driver.findElement(By.cssSelector("#start>button"));

        WebElement hello=driver.findElement(By.xpath("//h4[text()='Hello World!']"));

        System.out.println("hello.isDisplayed() = " + hello.isDisplayed());
        System.out.println("1 hello.getText() = " + hello.getText());
        Assert.assertFalse(hello.isDisplayed());

        startBtn.click();
        Thread.sleep(5000);
        Assert.assertTrue(hello.isDisplayed());
        System.out.println("2 hello.getText() = " + hello.getText());


        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void displayedTest2(){

        /**  HOME TASK
         https://the-internet.herokuapp.com/dynamic_loading
         Example 2: Element rendered after the fact -->click
         click that element
         verify that hello world is not displayed
         click start button
         verify that hello element is displayed
         and verify that "Hello World!" text is present
         */
    }
}
