package com.bars;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

class SwitchWindow {
    void forceSwitchToWindow(String oldWindowName){
        for(String windowsHandls : getWebDriver().getWindowHandles()) {
            if(!windowsHandls.equals(oldWindowName)){
                getWebDriver().switchTo().window(windowsHandls);
            }
        }
    }
    void switchToWindow(){
        for(String windowsHandls : getWebDriver().getWindowHandles()) {
        getWebDriver().switchTo().window(windowsHandls);
        }
    }
    void windowMaximize(){
        getWebDriver().manage().window().maximize();
    }
    void closeWindow(String nameWindow){
        switchTo().window(nameWindow).close();
    }
    void switchToOldWindow(String oldWindow){
        switchTo().window(oldWindow);
    }
    void switchToMainFrame(){
        switchTo().frame($("#mainFrame"));
    }
    void switchToDefaultContent(){
        switchTo().defaultContent();
    }
}
