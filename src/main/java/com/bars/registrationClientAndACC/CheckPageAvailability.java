package com.bars.registrationClientAndACC;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CheckPageAvailability {

    public void threePage(String searchEl){

        ArrayList<String> tabs0 = new ArrayList<> ( getWebDriver().getWindowHandles ( ) );
        Wait().until( ExpectedConditions.numberOfWindowsToBe(3));
        switchTo ( ).window ( tabs0.get ( 1 ) );
        System.out.println ( "Win0 " + tabs0 );
        ArrayList<String> tabs = new ArrayList<> (getWebDriver().getWindowHandles());
        System.out.println ( "List_win " + tabs );
        String mainWindows = getWebDriver().getWindowHandle();
        System.out.println ( "Main_win " + mainWindows );
        switchTo().window(tabs.get(2));
        SelenideElement elementID = $x("//*[@id]");
        String id = elementID.getAttribute("id");     // for getting id of each element
        System.out.println ( "First_id " + id );
        if (!id.equals ( searchEl )){
            switchTo().window(tabs.get(1)); // первый таб
            String mainWindows1 = getWebDriver ().getWindowHandle();
            System.out.println ( "First_win " + mainWindows1 );
            SelenideElement elementID1 = $x("//*[@id]");
            String id1 = elementID1.getAttribute("id");     // for getting id of each element
            System.out.println ( "Second_id " +id1 );
            if (!id1.equals ( searchEl )){
                switchTo().window(tabs.get(0)); // первый таб
                String mainWindows2 = getWebDriver ().getWindowHandle();
                System.out.println ( "Second_win " + mainWindows2 );
                SelenideElement elementID2 = $x("//*[@id]");
                String id2 = elementID2.getAttribute("id");     // for getting id of each element
                System.out.println ( "Third_id " +id2 );
                if (!id2.equals ( searchEl )){
                    switchTo().window(tabs.get(2)); // первый таб
                    String mainWindows3 = getWebDriver ().getWindowHandle();
                    System.out.println ( "Third_win " + mainWindows3 );
                    SelenideElement elementID3 = $x("//*[@id]");
                    String id3 = elementID3.getAttribute("id");     // for getting id of each element
                    System.out.println ( "Four_id " +id3 );
                }
            }
        }
        String mainWindows4 = getWebDriver ().getWindowHandle();
        System.out.println ( "Win4 " + mainWindows4 );
    }

    public void twoPage(String searchEl){
        ArrayList<String> tabs0 = new ArrayList<> ( getWebDriver ().getWindowHandles ( ) );
        Wait().until( ExpectedConditions.numberOfWindowsToBe(2));
        switchTo().window(1);
        switchTo ( ).window ( tabs0.get ( 0 ) );
        System.out.println ( "Win0 " + tabs0 );
        ArrayList<String> tabs = new ArrayList<> (getWebDriver ().getWindowHandles());
        System.out.println ( "List_win " + tabs );
        String mainWindows = getWebDriver ().getWindowHandle();
        System.out.println ( "Main_win " + mainWindows );
        switchTo().window(tabs.get(1));
        SelenideElement elementID = $x("//*[@id]");
        String id = elementID.getAttribute("id");     // for getting id of each element
        System.out.println ( "First_id " + id );
        if (!id.equals ( searchEl )){
            switchTo().window(tabs.get(1)); // первый таб
            String mainWindows1 = getWebDriver ().getWindowHandle();
            System.out.println ( "First_win " + mainWindows1 );
            SelenideElement elementID1 = $x("//*[@id]");
            String id1 = elementID1.getAttribute("id");     // for getting id of each element
            System.out.println ( "Second_id " +id1 );
            if (!id1.equals ( searchEl )){
                switchTo().window(tabs.get(0)); // первый таб
                String mainWindows2 = getWebDriver ().getWindowHandle();
                System.out.println ( "Second_win " + mainWindows2 );
                SelenideElement elementID2 = $x("//*[@id]");
                String id2 = elementID2.getAttribute("id");     // for getting id of each element
                System.out.println ( "Third_id " +id2 );
            }
        }
        String mainWindows4 = getWebDriver ().getWindowHandle();
        System.out.println ( "Win4 " + mainWindows4 );
    }
}
