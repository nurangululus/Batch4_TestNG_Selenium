package com.kraftechnologie.tests.day06_css;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Css_Index {

    public static void main(String[] args) {
        //go to https://www.krafttechexlab.com/login
        //get the email webElement as a whole
        //get the password webElement as a whole
        //get the login webElement as a whole

        //eighth formula
        //cssSyntax:nth-of-type(indexNumber)
        //NOTE: It works only if the webElements are under the same parent

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");

        //get the email as a whole
        WebElement emailAsWhole = driver.findElement(By.cssSelector(".col-12:nth-of-type(1)"));

        //get the password as a whole
        WebElement passwordAsWhole = driver.findElement(By.cssSelector(".col-12:nth-of-type(2)"));

        //get the login as a whole
        WebElement loginAsWhole = driver.findElement(By.cssSelector(".col-12:nth-of-type(4)"));
    }
}
