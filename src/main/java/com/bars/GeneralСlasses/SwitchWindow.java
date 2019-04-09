package com.bars.GeneralСlasses;

import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SwitchWindow {
    public void forceSwitchToWindow2(String oldWindowName){
        for(String windowsHandls : getWebDriver().getWindowHandles()) {
            if(!windowsHandls.equals(oldWindowName)){
                getWebDriver().switchTo().window(windowsHandls);
            }
        }
    }
    public void switchToWindow2(){
//        Wait().until( ExpectedConditions.numberOfWindowsToBe(2));
        for(String windowsHandls : getWebDriver().getWindowHandles()) {
        getWebDriver().switchTo().window(windowsHandls);
        }
    }
    public void windowMaximize(){
        getWebDriver().manage().window().maximize();
    }
    public void closeWindow(String nameWindow){
        switchTo().window(nameWindow).close();
    }
    public void switchToOldWindow(String oldWindow){
        switchTo().window(oldWindow);
    }
    public void switchToMainFrame(){
        switchTo().frame($("#mainFrame"));
    }
    public void switchToDefaultContent(){
        switchTo().defaultContent();
    }
}
