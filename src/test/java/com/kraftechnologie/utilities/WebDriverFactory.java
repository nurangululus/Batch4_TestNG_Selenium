package com.kraftechnologie.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {

    //write a static method
    //that is named getDriver
    //it takes a string parameter (browserType)
    //it will set up browser
    //it will return a driver based on parameter (chrome, safari, firefox)

    public static WebDriver getDriver(String browserType){
        WebDriver driver = null;
        switch (browserType.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                //driver.manage().window().maximize();
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                //driver.manage().window().maximize();
                break;
        }
        return driver;
    }
}
