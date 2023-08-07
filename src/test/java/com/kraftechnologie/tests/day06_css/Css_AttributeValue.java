package com.kraftechnologie.tests.day06_css;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Css_AttributeValue {

    public static void main(String[] args) throws InterruptedException {
        //go to https://www.krafttechexlab.com/login
        //locate the email box with attribute-value by using css syntax
        //locate the password box with attribute-value by using css syntax

        //Third Formula
        //[attribute='value']
        //tagName[attribute='value']

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        Thread.sleep(2000);

        WebElement emailBox= driver.findElement(By.cssSelector("input[name='email']"));
        emailBox.sendKeys("test@test.com");

        Thread.sleep(2000);

        WebElement password = driver.findElement(By.cssSelector("[type='password']"));
        password.sendKeys("12345678");

        Thread.sleep(2000);
        driver.quit();
    }
}
