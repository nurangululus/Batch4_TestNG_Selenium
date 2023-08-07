package com.kraftechnologie.tests.day12_action_JS_FileUpload;

import com.kraftechnologie.utilities.ConfigurationReader;
import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionTest {

    WebDriver driver;
    Actions actions;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        //driver = WebDriverFactory.getDriver("chrome");
        driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser")); // added after day14
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        actions=new Actions(driver);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void hoverOver() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/hovers");

        WebElement img2 = driver.findElement(By.xpath("(//img)[3]"));
        //img2.click();
        //Actions --> class that contains all the user interactions
        //Actions actions=new Actions(driver);
        Thread.sleep(2000);

        //moveToElement()--> move your mouse to the web element ( hover over)
        //perform()--> perform the action, complete the action
        actions.moveToElement(img2).perform();

        WebElement view_profile1 = driver.findElement(By.linkText("View profile"));

        System.out.println("view_profile1.getText() = " + view_profile1.getText());

        Assert.assertTrue(view_profile1.isDisplayed(),"Verify that element is displayed");

        /**  Hover class Task
         *      go to https://the-internet.herokuapp.com/hovers url
         *      and get "view profile" elements' text (all of them)
         *      and verify element is displayed (one by one)
         *
         *      hind: Use list and for loop
         */
    }

    @Test
    public void dragAndDrop() {
        driver.get("https://demoqa.com/droppable");

        WebElement source = driver.findElement(By.id("draggable"));

        WebElement target= driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        //Actions actions=new Actions(driver);

        actions.dragAndDrop(source,target).perform();

        WebElement verifyMessage=driver.findElement(By.xpath("//p[text()='Dropped!']"));
        System.out.println("verifyMessage.getText() = " + verifyMessage.getText());

        Assert.assertTrue(verifyMessage.isDisplayed());

        Assert.assertEquals(verifyMessage.getText(),"Dropped!","Verify that element has dropped");
    }

    @Test
    public void dragAndDrop2() {
        driver.get("https://demoqa.com/droppable");
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target= driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        // Actions actions=new Actions(driver);
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(3000).release().perform();
        WebElement verifyMessage=driver.findElement(By.xpath("//p[text()='Dropped!']"));
        System.out.println("verifyMessage.getText() = " + verifyMessage.getText());

        Assert.assertTrue(verifyMessage.isDisplayed());

        Assert.assertEquals(verifyMessage.getText(),"Dropped!","Verify that element has dropped");

    }
}
