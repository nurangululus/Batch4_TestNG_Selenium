package com.kraftechnologie.tests.day04_basic_locators;

import com.github.javafaker.Faker;
import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IdLocatorTest {

    public static void main(String[] args) throws InterruptedException{

        Faker faker=new Faker();

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/text-box");

        WebElement inputUserName = driver.findElement(By.id("userName"));
        //inputUserName.sendKeys("Jake Hyde");
        inputUserName.sendKeys(faker.name().fullName());

        WebElement inputUserEmail = driver.findElement(By.id("userEmail"));
        // inputUserEmail.sendKeys("jake@hyde.com");
        inputUserEmail.sendKeys(faker.internet().emailAddress());

        Thread.sleep(2000);
        driver.close();

    }
}
