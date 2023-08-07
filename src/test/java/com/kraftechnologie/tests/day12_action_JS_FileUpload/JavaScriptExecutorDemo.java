package com.kraftechnologie.tests.day12_action_JS_FileUpload;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorDemo {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void clickWithJS() {
        driver.get("https://www.amazon.com.tr/");

        driver.findElement(By.id("sp-cc-accept")).click();

        WebElement germany = driver.findElement(By.linkText("Almanya"));

        //germany.click();
        //ask google--> how to click with jsexecutor
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", germany);
        driver.findElement(By.id("sp-cc-accept")).click();

    }

    @Test
    public void typeWithJS() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));

        String text="Hello World!";
        //ask google--> how to sendKeys using JSExecutor
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].setAttribute('value', '" + text +"')", inputBox);


    }

    @Test
    public void scrollDownAndUP() throws InterruptedException {
        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.id("sp-cc-accept")).click();

        //ask google to--> how to scroll down in selenium javascript
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        // jse.executeScript("window.scrollBy(0,500)");

        for (int i = 0; i <10 ; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,500)");
        }
        for (int i = 0; i <10 ; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,-500)");
        }
    }

    @Test
    public void scrollToElement() throws InterruptedException {
        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.id("sp-cc-accept")).click();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebElement germany = driver.findElement(By.linkText("Almanya"));
        Thread.sleep(2000);
        //ask google to--> how to scroll into view with js executor
        jse.executeScript("arguments[0].scrollIntoView(true);", germany);
        jse.executeScript("arguments[0].click();", germany);

    }
}
