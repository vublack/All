package com.bars.registrationClientAndACC;

import com.bars.generalСlasses.SwitchWindowOrFrame;
import com.bars.helperClasses.ReadingFromFile;
import com.bars.helperClasses.WritingToFile;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class CustomerFoAccounts {

    private static SwitchWindowOrFrame switchWindowOrFrame = new SwitchWindowOrFrame();
    private CheckPageAvailability checkPageAvailability = new CheckPageAvailability ();

    public void checkSpecparamTab(){
        //Special parameters
        $("#bTab3").shouldBe(visible).click ();
        switchWindowOrFrame.tabFrameAcc("#Tab3");
        $("#btnSPECPARAM").shouldBe(visible).shouldHave(text("НБУ")).click();
        $(("#btnSPECPARAM_INT")).shouldBe(visible).shouldHave(text("Ощадбанк")).click();
        $(("#btnDPT")).shouldBe(visible).shouldHave(text("Депозити")).click();
        $(("#btnBPK")).shouldBe(visible).shouldHave(text("БПК")).click();
        $(("#btnCVK")).shouldBe(visible).shouldHave(text("ЦВК")).click();
    }

    public void saveOptions() throws IOException {
        switchWindowOrFrame.defaultContent();
        List<SelenideElement> linkElements1 = $$(By.tagName("head"));
        System.out.println ( linkElements1 );
        $("#btSave").shouldBe(visible).click ();
        switchWindowOrFrame.tabFrameAcc("#Tab3");

        //Confirmation window 1
        checkPageAvailability.threePage ("T1" );
        $("#btOk").shouldBe(visible).click ();

        //Confirmation window 2
        checkPageAvailability.threePage ( "T1" );


        if (ReadingFromFile.read ( "Polygon.txt" ).equals( "DB OBMMFOT" )) {
            Runtime.getRuntime().exec( ".\\Cancel.exe" );
            switchTo ().defaultContent();
        }


        $x("//*[@value='Ok']").shouldBe(visible).click ();
        //getWebDriver ().navigate ().refresh ();
        checkPageAvailability.twoPage ( "ctl00" );

        // $("#bTab3").shouldBe(visible).click ();
        String mainWindows = getWebDriver ().getWindowHandle();
        System.out.println ( "Win01 " + mainWindows );
        switchTo ().window ( mainWindows ).close ();
        ArrayList<String> tabs1237 = new ArrayList<> ( getWebDriver ().getWindowHandles ( ) );
        System.out.println ( "tabs1237" + tabs1237 );
        switchTo ( ).window ( tabs1237.get ( 0 ) );
        System.out.println ( "Win7 " + tabs1237 );
        String mainWindows2117 = getWebDriver ().getWindowHandle ( );
        System.out.println ( "21first7 " + mainWindows2117 );
        SelenideElement elementID7 = $x("//*[@id]");
        String id7 = elementID7.getAttribute ( "id" );     // for getting id of each element
        System.out.println ( "id7 " + id7 );
    }

    public void saveOptionsEdit() {
        switchWindowOrFrame.defaultContent();
        List<SelenideElement> linkElements1 = $$(By.tagName("head"));
        System.out.println ( linkElements1 );
        $("#btSave").shouldBe(visible).click ();
        switchWindowOrFrame.tabFrameAcc("#Tab3");

        //Confirmation window 1
        checkPageAvailability.threePage ("T1" );
        $("#btOk").shouldBe(visible).click ();

        //Confirmation window 2
        checkPageAvailability.threePage ( "T1" );
        $x("//*[@value='Ok']").shouldBe(visible).click ();
        checkPageAvailability.twoPage ( "ctl00" );

        // $("#bTab3").shouldBe(visible).click ();
        String mainWindows = getWebDriver ().getWindowHandle();
        switchTo ().window (mainWindows).close ();
        ArrayList<String> tabs1237 = new ArrayList<> ( getWebDriver ().getWindowHandles ( ) );
        switchTo().window(tabs1237.get(0));
    }

    public void createCustAcc(String nbs, String value) {
        $("#btOpen").shouldBe(visible).click ();
        checkPageAvailability.twoPage ( "ctl00" );
        getWebDriver().manage().window().maximize ();
        switchWindowOrFrame.tabFrameAcc("#Tab0");
        $("#tbNbs").shouldBe(visible).setValue(nbs);
        $("#bAccountMask").shouldBe(visible).click ();
        $("#ddOb22").shouldBe(visible).click ();
        String nlsFo = $("#tbNls").shouldBe(visible).getValue();
        WritingToFile.filewriting( "NewAccFo.txt", nlsFo);
        //new Actions(driver).moveByOffset(1, 1).click().build().perform();
        checkPageAvailability.threePage ( "webService" );
        $("#td_21").shouldBe(visible).click();
        checkPageAvailability.twoPage ( "ctl00" );

        //Other
        $("#bTab3").shouldBe(visible).click ();
        switchWindowOrFrame.tabFrameAcc("#Tab3");
// !!!!!! МОЖЕТ появиться обязательный доп параметр , тогда в if разкоментировать
 /*       if (ReadingFromFile.read ( "Polygon.txt" ).equals( "DB OBMMFOT" )){
            $("#btnOTHERS").shouldBe(visible).click ();
            frame.toTabFrameAcc("#Tab3");
            $("#HREF_1").shouldBe(visible).click ();
            String mainWindows10 = getWebDriver ().getWindowHandle(); //запоминаем первое окно
            for(String windowsHandls : getWebDriver ().getWindowHandles()){
                if(!windowsHandls.equals(mainWindows10)){
                    switchTo().window(windowsHandls);
                }
            }
            $("#r_1").shouldBe(visible).click ();
            switchTo().window(mainWindows10);
            frame.toTabFrameAcc ("#Tab0");
            $("#btnSPECPARAM").shouldBe(visible).click ();
        }
*/
        $("#VALUE_5").shouldBe(visible).doubleClick ();
        $("#VALUE").shouldBe(visible).setValue ( value );
        $x("//input[@type='button' and @value='Зберегти']").shouldBe(visible).click ();
        $("#VALUE_4").shouldBe(visible).doubleClick ();
        $("#VALUE").shouldBe(visible).setValue ( value );
        $x("//input[@type='button' and @value='Зберегти']").shouldBe(visible).click ();
        $("#VALUE_3").shouldBe(visible).doubleClick ();
        $("#VALUE").shouldBe(visible).setValue ( value );
        $x("//input[@type='button' and @value='Зберегти']").shouldBe(visible).click ();
        $("#VALUE_2").shouldBe(visible).doubleClick ();
        $("#VALUE").shouldBe(visible).setValue ( value );
        $x("//input[@type='button' and @value='Зберегти']").shouldBe(visible).click ();
    }

    public void editCustFoAcc(String nlsAlt, String nls){
        switchWindowOrFrame.mainFrame();
        $("#tbFindNls").shouldBe(visible).setValue(nls);
        $("#btFind").shouldBe(visible).click ();
        $("#r_1").shouldBe(visible).click ();

        String mainWindows22 = getWebDriver ().getWindowHandle();

        $("#btEdit").shouldBe(visible).click ();
        for(String windowsHandls1234 : getWebDriver ().getWindowHandles()){
            if(!windowsHandls1234.equals(mainWindows22)){
                switchTo().window(windowsHandls1234);
            }
        }

        switchWindowOrFrame.tabFrameAcc("#Tab0");
        getWebDriver().manage().window().maximize();
        $("#tbNlsAlt").shouldBe(visible).setValue ( nlsAlt );
        //Financial details -----------------------------//
        switchWindowOrFrame.defaultContent();
        $("#bTab1").shouldBe(visible).click ();
        switchWindowOrFrame.tabFrameAcc("#Tab1");
        $("#ddVidBlkD").shouldBe(visible).click ();

        String mainWindows3 = getWebDriver().getWindowHandle(); //запоминаем первое окно
        checkPageAvailability.threePage ( "webService" );
        $("#td_29").shouldBe(visible).click ();
        switchTo().window(mainWindows3);
        switchWindowOrFrame.tabFrameAcc("#Tab1");
        $("#ddVidBlkK").shouldBe(visible).click ();
        String mainWindows45 = getWebDriver ().getWindowHandle(); //запоминаем первое окно
        checkPageAvailability.threePage ( "webService" );
        $("#td_29").shouldBe(visible).click ();
        switchTo().window(mainWindows45);
        switchWindowOrFrame.defaultContent();
        //Access rights ---------------------------------//
        $("#bTab2").shouldBe(visible).click ();
        switchWindowOrFrame.tabFrameAcc("#Tab2");
        $("#btAdd").shouldBe(visible).click ();
        String mainWindows5 = getWebDriver().getWindowHandle(); //запоминаем первое окно

        checkPageAvailability.threePage ( "webService" );
        $("#td_29").shouldBe(visible).click ();
        switchTo().window(mainWindows5);
        switchWindowOrFrame.defaultContent();
    }

    public void closeCustFoAcc(String nls){
        switchWindowOrFrame.mainFrame();
        $("#tbFindNls").shouldBe(visible).setValue (nls);
        $("#btFind").shouldBe(visible).click ();
        $("#r_1").shouldBe(visible).click ();
        $("#btClose").shouldBe(visible).click ();
        $("#closureReason5").shouldBe(visible).click ();
        $("#alertify-ok").shouldBe(visible).click ();
        String mainWindows6 = getWebDriver ().getWindowHandle();
        for(String windowsHandls : getWebDriver ().getWindowHandles()){
            if(!windowsHandls.equals(mainWindows6)){
                switchTo().window(windowsHandls);
            }
        }
        checkPageAvailability.twoPage( "T1" );
        //$x("//input[@value = 'Ok']").shouldBe(visible).click ();
        Actions action = new Actions(getWebDriver ());
        action.sendKeys( Keys.ENTER).build().perform();
        switchTo().window(mainWindows6);
    }
}

