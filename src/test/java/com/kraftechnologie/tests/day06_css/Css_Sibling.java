package com.kraftechnologie.tests.day06_css;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Css_Sibling {

    public static void main(String[] args) throws InterruptedException {
        //go to https://www.krafttechexlab.com/login
        //locate the email box webElement by using sibling with Css syntax

        //formula
        //cssSyntax~tagName

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        Thread.sleep(2000);

        WebElement emailBox = driver.findElement(By.cssSelector("label[for='email']~input"));
        emailBox.sendKeys("test@test.com");

        Thread.sleep(2000);

        driver.quit();
    }
}
