package com.kraftechnologie.tests.day06_css;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Css_Contains {

    public static void main(String[] args) throws InterruptedException {

        //go to https://www.krafttechexlab.com/login

        //locate the email web element with contains by using css syntax
        //get the text and display

        //locate the password web element with contains by using css syntax
        //get the text and display

        //Sixth Formula
        //[attribute*='value']
        //tagName[attribute*='value']


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.krafttechexlab.com/login");
        Thread.sleep(2000);

        WebElement email = driver.findElement(By.cssSelector("label[for*='mai']"));
        System.out.println(email.getText());

        WebElement password = driver.findElement(By.cssSelector("[for*='rP']"));
        System.out.println(password.getText());

        driver.quit();
    }
}
