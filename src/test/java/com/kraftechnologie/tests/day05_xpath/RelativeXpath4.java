package com.kraftechnologie.tests.day05_xpath;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RelativeXpath4 {

    public static void main(String[] args) throws InterruptedException {
        //AND LOGIC
        //go to "https://www.krafttechexlab.com/components/modal"
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/components/modal");
        Thread.sleep(3000);

        //get the webElement by using AND logic with Xpath
        WebElement basicModal = driver.findElement(By.xpath("//button[@type='button'][@data-bs-target='#basicModal']"));
        System.out.println(basicModal.getText());
        //get the webElement by using AND logic with Xpath
        WebElement basicModal1 = driver.findElement(By.xpath("//button[@type='button' and @data-bs-target='#basicModal']"));
        System.out.println(basicModal1.getText());


        //OR LOGIC
        //go to https://www.krafttechexlab.com/components/tabs
        driver.get("https://www.krafttechexlab.com/components/tabs");
        Thread.sleep(3000);
        //get the webElement by using OR logic with Xpath
        WebElement messagesElement = driver.findElement(By.xpath("//button[@data-bs-target='#v-pills-messages' or @id='v-pills-messages-tab']"));
        System.out.println(messagesElement.getText());

        driver.quit();
    }
}
