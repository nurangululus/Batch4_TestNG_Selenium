package com.kraftechnologie.tests.day09_findElements_dropdowns;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/javascript/clicks");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void findElementsWithCorrectFormula() throws InterruptedException {

        /*
         * go to https://www.krafttechexlab.com/javascript/clicks
         * get all buttons into a list
         * click on third button
         */

        //elements list contains 4 different webElement
        //we can get any of these webElement by manipulating 'elements list'
        List<WebElement> elements = driver.findElements(By.cssSelector(".btn.btn-primary"));

        //assert that the size is 4
        System.out.println(elements.size());
        Assert.assertTrue(elements.size() == 4);

        //verify that the text of 4th element is Mouse Down / Up
        String actual = elements.get(3).getText();
        String expected = "Mouse Down / Up";
        Assert.assertEquals(actual,expected);

        //verify that the text of 3rd element is 'Click Me'
        String actual1 = elements.get(2).getText();
        String expected1 = "Click Me";
        Assert.assertEquals(actual1,expected1);
    }

    @Test
    public void findElementsWithoutCorrectFormula() throws InterruptedException {
        /*
         * go to https://www.krafttechexlab.com/javascript/clicks
         * try to locate any web element with findElements() method with a wrong formula
         * see how it behaves
         */

        //it does not throw exception even if it can not locate the webElement in the page since it returns list of webElement
        List<WebElement> wrongFormula = driver.findElements(By.xpath("wrongFormula"));
        System.out.println(wrongFormula.size());

        //verify that size is equal to 0
        //Assert.assertTrue(wrongFormula.size() == 0);
        Assert.assertTrue(wrongFormula.isEmpty());
    }
}
