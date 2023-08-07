package com.kraftechnologie.tests.day04_basic_locators;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClassNameTest {
    public static void main(String[] args) throws InterruptedException{

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/");

        System.out.println("driver.findElement(By.className(\"pagetitle\")).getText() = " + driver.findElement(By.className("pagetitle")).getText());
        System.out.println("driver.findElement(By.className(\"footer\")).getText() = " + driver.findElement(By.className("footer")).getText());

        //if there is a space in the className locator we can not use clasName locator -> NoSuchElementException
        // System.out.println("driver.findElement(By.className(\"header fixed-top d-flex align-items-center\")).getText() = " + driver.findElement(By.className("header fixed-top d-flex align-items-center")).getText());

        Thread.sleep(2000);
        driver.close();

    }
}
