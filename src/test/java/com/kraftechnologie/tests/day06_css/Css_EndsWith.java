package com.kraftechnologie.tests.day06_css;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Css_EndsWith {

    public static void main(String[] args) throws InterruptedException {
        //go to https://www.krafttechexlab.com/login

        //locate the rememberMe web element with ends-with by using css syntax
        //get the text and display

        //locate the designedByAfm web element with ends-with by using css syntax
        //get the text and display

        //Fifth Formula
        //[attribute$='lastPartOfValue']
        //tagName[attribute$='lastPartOfValue']

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        Thread.sleep(2000);

        WebElement rememberMe = driver.findElement(By.cssSelector("label[for$='Me']"));
        System.out.println(rememberMe.getText());

        WebElement designedByAfm = driver.findElement(By.cssSelector("[class$='s']"));
        System.out.println(designedByAfm.getText());

        driver.quit();
    }
}
