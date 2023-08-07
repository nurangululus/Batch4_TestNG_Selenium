package com.kraftechnologie.tests.day02_webdriver_basics;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {

    public static void main(String[] args) throws InterruptedException {

        //TASK
        //go to "https://www.krafttechexlab.com/" with chrome by using getDriver() method
        //verify that the url is "https://www.krafttechexlab.com/"

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/");
        driver.manage().window().maximize();

        Thread.sleep(3000);

        String expectedUrl = "https://www.krafttechexlab.com/";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            System.out.println("PASS");
        } else {
            System.out.println("FALL");
        }
        driver.quit();
    }
}
