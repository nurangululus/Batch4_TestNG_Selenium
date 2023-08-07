package com.kraftechnologie.tests.day08_typeOfWebElements;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class radioButtonTest {

    @Test
    public void radioBtnIsSelected() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://demo.aspnetawesome.com/");
        // Thread.sleep(2000);
        WebElement vegetablesRadio = driver.findElement(By.xpath("//div[text()='Vegetables']/../input"));
        System.out.println("vegetablesRadio.isSelected() = " + vegetablesRadio.isSelected());

        Assert.assertTrue(vegetablesRadio.isSelected(),"verify that \"vegetables\" radio is selected");
        /**
         * verify that legumes is NOT selected
         * click legumes
         * verify that legumes is selected
         * verify that vegetables is NOT selected
         */

        WebElement legumesRadio = driver.findElement(By.xpath("//div[text()='Legumes']/../input"));
        Assert.assertFalse(legumesRadio.isSelected(),"verify that \"Legumes\" radio is NOT selected");
        //System.out.println("legumesRadio.isSelected() = " + legumesRadio.isSelected());
        WebElement legume = driver.findElement(By.xpath("//div[text()='Legumes']/../div[1]"));
        legume.click();
        Assert.assertTrue(legumesRadio.isSelected(),"verify that \"Legumes\" radio is selected");


        Assert.assertFalse(vegetablesRadio.isSelected());

        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void checkboxIsSelected() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1= driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        WebElement checkbox2= driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

        Assert.assertTrue(checkbox2.isSelected());
        Assert.assertFalse(checkbox1.isSelected());

        Thread.sleep(1000);
        checkbox1.click();
        Thread.sleep(1000);
        checkbox2.click();

        Assert.assertTrue(checkbox1.isSelected());
        Assert.assertFalse(checkbox2.isSelected());

        Thread.sleep(2000);
        driver.close();

    }
}
