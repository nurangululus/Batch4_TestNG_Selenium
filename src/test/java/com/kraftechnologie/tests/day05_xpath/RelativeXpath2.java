package com.kraftechnologie.tests.day05_xpath;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RelativeXpath2 {

    public static void main(String[] args) throws InterruptedException {

        //go to https://www.krafttechexlab.com/forms/input

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/forms/input");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        //locate the webelement with starts-with(attribute-value)
        WebElement password = driver.findElement(By.xpath("//label[starts-with(@for,'inputP')]"));
        System.out.println(password.getText());

        //locate the webElement with starts-with(text)
        WebElement password1 = driver.findElement(By.xpath("//label[starts-with(text(),'P')]"));
        System.out.println(password1.getText());

        driver.quit();

    }
}
