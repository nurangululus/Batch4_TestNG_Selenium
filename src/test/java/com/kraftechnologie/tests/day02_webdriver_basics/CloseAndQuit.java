package com.kraftechnologie.tests.day02_webdriver_basics;

import com.kraftechnologie.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {

    public static void main(String[] args) throws InterruptedException{

        WebDriverManager.chromedriver().setup();

        WebDriver driver =new ChromeDriver();

        driver.navigate().to("https://www.krafttechexlab.com");

        driver.manage().window().maximize();

        Thread.sleep(3000);

        //close the driver with close() method
        //close the current tab
        driver.close();

        WebDriverManager.chromedriver().setup();
        WebDriver driver1 = new ChromeDriver();
        driver1.get("https://www.amazon.com");

        Thread.sleep(3000);

        //close the driver with the quit() method
        //close all the tabs

        driver1.quit();

    }
}
class closeExeptionTest{
    public static void main(String[] args) throws InterruptedException {
        //added in day 4 class
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://www.google.com/");

        Thread.sleep(2000);

        //close current tab
        driver.close();

        //giving new browser tab
        driver=new ChromeDriver(); // if we don't will give -> invalid session ID Exception
        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);
        driver.close();
    }

}
