package com.kraftechnologie.tests.day14_properties_singleton;

import com.kraftechnologie.tests.TestBase;
import com.kraftechnologie.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class logintest extends TestBase {

    @Test
    public void positiveLoginTest() throws InterruptedException {
        driver.get(ConfigurationReader.get("url"));
        driver.findElement(By.id("email")).sendKeys(ConfigurationReader.get("userEmail"));
        driver.findElement(By.id("yourPassword")).sendKeys(ConfigurationReader.get("userPassword"));
        driver.findElement(By.xpath("//*[.='Login']")).click();
        Thread.sleep(3000);
    }

    @Test
    public void anotherLoginTest() {
        driver.get(ConfigurationReader.get("url"));
        WebElement userEmailInput=driver.findElement(By.id("email"));
        WebElement userPassword=driver.findElement(By.id("yourPassword"));
        userEmailInput.sendKeys(ConfigurationReader.get("userEmail"));
        userPassword.sendKeys(ConfigurationReader.get("userPassword")+ Keys.ENTER);
        // userPassword.sendKeys(ConfigurationReader.get("userPassword")+ Keys.TAB+Keys.TAB+Keys.TAB+Keys.ENTER);
    }


}
