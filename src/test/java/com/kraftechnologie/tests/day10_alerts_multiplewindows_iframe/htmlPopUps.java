package com.kraftechnologie.tests.day10_alerts_multiplewindows_iframe;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class htmlPopUps {

    @Test
    public void htmlPopUpTest() throws InterruptedException {
        //go to http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=73437
        //tap on confirm button
        //tap on yes
        //make verification
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=73437");
        Thread.sleep(2000);
        driver.manage().window().maximize();

        WebElement confirmButton = driver.findElement(By.xpath("(//span[text()='Confirm'])[1]"));
        confirmButton.click();

        Thread.sleep(2000);

        WebElement yesButton = driver.findElement(By.xpath("//span[.='Yes']"));
        yesButton.click();

        Thread.sleep(2000);

        WebElement confirmationPopUp = driver.findElement(By.xpath("//p[.='You have accepted']"));

        //make verification
        String actual = confirmationPopUp.getText();
        String expected = "You have accepted";
        Assert.assertEquals(actual,expected);

        driver.quit();
    }
}
