package com.kraftechnologie.tests.day06_css;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Css_StartsWith {

    public static void main(String[] args) throws InterruptedException {
        //go to https://www.krafttechexlab.com/login

        //locate the enterYourEmail&Password web element  with start-with by using css syntax
        //get the web element text and display

        //locate the doNotHaveAnAccount web element with start-with by using css syntax
        //get the web element text and display

        //Fourth Formula
        //[attribute^='firstPartOfValue']
        //tagName[attribute^='firstPartOfValue']

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        Thread.sleep(2000);

        WebElement enterYourEmail = driver.findElement(By.cssSelector("p[class^='t']"));
        System.out.println(enterYourEmail.getText());

        Thread.sleep(2000);

        WebElement doNotHaveAccount = driver.findElement(By.cssSelector("[class^='sm']"));
        System.out.println(doNotHaveAccount.getText());

        driver.quit();
    }
}
