package com.kraftechnologie.tests.day05_xpath;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbsoluteXpath {
    public static void main(String[] args) throws InterruptedException {

        /*
         * go to https://www.krafttechexlab.com/
         * get the 'Home' webElement by absolute xpath
         * get the 'Dashboard' webElement by absolute xpath
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/");

        Thread.sleep(2000);

        WebElement homeButton = driver.findElement(By.xpath("html/body/main/div/nav/ol/li/a"));
        System.out.println(homeButton.getText());

        WebElement dashboardButton = driver.findElement(By.xpath("html/body/main/div/nav/ol/li[2]"));
        System.out.println(dashboardButton.getText());

        driver.quit();
    }
}
