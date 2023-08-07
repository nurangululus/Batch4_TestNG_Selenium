package com.kraftechnologie.tests.day03_webelement_intro;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyUserNameIsCorrect {
    public static void main(String[] args) throws InterruptedException{


        /** Class Task 3
         * open chrome browser
         * go to https://www.krafttechexlab.com/login  page
         * enter email as mike@gmail.com
         * enter password as mike1234
         * click login button
         * verify that username is "mike"
         * // verify that home page is "Dashboard"
         */

        String email = "mike@gmail.com";
        String password = "mike1234";
        String expectedProfilUsername = "mike";

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        //enter email -> lazy way
        driver.findElement(By.id("email")).sendKeys(email);
        //enter password-> lazy way
        driver.findElement(By.id("yourPassword")).sendKeys(password);
        //click login btn -> lazy way
        driver.findElement(By.cssSelector("[type=\"submit\"]")).click();

        //2 ways to get text from web element
        //1. getText() -> it will work %99 , it will return string
        //2. getAttribute("") --> second way of getting text especially

        WebElement profilUsername = driver.findElement(By.cssSelector("[class=\"d-none d-md-block dropdown-toggle ps-2\"]"));

        String actualProfilUsername = profilUsername.getText();
        System.out.println("actualProfilUsername = " + actualProfilUsername);

        if (expectedProfilUsername.equals(actualProfilUsername)) {
            System.out.printf("Pass");
        } else {
            System.out.printf("Fail");
        }

        Thread.sleep(2000);
        driver.close();
    }
}
