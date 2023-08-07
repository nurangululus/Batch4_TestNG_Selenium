package com.kraftechnologie.tests.day10_alerts_multiplewindows_iframe;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Iframe {

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    //first way
    //id value or name value
    @Test
    public void iframe_NameOrId(){
        //we will be able to locate this element since it is in the default HTML
        WebElement upTitle = driver.findElement(By.xpath("//textarea[@id='mce_0']/../h3"));
        System.out.println("upTitle.getText() = " + upTitle.getText());

        //we will not be able to locate this element since it is in another HTML/frame
        /*WebElement targetElement = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
        System.out.println("targetElement.getText() = " + targetElement.getText());*/

        //switch driver to the target html block by using "id value" or "name value"
        driver.switchTo().frame("mce_0_ifr");

        WebElement targetElement = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
        System.out.println("targetElement.getText() = " + targetElement.getText());

        //switch driver to the parent (default) HMTL
        //go back to parent frame
        driver.switchTo().parentFrame();

        WebElement upTitle1 = driver.findElement(By.xpath("//textarea[@id='mce_0']/../h3"));
        System.out.println("upTitle1.getText() = " + upTitle1.getText());
    }

    //second way
    //index number
    //index number is starting with 0
    @Test
    public void iframe_index() throws InterruptedException {
        //switch driver by index number
        driver.switchTo().frame(0);

        WebElement targetElement = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));

        //remove the text
        targetElement.clear();

        Thread.sleep(2000);

        //send a new text and confirm
        targetElement.sendKeys("Batch4 is here");

        Thread.sleep(2000);
    }

    @Test
    public void iframe_webElement() throws InterruptedException {
        WebElement frame = driver.findElement(By.cssSelector("#mce_0_ifr"));
        //switch driver by webelement
        driver.switchTo().frame(frame);

        WebElement targetElement = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));

        //remove the text
        targetElement.clear();

        Thread.sleep(2000);

        //send a new text and confirm
        targetElement.sendKeys("Batch4 is super cool");

        Thread.sleep(2000);
    }
}
