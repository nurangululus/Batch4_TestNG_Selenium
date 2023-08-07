package com.kraftechnologie.tests.day06_css;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Css_ParentToChild {

    public static void main(String[] args) throws InterruptedException {
        //  xpath
        //  '/' --> parent to child
        //  css
        //  '>' --> parent to child
        //  xpath
        //  '//' --> parent to grandson
        //  css
        //  ' ' --> parent to grandson

        //go to https://www.krafttechexlab.com/login
        //locate the email webElement by using parentToChild with Css syntax

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        Thread.sleep(2000);

        //parent to child
        WebElement email = driver.findElement(By.cssSelector(".col-12:nth-of-type(1)>label"));
        System.out.println(email.getText());

        //locate the login webElement by using parentToGrandSon with Css syntax
        //parent to grandson
        WebElement loginButton = driver.findElement(By.cssSelector(".row.g-3.needs-validation button"));
        System.out.println(loginButton.getText());

        driver.quit();
    }
}
