package com.bars.generalСlasses;

import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SwitchWindowOrFrame {
    public void forceSwitchToWindow2(String oldWindowName){
        Wait().until( ExpectedConditions.numberOfWindowsToBe(2));
        for(String windowsHandls : getWebDriver().getWindowHandles()) {
            if(!windowsHandls.equals(oldWindowName)){
                getWebDriver().switchTo().window(windowsHandls);
            }
        }
    }
    public void switchToWindow2(){
        Wait().until( ExpectedConditions.numberOfWindowsToBe(2));
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

    public void defaultContent(){
        switchTo().defaultContent();
    }
    public void mainFrame(){
        defaultContent();
        switchTo().frame($("#mainFrame"));
}

    public void tabFrameAcc(String path){
        defaultContent();
        switchTo().frame($(path));
    }

    public void kContentFrame(){
        mainFrame();
        switchTo().frame($(".k-content-frame"));
    }

    public void fullAddressFrame(){
        mainFrame();
        switchTo().frame( $x("//iframe[@title = 'Повна адреса клієнта']" ));
    }
    public void tabFrameClient(String path){
        kContentFrame();
        switchTo().frame(path);
    }


}
