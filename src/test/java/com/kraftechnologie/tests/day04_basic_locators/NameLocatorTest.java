package com.kraftechnologie.tests.day04_basic_locators;

import com.github.javafaker.Faker;
import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NameLocatorTest {

    public static void main(String[] args) throws InterruptedException {
        Faker faker=new Faker();

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        driver.findElement(By.name("email")).sendKeys(faker.harryPotter().character());
        Thread.sleep(1000);
        driver.findElement(By.name("password")).sendKeys(faker.internet().password());
        Thread.sleep(2000);
        driver.close();

    }
}
