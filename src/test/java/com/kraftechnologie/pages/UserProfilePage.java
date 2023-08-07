package com.kraftechnologie.pages;

import com.kraftechnologie.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfilePage extends BasePage{

    @FindBy(css = "[role='alert']")
    public WebElement updateMessage;

    public void navigateToOverViewMenu(String tab){
        WebElement tabElement= Driver.get().findElement(By.xpath("//li/button[.='"+tab+"']"));
        tabElement.click();
    }
    public String updateMessageGetText(){
        return updateMessage.getText();
    }
}

