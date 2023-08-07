package com.kraftechnologie.tests.day04_basic_locators;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NameDublicateTest {
    public static void main(String[] args) throws InterruptedException{


        /** this class for explaining that
         * When the name locator is duplicated,
         * only the first element is selected
         * but does NOT work
         *
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://demo.aspnetawesome.com/");

        Thread.sleep(3000);
        driver.findElement(By.id("btnCookie")).click();

        Thread.sleep(2000);
        System.out.println("driver.findElement(By.name(\"itemParentCat\")).getText() = " + driver.findElement(By.name("itemParentCat")).getText());
        Thread.sleep(2000);
        driver.close();
    }

}
