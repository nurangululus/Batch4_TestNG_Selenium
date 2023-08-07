package com.kraftechnologie.tests.day08_typeOfWebElements;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElement {


    /** What is disabled element ?
     * U can NOT interact with this element
     * U can NOT click
     * or U can NOT write something
     */

    @Test
    public void disabledElementTest1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement disabledElement=driver.findElement(By.cssSelector("#input-example>input"));
        Assert.assertFalse(disabledElement.isEnabled(),"Verify that element is NOT enable or element is disable");

        //if we click the enable button it will be interactive
        WebElement enableBtn=driver.findElement(By.cssSelector("#input-example>button"));
        enableBtn.click();
        Thread.sleep(4000);
        Assert.assertTrue(disabledElement.isEnabled());

        Thread.sleep(2000);
        driver.close();
    }

}
